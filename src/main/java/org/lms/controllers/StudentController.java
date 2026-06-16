package org.lms.controllers;

import org.lms.entities.Student;
import org.lms.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServices studService;


    @GetMapping("/new")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save")
    public String addStudent(@ModelAttribute("student") Student stud){
        studService.saveStudent(stud);
        return "redirect:/students-page";
    }


    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Integer id, Model model){
        Student existingStudent = studService.getStudent(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("student", existingStudent);
        return "edit-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@ModelAttribute("student") Student stud,
                                @PathVariable Integer id){
        studService.updateStudent(stud, id);
        return "redirect:/students-page";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studService.deleteStudent(id);
        return "redirect:/students-page";
    }
}