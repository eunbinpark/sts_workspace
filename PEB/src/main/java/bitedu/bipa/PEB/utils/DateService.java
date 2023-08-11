package bitedu.bipa.PEB.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
	
	public static String getDateInfo(int type) {
		// ?š”ì²??˜?Š” ???…(3ê°?ì§?)?— ?”°?¼ ? •ë³´ë?? ë¦¬í„´?•œ?‹¤.
		// ?…„?›”?¼ ?‹œë¶„ì´ˆ(?‚˜ë¨¸ì?)
		// ?…„?›”?¼(0)
		// ?‹œë¶„ì´ˆ(1)
		String info = null;
		//SimpleDateFormat?„ ?´?š©?•˜?—¬ ì½”ë“œë¥? ?‘?„±?•˜?‹œ?˜¤.
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
		// ?š”ì²??˜?Š” ???…(3ê°?ì§?)?— ?”°?¼ ? •ë³´ë?? ë¦¬í„´?•œ?‹¤.
		// ?…„?›”?¼ ?‹œë¶„ì´ˆ(?‚˜ë¨¸ì?)
		// ?…„?›”?¼(0)
		// ?‹œë¶„ì´ˆ(1)
		String info = null;
		//SimpleDateFormat?„ ?´?š©?•˜?—¬ ì½”ë“œë¥? ?‘?„±?•˜?‹œ?˜¤.
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
