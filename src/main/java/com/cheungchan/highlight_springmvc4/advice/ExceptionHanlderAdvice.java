package com.cheungchan.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // ControllerAdvice声明一个控制器建言，组合了@Component注解
public class ExceptionHanlderAdvice {
    @ExceptionHandler(value = Exception.class)//通过value属性可过滤拦截的条件。
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error"); //error页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute //通过@ModelAttribute将键值对添加到全局，所有注解@ReqeustMapping的方法可获得此键值对
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder // 通过设置WebDataBinder，将自动绑定前台请求参数到model中
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id"); // 忽略rquest参数的id。
    }
}
