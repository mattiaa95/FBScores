package com.soccer.scores.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.soccer.scores.R;
import com.soccer.scores.databinding.FragmentMatchdayresultfragmentBinding;
import com.soccer.scores.network.Client;
import com.soccer.scores.network.datamodel.Matches;
import com.soccer.scores.ui.adapters.MatchAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDayResultFragment extends BaseFragment implements Callback<Matches> {

    private MatchAdapter matchAdapter;
    private FragmentMatchdayresultfragmentBinding fragmentMatchdayresultfragmentBinding;

    public static MatchDayResultFragment newInstance() {
        return new MatchDayResultFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentMatchdayresultfragmentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_matchdayresultfragment,container,false);
        return fragmentMatchdayresultfragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Client.getMatchesList(this, "2019-09-01","2019-09-10");
    }

    @Override
    public void onResponse(Call<Matches> call, Response<Matches> response) {
        matchAdapter = new MatchAdapter(response.body().getMatches());
        fragmentMatchdayresultfragmentBinding.rvMatchesToday.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentMatchdayresultfragmentBinding.rvMatchesToday.setAdapter(matchAdapter);
    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }

    @Override
    public String getTagName() {
        return "MatchDay";
    }

    @Override
    public String getTitleName() {
        return this.getString(R.string.match_day_title);
    }
}
