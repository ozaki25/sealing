package com.example.sealing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.sealing.entity.Request;

@Mapper
public interface RequestMapper {
    @Select("select * from request")
    List<Request> findAll();

    @Select("select * from request where id = #{id}")
    Request findOne(Long id);

    @Insert("insert into request (name, date, daily_request_id) values (#{name}, #{date}, #{dailyRequest.id})")
    @Options(useGeneratedKeys = true)
    void save(Request request);

    @Update("update request set name = #{name}, date = #{date}, daily_request_id = #{dailyRequest.id} where id = #{id}")
    void update(Request request);

    @Delete("delete from request where id = #{id}")
    void delete(Long id);
}
