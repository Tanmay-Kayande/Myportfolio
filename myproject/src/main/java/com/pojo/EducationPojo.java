package com.pojo;

public class EducationPojo {
	
	private int sn;
	private String institution;
	private String degree;
	private String year;
	private String desc;
	
	public EducationPojo(int sn, String institution, String degree, String year, String desc) {
		super();
		this.sn = sn;
		this.institution = institution;
		this.degree = degree;
		this.year = year;
		this.desc = desc;
	}
	public int getSn() {
		return sn;
	}
	public String getInstitution() {
		return institution;
	}
	public String getDegree() {
		return degree;
	}
	public String getYear() {
		return year;
	}
	public String getDesc() {
		return desc;
	}
	
	
}
