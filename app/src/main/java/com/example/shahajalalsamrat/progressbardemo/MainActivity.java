package com.example.shahajalalsamrat.progressbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    int progress;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //Remove title bar

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );


        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressbarid);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
            }
        });
        thread.start();
    }

    public void dowork() {


        for (progress = 20; progress <=100; progress = progress + 20) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
