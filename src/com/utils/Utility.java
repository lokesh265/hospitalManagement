package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

	public static java.sql.Date stringToSqlDate(Long str) throws ParseException{
		System.out.println("Received Date is: "+str);
		/*SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf1.parse(str);
		System.out.println("Converted Util Date: "+date);*/
		java.sql.Date sqlDate = new java.sql.Date(str); 
		System.out.println("Converted SQL Date: "+sqlDate);
		return sqlDate;
	}
}
