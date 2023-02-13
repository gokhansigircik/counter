package com.gokhan.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainController{

	@GetMapping("")
	public String count(HttpSession session){
		if (session.getAttribute("count") == null){
			session.setAttribute("count", 1);
		}else{
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count+1);
		}
		return "index.jsp";
	}

	@GetMapping("/counter")
	public String display(HttpSession session, Model model){
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count", count);
		return "display.jsp";
	}
}
