package service.impl;

import java.util.ArrayList;
import java.util.Map;

import mapper.ParseXlsDao;
import model.BaseQs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.JxlUtil;
import service.ParseXls;
@Transactional
@Service("parseXlsImpl")
public class ParseXlsImpl implements ParseXls{

	@Autowired
	private ParseXlsDao parseXlsDao;
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> parse(String name,String savePath) {
		
		Map<String,Object> map = JxlUtil.readExcel(savePath);
		if(map==null){
			return null; //文件没有找到或者格式不对
		}
		
		ArrayList<model.BaseQs> baseQsArr = (ArrayList<BaseQs>) map.get("baseQsArr");
		ArrayList<String> info = (ArrayList<String>) map.get("info");
		
		for(int i=0;i<baseQsArr.size();i++){
			String title = baseQsArr.get(i).getBaseSingleTitle();
			if(parseXlsDao.counts(title)!=0){
				info.add("---重复---"+title);
				continue;
			}
		 parseXlsDao.insertExam(baseQsArr.get(i));
			
		}
		
		return info;
	}
	

}
