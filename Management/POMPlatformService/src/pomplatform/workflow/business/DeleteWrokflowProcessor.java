package pomplatform.workflow.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAnnualLeave;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.*;
import delicacy.system.executor.SystemProcessConstants;
import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import pomplatform.common.utils.StaticUtils;
import pomplatform.scapitaldistributionor.handler.CustomCapitalDistributionProcess;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.workflow.personnelbusiness.handler.GoodsApplyWorker;
import pomplatform.workflow.personnelbusiness.handler.PurchaseApplyWorker;
import pomplatform.workflow.personnelbusiness.handler.ReturnOfItemsWorker;

public class DeleteWrokflowProcessor implements GenericProcessor {
    private static Logger logger = Logger.getLogger("");
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getString(param.get("optType"));
		switch (optType) {
		case "deleteNormalReimbursement"://删除日常报销数据
			return deleteNormalReimbursement(param);
		case "deleteTravelReimbursement"://删除差旅报销数据
			return deleteTravelReimbursement(param);
		case "deleteEmployeeBorrowMoney"://删除借款申请
			return deleteEmployeeBorrowMoney(param);
		case "deletePayMoney"://删除预付款申请
			return deletePayMoney(param);
		case "deleteCapitalDistributions"://删除回款分配
			return deleteCapitalDistributions(param);
		case "deletePersonnelBusiness"://刪除人事流程(入职除外)
			return deletePersonnelBusiness(param);
		case "deletePersonnelBusinessAndSpecialDeduction"://刪除专项扣除流程
			return deletePersonnelBusinessAndSpecialDeduction(param);
		default:
			return null;
		}
    }
    
    
    /**
     * 
     * @Title: deleteCapitalDistributions 
     * @Description: 删除回款分配
     * @param @param param
     * @param @return
     * @param @throws Exception   
     * @return String   
     * @throws
     */
    public String deleteCapitalDistributions(Map<String, Object> param) throws Exception{
        int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
        int businessId = BaseHelpUtils.getIntValue(param.get("businessId"));
        if(processInstanceId > 0 && businessId > 0){
        	ThreadConnection.beginTransaction();
        	deleteSystemProcess(processInstanceId);
        	CapitalDistribution businessDao = new CapitalDistribution();
        	businessDao.setConditionCapitalDistributionId("=", businessId);
//        	businessDao.setDeleteFlag(StaticUtils.HAS_DELETE);
        	businessDao.conditionalUpdate();
        	businessDao.executeQueryOneRow();
        	CustomCapitalDistributionProcess.unDoCapitalProcess(businessDao.getCapitalId());
        	ThreadConnection.commit();
        }
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        return bc.toJSON();
    }
    
    public String deleteNormalReimbursement(Map<String, Object> param) throws Exception{
        int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
        int businessId = BaseHelpUtils.getIntValue(param.get("businessId"));
        if(processInstanceId > 0 && businessId > 0){
        	ThreadConnection.beginTransaction();
        	deleteSystemProcess(processInstanceId);
        	ProjectNormalReimbursement businessDao = new ProjectNormalReimbursement();
        	businessDao.setConditionProjectNormalReimbursementId("=", businessId);
        	businessDao.setDeleteFlag(StaticUtils.HAS_DELETE);
        	businessDao.conditionalUpdate();
        	ThreadConnection.commit();
        }
        BaseCollection bc = new BaseCollection<>();
        return bc.toJSON();
    }
    
    public String deleteTravelReimbursement(Map<String, Object> param) throws Exception{
    	int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
        int businessId = BaseHelpUtils.getIntValue(param.get("businessId"));
        if(processInstanceId > 0 && businessId > 0){
        	ThreadConnection.beginTransaction();
        	deleteSystemProcess(processInstanceId);
        	TravelReimbursement businessDao = new TravelReimbursement();
        	businessDao.setConditionTravelReimbursementId("=", businessId);
        	businessDao.setDeleteFlag(StaticUtils.HAS_DELETE);
        	businessDao.conditionalUpdate();
        	ThreadConnection.commit();
        }
        BaseCollection bc = new BaseCollection<>();
        return bc.toJSON();
    }
    
    public String deleteEmployeeBorrowMoney(Map<String, Object> param) throws Exception{
        int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
        int businessId = BaseHelpUtils.getIntValue(param.get("businessId"));
        if(processInstanceId > 0 && businessId > 0){
        	ThreadConnection.beginTransaction();
        	deleteSystemProcess(processInstanceId);
        	EmployeeMoneyManage businessDao = new EmployeeMoneyManage();
        	businessDao.setConditionEmployeeMoneyManageId("=", businessId);
        	businessDao.setDeleteFlag(StaticUtils.HAS_DELETE);
        	businessDao.conditionalUpdate();
        	ThreadConnection.commit();
        }
        BaseCollection bc = new BaseCollection<>();
        return bc.toJSON();
    }
    
    public String deletePayMoney(Map<String, Object> param) throws Exception{
        int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
        int businessId = BaseHelpUtils.getIntValue(param.get("businessId"));
        if(processInstanceId > 0 && businessId > 0){
        	ThreadConnection.beginTransaction();
        	deleteSystemProcess(processInstanceId);
        	PayMoneyManage businessDao = new PayMoneyManage();
        	businessDao.setConditionPayMoneyManageId("=", businessId);
        	businessDao.setDeleteFlag(StaticUtils.HAS_DELETE);
        	businessDao.conditionalUpdate();
        	ThreadConnection.commit();
        }
        BaseCollection bc = new BaseCollection<>();
        return bc.toJSON();
    }

	public String deletePersonnelBusiness(Map<String, Object> param) throws Exception {
		int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
		int businessId = BaseHelpUtils.getIntValue(param.get("businessId"));
		if (processInstanceId > 0 && businessId > 0) {
			ThreadConnection.beginTransaction();
			//删除的是请假流程的年假数据的时候需要将年假数据返还到员工相当于驳回流程
			PersonnelBusines dao = new PersonnelBusines();
			dao.setConditionPersonnelBusinessId("=", businessId);
			BasePersonnelBusines bean = dao.executeQueryOneRow();
			int type = BaseHelpUtils.getIntValue(bean.getType());
			int processType = BaseHelpUtils.getIntValue(bean.getProcessType());
			if (processType == 13 && type == StaticUtils.LEAVE_TYPE_22) {
				int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
				//获取请假的开始时间和结束时间
				Date startDate = bean.getStartDate();
				Date endDate = bean.getEndDate();
				//获取请假的天数
				BigDecimal days = BaseHelpUtils.getBigDecimalValue(bean.getDays());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(startDate);
				//获取请假开始时间的年份和月份
				int startDateYear = calendar.get(Calendar.YEAR);
				AnnualLeave annualLeave = new AnnualLeave();
				//初始化当年的年假的数据
				BigDecimal currentTotalDay = BigDecimal.ZERO;
				BigDecimal currentUserDay = BigDecimal.ZERO;
				//初始化上一年年假的数据
				BigDecimal lastTotalDay = BigDecimal.ZERO;
				BigDecimal lastUserDay = BigDecimal.ZERO;
				annualLeave.clear();
				annualLeave.setConditionYear("=", startDateYear);
				annualLeave.setConditionEmployeeId("=", employeeId);
				if (annualLeave.isExist()) {
					BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
					currentTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
					currentUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());

				}
				//上一年度的年假信息
				annualLeave.clear();
				annualLeave.setConditionYear("=", startDateYear - 1);
				annualLeave.setConditionEmployeeId("=", employeeId);
				if (annualLeave.isExist()) {
					BaseAnnualLeave baseAnnualLeave = annualLeave.executeQueryOneRow();
					lastTotalDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getTotalAnnualLeave());
					lastUserDay = BaseHelpUtils.getBigDecimalValue(baseAnnualLeave.getUsageAmountAnnual());
				}
				//回退的规则都是优先退回请假当年的数据让后再回退上一年的数据
				//当年使用的年假够本次退回的---- 直接退回到当年
				if (currentUserDay.compareTo(days) == 1) {
					currentUserDay = currentUserDay.subtract(days);
				}
				//当年的已用请假时间不够本次退回---- 则先退回当年的数据然后再退回上一年的数据
				else {
					BigDecimal subtract = days.subtract(currentUserDay);
					lastUserDay = lastUserDay.subtract(subtract);
					currentUserDay = BigDecimal.ZERO;
				}
				annualLeave.clear();
				//更新当年的年假
				annualLeave.setConditionEmployeeId("=", employeeId);
				annualLeave.setConditionYear("=", startDateYear);
				annualLeave.setUsageAmountAnnual(currentUserDay);
				annualLeave.conditionalUpdate();
				//更新上一年的年假
				annualLeave.clear();
				annualLeave.setConditionEmployeeId("=", employeeId);
				annualLeave.setConditionYear("=", startDateYear - 1);
				annualLeave.setUsageAmountAnnual(lastUserDay);
				annualLeave.conditionalUpdate();
			}


			if (processType == 13 && type == StaticUtils.LEAVE_TYPE_21) {
				int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
				CompensatoryLeave cl = new CompensatoryLeave();
				cl.setConditionEmployeeId("=",employeeId);
				cl.setConditionBusinessId("=",businessId);
				cl.conditionalDelete();
			}
			//对物品归还流程删除的处理
			else if (processType == 83) {
				ReturnOfItemsWorker returnOfItemsWorker = new ReturnOfItemsWorker();
				returnOfItemsWorker.deleteLinkReturn(businessId);
				returnOfItemsWorker.deleteEquipmentCord(businessId);

			}
			//对物品申请流程删除的处理
			else if(processType == 31){
				GoodsApplyWorker goodsApplyWorker = new GoodsApplyWorker();
				goodsApplyWorker.deleteEquipmentCord(businessId);
			}
			//采购申请 删除物品使用记录
			else if(processType == 36){
				PurchaseApplyWorker purchaseApplyWorker = new PurchaseApplyWorker();
				purchaseApplyWorker.delEquipmentCord(businessId);
			}
			deleteSystemProcess(processInstanceId);
			PersonnelBusines businessDao = new PersonnelBusines();
			businessDao.setConditionPersonnelBusinessId("=", businessId);
			businessDao.setDeleteFlag(StaticUtils.HAS_DELETE);
			businessDao.conditionalUpdate();
			//同步考勤
			OnShiftManageProcess.syncAttendance(bean);
			ThreadConnection.commit();
		}
		BaseCollection bc = new BaseCollection<>();

		return bc.toJSON();
	}
    
    public String deletePersonnelBusinessAndSpecialDeduction(Map<String, Object> param) throws Exception{
    	int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
    	int businessId = BaseHelpUtils.getIntValue(param.get("businessId"));
    	int specialDeductionRecordId = BaseHelpUtils.getIntValue(param.get("specialDeductionRecordId"));
    	if(processInstanceId > 0 && businessId > 0 && specialDeductionRecordId>0){
    		
    		//删除流程表
    		ThreadConnection.beginTransaction();
    		deleteSystemProcess(processInstanceId);
    		PersonnelBusines businessDao = new PersonnelBusines();
    		businessDao.setConditionPersonnelBusinessId("=", businessId);
    		businessDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    		businessDao.conditionalUpdate();
    		
    		//删除专项扣除记录表及关联表
    		SpecialDeductionRecord dao =new SpecialDeductionRecord();
    		dao.setConditionSpecialDeductionRecordId("=",specialDeductionRecordId);
    		dao.conditionalDelete();
    		
    		SpecialDeductionDetail sddDao =new SpecialDeductionDetail();
    		sddDao.setConditionParentId("=", specialDeductionRecordId);
    		sddDao.conditionalDelete();
    		ThreadConnection.commit();
    	}
    	BaseCollection bc = new BaseCollection<>();
    	return bc.toJSON();
    }

    public void deleteSystemProcess(int processInstanceId) throws Exception{
    	//流程实例逻辑删除
    	SystemProcessInstance instanceDao = new SystemProcessInstance();
    	instanceDao.setConditionProcessInstanceId("=", processInstanceId);
    	instanceDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	instanceDao.conditionalUpdate();
    	//流程节点逻辑删除
    	SystemProcessInstanceActivity activityDao = new SystemProcessInstanceActivity();
    	activityDao.setConditionProcessInstanceId("=", processInstanceId);
    	activityDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	activityDao.conditionalUpdate();
    	//流程任务池逻辑删除
    	SystemProcessPooledTask poolTaskDao = new SystemProcessPooledTask();
    	poolTaskDao.setConditionProcessInstanceId("=", processInstanceId);
    	poolTaskDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	poolTaskDao.conditionalUpdate();
    	//流程知会信息逻辑删除
    	SystemProcessAttention attentionDao = new SystemProcessAttention();
    	attentionDao.setConditionProcessInstanceId("=", processInstanceId);
    	attentionDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	attentionDao.conditionalUpdate();
    }
    
}
