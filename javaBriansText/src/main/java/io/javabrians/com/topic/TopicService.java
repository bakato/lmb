package io.javabrians.com.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topicList = new ArrayList<>(Arrays.asList(
			new Topic("Java1", "Name1 Framework11", "Description Framework11"),	
			new Topic("Java2", "Name2 Framework2", "Description Framework2"),
			new Topic("Java3", "Name3 Framework3", "Description Framework3")
				
		   ));
	
	public List<Topic> getAllArrayListTopics(){
		return topicList;
	}
	
	public Topic getTopicById (String id) {
		
		Topic topic;
		try {
			topic = topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		}
		catch(Exception e) {
		    throw new UserNotFoundException("id = "+id);
	    }
		return topic;

	}
	
//	public void addTheTopic(Topic topic) {
	public Topic addTheTopic(Topic topic) {
		topicList.add(topic);
		return topicList.get(topicList.indexOf(topic));
	}

	public void putTheTopic(Topic topic, String id) {
		topicList.forEach(item -> { 
			      if (item.getId().equals(id))		
			    	  topicList.set(topicList.indexOf(item), topic);
		});
		return;
	}

	public void deleteTopicById(String id) {
		topicList.removeIf(t -> t.getId().equals(id));		
		return;
	}
	
}
