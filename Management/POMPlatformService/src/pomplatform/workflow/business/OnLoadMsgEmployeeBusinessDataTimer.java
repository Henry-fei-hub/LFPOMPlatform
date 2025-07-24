package pomplatform.workflow.business;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSystemProcessInstanceActivity;
import com.pomplatform.db.bean.BaseSystemProcessPooledTask;
import com.pomplatform.db.dao.SystemProcessInstanceActivity;
import com.pomplatform.db.dao.SystemProcessPooledTask;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.workflow.bean.BaseOnLoadMsgEmployeeBusinessData;
import pomplatform.workflow.bean.ConditionOnLoadMsgEmployeeBusinessData;
import pomplatform.workflow.query.QueryOnLoadMsgEmployeeBusinessData;

/**
 *
 * @author 
 */
public class OnLoadMsgEmployeeBusinessDataTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnLoadMsgEmployeeBusinessDataTimer.class);
    
	private final static List<Integer> CWD_TYPE_IDS = new ArrayList<Integer>() ;
	static {
		CWD_TYPE_IDS.add(47);
		CWD_TYPE_IDS.add(48);
		CWD_TYPE_IDS.add(49);
		CWD_TYPE_IDS.add(50);
		CWD_TYPE_IDS.add(55);
	}

    @SuppressWarnings("deprecation")
	public   void run() {
    	__logger.debug("开始计算时间");
        try {
//        	ThreadConnection.beginTransaction();
        	Date currentDate = new Date();
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
        	SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        	//工作时间  9-20
        	String start = "09:00:00";
        	String end = "21:00:00";
        	String format = simpleDateFormat2.format(currentDate);
        	Date parse = simpleDateFormat2.parse(format); 
        	Date startDate = simpleDateFormat2.parse(start);
        	Date endDate = simpleDateFormat2.parse(end);
        	//非工作日期 6||7
        	int day = currentDate.getDay();
        	
        	if(day!=6&&day!=7&&parse.getTime()>=startDate.getTime()&&parse.getTime()<=endDate.getTime()) {
        		Calendar c = Calendar.getInstance();
            	SystemProcessInstanceActivity spiaDao =new SystemProcessInstanceActivity();
            	SystemProcessPooledTask spptDao =new  SystemProcessPooledTask();
            	BaseSystemProcessInstanceActivity spiaBase =null;
            	BaseSystemProcessPooledTask spptBase =null;
            	
            	QueryOnLoadMsgEmployeeBusinessData dao = new QueryOnLoadMsgEmployeeBusinessData();
            	ConditionOnLoadMsgEmployeeBusinessData conditon =new ConditionOnLoadMsgEmployeeBusinessData();
            	BaseCollection<BaseOnLoadMsgEmployeeBusinessData> result = dao.executeQuery( conditon.getKeyValues(), conditon) ;
            	List<BaseOnLoadMsgEmployeeBusinessData> list = result.getCollections();
            	if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
            		for (BaseOnLoadMsgEmployeeBusinessData base : list) {
            			int messageStauts=0;
                		int processInstanceActivityId=0;
                		int processPooledTaskId =0;
                    	String WeiXin=null;
                    	String processTypeName = null;
            			WeiXin=base.getCompanyWeixin();
            			if(!BaseHelpUtils.isNullOrEmpty(WeiXin)) {
            				Integer typeFlag = base.getTypeFlag();
            				if(typeFlag==1) { //单人
            					messageStauts=BaseHelpUtils.getIntValue(base.getMessage1());
            				}else if(typeFlag==2){//任务池
            					messageStauts=BaseHelpUtils.getIntValue(base.getMessage2());
            				}
            				
            				//已发送过得消息不再发送
            				if(messageStauts==2) {
            					continue;
            				}
            				
            				 processTypeName = base.getProcessTypeName();
            				//时限 （小时）
            				int timeOutAction =BaseHelpUtils.getIntValue(base.getTimeOutAction());
            				//流程实例节点创建时间
            				Date createTime = base.getInstanceActivityStartTime();
            				//获取超时的时间点
            				c.clear();
            				c.setTime(createTime);
            				c.add(Calendar.HOUR,timeOutAction);
            				Date timeDeadLine = c.getTime();
            				long time = timeDeadLine.getTime();
            				//1.提前15分钟
            				c.add(Calendar.MINUTE,-15);
            				Date timeDeadLine15m = c.getTime();
            				long time2 = timeDeadLine15m.getTime();
            				//2.超过后的一天
            				c.add(Calendar.HOUR,24);
            				Date timeDeadLine24h = c.getTime();
            				long time3 = timeDeadLine24h.getTime();
            				//3.当前时间
            				long time4 = currentDate.getTime();
            				
            				String dateStr = simpleDateFormat.format(timeDeadLine);
            				
            				//与当前时间节点比较 (是否同一天  ； 是否大于-15m并且小于deadline； 流程类型名不能为空)
            				if(messageStauts==0&&time4>=time2&&time4<=time&&!BaseHelpUtils.isNullOrEmpty(processTypeName)){
            					
        						//更新消息发送状态      消息状态 0 : 未发送    1 : 提前15分钟已发送   2 : 延迟24小时已发送
        						messageStauts=1;
                				if(typeFlag==1) { //单人
                					spiaBase=new BaseSystemProcessInstanceActivity();
                					processInstanceActivityId = BaseHelpUtils.getIntValue(base.getProcessInstanceActivityId());
                					if(processInstanceActivityId>0) {
                						
                						spiaDao.clear();
                						spiaBase.setProcessInstanceActivityId(processInstanceActivityId);
                						spiaBase.setTimeOutMessageStatus(messageStauts);
                						spiaDao.setDataFromBase(spiaBase);
                						spiaDao.update();
                						
                						StringBuilder sb = new StringBuilder();
                    					String params = "type_" + typeFlag + "__" + "id_" + processInstanceActivityId+ "__msgType_2";
                    					sb.append("https://erp.jaid.cn/minindex.html?")
                    						.append("state=")
                    						.append(params);
                						String str = String.format(WeixinStatics.MSG_EMPLOYEE_BUSINESS_DATA_15M, processTypeName,dateStr,sb.toString());
                						ERPWeixinUtils.sendTextMsgToUser(WeiXin, str);
                						
                					}
                				}else if(typeFlag==2){//任务池
                					spptBase=new BaseSystemProcessPooledTask();
                					 processPooledTaskId =BaseHelpUtils.getIntValue(base.getProcessPooledTaskId());
                					 if(processPooledTaskId>0) {
                						 spptDao.clear();
                						 spptBase.setProcessPooledTaskId(processPooledTaskId);
                						 spptBase.setTimeOutMessageStatus(messageStauts);
                						 spptDao.setDataFromBase(spptBase);
                						 spptDao.update();
                						 
                						StringBuilder sb = new StringBuilder();
                     					String params = "type_" + typeFlag + "__" + "id_" + processPooledTaskId+ "__msgType_2";
                     					sb.append("https://erp.jaid.cn/minindex.html?")
                     						.append("state=")
                     						.append(params);
                						 String str = String.format(WeixinStatics.MSG_EMPLOYEE_BUSINESS_DATA_15M, processTypeName,dateStr,sb.toString());
                						 ERPWeixinUtils.sendTextMsgToUser(WeiXin, str);
                					 }
                				}
        					//与当前时间节点比较 (是否同一天  ； 是否大于24h； 流程类型名不能为空)	
            				}else if(messageStauts<=1&&time4>=time3&&!BaseHelpUtils.isNullOrEmpty(processTypeName)){
            					//更新消息发送状态      消息状态 0 : 未发送    1 : 提前15分钟已发送   2 : 延迟24小时已发送
        						messageStauts=2;
                				if(typeFlag==1) { //单人
                					spiaBase=new BaseSystemProcessInstanceActivity();
                					processInstanceActivityId = BaseHelpUtils.getIntValue(base.getProcessInstanceActivityId());
                					if(processInstanceActivityId>0) {
                						spiaDao.clear();
                						spiaBase.setProcessInstanceActivityId(processInstanceActivityId);
                						spiaBase.setTimeOutMessageStatus(messageStauts);
                						spiaDao.setDataFromBase(spiaBase);
                						spiaDao.update();
                						
                						StringBuilder sb = new StringBuilder();
                    					String params = "type_" + typeFlag + "__" + "id_" + processInstanceActivityId+ "__msgType_2";
                    					sb.append("https://erp.jaid.cn/minindex.html?")
                    						.append("state=")
                    						.append(params);
                						String str = String.format(WeixinStatics.MSG_EMPLOYEE_BUSINESS_DATA_24H, processTypeName,dateStr,sb.toString());
                						ERPWeixinUtils.sendTextMsgToUser(WeiXin, str);
                					}
                				}else if(typeFlag==2){//任务池
                					spptBase=new BaseSystemProcessPooledTask();
                					 processPooledTaskId =BaseHelpUtils.getIntValue(base.getProcessPooledTaskId());
                					 if(processPooledTaskId>0) {
                						 spptDao.clear();
                						 spptBase.setProcessPooledTaskId(processPooledTaskId);
                						 spptBase.setTimeOutMessageStatus(messageStauts);
                						 spptDao.setDataFromBase(spptBase);
                						 spptDao.update();
                						 
                						 StringBuilder sb = new StringBuilder();
                     					 String params = "type_" + typeFlag + "__" + "id_" + processPooledTaskId+ "__msgType_2";
                     					 sb.append("https://erp.jaid.cn/minindex.html?")
                     						.append("state=")
                     						.append(params);
                						 String str = String.format(WeixinStatics.MSG_EMPLOYEE_BUSINESS_DATA_24H, processTypeName,dateStr,sb.toString());
                						 ERPWeixinUtils.sendTextMsgToUser(WeiXin, str);
                					 }
                				}
            				}
            			}
    				}
            	}
        	}else {
        		 __logger.debug("非工作时间不予推送消息");
        	}
        	 __logger.debug("结束时间");
//			ThreadConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
    }
    
    public static void main(String[] args) throws Exception {
//		run();
//    	WeixinUtils.sendWXMsgToUser(8, "111");
//    	System.out.println(WeixinUtils.sendTextMsgToUser(WeixinUtils.TEST_USERID, "ces"));
	}
    
}
