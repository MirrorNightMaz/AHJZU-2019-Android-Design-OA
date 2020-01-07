package com.example.oa10.entity;

import java.util.List;

public class Inform {

    private List<AnnouncementBean> announcement;
    private List<NoticeBean> notice;

    public List<AnnouncementBean> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<AnnouncementBean> announcement) {
        this.announcement = announcement;
    }

    public List<NoticeBean> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeBean> notice) {
        this.notice = notice;
    }

    public static class AnnouncementBean {
        /**
         * anno_id : 88
         * anno_title : grfvdfv
         * anno_content : sdscdscdcdcdscdc
         * anno_time : 1.2
         */

        private int anno_id;
        private String anno_title;
        private String anno_content;
        private String anno_time;

        public int getAnno_id() {
            return anno_id;
        }

        public void setAnno_id(int anno_id) {
            this.anno_id = anno_id;
        }

        public String getAnno_title() {
            return anno_title;
        }

        public void setAnno_title(String anno_title) {
            this.anno_title = anno_title;
        }

        public String getAnno_content() {
            return anno_content;
        }

        public void setAnno_content(String anno_content) {
            this.anno_content = anno_content;
        }

        public String getAnno_time() {
            return anno_time;
        }

        public void setAnno_time(String anno_time) {
            this.anno_time = anno_time;
        }

        @Override
        public String toString() {
            return "AnnouncementBean{" +
                    "anno_id=" + anno_id +
                    ", anno_title='" + anno_title + '\'' +
                    ", anno_content='" + anno_content + '\'' +
                    ", anno_time='" + anno_time + '\'' +
                    '}';
        }
    }

    public static class NoticeBean {
        /**
         * notice_id : 88
         * notice_title : fbgbg
         * notice_content : gbfbgfbgfbgbgfb
         * notice_time : 1.4
         */

        private int notice_id;
        private String notice_title;
        private String notice_content;
        private String notice_time;

        public int getNotice_id() {
            return notice_id;
        }

        public void setNotice_id(int notice_id) {
            this.notice_id = notice_id;
        }

        public String getNotice_title() {
            return notice_title;
        }

        public void setNotice_title(String notice_title) {
            this.notice_title = notice_title;
        }

        public String getNotice_content() {
            return notice_content;
        }

        public void setNotice_content(String notice_content) {
            this.notice_content = notice_content;
        }

        public String getNotice_time() {
            return notice_time;
        }

        public void setNotice_time(String notice_time) {
            this.notice_time = notice_time;
        }

        @Override
        public String toString() {
            return "NoticeBean{" +
                    "notice_id=" + notice_id +
                    ", notice_title='" + notice_title + '\'' +
                    ", notice_content='" + notice_content + '\'' +
                    ", notice_time='" + notice_time + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Inform{" +
                "announcement=" + announcement +
                ", notice=" + notice +
                '}';
    }
}
