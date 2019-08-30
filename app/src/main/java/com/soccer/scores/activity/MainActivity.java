package com.soccer.scores.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.soccer.scores.R;
import com.soccer.scores.databinding.ActivityMainBinding;
import com.soccer.scores.network.Client;
import com.soccer.scores.network.datamodel.Matches;
import com.soccer.scores.ui.adapters.MatchAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<Matches>{
    private MatchAdapter matchAdapter;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Client.getMachesList(this);
    }

    @Override
    public void onResponse(Call<Matches> call, Response<Matches> response) {
        matchAdapter = new MatchAdapter(response.body().getMatches());
        activityMainBinding.rvMatchesToday.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.rvMatchesToday.setAdapter(matchAdapter);
    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }
}
