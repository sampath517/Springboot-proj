package com.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.entity.Actor;
import com.mvc.service.IActorMgmtService;

@Controller
public class ActorOperationController {

	@Autowired
	private IActorMgmtService actorService;
	@GetMapping("/")
	public String showHomePAGE() {
		System.out.println("ActorOperationController.showHomePAGE()");
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showReport(@PageableDefault(page = 0,size = 3,sort="category",direction = Sort.Direction.ASC) Pageable pageable,Map<String, Object>map) {
		//use service
		Page<Actor>page=actorService.showAllActors(pageable);
		//keep results model attributes
		System.out.println("ActorOperationController.showReport()");
	
		map.put("pageData", page);
		
		return "show_report";
		
	}
	
	@GetMapping("/register")  //launch form page of register actor
	public String showFormPageRegister(@ModelAttribute("actor") Actor actor) {
		
		//use service
		//String msg=actorService.registerActors(actor);
	
		//keep result is model atttr
	//	map.put("resultMsg", msg);
		System.out.println("ActorOperationController.showFormPageRegister()");
		
		return "show_register_form";
		
		
	}
	
	/*@PostMapping("/register")           // reload page data will be added
	public String registerActor(@ModelAttribute("actor") Actor actor,Map<String, Object>map) {
		
		Iterable<Actor>list=actorService.showAllActors();
		//use service
		String msg=actorService.registerActors(actor);
	
		//keep result is model atttr
		map.put("resultMsg", msg);
		map.put("listActors", list);
		
		System.out.println("ActorOperationController.registerActor()");
		
		return "show_report";
		
		
	}*/
	
	/*@PostMapping("/register")    //solution 1   implementing PRG pattern
	public String registerActor(@ModelAttribute("actor") Actor actor,RedirectAttributes attr) {		
		
		//use service
		String msg=actorService.registerActors(actor);
	
		//keep result is model atttr
		attr.addFlashAttribute("resultMsg", msg);
	
		System.out.println("ActorOperationController.registerActor()");
		
		return "redirect:report";		
	}*/
	
	@PostMapping("/register")    //solution 2   implementing PRG pattern
	public String registerActor(@ModelAttribute("actor") Actor actor,HttpSession ses) {		
		
		//use service
		String msg=actorService.registerActors(actor);
	
		//keep result is model atttr
		ses.setAttribute("resultMsg", msg);
	
		System.out.println("ActorOperationController.registerActor()");
		
		return "redirect:report";		
	}
	
	@GetMapping("/edit")
	public String editActorFormPage(@ModelAttribute("actor") Actor actor,@RequestParam("no")int id) throws IllegalAccessException {
	
		Actor actor1=actorService.fetchActorById(id);
		//copy actor1 obj data to  actor object(model attr)
		BeanUtils.copyProperties(actor1, actor);
		
		return "actor_edit_form";
	}
	
	@PostMapping("/edit")
	public String editActor(@ModelAttribute("actor") Actor actor,RedirectAttributes attrs) {
		String msg=actorService.editActor(actor);
		
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
	@GetMapping("/delete")
	public String removeAcotrById(@RequestParam("no")int id,Map<String, Object> attr) {
		
		//use service
		String msg=actorService.deleteActorById(id);
		//keep the results in flash attr
		attr.put("resultMsg", msg);
		//forward req
		return "forward:report";
		
	}
}
