package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdepter extends FragmentPagerAdapter {
    public ViewPagerMessengerAdepter(@NonNull FragmentManager fm) {

        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        if(position==0)
            return new HomeFragment();
        else if (position==1)
            return new PreparationFragment();
        else
            return new QuizFragment();

    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Home";
        else if (position==1)
            return "Signs ";
        else
            return "Quiz";
    }

}
