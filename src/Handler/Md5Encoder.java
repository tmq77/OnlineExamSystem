package Handler;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 与前端js保持一致的加密编码
 * @author taominqi
 *
 */
public class Md5Encoder {

	
	/**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException  
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
    	byte[] salt = str.getBytes("UTF-8");
    	
    	//确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        //将数组放入计算
        md5.update(salt);
        //执行计算
        byte[] temp=md5.digest();
        
        StringBuffer sb = new StringBuffer();
        //转化16进制 ？与前端js一致？
        for(int i=0;i<temp.length;i++){
        	int val = ((int)temp[i])&0xff;
        	if(val<16){
        		sb.append("0");
        	}
        	sb.append(Integer.toHexString(val));
        }
        return sb.toString();
  
      
    }
    /*//密码前端先加密一次,然后后端再加盐  (username+加密过的密码)再加密 
   public static void main(String args[]) throws NoSuchAlgorithmException, UnsupportedEncodingException{
    	String str ="root"+"63a9f0ea7bb98050796b649e85481845";
    	System.out.println(EncoderByMd5(str));
    }*/
}
