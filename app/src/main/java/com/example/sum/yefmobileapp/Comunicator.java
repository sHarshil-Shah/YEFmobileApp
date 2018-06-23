package com.example.sum.yefmobileapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Comunicator extends FragmentPagerAdapter {
    public Comunicator(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new general();
            case 1:
                return new skills();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
