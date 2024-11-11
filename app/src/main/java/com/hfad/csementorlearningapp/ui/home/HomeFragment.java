package com.hfad.csementorlearningapp.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hfad.csementorlearningapp.R;
import com.hfad.csementorlearningapp.chaptertopics.TopicActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
    }

    CardView heading1, heading2, heading3, heading4, heading5;
    ImageView image1,image2,image3,image4,image5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        heading1 = view.findViewById(R.id.data_structure);
        heading2 = view.findViewById(R.id.algorithms);
        heading3 = view.findViewById(R.id.html);
        heading4 = view.findViewById(R.id.c);
        heading5 = view.findViewById(R.id.cpp);

        image1 = view.findViewById(R.id.datastructureID);
        image2 = view.findViewById(R.id.algorithmsID);
        image3 = view.findViewById(R.id.htmlID);
        image4 = view.findViewById(R.id.cID);
        image5 = view.findViewById(R.id.cppID);

        loadImage();

        heading1.setOnClickListener(this);
        heading2.setOnClickListener(this);
        heading3.setOnClickListener(this);
        heading4.setOnClickListener(this);
        heading5.setOnClickListener(this);

        return view;
    }

    private void loadImage() {
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhierarchical.png?alt=media&token=49eef7d6-4dc2-4ee8-abaf-e866196deee7")
                .into(image1);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Falgorithms.png?alt=media&token=ad75b224-c77f-41c7-a965-0c3efb3f34a6")
                .into(image2);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhtml5.png?alt=media&token=a9bf0969-e995-4b9a-8942-076b2845c857")
                .into(image3);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fc.png?alt=media&token=837af69d-cc54-4320-8dfe-972f6829a495")
                .into(image4);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fcpp.png?alt=media&token=6f2f5b08-0242-4de5-90c0-ceee9709a829")
                .into(image5);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), TopicActivity.class);

        if (view.getId() == R.id.data_structure) {
            intent.putExtra("chapterName", "data_structure");
            startActivity(intent);
        } else if (view.getId() == R.id.algorithms) {
            intent.putExtra("chapterName", "algorithms");
            startActivity(intent);
        } else if (view.getId() == R.id.html) {
            intent.putExtra("chapterName", "html");
            startActivity(intent);
        } else if (view.getId() == R.id.c) {
            intent.putExtra("chapterName", "c");
            startActivity(intent);
        } else if (view.getId() == R.id.cpp) {
            intent.putExtra("chapterName", "cpp");
            startActivity(intent);
        }
    }
}
