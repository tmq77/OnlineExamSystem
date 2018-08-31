package service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import service.HandleBaseAnswer;

@Component("handleBaseAnswerImpl")
public class HandleBaseAnswerImpl implements HandleBaseAnswer{
	
	
	public int handleBase(ArrayList<String> referenceAnswer, String[] temp) {
		int score=0;
		for(int i=0;i<temp.length;i++){
			if(temp[i].equals(referenceAnswer.get(i))){
				score+=5;  //5分一道选择，一共20题。
			}
		}
		return score;
	}

}
