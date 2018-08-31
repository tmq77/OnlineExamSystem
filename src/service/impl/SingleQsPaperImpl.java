package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.UuidGenerator;
import mapper.InsertSingleQsTempDao;
import model.PaperBaseQs;
import service.SingleQsPaper;

/**
 * 插入临时打印表---单选题
 * @author taominqi
 *
 */
@Transactional
@Service("singleQsPaperImpl")
public class SingleQsPaperImpl implements SingleQsPaper{  //弃用
	
	@Autowired
	private InsertSingleQsTempDao insertSingleQsTempDao;

	@Override
	public int insertSingleQs(String[] temp, ArrayList<Integer> singleID, String username) throws DataAccessException {
	
		for(int i=0;i<singleID.size();i++){
			PaperBaseQs paperBaseQs = insertSingleQsTempDao.getBaseSingle(singleID.get(i));
			paperBaseQs.setAccount(username);
			paperBaseQs.setSingleUs(temp[i]);
			paperBaseQs.setUuid(UuidGenerator.getUuid());
			int flag = insertSingleQsTempDao.insertSingleTemp(paperBaseQs);
			if(flag==0){
				return -1;
			}
		}
		
		return 1;
	}

}
