package com.ʵ��demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.bcel.generic.NEW;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.FileAppender;
import org.testng.IReporter;

public class Logg4jӦ�� {
	private final Class<?> clazz;
	private Logger logger;

	String relativelyPath = System.getProperty("user.dir"); // ��ȡ��Ŀ���ڵ�·��
	/**
	 * 
	 * @param clazz
	 * ��ȡ��ǰ��
	 */
	public Logg4jӦ��(Class<?> clazz) {
		this.clazz = clazz;
		// Logger.getLogger�ķ����ǵ��õ���LogManager.getLogger()�����������������������Ƿ���logger
		this.logger = Logger.getLogger(this.clazz);
		Logg4jӦ��.initlog4j();
	}

	// ��ʼ��log4j������log4j�������ļ�log4j.Properties
	private static void initlog4j() {
		
		// ����Propderties����
		Properties prop = new Properties();
		/*
		 * Log4j����ֻʹ���ĸ��������ȼ��Ӹߵ��ͷֱ���ERROR��WARN��INFO��DEBUG
		 * ���ﶨ������ʾ������ͼ���,�����嵽INFO����,�򿴲���DEBUG�������Ϣ��~!��������������
		 */            
		prop.setProperty("log4j.rootLogger", "INFO,CONSOLE,E,F");
		prop.setProperty("log4j.appender.CONSOLE","org.apache.log4j.ConsoleAppender");
		prop.setProperty("log4j.appender.CONSOLE.layout","org.apache.log4j.PatternLayout");
		prop.setProperty("log4j.appender.CONSOLE.layout.ConversionPattern","[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");

		// �������ڸ�ʽ
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date()).toString();
		
		String src = "test-output/" + date;
		
		File dir = new File(src);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		String filepath = dir.getAbsolutePath() + "/" + "log_" + date + ".log";

		prop.setProperty("log4j.appender.E", "org.apache.log4j.FileAppender");
		prop.setProperty("log4j.appender.E.file", filepath);
		prop.setProperty("log4j.appender.E.layout","org.apache.log4j.PatternLayout");
		prop.setProperty("log4j.appender.E.layout.ConversionPattern","[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");
		prop.setProperty("log4j.appender.F", "org.apache.log4j.FileAppender");
		String filepathHtml = dir.getAbsolutePath() + "/" + "log_" + date + ".html";
		prop.setProperty("log4j.appender.F.file", filepathHtml);
		prop.setProperty("log4j.appender.F.layout",
				"org.apache.log4j.HTMLLayout");
		// prop.setProperty("log4j.appender.F.layout.ConversionPattern",
		// "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");

		PropertyConfigurator.configure(prop);
	}

	public void info(String message) {
		logger.info(message);
	}

	public void warn(String message) {
		logger.warn(message);
	}

	public void error(String message) {
		logger.error(message);
	}

	public void debug(String message) {
		logger.debug(message);
	}

}
