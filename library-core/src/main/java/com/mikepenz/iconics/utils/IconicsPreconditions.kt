package com.mikepenz.iconics.utils

/**
 * @author pa.gulko zTrap (19.03.2019)
 */
internal object IconicsPreconditions {

    @JvmStatic fun checkMappingPrefix(s: String) {
        if (s.length == 3) return
        throw IllegalArgumentException("The mapping prefix of a font must be 3 characters long.")
    }
}