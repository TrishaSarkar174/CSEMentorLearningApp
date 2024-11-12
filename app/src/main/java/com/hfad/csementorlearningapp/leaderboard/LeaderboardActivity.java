package com.hfad.csementorlearningapp.leaderboard;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.csementorlearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    List<ScoreData> list;
    ScoreAdapter adapter;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.leaderboard_recycler);
        progressBar = findViewById(R.id.leaderboardProgress);

        reference= FirebaseDatabase.getInstance().getReference().child("Score");
        list=new ArrayList<>();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);


        reference.orderByChild("score").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                for(DataSnapshot snapshot: snapshot1.getChildren()){
                    ScoreData data=snapshot.getValue(ScoreData.class);
                    list.add(data);

                }
                adapter=new ScoreAdapter(LeaderboardActivity.this,list);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(LeaderboardActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}