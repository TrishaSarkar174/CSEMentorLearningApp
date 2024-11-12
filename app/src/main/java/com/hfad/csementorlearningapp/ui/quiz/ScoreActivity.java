package com.hfad.csementorlearningapp.ui.quiz;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.csementorlearningapp.R;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTxt,totalTxt;
    int score,total;
    FirebaseUser user;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        score=getIntent().getIntExtra("score",0);
        total=getIntent().getIntExtra("total",0);

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference();


        scoreTxt=(TextView) findViewById(R.id.score);
        totalTxt=(TextView) findViewById(R.id.total);

        scoreTxt.setText(String.valueOf(score));
        totalTxt.setText(String.valueOf(total));

        reference.child("Score").child(user.getUid()).child("score").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    score += Integer.parseInt(snapshot.getValue().toString());
                }

                snapshot.getRef().setValue(score);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}