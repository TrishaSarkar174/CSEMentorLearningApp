package com.hfad.csementorlearningapp.ui.code;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.hfad.csementorlearningapp.R;

public class ChapterActivity extends AppCompatActivity {

    private WebView videoWebView; // Declare the WebView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        // Get chapter name and video URL from the Intent
        String chapterName = getIntent().getStringExtra("chapterName");
        String videoUrl = getIntent().getStringExtra("videoUrl"); // Receive the video URL passed from CodeFragment
        setTitle(chapterName); // Set the chapter name as the title

        videoWebView = findViewById(R.id.videoWebView); // Initialize WebView

        // Enable JavaScript for YouTube embedded videos
        WebSettings webSettings = videoWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a WebViewClient to prevent opening URLs in external browser
        videoWebView.setWebViewClient(new WebViewClient());

        // Load the embedded video URL in the WebView
        videoWebView.loadUrl(videoUrl);
    }

    @Override
    public void onBackPressed() {
        // Ensure WebView can navigate back
        if (videoWebView.canGoBack()) {
            videoWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
