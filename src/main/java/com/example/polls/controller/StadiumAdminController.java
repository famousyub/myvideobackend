package com.example.polls.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.polls.model.Stadium;


import com.example.polls.repository.StadiumRepository;

@Controller
public class StadiumAdminController {
	
	
	@Autowired
	  private StadiumRepository tutorialRepository;

	  @GetMapping("/stades")
	  public String getAll(Model model, @Param("keyword") String keyword) {
	    try {
	      List<Stadium> tutorials = new ArrayList<Stadium>();

	      if (keyword == null) {
	        tutorialRepository.findAll().forEach(tutorials::add);
	      } else {
	        tutorialRepository.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
	        model.addAttribute("keyword", keyword);
	      }

	      model.addAttribute("tutorials", tutorials);
	    } catch (Exception e) {
	      model.addAttribute("message", e.getMessage());
	    }

	    return "stades";
	  }

	  @GetMapping("/stades/new")
	  public String addTutorial(Model model) {
		  Stadium tutorial = new Stadium();
	    tutorial.setPublished(true);
	    tutorial.setAvaible(true);

	    model.addAttribute("tutorial", tutorial);
	    model.addAttribute("pageTitle", "Create new Tutorial");

	    return "stade_form";
	  }

	  @PostMapping("/stades/save")
	  public String saveTutorial(Stadium tutorial, RedirectAttributes redirectAttributes) {
	    try {
	      tutorialRepository.save(tutorial);

	      redirectAttributes.addFlashAttribute("message", "The Tutorial has been saved successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addAttribute("message", e.getMessage());
	    }

	    return "redirect:/stades";
	  }

	  @GetMapping("/stades/{id}")
	  public String editTutorial(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
	    try {
	    	Stadium tutorial = tutorialRepository.findById(id).get();

	      model.addAttribute("tutorial", tutorial);
	      model.addAttribute("pageTitle", "Edit Tutorial (ID: " + id + ")");

	      return "stade_form";
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());

	      return "redirect:/stades";
	    }
	  }

	  @GetMapping("/stades/delete/{id}")
	  public String deleteTutorial(@PathVariable("id") Long  id, Model model, RedirectAttributes redirectAttributes) {
	    try {
	      tutorialRepository.deleteById(id);

	      redirectAttributes.addFlashAttribute("message", "The Tutorial with id=" + id + " has been deleted successfully!");
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());
	    }

	    return "redirect:/stades";
	  }

	  @GetMapping("/stades/{id}/published/{status}")
	  public String updateTutorialPublishedStatus(@PathVariable("id") Long id, @PathVariable("status") boolean published,
	      Model model, RedirectAttributes redirectAttributes) {
	    try {
	      tutorialRepository.updatePublishedStatus(id, published);

	      String status = published ? "published" : "disabled";
	      String message = "The Tutorial id=" + id + " has been " + status;

	      redirectAttributes.addFlashAttribute("message", message);
	    } catch (Exception e) {
	      redirectAttributes.addFlashAttribute("message", e.getMessage());
	    }

	    return "redirect:/stades";
	  }

	
	
	

}
