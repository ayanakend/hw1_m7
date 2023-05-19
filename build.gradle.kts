// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugin.AGP.application) version Version.AGP apply false
    id(Plugin.AGP.library) version Version.AGP apply false
    id(Plugin.Kotlin.android) version Version.kotlin apply false
    id(Plugin.DaggerHilt.hilt) version Version.hilt apply false
}