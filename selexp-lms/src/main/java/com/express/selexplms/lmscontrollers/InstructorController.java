package com.express.selexplms.lmscontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.express.selexplms.dao.InstructorDAO;
import com.express.selexplms.entity.Instructor;

@Controller
public class InstructorController {

	@Autowired
	private InstructorDAO instructorDAO;

	@RequestMapping("/instructor-info")
	public String showInstructorHomePage(Model model) {

		List<Instructor> instructorList = instructorDAO.findAllInstructor();

		model.addAttribute("instructorList", instructorList);

		return "instructor-home";
	}

}
