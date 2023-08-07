package bitedu.bipa.tiles.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
	
	public static String getDateInfo(int type) {
		// 요청되는 타입(3가지)에 따라 정보를 리턴한다.
		// 년월일 시분초(나머지)
		// 년월일(0)
		// 시분초(1)
		String info = null;
		//SimpleDateFormat을 이용하여 코드를 작성하시오.
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
		// 요청되는 타입(3가지)에 따라 정보를 리턴한다.
		// 년월일 시분초(나머지)
		// 년월일(0)
		// 시분초(1)
		String info = null;
		//SimpleDateFormat을 이용하여 코드를 작성하시오.
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
