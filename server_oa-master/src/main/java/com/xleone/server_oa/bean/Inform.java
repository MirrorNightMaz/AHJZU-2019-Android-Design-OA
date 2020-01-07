package com.xleone.server_oa.bean;
import java.util.ArrayList;
import java.util.List;

public class Inform {
    List<AnnoEntity> announcement ;
    List<NoticeEntity> notice;

    public List<AnnoEntity> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<AnnoEntity> announcement) {
        this.announcement = announcement;
    }

    public List<NoticeEntity> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeEntity> notice) {
        this.notice = notice;
    }
}
