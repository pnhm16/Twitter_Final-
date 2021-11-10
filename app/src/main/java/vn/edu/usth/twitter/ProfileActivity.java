package vn.edu.usth.twitter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.twitter.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TweetsFragment tweetsFragment = new TweetsFragment();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_search:
                        startActivity(new Intent(getApplicationContext()
                                , SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_notifs:
                        startActivity(new Intent(getApplicationContext()
                                , NotifsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_dms:
                        startActivity(new Intent(getApplicationContext()
                                , DmsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        return true;

                }
                return false;
            }
        });

        tabLayout = findViewById(R.id.tabs_layout);
        viewPager2 = findViewById(R.id.view_pager);
        FragmentManager fm = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Tweets"));
        tabLayout.addTab(tabLayout.newTab().setText("ReTweets"));
        tabLayout.addTab(tabLayout.newTab().setText("Liked"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        binding.fabCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, TweetUpload.class));
            }
        });
        //config action bar
//        actionBar = getSupportActionBar();
//        actionBar.setTitle("Profile");
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);
//        //init firebaseAuth
//        firebaseAuth = FirebaseAuth.getInstance();
//        checkUser();

        //logout


//    private void checkUser() {
//        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//        if (firebaseUser == null) {
//            //user not logged in
//            startActivity(new Intent(this, LoginActivity.class));
//            finish();
//        }
//        else {
//            //logged in, get info
//            String email = firebaseUser.getEmail();
//            Toast.makeText(ProfileActivity.this, "Account Created\n" + email, Toast.LENGTH_SHORT).show();
//            binding.emailTv.setText(email);
//        }
    }
}