package com.soccer.scores.ui.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.soccer.scores.R;
import com.soccer.scores.databinding.ItemMatchBinding;
import com.soccer.scores.datamodel.TeamResouce;
import com.soccer.scores.network.datamodel.Match;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter {

    private List<Match> items;

    public MatchAdapter(List<Match> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMatchBinding itemMatchBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_match, parent, false);
        return new ItemViewHolder(itemMatchBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        Match item = items.get(position);
        itemViewHolder.refreshCountryItem(item, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ItemMatchBinding itemMatchBinding;
        private Match item;

        public ItemViewHolder(ItemMatchBinding itemMatchBinding) {
            super(itemMatchBinding.getRoot());
            this.itemMatchBinding = itemMatchBinding;
        }

        public void refreshCountryItem(Match matchTableItem, int position) {
            this.item = matchTableItem;
            itemMatchBinding.twMatchName.setText(item.getHomeTeam().getName() + " VS " + item.getAwayTeam().getName());
            try {

                itemMatchBinding.ivFirstimage.setImageResource(TeamResouce.valueOf("_" + item.getHomeTeam().getId()).getResourceId());
                itemMatchBinding.ivLastimage.setImageResource(TeamResouce.valueOf("_" + item.getAwayTeam().getId()).getResourceId());

            } catch (Exception e) {
                Log.d("FAIL", e.getMessage());
            }

        }
    }

}


