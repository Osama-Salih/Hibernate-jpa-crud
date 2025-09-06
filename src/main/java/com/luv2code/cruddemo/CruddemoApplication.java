package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			getStudents(studentDAO);
//			getStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Num rows count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		student.setFirstName("John");

		studentDAO.update(student);

		System.out.println("Updated student: " + student);
	}

	private void getStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");
		for (Student s : students)
			System.out.println(s);
	}

	private void getStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students)
			System.out.println(student);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student");
		Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

		System.out.println("Saving the student");
		studentDAO.save(student);

		int id = student.getId();
		System.out.println("Saved student. Generated id: " + id);

		Student savedStudent = studentDAO.findById(id);
		System.out.println("Found student: " + savedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students objects..");
		Student student1 = new Student("John", "Doe", "john@luv2code.com");
		Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student student3 = new Student("Bonita", "Appleebum", "bonita@luv2code.com");

		System.out.println("Saving students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student");
		Student student = new Student("Paul", "Doe", "paul@luv2code.com");

		System.out.println("Saving the student");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
