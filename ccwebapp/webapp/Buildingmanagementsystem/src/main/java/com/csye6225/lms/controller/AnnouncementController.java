package com.csye6225.lms.controller;

import com.csye6225.lms.dao.AnnouncementRepository;
import com.csye6225.lms.pojo.Announcements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class
AnnouncementController {

	@Autowired
	private AnnouncementRepository announcementRepository;

	@GetMapping(value = "/announcements")
	public ModelAndView announcements(Model model){
		ModelAndView mv = new ModelAndView();
		List<Announcements> announcementsList= announcementRepository.findAll();
		mv.addObject(announcementsList);
		mv.setViewName("announcements");
		return mv;
	}

	@GetMapping(value = "/addAnnouncements")
	public ModelAndView addAnnouncements(Model model){
		ModelAndView mv = new ModelAndView();
		Announcements announecements = new Announcements();
		mv.addObject("announecements",announecements);
		mv.setViewName("addannouncements");
		return mv;
	}
	@PostMapping(value = "/addAnnouncements")
	public ModelAndView successAnnouncements(@Valid @ModelAttribute Announcements announecements , BindingResult errors){
		if(!errors.hasErrors()){
			announcementRepository.saveAndFlush(announecements);
		}
		ModelAndView mv = new ModelAndView();
		List<Announcements> announcementsList= announcementRepository.findAll();
		mv.addObject("announcementsList",announcementsList);
		mv.setViewName("announcements");
		return mv;
	}
}