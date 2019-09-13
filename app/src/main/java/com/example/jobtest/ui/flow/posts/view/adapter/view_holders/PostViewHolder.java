package com.example.jobtest.ui.flow.posts.view.adapter.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobtest.R;
import com.example.jobtest.interfaces.IExecuteItemClick;
import com.example.jobtest.network.response.Entry;
import com.example.jobtest.ui.flow.posts.view.adapter.PostsRecyclerAdapter;
import com.example.jobtest.ui.utils.Constants;
import com.example.jobtest.ui.utils.Utils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private boolean mIsVideoType;
    private IExecuteItemClick mListener;

    @BindView(R.id.play_video_btn)
    View mPlayVideoBtn;

    @BindView(R.id.title)
    TextView mTitle;

    @BindView(R.id.summery)
    TextView mSummery;

    @BindView(R.id.base_image)
    ImageView mBaseImage;

    @OnClick(R.id.root)
    void onRootClicked(){
        mListener.onItemClick(getAdapterPosition(), mIsVideoType);
    }

    public PostViewHolder(@NonNull View itemView, int viewType, PostsRecyclerAdapter adapter) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mListener = adapter;

        if(viewType == Constants.VIDEO_TYPE)
            mIsVideoType = true;
    }

    public void onBind(Entry entry){

        if(mIsVideoType){
            mPlayVideoBtn.setVisibility(View.VISIBLE);
        }else{
            mPlayVideoBtn.setVisibility(View.GONE);
        }

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
