package Log4jDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemoClass {

	static Logger logger = LogManager.getLogger(Log4jDemoClass.class); //Created logger variable for this perticular class and it will be used to log the commands.
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello Akshata!  \n");

		logger.info("This is info message");
		logger.error("This is an error message");
		logger.warn("This is a warn message");
		logger.fatal("This is a fatal message");
		logger.trace("This is a trace message");
		
		System.out.println("\n Completed");
	}

}
