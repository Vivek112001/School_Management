package com.in.hibernate.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.in.hibernate.entity.Student;
import com.in.hibernate.utility.HibernateUtil;


public class StudentDao {
	
	public void addStudent(Student student) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction=null;
		try {
		 transaction=session.beginTransaction();
			
			session.save(student);
			transaction.commit();
;
			System.out.println(student.toString());
			System.out.println("Students records inserted successfully \n");
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	public List<Student> getAllStudent(){
		Session session = HibernateUtil.getSession();
		List<Student> student=new ArrayList<>();
		try {
			Query query = session.createQuery("from Student");
			 student=query.list();
		}catch (HibernateException e) {
			e.printStackTrace();
			
		}
		finally {
	        session.close();
		}
		return student;
	}
	
	public void updateStudent(int id, Student student) {
		Session session = HibernateUtil.getSession();
		int row=0;
		try {
			Query query = session.createQuery("update Student set name=:name, age=:age,grade=:grade where id = :id");
			query.setParameter("id", student.getStudentId());
			query.setParameter("name", student.getName());
			query.setParameter("age", student.getAge());
			query.setParameter("grade", student.getGrade());
			row=query.executeUpdate();
			if(row>0) {
				System.out.println("Student updated successfully");
			}else {
				System.out.println("Please filled the corret details");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}
	
	public void deletestudent(int id) {
		Session session = HibernateUtil.getSession();
		int row=0;
		try {
			Query query= session.createQuery ("delete from Student where id = :id");
			query.setParameter("id", id);
			row=query.executeUpdate();
			System.out.println(row);
			if(row>0) {
				System.out.println("Student deleted successfully");
			}else {
				System.out.println("Please filled the corret details");
			}
		} catch (HibernateException e) {
			e.printStackTrace(); 
		}
		finally {
			session.close();
		}
	}
}
