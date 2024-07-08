package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosys.entity.Student;
import com.infosys.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping("/index")
	public String operations() {
		return "indexs";
	}
	
	@RequestMapping("/takeInput")
	public String takeInput() {
		return "inputPage";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute Student s,Model model) {
		service.insertStudent(s);
		model.addAttribute("id",s.getReg_no());
		return "insertSuccess";
	}
	
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<Student> s = service.getAll();
		model.addAttribute("all", s);
		return "allStudent";
	}
	
	@RequestMapping("/getById")
	public String getById() {
		return "inputPageId";
	}
	
	@RequestMapping("/getBYId")
	public String get(@ModelAttribute Student s,Model model) {
		Student stu = service.getById(s.getReg_no());
		model.addAttribute("Student", stu);
		return "displayStudent";
	}
	
	@RequestMapping("/updateIt")
	public String updateIt() {
		return "updateInput";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute Student s,Model model) {
		service.updateMarks(s.getReg_no(), s.getMarks());
		model.addAttribute("updatedStudent", s.getReg_no());
		return "updateOutput";
	}
	
	@RequestMapping("/deleteIt")
	public String deleteIt() {
		return "deleteInput";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute Student s,Model model) {
		service.delete(s.getReg_no());
		model.addAttribute("deletedStudent", s.getReg_no());
		return "deleteOutput";
	}
}
