package com.example.kca_student_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kca_student_app.ui.website.WebsiteLinkFragment;

public class WebsiteLink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website_fragment);




        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, WebsiteLinkFragment.newInstance())
                    .commitNow();
        }
    }
}