package org.bluesky.tools.qrcode;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 二维码生成工具类
 * 
 * @author: liuyuefeng
 * @date: 2016年2月4日 下午4:12:07
 * @version: V1.0
 * 
 */
public class QrCodeUtils {
	
	public static void main(String[] args) throws Exception {
		String text = "http://www.baidu.com";
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "gif";
		Map<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码
		File outputFile = new File("d:" + File.separator + "new.gif");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

	}
}
