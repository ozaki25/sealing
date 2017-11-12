package com.example.sealing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.sealing.entity.Player;

@Mapper
public interface PlayerMapper {
    @Select("select * from player")
    List<Player> findAll();

    @Select("select * from player where id = #{id}")
    Player findOne(Long id);

    @Select("select * from player where user_id = #{userId}")
    Player findByUserId(String userId);

    @Insert("insert into player (name, user_id, password, role_type) values (#{name}, #{userId}, #{password}, #{roleType})")
    @Options(useGeneratedKeys = true)
    void save(Player player);

    @Update("update player set name = #{name}, user_id = #{userId}, password = #{password}, role_type = #{roleType} where id = #{id}")
    void update(Player player);

    @Update("update player set password = #{password} where user_id = #{userId}")
    void updatePassword(@Param("userId") String userId, @Param("password") String password);

    @Delete("delete from player where id = #{id}")
    void delete(Long id);
}
