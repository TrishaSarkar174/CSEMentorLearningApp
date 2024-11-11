package com.hfad.csementorlearningapp.ui.code;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hfad.csementorlearningapp.R;

public class CodeCategory extends AppCompatActivity {

    ListView program;
    String[] list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_code_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadCategory();

        program = findViewById(R.id.program);
        CustomAdapter adapter = new CustomAdapter();
        program.setAdapter(adapter);
        program.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CodeCategory.this,CodeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadCategory() {
        final String chap1[] = {"chapter1","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap2[] = {"chapter2","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap3[] = {"chapter3","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap4[] = {"chapter4","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap5[] = {"chapter5","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap6[] = {"chapter6","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap7[] = {"chapter7","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap8[] = {"chapter8","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap9[] = {"chapter9","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap10[] = {"chapter10","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap11[] = {"chapter11","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

        final String chap12[] = {"chapter12","Write a program to read and display n numbers using an array",
                "Write a program to find the mean of n numbers using an array",
                "Write a program to find the second largest of n numbers using an array",
                "Write a program to find whether the array of integers contain a duplicate number",
                "Write a program to insert a number in an array that is already sorted in ascending order",
                "Write a program to delete a number from an array that is already sorted in descending order"};

          String category =getIntent().getStringExtra("codecategory");
          switch(category){
              case "chapter1":
                  list =chap1;
                  break;
              case "chapter2":
                  list =chap2;
                  break;
              case "chapter3":
                  list =chap3;
                  break;
              case "chapter4":
                  list =chap4;
                  break;
              case "chapter5":
                  list =chap5;
                  break;
              case "chapter6":
                  list =chap6;
                  break;
              case "chapter7":
                  list =chap7;
                  break;
              case "chapter8":
                  list =chap8;
                  break;
              case "chapter9":
                  list =chap9;
                  break;
              case "chapter10":
                  list =chap10;
                  break;
              case "chapter11":
                  list =chap11;
                  break;
              case "chapter12":
                  list =chap12;
                  break;

          }

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.code_category_item_layout,null);

            TextView textView=view.findViewById(R.id.code_title);
            textView.setText(list[i]);

            return view;
        }
    }
}