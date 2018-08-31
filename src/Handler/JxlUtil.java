package Handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.BaseQs;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 操作excel的类
 * 使用本类需要引入 jxl.jar包
 * @author taominqi
 *
 */
public class JxlUtil {
	
	/**
	 * 创建新的表格
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void createNewExcel(String path) throws IOException, RowsExceededException, WriteException{
		
		File file = new File(path);
		if(!file.exists()){
			file.createNewFile();
		}else{
			file.delete();
		}
		
		//新建一个xls文件----WwriteableWorkbook是写入的操作对象,book建立在新建的文件的流对象上
		WritableWorkbook book  =Workbook.createWorkbook(file);
		//下面是操作表---excel中的sheet   名为single,第一页
		WritableSheet sheet = book.createSheet("single", 0);
		//新建单元格，（0,0）表示第一列第一行,内容是‘单选题目’
		 Label labelTitle = new Label(0,0,"单选题目");
		 Label labelA = new Label(1,0,"选项A");  //选项A
		 Label labelB = new Label(2,0,"选项B");  //选项B
		 Label labelC = new Label(3,0,"选项C");  //选项C
		 Label labelD = new Label(4,0,"选项D");  //选项D
		 Label labelR = new Label(5,0,"参考答案");  //参考答案
		 //将单元格对象加入表对象中
		 sheet.addCell(labelTitle);
		 sheet.addCell(labelA);
		 sheet.addCell(labelB);
		 sheet.addCell(labelC);
		 sheet.addCell(labelD);
		 sheet.addCell(labelR);
		 //合并单元格
		 //前两个参数是合并前的位置，后两个是合并后的,合并后的单元格的列数还是之前的数字,不会因为合并而变化
		/* sheet.mergeCells(0, 0, 4, 0);
		 sheet.mergeCells(5, 0, 9, 0);
		 sheet.mergeCells(10, 0, 14, 0);
		 sheet.mergeCells(15, 0, 19, 0);
		 sheet.mergeCells(20, 0, 24,0);*/
		 
		 
		 
		 /*生成一个保存数字的单元格    
		      必须使用Number的完整包路径，否则有语法歧义    
	          单元格位置是第二列，第一行，值为123.456*/  
		   /*   jxl.write.Number num = new jxl.write.Number(0,1,123.456);
	          sheet.addCell(num);*/
		
		//将数据写入文件 
		 book.write();
		 book.close();
	}
	
	/**
	 * 读取excel文件
	 * @param path  路径
	 */
	public static Map<String,Object> readExcel(String path){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			Workbook book = Workbook.getWorkbook(new File(path));
			//获取第一个工作表的对象
			Sheet sheet = book.getSheet(0);
			//Sheet sheet = book.getSheet("single");
			int rows = sheet.getRows();
			int cols = sheet.getColumns();
			ArrayList<model.BaseQs> baseArr = new ArrayList<>();
			ArrayList<String> info = new ArrayList<>();
			if(cols!=6){//格式不对
				
				File old = new File(path);
				if(old.exists()){
					old.delete();
				}
				
				return null;
			}
			
			
			
			for(int row = 1;row<rows;row++){//第一行是标题行，不计入
				String r = sheet.getCell(5,row).getContents().trim();
				if(!("a".equals(r)||"b".equals(r)||"c".equals(r)||"d".equals(r)||"A".equals(r)||"B".equals(r)||"C".equals(r)||"D".equals(r))){
					System.out.println("第"+row+"行"+"第6列的值只能为ABCD");
					info.add("第"+row+"行的参考答案列输入有误");
					continue;
				}
				String title = sheet.getCell(0, row).getContents().trim();
				String singleA = sheet.getCell(1, row).getContents().trim();
				String singleB = sheet.getCell(2, row).getContents().trim();
				String singleC = sheet.getCell(3, row).getContents().trim();
				String singleD = sheet.getCell(4, row).getContents().trim();
				String singleR = sheet.getCell(5,row).getContents().trim().toUpperCase();
				
				model.BaseQs baseQs = new BaseQs();
				baseQs.setBaseSingleTitle(title);
				baseQs.setBaseSingleA(singleA);
				baseQs.setBaseSingleB(singleB);
				baseQs.setBaseSingleC(singleC);
				baseQs.setBaseSingleD(singleD);
				baseQs.setBaseSingleAS(singleR);
				baseArr.add(baseQs);
				
				/*for(int col=0;col<cols;col++){//这个包中的方法列和行似乎倒了一下
					System.out.println("第"+row+"行第"+col+"列的内容是："+sheet.getCell(col,row).getContents().trim());
				}*/
			}
			map.put("info", info);
			map.put("baseQsArr", baseArr);
			book.close();
			File oldFile = new File(path);
			if(oldFile.exists()){
				oldFile.delete();
			}
			
			return map;
		} catch (BiffException | IOException e) {
			File oldFile = new File(path);
			if(oldFile.exists()){
				oldFile.delete();
			}
			e.printStackTrace();
			return null; //文件没有找到
		}
	}
	

}
