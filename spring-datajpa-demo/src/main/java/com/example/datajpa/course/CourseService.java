package com.example.datajpa.course;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	/*
	 * private List<Course> course = new ArrayList<> (Arrays.asList(new
	 * Course("123", "java", "collection"), new Course("124", "Spring", "MVC"), new
	 * Course("125", "Sprinboot", "AOPs")));
	 */
	
	public List<Course> getAllCourses(String topicId){
		
		//return topics;
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
		
		
		
		
	}
	
	
	
	public Course getCourse(String id) {
		/*
		 * return topics.stream(). filter(t -> t.getId().equalsIgnoreCase(id))
		 * .findFirst().get();
		 */
		
		return courseRepository.findById(id).get();
		
		/*
		 * topics.stream(). filter(t -> t.getId().equalsIgnoreCase("123")) .findAny()
		 * .orElse(null);
		 */
		
				
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		courseRepository.save(course);
		
	}
//
	
	
	public void updateCourse(Course course, String id) {
		// TODO Auto-generated method stub
		
		/*
		 * topics.stream() .filter(t -> t.getId().equalsIgnoreCase(id)) .forEach(u
		 * ->topics.set(topics.indexOf(u), topic));
		 */
		 
		courseRepository.save(course);
		 
		
		
	}

	public void deleteCourse(String id) {
		
		//topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
		courseRepository.deleteById(id);
		
	}

	

}
