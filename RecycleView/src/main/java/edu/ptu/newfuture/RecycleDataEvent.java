package edu.ptu.newfuture;

import org.json.JSONObject;

/**
 * Created by WangAnshu on 2016/3/2.
 */
public class RecycleDataEvent {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String desc;
    private String imgUrl;

}
