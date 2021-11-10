package vn.edu.usth.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        Handler h = new Handler();

        h.postDelayed(new Runnable(){

            @Override
            public void run(){
                SplashActivity.this.startActivity(new Intent(SplashActivity.this,Welcome.class));
                finish();

            }}, 3000);
    }
}