package kr.co.jgm.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jgm.user.domain.User;
import kr.co.jgm.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "user/sign";
	}
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.POST)
	public String registerUser(
			@ModelAttribute User user
			, Model model) {
		try {
			int result = service.insertUser(user);
			if(result > 0) {
				return "redirect:/user/login.do";
			}else{
				model.addAttribute("msg", "회원가입이 완료되지 않았습니다.");
				model.addAttribute("error", "회원가입 실패");
				model.addAttribute("url", "/user/register.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/update.do", method=RequestMethod.GET)
	public String showMyInfo(
			String userId
			, Model model) {
		User user = service.getUserById(userId);
		model.addAttribute("user", user);
		return "user/modify";
	}

	@RequestMapping(value="/user/update.do", method=RequestMethod.POST)
	public String modifyUser(@ModelAttribute User user, Model model) {
		try {
			int result = service.updateUser(user);
			if(result > 0) {
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "");
				model.addAttribute("error", "");
				model.addAttribute("url", "/user/mypage.do?userId"+user.getUserId());
				return "common.errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", ".");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/delete.do", method=RequestMethod.GET)
	public String outServiceUser(
			@RequestParam("userId") String userId
			, Model model) {
		try {
			int result = service.deleteUser(userId);
			if(result > 0) {
				return "redirect:/user/logout.do";
			}else {
				model.addAttribute("msg", "");
				model.addAttribute("error", "");
				model.addAttribute("url", "/index.jsp");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.GET)
	public String showLoginForm() {
		return "user/login";
	}
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public String userLogin(
			@ModelAttribute User user
			, HttpSession session
			, Model model) {
		try {
			User uOne = service.selectCheckLogin(user);
			if(uOne != null) {
				session.setAttribute("userId", uOne.getUserId());
				session.setAttribute("userName", uOne.getUserName());
				return "redirect:/index.jsp";
			}else {
				model.addAttribute("msg", "로그인이 완료되지 않았습니다.");
				model.addAttribute("error", "로그인 실패");
				model.addAttribute("url", "/user/register.do");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "관리자에게 문의해주세요.");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/logout.do", method=RequestMethod.GET)
	public String userLogout(HttpSession session, Model model) {
		if(session != null) {
			session.invalidate();
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("error", "");
			model.addAttribute("msg", "");
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/mypage.do", method=RequestMethod.GET)
	public String showMyPage(
			@RequestParam("userId") String userId
			, Model model) {
		try {
			User user = service.getUserById(userId);
			if(user != null) {
				model.addAttribute("user", user);
				return "user/mypage";
			}else {
				model.addAttribute("msg", "회원정보 조회에 실패했습니다.");
				model.addAttribute("error", "");
				model.addAttribute("url", "/index.jsp");
				return "common.errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "");
			model.addAttribute("error", e.getMessage());
			model.addAttribute("url", "/index.jsp");
			return "common/errorPage";
		}
		
	}
	
}