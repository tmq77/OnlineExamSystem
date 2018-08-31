package service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;

import Handler.DateUtil;
import service.SingleUpload;
@Service("singleUploadImpl")
public class SingleUploadImpl implements SingleUpload{

	
	public String upload(File file, String savePath, String fileName) {
		
		File newFile = new File(savePath);
		if(!newFile.exists()){
			newFile.mkdirs();
		}
		
		FileOutputStream fos = null;
		FileInputStream fis =null;
		String time = DateUtil.getDateToMs();
		//读取上传的文件流
		try {
			 fos = new FileOutputStream(savePath+"\\"+time+fileName);  //创建文件夹下的文件
			 fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer))>0){
				fos.write(buffer,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件没有找到");	
			return "error";
		}finally{
			try {
				if(fos!=null){
				fos.close();
				}
				if(fis!=null){
				fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		
		return time;
	}

	
}
