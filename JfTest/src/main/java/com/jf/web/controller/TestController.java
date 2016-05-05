package com.jf.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class TestController {
	
	@RequestMapping(value = "test")
    @ResponseBody
    public String test(@RequestParam int channel,@RequestParam int type,
			final HttpServletRequest request) {
		return "{\"channel\":" + 0 + "}";
	}
	
	@RequestMapping(value = "test3")
//	@ResponseBody
	public String test3(@RequestParam int channel,@RequestParam int type,
			final HttpServletRequest request) {
		return "view";
	}

	@RequestMapping(value = "rest/{id}/{lt}")
	@ResponseBody
	public String rest(@PathVariable("id") int id, @PathVariable("lt") int lt,@RequestParam int type,
			final HttpServletRequest request) {
		System.out.println(id + "|" + lt);
		System.out.println(type);
		return "{\"id\":" + id + ",\"lt\":" + lt + "}";
	}
	
	@RequestMapping(value = "rest/{id}/{lt}/{hh}")
	@ResponseBody
	public String rest(@PathVariable("id") int id, @PathVariable("lt") int lt,
			final HttpServletRequest request) {
		System.out.println(id + "|" + lt);
		return "{\"id\":" + id + ",\"lt\":" + lt + "}";
	}

	@RequestMapping(value = "test2")
	@ResponseBody
	public void test2(@RequestParam int id,@RequestParam int lt,
			final HttpServletRequest request,final HttpServletResponse response) throws IOException {
		System.out.println(id + "|" + lt);
		
		response.sendRedirect("http://www.baidu.com");
//		return "";
//		return "redirect:http://www.baidu.com";
		
//		response.setHeader("pragma","no-cache");
//        response.setHeader("cache-control", "no-cache");
//        response.setHeader("cache-control", "private");
//        response.setDateHeader("expires", 0);
//        response.setContentType("image/jpeg");
//
//        ServletOutputStream out = response.getOutputStream();
//
//        BufferedImage image = new BufferedImage(100, 100,BufferedImage.TYPE_INT_RGB);
//        Graphics g = image.getGraphics();
//
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//        ImageIO.write(image, "JPEG", bos);
//
//        byte[] buf = bos.toByteArray();
//
//        response.setContentLength(buf.length);
//        out.write(buf);
//        out.flush();
//        bos.close();
//        out.close();
	}

}
