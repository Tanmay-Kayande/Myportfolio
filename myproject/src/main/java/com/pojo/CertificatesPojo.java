package com.pojo;

public class CertificatesPojo {

	private int sn;
	private String certificate;
	private String institution;
	private String year;
	private String desc;
	
	public CertificatesPojo(int sn, String certificate, String institution, String year, String desc) {
		super();
		this.sn = sn;
		this.certificate = certificate;
		this.institution = institution;
		this.year = year;
		this.desc = desc;
	}

	public int getSn() {
		return sn;
	}

	public String getCertificate() {
		return certificate;
	}

	public String getInstitution() {
		return institution;
	}

	public String getYear() {
		return year;
	}

	public String getDesc() {
		return desc;
	}
	
	
}
