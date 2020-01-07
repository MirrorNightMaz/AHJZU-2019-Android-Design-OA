package com.example.oa10.entity;

import java.util.List;

public class Schedule {


    private List<ScheduleBean> schedule;

    public List<ScheduleBean> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<ScheduleBean> schedule) {
        this.schedule = schedule;
    }

    public static class ScheduleBean {
        /**
         * sche_id : 777
         * sche_time : 2019-01-04 06:50:22
         * sche_content : vvvvvvvvbbddd
         * user_id : 123
         */

        private int sche_id;
        private String sche_time;
        private String sche_content;
        private String user_id;

        public int getSche_id() {
            return sche_id;
        }

        public void setSche_id(int sche_id) {
            this.sche_id = sche_id;
        }

        public String getSche_time() {
            return sche_time;
        }

        public void setSche_time(String sche_time) {
            this.sche_time = sche_time;
        }

        public String getSche_content() {
            return sche_content;
        }

        public void setSche_content(String sche_content) {
            this.sche_content = sche_content;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
