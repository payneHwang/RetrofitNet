package com.remote.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huang_jin on 2017/10/27.
 */

public class Beauty implements Parcelable {
    private String _id;
    private String createAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;


    protected Beauty(Parcel in) {
        _id = in.readString();
        createAt = in.readString();
        desc = in.readString();
        publishedAt = in.readString();
        source = in.readString();
        type = in.readString();
        url = in.readString();
        who = in.readString();
        used = in.readInt() == 0;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "Beauty{" +
                "_id='" + _id + '\'' +
                ", createAt='" + createAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //写进缓存的Parcel对象容器中
        parcel.writeString(_id);
        parcel.writeString(createAt);
        parcel.writeString(desc);
        parcel.writeString(publishedAt);
        parcel.writeString(source);
        parcel.writeString(type);
        parcel.writeString(url);
        parcel.writeString(who);
        parcel.writeInt(used ? 1 : 0);
    }

    public static final Creator<Beauty> CREATOR = new Creator<Beauty>() {
        @Override
        public Beauty createFromParcel(Parcel in) {
            return new Beauty(in);
        }

        @Override
        public Beauty[] newArray(int size) {
            return new Beauty[size];
        }
    };
}
