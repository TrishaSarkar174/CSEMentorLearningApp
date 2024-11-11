package com.hfad.csementorlearningapp.ui.code;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hfad.csementorlearningapp.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class CodeFragment extends Fragment implements View.OnClickListener{


    public CodeFragment(){

    }

    CircleImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code, container, false);

        image1 = view.findViewById(R.id.chapter1);
        image2 = view.findViewById(R.id.chapter2);
        image3 = view.findViewById(R.id.chapter3);
        image4 = view.findViewById(R.id.chapter4);
        image5 = view.findViewById(R.id.chapter5);
        image6 = view.findViewById(R.id.chapter6);
        image7 = view.findViewById(R.id.chapter7);
        image8 = view.findViewById(R.id.chapter8);
        image9 = view.findViewById(R.id.chapter9);
        image10 = view.findViewById(R.id.chapter10);
        image11 = view.findViewById(R.id.chapter11);
        image12 = view.findViewById(R.id.chapter12);

        loadImage();
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        image8.setOnClickListener(this);
        image9.setOnClickListener(this);
        image10.setOnClickListener(this);
        image11.setOnClickListener(this);
        image12.setOnClickListener(this);


//        image1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getContext(),CodeCategory.class));
//            }
//        });

        return view;
    }

    private void loadImage() {
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhierarchical.png?alt=media&token=49eef7d6-4dc2-4ee8-abaf-e866196deee7")
                .into(image1);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhtml5.png?alt=media&token=a9bf0969-e995-4b9a-8942-076b2845c857")
                .into(image2);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fc.png?alt=media&token=837af69d-cc54-4320-8dfe-972f6829a495")
                .into(image3);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fcpp.png?alt=media&token=6f2f5b08-0242-4de5-90c0-ceee9709a829")
                .into(image4);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Falgorithms.png?alt=media&token=ad75b224-c77f-41c7-a965-0c3efb3f34a6")
                .into(image5);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhierarchical.png?alt=media&token=49eef7d6-4dc2-4ee8-abaf-e866196deee7")
                .into(image6);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Falgorithms.png?alt=media&token=ad75b224-c77f-41c7-a965-0c3efb3f34a6")
                .into(image7);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhtml5.png?alt=media&token=a9bf0969-e995-4b9a-8942-076b2845c857")
                .into(image8);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fc.png?alt=media&token=837af69d-cc54-4320-8dfe-972f6829a495")
                .into(image9);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fcpp.png?alt=media&token=6f2f5b08-0242-4de5-90c0-ceee9709a829")
                .into(image10);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fc.png?alt=media&token=837af69d-cc54-4320-8dfe-972f6829a495")
                .into(image11);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fcpp.png?alt=media&token=6f2f5b08-0242-4de5-90c0-ceee9709a829")
                .into(image12);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), CodeCategory.class);

        if (view.getId() == R.id.chapter1) {
            intent.putExtra("codecategory", "chapter1");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter2) {
            intent.putExtra("codecategory", "chapter2");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter3) {
            intent.putExtra("codecategory", "chapter3");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter4) {
            intent.putExtra("codecategory", "chapter4");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter5) {
            intent.putExtra("codecategory", "chapter5");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter6) {
            intent.putExtra("codecategory", "chapter6");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter7) {
            intent.putExtra("codecategory", "chapter7");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter8) {
            intent.putExtra("codecategory", "chapter8");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter9) {
            intent.putExtra("codecategory", "chapter9");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter10) {
            intent.putExtra("codecategory", "chapter10");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter11) {
            intent.putExtra("codecategory", "chapter11");
            startActivity(intent);
        } else if (view.getId() == R.id.chapter12) {
            intent.putExtra("codecategory", "chapter12");
            startActivity(intent);
        }
    }

}
