package com.lick.quartz;

import java.io.File;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestQuartz  extends QuartzJobBean {
	/**
	 * 执行定时任务
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("执行定时任务》》》"+new Date());
		String filePath="D:\\数据库文件\\";
		String dbName="springbootdb";//备份的数据库名
		String username="root";//用户名
		String password="mysql";//密码
		File uploadDir = new File(filePath);
		if (!uploadDir.exists())
			uploadDir.mkdirs();
		
        String cmd =  "mysqldump  -u"+ username +"  -p"+password +" "+ dbName + " -r "
                + filePath + "/" + dbName+new java.util.Date().getTime()+ ".sql";
        try {
        Process process = Runtime.getRuntime().exec(cmd); 
            System.out.println("备份数据库成功!!!");         
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
     
        }

	}

}
