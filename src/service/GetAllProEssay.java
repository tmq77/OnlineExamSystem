package service;

import java.util.ArrayList;

import model.ProEssay;

public interface GetAllProEssay {
	
	ArrayList<ProEssay> getAllPro(String post,int index);
	
	int getCounts(String post);

}
