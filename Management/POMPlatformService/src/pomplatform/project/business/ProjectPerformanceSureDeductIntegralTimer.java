package pomplatform.project.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.ProjectManagePerformanceRecord;
import com.pomplatform.db.dao.ProjectManagePerformanceTotal;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.project.bean.BaseOnRevenueSureWarn;
import pomplatform.project.bean.ConditionOnRevenueSureWarn;
import pomplatform.project.query.QueryOnRevenueSureWarn;

/**
 *
 * @author 
 */
public class ProjectPerformanceSureDeductIntegralTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(ProjectPerformanceSureDeductIntegralTimer.class);
    
    @Override
    public void run() {
    	try {
    		Calendar ca = Calendar.getInstance();
    		int day = ca.get(Calendar.DAY_OF_WEEK);
    		if(day == 1){//表示是周日
    			QueryOnRevenueSureWarn dao = new QueryOnRevenueSureWarn();
    			ConditionOnRevenueSureWarn con = new ConditionOnRevenueSureWarn();
    			BaseCollection<BaseOnRevenueSureWarn> result = dao.executeQuery(null, con);
    			if(!BaseHelpUtils.isNullOrEmpty(result)){
    				List<BaseOnRevenueSureWarn> list = result.getCollections();
    				if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    					ThreadConnection.beginTransaction();
    					Date currentDate = new Date();
    					PlateRecord prDao = new PlateRecord();
    					BasePlateRecord prBean = null;
    					for(BaseOnRevenueSureWarn e : list){
    						int warnFlag = BaseHelpUtils.getIntValue(e.getWarnFlag());
    						if(warnFlag == 2){//说明截止目前还没进行项目积分的确认，则进行扣款
    							//获取项目经理id
    							int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    							String employeeName = BaseHelpUtils.getString(e.getEmployeeName());
    							String contentOne = "因项目积分超过规定时限未进行任何确认，进行项目绩效扣除";
    							if(employeeId <= 0){
    								continue;
    							}
    							//设置这一次累计扣款金额，包括项目经理和部门扣款
    							BigDecimal totalDeduct = BigDecimal.ZERO;
    							String contentTwo = String.format("因项目经理(%1$s)超过本周规定时限未进行任何确认，进行项目绩效扣除", employeeName);
								//设置当前部门扣款积分
    							BigDecimal currentPlatedeductMoney = BigDecimal.ZERO;
    							//设置上级部门扣款金额
    							BigDecimal parentPlatedeductMoney = BigDecimal.ZERO;
    							//扣除个人账户500积分
    							totalDeduct = totalDeduct.add(StaticUtils.DEDUCT_MONEY_500);
    							//获取项目经理归属的业务部门
    							int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
    							int parentId = 0;
    							if(plateId > 0){
    								//扣除部门账户积分
    								prDao.clear();
    								prDao.setConditionPlateId("=",plateId);
    								prBean = prDao.executeQueryOneRow();
    								if(!BaseHelpUtils.isNullOrEmpty(prBean)){
    									parentId = BaseHelpUtils.getIntValue(prBean.getParentId());
    								}
    								if(parentId == 0){//说明项目经理归属的业务部门是一级部门，则扣除2000积分
    									currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_2000;
    								}else{//说明当前项目经理归属的业务部门还有上级部门，则扣除1000积分，上级部门也扣除1000积分
    									currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1000;
    									//扣除上级部门1000积分
    									parentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1000;
    								}
    							}
    							totalDeduct = totalDeduct.add(currentPlatedeductMoney).add(parentPlatedeductMoney);
    							//设置业务模块名称
    							String businessName = String.format("%1$s-%2$s-%3$s",StaticUtils.POROJECT_PERFORMANCE_BUSINESS_4,employeeName,DateUtil.getChinaDateString(currentDate));
    							//插入总表数据
    							ProjectManagePerformanceTotal pmptDao = new ProjectManagePerformanceTotal();
    							pmptDao.setBusinessType(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_4);
    							pmptDao.setBusinessName(businessName);
    							pmptDao.setPerformanceMoney(totalDeduct);
    							pmptDao.setEmployeeId(employeeId);
    							pmptDao.setRecordDate(currentDate);
    							pmptDao.setRecordTime(currentDate);
    							pmptDao.setRemark(contentTwo);
    							pmptDao.save();
    							int totalBusinessId = pmptDao.getProjectManagePerformanceTotalId();
    							//插入品质基金账户
    							AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT,0, totalBusinessId, AccountManageProcess.project_performance_achieve,totalDeduct,contentTwo,-1);
    							//插入明细表
    							ProjectManagePerformanceRecord pmfrDao = new ProjectManagePerformanceRecord();
    							pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
    							pmfrDao.setObjectId(employeeId);
    							pmfrDao.setObjectNo(e.getEmployeeNo());
    							pmfrDao.setObjectName(e.getEmployeeName());
    							pmfrDao.setObjectType(1);//1：人员；2：部门
    							pmfrDao.setPerformanceMoney(StaticUtils.DEDUCT_MONEY_500);
    							pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
    							pmfrDao.setBusinessType(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_4);
    							pmfrDao.setBusinessName(businessName);
    							pmfrDao.setRecordDate(currentDate);
    							pmfrDao.setRecordTime(currentDate);
    							pmfrDao.setRemark(contentOne);
    							pmfrDao.save();
    							int businessId = pmfrDao.getProjectManagePerformanceRecordId();
    							//插入个人账户
    							AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId,AccountManageProcess.EMP_BT_PROJECT_PERFORMANCE_PAY, StaticUtils.DEDUCT_MONEY_500, currentDate, contentOne, -1);
    							if(plateId > 0 && currentPlatedeductMoney.compareTo(BigDecimal.ZERO) > 0){
    								prDao.clear();
    								prDao.setConditionPlateId("=",plateId);
    								prBean = prDao.executeQueryOneRow();
    								if(!BaseHelpUtils.isNullOrEmpty(prBean)){
    									//插入明细表
    									pmfrDao.clear();
    									pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
    									pmfrDao.setObjectId(plateId);
    									pmfrDao.setObjectNo(prBean.getPlateCode());
    									pmfrDao.setObjectName(prBean.getPlateName());
    									pmfrDao.setObjectType(2);//1：人员；2：部门
    									pmfrDao.setPerformanceMoney(currentPlatedeductMoney);
    									pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
    									pmfrDao.setBusinessType(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_4);
    									pmfrDao.setBusinessName(businessName);
    									pmfrDao.setRecordDate(currentDate);
    									pmfrDao.setRecordTime(currentDate);
    									pmfrDao.setRemark(contentTwo);
    									pmfrDao.save();
    									businessId = pmfrDao.getProjectManagePerformanceRecordId();
    									//插入部门账户
    									AccountManageProcess.onSavePlateAccount(plateId, businessId,AccountManageProcess.PLATE_BT_PROJECT_PERFORMANCE_PAY,currentPlatedeductMoney,currentDate, contentTwo, -1);
    								}
    							}
    							if(parentId > 0 && parentPlatedeductMoney.compareTo(BigDecimal.ZERO) > 0){
    								prDao.clear();
    								prDao.setConditionPlateId("=",parentId);
    								prBean = prDao.executeQueryOneRow();
    								if(!BaseHelpUtils.isNullOrEmpty(prBean)){
    									//插入明细表
    									pmfrDao.clear();
    									pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
    									pmfrDao.setObjectId(parentId);
    									pmfrDao.setObjectNo(prBean.getPlateCode());
    									pmfrDao.setObjectName(prBean.getPlateName());
    									pmfrDao.setObjectType(2);//1：人员；2：部门
    									pmfrDao.setPerformanceMoney(parentPlatedeductMoney);
    									pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
    									pmfrDao.setBusinessType(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_4);
    									pmfrDao.setBusinessName(businessName);
    									pmfrDao.setRecordDate(currentDate);
    									pmfrDao.setRecordTime(currentDate);
    									pmfrDao.setRemark(contentTwo);
    									pmfrDao.save();
    									businessId = pmfrDao.getProjectManagePerformanceRecordId();
    									//插入部门账户
    									AccountManageProcess.onSavePlateAccount(parentId, businessId,AccountManageProcess.PLATE_BT_PROJECT_PERFORMANCE_PAY,parentPlatedeductMoney,currentDate, contentTwo, -1);
    								}
    							}
    						}
    					}
    					ThreadConnection.commit();
    				}
    			}
    		}
		} catch (Exception e) {
			e.printStackTrace();
			__logger.error("项目绩效确认扣除金额警告异常", e);
		}
       
    }
    public static void main(String[] args) {
    	ProjectPerformanceSureDeductIntegralTimer time = new ProjectPerformanceSureDeductIntegralTimer();
    	time.run();
	}
}
