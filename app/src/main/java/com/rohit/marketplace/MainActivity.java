// package com.rohit.marketplace;

// import android.os.Bundle;
// import android.webkit.WebView;
// import android.webkit.WebViewClient;
// import androidx.appcompat.app.AppCompatActivity;

// public class MainActivity extends AppCompatActivity {
//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         WebView webView = new WebView(this);
//         webView.getSettings().setJavaScriptEnabled(true);
//         webView.setWebViewClient(new WebViewClient());
//         webView.loadUrl("https://ecommerce-app-7.vercel.app");
//         setContentView(webView);
//     }
// }

package com.rohit.marketplace;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  // 🚫 avoid cache-related issues

        webView.clearCache(true);  // 🧹 clear previous cache
        webView.clearHistory();

        // 🌐 Keep navigation inside the WebView & handle errors
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false; // Let WebView handle the URL
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                view.loadData(
                    "<html><body><h2>Page failed to load</h2><p>" + description + "</p></body></html>",
                    "text/html",
                    "UTF-8"
                );
            }
        });

        webView.loadUrl("https://ecommerce-app-7.vercel.app"); // ✅ our site
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
