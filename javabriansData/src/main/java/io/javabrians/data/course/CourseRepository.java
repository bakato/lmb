package io.javabrians.data.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	// to create custom method:
	// key here is take:  findBy + propertie name of Entity module file ( i.e: id, name, description )  
	// --> findByName, findById, findByDescription, findByTopicId 
	// CrudRepository will take care of query and provides the right result.
	
	public List<Course> findByTopicId(String topicId);
	

}
