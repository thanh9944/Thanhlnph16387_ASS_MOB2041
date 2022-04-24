package com.nhatthanh.thanhlnph16387_ass_mob2041;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ChaoActivity extends AppCompatActivity {
     ProgressBar progressBar;
     TextView textView;
     Handler handler = new Handler();
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao);
        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.tv_chay);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startProgress();
                startActivity(new Intent(ChaoActivity.this, LoginActivity.class));
            }
        });
        thread.start();
    }

    public void startProgress() {
        for (i = 0; i < 100; i = i + 1) {
            try {
                Thread.sleep(50);
                progressBar.setProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(i + "%");
                }
            });
        }

    }
}