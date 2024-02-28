package com.appinfopackage

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = AppInfoModule.NAME)
class AppInfoModule(
        reactContext: ReactApplicationContext
): NativeAppInfoModuleSpec(reactContext) {
    private val moduleImpl = AppInfoModuleImpl(reactContext)

    override fun getName() = NAME

    override fun getAppBuildNumber(): String {
        return moduleImpl.getAppBuildNumber()
    }

    override fun getAppBundleId(): String {
        return moduleImpl.getAppBundleId()
    }

    override fun getAppVersion(): String {
        return moduleImpl.getAppVersion()
    }

    companion object {
        const val NAME = AppInfoModuleImpl.NAME
    }
}