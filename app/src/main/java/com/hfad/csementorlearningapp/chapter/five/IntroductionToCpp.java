package com.hfad.csementorlearningapp.chapter.five;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hfad.csementorlearningapp.R;
import com.hfad.csementorlearningapp.chapter.one.ArrayOperations;
import com.joanzapata.pdfview.PDFView;

import java.io.File;
import java.io.IOException;

public class IntroductionToCpp extends AppCompatActivity {
    private PDFView pdfView;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_introduction_to_cpp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pdfView = findViewById(R.id.pdfview);
        firebaseStorage = FirebaseStorage.getInstance();

        loadPdfFromFirebase();
    }
    private void loadPdfFromFirebase() {
        // Adjust the path to your PDF file in Firebase Storage
        storageReference = firebaseStorage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/CourseDetailsPdf%2FC%2B%2B%2FBasicsofC%2B%2B.pdf?alt=media&token=44ccb8fd-00d8-4a65-9bf9-09d25c1ab54d");

        try {
            File localFile = File.createTempFile("temp_pdf", ".pdf");
            storageReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    pdfView.fromFile(localFile).load();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText(IntroductionToCpp.this, "Failed to load PDF", Toast.LENGTH_SHORT).show();
                    Log.e("PDF_LOAD_ERROR", "Error loading PDF", exception);
                }
            });
        } catch (IOException e) {
            Toast.makeText(this, "Error creating temp file", Toast.LENGTH_SHORT).show();
            Log.e("TEMP_FILE_ERROR", "Error creating temp file for PDF", e);
        }
    }
}