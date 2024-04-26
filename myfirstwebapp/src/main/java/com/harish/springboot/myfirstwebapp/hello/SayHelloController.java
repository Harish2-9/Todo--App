package com.harish.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello !What are you learning today..";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My html web page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My Html page and body");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();		
	}
	
	//src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	//@ResponseBody
	public String sayHelloJsp() {
		return "sayHello"; // "SayHello" is the name of the jsp file which contains the display content
	}
	
	
}
