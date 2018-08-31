package Handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分页插件<hr>
 * <h2>这个插件只是提供判断了页码是否符合规范(是否为数字，是否超出范围等等)、
 * 获取需要的总页数pageSize----需要传入total(数据库查询出来的总记录数)和records(每页多少条数据)作为参数、
 * 获取当前的页码数pageNo----需要事先传入pageSize的功能<hr>
 * </h2>
 * 方法调用顺序为：getTotalPage()、getCurrentPage()、getIndex();
 * @author taominqi
 *
 */
public class PageUtil {
	
	
	/**
	 * 页码转换----字符串转为int
	 * @param pn  传入的页码----默认String类型
	 * @return pageNo 转换后的页码
	 */
	public static int transformPage(String pn){
		/*
		 * 验证是否为空
		 */
		if(pn==null||pn==""){
			pn = "1";  //为空则变为第一页
		}
		/*
		 * 字符串判断，验证输入是否为数字
		 */
		Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(pn);
		   if( !isNum.matches() ){
		        pn="1";  //如果不是数字---变为字符串“1”
		   } 	   
		   int pageNo = Integer.parseInt(pn); //页码转换
		   return pageNo;
	}
	
	
	/**
	 * 获取总页数
	 * @param records 每页多少条记录 ---根据需要配合数据库的LIMIT ?,?设置, 第一个问号是每页数据在数据库的起始下标,第二个是每页显示几条数据
	 * @param total 总记录数---需要事先从数据库取得 ---SELECT count(*) FROM .... WHERE .... ....
	 * @return pageSize 总页数
	 */
	public static int getTotalPage(int records,int total){
		
		int pageSize = (total%records)==0?(total/records):((total/records)+1);
		return pageSize;
	}
	
	
	/**
	 * 查询的结果中每页记录的起始下标，从0开始<br>
	 * @param pageNo 传入的页码
	 * @param records 每页放几条记录
	 * @return index 返回当前页码的第一条记录的下标
	 */
	public static int getIndex(int pageNo,int records){
		int index = records*(pageNo-1);
		return index;
	}
	
	/**
	 * <h2>调用这个方法前需要先调用getTotalPage()来获取总页数</h2><hr>
	 * 获取当前的页码用于传递到前台显示(点击了上一页或者下一页或者输入了页码跳转后的页面)<br>
	 * 同时这个方法也用来判断上一页是否到头，或者下一页是否到底<hr>
	 * @param pn 前台传入的页码数据(可以是任何字符串)
	 * @param pageSize 总页数
	 * @return pageNo 返回需要显示的页码
	 */
	public static int getCurrentPageNo(String pn,int pageSize){
		int pageNo = transformPage(pn);
		if(pageNo<=0){  //到头了则跳转到最后一页
			pageNo=pageSize;
		}else if(pageNo>pageSize){  //到底了则跳转到第一页
			pageNo=1;
		}
		return pageNo;
	}
	 

}
