package com.example.kca_student_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.kca_student_app.ui.feedback.FeedbackFragment;

public class MainFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_feedback_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FeedbackFragment.newInstance())
                    .commitNow();
        }
    }
}