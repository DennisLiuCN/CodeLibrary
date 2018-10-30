package org.bluesky.tools.character;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HexBytesUtilTest extends TestCase {
	private String str;
	private static Logger logger = LoggerFactory.getLogger(HexBytesUtilTest.class);

	@Before
	public void setUp() throws Exception {
		str = "303Bbe9a1f0040dd89d79d66085b711";
	}

	@Test
	public void testCompressAndDepress() {
		String strZip = HexBytesUtil.compressHexToStr(str);
		String strUnzip = HexBytesUtil.depressStrToHex(strZip);
		System.out.println("str     :" + str);
		System.out.println("strZip  :" + strZip);
		System.out.println("strUnzip:" + strUnzip);
		logger.info("str     :" + str);
		logger.info("strZip  :" + strZip);
		logger.info("strUnzip:" + strUnzip);
	}

}
