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
        webSettings.setJavaScriptEnabled(true);     // ✅ Essential for JS-based sites
        webSettings.setDomStorageEnabled(true);     // ✅ Needed for localStorage
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // ✅ Default caching

        webView.setWebViewClient(new WebViewClient()); // ✅ Keeps navigation inside app
        webView.loadUrl("https://ecommerce-app-7.vercel.app");
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
