package com.soccer.scores.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.soccer.scores.R;
import com.soccer.scores.databinding.ActivityMainBinding;
import com.soccer.scores.fragment.BaseFragment;
import com.soccer.scores.fragment.MatchDayResultFragment;
import com.soccer.scores.ui.adapters.BaseFragmentTabAdapter;
import com.soccer.scores.ui.adapters.MatchAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private MatchAdapter matchAdapter;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initData();
    }

    private void initData() {
        List<BaseFragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();


            fragments.add(MatchDayResultFragment.newInstance());
            titles.add(getString(R.string.match_day_title));


        activityMainBinding.vpMain.setAdapter(new BaseFragmentTabAdapter(getSupportFragmentManager(), fragments,titles));
        activityMainBinding.tlMain.setupWithViewPager(activityMainBinding.vpMain);

        TabLayout.Tab tab = activityMainBinding.tlMain.getTabAt(0);
        tab.select();

    }

}
