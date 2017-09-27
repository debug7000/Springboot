package com.learn.web.springwebdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.web.springwebdemo.model.Todo;
import com.learn.web.springwebdemo.service.TodoRepository;
import com.learn.web.springwebdemo.service.TodoService;

@Controller

public class TodosController {
	
	/*@Autowired
	TodoService todoService;
	*/
	@Autowired
	TodoRepository repository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)

	public String showTodosList(ModelMap model) {
		
		String name = getLoggedInUser(model);
		System.out.println("TodosController.showTodosList()"+name);
		model.put("todos", repository.findByUser(name));
		//model.put("todos", todoService.retrieveTodos(name));

		return "list-todos";
	}

	
	@RequestMapping(value = "/add-todos", method = RequestMethod.GET)

	public String showAddTodoPage(ModelMap model) {
		
		model.addAttribute("todo",new Todo(0,getLoggedInUser(model), "", new Date(), false));
		return "todos";
	}

	/*private String getLoggedInUser(ModelMap model) {
		return (String)model.get("name");
	}*/
	
	private String getLoggedInUser(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)

	public String deleteATodo(ModelMap model, @RequestParam int id) {
		if(id==1)
			throw new RuntimeException("Something went wrong");
		repository.delete(id);
		//todoService.deleteTodo(id);
		
		
		
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)

	public String showUpdateATodo(ModelMap model, @RequestParam int id) {
		
		Todo todo =repository.findOne(id);
		//Todo todo =todoService.getTodosByID(id);
		model.put("todo", todo);
		
		
		
		return "todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)

	public String UpdateATodo(ModelMap model,@Valid Todo todo, BindingResult br) {
		if(br.hasErrors()){
			return "todos";
		}
		
		todo.setUser(getLoggedInUser(model));
		repository.save(todo);
		//todoService.updateTodo(todo);
		
		
		
		
		return "redirect:/list-todos";
	}
	
	
	
	
	@RequestMapping(value = "/add-todos", method = RequestMethod.POST)

	public String addTodosList(ModelMap model, @Valid Todo todo, BindingResult br) {
		if(br.hasErrors()){
			return "todos";
		}
		
		System.out.println("TodosController.addTodosList()"+todo);
		todo.setUser(getLoggedInUser(model));
		System.out.println("TodosController.addTodosList(todoRepository)"+repository);
		repository.save(todo);
		//todoService.addTodo(getLoggedInUser(model), todo.getDesc(), todo.getTargetDate(), false);
		//String name = (String)model.get("name");
		//model.put("todos", todo.retrieveTodos(name));
		
		return "redirect:/list-todos";
	}
	

	

}
