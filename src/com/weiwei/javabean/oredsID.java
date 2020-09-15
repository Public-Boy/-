package com.weiwei.javabean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class oredsID {
	   public static synchronized String generateUniqueKey(){
	        Random random = new Random();
	        Integer r = random.nextInt(900000000) + 100000000;
	        Long timeMillis = System.currentTimeMillis();
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	        String timeStr = sdf.format(new Date());
	        String idname="S";
	        return idname+timeStr+ r;
	    }
	   
	   public static synchronized int piao(){
		   Random random = new Random();
	       Integer ra = random.nextInt(900000000) + 1000000000;
		   return ra;
	   }
	   
}
