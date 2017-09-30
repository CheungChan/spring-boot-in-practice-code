package com.cheungchan.springmvc4.web.ch4_6;

import com.cheungchan.highlight_springmvc4.MyMvcConfig;
import com.cheungchan.highlight_springmvc4.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")// 指明是一个WebApplicationContext，而且制定资源位置
public class TestControllerIntegrationTests {
    private MockMvc mockMvc;//模拟mvc对象
    @Autowired
    private DemoService demoService;//可以注入Spring的Bean
    @Autowired
    WebApplicationContext wac;//可以注入WebApplicationContext
    @Autowired
    MockHttpSession session; // 可以注入模拟的http session
    @Autowired
    MockHttpServletRequest request; // 可以注入模拟的http request

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();//初始化模拟MVC对象
    }

    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/normal")) //模拟向/normal进行get请求
                .andExpect(status().isOk())//预期控制返回状态为200
                .andExpect(view().name("page")) //预期view名称为page
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))// 预期真正路径
                .andExpect(model().attribute("msg", demoService.saySomething()));//预期service的返回值是msg
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(demoService.saySomething()));
    }
}
