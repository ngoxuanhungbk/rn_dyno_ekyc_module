package com.rndynoekycmodule

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.facebook.react.bridge.Arguments
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.mv.engine.EKYCComponentView
import com.mv.engine.OnReceiverResult

class RnDynoEkycModuleViewManager : SimpleViewManager<View>() {

  override fun getName() = "RnDynoEkycModuleView"

  override fun createViewInstance(reactContext: ThemedReactContext): View {
    System.loadLibrary("engine")
    return MyCustomView(reactContext)
  }

  @ReactProp(name = "normal")
  fun setNormalString(view:View,normal:String){
    if(view is MyCustomView){
      (view as MyCustomView).updateNormalString(normal)
    }
  }

  @ReactProp(name = "faceUp")
  fun setFaceUpString(view:View,faceUp:String){
    if(view is MyCustomView){
      (view as MyCustomView).updateFaceUpString(faceUp)
    }
  }

  @ReactProp(name = "faceDown")
  fun setFaceDownString(view:View,faceDown:String){
    if(view is MyCustomView){
      (view as MyCustomView).updateFaceDownString(faceDown)
    }
  }

  @ReactProp(name = "faceLeft")
  fun setFaceLeftString(view:View,faceLeft:String){
    if(view is MyCustomView){
      (view as MyCustomView).updateFaceLeftString(faceLeft)
    }
  }

  @ReactProp(name = "faceRight")
  fun setFaceRightString(view:View,faceRight:String){
    if(view is MyCustomView){
      (view as MyCustomView).updateFaceRightString(faceRight)
    }
  }

  @ReactProp(name = "blink")
  fun setFaceBlinkString(view:View,blink:String){
    if(view is MyCustomView){
      (view as MyCustomView).updateBlinkString(blink)
    }
  }

  override fun getExportedCustomBubblingEventTypeConstants(): MutableMap<String, Any>? {
    return MapBuilder.builder<String, Any>().put("onSuccess",
      MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSuccess"))).build()
  }
}

class MyCustomView(val reactContext: ThemedReactContext) : FrameLayout(reactContext), OnReceiverResult {

   private val ekycComponentView: EKYCComponentView

  init {
    ekycComponentView = EKYCComponentView(reactContext.currentActivity
      ?: reactContext, onReceiverResult = this)
    this.addView(ekycComponentView,
      LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
  }

  fun updateNormalString(normal: String){
    ekycComponentView.normalString = normal
  }
  fun updateFaceUpString(faceUp: String){
    ekycComponentView.faceUpString = faceUp
  }
  fun updateFaceDownString(faceDown: String){
    ekycComponentView.faceDownString = faceDown
  }
  fun updateFaceLeftString(faceLeft: String){
    ekycComponentView.faceLeftString = faceLeft
  }
  fun updateFaceRightString(faceRight: String){
    ekycComponentView.faceRightString = faceRight
  }
  fun updateBlinkString(blink: String){
    ekycComponentView.blinkString = blink
  }

  override fun onReceiverResult(isSuccess: Boolean, filePath: String) {
    val event = Arguments.createMap()
    event.putBoolean("isSuccess", isSuccess)
    event.putString("filePath", filePath)

    Log.e("setFaceUpString",ekycComponentView.faceUpString)
    reactContext.getJSModule(RCTEventEmitter::class.java)
      .receiveEvent(id, "onSuccess", event)
  }
}
