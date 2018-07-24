package com.moneytap.feature;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.moneytap.wikipediasearch.R;

/**
 * Class to display web pages in app.
 */
public class WikiWebView extends AppCompatActivity {
  @BindView(R.id.webview) WebView webView;
  public static final String URL_KEY = "urlKey";

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wiki_webview);
    ButterKnife.bind(this);
    String url = getIntent().getStringExtra(URL_KEY);
    webView.setWebViewClient(new WebViewClient());
    if(url != null) {
      webView.loadUrl(url);
    }
  }
}
