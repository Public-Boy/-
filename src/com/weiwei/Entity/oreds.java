package com.weiwei.Entity;

import java.util.Date;

public class oreds {
	private int oid;
	private String onumber;
	private String ousername;
	private String oname;
	private String ousercar;
	private String ograde;
	private String ouname;
	private String omoble;
	private Date otime;
	private String ofid;
	private int opiao;
	private String ozt;
	public int getOid() {
		return oid;
	}
	public String getOnumber() {
		return onumber;
	}
	public String getOusername() {
		return ousername;
	}
	public String getOname() {
		return oname;
	}
	public String getOusercar() {
		return ousercar;
	}
	public String getOgrade() {
		return ograde;
	}
	public String getOuname() {
		return ouname;
	}
	public String getOmoble() {
		return omoble;
	}
	public Date getOtime() {
		return otime;
	}
	public String getOfid() {
		return ofid;
	}
	public int getOpiao() {
		return opiao;
	}
	public String getOzt() {
		return ozt;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	public void setOusername(String ousername) {
		this.ousername = ousername;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public void setOusercar(String ousercar) {
		this.ousercar = ousercar;
	}
	public void setOgrade(String ograde) {
		this.ograde = ograde;
	}
	public void setOuname(String ouname) {
		this.ouname = ouname;
	}
	public void setOmoble(String omoble) {
		this.omoble = omoble;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public void setOfid(String ofid) {
		this.ofid = ofid;
	}
	public void setOpiao(int opiao) {
		this.opiao = opiao;
	}
	public void setOzt(String ozt) {
		this.ozt = ozt;
	}
	public oreds(int oid, String onumber, String ousername, String oname, String ousercar, String ograde, String ouname,
			String omoble, Date otime, String ofid, int opiao, String ozt) {
		super();
		this.oid = oid;
		this.onumber = onumber;
		this.ousername = ousername;
		this.oname = oname;
		this.ousercar = ousercar;
		this.ograde = ograde;
		this.ouname = ouname;
		this.omoble = omoble;
		this.otime = otime;
		this.ofid = ofid;
		this.opiao = opiao;
		this.ozt = ozt;
	}
	public oreds(String onumber, String ousername, String oname, String ousercar, String ograde, String ouname,
			String omoble, Date otime, String ofid, int opiao, String ozt) {
		super();
		this.onumber = onumber;
		this.ousername = ousername;
		this.oname = oname;
		this.ousercar = ousercar;
		this.ograde = ograde;
		this.ouname = ouname;
		this.omoble = omoble;
		this.otime = otime;
		this.ofid = ofid;
		this.opiao = opiao;
		this.ozt = ozt;
	}
	public oreds() {
		super();
	}
	@Override
	public String toString() {
		return "oreds [oid=" + oid + ", onumber=" + onumber + ", ousername=" + ousername + ", oname=" + oname
				+ ", ousercar=" + ousercar + ", ograde=" + ograde + ", ouname=" + ouname + ", omoble=" + omoble
				+ ", otime=" + otime + ", ofid=" + ofid + ", opiao=" + opiao + ", ozt=" + ozt + "]";
	}

	
	
	
}
