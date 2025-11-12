package com.koreait.spring_boot_study.controller;
import com.koreait.spring_boot_study.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//controller - 클라이언트(브라우저)와 서버(스프링부트) 사이의 API 진입점
//유형 1. Controller : html파일을 반환 - SSR(Server Side Rendering)
//유형 2. REST Controller : JSON, 문자열 등의 데이터들만 반환 - CSR(Client Side Rendering)


@Controller
public class StudyController {
    //how 중심

    //인터넷 통신(HTTP 통신) - 웹에서 클라이언트와 데이터를 주고받는 규칙
    //1. 한번 요청하면 한번 응답한다,
    // 요청/응답 : 객체(header, body로 이루어짐)
    //2. 요청의 경우 메서드(방법)
    // - GET : 자원 조회 - body X, url에 쿼리스트링으로 데이터 전달
    // - POST : 자원 생성
    // - DELETE : 자원 삭제
    // - PUT :  자원 전체 수정
    // - PATCH : 자원 일부 수정
    // 톰캣서버(8080포트) + 로컬 -> localhost:8080(서버주소)
    //localhost:8080/hello -> 접속시 helloPage 컨트롤러가 실행됨.
    @GetMapping("/hello") //hello 경로로 get요청이 오면 실행하세요.
    public String helloPage(Model model){
        //Model : HTMl에 데이터를 전달해주는 자바객체
        System.out.println("hello 컨트롤러 수신");
        Hello hello = Hello.builder().hello1("데이터1").hello2("데이터2").build();

        //hello 객체를 "hello" 이름으로 html에 전달
        model.addAttribute("hello",hello);
        //templates 경로 안에 hello.html을 찾아서 반환해라.
        return "hello";
    }
}
