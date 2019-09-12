package com.example.jobtest.ui.flow.posts.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jobtest.R;
import com.example.jobtest.interfaces.IExecuteItemClick;
import com.example.jobtest.network.response.Entry;
import com.example.jobtest.ui.flow.posts.presenter.PostsPresenter;
import com.example.jobtest.ui.flow.posts.view.adapter.view_holders.PostViewHolder;
import com.example.jobtest.ui.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class PostsRecyclerAdapter extends RecyclerView.Adapter implements IExecuteItemClick {

    private final String VIDEO = "video";

    private List<Entry> mList;
    private IListener mPresenterListener;

    @Inject
    public PostsRecyclerAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view, viewType, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((PostViewHolder) holder).onBind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<Entry> postsList, PostsPresenter presenter) {
        this.mList = postsList;
        mPresenterListener = presenter;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).getType().getValue().equals(VIDEO)) {
            return Constants.VIDEO_TYPE;
        } else {
            return Constants.LINK_TYPE;
        }
    }

    @Override
    public void onItemClick(int position) {

        if(mList.get(position).getType().getValue().equals(VIDEO)){
            mPresenterListener.onPlayVideoClicked(mList.get(position));
        }else {
            mPresenterListener.onLinkClicked(mList.get(position).getLink().getHref());
        }
    }

    public void filterList(String newText, List<Entry> postsList) {

        List<Entry> filterList = new ArrayList<>();
        this.mList = postsList;

        if(mList != null){

            if(!newText.isEmpty()){

                newText = newText.toLowerCase();
                for (Entry obj: mList){

                    if (obj.getTitle().toLowerCase().contains(newText)){
                        filterList.add(obj);
                        setList(filterList);
                    }
                    boolean isFull = false;
                    if(filterList.size() > 0){
                        isFull = true;
                    }
                    mPresenterListener.filterFinish(isFull);
                }
            }else {
                setList(mList);
                mPresenterListener.filterFinish(true);
            }
            notifyDataSetChanged();
        }
    }

    private void setList(List<Entry> filterList) {
        mList = filterList;
    }

    public interface IListener{

        void onLinkClicked(String url);
        void onPlayVideoClicked(Entry entry);
        void filterFinish(boolean isFull);
    }
}
