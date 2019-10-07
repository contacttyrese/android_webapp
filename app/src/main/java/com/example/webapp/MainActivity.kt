package com.example.webapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById<WebView>(R.id.myWebView)
        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swiperefresh)

        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.freshegokid.com")
        webView.webViewClient = WebViewClient()

        swipeRefreshLayout.setOnRefreshListener {
            webView.reload()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onBackPressed() {
        webView = findViewById<WebView>(R.id.myWebView)

        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
