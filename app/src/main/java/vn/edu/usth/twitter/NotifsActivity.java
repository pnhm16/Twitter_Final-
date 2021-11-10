package vn.edu.usth.twitter;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import vn.edu.usth.twitter.databinding.ActivityNotifsBinding;


public class NotifsActivity extends AppCompatActivity {
    private ActivityNotifsBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapterNotif fragmentAdapterNotif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotifsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.logout.setOnClickListener(view -> startActivity(new Intent(NotifsActivity.this, LogIn.class)));
        AllFragment allFragment = new AllFragment();

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
                                ,SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_dms:
                        startActivity(new Intent(getApplicationContext()
                                , DmsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_profile:
                        startActivity(new Intent(getApplicationContext()
                                , ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        return true;

                }
                return false;
            }
        });

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotifsActivity.this, LogIn.class));
            }
        });

        binding.viewpro5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotifsActivity.this, ProfileActivity.class));
            }
        });
        tabLayout = findViewById(R.id.tabs_notif_layout);
        viewPager2 = findViewById(R.id.view_notif_pager);
        FragmentManager fm = getSupportFragmentManager();
        fragmentAdapterNotif = new FragmentAdapterNotif(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapterNotif);

        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Mentions"));

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


    }



}