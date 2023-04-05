package com.express.selexplms.lmscontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.express.selexplms.dto.LessonCountDTO;
import com.express.selexplms.entity.Course;
import com.express.selexplms.entity.Lesson;
import com.express.selexplms.service.CourseService;

@SessionAttributes("lessonCount")
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/viewCourse")
	public String viewcourse(@RequestParam("courseId") int courseId, Model model) {

		Course course = courseService.findCourseById(courseId);
		
		model.addAttribute("course", course);
		
		int firstLesson = course.getLessons().get(0).getLesson_id();
		
		System.out.println("firstLesson "+firstLesson);
		
		
		int lastLesson = (firstLesson + course.getLessons().size())-1;
		
		System.out.println("lastLesson "+lastLesson);

		LessonCountDTO lessonCountDTO = new LessonCountDTO();
		lessonCountDTO.setFirstLessonNumber(firstLesson);
		lessonCountDTO.setLastLessonNumber(lastLesson);
		
		model.addAttribute("lessonCount", lessonCountDTO);
		
		
		return "course-page";
	}
	
	@GetMapping("/openLesson")
	public String openLesson(@RequestParam("id") int lessonId, Model model) {
		
		Lesson lesson = courseService.findLessonById(lessonId);
		
		model.addAttribute("lesson", lesson);

		return "lesson-page";
	}

}
