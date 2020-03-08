package com.example.datajpa.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.datajpa.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{topicid}/courses")
	public List<Course> getTopics(@PathVariable String topicid) {
		
				return courseService.getAllCourses(topicid);
	}
	
	@GetMapping("/topics/{topicid}/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		
				return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics/{topicid}/courses")
	public void addTopic(@RequestBody Course course,@PathVariable String topicid) {
		
		Topic topic = new Topic(topicid,"","");
		course.setTopic(topic);
		courseService.addCourse(course);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "topics/{topicid}/courses/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String topicid,@PathVariable String id) {
		
		Topic topic = new Topic(topicid,"","");
		course.setTopic(topic);
		courseService.updateCourse(course,id);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "topics/{topicid}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		
		courseService.deleteCourse(id);
		
	}

}
