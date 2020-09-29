package com.csye6225.lms.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.csye6225.lms.JsonResponse.UserJsonResponse;
import com.csye6225.lms.auth.AuthGroup;
import com.csye6225.lms.dao.AnnouncementRepository;
import com.csye6225.lms.dao.AuthGroupRepository;
import com.csye6225.lms.dao.UserRepository;
import com.csye6225.lms.pojo.Announcements;
import com.csye6225.lms.pojo.User;
import com.csye6225.lms.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.servlet.ModelAndView;

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