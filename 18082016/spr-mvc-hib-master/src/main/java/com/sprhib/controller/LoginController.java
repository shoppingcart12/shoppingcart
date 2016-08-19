package com.sprhib.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Users;
import com.sprhib.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView submit(Model model,
			@ModelAttribute("loginBean") Users loginBean,
			HttpSession httpSession) {
		ModelAndView modelAndView = null;
		try {
			if (!userService.checkUserInf(loginBean.getUsername())) {
				model.addAttribute("msg", "User doesnot exist");
				modelAndView = new ModelAndView("Login");
			} else if (!userService.checkLoginInf(loginBean.getUsername(),
					loginBean.getPassword())) {

				model.addAttribute("msg", "Invalid Credentials");
				modelAndView = new ModelAndView("Login");
			} else {
				userService.checkLoginInf(loginBean.getUsername(),
						loginBean.getPassword());
				Integer UserRole = userService.getUserRole(loginBean
						.getUsername());
				if (UserRole == 1) {
					modelAndView = new ModelAndView("AdminHome");
				} else {
					modelAndView = new ModelAndView("UserHome");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/goLogin", method = RequestMethod.GET)
	public ModelAndView goLogin(Model model) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("Login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView forgot(Model model) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("ForgotPwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/plogin", method = RequestMethod.GET)
	public ModelAndView Plogin() {
		return new ModelAndView("PLogin");
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView success() {
		return new ModelAndView("success");
	}
	
	@RequestMapping(value = "/notauth", method = RequestMethod.GET)
	public ModelAndView notauth() {
		return new ModelAndView("notauth");
	}

	@RequestMapping(value = "/pforgot", method = RequestMethod.GET)
	public ModelAndView pforgot() {
		return new ModelAndView("forgot");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		return new ModelAndView("logout");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/goAdminHome", method = RequestMethod.GET)
	public ModelAndView goAdminHome(Model model) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("AdminHome");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/newpwd/{username}", method = RequestMethod.GET)
	public ModelAndView newPwd(Model model,
			@ModelAttribute("newpwdBean") Users usersBean,
			@PathVariable String username) {
		ModelAndView modelAndView = null;
		try {
			if (!userService.checkUserInf(usersBean.getUsername())) {
				model.addAttribute("msg", "User doesnot exist");
				modelAndView = new ModelAndView("ForgotPwd");
			} else {
				userService.updatePwd(usersBean);
				model.addAttribute("msg", "Password updated successfully");
				modelAndView = new ModelAndView("ForgotPwd");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/checkUser")
	public void checkUser(@RequestParam("username") String username,
			HttpServletResponse res) {
		PrintWriter out = null;
		try {

			out = res.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean isvalid = userService.checkUserInf(username);
		/*String message = null;
		if (isvalid)
			message = "success";
		else
			message = "failure";*/
		out.println(isvalid);

	}

	@RequestMapping("/getrole")
	public void getRole(@RequestParam("username") String username,
			HttpServletResponse res) {
		PrintWriter out = null;
		try {
			out = res.getWriter();
		} catch (Exception e) {
		}
		int roleuser = userService.getUserRole(username);
		out.println(roleuser);
	}

	@RequestMapping(value = "/userSignUp", method = RequestMethod.GET)
	public ModelAndView userSignUp(Model model) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("UserSignUp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/signUpUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Users user) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("UserSignUp");
			if (user.getUsername().equals("admin")
					&& user.getPassword().equals("admin")) {
				user.setRoleid(1);
			} else {
				user.setRoleid(2);
			}
			userService.addUser(user);
			String message = "User Registered Successfully.";
			modelAndView.addObject("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/newregister", method = RequestMethod.GET)
	public void registeruser(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("role") String role, HttpServletResponse res) {
		PrintWriter out = null;
		try {
			out = res.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("new register");
		Users user = new Users();
		if (role.equals("Admin"))
			user.setRoleid(1);
		else
			user.setRoleid(2);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);

		try {
			userService.addUser(user);

		} catch (Exception e) {
			System.out.println("Exception caught");
			out.println("fail");
		}
		System.out.println("before return");
		out.println("success");
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}