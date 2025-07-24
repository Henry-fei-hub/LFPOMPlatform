package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimerTask;

import delicacy.system.dao.Employee;
import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeChangePlateDetail;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeChangePlateDetail;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeDayPlateRecord;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PlateSalaryAdvanceRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;
import delicacy.otheraccount.UserAccountUtils;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;


/**
 * 
 * @author CL
 *
 */
public class ApplyForTransferTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(ApplyForTransferTask.class);

    @Override
    public void run() {
        __logger.debug("开始进行员工转岗处理");
        
        try {
        	Date currentDate = new Date();
        	String currentDateStr = DateUtil.formatDateString(currentDate);
			String sql = "'"+currentDateStr+"' = to_char(complete_time,'yyyy-mm-dd')";
        	SystemProcessInstance spiDao = new SystemProcessInstance();
        	spiDao.setConditionProcessStatus("=", 3);//流程完成
        	spiDao.setConditionProcessType("=", 26);//转岗
        	spiDao.setConditionDeleteFlag("=", 0);//未删除
        	List<BaseSystemProcessInstance> spiList = spiDao.conditionalLoad(sql);
        	if(spiList.size() > 0){
        		Object[] arr = new Object[spiList.size()];
        		for (int i = 0; i < spiList.size(); i++) {
        			arr[i] = spiList.get(i).getBusinessId();
				}
        		PersonnelBusines pbDao = new PersonnelBusines();
        		pbDao.addCondition(BasePersonnelBusines.CS_PERSONNEL_BUSINESS_ID, "in", arr);
        		pbDao.setConditionDeleteFlag("=", 0);
        		List<BasePersonnelBusines> pbList = pbDao.conditionalLoad();
        		//设置当前月的11号，每个月11号去处理当月11号之前员工剩余积分，之后就是每天去执行，主要是考虑到10号发工资，成本延迟的情况
        		int dayOfMonth = DateUtil.getDayOfMonth(currentDate);
        		EmployeeChangePlateDetail ecDao = new EmployeeChangePlateDetail();
        		Department dDao = new Department();
        		Employee eDao = new Employee();
        		String employeeNo = "";
        		String employeeName = "";
        		EmployeeChangePlateRecord ecprDao = new EmployeeChangePlateRecord();
        		EmployeeDayPlateRecord edprDao = new EmployeeDayPlateRecord();
        		for (BasePersonnelBusines bean : pbList) {
        			Date sureDate = null;
					if(null == bean.getEndDate()){
						sureDate = bean.getStartDate();
					}else{
						sureDate = bean.getEndDate();
					}
					//如果延迟审批完，则转岗日期节点以审批完流程这一天的日期为准
					if(sureDate.before(currentDate)){
						sureDate = currentDate;
					}
        			eDao.clear();
        			int employeeId = bean.getEmployeeId();
    				eDao.setEmployeeId(employeeId);
    				if(eDao.load()){
    					employeeNo = eDao.getEmployeeNo();
    					employeeName = eDao.getEmployeeName();
    					dDao.clear();
    					dDao.setDepartmentId(eDao.getDepartmentId());
    					Integer fromCompanyId = eDao.getCompanyId();
    					Integer toCompanyId = bean.getCompanyId();
    					int fromPlateId = 0 ;
    					int toPlateId = 0 ;
    					if(dDao.load()){
    						fromPlateId = dDao.getPlateId();
    					}
    					dDao.clear();
    					dDao.setDepartmentId(bean.getParentId());
    					if(dDao.load()){
    						toPlateId = dDao.getPlateId();
    					}
    					if(fromPlateId > 0 && toPlateId > 0 && toPlateId != fromPlateId){
    						ecDao.clear();
    						int year = DateUtil.getYear(sureDate);
    						int month = DateUtil.getMonth(sureDate);
    						ecDao.setYear(year);
    						ecDao.setMonth(month);
    						ecDao.setOutPlateId(fromPlateId);
    						ecDao.setInPlateId(toPlateId);
    						ecDao.setCreateTime(new Date());
    						ecDao.setChangePlateDate(sureDate);
    						ecDao.setEmployeeId(employeeId);
    						ecDao.save();
    						int ecBusinessId = ecDao.getEmployeeChangePlateDetailId();
    						//向每月归属部门表插入数据
    						ecprDao.clear();
    						ecprDao.setConditionEmployeeId("=",employeeId);
    						ecprDao.setConditionMonth("=",month);
    						ecprDao.setConditionYear("=",year);
    						if(ecprDao.countRows() == 0){
    							ecprDao.clear();
    							ecprDao.setEmployeeId(employeeId);
    							ecprDao.setYear(year);
    							ecprDao.setMonth(month);
    							ecprDao.setPlateId(toPlateId);
    							ecprDao.setCreateTime(new Date());
    							ecprDao.setUpdateTime(new Date());
    							ecprDao.setChangePlateDate(sureDate);
    							ecprDao.setDepartmentId(bean.getParentId());
    							ecprDao.save();
    						}else{
    							ecprDao.setPlateId(toPlateId);
    							ecprDao.setDepartmentId(bean.getParentId());
    							ecprDao.setChangePlateDate(sureDate);
    							ecprDao.setUpdateTime(new Date());
    							ecprDao.conditionalUpdate();
    						}
    						//向每日归属部门表插入数据
    						edprDao.clear();
    						edprDao.setConditionEmployeeId("=",employeeId);
    						edprDao.setConditionRecordDate("=",sureDate);
    						if(edprDao.isExist()) {
    							edprDao.setPlateId(toPlateId);
    							edprDao.setDepartmentId(bean.getParentId());
    							edprDao.conditionalUpdate();
    						}else {
    							edprDao.clear();
    							edprDao.setEmployeeId(employeeId);
    							edprDao.setYear(year);
    							edprDao.setMonth(month);
    							edprDao.setRecordDate(sureDate);
    							edprDao.setPlateId(toPlateId);
    							edprDao.setEmployeeName(employeeName);
    							edprDao.setEmployeeNo(employeeNo);
    							edprDao.setDepartmentId(bean.getParentId());
    							edprDao.setCompanyId(eDao.getCompanyId());
    							edprDao.setOnboardStatus(eDao.getOnboardStatus());
    							edprDao.save();
    						}
    						
    						//人员进行变动    改变部门 、确认积分、 微信、企业邮箱、ECMC数据
    						if(dayOfMonth >= 11){
    							onOperateEmpIntegral(employeeId, fromPlateId, ecBusinessId, sureDate, employeeNo, employeeName);
    						}
    					}

    					//更新员工的归属部门与业务部门
    					eDao.setDepartmentId(bean.getParentId());
    					if(toPlateId > 0 && toPlateId != fromPlateId){
    						eDao.setPlateId(toPlateId);
    					}
    					//更新员工归属公司
    					if((null != fromCompanyId && null != toCompanyId && !Objects.equals(fromCompanyId, toCompanyId))){
    						eDao.setCompanyId(toCompanyId);
    						eDao.setOwnedCompany(toCompanyId+"");
    					}
    					eDao.setDutyId(bean.getDutyId());//岗位转变
    					eDao.update();

    					//进行第三方账号的更改
    					UserAccountUtils.updateUserAccount(eDao.generateBase(), 1);
    				}
				}
        		//处理当前月11号之前转岗员工的转岗积分
        		if(dayOfMonth == 11){
        			onOperateBeforIntegral(pbList, currentDate);
        		}
        	}
        	
		} catch (Exception e) {
			__logger.error(String.format("员工转岗处理出错 : {%1$s}", e.getMessage()));
		}
    }
    
    /**
     * 处理当前月11号之前转岗员工的转岗积分
     * @param pbList
     * @param currentDate
     * @throws SQLException
     */
    public void onOperateBeforIntegral(List<BasePersonnelBusines> pbList,Date currentDate) throws SQLException{
    	if(!BaseHelpUtils.isNullOrEmpty(pbList) && pbList.size() > 0){
    		int currentYear = DateUtil.getYear(currentDate);
    		int currentMonth = DateUtil.getMonth(currentDate);
    		EmployeeChangePlateDetail ecDao = new EmployeeChangePlateDetail();
    		Department dDao = new Department();
    		Employee eDao = new Employee();
    		for(BasePersonnelBusines bean : pbList){
    			Date sureDate = null;
				if(null == bean.getEndDate()){
					sureDate = bean.getStartDate();
				}else{
					sureDate = bean.getEndDate();
				}
				int sureYear = DateUtil.getYear(sureDate);
				int sureMonth = DateUtil.getMonth(sureDate);
				int sureDay = DateUtil.getDayOfMonth(sureDate);
				if(currentYear == sureYear && currentMonth == sureMonth && sureDay < 11){
	        		String employeeNo = "";
	        		String employeeName = "";
	        		eDao.clear();
        			int employeeId = bean.getEmployeeId();
    				eDao.setEmployeeId(employeeId);
    				if(eDao.load()){
    					employeeNo = eDao.getEmployeeNo();
    					employeeName = eDao.getEmployeeName();
    					dDao.clear();
    					dDao.setDepartmentId(eDao.getDepartmentId());
    					int fromPlateId = 0 ;
    					int toPlateId = 0 ;
    					if(dDao.load()){
    						fromPlateId = dDao.getPlateId();
    					}
    					dDao.clear();
    					dDao.setDepartmentId(bean.getParentId());
    					if(dDao.load()){
    						toPlateId = dDao.getPlateId();
    					}
    					if(fromPlateId > 0 && toPlateId > 0 && toPlateId != fromPlateId){
    						ecDao.clear();
    						ecDao.setConditionYear("=",sureYear);
    						ecDao.setConditionMonth("=",sureMonth);
    						ecDao.setConditionEmployeeId("=",employeeId);
    						BaseEmployeeChangePlateDetail ecBean = ecDao.executeQueryOneRow();
    						if(BaseHelpUtils.isNullOrEmpty(ecBean)){
    							continue;
    						}
    						int ecBusinessId = ecBean.getEmployeeChangePlateDetailId();
    						onOperateEmpIntegral(employeeId, fromPlateId, ecBusinessId, sureDate, employeeNo, employeeName);
    					}
    				}
				}
    		}
    	}
    }
    
    /**
     * 转岗人员积分处理
     * @param employeeId
     * @param fromPlateId
     * @param ecBusinessId
     * @param sureDate
     * @param employeeNo
     * @param employeeName
     * @throws SQLException
     */
    public void onOperateEmpIntegral(int employeeId,int fromPlateId,int ecBusinessId,Date sureDate,String employeeNo,String employeeName) throws SQLException{
    	AccountManageProcess am = new AccountManageProcess();
		Map<Integer, BigDecimal> data = am.getLeftIntegralOfEmployee(employeeId);
		BigDecimal money = data.get(employeeId);
		if(null != money && money.compareTo(BigDecimal.ZERO) != 0){
			Calendar cd = Calendar.getInstance();
			cd.setTime(sureDate);
			cd.add(Calendar.DAY_OF_MONTH, -1);
			if(money.compareTo(BigDecimal.ZERO) > 0){
				AccountManageProcess.onSaveEmployeeAccount(employeeId, ecBusinessId, AccountManageProcess.EMP_BT_PLATE_CHANGE_ACHIEVE, money, sureDate, null,employeeId);
				AccountManageProcess.onSaveEmployeeAccount(employeeId, ecBusinessId, AccountManageProcess.EMP_BT_PLATE_CHANGE_PAY, money, cd.getTime(), null,employeeId);
			}else{//如果是负积分，则由部门积分借款給到他
				money = money.abs();
				PlateSalaryAdvanceRecord psaDao = new PlateSalaryAdvanceRecord();
				psaDao.setPlateId(fromPlateId);
				psaDao.setEmployeeId(employeeId);
				psaDao.setEmployeeName(employeeName);
				psaDao.setEmployeeNo(employeeNo);
				psaDao.setSalaryReturn(money);
				psaDao.setRecordDate(sureDate);
				psaDao.save();
				int businessId = psaDao.getPlateSalaryAdvanceRecordId();
				//向部门账户中插入数据
				AccountManageProcess.onSavePlateAccount(fromPlateId,businessId, AccountManageProcess.PLATE_BT_INTEGRAL_ADVANCE, money, cd.getTime(), "转岗积分借款",employeeId);
				//向个人账户插入数据
				AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_INTEGRAL_ADVANCE, money, cd.getTime(),"转岗积分借款", employeeId);
			}
		}
    }
    //手动转岗  慎重操作。。。。
    public static void main(String[] args) throws Exception {
//    	Employee eDao = new Employee();
//    	eDao.setEmployeeId(1157);
//    	eDao.load();
//    	//工号改变
//		QueryMakeEmployeeNo dao = new QueryMakeEmployeeNo();
//		dao.setCurrentPage(0);
//		dao.setPageLines(1);
//		ConditionMakeEmployeeNo condition = new ConditionMakeEmployeeNo();
//		condition.setCompanyRecordId(eDao.getCompanyId());
//		condition.setPlateId(eDao.getPlateId());
//		BaseCollection<BaseMakeEmployeeNo> result = dao.executeQuery( null, condition) ;
//		if(result.getCollections().size() > 0){
//			BaseMakeEmployeeNo tmpBean = result.getCollections().get(0);
//			String companyCode = delicacy.common.BaseHelpUtils.getString(tmpBean.getCompanyCode());
//			String plateCode = delicacy.common.BaseHelpUtils.getString(tmpBean.getPlateCode());
//			String num = delicacy.common.BaseHelpUtils.getString(tmpBean.getNum());
//			if(num.length() == 0){
//				num = "000";
//			}else if(num.length() == 1){
//				num = "00" + num;
//			}else if(num.length() == 2){
//				num = "0" + num;
//			}
//			System.out.println(companyCode+plateCode+num);
//			eDao.setEmployeeNo(companyCode+plateCode+num);
//		}
//		eDao.update();
//		String content = String.format(WeixinStatics.MSG_TRANSFER, eDao.getEmployeeName(), eDao.getEmployeeNo());
//		WeixinUtils.sendTextMsgToUser(eDao.getCompanyWeixin(), content);
//		System.out.println(content);
//		//进行第三方账号的更改
//		UserAccountUtils.updateUserAccount(eDao.generateBase(), 1);
    	ApplyForTransferTask dao = new ApplyForTransferTask();
    	dao.run();
	}
}
