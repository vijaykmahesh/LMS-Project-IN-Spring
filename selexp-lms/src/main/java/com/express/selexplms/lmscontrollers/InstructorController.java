package com.express.selexplms.lmscontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.express.selexplms.dto.SearchDTO;
import com.express.selexplms.entity.Instructor;
import com.express.selexplms.service.InstructorService;

import jakarta.validation.Valid;

@Controller
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@GetMapping(value = "/instructor-info")
	public String showInstructorHomePage(Model model) {

		List<Instructor> instructorList = instructorService.findAllInstructor();

		model.addAttribute("instructorList", instructorList);
		model.addAttribute("searchDTO", new SearchDTO());

		return "instructor-home";
	}

	@RequestMapping("/add-instructor")
	public String showInsertInstructorPage(Model model) {

		if (!model.containsAttribute("instructor")) {

			model.addAttribute("instructor", new Instructor());

		}

		return "add-instructor";
	}

	@RequestMapping("/process-search")
	public String showInsertInstructorPage(@RequestParam("id") int id, Model model) {

		ArrayList<Instructor> list = new ArrayList<Instructor>();

		Instructor instructor = instructorService.searchInstructor(id);
		list.add(instructor);

		model.addAttribute("instructorList", list);
		model.addAttribute("searchDTO", new SearchDTO());

		return "instructor-home";
	}

	@RequestMapping("/deleteInstructor")
	public String deleteInstructor(@RequestParam("id") int id) {

		instructorService.deleteInstructor(id);

		return "redirect:/instructor-info";
	}

	@PostMapping("/submit-instructor")
	public String saveInstructor(@Valid @ModelAttribute("instructor") Instructor instructor, BindingResult error,
			RedirectAttributes redirectAttributes) {

		if (error.hasErrors()) {

			redirectAttributes.addFlashAttribute("instructor", instructor);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.instructor", error);

			System.out.println("Error" + error);

			System.out.println("instructor" + instructor);

			return "redirect:/add-instructor";
		}

		instructorService.save(instructor);

		return "redirect:/instructor-info";
	}

}
