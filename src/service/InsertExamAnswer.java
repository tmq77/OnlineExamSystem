package service;

import java.util.ArrayList;

/**
 * 用于整合录入考生答案的服务层接口
 * 整合在一个服务层中而不是多个服务层整合在控制层中是为了解决潜在异常
 * 当前台考试页面点击提交后，录入试题答案中的某个环节出错后,后台无法成功在阅卷页面点击通过按钮让该人员通过考试,
 * 当极端情况下，即使通过了考试,也无法打印出试卷,更无法删除人员，此时该诗句就会变成脏数据
 * @author taominqi
 *
 */
public interface InsertExamAnswer {
	
	int insertExamSafely(int score,String username,String proId1,String proId2,String proId3,String proAns1,String proAns2,String proAns3,String baseId1,String baseId2,String baseId3,String baseAns1,String baseAns2,String baseAns3,String rid,String reanswer,String voiceanswer,String[] temp,ArrayList<Integer> singleID );

}
