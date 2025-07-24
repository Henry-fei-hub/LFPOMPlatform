package pomplatform.workflow.business;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;

/**
 *  提前一个月转正通知部门领导
 * @author 
 */
public class OnLoadMsgEmployeeConfirmationNoticeTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnLoadMsgEmployeeConfirmationNoticeTimer.class);
    
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
    
    private static  String job="招聘专员";

    @SuppressWarnings("deprecation")
	public  void run() {
    	__logger.debug("开始计算时间");
        try {
//        	ThreadConnection.beginTransaction();
        	Calendar c = Calendar.getInstance();
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Date currentDate = new Date();
//        	String sss="2018-12-08";
//        	Date currentDate=simpleDateFormat.parse(sss);
        	//一月后
            c.setTime(currentDate);
            c.add(Calendar.MONTH, +1);
            c.add(Calendar.DAY_OF_MONTH, +1);
            Date m = c.getTime();
            String mon = simpleDateFormat.format(m);
            Date mon2 = simpleDateFormat.parse(mon);
//            System.out.println("一个月后："+mon);
            
            //十五天后
            c.setTime(currentDate);
            c.add(Calendar.DATE, +16);
            Date d = c.getTime();
            String day = simpleDateFormat.format(d);
            Date day2 = simpleDateFormat.parse(day);
//            System.out.println("十五天后："+day);
            
            EmployeeRole erDao =new EmployeeRole();
            CompanyRecord crDao = new CompanyRecord();
            Employee dao =new Employee();

            //1.通知部门的直属领导
            //2.通知人事，深圳的提醒陆永昌、北京禹妍妍、大连刘薇、上海岑妍妮、武汉张茜
            crDao.setConditionIsEnabled("=", true);
            List<BaseCompanyRecord> companies = crDao.conditionalLoad();
            
            
            //roles是人事助理或招聘专员的行政人事人员
            erDao.clear();
            Integer[] args =new Integer[] {StaticUtils.ROLE_64,StaticUtils.ROLE_57};
            erDao.addCondition(BaseEmployeeRole.CS_ROLE_ID, "in", args);
            List<BaseEmployeeRole> EmployeeRoleList = erDao.conditionalLoad();
            Integer[] ints =new Integer[EmployeeRoleList.size()];
            if(!BaseHelpUtils.isNullOrEmpty(EmployeeRoleList)&&EmployeeRoleList.size()>0) {
            	for (int i = 0; i < EmployeeRoleList.size(); i++) {
            		ints[i]=EmployeeRoleList.get(i).getEmployeeId();
				}
            }
            
            dao.clear();
            dao.setConditionStatus("=", 0);
            dao.addCondition(BaseEmployeeRole.CS_EMPLOYEE_ID, "in", (Object[])ints);
            List<BaseEmployee> list = dao.conditionalLoad();
            if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
            	for (BaseEmployee baseEmployee : list) {
            		String ownedCompany = BaseHelpUtils.getString(baseEmployee.getOwnedCompany());
            		String jobs = BaseHelpUtils.getString(baseEmployee.getJobs());
            		String companyWeixin = BaseHelpUtils.getString(baseEmployee.getCompanyWeixin());
            		String employeeName = BaseHelpUtils.getString(baseEmployee.getEmployeeName());
            		if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_12+"")||ownedCompany.equals(StaticUtils.SIGN_COMPANY_6+"")) {
            			BJweixin=companyWeixin;
            			BJname=employeeName;
            		}else if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_10+"")||ownedCompany.equals(StaticUtils.SIGN_COMPANY_7+"")){
            			DLweixin=companyWeixin;
            			DLname=employeeName;
            		}else if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_13+"")||ownedCompany.equals(StaticUtils.SIGN_COMPANY_5+"")){
            			SHweixin=companyWeixin;
            			SHname=employeeName;
            		}else if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_13+"")||ownedCompany.equals(StaticUtils.SIGN_COMPANY_5+"")){
            			WHweixin=companyWeixin;
            			WHname=employeeName;
            		}else if(jobs.equals(job)&&ownedCompany.equals(StaticUtils.SIGN_COMPANY_0+"")){
            			SZweixin=companyWeixin;
            			SZname=employeeName;
            		}
            	}
            }
            
            //查询转正日期为一个月之后的在职员工
            dao.clear();
            dao.setConditionStatus("=", 0);
            dao.setConditionOnboardStatus("=", 1);
            dao.setConditionPositiveDate("=", mon2);
            List<BaseEmployee> conditionalLoad = dao.conditionalLoad();
            Message(conditionalLoad,mon);
            
            //查询转正日期为15天之后的在职员工
            dao.clear();
            dao.setConditionStatus("=", 0);
            dao.setConditionOnboardStatus("=", 1);
            dao.setConditionPositiveDate("=", day2);
            List<BaseEmployee> conditionalLoad2 = dao.conditionalLoad();
            Message(conditionalLoad2,day);
