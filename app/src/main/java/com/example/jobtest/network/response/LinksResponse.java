
package com.example.jobtest.network.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LinksResponse {

    @SerializedName("xmlns:applicaster")
    @Expose
    private String xmlnsApplicaster;
    @SerializedName("xmlns")
    @Expose
    private String xmlns;
    @SerializedName("xml:lang")
    @Expose
    private String xmlLang;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("link")
    @Expose
    private Link link;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("entry")
    @Expose
    private List<Entry> entry = null;
    @SerializedName("type")
    @Expose
    private Type type;

    public String getXmlnsApplicaster() {
        return xmlnsApplicaster;
    }

    public void setXmlnsApplicaster(String xmlnsApplicaster) {
        this.xmlnsApplicaster = xmlnsApplicaster;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getXmlLang() {
        return xmlLang;
    }

    public void setXmlLang(String xmlLang) {
        this.xmlLang = xmlLang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
