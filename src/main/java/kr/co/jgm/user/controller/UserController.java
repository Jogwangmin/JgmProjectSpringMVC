package kr.co.jgm.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.jgm.user.domain.User;
import kr.co.jgm.user.service.UserService;

@Controller
@SessionAttributes({"userId", "userName"})
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "user/login";
	}
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public String userLogin(
			HttpServletRequest request
			, @RequestParam("userId") String userId
			, @RequestParam("userPw") String userPw
			, Model model) {
		try {
			User user = new User();
			user.setUserId(userId);
			user.setUserPw(userPw);
			User uOne = service.selectCheckLogin(user);
			if(uOne != null) {
				model.addAttribute("userId", uOne.getUserId());
				model.addAttribute("userPw", uOne.getUserPw());
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "로그인 실패");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
}