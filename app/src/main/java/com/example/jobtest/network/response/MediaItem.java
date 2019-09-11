
package com.example.jobtest.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaItem {

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("key")
    @Expose
    private String key;

    //for links
    @SerializedName("scale")
    @Expose
    private String scale;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
