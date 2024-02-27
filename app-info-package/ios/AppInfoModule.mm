#import "AppInfoModule.h"
#import "AppInfoPackage-Swift.h"

#if RCT_NEW_ARCH_ENABLED

#import "AppInfoPackage.h"

@interface AppInfoModule () <NativeAppInfoModuleSpec>

@end

#endif

@implementation AppInfoModule
{
    AppInfoModuleImpl *moduleImpl;
}

- (instancetype)init
{
    self = [super init];
    
    if (self) {
        moduleImpl = [AppInfoModuleImpl new];
    }
    
    return self;
}

+ (bool)requiresMainQueueSetup
{
    return false;
}

RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(NSString *, getAppBuildNumber)
{
    return [moduleImpl getAppBuildNumber];
}

RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(NSString *, getAppBundleId)
{
    return [moduleImpl getAppBundleId];
}

RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(NSString *, getAppVersion)
{
    return [moduleImpl getAppVersion];
}

RCT_EXPORT_MODULE(AppInfoModule)

#if RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params {
    return std::make_shared<facebook::react::NativeAppInfoModuleSpecJSI>(params);
}
#endif

@end

