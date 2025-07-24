package pomplatform.preProjects.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.PreProjectWarnRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import message.common.ERPWeixinUtils;
import pomplatform.preProjects.bean.BaseprojectPreInfomations;
import pomplatform.preProjects.bean.ConditionprojectPreInfomations;
import pomplatform.preProjects.query.QueryprojectPreInfomations;

/**
 *
 * @author 
 */
public class ProjectWarnTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(ProjectWarnTimer.class);
    
    
    @Override
    public void run() {
    	try {
    		Date currentDate = new Date();
    		Calendar ca = Calendar.getInstance();
    		ca.setTime(currentDate);
    		//获取小时
    		int hour = ca.get(Calendar.HOUR_OF_DAY);
    		if(9 > hour || hour > 18) {
    			return;
    		}
    		//查询所有项目报警信息
    		QueryprojectPreInfomations dao = new QueryprojectPreInfomations();
    		ConditionprojectPreInfomations con = new ConditionprojectPreInfomations();
    //		KeyValuePair[] keyValues = new KeyValuePair[]{new KeyValuePair()};
//			keyValues[0].setKey("CAST(aa.win_rate AS INTEGER) > ?");
//			keyValues[0].setValue("1 = 1 and 1 > ?");
    		BaseCollection<BaseprojectPreInfomations> result = dao.executeQuery(null, con);
    		if(!BaseHelpUtils.isNullOrEmpty(result)){
    			List<BaseprojectPreInfomations> list = result.getCollections();
    			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    				PreProjectWarnRecord warnDao = new PreProjectWarnRecord();
    				for(BaseprojectPreInfomations bean : list){
    					//获取标示字段(1:红色警告；2：黄色警告；3：正常；4：黑色警告；5：灰色)，如果是已立项、已签订合同、已关闭、暂停则不推送警告
    					int flag = BaseHelpUtils.getIntValue(bean.getFlag());
    					if(flag == 5 || flag == 1){
    						continue;
    					}
    					//获取天数
    					int days = BaseHelpUtils.getIntValue(bean.getDays());
    					if(days == 6 || days == 11 || days == 16){
    						//获取前期项目Id
    						int preProjectId = BaseHelpUtils.getIntValue(bean.getPreProjectId());
    						//检测这一天该项目是否已经警告过
    						warnDao.clear();
    						warnDao.setConditionPreProjectId("=",preProjectId);
    						warnDao.setConditionRecordDate("=",currentDate);
    						if(!warnDao.isExist()){//说明这一天是没有警告过的
    							String projectName = BaseHelpUtils.getString(bean.getProjectName());
    							int employeeId = BaseHelpUtils.getIntValue(bean.getApplyEmployeeId());
    							warnDao.setPreProjectId(preProjectId);
    							warnDao.setInfoCode(bean.getInfoCode());
    							warnDao.setProjectCode(bean.getProjectCode());
    							warnDao.setProjectName(projectName);
    							warnDao.setEmployeeId(employeeId);
    							warnDao.setWarnDays(days);
    							warnDao.setRecordDate(currentDate);
    							warnDao.setRecordTime(currentDate);
    							String warnContent = "";
    							if(days == 6 || days == 11){
    								warnContent = String.format("您有一个项目（%1$s）超过%2$s天未跟进。请及时登录系统更新项目进度！",projectName, days);
    							}else if(days == 16){
    								warnContent = String.format("您有一个项目（%1$s）超过%2$s天未跟进。已被系统视为无效项目，请知悉！",projectName, days);
    							}
    							warnDao.setWarnContent(warnContent);
    							warnDao.save();
    							//推送微信信息
    							ERPWeixinUtils.sendWXMsgToUser(employeeId,warnContent);
    						}
    					}
    				}
    			}
    		}
		} catch (Exception e) {
			e.printStackTrace();
			__logger.error("监控项目警告异常", e);
		}
       
    }
    public static void main(String[] args) {
    	ProjectWarnTimer time = new ProjectWarnTimer();
    	time.run();
	}
}
