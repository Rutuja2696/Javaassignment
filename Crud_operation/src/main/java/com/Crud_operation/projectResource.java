package com.Crud_operation;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
@Path("project")
public class projectResource 
{
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Project> getproject() throws ClassNotFoundException
	{
		projectRepository prepo=new projectRepository();
		System.out.println("getprojects called...");
		return prepo.getProject();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("oneproj/{pno}")
	public Project getoneproject(@PathParam("pno")int pno) throws ClassNotFoundException
	{
		projectRepository prepo=new projectRepository();
		System.out.println("getprojects called...");
		return prepo.getoneProject(pno);
	}
	
	@POST
	@Path("insertproj")
	public Project insertstudent(Project p1) throws ClassNotFoundException
	{
		projectRepository prepo=new projectRepository();
		System.out.println(p1);
		prepo.insert(p1);
		return p1;
	}
	
	@PUT
	@Path("updateproj")
	public Project updatestudent(Project p1) throws ClassNotFoundException
	{
		projectRepository prepo=new projectRepository();
		System.out.println(p1);
		prepo.update(p1);
		return p1;
	}
	@DELETE
	@Path("deleteproj/{p_no}")
	public Project Deletestudent(@PathParam("p_no") int p_no) throws ClassNotFoundException
	{
		projectRepository prepo=new projectRepository();
		Project p=prepo.getoneProject(p_no);
		if(p.getP_no()!=0)
		{
		   prepo.delete(p_no);
		}
		return p;
	}
}
