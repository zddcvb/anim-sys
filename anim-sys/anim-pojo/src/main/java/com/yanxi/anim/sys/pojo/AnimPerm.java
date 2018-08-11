package com.yanxi.anim.sys.pojo;

public class AnimPerm {
    private String permId;

    private String permUrl;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }

    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl == null ? null : permUrl.trim();
    }
}