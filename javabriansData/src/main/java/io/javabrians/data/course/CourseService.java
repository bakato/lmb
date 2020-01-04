package io.javabrians.data.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllTheCourses(String id){
		List<Course> courses = new ArrayList<>();		
		courseRepository.findByTopicId(id).forEach(courses::add);
		return courses;
	}
	
	public Course getCourseById (String id) {
		return courseRepository.findById(id).get();
	}
	
	public void addTheCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course, String id) {	
		courseRepository.findAll().forEach(item -> { 			
			if (item.getId().equals(id)) {
				courseRepository.delete(item);
				courseRepository.save(course);
			}
		});
	}

	public void deleteCourseById(String id) {
		courseRepository.deleteById(id);		
	}

}
