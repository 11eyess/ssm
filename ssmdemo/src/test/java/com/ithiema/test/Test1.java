package com.ithiema.test;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {

    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void test1(){
        List<Student> studentList = studentMapper.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void test2(){
        System.out.println("just test");
    }

    @Test
    public void test3(){

        System.out.println("just test");
    }






    @Test
    public void test4(){

        System.out.println("just test");
    }
}
