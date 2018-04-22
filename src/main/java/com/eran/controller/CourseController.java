package com.eran.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eran.model.Course;
import com.eran.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;

	private static Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCourse(@RequestParam Integer courseId, Model model) {
		log.debug("传统url");
		Course course = courseService.getCourseById(1);
		model.addAttribute(course);
		return "course_overview";
	}

	// restful风格的url
	@RequestMapping(value = "/view2/{courseId}", method = RequestMethod.GET)
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> map) {
		log.debug("restfrl风格url");
		Course course = courseService.getCourseById(1);
		map.put("course", course);
		return "course_overview";
	}

	// 传统HttpServletRequest方式
	@RequestMapping(value = "view3")
	public String viewCourse3(HttpServletRequest request) {
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		Course course = courseService.getCourseById(courseId);
		request.setAttribute("course", course);
		return "course_overview";
	}

	// bind,将请求中按名字匹配的规则填入后台对象中
	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String courseAdd() {
		return "course_admin/course_edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String doSave(Course course) {
		// 业务操作
		course.setCourseId(123);
		return "redirect:view2/" + course.getCourseId();
	}

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String doSave2(@ModelAttribute Course course) {
		// 业务操作
		course.setCourseId(123);
		return "redirect:view2/" + course.getCourseId();
	}

	// 文件上传
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "course_admin/files";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String originalFilename = file.getOriginalFilename();
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File("/Users/liyiran", System.currentTimeMillis() + originalFilename));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "success";
	}

	// springmvc 和json协同工作
	// 1.RequestBody方式，简洁
	@RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
	public @ResponseBody Course getCourseJson(@PathVariable Integer courseId) {
		log.debug("##################json_ResoponseBody###############");
		return courseService.getCourseById(123);
	}

	// 2.ResponseEntity方式，springMVC提供的
	@RequestMapping(value = "/jsontype/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<Course> getCourseJson2(@PathVariable Integer courseId) {
		log.debug("####################json_ResoponseEntity####################");
		Course couse = courseService.getCourseById(13);
		return new ResponseEntity<Course>(couse, HttpStatus.OK);
	}

	// 3.利用json和前段ajax等前端技术可以实现页面的异步加载，更好的解决了controller的模块化和轻量化；

}
