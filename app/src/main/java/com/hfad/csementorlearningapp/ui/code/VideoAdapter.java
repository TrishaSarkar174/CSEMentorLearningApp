package com.hfad.csementorlearningapp.ui.code;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.csementorlearningapp.R;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private final String[] videoUrls;

    public VideoAdapter(String[] videoUrls) {
        this.videoUrls = videoUrls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String videoUrl = videoUrls[position];
        String html = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"" +
                videoUrl + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        holder.videoWebView.loadData(html, "text/html", "utf-8");
    }

    @Override
    public int getItemCount() {
        return videoUrls.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        WebView videoWebView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoWebView = itemView.findViewById(R.id.videoWebView);
            videoWebView.getSettings().setJavaScriptEnabled(true);
            videoWebView.setWebViewClient(new WebViewClient());
        }
    }
}
