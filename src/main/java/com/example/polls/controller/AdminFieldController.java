	package com.example.polls.controller;

	import com.example.polls.model.Field;
	import com.example.polls.model.FieldDetail;

	import com.example.polls.repository.FieldRepository;
import com.example.polls.repository.FielddetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.*;

	@Controller
	@RequestMapping("/fields")

public class AdminFieldController {




	    @Autowired
	    private FieldRepository fieldRepository;

	    @Autowired
	    private FielddetailRepository fieldDetailRepository;

	    @GetMapping("/list")
	    public String listFields(Model model) {
	        model.addAttribute("fields", fieldRepository.findAll());
	        return "field/list";
	    }

	    @GetMapping("/showFormForAdd")
	    public String showFormForAdd(Model model) {
	        Field field = new Field();
	        FieldDetail fieldDetail = new FieldDetail();
	        field.setDetail(fieldDetail);
	        model.addAttribute("field", field);
	        return "field/create";
	    }

	    @PostMapping("/saveField")
	    public String saveField(@ModelAttribute("field") Field field) {
	        fieldDetailRepository.save(field.getDetail());
	        fieldRepository.save(field);
	        return "redirect:/fields/list";
	    }

	    @GetMapping("/showFormForUpdate")
	    public String showFormForUpdate(@RequestParam("fieldId") Long fieldId, Model model) {
	        Field field = fieldRepository.findById(fieldId).orElse(null);
	        model.addAttribute("field", field);
	        return "field/edit";
	    }

	    @PostMapping("/updateField")
	    public String updateField(@ModelAttribute("field") Field field) {
	        fieldDetailRepository.save(field.getDetail());
	        fieldRepository.save(field);
	        return "redirect:/fields/list";
	    }

	    @GetMapping("/showFormForDelete")
	    public String showFormForDelete(@RequestParam("fieldId") Long fieldId, Model model) {
	        Field field = fieldRepository.findById(fieldId).orElse(null);
	        model.addAttribute("field", field);
	        return "field/delete";
	    }

	    @PostMapping("/deleteField")
	    public String deleteField(@RequestParam("fieldId") Long fieldId) {
	        fieldRepository.deleteById(fieldId);
	        return "redirect:/fields/list";
	    }
	}

