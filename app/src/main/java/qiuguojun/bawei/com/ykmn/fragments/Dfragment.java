package qiuguojun.bawei.com.ykmn.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import qiuguojun.bawei.com.ykmn.R;

public class Dfragment extends Fragment {
    private WebView webview;
    private String Url = "https://abnerming8.github.io/abnerming.html";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.dfragment, container, false);
        initView(inflate);
        return inflate;
    }

    @SuppressLint("JavascriptInterface")
    private void initView(View inflate) {
        webview = (WebView) inflate.findViewById(R.id.webview);
        webview.loadUrl(Url);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        webview.addJavascriptInterface(new TextTwo(),"android");
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
    }
   class TextTwo{
        @JavascriptInterface
        public void show(){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    webview.loadUrl("javascript:toast()");
                }
            });
        }
   }
}
