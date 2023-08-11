package bitedu.bipa.PEB.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
	
	public static String getDateInfo(int type) {
		// ?���??��?�� ???��(3�?�?)?�� ?��?�� ?��보�?? 리턴?��?��.
		// ?��?��?�� ?��분초(?��머�?)
		// ?��?��?��(0)
		// ?��분초(1)
		String info = null;
		//SimpleDateFormat?�� ?��?��?��?�� 코드�? ?��?��?��?��?��.
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		info = sdf.format(new Date());
		if(type==0) {
			info = info.split(" ")[0];
		} else if(type==1) {
			info = info.split(" ")[1];
		}
		return info;
	}
	
	public static String getDateInfo(int type,Date date) {
		// ?���??��?�� ???��(3�?�?)?�� ?��?�� ?��보�?? 리턴?��?��.
		// ?��?��?�� ?��분초(?��머�?)
		// ?��?��?��(0)
		// ?��분초(1)
		String info = null;
		//SimpleDateFormat?�� ?��?��?��?�� 코드�? ?��?��?��?��?��.
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		info = sdf.format(date);
		if(type==0) {
			info = info.split(" ")[0];
		} else if(type==1) {
			info = info.split(" ")[1];
		}
		return info;
	}
}
