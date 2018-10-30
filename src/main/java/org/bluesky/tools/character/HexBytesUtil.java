package org.bluesky.tools.character;

/**
 * 字符压缩类
 * @author: liuyuefeng
 * @date: 2014-9-14 下午5:33:32
 * @version: V1.0
 *
 */
public class HexBytesUtil {
	
	/**
	 * 16进制数字组成的字符串按每两个字节压缩成一个字节（字符数为单数时舍去最后一个字符）
	 * @param hexStr
	 * @return String
	 */
	public static String compressHexToStr(String hexStr) {
		char[] c = hexStr.toCharArray();
		byte[] b = new byte[c.length];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			b[i] = (byte) Integer.parseInt(String.valueOf(c[i]), 16);
			if (i % 2 == 1)
				sb.append((char) ((b[i - 1] << 4) + b[i]));
		}
		return sb.toString();
	}

	/**
	 * 字符串解压成16进制数字组成的字符串每一个字节解压成两个字节
	 * @param str
	 * @return String
	 */
	public static String depressStrToHex(String str) {
		char[] c = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			sb.append(Integer.toHexString(c[i] >> 4 & 0x0f));
			sb.append(Integer.toHexString(c[i] & 0x0f));
		}
		return sb.toString();
	}
	
}
