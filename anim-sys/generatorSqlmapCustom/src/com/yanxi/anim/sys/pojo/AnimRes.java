package com.yanxi.anim.sys.pojo;

public class AnimRes {
    private String resId;

    private String resName;

    private String resUrl;

    private String resSize;

    private String resCreatetime;

    private String resUpdatetime;

    private Boolean isdeleted;

    private String resCatagortyId;

    private String resReviewUrl;

    private String resViewUrl;

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl == null ? null : resUrl.trim();
    }

    public String getResSize() {
        return resSize;
    }

    public void setResSize(String resSize) {
        this.resSize = resSize == null ? null : resSize.trim();
    }

    public String getResCreatetime() {
        return resCreatetime;
    }

    public void setResCreatetime(String resCreatetime) {
        this.resCreatetime = resCreatetime == null ? null : resCreatetime.trim();
    }

    public String getResUpdatetime() {
        return resUpdatetime;
    }

    public void setResUpdatetime(String resUpdatetime) {
        this.resUpdatetime = resUpdatetime == null ? null : resUpdatetime.trim();
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getResCatagortyId() {
        return resCatagortyId;
    }

    public void setResCatagortyId(String resCatagortyId) {
        this.resCatagortyId = resCatagortyId == null ? null : resCatagortyId.trim();
    }

    public String getResReviewUrl() {
        return resReviewUrl;
    }

    public void setResReviewUrl(String resReviewUrl) {
        this.resReviewUrl = resReviewUrl == null ? null : resReviewUrl.trim();
    }

    public String getResViewUrl() {
        return resViewUrl;
    }

    public void setResViewUrl(String resViewUrl) {
        this.resViewUrl = resViewUrl == null ? null : resViewUrl.trim();
    }
}