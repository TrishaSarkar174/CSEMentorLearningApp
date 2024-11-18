package com.hfad.csementorlearningapp.ui.code;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.hfad.csementorlearningapp.R;
import com.hfad.csementorlearningapp.ui.code.Chapter;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {

    private final ArrayList<Chapter> chapterList;
    private final OnChapterClickListener listener;

    public ChapterAdapter(ArrayList<Chapter> chapterList, OnChapterClickListener listener) {
        this.chapterList = chapterList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chapter chapter = chapterList.get(position);
        holder.chapterName.setText(chapter.getName());
        Glide.with(holder.itemView.getContext()).load(chapter.getImageUrl()).into(holder.chapterImage);

        holder.itemView.setOnClickListener(v -> listener.onChapterClick(chapter));
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public interface OnChapterClickListener {
        void onChapterClick(Chapter chapter);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView chapterName;
        ImageView chapterImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chapterName = itemView.findViewById(R.id.chapterName);
            chapterImage = itemView.findViewById(R.id.chapterImage);
        }
    }
}
