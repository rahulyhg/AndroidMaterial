package edu.ptu.webview.js;

import android.webkit.JavascriptInterface;

/**
 * Created by WangAnshu on 2016/3/25.
 */
@JsObjectName(name = "android")
public class JsInterfaceUseAndroid {
    @JavascriptInterface
    public void clickOnAndroid(){
        // TODO: 2016/3/24 js调用android代码,可能会出现不同网页调用这个方法，且处理的逻辑不一样。这个方法将会变复杂
    }
}
