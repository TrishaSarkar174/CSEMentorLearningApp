package com.hfad.csementorlearningapp.ui.code;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hfad.csementorlearningapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class CodeFragment extends Fragment {

    private RecyclerView chapterRecyclerView;
    private ChapterAdapter chapterAdapter;
    private ArrayList<Chapter> chapterList = new ArrayList<>();

    // Manual YouTube URLs
    private final HashMap<String, String> chapterVideoUrls = new HashMap<String, String>() {{
        put("Database System", "https://www.youtube.com/embed/pFq1pgli0OQ?si=jBSYU5xZdIBNZoSp");
        put("Algorithm", "https://www.youtube.com/embed/cuhLSGGV-1k?si=D7gDsQ3pQrVQg2ra");
        put("Data Structure", "https://www.youtube.com/embed/27PdRL89A9U?si=MHRRd3LcNmbrz1Zj");
        put("C", "https://www.youtube.com/embed/rLf3jnHxSmU?si=mVcSvEVfFdOwRcTs");
        put("C++", "https://www.youtube.com/embed/McojvctVsUs?si=g4s3NYgoAFK7oTss");
        put("Java", "https://www.youtube.com/embed/i6AZdFxTK9I?si=8cjWdqXJsGmqK555");
        put("Wireless Network", "https://www.youtube.com/embed/60zAe27su_E?si=vSbCV41uQQ39vyXk");
        put("Computer Network", "https://www.youtube.com/embed/VwN91x5i25g?si=uF_ttHS8wx40Fka6");
        put("Digital Image Processing", "https://www.youtube.com/embed/xUCsfKA8bi0?si=8KlcMYwG2rh5Iul-");
        put("EDC", "https://www.youtube.com/embed/s3vpH3A_eTA?si=-Mgbp35I90aRSmPY");
        put("Microprocessor", "https://www.youtube.com/embed/Gyel_XQTKN0?si=gfANpWClBvhKx-CJ");
        put("Discrete Math", "https://www.youtube.com/embed/p2b2Vb-cYCs?si=1bw2RuItK5VyamfD");
    }};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code, container, false);

        // Initialize RecyclerView here
        chapterRecyclerView = view.findViewById(R.id.chapterRecyclerView);
        chapterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        chapterAdapter = new ChapterAdapter(chapterList, this::openChapterActivity);
        chapterRecyclerView.setAdapter(chapterAdapter);

        loadChaptersFromFirebase();

        return view;
    }

    private void loadChaptersFromFirebase() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference().child("chapters/");

        // Assume we know the chapters (can be dynamic if fetched from another source)
        String[] chapterNames = {"Database System", "Algorithm", "Data Structure", "C", "C++", "Java", "Wireless Network", "Computer Network", "Digital Image Processing", "EDC", "Microprocessor", "Discrete Math"};

        for (String chapterName : chapterNames) {
            storageReference.child(chapterName.toLowerCase().replace(" ", "_") + ".png")
                    .getDownloadUrl()
                    .addOnSuccessListener(uri -> {
                        chapterList.add(new Chapter(chapterName, uri.toString()));
                        // Notify adapter after data is added
                        chapterAdapter.notifyItemInserted(chapterList.size() - 1);
                    })
                    .addOnFailureListener(exception -> {
                        // Handle failure to fetch image URL
                    });
        }
    }

    private void openChapterActivity(Chapter chapter) {
        String chapterName = chapter.getName();
        String videoUrl = chapterVideoUrls.get(chapterName); // Fetch YouTube URL for selected chapter

        Intent intent = new Intent(getActivity(), ChapterActivity.class);
        intent.putExtra("chapterName", chapterName);
        intent.putExtra("videoUrl", videoUrl); // Pass video URL to ChapterActivity
        startActivity(intent);
    }
}
