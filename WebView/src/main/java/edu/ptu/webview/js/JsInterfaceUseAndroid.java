package edu.ptu.webview.js;

import android.webkit.JavascriptInterface;

/**
 * Created by WangAnshu on 2016/3/25.
 */
@JsObjectName(name = "android")
public class JsInterfaceUseAndroid {
    @JavascriptInterface
    public void clickOnAndroid(){
        // TODO: 2016/3/24 js调用android代码
    }

    public static void main(String[] args) {
        String name = ((JsObjectName) JsInterfaceUseAndroid.class.getAnnotations()[0]).name();
        System.out.println("===>"+name);
    }
}
