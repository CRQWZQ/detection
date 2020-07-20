package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/03 <br>
 */
@RestController
@RequestMapping("/demo")
public class SampleController {
    @RequestMapping("/status")
    @ResponseBody
    public void index(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello");
    }
}
