package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select * from t_student")
    public List<Student> findAll();

    @Insert("insert into t_student  values(#{id},#{name},#{sex},#{age},#{address})")
    public void save(Student student);

    @Select("select * from  t_student where id = #{id}")
    public Student findById(int id);

    @Update("update t_student set name=#{name},sex=#{sex},age=#{age},address=#{address} where id=#{id}")
    public void update(Student student);

    @Delete("delete from  t_student where id=#{id}")
    public void delete(int id);
}
