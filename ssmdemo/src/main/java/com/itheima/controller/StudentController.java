package com.itheima.controller;


import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.findAll();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("save")
    public String  save(Student student){
        studentService.save(student);
        return "redirect:/student/findAll";
    }

    @RequestMapping("updateUI")
    public ModelAndView findById(int id){
        Student student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @RequestMapping("update")
    public String update(Student student){
        studentService.update(student);
        return "redirect:/student/findAll";
    }

    @RequestMapping("deleteById")
    public String delete(int id){
            studentService.delete(id);
        return "redirect:/student/findAll";
    }

    @RequestMapping("deleteAll")
    public String deleteAll(int[] ids){
        if (ids!=null){
            for (int id : ids) {
                studentService.delete(id);
            }
        }
        return "redirect:/student/findAll";
    }




}
