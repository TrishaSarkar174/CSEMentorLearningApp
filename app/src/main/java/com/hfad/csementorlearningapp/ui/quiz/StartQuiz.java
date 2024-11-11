package com.hfad.csementorlearningapp.ui.quiz;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hfad.csementorlearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class StartQuiz extends AppCompatActivity {

    private TextView questionTxt, indicator;
    private LinearLayout container;
    private Button nextBtn, shareBtn;
    private int score = 0;
    private int position = 0;
    private int count = 0;

    private DatabaseReference reference;
    private List<QuestionData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        questionTxt = findViewById(R.id.question);
        indicator = findViewById(R.id.indicator);
        container = findViewById(R.id.linearLayout2);
        nextBtn = findViewById(R.id.next_btn);
        shareBtn = findViewById(R.id.share_btn);

        list = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference();

        reference.child("Questions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String question = snapshot.child("question").getValue(String.class).toString();
                    String option1 = snapshot.child("option1").getValue(String.class).toString();
                    String option2 = snapshot.child("option2").getValue(String.class).toString();
                    String option3 = snapshot.child("option3").getValue(String.class).toString();
                    String option4 = snapshot.child("option4").getValue(String.class).toString();
                    String correctAns = snapshot.child("answer").getValue(String.class).toString();

                    list.add(new QuestionData(option1, option2, option3, option4, question, correctAns));
                }
                if (list.size() > 0) {
                    loadQuestion(questionTxt, 0, list.get(position).getQuestion());
                    for (int i=0;i<4;i++){
                        container.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                checkAnswer((Button)view);
                            }
                        });
                    }



                } else {
                    Toast.makeText(StartQuiz.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StartQuiz.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkAnswer(Button selectedOption) {
     if(selectedOption.getText().toString().equals(list.get(position).getAnswer())){
         score++;
         selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));
     }else{
        selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
        Button correctOption = container.findViewWithTag(list.get(position).getAnswer());
        correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));
     }
    }

    private void loadQuestion(final View view, final int value, final String data) {
        for (int i = 0; i < 4; i++) {
            container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
        }

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animator) {
                        if (value == 0 && count < 4) {
                            String option = "";
                            if (count == 0) option = list.get(position).getOption1();
                            else if (count == 1) option = list.get(position).getOption2();
                            else if (count == 2) option = list.get(position).getOption3();
                            else if (count == 3) option = list.get(position).getOption4();

                            loadQuestion(container.getChildAt(count),0, option);
                            count++;
                        }
                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animator) {
                        if (value == 0) {
                            try{
                                ((TextView)view).setText(data);
                                indicator.setText(position + "/" + list.size());
                            }catch(ClassCastException e){
                                ((Button)view).setText(data);
                            }
                            view.setTag(data);
                            loadQuestion(view, 1, data);
                        }
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animator) {}

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animator) {}
                });
    }


}
