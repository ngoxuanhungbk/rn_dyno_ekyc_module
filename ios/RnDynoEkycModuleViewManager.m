#import "React/RCTViewManager.h"

@interface RCT_EXTERN_MODULE(RnDynoEkycModuleViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(color, NSString)
RCT_EXPORT_VIEW_PROPERTY(normal, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceUp, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceDown, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceLeft, NSString)
RCT_EXPORT_VIEW_PROPERTY(faceRight, NSString)
RCT_EXPORT_VIEW_PROPERTY(blink, NSString)
RCT_EXPORT_VIEW_PROPERTY(onSuccess, RCTDirectEventBlock)


@end
