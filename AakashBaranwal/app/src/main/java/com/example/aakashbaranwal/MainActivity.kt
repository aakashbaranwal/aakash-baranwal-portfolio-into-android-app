package com.example.aakashbaranwal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    var mViewWeb: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewWeb = findViewById<View>(R.id.webView) as WebView

        mViewWeb!!.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

        }


        val webSettings = mViewWeb!!.getSettings()
        webSettings.setJavaScriptEnabled(true)
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        webSettings.setAppCacheEnabled(true)
        webSettings.setDomStorageEnabled(true)
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS)
        webSettings.setUseWideViewPort(true)
        webSettings.setSavePassword(true)
        webSettings.setSaveFormData(true)
        webSettings.setEnableSmoothTransition(true)
        mViewWeb!!.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)

        mViewWeb!!.loadUrl("https://aakashbaranwal.github.io/")
    }

    override fun onBackPressed() {
        if (mViewWeb!!.canGoBack()) {
            mViewWeb!!.goBack()
        }

        else {
            super.onBackPressed()
        }
    }

}
