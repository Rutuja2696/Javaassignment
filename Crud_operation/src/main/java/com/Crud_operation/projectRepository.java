package com.Crud_operation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class projectRepository 
{
  Connection con=null;
  public projectRepository() throws ClassNotFoundException
  {
	  String url="jdbc:mysql://localhost:3306/mydb";
	   String username="root";
	   String password="Rutuja@1996";
	   try {
		   
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public List<Project> getProject()
  {
	  List<Project> pro=new ArrayList<>();
	   String sql="select * from PROJECT";
	   try {
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Project p=new Project();
			p.setP_no(rs.getInt(1));
			p.setP_name(rs.getString(2));
			p.setP_duration(rs.getInt(3));
			p.setP_platform(rs.getString(4));
			pro.add(p);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return pro;
  }
  
  public Project getoneProject(int pno)
  {
	   Project p=new Project();
	   String sql="select * from PROJECT where PRJ_NO="+pno;
	   try {
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			p.setP_no(rs.getInt(1));
			p.setP_name(rs.getString(2));
			p.setP_duration(rs.getInt(3));
			p.setP_platform(rs.getString(4));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return p;
  }
  
  
  public void insert(Project p1)
  {
	   String sql="insert into PROJECT values(?,?,?,?)";
	   try {
			PreparedStatement st= con.prepareStatement(sql);
		    st.setInt(1,p1.getP_no());
		    st.setString(2, p1.getP_name());
		    st.setInt(3, p1.getP_duration());
		    st.setString(4, p1.getP_platform());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void update(Project p1)
  {
	   String sql="update PROJECT set PRJ_NAME=? where PRJ_NO=?";
	   try {
			PreparedStatement st= con.prepareStatement(sql);
		    st.setString(1, p1.getP_name());
		    st.setInt(2, p1.getP_no());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void delete(int pno)
  {
	   String sql="Delete from PROJECT where PRJ_NO=?";
	   try {
			PreparedStatement st= con.prepareStatement(sql);
		    st.setInt(1,pno);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
