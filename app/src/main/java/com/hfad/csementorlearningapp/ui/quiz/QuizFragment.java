package com.hfad.csementorlearningapp.ui.quiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hfad.csementorlearningapp.R;

public class QuizFragment extends Fragment {

    public QuizFragment(){

    }


    Button playQuiz;

    //FirebaseUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        playQuiz = root.findViewById(R.id.play_quiz);
       // user = FirebaseAuth.getInstance().getCurrentUser();

        playQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(user != null){
//                    startActivity(new Intent(getContext(),StartQuiz.class));
//                }
//                else{
//                    startActivity(new Intent(getContext(),LoginActivity.class));
//                }
            }
        });




        return root;
    }
}