package vn.edu.usth.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import vn.edu.usth.twitter.databinding.ActivityDmsBinding;
import vn.edu.usth.twitter.databinding.ActivityHomeBinding;

public class DmsActivity extends AppCompatActivity {
    private ActivityDmsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDmsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DmsActivity.this, LogIn.class));
            }
        });

        binding.viewpro5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DmsActivity.this, ProfileActivity.class));
            }
        });
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DmsActivity.this, LogIn.class));
            }
        });

        binding.fabCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DmsActivity.this, TweetUpload.class));
            }
        });
    }
}