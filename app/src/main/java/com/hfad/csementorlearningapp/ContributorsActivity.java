package com.hfad.csementorlearningapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ContributorsActivity extends AppCompatActivity {

    private LinearLayout contributorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributors);

        // Initialize views
        contributorsContainer = findViewById(R.id.contributors_container);

        // Add contributors manually
        List<Contributor> contributors = getContributors();
        for (Contributor contributor : contributors) {
            addContributorToUI(contributor);
        }
    }

    private List<Contributor> getContributors() {
        // Manually define contributors' details
        List<Contributor> contributors = new ArrayList<>();
        contributors.add(new Contributor(R.drawable.jugalsir, "Dr. Jugal Krishna Das", "Professor", "jugalSir@juniv.edu"));
        contributors.add(new Contributor(R.drawable.imdadsir, "Dr. Md. Imdadul Islam", "Professor", "imdadSir@juniv.edu"));
        contributors.add(new Contributor(R.drawable.ezharsir, "Dr. Md. Ezharul Islam", "Professor", "ezharSir@juniv.edu"));
        contributors.add(new Contributor(R.drawable.mushfiquesir, "Dr. Md. Musfique Anwar", "Professor", "mushfiqueSir@juniv.edu"));
        contributors.add(new Contributor(R.drawable.rafsansir, "Md. Rafsan Jani", "Assistant Professor", "rafsanSir@juniv.edu"));
        contributors.add(new Contributor(R.drawable.naharmaam, "Samsun Nahar Khandakar", "Lecturer", "naharMaam@juniv.edu"));
        return contributors;
    }

    private void addContributorToUI(Contributor contributor) {
        // Inflate contributor item layout
        View contributorView = LayoutInflater.from(this).inflate(R.layout.item_contributor, contributorsContainer, false);

        // Get views
        ImageView contributorImage = contributorView.findViewById(R.id.contributor_image);
        TextView nameText = contributorView.findViewById(R.id.name_text);
        TextView designationText = contributorView.findViewById(R.id.designation_text);
        TextView contactText = contributorView.findViewById(R.id.contact_text);

        // Set data
        contributorImage.setImageResource(contributor.getImageResId());
        nameText.setText(contributor.getName());
        designationText.setText(contributor.getDesignation());
        contactText.setText(contributor.getContact());

        // Add to container
        contributorsContainer.addView(contributorView);
    }
}
