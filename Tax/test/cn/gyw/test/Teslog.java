package cn.gyw.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class Teslog {
	
	@Test
	public void test(){
		
		Log log = LogFactory.getLog(getClass());
		
		try {
			int i=1/0;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		log.debug("debug 调试级别");
		log.info("info 级别日志");
		log.warn("warn 级别日志");
		log.error("error 级别日志");
		log.fatal("fatal 级别日志");
	}
}
