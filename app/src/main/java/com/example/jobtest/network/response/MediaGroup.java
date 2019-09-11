
package com.example.jobtest.network.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaGroup {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("media_item")
    @Expose
    private List<MediaItem> mediaItem = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MediaItem> getMediaItem() {
        return mediaItem;
    }

    public void setMediaItem(List<MediaItem> mediaItem) {
        this.mediaItem = mediaItem;
    }

}
