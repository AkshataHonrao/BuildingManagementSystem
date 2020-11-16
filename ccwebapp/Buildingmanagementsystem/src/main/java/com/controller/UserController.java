package com.controller;

import java.util.Map;
import java.util.stream.Collectors;

import com.JsonResponse.UserJsonResponse;
import com.dao.AuthGroupRepository;
import com.dao.UserRepository;
import com.pojo.User;
import com.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class
UserController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomUserDetailsService userService ;
	@Autowired
	private AuthGroupRepository authGroupRepository;

	@GetMapping(value={"/", "/index"})
	public String getHomePage(Model model){
		return "index";
	}

	@GetMapping(value="/login")
	public String getLoginPage(Model model)
	{
//		ModelAndView mv = new ModelAndView();
//		User user = new User();
//		mv.addObject(user);
//		mv.setViewName("login");
		return "login";
	}

	@GetMapping(value="/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getUserPage(Model model)
	{
		return "index";
	}

	@GetMapping(value="/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String getAdminPage(Model model)
	{
		return "login";
	}

	@GetMapping(value="/logout-success")
	public String getLogoutPage(Model model){
		return "logout";
	}

	@GetMapping(value = "/signup")
	public String register(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "signup";
	}

	@PostMapping(value = "/signup", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String register(@Valid @ModelAttribute User user, BindingResult errors,Model model) {
		UserJsonResponse userJsonResponse = new UserJsonResponse();
		if (errors.hasErrors()){
			Map<String, String> errorsList=errors.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
			userJsonResponse.setValidated(false);
			userJsonResponse.setErrorMessages(errorsList);
			return "signup";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User newuser=userRepository.findByUsername(user.getUsername());
		User savedUser=userRepository.saveAndFlush(user);
		model.addAttribute("message","Validation Errors Saved");
		return "login";
	}

	@GetMapping(value = "/Requests")
	public String requsts(Model model){
		return "Requests";
	}

}