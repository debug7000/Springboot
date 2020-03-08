package com.springboot.course.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getTopics(@RequestParam(value = "name", defaultValue = "World") String name) {
		
				return topicService.getTopics();
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		
				return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		
		topicService.updateTopic(topic,id);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		
		topicService.deleteTopic(id);
		
	}

}
