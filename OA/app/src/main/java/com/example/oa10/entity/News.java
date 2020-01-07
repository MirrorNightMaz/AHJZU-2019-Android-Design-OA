package com.example.oa10.entity;

import java.util.List;

public class News {


    private List<NewsBean> news;    //<>中指定了列表的泛型

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public static class NewsBean {
        /**
         * news_id : 77
         * news_title : 美方代表团将于1月7日至8日访华
         * news_content : 【环球网综合报道】2019年1月4日外交部发言人陆慷主持例行记者会，有记者问道， 我们注意到中国商务部新闻发言人今天上午表示，美方代表团将于1月7日至8日访华进行经贸磋商。你能否证实?
         * news_time : 2019-01-04 17:55
         * news_icon : http://5b0988e595225.cdn.sohucs.com/images/20190104/9e3177f41c04480385986075eb0c872f.jpeg
         */

        private int news_id;
        private String news_title;
        private String news_content;
        private String news_time;
        private String news_icon;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_content() {
            return news_content;
        }

        public void setNews_content(String news_content) {
            this.news_content = news_content;
        }

        public String getNews_time() {
            return news_time;
        }

        public void setNews_time(String news_time) {
            this.news_time = news_time;
        }

        public String getNews_icon() {
            return news_icon;
        }

        public void setNews_icon(String news_icon) {
            this.news_icon = news_icon;
        }
    }
}
