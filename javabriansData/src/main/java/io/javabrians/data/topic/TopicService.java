package io.javabrians.data.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllArrayListTopics(){
		List<Topic> topics = new ArrayList<>();		
		topicRepository.findAll().forEach(topics::add);		
		return topics;
	}
	
	public Topic getTopicById (String id) {
		return topicRepository.findById(id).get();
	}
	
	public void addTheTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {	
		topicRepository.findAll().forEach(item -> { 			
			if (item.getId().equals(id)) {
				topicRepository.delete(item);
				topicRepository.save(topic);
			}
		});
	}

	public void deleteTopicById(String id) {
		topicRepository.deleteById(id);		
	}
	
}
