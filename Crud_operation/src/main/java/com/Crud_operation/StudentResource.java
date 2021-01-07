package com.Crud_operation;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("student")
public class StudentResource
{
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getstudent() throws ClassNotFoundException
	{
		StudentRepository srepo=new StudentRepository();
		System.out.println("getstudents called...");
		return srepo.getStudent();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("onestud/{sno}")
	public Student getonestudent(@PathParam("sno")int sno) throws ClassNotFoundException
	{
		StudentRepository srepo=new StudentRepository();
		System.out.println("getStudents called...");
		return srepo.getonestudent(sno);
	}
	
	@POST
	@Path("insertstud")
	public Student insertstudent(Student s1) throws ClassNotFoundException
	{
		StudentRepository srepo=new StudentRepository();
		System.out.println(s1);
		srepo.insert(s1);
		return s1;
	}
	
	@PUT
	@Path("updatestud")
	public Student updatestudent(Student s1) throws ClassNotFoundException
	{
		StudentRepository srepo=new StudentRepository();
		System.out.println(s1);
		srepo.update(s1);
		return s1;
	}
	
	@DELETE
	@Path("deletestud/{s_no}")
	public Student Deletestudent(@PathParam("s_no") int s_no) throws ClassNotFoundException
	{
StudentRepository srepo=new StudentRepository();
		Student s=srepo.getonestudent(s_no);
		if(s.getS_no()!=0)
		{
		   srepo.delete(s_no);
		}
		return s;
	}
	
}

