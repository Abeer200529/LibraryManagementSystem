package org.lms.services;
import org.lms.entities.Student;
import org.lms.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepo studRepo;

    public Student saveStudent(Student book){
        return studRepo.save(book);
    }

    public List<Student> getAllStudent(){
        return studRepo.findAll();
    }

    public Optional<Student> getStudent(Integer id){
        return studRepo.findById(id);
    }

    public void deleteStudent(Integer id){
        studRepo.deleteById(id);
    }
    public Student updateStudent(Student student, Integer id){
        Student existingStudent = studRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        return studRepo.save(existingStudent);
    }

}