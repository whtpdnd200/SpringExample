package com.devwork.springexample.jpa;

import com.devwork.springexample.jpa.domain.Student;
import com.devwork.springexample.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/lombok")
    public Student lomBokTest() {

//        Student student = new Student(2
//                    ,"김인규"
//                    , "010-1111-2222"
//                    , "test@gmail.com"
//                    , "개발자"
//                    , LocalDateTime.now()
//                    , LocalDateTime.now());

        // bulder 패턴을 통한 객체 생성
        Student student = Student.builder()
                .name("조세웅")
                .phoneNumber("010-4444-5555")
                .dreamJob("개발자")
                .build();

        return student;
    }

    @ResponseBody
    @GetMapping("/add")
    public Student addStudent() {
        // 조세웅, 010-4444-5555, test@gmail.com, 개발자

        Student result = studentService.createStudent("조세웅", "010-4444-5555", "test@gmail.com", "개발자");
        return result;
    }

    @ResponseBody
    @GetMapping("/modify")
    public Student modifyStudent() {
        // id가 3인 학생의 장래희망을 강사로 변경
        Student student = studentService.updateStudent(3, "강사");

        return student;
    }

    @ResponseBody
    @GetMapping("/remove")
    public String removeStudent() {

        // id가 3인 행 학생 삭제
        studentService.deleteStudent(3);

        return "삭제 완료";
    }
}
