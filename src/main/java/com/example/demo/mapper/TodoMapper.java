package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.model.Todo;

@Mapper
public interface TodoMapper {

    @Insert("INSERT INTO todo (title, details, finished) VALUES (#{title}, #{details}, #{finished})")
    @Options(useGeneratedKeys = true)
    void insert(Todo todo);

    @Select("SELECT id, title, details, finished FROM todo WHERE id = #{id}")
    Todo selectByPrimary(int id);

    @Select("SELECT id, title, details, finished FROM todo")
    List<Todo> selectAll();

    @Update("UPDATE todo SET title = #{title}, details = #{details}, finished = #{finished} WHERE id = #{id}")
    void update(Todo todo);
}
