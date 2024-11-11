package com.hfad.csementorlearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener{

    ImageView imageView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView splashLogo = findViewById(R.id.splash_logo);
        Animation zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        splashLogo.startAnimation(zoomIn);

        //imageView =findViewById(R.id.splash_logo);
        //animation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.splash_anime);
        //animation.setAnimationListener(this);
        //imageView.startAnimation(animation);

       Handler handler =new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent=new Intent(SplashScreen.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
       }, 2000);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}