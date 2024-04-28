package com.nt.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.binding.Student;
import com.nt.entiry.StudentEntity;
import com.nt.repository.StudentRepository;

@Controller
public class StudentController {
	/*
	 * i want insert my record in to my database table . to do that first will be
	 * understand there will be StudentRpository(to insert record in to the database
	 * let me inject the studentRepository in the StudentController)
	 */
	@Autowired
	private StudentRepository repo;
	
	/* Method load the form */
	@GetMapping("/")
	public String loadForm(Model model) {
		loadFormData(model);
		return "index";
		
	}

	private void loadFormData(Model model) {
		List<String>coursesList=new ArrayList<>();
		coursesList.add("Core Java");
		coursesList.add("Jakarta Enterprise Edition(Servlet,Jdbc,JSP)");
		coursesList.add("Html Css JavaScript");
		coursesList.add("Oracle(SQL/PLSQL)");
		coursesList.add("React");
		coursesList.add("Spring Core");
		coursesList.add("SpringBoot and Microservices");
		coursesList.add("Selenium");
		
		/*add timings*/
		List<String> timingsList=new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");
		timingsList.add("Night");
		
		/*how to send data to the UI.   to send data to UI we are using model.addAttribute(); */
		model.addAttribute("courses", coursesList);
		model.addAttribute("timings", timingsList);
		
		/* i am going to create one Student Object*/ 
		Student student=new Student();
		model.addAttribute("student" , student);
	}
	
	
	/* Method save our data */
	@PostMapping("/save") // this method i want to bind to the post request for that i am using post Mapping 
	public String handleSubmit(Student s , Model model) {
		/*
		 * when ever submit the form form data coming in to the controller method in the
		 * form of student object but repository is excepting entity Object...so we need
		 * to copy the data from student(binding) object to student entity object
		 */
		StudentEntity entity=new StudentEntity();
		//copy the data binding object to entity object
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings()));
		repo.save(entity);
		
		model.addAttribute("msg","Student Saved");
		loadFormData(model);
		return "index";
		
		/*
		 * ==========================================================================
		 * i am handeld handleSubmit method which is binded to the PostMapping method
		 * when ever you save the form in browser the form data come to my method as a
		 * parameter in the form of object once i get that obejct data i am going to
		 * save that data. we need a entity(entity object) is created actual data
		 * available in binding object but my save() method excepting entiy object . i
		 * am copy the data student obejct to the entity object and i am calling
		 * repo.save()
		 * ===========================================================================
		 * 
		 * =====================================================================
		 * first of it will give error coz i did not mentaion generated value. it is mandatory
		 * 
		 * 
		 * 
		 * ==================================================================================================
		 * when ever copying in the data from binding object to entity object all field are copy but timings are not copy coz of data
		 * type mismatch coz i gave array type to slect multiple record that why this timing field did not copy so in that situation 
		 * we add manually
		 */

	}
	
	//method to disply save student data by using hyperlink
	
	@GetMapping("/viewStudents") /* i want bind the method to the get request for that purpose use @GetMapping */
	public String getStudentsData(Model model) {
		// logic to fetch and send Student data in UI
		   List<StudentEntity>studentList=repo.findAll(); // it give list of student 
			/*
			 * so this student data we can send to the UI again we send to the entity again
			 * we can convert data in to binding object and send binding object to the UI so
			 * i dont do that i am directly send Student entity data to the UI
			 */
		   
		   // to send the data to UI we use 
		                                                               //Value
		   model.addAttribute("students", studentList);
		   
		return "data";
	}
		
}






















