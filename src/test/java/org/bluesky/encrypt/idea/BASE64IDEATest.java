package org.bluesky.encrypt.idea;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import junit.framework.TestCase;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

/**
 * @author: liuyuefeng
 * @date: 2014-10-30 下午4:39:03
 * @version: V1.0
 * 
 */
public class BASE64IDEATest extends TestCase {
	//如果URL中需要传递经过BASE64加密的参数时，会把参数中的“+”变成“ ”，在解密过程中需要用inputXml.replaceAll(" ", "+")替换

	private String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<dkskfxx><dkskfsh>500103202800832</dkskfsh><dkskfmc>極致純牛奶</dkskfmc><dkfsh>500903202875710DK</dkfsh><dkfmc>總參八局</dkfmc></dkskfxx>";
	
	IDEAService idea = null;
/*	BASE64Encoder base64Encoder = null;
	BASE64Decoder base64Decoder = null;
*/
	@Before
	public void setUp() throws Exception {
		idea = new IDEAService();
/*		base64Encoder = new BASE64Encoder();
		base64Decoder = new BASE64Decoder();
*/	}

	@Test
	public void testEncryptAndDecrypt() {
		String inputXml = "";
		try {
			//inputXml = base64Encoder.encode(idea.encrypt(data.getBytes("GBK")));
			inputXml = Base64.encodeBase64String(idea.encrypt(data.getBytes("GBK")));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String outputXml = "";
		try {
			//outputXml = new String(idea.decrypt(base64Decoder.decodeBuffer(inputXml)), "GBK");
			outputXml = new String(idea.decrypt(Base64.decodeBase64(inputXml)), "GBK");
			if (outputXml.indexOf('\u0000') > 0) {
				outputXml = outputXml.substring(0, outputXml.indexOf('\u0000'));// 用来截取0情况，否则后面会多出？
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("加密数据:\n" + inputXml);
		System.out.println("解密数据:\n" + outputXml);
		assertEquals("IDEA加解密不成功！", data.trim(), outputXml.trim());
	}

}
