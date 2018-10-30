package org.bluesky.encrypt.idea;

/**
 * IDEA算法调用服务类
 * @author: liuyuefeng
 * @date: 2014-9-14 下午5:26:54
 * @version: V1.0
 *
 */
public class IDEAService {
	
	private String key = "";// 密钥
	private IDEA idea = null;
	
	public IDEAService(){
		key = "9781246350HQSTAR";
		idea = new IDEA();
	}
	
	/**
	 * 调用IDEA加密算法
	 * @param byteData
	 * @return: byte[]
	 * @throws:
	 */
	public byte[] encrypt(byte[] byteData) {
		byte[] byteKey = key.getBytes();
        
		byte[] encryptData = idea.IdeaEncrypt(byteKey, byteData, true);// true时为加密
		return encryptData;
	}
	
	/**
	 * 调用IDEA解密算法
	 * @param byteData
	 * @return: byte[]
	 * @throws:
	 */
	public byte[] decrypt(byte[] byteData){
		byte[] byteKey = key.getBytes();
        
		byte[] decryptData = idea.IdeaEncrypt(byteKey, byteData, false);// false时为解密
		return decryptData;
	}
	
}
