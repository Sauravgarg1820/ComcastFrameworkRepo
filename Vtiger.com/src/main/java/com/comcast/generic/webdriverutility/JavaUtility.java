package com.comcast.generic.webdriverutility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int ranDomNumber = random.nextInt(5000);
		return ranDomNumber;
	}

	public String getSystemDateYYYYMMDD() {
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actualdate = sim.format(date);
		return actualdate;
		}
	public String getRequiredDateyyyymmdd(int days) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate = sim.format(cal.getTime());
		return reqdate;
	}
	
}
