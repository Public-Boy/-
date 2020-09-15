package com.weiwei.Entity;

public class Box {
	private int Bid;
	private String Bname;
	private String Bmobli;
	private String Btitle;
	private String Bboby;
	public int getBid() {
		return Bid;
	}
	public String getBname() {
		return Bname;
	}
	public String getBmobli() {
		return Bmobli;
	}
	public String getBtitle() {
		return Btitle;
	}
	public String getBboby() {
		return Bboby;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public void setBmobli(String bmobli) {
		Bmobli = bmobli;
	}
	public void setBtitle(String btitle) {
		Btitle = btitle;
	}
	public void setBboby(String bboby) {
		Bboby = bboby;
	}
	public Box(int bid, String bname, String bmobli, String btitle, String bboby) {
		super();
		Bid = bid;
		Bname = bname;
		Bmobli = bmobli;
		Btitle = btitle;
		Bboby = bboby;
	}
	public Box(String bname, String bmobli, String btitle, String bboby) {
		super();
		Bname = bname;
		Bmobli = bmobli;
		Btitle = btitle;
		Bboby = bboby;
	}
	public Box() {
		super();
	}
	@Override
	public String toString() {
		return "Box [Bid=" + Bid + ", Bname=" + Bname + ", Bmobli=" + Bmobli + ", Btitle=" + Btitle + ", Bboby=" + Bboby
				+ "]";
	}
	
	
	
}
