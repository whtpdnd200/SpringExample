package com.devwork.springexample.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@NoArgsConstructor // 아무런 인자를 전달 받지않고 객체만 생성 할 수 있는 생성자 어노테이션
@AllArgsConstructor // 모든 필드의 값을 생성할때 넣고 생성시켜주는 생성자 어노테이션
@Getter // 게터 자동 생성 어노테이션
@Table(name = "`new_student`") // db의 테이블 이름 매칭 어노테이션
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String dreamJob;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
