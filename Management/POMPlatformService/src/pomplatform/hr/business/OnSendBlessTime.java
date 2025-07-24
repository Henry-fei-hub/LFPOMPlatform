package pomplatform.hr.business;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCustomerResource;
import com.pomplatform.db.bean.BaseHolidayBlessManage;
import com.pomplatform.db.dao.CustomerResource;
import com.pomplatform.db.dao.HolidayBlessManage;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import message.common.OnTelMobile;

/**
 *
 * @author 
 */
public class OnSendBlessTime extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnSendBlessTime.class);

    @SuppressWarnings("deprecation")
	@Override
    public void run() {
        __logger.debug("开始推送节日祝福语");
        try {
        	ThreadConnection.beginTransaction();
        	Date currentDate = new Date();
        	HolidayBlessManage holidayDao = new HolidayBlessManage();
        	BaseHolidayBlessManage holidayBean = null;
        	List<BaseCustomerResource> crList = null;
        	//检索这一天是否有员工生日，如果有则发送手机短息祝福语
        	Employee dao = new Employee();
        	dao.setConditionStatus("=",0);//只检索在职的
        	dao.setConditionBirth("=",currentDate);
        	List<BaseEmployee> list = dao.conditionalLoad();
        	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
        		//检索内部员工祝福语
        		holidayDao.setConditionHolidayType("=",1);//生日祝福语
        		holidayDao.setConditionSendObject("=",1);//内部员工
        		holidayBean = holidayDao.executeQueryOneRow();
        		if(!BaseHelpUtils.isNullOrEmpty(holidayBean)){
        			//获取祝福语
        			String blessWords = holidayBean.getBlessWords();
        			if(!BaseHelpUtils.isNullOrEmpty(blessWords)){
        				for(BaseEmployee e : list){
        					OnTelMobile.onTelMobileSendMeg(e.getEmployeeId(),blessWords);
        				}
        			}
        		}
        	}
        	//检索这一天是否有公司客户生日，如果有则发送手机短息祝福语
        	CustomerResource crDao = new CustomerResource();
        	crDao.setConditionBirthDate("=",currentDate);
        	crList = crDao.conditionalLoad();
        	if(!BaseHelpUtils.isNullOrEmpty(crList) && crList.size() > 0){
        		//检索公司客户祝福语
        		holidayDao.clear();
        		holidayDao.setConditionHolidayType("=",1);//生日祝福语
        		holidayDao.setConditionSendObject("=",2);//公司客户
        		holidayBean = holidayDao.executeQueryOneRow();
        		if(!BaseHelpUtils.isNullOrEmpty(holidayBean)){
        			//获取祝福语
        			String blessWords = holidayBean.getBlessWords();
        			if(!BaseHelpUtils.isNullOrEmpty(blessWords)){
        				for(BaseCustomerResource e : crList){
        					//获取客户电话号码
        					String telephone = e.getTelephone();
        					if (!BaseHelpUtils.isNullOrEmpty(telephone)) {
        						OnTelMobile.onTelMobileSendMeg(telephone, blessWords);
        					}
        				}
        			}
        		}
        	}
        	//检索内部员工节日祝福语
        	holidayDao.clear();
    		holidayDao.setConditionHolidayType("=",2);//节日祝福语
    		holidayDao.setConditionHolidayDate("=",currentDate);
    		holidayDao.setConditionSendObject("=",1);//内部员工
    		holidayBean = holidayDao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(holidayBean)){
    			//获取祝福语
    			String blessWords = holidayBean.getBlessWords();
    			if(!BaseHelpUtils.isNullOrEmpty(blessWords)){
    				//获取对象类型:0:通用;1:男;2:女
    				int objectType = holidayBean.getObjectType();
    				//加载公司在职的职员
    				dao.clear();
    				dao.setConditionStatus("=",0);//只检索在职的
    	        	List<BaseEmployee> eList = dao.conditionalLoad();
    	        	if(!BaseHelpUtils.isNullOrEmpty(eList) && eList.size() > 0){
    	        		for(BaseEmployee e : eList){
    	        			//如果不是通用的，且对象类型不一致，则不发送
    	        			if(objectType != 0 && objectType != e.getGender()){
    	        				continue;
    	        			}
    	        			OnTelMobile.onTelMobileSendMeg(e.getEmployeeId(),blessWords);
    	        		}
    	        	}
    			}
    		}
    		
    		//检索公司客户节日祝福语
        	holidayDao.clear();
    		holidayDao.setConditionHolidayType("=",2);//节日祝福语
    		holidayDao.setConditionHolidayDate("=",currentDate);
    		holidayDao.setConditionSendObject("=",2);//公司员工
    		holidayBean = holidayDao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(holidayBean)){
    			//获取祝福语
    			String blessWords = holidayBean.getBlessWords();
    			if(!BaseHelpUtils.isNullOrEmpty(blessWords)){
    				//获取对象类型:0:通用;1:男;2:女
    				int objectType = holidayBean.getObjectType();
    				//加载公司客户信息
    				crDao.clear();
    	        	crList = crDao.conditionalLoad();
    	        	if(!BaseHelpUtils.isNullOrEmpty(crList) && crList.size() > 0){
    	        		for(BaseCustomerResource e : crList){
    	        			//如果不是通用的，且对象类型不一致，则不发送
    	        			if(objectType != 0 && objectType != e.getGender()){
    	        				continue;
    	        			}
    	        			//获取客户电话号码
        					String telephone = e.getTelephone();
    	        			OnTelMobile.onTelMobileSendMeg(telephone, blessWords);
    	        		}
    	        	}
    			}
    		}
			
			ThreadConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        
    }
    
    public static void main(String[] args) {
    	OnSendBlessTime ss = new OnSendBlessTime();
    	ss.run();
	}
}
