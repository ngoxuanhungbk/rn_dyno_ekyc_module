package com.rndynoekycmodule

import android.graphics.Color
import android.view.View
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.mv.engine.EKYCComponentView

class RnDynoEkycModuleViewManager : SimpleViewManager<View>() {
  override fun getName() = "RnDynoEkycModuleView"

  override fun createViewInstance(reactContext: ThemedReactContext): View {
    return EKYCComponentView(reactContext.currentActivity?:reactContext)
  }

  @ReactProp(name = "color")
  fun setColor(view: View, color: String) {
    view.setBackgroundColor(Color.parseColor(color))
  }
}
