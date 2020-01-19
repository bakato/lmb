package io.javabrians.data.topic;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties(value = {"name", "description"})
public class Topic {
	
	@Id	
//	@GeneratedValue
	private String id;
	
	@Size(min = 2, message = "Name should have at least 2 characters long")
	private String name;
	
//	@JsonIgnore
	private String description;
	
	@Past()
//	@ApiModelProperty(notes="not valid date")
	private Date publishedDate;

	public Topic() {

	}

	public Topic(String id, String name, String description, Date publishDate) {
	    super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.publishedDate = publishDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	

}
