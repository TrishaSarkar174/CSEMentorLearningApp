package com.hfad.csementorlearningapp.leaderboard;

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

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewAdapater> {

    List<ScoreData> list;
    Context context;


    public ScoreAdapter(Context context, List<ScoreData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ScoreViewAdapater onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.score_list_item,parent,false);
        return new ScoreViewAdapater(view);
    }

    int k;


    @Override
    public void onBindViewHolder(@NonNull ScoreViewAdapater holder, int position) {

        k=list.size() -50;


        ScoreData currentItem = list.get(position +k );
        holder.name.setText(currentItem.getName());
        holder.score.setText(String.valueOf(currentItem.getScore()));
        holder.rank.setText(String.valueOf(list.size()-(position+k)));
        Glide.with(context).load(currentItem.getImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {

        return Math.min(list.size(),50);

    }

    public class ScoreViewAdapater extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,score,rank;



        public ScoreViewAdapater(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.score_user_img);
            name=itemView.findViewById(R.id.score_user_name);
            score=itemView.findViewById(R.id.score_user_result);
            rank=itemView.findViewById(R.id.score_user_rank);


        }
    }
}
