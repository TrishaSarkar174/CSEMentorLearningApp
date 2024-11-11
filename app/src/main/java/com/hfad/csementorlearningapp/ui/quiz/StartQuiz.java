package com.hfad.csementorlearningapp.ui.quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hfad.csementorlearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class StartQuiz extends AppCompatActivity {

    private TextView questionTxt,indicator;
    private LinearLayout container;
    private Button nextBtn, shareBtn;
    private int score=0;
    private int position=0;
    private int count=0;

   // DatabaseReference reference;

    //private List<QuestionData> listl


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

        questionTxt =findViewById(R.id.question);
        indicator=findViewById(R.id.indicator);
        container=findViewById(R.id.linearLayout2);
        nextBtn=findViewById(R.id.next_btn);
        shareBtn=findViewById(R.id.share_btn );

//        list = new ArrayList<>();
//        reference = FirebaseDatabase.getInstance().getReference();
//
//        reference.child("Questions").addListenerForSingValueEvent(new ValueEventListener(){
//
//        })

    }
}