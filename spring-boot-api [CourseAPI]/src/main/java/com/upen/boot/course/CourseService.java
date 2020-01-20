package com.upen.boot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository; 
	
	public List<Course> getAllCourses(String topicid) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicid).forEach(courses::add); // lambda expressions, method reference.
		return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
