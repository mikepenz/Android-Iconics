package com.mikepenz.iconics.typeface.utils

import androidx.annotation.RestrictTo

/**
 * @author pa.gulko zTrap (19.03.2019)
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP_PREFIX)
object IconicsPreconditions {

    @JvmStatic fun checkMappingPrefix(s: String) {
        if (s.length == 3) return
        throw IllegalArgumentException("The mapping prefix of a font must be 3 characters long.")
    }
}