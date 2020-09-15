package com.weiwei.Entity;

import java.util.Date;

public class flight {
	private int fid;
	private String fname;    			
	private String fchufa;
	private String fdaoda;
	private String fchufajichang;
	private String fdaodajichang;
	private String fchutime;
	private String fdaotime;
	private Date ftime;
	private String ffp;
	private String fbp;
	private String fep;
	private String ff;
	private String fb;
	private String fe;
	public int getFid() {
		return fid;
	}
	public String getFname() {
		return fname;
	}
	public String getFchufa() {
		return fchufa;
	}
	public String getFdaoda() {
		return fdaoda;
	}
	public String getFchufajichang() {
		return fchufajichang;
	}
	public String getFdaodajichang() {
		return fdaodajichang;
	}
	public String getFchutime() {
		return fchutime;
	}
	public String getFdaotime() {
		return fdaotime;
	}
	public Date getFtime() {
		return ftime;
	}
	public String getFfp() {
		return ffp;
	}
	public String getFbp() {
		return fbp;
	}
	public String getFep() {
		return fep;
	}
	public String getFf() {
		return ff;
	}
	public String getFb() {
		return fb;
	}
	public String getFe() {
		return fe;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setFchufa(String fchufa) {
		this.fchufa = fchufa;
	}
	public void setFdaoda(String fdaoda) {
		this.fdaoda = fdaoda;
	}
	public void setFchufajichang(String fchufajichang) {
		this.fchufajichang = fchufajichang;
	}
	public void setFdaodajichang(String fdaodajichang) {
		this.fdaodajichang = fdaodajichang;
	}
	public void setFchutime(String fchutime) {
		this.fchutime = fchutime;
	}
	public void setFdaotime(String fdaotime) {
		this.fdaotime = fdaotime;
	}
	public void setFtime(Date ftime) {
		this.ftime = ftime;
	}
	public void setFfp(String ffp) {
		this.ffp = ffp;
	}
	public void setFbp(String fbp) {
		this.fbp = fbp;
	}
	public void setFep(String fep) {
		this.fep = fep;
	}
	public void setFf(String ff) {
		this.ff = ff;
	}
	public void setFb(String fb) {
		this.fb = fb;
	}
	public void setFe(String fe) {
		this.fe = fe;
	}
	public flight(int fid, String fname, String fchufa, String fdaoda, String fchufajichang, String fdaodajichang,
			 Date ftime,String fchutime, String fdaotime, String ffp, String fbp, String fep, String ff, String fb,
			String fe) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fchufa = fchufa;
		this.fdaoda = fdaoda;
		this.fchufajichang = fchufajichang;
		this.fdaodajichang = fdaodajichang;
		this.fchutime = fchutime;
		this.fdaotime = fdaotime;
		this.ftime = ftime;
		this.ffp = ffp;
		this.fbp = fbp;
		this.fep = fep;
		this.ff = ff;
		this.fb = fb;
		this.fe = fe;
	}
	public flight(String fname, String fchufa, String fdaoda, String fchufajichang, String fdaodajichang,
			 Date ftime, String fchutime, String fdaotime,String ffp, String fbp, String fep, String ff, String fb,
			String fe) {
		super();
		this.fname = fname;
		this.fchufa = fchufa;
		this.fdaoda = fdaoda;
		this.fchufajichang = fchufajichang;
		this.fdaodajichang = fdaodajichang;
		this.fchutime = fchutime;
		this.fdaotime = fdaotime;
		this.ftime = ftime;
		this.ffp = ffp;
		this.fbp = fbp;
		this.fep = fep;
		this.ff = ff;
		this.fb = fb;
		this.fe = fe;
	}
	public flight() {
		super();
	}
	@Override
	public String toString() {
		return "flight [fid=" + fid + ", fname=" + fname + ", fchufa=" + fchufa + ", fdaoda=" + fdaoda
				+ ", fchufajichang=" + fchufajichang + ", fdaodajichang=" + fdaodajichang + ", fchutime=" + fchutime
				+ ", fdaotime=" + fdaotime + ", ftime=" + ftime + ", ffp=" + ffp + ", fbp=" + fbp + ", fep=" + fep
				+ ", ff=" + ff + ", fb=" + fb + ", fe=" + fe + "]";
	}
	

	
}
