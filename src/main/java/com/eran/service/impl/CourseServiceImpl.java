package com.eran.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.eran.model.Chapter;
import com.eran.model.Course;
import com.eran.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	public Course getCourseById(Integer courseId) {
		Course course = new Course();
		course.setCourseId(1);
		course.setTitle("JAVA SE学习");
		course.setLevel(5);
		course.setLevelDesc("很好学习");
		course.setLeaningNum(11);
		course.setDescr("适合Java新手学习");
		course.setDuration(12);
		course.setImgPath("resources/imgs/icon.jpg");
		
		Chapter chapter1 = new Chapter("java数据类型", "基本数据类型，引用数据类型", "java数据类型分两类，基本数据类型和引用数据类，基本数据类型又分为四类，细分为八种");
		Chapter chapter2 = new Chapter("java IO流", "InputStream，Reader", "java数据流分类两类，字节流和字符流");
		ArrayList<Chapter> list = new ArrayList<Chapter>();
		list.add(chapter1);
		list.add(chapter2);
		course.setChapterList(list);
		return course;
	}

}
