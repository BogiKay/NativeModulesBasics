package com.appinfopackage

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class AppInfoTurboPackage : TurboReactPackage {
  override fun getModule(name: String, context: ReactApplicationContext): NativeModule? {
    return null
  }

  override fun getReactInfoModuleProvider(): ReactModuleInfoProvider {
    val moduleList: Array<Class<out NativeModule?>> = arrayOf()
    val reactModuleInfoMap: MutableMap<String, ReactModuleInfo> = HashMap()

    for (moduleClass in moduleList) {
      val reactModule = moduleClass.getAnnotation(ReactModule::class.java) ?: continue
      reactModuleInfoMap[reactModule.name] =
          ReactModuleInfo(
              reactModule.name,
              moduleClass.name,
              true,
              reactModule.needsEagerInit,
              reactModule.hasConstants,
              reactModule.isCxxModule,
              TurboModule::class.java.isAssignableFrom(moduleClass)
          )
    }

    return ReactModuleInfoProvider { reactModuleInfoMap }
  }
}
