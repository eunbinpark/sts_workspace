package bitedu.bipa.PEB.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
	
	public static String getDateInfo(int type) {
		// ?μ²??? ???(3κ°?μ§?)? ?°?Ό ? λ³΄λ?? λ¦¬ν΄??€.
		// ???Ό ?λΆμ΄(?λ¨Έμ?)
		// ???Ό(0)
		// ?λΆμ΄(1)
		String info = null;
		//SimpleDateFormat? ?΄?©??¬ μ½λλ₯? ??±???€.
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
		// ?μ²??? ???(3κ°?μ§?)? ?°?Ό ? λ³΄λ?? λ¦¬ν΄??€.
		// ???Ό ?λΆμ΄(?λ¨Έμ?)
		// ???Ό(0)
		// ?λΆμ΄(1)
		String info = null;
		//SimpleDateFormat? ?΄?©??¬ μ½λλ₯? ??±???€.
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
