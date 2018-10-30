package org.bluesky.encrypt.idea;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class IDEATest extends TestCase {
	private String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<dkskfxx><dkskfsh>500103202800832</dkskfsh><dkskfmc>極致純牛奶</dkskfmc><dkfsh>500903202875710DK</dkfsh><dkfmc>總參八局</dkfmc></dkskfxx>";
	IDEAService idea = null;

	@Before
	public void setUp() throws Exception {
		idea = new IDEAService();
	}

	@Test
	public void testEncryptAndDecrypt() {
		assertEquals("IDEA加解密不成功！", data.trim(), new String(idea.decrypt(idea.encrypt(data.getBytes()))).trim());
	}

}
