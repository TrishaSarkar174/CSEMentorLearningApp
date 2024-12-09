package com.hfad.csementorlearningapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hfad.csementorlearningapp.authentication.LoginActivity;
import com.hfad.csementorlearningapp.authentication.ProfileActivity;
import com.hfad.csementorlearningapp.leaderboard.LeaderboardActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    FirebaseUser user;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Check theme mode from shared preferences
        preferences = getSharedPreferences("AppTheme", MODE_PRIVATE);
        boolean isNightMode = preferences.getBoolean("NightMode", false);
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.my_drawer);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null); // Programmatically disable tint


        // Setup ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        // BottomNavigationView setup
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this, R.id.main_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.profile) {
            if (user != null) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            } else {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.leaderboard) {
            startActivity(new Intent(MainActivity.this, LeaderboardActivity.class));
        } else if (itemId == R.id.DaylightMode) {
            toggleDaylightMode();
        } else if (itemId == R.id.share) {
            shareApp();
        } else if (itemId == R.id.rate) {
            showRatingDialog();
        } else if (itemId == R.id.about) {
            sendEmail();
        } else if (itemId == R.id.contributors) {
            startActivity(new Intent(MainActivity.this, ContributorsActivity.class));
        }


        // Close drawer after selection
        drawerLayout.closeDrawers();
        return true;
    }

//    private void showContributors() {
//        // For now, we can simply show a Toast message with the contributors.
//        // You can modify this to navigate to a new activity with contributors details if needed.
//
//        String contributors = "1. John Doe - Lead Developer\n2. Jane Smith - UI/UX Designer\n3. Michael Johnson - Backend Developer";
//
//        // Show contributors in a dialog or Toast
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Contributors")
//                .setMessage(contributors)
//                .setPositiveButton("OK", null)
//                .show();
//    }


    private void shareApp() {
        String shareMessage = "Check out the CSEmentor Learning App! It's a fantastic tool for students. Download it here: " +
                "https://play.google.com/store/apps/details?id=" + getPackageName();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "CSEmentor Learning App");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

        try {
            startActivity(Intent.createChooser(shareIntent, "Share App via"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No sharing apps installed.", Toast.LENGTH_SHORT).show();
        }
    }


    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(android.net.Uri.parse("mailto:")); // Only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jucse29.359@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact via CSEmentor App");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi, I wanted to discuss..."); // Default email body

        try {
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }


    private void toggleDaylightMode() {
        boolean isNightMode = preferences.getBoolean("NightMode", false);
        SharedPreferences.Editor editor = preferences.edit();

        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            editor.putBoolean("NightMode", false);
            Toast.makeText(this, "Switched to Day Mode", Toast.LENGTH_SHORT).show();
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            editor.putBoolean("NightMode", true);
            Toast.makeText(this, "Switched to Night Mode", Toast.LENGTH_SHORT).show();
        }
        editor.apply();
    }

    private void showRatingDialog() {
        final int[] userRating = {0};
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Rate Us")
                .setIcon(R.drawable.rating)
                .setSingleChoiceItems(new String[]{"⭐", "⭐⭐", "⭐⭐⭐", "⭐⭐⭐⭐", "⭐⭐⭐⭐⭐"}, -1, (dialog, which) -> userRating[0] = which + 1)
                .setPositiveButton("Submit", (dialog, which) -> {
                    if (userRating[0] > 0) {
                        Toast.makeText(this, "Thank you for " + userRating[0] + " stars! 😊", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "Please select a rating! 😊", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
