package service;

import java.util.ArrayList;

import model.ModifyRequiredQs;

public interface GetAllRequiredQs {

	int getCounts(String post);
	ArrayList<ModifyRequiredQs> getRequiredQs(String post,int index);
}
