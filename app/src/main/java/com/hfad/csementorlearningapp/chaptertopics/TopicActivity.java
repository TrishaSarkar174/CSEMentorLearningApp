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
import com.hfad.csementorlearningapp.chapter.eight.Agile;
import com.hfad.csementorlearningapp.chapter.eight.ArchitecturalPattern;
import com.hfad.csementorlearningapp.chapter.eight.BasicOfSWE;
import com.hfad.csementorlearningapp.chapter.eight.BlackBoxTesting;
import com.hfad.csementorlearningapp.chapter.eight.DesignPrinciple;
import com.hfad.csementorlearningapp.chapter.eight.DocumentationAndCodingStandards;
import com.hfad.csementorlearningapp.chapter.eight.IssueAndBugTracking;
import com.hfad.csementorlearningapp.chapter.eight.JUnitExamples;
import com.hfad.csementorlearningapp.chapter.eight.SDLCAndSWProcessModel;
import com.hfad.csementorlearningapp.chapter.eight.UserStory;
import com.hfad.csementorlearningapp.chapter.eight.WhiteBoxTesting;
import com.hfad.csementorlearningapp.chapter.five.ArraysAndStrings;
import com.hfad.csementorlearningapp.chapter.five.Functions;
import com.hfad.csementorlearningapp.chapter.five.Inheritance;
import com.hfad.csementorlearningapp.chapter.five.IntroductionToCpp;
import com.hfad.csementorlearningapp.chapter.five.LoopsAndDecisions;
import com.hfad.csementorlearningapp.chapter.five.MultifilePrograms;
import com.hfad.csementorlearningapp.chapter.five.ObjectsAndClasses;
import com.hfad.csementorlearningapp.chapter.five.OperatorOverloading;
import com.hfad.csementorlearningapp.chapter.five.Pointers;
import com.hfad.csementorlearningapp.chapter.five.ReferredBook1;
import com.hfad.csementorlearningapp.chapter.five.ReferredBook2;
import com.hfad.csementorlearningapp.chapter.five.StreamsAndFiles;
import com.hfad.csementorlearningapp.chapter.five.Structures;
import com.hfad.csementorlearningapp.chapter.five.VirtualFunctions;
import com.hfad.csementorlearningapp.chapter.four.ControlFlow;
import com.hfad.csementorlearningapp.chapter.four.DataTypesVariablesAndOperators;
import com.hfad.csementorlearningapp.chapter.four.DynamicMemoryAllocation;
import com.hfad.csementorlearningapp.chapter.four.FileHandlingInC;
import com.hfad.csementorlearningapp.chapter.four.FunctionsInC;
import com.hfad.csementorlearningapp.chapter.four.IntroductionToCProgramming;
import com.hfad.csementorlearningapp.chapter.four.PointersAndArrays;
import com.hfad.csementorlearningapp.chapter.four.ReferredBookC;
import com.hfad.csementorlearningapp.chapter.four.StructuresAndUnions;
import com.hfad.csementorlearningapp.chapter.nine.BasicConceptsAndComputerEvolution;
import com.hfad.csementorlearningapp.chapter.nine.CacheMemory;
import com.hfad.csementorlearningapp.chapter.nine.ComputerArithmetic;
import com.hfad.csementorlearningapp.chapter.nine.ComputerFunctionAndInterconnection;
import com.hfad.csementorlearningapp.chapter.nine.ControlUnitOperation;
import com.hfad.csementorlearningapp.chapter.nine.ExternalMemory;
import com.hfad.csementorlearningapp.chapter.nine.InputOutput;
import com.hfad.csementorlearningapp.chapter.nine.InstructionLevelParallelism;
import com.hfad.csementorlearningapp.chapter.nine.InstructionSet;
import com.hfad.csementorlearningapp.chapter.nine.InternalMemory;
import com.hfad.csementorlearningapp.chapter.nine.MulticoreComputers;
import com.hfad.csementorlearningapp.chapter.nine.ParallelProcessing;
import com.hfad.csementorlearningapp.chapter.nine.ProcessStructureAndFunction;
import com.hfad.csementorlearningapp.chapter.nine.RISC;
import com.hfad.csementorlearningapp.chapter.nine.WilliamStallingsBook;
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
import com.hfad.csementorlearningapp.chapter.seven.ATM;
import com.hfad.csementorlearningapp.chapter.seven.ApplicationLayer;
import com.hfad.csementorlearningapp.chapter.seven.CongestionControlandQOS;
import com.hfad.csementorlearningapp.chapter.seven.DataLinkLayer;
import com.hfad.csementorlearningapp.chapter.seven.IPAddress;
import com.hfad.csementorlearningapp.chapter.seven.IntroductionToComputerNetwork;
import com.hfad.csementorlearningapp.chapter.seven.NetworkLayer;
import com.hfad.csementorlearningapp.chapter.seven.NetworkLayerDesignIssues;
import com.hfad.csementorlearningapp.chapter.seven.NetworkSecurity;
import com.hfad.csementorlearningapp.chapter.seven.ReferredBookCNN;
import com.hfad.csementorlearningapp.chapter.seven.TransportLayer;
import com.hfad.csementorlearningapp.chapter.six.ArticulationPointBridgeBiconnectedComponents;
import com.hfad.csementorlearningapp.chapter.six.BinaryIndexedTree;
import com.hfad.csementorlearningapp.chapter.six.KMPAlgorithm;
import com.hfad.csementorlearningapp.chapter.six.NetworkFlow;
import com.hfad.csementorlearningapp.chapter.six.RMQTechniques;
import com.hfad.csementorlearningapp.chapter.six.ReferredBookAlgo2;
import com.hfad.csementorlearningapp.chapter.six.SegmentTree;
import com.hfad.csementorlearningapp.chapter.six.SparseTable;
import com.hfad.csementorlearningapp.chapter.six.SquareRootDecomposition;
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
    String chapter6[] = {"Referred Book of Algorithm 2","Sparse Table","Articulation Point, Bridge, Biconnected Components","Segment Tree","Square Root Decomposition","Binary Indexed Tree","RMQ Techniques","Network Flow","KMP Algorithm","AVL Tree"};
    String chapter3[] = {"Referred Book","Introduction to HTML","HTML Elements and Attributes","Working with Forms","Multimedia in HTML","HTML5 and New Elements"};
    String chapter4[] = {"Programming with ANSI C-Balagurusamy Book","Introduction to C Programming","Data Types,Variables, and Operators","Control Flow","Functions in C","Pointers and Arrays","File Handling in C","Structures and Unions","Dynamic Memory Allocation"};
    String chapter5[] = {"Robert Lafore Book","Balagurusamy Book","Introduction to C++","Loops and Decisions","Functions","Arrays and Strings","Objects and Classes","Inheritance","Operator Overloading","Pointers","Structures","Virtual Functions","Streams and Files","Multifile Programs"};

    String chapter7[] = {"B.Forouzan Book","Introduction to Computer Network","Data Link Layer","Network Layer","Network Layer Design Issues","IP Address","Transport Layer","Congestion Control and QoS","Network Security","Application Layer","ATM"};
    String chapter9[] = {"William Stallings Book","Basic Concepts and Computer Evolution","Computer Arithmetic","Computer Function and Interconnection","Internal Memory","Cache Memory","External Memory","Control Unit Operation","Input Output","Instruction Level Parallelism","Instruction Set","Multicore Computers","Parallel Processing","Process Structure and Function","RISC"};
    String chapter19[] = {"Introduction to Digital Image Processing","Filtering and Image Resizing","Color Model","Edge Detection","Image Moments","Image Restoration","Image Transform","Morphology","Pseudocoloring","Thresholding","Hough Transform"};
    String chapter10[] = {"B. Forouzan Book","Layered Communications","Logical Link Control","MAC","Frame Relay","Data and Signals","Digital Transmission","Digital To Analog Conversion","Line Coding","Pulse Code Modulation","Delta Modulation","Multiplexing Techniques","Huffman Coding","ATM"};
    String chapter11[] = {"Referred Book of Database","Introduction to Database","Database System Architectures","Data Model","SQL","Relational Algebra","Normalization","Functional Dependency","Transactions","Data Recovery System","Indexing and Hashing","Integrity and Security"};
    String chapter12[] = {"Referred Book of Discrete Math","Proposition and Propositional Equivalence","Rules of Inference","Relations","Predicates and Quantifiers","Counting","Graph and Tree"};
    String chapter13[] = {"Referred Book of EDC","Semiconductor Diodes","Diode Applications","DC Biasing BJTs","Transistor Construction","Field Effect Transistors","FET Biasing","BJT AC Analysis","FET Amplifiers","Power Supply","Operational Amplifiers"};
    String chapter14[] = {"Referred Book of HCI","Human Computer Interaction","Interaction","Interaction Model","Interface Design","UI Management System","Paradigms of Interaction","Ergonomics","Communication and Collaboration Model","Multimedia","HTA","Evaluation Techniques","Diagrammatic Dialog Design Notations","VR and AR","Ubiquitous Computing"};
    String chapter15[] = {"Getting Started With Java","Selection Statements","Repetition Statements","Control Statements and Loop","Numerical Data","Arrays","IO and String","Class and Objects","Defining Your Own Class part1","Defining Your Own Class part2","Inheritance","Array of Objects","Abstract Class","Interface","Exceptions and Assertions"};
    String chapter16[] = {"Referred Book of Microprocessor","Basic of Microprocessor","Data Type","Memory Organization","Keyboard and Display","8086 Pindiagram","Interrupt","8086 Interrupts","Features of Pentium Processor","DMA Controller","80286 & 80386","Semiconductor Memory","Serial Communication Interfaces"};
    String chapter17[] = {"Referred Book of NM","Introduction to Numerical Computing","Errors in Arithmetic","Errors in Integer & Floating Point Arithmetic","Boundary value & Eigen Value Problem","Direct Solution of Linear Equations","Iterative Solution of Linear Equations","Roots of Nonlinear Equations","Numerical Differentiations","Numerical Integration","Ordinary Differential Equations","Interpolation","Regression"};
    String chapter18[] = {"Referred Book of OS","Introduction to OS","Operating System Architecture","Main Memory","Virtual Memory","Process","Process Synchronization","Threads","Deadlocks","CPU Scheduling","Mass Storage Systems"};
    String chapter8[] = {"Basic of SWE","User Story","Documentation & Coding Standards","Architectural Pattern","SDLC & SW Process Model","Design Principle","Issue & Bug Tracking","White Box Testing","Black Box Testing","Agile","Junit Examples"};
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
        else if(chapterName.equals("Algorithm 1")){
            arr = chapter2;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/Images%2FcourseHeadImages%2Falgorithms.png?alt=media&token=ad75b224-c77f-41c7-a965-0c3efb3f34a6")
                    .into(chapterImage);
            getSupportActionBar().setTitle("Algorithm 1");
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
        else if(chapterName.equals("Algorithm2")){
            arr = chapter6;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/chapters%2Falgorithm.png?alt=media&token=9892a025-fcc5-45a4-a39c-fddeea6b82d7")
                    .into(chapterImage);
            getSupportActionBar().setTitle("Algorithm 2");
        }
        else if(chapterName.equals("CNN")){
            arr = chapter7;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/chapters%2Fcomputer_network.png?alt=media&token=7decc4bb-ffb9-4ddd-99cd-19a5f9d2dba3")
                    .into(chapterImage);
            getSupportActionBar().setTitle("Computer Network");
        }
        else if(chapterName.equals("SWE")){
            arr = chapter8;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/chapters%2FSWE.png?alt=media&token=7811fb40-2ba9-4d26-84c8-f419c49f37d5")
                    .into(chapterImage);
            getSupportActionBar().setTitle("Software Engineering");
        }
        else if(chapterName.equals("COA")){
            arr = chapter9;
            Glide.with(TopicActivity.this)
                    .load("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/chapters%2FCOA.png?alt=media&token=e0a119ca-6329-44d7-800d-c4963fc54455")
                    .into(chapterImage);
            getSupportActionBar().setTitle("Computer Architecture");
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
            case "Programming with ANSI C-Balagurusamy Book":
                startActivity(new Intent(TopicActivity.this, ReferredBookC.class));
                break;
            case "Introduction to C Programming":
                startActivity(new Intent(TopicActivity.this, IntroductionToCProgramming.class));
                break;
            case "Data Types, Variables & Operators":
                startActivity(new Intent(TopicActivity.this, DataTypesVariablesAndOperators.class));
                break;
            case "Control Flow":
                startActivity(new Intent(TopicActivity.this, ControlFlow.class));
                break;
            case "Functions in C":
                startActivity(new Intent(TopicActivity.this, FunctionsInC.class));
                break;
            case "Pointers and Arrays":
                startActivity(new Intent(TopicActivity.this, PointersAndArrays.class));
                break;
            case "File Handling in C":
                startActivity(new Intent(TopicActivity.this, FileHandlingInC.class));
                break;
            case "Structures and Unions":
                startActivity(new Intent(TopicActivity.this, StructuresAndUnions.class));
                break;
            case "Dynamic Memory Allocation":
                startActivity(new Intent(TopicActivity.this, DynamicMemoryAllocation.class));
                break;


                // C++
            case "Robert Lafore Book":
                startActivity(new Intent(TopicActivity.this, ReferredBook1.class));
                break;
            case "Balagurusamy Book":
                startActivity(new Intent(TopicActivity.this, ReferredBook2.class));
                break;
            case "Introduction to C++":
                startActivity(new Intent(TopicActivity.this, IntroductionToCpp.class));
                break;
            case "Loops and Decisions":
                startActivity(new Intent(TopicActivity.this, LoopsAndDecisions.class));
                break;
            case "Functions":
                startActivity(new Intent(TopicActivity.this, Functions.class));
                break;
            case "Arrays and Strings":
                startActivity(new Intent(TopicActivity.this, ArraysAndStrings.class));
                break;
            case "Objects and Classes":
                startActivity(new Intent(TopicActivity.this, ObjectsAndClasses.class));
                break;
            case "Inheritance":
                startActivity(new Intent(TopicActivity.this, Inheritance.class));
                break;
            case "Operator Overloading":
                startActivity(new Intent(TopicActivity.this, OperatorOverloading.class));
                break;
            case "Pointers":
                startActivity(new Intent(TopicActivity.this, Pointers.class));
                break;
            case "Structures":
                startActivity(new Intent(TopicActivity.this, Structures.class));
                break;
            case "Virtual Functions":
                startActivity(new Intent(TopicActivity.this, VirtualFunctions.class));
                break;
            case "Streams and Files":
                startActivity(new Intent(TopicActivity.this, StreamsAndFiles.class));
                break;
            case "Multifile Programs":
                startActivity(new Intent(TopicActivity.this, MultifilePrograms.class));
                break;


                //Algorithm 2
            case "Referred Book of Algorithm 2":
                startActivity(new Intent(TopicActivity.this, ReferredBookAlgo2.class));
                break;
            case "Sparse Table":
                startActivity(new Intent(TopicActivity.this, SparseTable.class));
                break;
            case "Articulation Point, Bridge, Biconnected Components":
                startActivity(new Intent(TopicActivity.this, ArticulationPointBridgeBiconnectedComponents.class));
                break;
            case "Segment Tree":
                startActivity(new Intent(TopicActivity.this, SegmentTree.class));
                break;
            case "Square Root Decomposition":
                startActivity(new Intent(TopicActivity.this, SquareRootDecomposition.class));
                break;
            case "Binary Indexed Tree":
                startActivity(new Intent(TopicActivity.this, BinaryIndexedTree.class));
                break;
            case "RMQ Techniques":
                startActivity(new Intent(TopicActivity.this, RMQTechniques.class));
                break;
            case "Network Flow":
                startActivity(new Intent(TopicActivity.this, NetworkFlow.class));
                break;
            case "KMP Algorithm":
                startActivity(new Intent(TopicActivity.this, KMPAlgorithm.class));
                break;


            // CNN
            case "B.Forouzan Book":
                startActivity(new Intent(TopicActivity.this, ReferredBookCNN.class));
                break;
            case "Introduction to Computer Network":
                startActivity(new Intent(TopicActivity.this, IntroductionToComputerNetwork.class));
                break;
            case "Data Link Layer":
                startActivity(new Intent(TopicActivity.this, DataLinkLayer.class));
                break;
            case "Network Layer":
                startActivity(new Intent(TopicActivity.this, NetworkLayer.class));
                break;
            case "Network Layer Design Issues":
                startActivity(new Intent(TopicActivity.this, NetworkLayerDesignIssues.class));
                break;
            case "IP Address":
                startActivity(new Intent(TopicActivity.this, IPAddress.class));
                break;
            case "Transport Layer":
                startActivity(new Intent(TopicActivity.this, TransportLayer.class));
                break;
            case "Congestion Control and QoS":
                startActivity(new Intent(TopicActivity.this, CongestionControlandQOS.class));
                break;
            case "Network Security":
                startActivity(new Intent(TopicActivity.this, NetworkSecurity.class));
                break;
            case "Application Layer":
                startActivity(new Intent(TopicActivity.this, ApplicationLayer.class));
                break;
            case "ATM":
                startActivity(new Intent(TopicActivity.this, ATM.class));
                break;


                // SWE
            case "Basic of SWE":
                startActivity(new Intent(TopicActivity.this, BasicOfSWE.class));
                break;
            case "User Story":
                startActivity(new Intent(TopicActivity.this, UserStory.class));
                break;
            case "Documentation & Coding Standards":
                startActivity(new Intent(TopicActivity.this, DocumentationAndCodingStandards.class));
                break;
            case "Architectural Pattern":
                startActivity(new Intent(TopicActivity.this, ArchitecturalPattern.class));
                break;
            case "SDLC & SW Process Model":
                startActivity(new Intent(TopicActivity.this, SDLCAndSWProcessModel.class));
                break;
            case "Design Principle":
                startActivity(new Intent(TopicActivity.this, DesignPrinciple.class));
                break;
            case "Issue & Bug Tracking":
                startActivity(new Intent(TopicActivity.this, IssueAndBugTracking.class));
                break;
            case "White Box Testing":
                startActivity(new Intent(TopicActivity.this, WhiteBoxTesting.class));
                break;
            case "Black Box Testing":
                startActivity(new Intent(TopicActivity.this, BlackBoxTesting.class));
                break;
            case "Agile":
                startActivity(new Intent(TopicActivity.this, Agile.class));
                break;
            case "Junit Examples":
                startActivity(new Intent(TopicActivity.this, JUnitExamples.class));
                break;

                // COA
            case "William Stallings Book":
                startActivity(new Intent(TopicActivity.this, WilliamStallingsBook.class));
                break;
            case "Basic Concepts and Computer Evolution":
                startActivity(new Intent(TopicActivity.this, BasicConceptsAndComputerEvolution.class));
                break;
            case "Computer Arithmetic":
                startActivity(new Intent(TopicActivity.this, ComputerArithmetic.class));
                break;
            case "Computer Function and Interconnection":
                startActivity(new Intent(TopicActivity.this, ComputerFunctionAndInterconnection.class));
                break;
            case "Internal Memory":
                startActivity(new Intent(TopicActivity.this, InternalMemory.class));
                break;
            case "Cache Memory":
                startActivity(new Intent(TopicActivity.this, CacheMemory.class));
                break;
            case "External Memory":
                startActivity(new Intent(TopicActivity.this, ExternalMemory.class));
                break;
            case "Control Unit Operation":
                startActivity(new Intent(TopicActivity.this, ControlUnitOperation.class));
                break;
            case "Input Output":
                startActivity(new Intent(TopicActivity.this, InputOutput.class));
                break;
            case "Instruction Level Parallelism":
                startActivity(new Intent(TopicActivity.this, InstructionLevelParallelism.class));
                break;
            case "Instruction Set":
                startActivity(new Intent(TopicActivity.this, InstructionSet.class));
                break;
            case "Multicore Computers":
                startActivity(new Intent(TopicActivity.this, MulticoreComputers.class));
                break;
            case "Parallel Processing":
                startActivity(new Intent(TopicActivity.this, ParallelProcessing.class));
                break;
            case "Process Structure and Function":
                startActivity(new Intent(TopicActivity.this, ProcessStructureAndFunction.class));
                break;
            case "RISC":
                startActivity(new Intent(TopicActivity.this, RISC.class));
                break;


        }
    }
}