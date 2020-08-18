/*
 * Copyright (c) 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.mikepenz.iconics.typeface.library.community.material.CommunityMaterial
import com.mikepenz.iconics.typeface.library.devicon.DevIcon
import com.mikepenz.iconics.typeface.library.entypo.Entypo
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.typeface.library.foundationicons.FoundationIcons
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.typeface.library.ionicons.Ionicons
import com.mikepenz.iconics.typeface.library.materialdesigniconic.MaterialDesignIconic
import com.mikepenz.iconics.typeface.library.meteoconcs.Meteoconcs
import com.mikepenz.iconics.typeface.library.octicons.Octicons
import com.mikepenz.iconics.typeface.library.pixeden7stroke.Pixeden7Stroke
import com.mikepenz.iconics.typeface.library.typeicons.Typeicons
import com.mikepenz.iconics.typeface.library.weathericons.WeatherIcons
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import ru.ztrap.iconics.IconicsStringGenerator

/**
 * @author pa.gulko zTrap (29.10.2017)
 */
@Ignore
@RunWith(JUnit4::class)
class StringFieldsGenerator : IconicsStringGenerator() {

    @Test fun generateCommunityMaterial() {
        generateIconsFrom(CommunityMaterial)
    }

    @Test fun generateDevIcon() {
        generateIconsFrom(DevIcon)
    }

    @Test fun generateEntypo() {
        generateIconsFrom(Entypo)
    }

    @Test fun generateFontAwesome() {
        generateIconsFrom(FontAwesome)
    }

    @Test fun generateFoundationIcons() {
        generateIconsFrom(FoundationIcons)
    }

    @Test fun generateGoogleMaterial() {
        generateIconsFrom(GoogleMaterial)
    }

    @Test fun generateIonicons() {
        generateIconsFrom(Ionicons)
    }

    @Test fun generateMaterialDesignIconic() {
        generateIconsFrom(MaterialDesignIconic)
    }

    @Test fun generateMeteoconcs() {
        generateIconsFrom(Meteoconcs)
    }

    @Test fun generateOcticons() {
        generateIconsFrom(Octicons)
    }

    @Test fun generatePixeden7Stroke() {
        generateIconsFrom(Pixeden7Stroke)
    }

    @Test fun generateTypeicons() {
        generateIconsFrom(Typeicons)
    }

    @Test fun generateWeatherIcons() {
        generateIconsFrom(WeatherIcons)
    }

    override val fileCreationStrategy: IconicsStringGenerator.FileCreationStrategy
        get() = IconicsStringGenerator.FileCreationStrategy.SAVE_ONLY_CURRENT

    override val modifierCurrent: String get() = ""
}
