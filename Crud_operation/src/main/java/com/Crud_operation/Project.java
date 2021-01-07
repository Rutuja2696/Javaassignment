package com.Crud_operation;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Project 
{
   private int p_no;
   private String p_name;
   private int p_duration;
   private String p_platform;
public int getP_no() {
	return p_no;
}
public void setP_no(int p_no) {
	this.p_no = p_no;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public int getP_duration() {
	return p_duration;
}
public void setP_duration(int p_duration) {
	this.p_duration = p_duration;
}
public String getP_platform() {
	return p_platform;
}
public void setP_platform(String p_platform) {
	this.p_platform = p_platform;
}
@Override
public String toString() {
	return "Project [p_no=" + p_no + ", p_name=" + p_name + ", p_duration=" + p_duration + ", p_platform=" + p_platform
			+ "]";
}
   
}
