package com.cheungchan.highlight_springmvc4;

import com.cheungchan.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {


    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + "can access";
    }

    // 演示路径参数 /anno/pathvar/xx
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + "can access,str:" + str;
    }

    // 演示常规的从request参数获取，访问路径为/anno/reqeustParam?id=1
    @RequestMapping(value = "requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String passReqeustParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,id:" + id;
    }

    // 演示解释参数到对象，访问路径为/anno/obj?id=1&name=xx
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody // @ResponseBody也可以注解到方法上
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url: " + request.getRequestURL() + " can access, obj id: " + obj.getId() +
                " obj name: " + obj.getName();
    }

    // 演示映射到不同路径到相同方法，访问路径为/anno/name1或/anno/name2
    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }
}
