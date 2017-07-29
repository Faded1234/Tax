package cn.gyw.nsfw.complain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTask {
	
	public void doSimpleTriggerTask(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(new Date());
		System.out.println("当前的时间为"+sdf);
	}
	public void doCronTriggerTask() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("doing cronTrigger task..." + sdf.format(new Date()));
	}
}
