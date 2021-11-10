package vn.edu.usth.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import vn.edu.usth.twitter.databinding.ActivityNotifsBinding;
import vn.edu.usth.twitter.databinding.ActivityTweetUploadBinding;

public class TweetUpload extends AppCompatActivity {
    private ActivityTweetUploadBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTweetUploadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cancel.setOnClickListener(view -> startActivity(new Intent(TweetUpload.this, DmsActivity.class)));
    }
}