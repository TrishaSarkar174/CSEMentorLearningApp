package com.hfad.csementorlearningapp.chaptertopics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;


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
import com.hfad.csementorlearningapp.chapter.one.ArrayOperations;
import com.hfad.csementorlearningapp.chapter.one.BasicTerminologies;
import com.hfad.csementorlearningapp.chapter.one.Graphs;
import com.hfad.csementorlearningapp.chapter.one.IntroductionToDataStructure;
import com.hfad.csementorlearningapp.chapter.one.LinkedLists;
import com.hfad.csementorlearningapp.chapter.one.ReferredBookDS;
import com.hfad.csementorlearningapp.chapter.one.SortingAlgorithms;
import com.hfad.csementorlearningapp.chapter.one.AVLTree;
import com.hfad.csementorlearningapp.chapter.one.StacksAndQueuesRecursion;
import com.hfad.csementorlearningapp.chapter.one.StringProcessing;
import com.hfad.csementorlearningapp.chapter.one.Trees;
import com.hfad.csementorlearningapp.chapter.three.HtmlAndNewElements;
import com.hfad.csementorlearningapp.chapter.three.HtmlElementsAndAttributes;
import com.hfad.csementorlearningapp.chapter.three.IntroductionToHtml;
import com.hfad.csementorlearningapp.chapter.three.MultimediaInHtml;
import com.hfad.csementorlearningapp.chapter.three.WorkingWithForms;
import com.hfad.csementorlearningapp.chapter.two.ActivitySelectionProblem;
import com.hfad.csementorlearningapp.chapter.two.BFS;
import com.hfad.csementorlearningapp.chapter.two.DFS;
import com.hfad.csementorlearningapp.chapter.two.Dijkstra;
import com.hfad.csementorlearningapp.chapter.two.DynamicProgramming;
import com.hfad.csementorlearningapp.chapter.two.ElementsofDP;
import com.hfad.csementorlearningapp.chapter.two.FractionalKnapsackHuffmanCode;
import com.hfad.csementorlearningapp.chapter.two.GreedyAlgorithms;
import com.hfad.csementorlearningapp.chapter.two.HeapSort;
import com.hfad.csementorlearningapp.chapter.two.MCM;
import com.hfad.csementorlearningapp.chapter.two.MSTKruskal;
import com.hfad.csementorlearningapp.chapter.two.MSTPrims;
import com.hfad.csementorlearningapp.chapter.two.MergeSort;
import com.hfad.csementorlearningapp.chapter.two.ReferredBook;
import com.hfad.csementorlearningapp.chapter.two.SCC;
import com.hfad.csementorlearningapp.chapter.two.SelectionSort;
import com.hfad.csementorlearningapp.chapter.two.TopologicalSort;

public class TopicActivity extends AppCompatActivity {

    Toolbar toolbar;
    ExpandableHeightGridView gridView;
    String chapterName;
    TopicAdapter adapter;
    String arr[]=null;
    ImageView chapterImage;

// chapter means course name here
    String chapter1[] = {"Referred Book of DS","Introduction to Data Structure","Basic Terminologies","String Processing","Array Operations","LinkedLists","Sorting","Graphs","Stack, Queue, Recursion","Trees","AVL Tree"};
    String chapter2[] = {"Referred Book of Algorithm","BFS","DFS","Topological Sort","Strongly Connected Components","Dynamic Programming","Elements of DP","Greedy Algorithms","Activity Selection Problem","Coin Change, Fractional Knapsack & Huffman Code","Dijkstra Algorithm","MST Prims Algorithm","MST Kruskal Algorithm","Matrix Chain Multiplication","Heap Sort","Merge Sort","Selection Sort"};
    String chapter6[] = {"Referred Book","Sparse Table","Articulation Point, Bridge, Biconnected Components","Segment Tree","Square Root Decomposition","Binary Indexed Tree","RMQ Techiniques","Network Flow","KMP Algorithm","AVL Tree"};
    String chapter3[] = {"Referred Book","Introduction to HTML","HTML Elements and Attributes","Working with Forms","Multimedia in HTML","HTML5 and New Elements"};
    String chapter4[] = {"Tech Yourself C Book","Programming with ANSI C-Balagurusamy Book","Introduction to C Programming","Data Types,Variables, and Operators","Control Flow","Functions in C","Pointers and Arrays","File Handling in C","Structures and Unions","Dynamic Memory Allocation"};
    String chapter5[] = {"Robert Lafore Book","Balagurusamy Book","Introduction to C++","Loops and Decisions","Functions","Arrays and Strings","Objects and Classes","Inheritance","Operator Overloading","Pointers","Structures","Virtual Functions","Streams and Files","Multifile Programs"};

