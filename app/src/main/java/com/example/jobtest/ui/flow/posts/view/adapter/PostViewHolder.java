package com.example.jobtest.ui.flow.posts.view.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(){

    }
}
