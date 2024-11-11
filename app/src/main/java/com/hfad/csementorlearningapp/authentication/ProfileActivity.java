package com.hfad.csementorlearningapp.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hfad.csementorlearningapp.MainActivity;
import com.hfad.csementorlearningapp.R;

public class ProfileActivity extends AppCompatActivity {

    TextView name,email;
    ImageView userImage;
    Button logout;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name=findViewById(R.id.user_name);
        email=findViewById(R.id.user_email);
        userImage=findViewById(R.id.user_image);
        logout=findViewById(R.id.logout_btn);


        user= FirebaseAuth.getInstance().getCurrentUser();

        name.setText(user.getDisplayName());
        email.setText(user.getEmail());
        Glide.with(ProfileActivity.this).load(user.getPhotoUrl()).into(userImage);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}