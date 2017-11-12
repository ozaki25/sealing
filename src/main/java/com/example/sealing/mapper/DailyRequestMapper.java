package com.example.sealing.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.sealing.entity.DailyRequest;

@Mapper
public interface DailyRequestMapper {
    @Select("select * from daily_request")
    List<DailyRequest> findAll();

    @Select("select * from daily_request where id = #{id}")
    DailyRequest findOne(Long id);

    @Select("select * from daily_request where date = #{date}")
    DailyRequest findByDate(Date date);

    @Insert("insert into daily_request (date, status_type) values (#{date}, #{statusType})")
    @Options(useGeneratedKeys = true)
    void save(DailyRequest dailyRequest);

    @Update("update daily_request set date = #{date}, status_type = #{statusType} where id = #{id}")
    void update(DailyRequest dailyRequest);

    @Update("update daily_request set status_type = #{statusType} where id = #{id}")
    void updateStatus(Long id, Integer statusType);

    @Delete("delete from daily_request where id = #{id}")
    void delete(Long id);
}
