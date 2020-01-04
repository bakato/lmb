package io.javabrians.com.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Java1", "Name1 Framework11", "Description Framework11"),	
			new Topic("Java2", "Name2 Framework2", "Description Framework2"),
			new Topic("Java3", "Name3 Framework3", "Description Framework3")
				
		   ));
	
	public List<Topic> getAllArrayListTopics(){
		return topics;
	}
	
	public Topic getTopicById (String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}
	
	public void addTheTopic(Topic topic) {
		topics.add(topic);
	}

	public void putTheTopic(Topic topic, String id) {
		topics.forEach(item -> { 
			      if (item.getId().equals(id))		
				     topics.set(topics.indexOf(item), topic);
		});
		return;
	}

	public void deleteTopicById(String id) {
		topics.removeIf(t -> t.getId().equals(id));		
		return;
	}
	
}
