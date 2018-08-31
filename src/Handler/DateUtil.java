package Handler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author taominqi
 *
 */
public class DateUtil {
	public static String getDateToMs() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式--精确到毫秒
		String time = df.format(new Date());
	//	System.out.println(time);// new Date()为获取当前系统时间
		return time;
		}
	
	public static String getDateToSs() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式--精确到秒
		String time = df.format(new Date());
	//	System.out.println(time);// new Date()为获取当前系统时间
		return time;
		}
	
	public static String getDateTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time = df.format(new Date());
		return time;
	}

}
