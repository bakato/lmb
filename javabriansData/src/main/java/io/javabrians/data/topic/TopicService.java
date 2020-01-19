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
		List<Topic> topicList = new ArrayList<>();		
		topicRepository.findAll().forEach(topicList::add);	
		if (topicList.isEmpty())
			throw new UserNotFoundException("No record in the database");
		
		return topicList;
	}
	
	public Topic getTopicById (String id) {
		Topic topic = null;		
		try {
			topic = topicRepository.findById(id).get();
		}
		catch(Exception ex) {
			throw new UserNotFoundException("id = '"+id+"'  could not be found");
		}		
		return topic;			
	}
	
	public Topic addTheTopic(Topic topic) {
		return topicRepository.save(topic);
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
		Topic topic = this.getTopicById(id);
		if (topic != null)
		     topicRepository.deleteById(id);		
	}
	
}
