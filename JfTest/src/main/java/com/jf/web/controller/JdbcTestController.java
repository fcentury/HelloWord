package com.jf.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.model.JdbcTest;
import com.jf.service.service.JdbcTestService;

/**
 * sprint jdbc test
 * @author jiafengma
 *
 */
@Controller
@RequestMapping(value = "/")
public class JdbcTestController {
	
	@Autowired
	private JdbcTestService service;
	
	@RequestMapping(value = "basic/save/withid")
    @ResponseBody
    public String saveWithId(@RequestParam String name,@RequestParam int status,
			final HttpServletRequest request) {
		String content = name + "-" + status;
		JdbcTest bean = new JdbcTest();
		bean.setName(name);
		bean.setStatus(status);
		long id = service.saveWithId(bean);
		return "{\"content\":" + "\"" +  content + "-" + id + "\"}";
	}

	@RequestMapping(value = "basic/save/withoutid")
	@ResponseBody
	public String saveWithoutId(@RequestParam String name,@RequestParam int status,
			final HttpServletRequest request) {
		String content = name + "-" + status;
		JdbcTest bean = new JdbcTest();
		bean.setName(name);
		bean.setStatus(status);
		bean.setId(0);
		boolean flag = service.saveWithoutId(bean);
		return "{\"content\":" + "\"" +  content + "-" + flag + "\"}";
	}

	@RequestMapping(value = "basic/get")
	@ResponseBody
	public String get(@RequestParam long id,
			final HttpServletRequest request) {
		JdbcTest bean = service.get(id);
		System.out.println(bean);
		return "{\"content\":" + "\"" +  id + "\"}";
	}

}
