package edu.bit.ex;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	
	@RequestMapping("/login/loginForm")
	public String loginFor(Model model) {
		logger.info("Welcome Login Form!");
		
		return "login/loginForm2";
	}
	
	
	@RequestMapping("/user/userHome")
	public String userHome(Model model) {
		logger.info("Welcome userHome!");
		
		return "user/user";
	}
	
	@RequestMapping("/admin/adminHome")
	public String adminHome(Model model) {
		logger.info("Welcome adminHome!");
		
		return "admin/adminHome";
	}
	
	@RequestMapping("/login/accessDenied")
	public String accessDeniedHome(Model model) {
		logger.info("Welcome accessDenied!");
		
		return "login/accessDenied";
	}
	
	
	
	@RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
	public String loginInfo(Principal principal,Model model) {
		
		//1.Controller�� ���Ͽ� Pincipal��ü�� �������� ���
		String user_id = principal.getName();
		System.out.println("���� ���̵�:" + user_id   );
		
		//2.SpringContextHolder�� ���Ͽ� �������� ���
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user_id = auth.getName();
        System.out.println("���� ���̵�:" + user_id   );
        //Authentication�ȿ� principal ���� 
        
    	//3.User Ŭ������ ��ȯ �Ͽ� �������� ���
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //�츮�� ���� Ŭ������ �ƴ� Spring�� �ִ� ��ü��
        user_id = user.getUsername();
        System.out.println("���� ���̵�:" + user_id   );
        
        return "home";
	}
	
	
	
	
	
	
}
