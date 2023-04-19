package com.express.selexplms.lmscontrollers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.express.selexplms.dto.LessonCountDTO;
import com.express.selexplms.entity.Course;
import com.express.selexplms.entity.Instructor;
import com.express.selexplms.entity.Lesson;
import com.express.selexplms.service.CourseService;
import com.express.selexplms.service.InstructorService;
import com.express.selexplms.service.LessonService;

@SessionAttributes("lessonCount")
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private LessonService lessonService;

//	@ResponseBody
//	@GetMapping("/test")
//	public String test(@RequestParam("pageNumber") int pageNumber, HttpServletRequest request) {
//
//		// default pageNumber is 0
//		PagedListHolder<Lesson> pagedListHolder = new PagedListHolder<Lesson>();
//
//		// instead of making DB call for each and every pageNumber we are storing
//		// lessons which we got
//		// from pageListHolder inside session and fetching it again if it is not 1st
//		// time.
//
//		if (pageNumber == 0) {
//			Course course = courseService.findCourseById(1);
//
//			List<Lesson> lessonList1 = course.getLessons();
//
//			pagedListHolder.setSource(lessonList1);
//			pagedListHolder.setPageSize(2);
//
//			// For which pageNumber u want details to be printed
//			pagedListHolder.setPage(pageNumber);
//
//			List<Lesson> lessonListFromPageListHolder = pagedListHolder.getPageList();
//
//			HttpSession session = request.getSession();
//
//			session.setAttribute("pagedListHolder", pagedListHolder);
//
//			for (Lesson lesson : lessonListFromPageListHolder) {
//
//				System.out.println("  lesson  " + lesson);
//			}
//
//			System.out.println("current page " + pagedListHolder.getPage());
//
//			System.out.println("page size" + pagedListHolder.getPageSize());
//
//		}
//
//		else {
//
//			PagedListHolder<Lesson> lessonListNew = (PagedListHolder<Lesson>) request.getSession()
//					.getAttribute("pagedListHolder");
//			lessonListNew.setPage(pageNumber);
//
//			List<Lesson> lessonList = lessonListNew.getPageList();
//
//			for (Lesson lesson2 : lessonList) {
//
//				System.out.println("  lessonListNew  " + lesson2);
//
//			}
//
//			System.out.println("current page " + pagedListHolder.getPage());
//
//			System.out.println("page size" + pagedListHolder.getPageSize());
//		}
//
//		return "testing";
//	}

	@GetMapping("/viewCourse")
	public String viewcourse(@RequestParam("courseId") int courseId,
			@RequestParam(name = "pageNum", required = false) String pageNum, Model model, HttpServletRequest request) {

		PagedListHolder<Lesson> pagedLessonListHolder = new PagedListHolder<>();

		Course course = null;

		if (pageNum == null) {

			course = courseService.findCourseById(courseId);

			List<Lesson> lessons = course.getLessons();

			pagedLessonListHolder.setSource(lessons);

			pagedLessonListHolder.setPageSize(2);

			pagedLessonListHolder.setPage(0);

			request.getSession().setAttribute("course", course);
			request.getSession().setAttribute("lessonList", pagedLessonListHolder);

			pagedLessonListHolder.getPageList(); // fetch all lesson

			int pageCount = pagedLessonListHolder.getPageCount(); // for that particular page records present.

			System.out.println("Page Count" + pageCount);
		}

		else if ("prev".equals(pageNum)) {

			pagedLessonListHolder = (PagedListHolder<Lesson>) request.getSession().getAttribute("lessonList");
			pagedLessonListHolder.previousPage();

		}

		else if ("next".equals(pageNum)) {

			pagedLessonListHolder = (PagedListHolder<Lesson>) request.getSession().getAttribute("lessonList");
			pagedLessonListHolder.nextPage();
		}

		else {

			pagedLessonListHolder = (PagedListHolder<Lesson>) request.getSession().getAttribute("lessonList");

			pagedLessonListHolder.setPage(Integer.parseInt(pageNum));

		}

		model.addAttribute("courseId", courseId);
		model.addAttribute("course", course);

		LessonCountDTO lessonCountDTO = new LessonCountDTO();

		course = (Course) request.getSession().getAttribute("course");

		if (!course.getLessons().isEmpty()) {
			int firstLesson = course.getLessons().get(0).getLesson_id();

			System.out.println("firstLesson " + firstLesson);

			int lastLesson = (firstLesson + course.getLessons().size()) - 1;

			// firstlesson = 1 lessonSize = 6 then use - 1

			// to find lastlessonNumber ==> (1+6)- 1

			System.out.println("lastLesson " + lastLesson);

			lessonCountDTO.setFirstLessonNumber(firstLesson);
			lessonCountDTO.setLastLessonNumber(lastLesson);

		} else

			model.addAttribute("lessonCount", lessonCountDTO);

		System.out.println("Lesson Count" + lessonCountDTO);

		return "course-page";
	}

	@GetMapping("/openLesson")
	public String openLesson(@RequestParam("id") int lessonId, Model model) {

		Lesson lessonObj = courseService.findLessonById(lessonId);

		model.addAttribute("lesson", lessonObj);

		return "lesson-page";
	}

	@GetMapping("/addLesson")
	public String addLesson(@RequestParam("courseId") int courseId, Model model) {

		Lesson lessonObj = new Lesson();

		Course course = courseService.findCourseById(courseId);

		lessonObj.setCourse(course);

		model.addAttribute("lesson", lessonObj);

		return "add-lesson";
	}

	@GetMapping("/add-course")
	public String addCoursePage(Model model) {

		model.addAttribute("course", new Course());

		List<Instructor> instructorList = instructorService.findAllInstructor();

		model.addAttribute("instructorList", instructorList);

		return "add-course";
	}

	@PostMapping("/save-course")
	public String saveCourse(Course course) {

		int courseId = courseService.save(course);

		return "redirect:/viewCourse?courseId=" + courseId;
	}

	@PostMapping("/save-lesson")
	public String saveLesson(Lesson lesson) {

		lessonService.saveLesson(lesson);

		return "redirect:/viewCourse?courseId=" + lesson.getCourse().getCourse_id();
	}

}
