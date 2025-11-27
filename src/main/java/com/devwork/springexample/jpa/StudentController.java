package com.devwork.springexample.jpa;

import com.devwork.springexample.jpa.domain.Student;
import com.devwork.springexample.jpa.repository.StudentRepository;
import com.devwork.springexample.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;

    // !!!!!!!!!!!!!!!!!경고 !!!!!!!!!!!!!!
    // 절대 Controller에서 Repository 객체를 활용하면 안됨!!
    // 다만, 코드 작성 편의를 위해 임시로 활용
    @Autowired
    private StudentRepository studentRepository;

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

    @ResponseBody
    @GetMapping("/find")
    public List<Student> findStudent() {

        List<Student> studentList = null;
        // 모든 행 조회
        // studentList = studentRepository.findAll();
        // studentList = studentRepository.findByName("조세호");
        // studentList = studentRepository.findByOrderByIdDesc();
        // studentList = studentRepository.findTop2ByNameOrderByIdDesc("조세웅");
        List<String> nameList = new ArrayList<>();
        nameList.add("유재석");
        nameList.add("조세웅");
        nameList.add("조세호");
        //studentList = studentRepository.findByNameIn(nameList);

        studentList = studentRepository.selectByDreamJob("개발자");
        return studentList;
    }


}
