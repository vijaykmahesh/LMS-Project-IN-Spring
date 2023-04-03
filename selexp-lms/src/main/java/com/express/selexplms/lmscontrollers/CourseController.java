package com.express.selexplms.lmscontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.express.selexplms.entity.Course;
import com.express.selexplms.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/viewCourse")
	public String viewcourse(@RequestParam("courseId") int courseId, Model model) {

		Course course = courseService.findCourseById(courseId);
		
		model.addAttribute("course", course);
		return "course-page";
	}

}
