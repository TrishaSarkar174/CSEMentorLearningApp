package com.hfad.csementorlearningapp.authentication;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import com.hfad.csementorlearningapp.R;


public class RegisterActivity extends AppCompatActivity {

     EditText regName,regEmail,regPassword;
     Button regButton,loginBtn;
     private FirebaseAuth auth;
     ImageView userImage;
     static int REQUEST_CODE=1;
     Uri pickedImgUri;
     private ProgressBar progressBar;

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
        userImage=(ImageView) findViewById(R.id.reg_image);
        progressBar = (ProgressBar) findViewById(R.id.regProgressBar);
        progressBar.setVisibility(View.GONE);
        loginBtn= findViewById(R.id.reg_login_btn);

        auth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

        userImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(Build.VERSION.SDK_INT >= 22){
                    checkAndRequestPermission();
                }else{
                    openGallery();
                }
               // openGallery();
            }
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void openLogin() {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }

    private void checkAndRequestPermission() {
        if(ContextCompat.checkSelfPermission(RegisterActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(RegisterActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else{
            openGallery();
        }
    }

    private void openGallery() {
        Intent galleryIntent = new Intent()
                .setAction(Intent.ACTION_GET_CONTENT)
                .setType("image/*");
        startActivityForResult(galleryIntent, REQUEST_CODE); // Use startActivityForResult with REQUEST_CODE
    }

//    private void openGallery() {
//        startActivity(new Intent()
//                .setAction(Intent.ACTION_GET_CONTENT)
//                .setType("image/*"), REQUEST_CODE);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if(data != null){
                pickedImgUri= data.getData();
                userImage.setImageURI(pickedImgUri);
            }

        }
    }

    private void registerUser() {
          String name, email,password;
          name=regName.getText().toString().trim();
          email=regEmail.getText().toString().trim();
          password=regPassword.getText().toString().trim();

          if(name.isEmpty() || TextUtils.isEmpty(email) || password.isEmpty() ){
              Toast.makeText(this,"please Enter All Fields", Toast.LENGTH_SHORT).show();
          }else{
              progressBar.setVisibility(View.VISIBLE);
              auth.createUserWithEmailAndPassword(email,password)
                      .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if(task.isSuccessful()){
                                  //Toast.makeText(RegisterActivity.this,"Registered Successful",Toast.LENGTH_SHORT).show();

                                  updateUI(name,pickedImgUri,auth.getCurrentUser());
                                  openProfile();
                                  progressBar.setVisibility(View.GONE);
                              }else{
                                  progressBar.setVisibility(View.GONE);
                                  Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                              }
                          }
                      });
          }
    }

    private void openProfile() {
        startActivity(new Intent(RegisterActivity.this,ProfileActivity.class));
        finish();
    }

    private void updateUI(String name, Uri pickedImgUri, FirebaseUser currentUser) {
        StorageReference mstorage = FirebaseStorage.getInstance().getReference().child("user_image");
        final StorageReference imageFilePath = mstorage.child(pickedImgUri.getLastPathSegment());
        imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
                    @Override
                    public void onSuccess(Uri uri){
                        UserProfileChangeRequest changeRequest = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .setPhotoUri(uri)
                                .build();
                        currentUser.updateProfile(changeRequest);
                    }
                });
            }
        });
    }
}