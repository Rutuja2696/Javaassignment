package com.Crud_operation;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Student 
{
	Date d=new Date();  

   private int s_no;
   private String s_name;
   private Date s_Dob;
   private Date s_Doj;
public int getS_no() {
	return s_no;
}
public void setS_no(int s_no) {
	this.s_no = s_no;
}
public String getS_name() {
	return s_name;
}
public void setS_name(String s_name) {
	this.s_name = s_name;
}
public Date getS_Dob() {
	return s_Dob;
}
public void setS_Dob(Date s_Dob) {
	this.s_Dob = s_Dob;
}
public Date getS_Doj() {
	return s_Doj;
}
@Override
public String toString() {
	return "Student [s_no=" + s_no + ", s_name=" + s_name + ", s_Dob=" + s_Dob + ", s_Doj=" + s_Doj + "]";
}
public void setS_Doj(Date s_Doj) {
	this.s_Doj = s_Doj;
}

}
