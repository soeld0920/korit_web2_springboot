package com.koreait.spring_boot_study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//html 리턴이 아닌 데이터를 리턴함
@Slf4j
public class StudyRestController1 {
    @GetMapping("/study/test1")
    public String test1(){
        log.info("test1 컨트롤러 수신");
        return "양호합니다.";
    }

    //GET 요청의 경우 쿼리스트링으로 데이터 전달 가능
    // localhost:8080/study/test2?text
    // 서버주소/경로?name="asdf"&age="asdf"
    @GetMapping("/study/test2")

    //RequestParma는 쿼리스트링의 key와 매개변수명이 같으면 생략가능
    public String test2(@RequestParam("name") String name){
        log.info("test2 컨트롤러 수신");
        return "양호합니다." + name + "님";
    }

    //param 2개, RequestParams 생략
    @GetMapping("/study/test3")
    public String test3(String name, Integer age){
        //key = 이름이면 생략가능
        // 숫자는 알아서 매개변수 타입으로 변환
        log.info("test3 컨트롤러 수신");
        return "양호합니다." + name + "님" + age + "살이네요";
    }
}
