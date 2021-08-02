package com.example.e_collabclasroom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewCollab extends AppCompatActivity {
    public static WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_collab);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Waiting For Open");
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();

        if(b!=null)
        {
            String j =(String) b.get("link");
            myWebView = (WebView) findViewById(R.id.webView);
            myWebView.setWebChromeClient(new  WebChromeClient(){
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    super.onProgressChanged(view, newProgress);
                    progressDialog.setTitle("Opening");
                    progressDialog.setProgress(0);
                    progressDialog.setProgress(newProgress*1000);
                    progressDialog.incrementProgressBy(newProgress);
                    if (newProgress == 100 && progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }
                }
            });
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.loadUrl(j);
        }


    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }


}
