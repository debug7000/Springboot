package com.springboot.course.topic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>
			(Arrays.asList(new Topic("123", "java", "collection"),
			new Topic("124", "Spring", "MVC"),
			new Topic("125", "Sprinboot", "AOPs")));
	
	public List<Topic> getTopics(){
		
		return topics;
		
	}
	
	public Topic getTopicOld(String id) {
		Topic tp =null;
		for (Topic topic : topics) {
			if(id.equalsIgnoreCase(topic.getId())) {
				tp= topic;
			}
			
			
			
		}
		return tp;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().
				filter(t -> t.getId().equalsIgnoreCase(id))
				.findFirst().get();
		
		
		/*
		 * topics.stream(). filter(t -> t.getId().equalsIgnoreCase("123")) .findAny()
		 * .orElse(null);
		 */
		
				
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topics.add(topic);
		
	}
//
	
	public void updateTopicOld(Topic topic, String id) {
		for (Topic topic2 : topics) {
			
			if(id.equalsIgnoreCase(topic2.getId())) {
				topics.set(topics.indexOf(topic2), topic);
				return;
			}
			
		}		
		 
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		
		 topics.stream()
		 .filter(t -> t.getId().equalsIgnoreCase(id))
		 .forEach(u ->topics.set(topics.indexOf(u), topic));
		 
		 
		
		
	}

	public void deleteTopic(String id) {
		
		topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
		
	}

	

}