//			ThreadConnection.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
    }
    
    
    private static void Message(List<BaseEmployee> list,String day) throws SQLException {
        EmployeeRole erDao =new EmployeeRole();
        PersonnelBusines pbDao =new PersonnelBusines();
        Department dDao =new Department();
        CompanyRecord crDao = new CompanyRecord();
        Employee dao =new Employee();
    	
        if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
        	for (BaseEmployee baseEmployee : list) {
        		//通知哪个地区的人事
        		String ownedCompany = baseEmployee.getOwnedCompany();
        		String weixin ="";
        		String name ="";
        		if(!BaseHelpUtils.isNullOrEmpty(ownedCompany)) {
        			if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_12+"")||ownedCompany.equals(StaticUtils.SIGN_COMPANY_6+"")) {
        				weixin=BJweixin;
        				name =BJname;
        			}else if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_10+"")||ownedCompany.equals(StaticUtils.SIGN_COMPANY_7+"")){
        				weixin=DLweixin;
        				name =DLname;
        			}else if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_13+"")||ownedCompany.equals(StaticUtils.SIGN_COMPANY_5+"")){
        				weixin=SHweixin;
        				name =SHname;
        			}else if(ownedCompany.equals(StaticUtils.SIGN_COMPANY_4+"")){
        				weixin=WHweixin;
        				name =WHname;
        			}else {
        				weixin=SZweixin;
        				name =SZname;
        			}
        		}
        		//是否有进行转正流程
        		pbDao.clear();
        		pbDao.setConditionEmployeeId("=", baseEmployee.getEmployeeId());
        		pbDao.setConditionProcessType("=",  StaticUtils.PROCESS_TYPE_29);
        		BasePersonnelBusines execute = pbDao.executeQueryOneRow();
        		//为空则再进行通知部门领导
        		if(BaseHelpUtils.isNullOrEmpty(execute)) {
        		String companyWeixin ="";
        		String department ="";
        		String employeeName = baseEmployee.getEmployeeName();
        		if(BaseHelpUtils.getIntValue(baseEmployee.getDepartmentId())>0) {
        			Integer departmentId = baseEmployee.getDepartmentId();
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
        					String str = String.format(WeixinStatics.MSG_CONFIRMATION_NOTICE, department,employeeName,day,name);
        					ERPWeixinUtils.sendTextMsgToUser(companyWeixin, str);
        					if(!BaseHelpUtils.isNullOrEmpty(weixin)) {
        						String str2 = String.format(WeixinStatics.MSG_CONFIRMATION_NOTICE_2, department,employeeName,day,executeQueryOneRow.getEmployeeName());
        						ERPWeixinUtils.sendTextMsgToUser(weixin, str2);
        					}
        				}
        			}
        		}
			}
        	}
        }
        
    }
    
    public static void main(String[] args) throws Exception {
//		run();
//    	WeixinUtils.sendWXMsgToUser(8, "111");
//    	System.out.println(WeixinUtils.sendTextMsgToUser(WeixinUtils.TEST_USERID, "ces"));
	}
    
}