    String chapter7[] = {"B.Forouzan Book","Introduction to Computer Network","Data Link Layer","Network Layer","Network Layer Design Issues","IP Address","Transport Layer","Congestion Control and QoS","Network Security","Application Layer","ATM"};
    String chapter8[] = {"William Stallings Book","Basic Concepts and Computer Evolution","Computer Arithmetic","Computer Function and Interconnection","Internal Memory","Cache Memory","External Memory","Control Unit Operation","Input Output","Instruction Level Parallelism","Instruction Set","Multicore Computers","Parallel Processing","Process Structure and Function","RISC"};
    String chapter9[] = {"Introduction to Digital Image Processing","Filtering and Image Resizing","Color Model","Edge Detection","Image Moments","Image Restoration","Image Transform","Morphology","Pseudocoloring","Thresholding","Hough Transform"};
    String chapter10[] = {"B. Forouzan Book","Layered Communications","Logical Link Control","MAC","Frame Relay","Data and Signals","Digital Transmission","Digital To Analog Conversion","Line Coding","Pulse Code Modulation","Delta Modulation","Multiplexing Techniques","Huffman Coding","ATM"};
    String chapter11[] = {"Referred Book of Database","Introduction to Database","Database System Architectures","Data Model","SQL","Relational Algebra","Normalization","Functional Dependency","Transactions","Data Recovery System","Indexing and Hashing","Integrity and Security"};
    String chapter12[] = {"Referred Book of Discrete Math","Proposition and Propositional Equivalence","Rules of Inference","Relations","Predicates and Quantifiers","Counting","Graph and Tree"};
    String chapter13[] = {"Referred Book of EDC","Semiconductor Diodes","Diode Applications","DC Biasing BJTs","Transistor Construction","Field Effect Transistors","FET Biasing","BJT AC Analysis","FET Amplifiers","Power Supply","Operational Amplifiers"};
    String chapter14[] = {"Referred Book of HCI","Human Computer Interaction","Interaction","Interaction Model","Interface Design","UI Management System","Paradigms of Interaction","Ergonomics","Communication and Collaboration Model","Multimedia","HTA","Evaluation Techniques","Diagrammatic Dialog Design Notations","VR and AR","Ubiquitous Computing"};
    String chapter15[] = {"Getting Started With Java","Selection Statements","Repetition Statements","Control Statements and Loop","Numerical Data","Arrays","IO and String","Class and Objects","Defining Your Own Class part1","Defining Your Own Class part2","Inheritance","Array of Objects","Abstract Class","Interface","Exceptions and Assertions"};
    String chapter16[] = {"Referred Book of Microprocessor","Basic of Microprocessor","Data Type","Memory Organization","Keyboard and Display","8086 Pindiagram","Interrupt","8086 Interrupts","Features of Pentium Processor","DMA Controller","80286 & 80386","Semiconductor Memory","Serial Communication Interfaces"};
    String chapter17[] = {"Referred Book of NM","Introduction to Numerical Computing","Errors in Arithmetic","Errors in Integer & Floating Point Arithmetic","Boundary value & Eigen Value Problem","Direct Solution of Linear Equations","Iterative Solution of Linear Equations","Roots of Nonlinear Equations","Numerical Differentiations","Numerical Integration","Ordinary Differential Equations","Interpolation","Regression"};
    String chapter18[] = {"Referred Book of OS","Introduction to OS","Operating System Architecture","Main Memory","Virtual Memory","Process","Process Synchronization","Threads","Deadlocks","CPU Scheduling","Mass Storage Systems"};
    String chapter19[] = {"Basic of SWE","User Story","Documentation & Coding Standards","Architectural Pattern","SDLC & SW Process Model","Design Principle","Issue & Bug Tracking","White Box Testing","Black Box Testing","Agile","Junit Examples"};
    String chapter20[] = {"Basic Concepts of WN","Basic Concepts of Cognitive Radio","4G Wireless Communication","Mobile Ad-hoc Network","5G Wireles Network","Wireless Sensor Network"};


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
            case "Referred Book of DS":
                startActivity(new Intent(TopicActivity.this, ReferredBookDS.class));
                break;
            case "Introduction to Data Structure":
                startActivity(new Intent(TopicActivity.this, IntroductionToDataStructure.class));
                break;
            case "Basic Terminologies":
                startActivity(new Intent(TopicActivity.this, BasicTerminologies.class));
                break;
            case "String Processing":
                startActivity(new Intent(TopicActivity.this, StringProcessing.class));
                break;
            case "Array Operations":
                startActivity(new Intent(TopicActivity.this, ArrayOperations.class));
                break;
            case "LinkedLists":
                startActivity(new Intent(TopicActivity.this, LinkedLists.class));
                break;
            case "Sorting":
                startActivity(new Intent(TopicActivity.this, SortingAlgorithms.class));
                break;
            case "Graphs":
                startActivity(new Intent(TopicActivity.this, Graphs.class));
                break;
            case "Stack, Queue, Recursion":
                startActivity(new Intent(TopicActivity.this, StacksAndQueuesRecursion.class));
                break;
            case "Trees":
                startActivity(new Intent(TopicActivity.this, Trees.class));
                break;
            case "AVL Tree":
                startActivity(new Intent(TopicActivity.this, AVLTree.class));
                break;



