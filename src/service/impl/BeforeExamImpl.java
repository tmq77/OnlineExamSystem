package service.impl;

import mapper.BeforeExamDao;
import model.InfoConfirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.BeforeExam;

@Transactional
@Service("beforeExamImpl")
public class BeforeExamImpl implements BeforeExam{
	
	@Autowired
	private BeforeExamDao beforeExamDao;

	@Override
	public InfoConfirm confirm(String username) {
		InfoConfirm be = beforeExamDao.userConfirm(username);
		return be;
	}

}
