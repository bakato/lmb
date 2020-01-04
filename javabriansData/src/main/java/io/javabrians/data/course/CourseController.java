package io.javabrians.data.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrians.data.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllTheCourses(id);
	}
	
	@RequestMapping (method = RequestMethod.GET, value = "/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable  String id) {		
		return courseService.getCourseById(id);
	}
	
	@RequestMapping (method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addTheCourse(course);
	}
	
	@RequestMapping (method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void putCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course, id);
	}
	
	@RequestMapping (method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable  String id) {
		courseService.deleteCourseById(id);
	}
}
