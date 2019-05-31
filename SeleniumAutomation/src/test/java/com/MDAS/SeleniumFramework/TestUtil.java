package com.MDAS.SeleniumFramework;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestUtil {
	
	//get current date time
	public static String now(String dateFormat){
		Calendar today = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(today.getTime());

}
}
