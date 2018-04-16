package com.demo.zhihu.bean;

import java.util.List;

/**
 * Created by xnn on 2018/4/15.
 */

public class HomeBean {

    public List<HomeBean.data> getData() {
        return data;
    }

    public void setData(List<HomeBean.data> data) {
        this.data = data;
    }

    public List<data> data;

    public static  class data{
        public int id;
        public String title;
        public String author;
        public String press;
        public String publishTime;
        public String introduction;
        public String coverImage;
        public String remark;
        public String page;
        public String size;
        public String start;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPress() {
            return press;
        }

        public void setPress(String press) {
            this.press = press;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }
    }
}
