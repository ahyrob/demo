package hello2.hello2spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

    // 정적 컨텐츠: 파일을 그냥 내려 주는 거임
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    // mvc와 템플릿 엔진: 템플릿 엔진을 model view controller방식으로 쪼개서 뷰를
    //템플릿 엔진으로 html을 프로그래밍한 걸 렌더링해서 렌더링이된 html을 클라이언트에게
    //전달해주는 것
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    // 문자 그대로 갖다 붙이는 거임  html이 아닌 문자값을 http에 주는 거
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello"+name; // hello spring
    }

    // api 방식: responsebody원리- 객체가 오는 거임 json방식으로 만들어서 http로 반환하는 것
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
