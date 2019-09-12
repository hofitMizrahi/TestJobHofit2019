package com.example.jobtest.ui.flow.posts.view.adapter.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobtest.R;
import com.example.jobtest.network.response.Entry;
import com.example.jobtest.ui.utils.Utils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.root)
    View mRoot;

    @BindView(R.id.title)
    TextView mTitle;

    @BindView(R.id.summery)
    TextView mSummery;

    @BindView(R.id.base_image)
    ImageView mBaseImage;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(Entry entry){

        if(entry != null) {
            mTitle.setText(entry.getTitle());
            mSummery.setText(entry.getSummary());

            if(Utils.isListFull(entry.getMediaGroup()) && entry.getMediaGroup().get(0) != null
                    && Utils.isListFull(entry.getMediaGroup().get(0).getMediaItem())
                    && entry.getMediaGroup().get(0).getMediaItem().get(0) != null
                    && !entry.getMediaGroup().get(0).getMediaItem().get(0).getSrc().isEmpty()){

                Picasso.get().load(entry.getMediaGroup().get(0).getMediaItem().get(0).getSrc()).into(mBaseImage);
            }
        }
    }
}
