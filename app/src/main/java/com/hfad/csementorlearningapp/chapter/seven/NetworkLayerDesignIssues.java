package com.hfad.csementorlearningapp.chapter.seven;

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

public class NetworkLayerDesignIssues extends AppCompatActivity {
    private PDFView pdfView;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_network_layer_design_issues);
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
        storageReference = firebaseStorage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/csementorlearningapp.appspot.com/o/CourseDetailsPdf%2FCN%2FNetworkLayerDesignIssues.pdf?alt=media&token=4f8f7177-efb6-4e75-a69a-c742f2c54810");

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
                    Toast.makeText(NetworkLayerDesignIssues.this, "Failed to load PDF", Toast.LENGTH_SHORT).show();
                    Log.e("PDF_LOAD_ERROR", "Error loading PDF", exception);
                }
            });
        } catch (IOException e) {
            Toast.makeText(this, "Error creating temp file", Toast.LENGTH_SHORT).show();
            Log.e("TEMP_FILE_ERROR", "Error creating temp file for PDF", e);
        }
    }
}