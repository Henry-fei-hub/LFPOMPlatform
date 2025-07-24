package pomplatform.workflow.business;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeRole;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.client.bean.BaseMemployeeeor;
import pomplatform.client.bean.ConditionMemployeeeor;
import pomplatform.client.query.QueryMemployeeeor;
import pomplatform.common.utils.StaticUtils;
import pomplatform.hr.bean.BaseEmployeeContractAttachment;
import pomplatform.hr.bean.ConditionEmployeeContractAttachment;
import pomplatform.hr.query.QueryEmployeeContractAttachment;

/**
 *  提前一个月通知劳动合同到期
 *  1.通知人资行政部门的人员
 *  2.通知部门领导
 * @author 
 */
public class OnLoadMsgLaborContractnNoticeTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnLoadMsgLaborContractnNoticeTimer.class);
    
    private static String SZweixin="";
    private static String BJweixin="";
    private static String DLweixin="";
    private static String SHweixin="";
    private static String WHweixin="";
    
    private static  String SZname="";
    private static  String BJname="";
    private static  String DLname="";
    private static  String SHname="";
    private static  String WHname="";
    
    @SuppressWarnings("deprecation")
	public  void run() {
    	__logger.debug("开始计算时间");
        try {
//        	ThreadConnection.beginTransaction();
        	Calendar c = Calendar.getInstance();
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        	Date currentDate = new Date();
        	String sss="2018-11-30";
        	Date currentDate=simpleDateFormat.parse(sss);
        	//一月后
            c.setTime(currentDate);
            c.add(Calendar.MONTH, +1);
            c.add(Calendar.DAY_OF_MONTH, +1);
            Date m = c.getTime();
            String mon = simpleDateFormat.format(m);
            Date mon2 = simpleDateFormat.parse(mon);
            System.out.println("一个月后："+mon);
            
            //十五天后
//            c.setTime(currentDate);
//            c.add(Calendar.DATE, +15);
//            Date d = c.getTime();
//            String day = simpleDateFormat.format(d);
//            Date day2 = simpleDateFormat.parse(day);
//          System.out.println("十五天后："+day);
            
            Department dDao =new  Department();
            EmployeeRole erDao =new EmployeeRole();
            Employee dao =new Employee();
            
            //人资行政部门的人员
    		QueryMemployeeeor qmDao = new QueryMemployeeeor();
    		ConditionMemployeeeor c1 =new  ConditionMemployeeeor();
    		BaseCollection<BaseMemployeeeor> result1 = qmDao.executeQuery( c1.getKeyValues(), c1) ;
    		
    		//查找所有在职人员，一个月后过期的劳动合同
    		QueryEmployeeContractAttachment qecDao =new QueryEmployeeContractAttachment();
    		ConditionEmployeeContractAttachment c2 =new ConditionEmployeeContractAttachment();
    		c2.setStatus(0);
    		c2.setEndDate(mon2);
    		c2.setWillEnd(1);
    		BaseCollection<BaseEmployeeContractAttachment> result2 = qecDao.executeQuery( c2.getKeyValues(), c2) ;
    		
    		if(!BaseHelpUtils.isNullOrEmpty(result2)&&result2.getCollections().size()>0) {
    			List<BaseEmployeeContractAttachment> collections = result2.getCollections();
    			//通知部门领导
    			for (BaseEmployeeContractAttachment baseEmployeeContractAttachment : collections) {
            		String companyWeixin ="";
            		String department ="";
            		String employeeName = baseEmployeeContractAttachment.getEmployeeName();
            		Integer departmentId = BaseHelpUtils.getIntValue(baseEmployeeContractAttachment.getDepartmentId());
            		if(departmentId>0) {
            			dDao.clear();
            			dDao.setConditionDepartmentId("=", departmentId);
            			BaseDepartment baseDepartment = dDao.executeQueryOneRow();
            			if(!BaseHelpUtils.isNullOrEmpty(baseDepartment)) {
            				department=	baseDepartment.getDepartmentName();
            			}
            			erDao.clear();
            			erDao.setConditionDepartmentId("=", departmentId);
            			erDao.setConditionRoleId("=", StaticUtils.ROLE_PLATE_MANAGE_MANAGER);
            			BaseEmployeeRole baseEmployeeRole = erDao.executeQueryOneRow();
            			if(!BaseHelpUtils.isNullOrEmpty(baseEmployeeRole)) {
            				Integer employeeId = baseEmployeeRole.getEmployeeId();
            				dao.clear();
            				dao.setConditionEmployeeId("=", employeeId);
            				dao.setConditionStatus("=", 0);
            				BaseEmployee executeQueryOneRow = dao.executeQueryOneRow();
            				if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
            					companyWeixin = executeQueryOneRow.getCompanyWeixin();
            					String str = String.format(WeixinStatics.MSG_LABOR_CONTRACT_NOTICE, department,employeeName,mon);
            					Thread.sleep(2000);
            					ERPWeixinUtils.sendTextMsgToUser(companyWeixin, str);
            				}
            			}
            		}
				}
    			//通知人资行政部门的人员
    			if(!BaseHelpUtils.isNullOrEmpty(result1)&&result1.getCollections().size()>0) {
    				int size = result2.getCollections().size();
    				String str = String.format(WeixinStatics.MSG_LABOR_CONTRACT_NOTICE_2,mon,size );
    				List<BaseMemployeeeor> collections2 = result1.getCollections();
    				for (BaseMemployeeeor baseMemployeeeor : collections2) {
    					String companyWeixin = baseMemployeeeor.getCompanyWeixin();
    					Thread.sleep(2000);
    					ERPWeixinUtils.sendTextMsgToUser(companyWeixin, str);
					}
    			}
    		}
    		
 //			ThreadConnection.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
    }
    
    public static void main(String[] args) throws Exception {
//		run();
	}
    
}
