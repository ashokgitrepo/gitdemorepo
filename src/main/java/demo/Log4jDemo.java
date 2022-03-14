package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	static Logger logger=LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		System.out.println("hello world\n");
		logger.info("this is an information");
		logger.warn("this is a warn message");
		logger.fatal("this is a fatal information");
		logger.error("this is an error");
		System.out.println("\ncompleted");
		
		// TODO Auto-generated method stub

	}

}
