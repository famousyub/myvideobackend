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
	@RequestMapping("/fieldsdata")


public class AdminFieldDetailsFieldController {



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
	        model.addAttribute("field", new Field());
	        model.addAttribute("fieldDetail", new FieldDetail());
	        return "field/create";
	    }
	    
	    @GetMapping("/showFormForAddp")
	    public String showFormForAddp(Model model) {
	        model.addAttribute("field", new Field());
	       
	        return "field/createfiled";
	    }
	    
	    
	    @PostMapping("/saveFieldp")
	    public String saveFieldp(@ModelAttribute("field") Field field
	                            ) {
	    	
	    	
	      
	        fieldRepository.save(field);
	        return "redirect:/fields/list";
	    }

	    @PostMapping("/saveField")
	    public String saveField(@ModelAttribute("field") Field field,
	                            @ModelAttribute("fieldDetail") FieldDetail fieldDetail) {
	    	
	    	
	    	
	    	//fieldDetail.setId(field.getId());
	        field.setDetail(null);
	        fieldDetail.setField(field);
	        fieldRepository.save(field);
	        return "redirect:/fields/list";
	    }

	    @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
	        Field field = fieldRepository.findById(id).orElse(null);
	        model.addAttribute("field", field);
	        model.addAttribute("fieldDetail", field.getDetail());
	        return "field/edit";
	    }

	    @PostMapping("/updateField/{id}")
	    public String updateField(@PathVariable("id") Long id,
	                              @ModelAttribute("field") Field field,
	                              @ModelAttribute("fieldDetail") FieldDetail fieldDetail) {
	        field.setId(id);
	        field.setDetail(fieldDetail);
	        fieldDetail.setField(field);
	        fieldRepository.save(field);
	        return "redirect:/fields/list";
	    }

	    @GetMapping("/showFormForDelete/{id}")
	    public String showFormForDelete(@PathVariable("id") Long id, Model model) {
	        Field field = fieldRepository.findById(id).orElse(null);
	        model.addAttribute("field", field);
	        model.addAttribute("fieldDetail", field.getDetail());
	        return "field/delete";
	    }

	    @PostMapping("/deleteField/{id}")
	    public String deleteField(@PathVariable("id") Long id) {
	        fieldRepository.deleteById(id);
	        return "redirect:/fields/list";
	    }
	}