                //Algorithm course
            case "Referred Book of Algorithm":
                startActivity(new Intent(TopicActivity.this, ReferredBook.class));
                break;
            case "BFS":
                startActivity(new Intent(TopicActivity.this, BFS.class));
                break;
            case "DFS":
                startActivity(new Intent(TopicActivity.this, DFS.class));
                break;
            case "Topological Sort":
                startActivity(new Intent(TopicActivity.this, TopologicalSort.class));
                break;
            case "Strongly Connected Components":
                startActivity(new Intent(TopicActivity.this, SCC.class));
                break;
            case "Dynamic Programming":
                startActivity(new Intent(TopicActivity.this, DynamicProgramming.class));
                break;
            case "Elements of DP":
                startActivity(new Intent(TopicActivity.this, ElementsofDP.class));
                break;
            case "Greedy Algorithms":
                startActivity(new Intent(TopicActivity.this, GreedyAlgorithms.class));
                break;
            case "Activity Selection Problem":
                startActivity(new Intent(TopicActivity.this, ActivitySelectionProblem.class));
                break;
            case "Coin Change, Fractional Knapsack & Huffman Code":
                startActivity(new Intent(TopicActivity.this, FractionalKnapsackHuffmanCode.class));
                break;
            case "Dijkstra Algorithm":
                startActivity(new Intent(TopicActivity.this, Dijkstra.class));
                break;
            case "MST Prims Algorithm":
                startActivity(new Intent(TopicActivity.this, MSTPrims.class));
                break;
            case "MST Kruskal Algorithm":
                startActivity(new Intent(TopicActivity.this, MSTKruskal.class));
                break;
            case "Matrix Chain Multiplication":
                startActivity(new Intent(TopicActivity.this, MCM.class));
                break;
            case "Heap Sort":
                startActivity(new Intent(TopicActivity.this, HeapSort.class));
                break;
            case "Merge Sort":
                startActivity(new Intent(TopicActivity.this, MergeSort.class));
                break;
            case "Selection Sort":
                startActivity(new Intent(TopicActivity.this, SelectionSort.class));
                break;


           // HTML
            case "Introduction to HTML":
                startActivity(new Intent(TopicActivity.this, IntroductionToHtml.class));
                break;
            case "HTML Elements and Attributes":
                startActivity(new Intent(TopicActivity.this, HtmlElementsAndAttributes.class));
                break;
            case "Working with Forms":
                startActivity(new Intent(TopicActivity.this, WorkingWithForms.class));
                break;
            case "Multimedia in HTML":
                startActivity(new Intent(TopicActivity.this, MultimediaInHtml.class));
                break;
            case "HTML5 and New Elements":
                startActivity(new Intent(TopicActivity.this, HtmlAndNewElements.class));
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