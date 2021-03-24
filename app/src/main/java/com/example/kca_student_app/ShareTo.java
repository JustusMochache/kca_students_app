package com.example.kca_student_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.kca_student_app.ui.share.ShareToFragment;

public class ShareTo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_to_activity);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ShareToFragment.newInstance())
                    .commitNow();
        }
    }
}