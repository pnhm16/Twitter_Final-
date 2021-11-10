package vn.edu.usth.twitter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapterNotif extends FragmentStateAdapter {

    public FragmentAdapterNotif(@NonNull FragmentManager fragmentManagerNotif, @NonNull Lifecycle lifecycle) {
        super(fragmentManagerNotif, lifecycle);
    }


//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        switch (position) {
//            case 1:
//                return new HomeFragment();
//            case 2:
//                return new SearchFragment();
//            case 3:
//                return new DmsFragment();
//        }
//        return new HomeFragment();
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new AllFragment();

        }
        return new MentionsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
