package com.hfad.csementorlearningapp.ui.code;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hfad.csementorlearningapp.R;

public class CodeActivity extends AppCompatActivity {

    //CodeView codeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_code);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       // codeView = findViewById(R.id.code_view);
        //codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO);
        //loadPrograms();
    }

//    private void loadPrograms() {
//        codeView.showCode(""+"class Hello (\n"+
//                "public static void main(String args[]){\n"+
//                "System.out.println(\"Hello World\");\n"+
//                "}\n"+
//                "}");
//
//    }
}