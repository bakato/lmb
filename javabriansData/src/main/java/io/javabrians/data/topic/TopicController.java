package io.javabrians.data.topic;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Topic> addTopic(@Valid @RequestBody Topic topic) {		
        Topic savedTopic = topicService.addTheTopic(topic);
		
		URI location = ServletUriComponentsBuilder
		         .fromCurrentRequest()
		         .path("/{id}")
		         .buildAndExpand(savedTopic.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping (method = RequestMethod.PUT, value = "/topics/{id}")
	public void putTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping (method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable  String id) {
		topicService.deleteTopicById(id);
	}
}
