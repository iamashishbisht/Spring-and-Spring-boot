package MyPackage.Controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ClassPackagePOJO.Student;
import ClassPackagePOJO.StudentError;

@RestController
@RequestMapping("/student")
public class MyRestController {
	
	@RequestMapping("/list")
	public Student StudentList()
	{
		Student theStudent = new Student("Ashish","Bisht",24);
		
		return theStudent;
		
	}
	
	@RequestMapping("/lists")
	public ArrayList<Student> StudentsList()
	{
		ArrayList<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("Ashish","Bisht",23));
		studentList.add(new Student("Ashi","Bisht",20));
		studentList.add(new Student("Ashu","Bisht",22));
		studentList.add(new Student("Ashish","Bisht1",24));
		
		return studentList;
		
	}
	
	
	@RequestMapping("/lists/{studentId}")
	public Student StudentsListWithPathVariable(@PathVariable int studentId)
	{
		ArrayList<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("Ashish","Bisht",23));
		studentList.add(new Student("Ashi","Bisht",20));
		studentList.add(new Student("Ashu","Bisht",22));
		studentList.add(new Student("Ashish","Bisht1",24));
		
		if (studentId < 0 || studentId > studentList.size())
		  {
			throw new RuntimeException("Invalid parameter value in url");
		  }
		
		return studentList.get(studentId);
		
	}

	
	
}
