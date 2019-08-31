package com.soccer.scores.ui.adapters;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.soccer.scores.fragment.BaseFragment;

public class BaseFragmentTabAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;
    private List<String> titles;

    public BaseFragmentTabAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
        super(fm);
        mFragments = fragments;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public BaseFragment getItem(int position) {
        return mFragments.get(position);
    }
}