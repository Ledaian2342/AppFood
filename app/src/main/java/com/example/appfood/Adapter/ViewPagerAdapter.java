package com.example.appfood.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.appfood.Fragment.Fragment_Cart_Activity;
import com.example.appfood.Fragment.Fragment_Detail_Activity;
import com.example.appfood.Fragment.Fragment_Home_Activity;
import com.example.appfood.Fragment.Fragment_Profile_Activity;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_Home_Activity();
            case 1:
                return new Fragment_Detail_Activity();
            case 2:
                return new Fragment_Cart_Activity();
            case 3:
                return new Fragment_Profile_Activity();
            default:
                return new Fragment_Home_Activity();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
