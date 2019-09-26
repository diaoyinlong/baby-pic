package com.diao.home.qiqi;

/**
 * QiModel
 */
public class QiPicModel {

    private Integer id;
    private Integer categoryId;
    private String picName;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getThumbPicName() {
        return "thumbnail."+picName;
    }
}