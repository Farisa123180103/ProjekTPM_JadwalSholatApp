package com.example.jadwalsholat.view.activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.jadwalsholat.R;


public class SplshScreenActivity extends AppCompatActivity{
    TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.splashscreen);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 2000L); //3000 L = 3 detik
    }
}
