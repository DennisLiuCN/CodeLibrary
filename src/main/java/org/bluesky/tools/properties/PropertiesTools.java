package org.bluesky.tools.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 资源文件读取类
 * @author: liuyuefeng
 * @date: 2014-9-20 下午4:34:10
 * @version: V1.0
 *
 */
public class PropertiesTools {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesTools.class);
	private static Properties props = null;
	private static String fileName = "db.properties";
	
	static {
		props = new Properties();
		try {
			//1.使用class变量的getResourceAsStream()方法
			InputStream is = PropertiesTools.class.getResourceAsStream("db.properties");
			
			//2.使用class.getClassLoader()所得到的java.lang.ClassLoader的getResourceAsStream()方法
			//InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream("db.properties");
			
			//3.使用java.lang.ClassLoader类的getSystemResourceAsStream()静态方法
			//InputStream in = ClassLoader.getSystemResourceAsStream("db.properties");
			
			//4.使用spring的ClassPathResource类的getFile()方法
			//InputStream is = new FileInputStream(new ClassPathResource("xxx.properties").getFile());
			
			//5.web环境下可以使用ServletContext的getResourceAsStream()方法
			//InputStream is = context.getResourceAsStream(path);

			props.load(is);
			
			//6.使用java.util.ResourceBundle类的getBundle()方法
			//ResourceBundle rb = ResourceBundle.getBundle(fileName, Locale.getDefault());
			//rb.getObject("keyName");
			
			//7.使用java.util.PropertyResourceBundle类的构造函数
			//InputStream is = new BufferedInputStream(new FileInputStream(fileName));
			//ResourceBundle rb = new PropertyResourceBundle(is);
		} catch (IOException e) {
			LOGGER.error("读取配置文件" + fileName + "时程序发生错误:" + e.getMessage());
		}
	} 

	public static Object getValue(String key) {
		return props.get(key);
	}

}
