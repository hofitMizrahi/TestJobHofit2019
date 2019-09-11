
package com.example.jobtest.network.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("link")
    @Expose
    private Link link;
    @SerializedName("media_group")
    @Expose
    private List<MediaGroup> mediaGroup = null;
    @SerializedName("author")
    @Expose
    private Author author;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public List<MediaGroup> getMediaGroup() {
        return mediaGroup;
    }

    public void setMediaGroup(List<MediaGroup> mediaGroup) {
        this.mediaGroup = mediaGroup;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
