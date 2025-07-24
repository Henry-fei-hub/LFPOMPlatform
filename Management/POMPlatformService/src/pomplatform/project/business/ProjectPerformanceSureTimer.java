package pomplatform.project.business;

import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.PlateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import message.common.ERPWeixinUtils;
import pomplatform.project.bean.BaseOnRevenueSureWarn;
import pomplatform.project.bean.ConditionOnRevenueSureWarn;
import pomplatform.project.query.QueryOnRevenueSureWarn;

/**
 *
 * @author 
 */
public class ProjectPerformanceSureTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(ProjectPerformanceSureTimer.class);
    
    @Override
    public void run() {
    	try {
    		Calendar ca = Calendar.getInstance();
    		int day = ca.get(Calendar.DAY_OF_WEEK);
    		if(day == 6){//表示是周五
    			QueryOnRevenueSureWarn dao = new QueryOnRevenueSureWarn();
    			ConditionOnRevenueSureWarn con = new ConditionOnRevenueSureWarn();
    			BaseCollection<BaseOnRevenueSureWarn> result = dao.executeQuery(null, con);
    			if(!BaseHelpUtils.isNullOrEmpty(result)){
    				List<BaseOnRevenueSureWarn> list = result.getCollections();
    				if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    					for(BaseOnRevenueSureWarn e : list){
    						int warnFlag = BaseHelpUtils.getIntValue(e.getWarnFlag());
    						if(warnFlag == 2){//说明截止目前还没进行项目积分的确认，则发送通知
    							//获取项目经理id
    							int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    							if(employeeId <= 0){
    								continue;
    							}
    							String employeeName = BaseHelpUtils.getString(e.getEmployeeName());
    							String content = "您本周还未进行项目积分确认，请尽快登录ERP系统进行确认，否则会进行项目绩效扣除";
    							//向项目经理推送微信信息
    							ERPWeixinUtils.sendWXMsgToUser(employeeId, content);
    							//获取当前项目经理归属的业务部门
    							int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
    							if(plateId > 0){
    								PlateRecord prDao = new PlateRecord();
    								prDao.setConditionPlateId("=",plateId);
    								BasePlateRecord prBean = prDao.executeQueryOneRow();
    								if(!BaseHelpUtils.isNullOrEmpty(prBean)){
    									//获取当前业务部门的部门负责人
    									int plateManagerId = BaseHelpUtils.getIntValue(prBean.getPlateManagerId());
    									if(plateManagerId > 0 && plateManagerId != employeeId){
    										content = String.format("本部门项目经理（%1$s）本周还未进行项目积分确认，如在本周结束前仍未进行确认，将对部门进行项目绩效扣除", employeeName);
    										//向本部门领导推送微信信息
    										ERPWeixinUtils.sendWXMsgToUser(plateManagerId, content);
    									}
    									//获取上级业务部门
    									int parentPlateId = BaseHelpUtils.getIntValue(prBean.getParentId());
    									if(parentPlateId > 0){
    										prDao.clear();
    										prDao.setConditionPlateId("=",parentPlateId);
    	    								prBean = prDao.executeQueryOneRow();
    	    								if(!BaseHelpUtils.isNullOrEmpty(prBean)){
    	    									//获取上级业务部门的部门负责人
    	    									int parentManagerId = BaseHelpUtils.getIntValue(prBean.getPlateManagerId());
    	    									if(parentManagerId > 0 && parentManagerId != employeeId && plateManagerId != parentManagerId){
    	    										String plateName = BaseHelpUtils.getString(prBean.getPlateName());
    	    										content = String.format("（%1$s）项目经理（%2$s）本周还未进行项目积分确认，如在本周结束前仍未进行确认，将对部门进行项目绩效扣除",plateName,employeeName);
    	    										//向本部门领导推送微信信息
    	    										ERPWeixinUtils.sendWXMsgToUser(parentManagerId,content);
    	    									}
    	    								}
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    		}
		} catch (Exception e) {
			e.printStackTrace();
			__logger.error("项目绩效确认警告异常", e);
		}
       
    }
    public static void main(String[] args) {
    	ProjectPerformanceSureTimer time = new ProjectPerformanceSureTimer();
    	time.run();
	}
}
