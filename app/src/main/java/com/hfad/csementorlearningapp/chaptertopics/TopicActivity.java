package com.hfad.csementorlearningapp.chaptertopics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.hfad.csementorlearningapp.R;
import com.hfad.csementorlearningapp.chapter.five.IntroductionToCpp;
import com.hfad.csementorlearningapp.chapter.four.IntroductionToCProgramming;
import com.hfad.csementorlearningapp.chapter.one.AdvancedDataStructures;
import com.hfad.csementorlearningapp.chapter.one.ArraysAndLinkedLists;
import com.hfad.csementorlearningapp.chapter.one.Graphs;
import com.hfad.csementorlearningapp.chapter.one.Hashing;
import com.hfad.csementorlearningapp.chapter.one.HeapsAndPriorityQueues;
import com.hfad.csementorlearningapp.chapter.one.IntroductionToDataStructure;
import com.hfad.csementorlearningapp.chapter.one.SortingAlgorithms;
import com.hfad.csementorlearningapp.chapter.one.StacksAndQueues;
import com.hfad.csementorlearningapp.chapter.one.Trees;
import com.hfad.csementorlearningapp.chapter.three.IntroductionToHtml;
import com.hfad.csementorlearningapp.chapter.two.DivideAndConquer;
import com.hfad.csementorlearningapp.chapter.two.IntroductionToAlgorithms;

public class TopicActivity extends AppCompatActivity {

    Toolbar toolbar;
    ExpandableHeightGridView gridView;
    String chapterName;
    TopicAdapter adapter;
    String arr[]=null;
    ImageView chapterImage;

// chapter means course name here
    String chapter1[] = {"Introduction to Data Structure","Arrays and Linked Lists","Stacks and Queues","Trees","Graphs","Hashing","Heaps and Priority Queues","Sorting Algorithms","Advanced Data Structures"};
    String chapter2[] = {"Introduction to Algorithms","Divide and Conquer","Dynamic Programming","Greedy algorithms","Graph Algorithms","Sorting and Searching Algorithms","NP-Completeness"};
    String chapter3[] = {"Introduction to HTML","HTML Elements and Attributes","Working with Forms","Multimedia in HTML","HTML5 and New Elements"};
    String chapter4[] = {"Introduction to C Programming","Data Types,Variables, and Operators","Control Flow","Functions in C","Pointers and Arrays","File Handling in C","Structures and Unions","Dynamic Memory Allocation"};
    String chapter5[] = {"Introduction to C++","Functions and Loops","Object-Oriented Programming","Inheritance and Polymorphism","Templates and STL","File Handling in C++","Exception Handling in C++"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_topic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar);
        gridView =findViewById(R.id.topics_name);
        gridView.setExpanded(true);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        chapterName = getIntent().getStringExtra("chapterName");
        chapterImage = findViewById(R.id.chapter_image);

        compareAndOpen();


    }

    private void compareAndOpen() {

        if(chapterName.equals("data_structure"))
        {
            arr = chapter1;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhierarchical.png?alt=media&token=49eef7d6-4dc2-4ee8-abaf-e866196deee7")
                    .into(chapterImage);
            getSupportActionBar().setTitle("Data Structure");
        }
        else if(chapterName.equals("algorithms")){
            arr = chapter2;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Falgorithms.png?alt=media&token=ad75b224-c77f-41c7-a965-0c3efb3f34a6")
                    .into(chapterImage);
            getSupportActionBar().setTitle("Algorithms");
        }
        else if(chapterName.equals("html")){
            arr = chapter3;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fhtml5.png?alt=media&token=a9bf0969-e995-4b9a-8942-076b2845c857")
                    .into(chapterImage);
            getSupportActionBar().setTitle("HTML");
        }
        else if(chapterName.equals("c")){
            arr = chapter4;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fc.png?alt=media&token=837af69d-cc54-4320-8dfe-972f6829a495")
                    .into(chapterImage);
            getSupportActionBar().setTitle("C");
        }
        else if(chapterName.equals("cpp")){
            arr = chapter5;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Fcpp.png?alt=media&token=6f2f5b08-0242-4de5-90c0-ceee9709a829")
                    .into(chapterImage);
            getSupportActionBar().setTitle("C++");
        }
        else {
            arr = null;
        }

        adapter = new TopicAdapter(TopicActivity.this,arr);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                openActivity(arr[i]);
            }
        });
    }

    private void openActivity(String s) {
        switch(s){
            // Data Structure
            case "Introduction to Data Structure":
                startActivity(new Intent(TopicActivity.this, IntroductionToDataStructure.class));
                break;
            case "Arrays and Linked Lists":
                startActivity(new Intent(TopicActivity.this, ArraysAndLinkedLists.class));
                break;
            case "Stacks and Queues":
                startActivity(new Intent(TopicActivity.this, StacksAndQueues.class));
                break;
            case "Trees":
                startActivity(new Intent(TopicActivity.this, Trees.class));
                break;
            case "Graphs":
                startActivity(new Intent(TopicActivity.this, Graphs.class));
                break;
            case "Hashing":
                startActivity(new Intent(TopicActivity.this, Hashing.class));
                break;
            case "Heaps and Priority Queues":
                startActivity(new Intent(TopicActivity.this, HeapsAndPriorityQueues.class));
                break;
            case "Sorting Algorithms":
                startActivity(new Intent(TopicActivity.this, SortingAlgorithms.class));
                break;
            case "Advanced Data Structures":
                startActivity(new Intent(TopicActivity.this, AdvancedDataStructures.class));
                break;

                //Algorithm course
            case "Introduction to Algorithms":
                startActivity(new Intent(TopicActivity.this, IntroductionToAlgorithms.class));
                break;
            case "Divide and Conquer":
                startActivity(new Intent(TopicActivity.this, DivideAndConquer.class));
                break;
            case "Dynamic Programming":
                startActivity(new Intent(TopicActivity.this, IntroductionToAlgorithms.class));
                break;
            case "Greedy algorithms":
                startActivity(new Intent(TopicActivity.this, IntroductionToAlgorithms.class));
                break;
            case "Graph Algorithms":
                startActivity(new Intent(TopicActivity.this, IntroductionToAlgorithms.class));
                break;
            case "Sorting and Searching Algorithms":
                startActivity(new Intent(TopicActivity.this, IntroductionToAlgorithms.class));
                break;
            case "NP-Completeness":
                startActivity(new Intent(TopicActivity.this, IntroductionToAlgorithms.class));
                break;

           // HTML
            case "Introduction to HTML":
                startActivity(new Intent(TopicActivity.this, IntroductionToHtml.class));
                break;
            case "HTML Elements and Attributes":
                startActivity(new Intent(TopicActivity.this, IntroductionToHtml.class));
                break;
            case "Working with Forms":
                startActivity(new Intent(TopicActivity.this, IntroductionToHtml.class));
                break;
            case "Multimedia in HTML":
                startActivity(new Intent(TopicActivity.this, IntroductionToHtml.class));
                break;
            case "HTML5 and New Elements":
                startActivity(new Intent(TopicActivity.this, IntroductionToHtml.class));
                break;

            // C
            case "Introduction to C Programming":
                startActivity(new Intent(TopicActivity.this, IntroductionToCProgramming.class));
                break;


                // C++
            case "Introduction to C++":
                startActivity(new Intent(TopicActivity.this, IntroductionToCpp.class));
                break;
        }
    }
}