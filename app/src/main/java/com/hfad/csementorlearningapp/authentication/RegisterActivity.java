package com.hfad.csementorlearningapp.authentication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hfad.csementorlearningapp.R;


public class RegisterActivity extends AppCompatActivity {

     EditText regName,regEmail,regPassword;
     Button regButton;
     private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        regName= (EditText) findViewById(R.id.reg_name);
        regEmail= (EditText) findViewById(R.id.reg_email);
        regPassword=  findViewById(R.id.reg_password);
        regButton= findViewById(R.id.register_button);

        auth = FirebaseAuth.getInstance();
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
          String name, email,password;
          name=regName.getText().toString().trim();
          email=regEmail.getText().toString().trim();
          password=regPassword.getText().toString().trim();

          if(name.isEmpty() || TextUtils.isEmpty(email) || password.isEmpty()){
              Toast.makeText(this,"please Enter All Fields", Toast.LENGTH_SHORT).show();
          }else{
              auth.createUserWithEmailAndPassword(email,password)
                      .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if(task.isSuccessful()){
                                  Toast.makeText(RegisterActivity.this,"Registered Successful",Toast.LENGTH_SHORT).show();

                              }else{
                                  Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                              }
                          }
                      });
          }
    }
}