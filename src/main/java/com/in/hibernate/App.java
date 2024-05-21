package com.in.hibernate;

import java.util.List;
import java.util.Scanner;

import com.in.hibernate.dao.StudentDao;
import com.in.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static Scanner sc = new Scanner(System.in);
//	public static Student student;
	public static StudentDao studentDao=new StudentDao();
	public static void addStudent() {
		System.out.println("Enter your Details here");
		System.out.println("Enter the Student Id");
		int id=sc.nextInt();
		System.out.println("Enter Student Name");
		String name=sc.next();
		System.out.println("Enter the Student Age");
		int age=sc.nextInt();
		System.out.println("Enter the Student Grade");
		String Grade= sc.next();
		Student student = new Student(id, name, age, Grade);
		studentDao.addStudent(student);
	}
	
	public static void getAllStudent() {
		System.out.println("The List of student is");
		List<Student> student=studentDao.getAllStudent();
		for(Student s :student) {
			System.out.println(s.getStudentId()+" "+s.getName()+" "+s.getAge()+" "+s.getGrade());
		}

	}
	public static void updateStudent() {
		System.out.println("Enter the student Id for update the student");
		int id = sc.nextInt();
		System.out.println("Enter The updated Name");
		String name=sc.next();
		System.out.println("Enter the Student age");
		int age=sc.nextInt();
		System.out.println("Enter the Student Grade");
		String Grade= sc.next();
		studentDao.updateStudent(id, new Student(id, name, age, Grade));
	}
	
	public static void deleteStudent() {
		System.out.println("Enter the Student id");
		int id=sc.nextInt();
		studentDao.deletestudent(id);
	}
	

    public static void main( String[] args )
    {
       while(true) {
    	   System.out.println("Student Management System :-");
    	   System.out.println("1 : Add the student");
    	   System.out.println("2 : Get all Student");
    	   System.out.println("3 : Update the Student By id");
    	   System.out.println("4 : Delete the Student By id");
    	   System.out.print("Enter your choice: ");
    	   int choice=sc.nextInt();
    	   switch(choice) {
    	   case 1:addStudent();
    	   break;
    	   case 2:getAllStudent();
    	   break;
    	   case 3:updateStudent();
    	   break;
    	   case 4:deleteStudent();
    	   break;
    	   default:System.out.println("Please enter the Given Number");
    	   }
    	   
       }
        
    }
}
