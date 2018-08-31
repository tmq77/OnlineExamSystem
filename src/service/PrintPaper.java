package service;


public interface PrintPaper {
	
	/**
	 * 点击通过按钮后
	 * 从旧表中获取所有的题目以及答案并且将数据转移到对应的打印表中
	 * @param username
	 * @return
	 */
	public int printQs(String username);
	

}
