package pomplatform.project.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.dao.*;
import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProjectPerformanceNodeEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.project.bean.BaseOnProjectManageStatus;
import pomplatform.project.bean.ConditionOnProjectManageStatus;
import pomplatform.project.query.QueryOnProjectManageStatus;

/**
 *
 * @author 
 */
public class ProjectPerformanceManageTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(ProjectPerformanceManageTimer.class);
    private static final BigDecimal freeHours = new BigDecimal(48);
    private static final BigDecimal compareHours = new BigDecimal(24);
    @Override
    public void run() {
    	try {
    		ThreadConnection.beginTransaction();
    		Date currentDate = new Date();
    		Calendar ca = Calendar.getInstance();
    		int day = ca.get(Calendar.DAY_OF_WEEK);
    		if(1 < day && day < 7){//过滤掉周六和周日，周末两天不进行监控
    			QueryOnProjectManageStatus dao = new QueryOnProjectManageStatus();
    			ConditionOnProjectManageStatus con = new ConditionOnProjectManageStatus();
    			//先加载没有报价单的项目信息
    			con.setHasOutQuotations(Boolean.FALSE);
    			BaseCollection<BaseOnProjectManageStatus> result = dao.executeQuery(null, con);
    			onFindDeductEmp(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_1, result, currentDate,day);
    			//拆分价模块,检索有报价单，但是没有拆分价的项目
    			con.setHasOutQuotations(Boolean.TRUE);
    			con.setHasSplitPrice(Boolean.FALSE);
    			result = dao.executeQuery(null, con);
    			onFindDeductEmp(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_2, result, currentDate,day);
    			//订单下达模块,检索有报价单和拆分价，但是没有订单下达的项目
    			con.setHasOutQuotations(Boolean.TRUE);
    			con.setHasSplitPrice(Boolean.TRUE);
    			con.setHasSendSheet(Boolean.FALSE);
    			result = dao.executeQuery(null, con);
    			onFindDeductEmp(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_3, result, currentDate,day);
    		}
    		ThreadConnection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			__logger.error("项目绩效管理异常", e);
		}
    }
    
    
    /**
     * 
     * @param businessType
     * @param result
     * @param currentDate
     * @return
     * @throws SQLException
     */
    public void onFindDeductEmp(int businessType,BaseCollection<BaseOnProjectManageStatus> result,Date currentDate,int day) throws SQLException{
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
			List<BaseOnProjectManageStatus> list = result.getCollections();
    		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    			ProjectPerformanceNodeEmployee nodeDao = new ProjectPerformanceNodeEmployee();
    			MainProjectEmployee mpeDao = new MainProjectEmployee();
    			for(BaseOnProjectManageStatus e : list){
    				//获取主项目Id
					int mainProjectId = BaseHelpUtils.getIntValue(e.getMainProjectId());
    				Date compareTime = null;

    				if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_1){//说明是报价单
    					//如果是投标立项项目，公开投标立项或邀请投标立项，并且是中标状态
    					if((e.getProjectBaseOn()==1 || e.getProjectBaseOn()==4) && e.getBidType()==2){
							compareTime = e.getWinningTime();
						}else {
							OutQuotation quotation = new OutQuotation();
							quotation.setInfoCode(e.getInfoCode());
							List<BaseOutQuotation> list1 = quotation.conditionalLoad();
							if(!BaseHelpUtils.isNullOrEmpty(list1)){//如果有报价单
								if(list1.size()==1  ){//如果是第一次报价单检测
									//获取立项时间
									compareTime = e.getProjectApprovalTime();
								}
							}
						}
		    		}else if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_2){//说明是拆分价
		    			//获取报价单的时间
		    			compareTime = e.getHasOutQuotationsTime();
		    		}else if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_3){//说明是订单下达
		    			//获取拆分价时间
		    			compareTime = e.getHasSplitPriceTime();
		    		}
    				if(BaseHelpUtils.isNullOrEmpty(compareTime)){
						continue;
					}
					//设置当前系统日期与项目立项日期相差小时数，如果超过24小时，则需对相关模块负责人进行绩效扣除
					BigDecimal hours = BaseHelpUtils.getBigDecimalValue(DateUtil.generateHoursBetween(currentDate, compareTime));
					//如果是周一的话则需减去周末两天48小时
					if(day == 2){
						hours = hours.subtract(freeHours);
					}
					if(hours.compareTo(compareHours) > 0){//24小时后未进行处理，则进行绩效扣款
						Map<Integer,Integer> empMap = new HashMap<>();
						if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_1){//说明是报价单
							/**
							 * 检索该项目报价单模块的负责人，即前期项目的项目跟进人员，可能有多个，如果是多个，则扣除多个人积分
							 * 如果是多个人，且多个同属一个部门的话，则对部门只进行一次扣款，上级部门同此
							 */
							mpeDao.clear();
							mpeDao.setConditionMainProjectId("=",mainProjectId);
							mpeDao.setConditionRelation("=",1);//只检索跟进人员
							mpeDao.setConditionMainAndAssistance("=",1);//只检索主要跟进人
							List<BaseMainProjectEmployee> mpeList = mpeDao.conditionalLoad();
							if(!BaseHelpUtils.isNullOrEmpty(mpeList) && mpeList.size() > 0 ){
								for(BaseMainProjectEmployee mpeBean : mpeList){
									//获取跟进人员Id
									int empId = BaseHelpUtils.getIntValue(mpeBean.getEmployeeId());
									empMap.put(empId,empId);
								}
							}
			    		}else if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_2){//说明是拆分价
			    			//如果是拆分价的话，由于人员不足，改了48小时
			    			if(hours.compareTo(freeHours) > 0) {
			    				//检索拆分价模块的扣款人员
			    				nodeDao.clear();
			    				nodeDao.setConditionBusinessType("=",1);//只检索拆分价的维护人员
			    				List<BaseProjectPerformanceNodeEmployee> nodeList = nodeDao.conditionalLoad();
			    				if(!BaseHelpUtils.isNullOrEmpty(nodeList) && nodeList.size() > 0){
			    					for(BaseProjectPerformanceNodeEmployee nodeBean : nodeList){
			    						//获取跟进人员Id
			    						int empId = BaseHelpUtils.getIntValue(nodeBean.getEmployeeId());
			    						empMap.put(empId,empId);
			    					}
			    				}
			    			}
			    		}else if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_3){//说明是订单下达
			    			//检索拆分价模块的扣款人员
			    			nodeDao.clear();
			    			nodeDao.setConditionBusinessType("=",2);//只检索订单下达的维护人员
			    			List<BaseProjectPerformanceNodeEmployee> nodeList = nodeDao.conditionalLoad();
			    			if(!BaseHelpUtils.isNullOrEmpty(nodeList) && nodeList.size() > 0){
			    				for(BaseProjectPerformanceNodeEmployee nodeBean : nodeList){
			    					//获取跟进人员Id
									int empId = BaseHelpUtils.getIntValue(nodeBean.getEmployeeId());
									empMap.put(empId,empId);
			    				}
			    			}
			    		}
						onCommonDeduct(businessType, empMap, currentDate, mainProjectId, e.getInfoCode(), e.getProjectName());
					}
    			}
    		}
		}
    }
    
    /**
     * 
     * @param businessType
     * @param empMap
     * @throws SQLException 
     */
    public void onCommonDeduct(int businessType,Map<Integer,Integer> empMap,Date currentDate,int mainProjectId,String infoCode,String projectName) throws SQLException{
    	ProjectManagePerformanceTotal pmptDao = new ProjectManagePerformanceTotal();
    	pmptDao.setConditionMainProjectId("=",mainProjectId);
    	pmptDao.setConditionBusinessType("=",businessType);
    	if(!pmptDao.isExist() && !BaseHelpUtils.isNullOrEmpty(empMap) && empMap.size() > 0){
    		Employee dao = new Employee();
    		PlateRecord pDao = new PlateRecord();
    		BasePlateRecord pBean = null;
    		//设置这一次累计扣款金额
    		BigDecimal totalDeduct = BigDecimal.ZERO;
    		//定义map来存放部门及扣款数据
    		Map<Integer,BigDecimal> plateMap = new HashMap<>();
    		//定义map来存放人员信息
    		Map<Integer,BaseEmployee> empDataMap = new HashMap<>();
    		for(Integer empId : empMap.keySet()){
    			dao.clear();
    			dao.setEmployeeId(empId);
    			if(dao.load()){
    				empDataMap.put(empId,dao.generateBase());
    				//扣除个人账户500积分
					totalDeduct = totalDeduct.add(StaticUtils.DEDUCT_MONEY_500);
    				//获取业务部门Id
    				int plateId = BaseHelpUtils.getIntValue(dao.getPlateId());
    				if(plateId > 0){
    					//设置当前部门扣款积分
						BigDecimal currentPlatedeductMoney = BigDecimal.ZERO;
						//设置上级部门扣款金额
						BigDecimal parentPlatedeductMoney = BigDecimal.ZERO;
    					//获取上级部门ID
    					pDao.clear();
    					pDao.setConditionPlateId("=",plateId);
    					pBean = pDao.executeQueryOneRow();
    					int parentId = 0;
    					if(!BaseHelpUtils.isNullOrEmpty(pBean)){
    						parentId = BaseHelpUtils.getIntValue(pBean.getParentId());
    					}
    					if(parentId > 0){
    						currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1000;
    						parentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1000;
    					}else{
    						currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_2000;
    					}
    					//检索该部门是否已经扣过款了，如果已扣过，则无需再进行扣款
    					if(!plateMap.containsKey(plateId)){
    						plateMap.put(plateId, currentPlatedeductMoney);
    						totalDeduct = totalDeduct.add(currentPlatedeductMoney);
    					}
    					if(!plateMap.containsKey(parentId)){
    						plateMap.put(parentId, parentPlatedeductMoney);
    						totalDeduct = totalDeduct.add(parentPlatedeductMoney);
    					}
    				}
    			}
    		}
    		String businessName = "";
    		String remark = "";
    		if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_1){//说明是报价单
    			businessName = String.format("%1$s-%2$s-%3$s",StaticUtils.POROJECT_PERFORMANCE_BUSINESS_1,projectName,DateUtil.getChinaDateString(currentDate));
    			remark = String.format("因项目(%1$s-%2$s)在报价单阶段超过规定时限，进行项目绩效扣除",infoCode,projectName);
    		}else if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_2){//说明是拆分价
    			businessName = String.format("%1$s-%2$s-%3$s",StaticUtils.POROJECT_PERFORMANCE_BUSINESS_2,projectName,DateUtil.getChinaDateString(currentDate));
    			remark = String.format("因项目(%1$s-%2$s)在拆分价阶段超过规定时限，进行项目绩效扣除",infoCode,projectName);
    		}else if(businessType == StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_3){//说明是订单下达
    			businessName = String.format("%1$s-%2$s-%3$s",StaticUtils.POROJECT_PERFORMANCE_BUSINESS_3,projectName,DateUtil.getChinaDateString(currentDate));
    			remark = String.format("因项目(%1$s-%2$s)在订单下达阶段超过规定时限，进行项目绩效扣除",infoCode,projectName);
    		}
    		//插入总表数据
    		pmptDao.clear();
			pmptDao.setBusinessType(businessType);
			pmptDao.setBusinessName(businessName);
			pmptDao.setMainProjectId(mainProjectId);
			pmptDao.setPerformanceMoney(totalDeduct);
			pmptDao.setRecordDate(currentDate);
			pmptDao.setRecordTime(currentDate);
			pmptDao.setRemark(remark);
			pmptDao.save();
			int totalBusinessId = pmptDao.getProjectManagePerformanceTotalId();
			//插入品质基金账户
			AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT,0, totalBusinessId, AccountManageProcess.project_performance_achieve,totalDeduct,remark,-1);
			//插入明细表
			ProjectManagePerformanceRecord pmfrDao = new ProjectManagePerformanceRecord();
			//插入个人数据
			for(Integer empId : empDataMap.keySet()){
				BaseEmployee empBean = empDataMap.get(empId);
				pmfrDao.clear();
				pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
				pmfrDao.setObjectId(empId);
				pmfrDao.setObjectNo(empBean.getEmployeeNo());
				pmfrDao.setObjectName(empBean.getEmployeeName());
				pmfrDao.setObjectType(1);//1：人员；2：部门
				pmfrDao.setPerformanceMoney(StaticUtils.DEDUCT_MONEY_500);
				pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
				pmfrDao.setBusinessType(businessType);
				pmfrDao.setBusinessName(businessName);
				pmfrDao.setRecordDate(currentDate);
				pmfrDao.setRecordTime(currentDate);
				pmfrDao.setRemark(remark);
				pmfrDao.save();
				int businessId = pmfrDao.getProjectManagePerformanceRecordId();
				//插入个人账户
				AccountManageProcess.onSaveEmployeeAccount(empId, businessId,AccountManageProcess.EMP_BT_PROJECT_PERFORMANCE_PAY, StaticUtils.DEDUCT_MONEY_500, currentDate, remark, -1);
			}
			//插入部门数据
			for(Integer plateId : plateMap.keySet()){
				//获取扣款金额
				BigDecimal deduceMoney = BaseHelpUtils.getBigDecimalValue(plateMap.get(plateId));
				pDao.clear();
				pDao.setConditionPlateId("=",plateId);
				BasePlateRecord plateBean = pDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(plateBean) && deduceMoney.compareTo(BigDecimal.ZERO) > 0){
					pmfrDao.clear();
					pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
					pmfrDao.setObjectId(plateId);
					pmfrDao.setObjectNo(plateBean.getPlateCode());
					pmfrDao.setObjectName(plateBean.getPlateName());
					pmfrDao.setObjectType(2);//1：人员；2：部门
					pmfrDao.setPerformanceMoney(deduceMoney);
					pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
					pmfrDao.setBusinessType(businessType);
					pmfrDao.setBusinessName(businessName);
					pmfrDao.setRecordDate(currentDate);
					pmfrDao.setRecordTime(currentDate);
					pmfrDao.setRemark(remark);
					pmfrDao.save();
					int businessId = pmfrDao.getProjectManagePerformanceRecordId();
					//插入部门账户
					AccountManageProcess.onSavePlateAccount(plateId, businessId,AccountManageProcess.PLATE_BT_PROJECT_PERFORMANCE_PAY,deduceMoney,currentDate, remark, -1);
				}
			}
			
    	}
    }
    
    public static void main(String[] args) {
    	ProjectPerformanceManageTimer time = new ProjectPerformanceManageTimer();
    	time.run();
	}
}
