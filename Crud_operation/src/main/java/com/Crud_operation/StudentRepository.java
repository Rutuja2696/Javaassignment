package com.Crud_operation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentRepository 
{
	 Connection con=null;
   public StudentRepository() throws ClassNotFoundException
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
   
   public List<Student> getStudent()
   {
	   List<Student> stud= new ArrayList<>();
	   String sql="select * from STUDENT";
	   try {
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Student s=new Student();
			s.setS_no(rs.getInt(1));
			s.setS_name(rs.getString(2));
			s.setS_Dob(rs.getDate(3));
			s.setS_Doj(rs.getDate(4));
			
			stud.add(s);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return stud;
   }
   

public void insert(Student s1)
   {
	   String sql="insert into STUDENT values(?,?,?,?)";
	   try {
		    java.util.Date d1=s1.getS_Dob();
		    java.sql.Date d2=new java.sql.Date(d1.getDate());
		    java.util.Date d3=s1.getS_Doj();
		    java.sql.Date d4=new java.sql.Date(d3.getDate());
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, s1.getS_no());
			st.setString(2, s1.getS_name());
			st.setDate(3,d2);
			st.setDate(4,d4);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }

public Student getonestudent(int sno)
{
	   
	   Student s=new Student();
	   String sql="select * from STUDENT where STUDENT_NO="+sno;
	   try {
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			s.setS_no(rs.getInt(1));
			s.setS_name(rs.getString(2));
			s.setS_Dob(rs.getDate(3));
			s.setS_Doj(rs.getDate(4));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return s;
}

public void update(Student s1)
{
	   String sql="update STUDENT set STUDENT_NAME=? where STUDENT_NO=?";
	   try {
			PreparedStatement st= con.prepareStatement(sql);
		    st.setString(1, s1.getS_name());
		    st.setInt(2, s1.getS_no());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

public void delete(int sno)
{
	   String sql="Delete from STUDENT where STUDENT_NO=?";
	   try {
			PreparedStatement st= con.prepareStatement(sql);
		    st.setInt(1,sno);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
