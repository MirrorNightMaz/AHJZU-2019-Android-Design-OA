package com.xleone.server_oa.mapper;
import com.xleone.server_oa.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface MainMapper {
    @Select("select * from news")
    public List<NewsEntity> getAllNews();
    @Select("select * from announcement")
    public List<AnnoEntity> getAnno();

    @Select("select * from notice")
    public List<NoticeEntity> getNotice();
    @Select("select * from admin where user_name=#{admin.user_name} and user_pass=#{admin.user_pass}")
    public admin login(@Param(value = "admin") admin admin);
    @Select("select * from schedule where 1=1 and date_format(sche_time,'%Y-%m-%d')=#{date} and user_id=#{user_id}")
     public List<ScheEntity> getNewSche(@Param("date") String date,@Param("user_id") String user_id);

    @Select("select * from schedule where 1=1 and date_format(sche_time,'%Y-%m-%d')>#{date} and user_id=#{user_id}")
    public List<ScheEntity> getTomSche(@Param("date")String date,@Param("user_id") String user_id);

    @Select("select * from schedule where 1=1 and date_format(sche_time,'%Y-%m-%d')<#{date} and user_id=#{user_id}")//  1 = 1 ????
    public List<ScheEntity> getOldSche(@Param("date")String date,@Param("user_id") String user_id);
}
