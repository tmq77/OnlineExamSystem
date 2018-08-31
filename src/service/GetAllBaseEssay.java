package service;

import java.util.ArrayList;

import model.BaseEssay;

public interface GetAllBaseEssay {
	
	ArrayList<BaseEssay> getAllBaseEssay(int index);
	
	int getTotalCounts();

}
