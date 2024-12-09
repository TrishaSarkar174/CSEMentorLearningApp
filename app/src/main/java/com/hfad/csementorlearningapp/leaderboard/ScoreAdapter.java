package com.hfad.csementorlearningapp.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hfad.csementorlearningapp.R;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    private final Context context;
    private final List<ScoreData> list;

    public ScoreAdapter(Context context, List<ScoreData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for leaderboard entries
        View view = LayoutInflater.from(context).inflate(R.layout.item_leaderboard, parent, false);
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        // Get current data
        ScoreData data = list.get(position);

        // Set rank text
        holder.rank.setText(String.valueOf(position + 1));

        // Assign rank badges and colors
        int rankColor;
        int rankIcon = R.drawable.default_rank; // Default rank icon
        switch (position) {
            case 0:
                rankColor = R.color.gold;
                rankIcon = R.drawable.gold_medal;
                break;
            case 1:
                rankColor = R.color.silver;
                rankIcon = R.drawable.silver_medal;
                break;
            case 2:
                rankColor = R.color.bronze;
                rankIcon = R.drawable.bronze_medal;
                break;
            default:
                rankColor = R.color.default_rank_color; // Fallback color for other ranks
                break;
        }
        holder.rank.setBackgroundTintList(ContextCompat.getColorStateList(context, rankColor));
        holder.rankIcon.setImageResource(rankIcon);

        // Load profile image from the image URL using Glide
        if (data.getImage() != null && !data.getImage().isEmpty()) {
            Glide.with(context)
                    .load(data.getImage()) // Load image from URL
                    .placeholder(R.drawable.placeholder) // Placeholder image while loading
                    .error(R.drawable.placeholder) // Fallback image in case of error
                    .into(holder.profile);
        } else {
            holder.profile.setImageResource(R.drawable.placeholder);
        }

        // Set name and score
        holder.name.setText(data.getName());
        holder.score.setText("Score: " + data.getScore());
    }

    @Override
    public int getItemCount() {
        return list.size(); // Return the size of the data list
    }

    public static class ScoreViewHolder extends RecyclerView.ViewHolder {
        TextView rank, name, score;
        ImageView profile, rankIcon;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize view components
            rank = itemView.findViewById(R.id.leaderboard_rank);
            name = itemView.findViewById(R.id.leaderboard_name);
            score = itemView.findViewById(R.id.leaderboard_score);
            profile = itemView.findViewById(R.id.leaderboard_profile);
            rankIcon = itemView.findViewById(R.id.leaderboard_rank_icon); // Add new ImageView for rank icon
        }
    }
}
