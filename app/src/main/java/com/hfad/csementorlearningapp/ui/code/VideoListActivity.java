//package com.hfad.csementorlearningapp.ui.code;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.ListResult;
//import com.google.firebase.storage.StorageReference;
//import com.hfad.csementorlearningapp.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VideoListActivity extends AppCompatActivity {
//
//    private RecyclerView videoRecyclerView;
//    private VideoAdapter videoAdapter;
//    private List<String> videoUrls = new ArrayList<>();
//    private FirebaseStorage storage;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_video_list);
//
//        videoRecyclerView = findViewById(R.id.videoRecyclerView);
//        videoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        videoAdapter = new VideoAdapter(videoUrls);
//        videoRecyclerView.setAdapter(videoAdapter);
//
//        storage = FirebaseStorage.getInstance();
//
//        String courseType = getIntent().getStringExtra("COURSE_TYPE");
//        if (courseType != null) {
//            loadVideos(courseType);
//        }
//    }
//
//    private void loadVideos(String courseType) {
//        // Firebase Storage reference
//        StorageReference videosRef = storage.getReference().child("chapters/" + courseType + "/videos/");
//
//        videosRef.listAll().addOnSuccessListener(listResult -> {
//            for (StorageReference fileRef : listResult.getItems()) {
//                fileRef.getDownloadUrl().addOnSuccessListener(uri -> {
//                    videoUrls.add(uri.toString());
//                    videoAdapter.notifyDataSetChanged();
//                });
//            }
//        });
//    }
//}
