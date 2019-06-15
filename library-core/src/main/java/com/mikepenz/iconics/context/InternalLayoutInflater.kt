/*
 * Copyright 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.context

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.xmlpull.v1.XmlPullParser
import java.lang.reflect.Field

/**
 * Base created by Christopher Jenkins
 * https://github.com/chrisjenx/Calligraphy
 */
internal class InternalLayoutInflater : LayoutInflater {
    // Reflection Hax
    private var isSetPrivateFactory = false
    private var constructorArgs: Field? = null

    protected constructor(context: Context) : super(context) {
        setUpLayoutFactories(false)
    }

    constructor(
        original: LayoutInflater,
        newContext: Context,
        cloned: Boolean
    ) : super(original, newContext) {
        setUpLayoutFactories(cloned)
    }

    override fun cloneInContext(newContext: Context): LayoutInflater {
        return InternalLayoutInflater(this, newContext, true)
    }

    @Throws(ClassNotFoundException::class)
    override fun onCreateView(name: String, attrs: AttributeSet): View? {
        var view: View? = null

        classPrefixList.forEach { runCatching { view = createView(name, it, attrs) } }
        // In this case we want to let the base class take a crack at it.
        if (view == null) {
            view = super.onCreateView(name, attrs)
        }

        return view?.let { IconicsFactory.onViewCreated(it, it.context, attrs) }
    }

    @Throws(ClassNotFoundException::class)
    override fun onCreateView(parent: View?, name: String, attrs: AttributeSet): View? {
        val view = super.onCreateView(parent, name, attrs)
        return IconicsFactory.onViewCreated(view, context, attrs)
    }

    // ===
    // Wrapping goodies
    // ===

    override fun inflate(parser: XmlPullParser, root: ViewGroup?, attachToRoot: Boolean): View {
        setPrivateFactoryInternal()
        return super.inflate(parser, root, attachToRoot)
    }

    /**
     * We don't want to unnecessary create/set our factories if there are none there. We try to be
     * as lazy as possible.
     */
    private fun setUpLayoutFactories(cloned: Boolean) {
        if (cloned) {
            return
        }
        if (factory2 != null && factory2 !is InternalLayoutInflater.WrapperFactory2) {
            // Sets both Factory/Factory2
            factory2 = factory2
        }
    }

    override fun setFactory(factory: LayoutInflater.Factory) {
        // Only set our factory and wrap calls to the Factory trying to be set!
        if (factory !is InternalLayoutInflater.WrapperFactory) {
            super.setFactory(InternalLayoutInflater.WrapperFactory(factory))
        } else {
            super.setFactory(factory)
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun setFactory2(factory2: LayoutInflater.Factory2) {
        // Only set our factory and wrap calls to the Factory2 trying to be set!
        if (factory2 !is InternalLayoutInflater.WrapperFactory2) {
            super.setFactory2(InternalLayoutInflater.WrapperFactory2(factory2))
        } else {
            super.setFactory2(factory2)
        }
    }

    private fun setPrivateFactoryInternal() {
        // Already tried to set the factory.
        if (isSetPrivateFactory) {
            return
        }

        // Skip if not attached to an activity.
        if (context !is LayoutInflater.Factory2) {
            isSetPrivateFactory = true
            return
        }

        val setPrivateFactoryMethod = ReflectionUtils.getMethod(
            LayoutInflater::class.java,
            "setPrivateFactory"
        )

        if (setPrivateFactoryMethod != null) {
            ReflectionUtils.invokeMethod(
                this,
                setPrivateFactoryMethod,
                PrivateWrapperFactory2(
                    context as LayoutInflater.Factory2,
                    this
                )
            )
        }
        isSetPrivateFactory = true
    }

    private fun createCustomViewInternal(
        view: View?,
        name: String,
        viewContext: Context,
        attrs: AttributeSet
    ): View? {
        var createdView = view
        if (createdView == null && name.contains('.')) {
            if (constructorArgs == null) {
                constructorArgs = ReflectionUtils.getField(
                    LayoutInflater::class.java,
                    "mConstructorArgs"
                )
            }
            val constructorArgs = this.constructorArgs ?: return null

            @Suppress("UNCHECKED_CAST")
            val constArgs = ReflectionUtils.getValue(constructorArgs, this) as Array<Any>
            val lastContext = constArgs[0]
            // The LayoutInflater actually finds out the correct context to use. We just need to set
            // it on the mConstructor for the internal method.
            // Set the constructor ars up for the createView, not sure why we can't pass these in.
            constArgs[0] = viewContext
            ReflectionUtils.setValue(constructorArgs, this, constArgs)

            runCatching { createdView = createView(name, null, attrs) }
            constArgs[0] = lastContext
            ReflectionUtils.setValue(constructorArgs, this, constArgs)
        }
        return createdView
    }

    // ===
    // Wrapper Factories for Pre/Post HC
    // ===

    /** Factory 1 is the first port of call for LayoutInflation */
    private class WrapperFactory(
        private val factory: LayoutInflater.Factory
    ) : LayoutInflater.Factory {

        override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
            val view = factory.onCreateView(name, context, attrs)
            return IconicsFactory.onViewCreated(view, context, attrs)
        }
    }

    /** Factory 2 is the second port of call for LayoutInflation */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private open class WrapperFactory2(
        protected val factory2: LayoutInflater.Factory2
    ) : LayoutInflater.Factory2 {

        override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
            val view = factory2.onCreateView(name, context, attrs)
            return IconicsFactory.onViewCreated(view, context, attrs)
        }

        override fun onCreateView(
            parent: View?,
            name: String,
            context: Context,
            attrs: AttributeSet
        ): View? {
            val view = factory2.onCreateView(parent, name, context, attrs)
            return IconicsFactory.onViewCreated(view, context, attrs)
        }
    }

    /**
     * Private factory is step three for Activity Inflation, this is what is attached to the
     * Activity on HC+ devices.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private class PrivateWrapperFactory2(
        factory2: LayoutInflater.Factory2,
        private val inflater: InternalLayoutInflater
    ) : InternalLayoutInflater.WrapperFactory2(factory2) {

        override fun onCreateView(
            parent: View?,
            name: String,
            context: Context,
            attrs: AttributeSet
        ): View? {
            val view = factory2.onCreateView(parent, name, context, attrs)
            val customView = inflater.createCustomViewInternal(view, name, context, attrs)
            return IconicsFactory.onViewCreated(customView, context, attrs)
        }
    }

    companion object {
        private val classPrefixList = arrayOf("android.widget.", "android.webkit.")
    }
}