package io.javabrians.com.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/topics")
	public List<Topic> getAllTopics(){
	
		return topicService.getAllArrayListTopics();
	}
	
	@RequestMapping (method = RequestMethod.GET, value = "/topics/{id}")
	public Topic getTopic(@PathVariable  String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping (method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTheTopic(topic);
	}
	
	@RequestMapping (method = RequestMethod.PUT, value = "/topics/{id}")
	public void putTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.putTheTopic(topic, id);
	}
	
	@RequestMapping (method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable  String id) {
		topicService.deleteTopicById(id);
	}
}
