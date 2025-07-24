package delicacy.oa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCarCostAllocation;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.CarCostAllocation;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.ProjectCost;

import delicacy.connection.ThreadConnection;
import delicacy.servlet.CommonTimer;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.Department;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;

public class CarApplyWrokflowTask extends TimerTask {

	private static final Logger __logger = Logger.getLogger(CarApplyWrokflowTask.class);

	@Override
	public void run() {
		try {
			Date date = new Date();
			PersonnelBusines pbDao = new PersonnelBusines();
			pbDao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_33);
			//是否发送过消息给司机和申请人
			pbDao.setConditionIsRemoteCity("=", true);
			//流程还没走完
			pbDao.setConditionIsCompleted("=", false);
			pbDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
			List<BasePersonnelBusines> pbList = pbDao.conditionalLoad();
			if(null != pbList && !pbList.isEmpty()){
				try {
					ThreadConnection.beginTransaction();
					for(BasePersonnelBusines bean : pbList){
						//超过2天的,自动通过审批
						if (date.getTime() - bean.getCertificationTime().getTime() >= CommonTimer.PERIOD_DAY * 7) {
							Integer businessId = bean.getPersonnelBusinessId();
							String remark = bean.getReason();
							//修改流程数据
							SystemProcessInstance spiDao = new SystemProcessInstance();
							spiDao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_33);
							spiDao.setConditionBusinessId("=", businessId);
							spiDao.setCompleteTime(date);
							spiDao.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_COMPLETED);
							spiDao.conditionalUpdate();
							BaseSystemProcessInstance spiBean = spiDao.executeQueryOneRow();
							Integer processId = spiBean.getProcessId();
							Integer processInstanceId = spiBean.getProcessInstanceId();
							SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
							spiaDao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_33);
							spiaDao.setConditionBusinessId("=", businessId);
							spiaDao.setConditionStatus("=", SystemProcessConstants.ACTIVITY_STATUS_ACTIVE);
							spiaDao.setStatus(SystemProcessConstants.ACTIVITY_STATUS_PASS);
							spiaDao.setOperateTime(date);
							spiaDao.conditionalUpdate();
							//插入成本
							CarCostAllocation ccaDao = new CarCostAllocation();
							ccaDao.setConditionPersonnelBusinessId("=", businessId);
							List<BaseCarCostAllocation> ccaList = ccaDao.conditionalLoad();
							if(null != ccaList && !ccaList.isEmpty()){
								if(bean.getStartDateDetail().intValue() == StaticUtils.DEPARTMENT_USE_CAR){
									//部门成本
									Calendar c = Calendar.getInstance();
									c.setTime(date);
									PlateCostRecord pcrDao = new PlateCostRecord();
									pcrDao.setConditionProcessInstanceId("=", processInstanceId);
									pcrDao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_33);
									if(pcrDao.countRows() <= 0){
										for(BaseCarCostAllocation obj : ccaList){
											//保存部门成本
											PlateCostRecord plateCostRecord=new PlateCostRecord();
											Department department=new Department();
											department.setDepartmentId(obj.getId());
											if(department.load()){
												plateCostRecord.setPlateId(department.getPlateId());
											}
											plateCostRecord.setCostIntegral(obj.getCostAllocation());
											plateCostRecord.setSalaryIntegral(new BigDecimal("0"));
											plateCostRecord.setIsSettlement(false);
											//获取当前的年月
											plateCostRecord.setYear(c.get(Calendar.YEAR));
											plateCostRecord.setMonth(c.get(Calendar.MONTH)+1);
											plateCostRecord.setCostDate(date);
											plateCostRecord.setProcessType(StaticUtils.PROCESS_TYPE_33);
											plateCostRecord.setBusinessId(businessId);
											plateCostRecord.setProcessId(processId);
											plateCostRecord.setProcessInstanceId(processInstanceId);
											plateCostRecord.setRemark(remark);
											plateCostRecord.save();
											//同时更新数据到部门积分汇总表中
											PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
											plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
											plateAccountRecordDao.setBusinessId(plateCostRecord.getPlateCostRecordId());
											plateAccountRecordDao.setPlateId(plateCostRecord.getPlateId());
											plateAccountRecordDao.setIntegral(plateCostRecord.getCostIntegral());
											plateAccountRecordDao.setRecordDate(plateCostRecord.getCostDate());
											plateAccountRecordDao.setOperateEmployeeId(bean.getEmployeeId());
											plateAccountRecordDao.setOperateTime(date);
											plateAccountRecordDao.setRemark(remark);
											plateAccountRecordDao.save();
										}
									}
								}else if(bean.getStartDateDetail().intValue() == StaticUtils.PROJECT_USE_CAR){
									//项目成本挂钩到项目上去
									ProjectCost costDao = new ProjectCost();
									costDao.setConditionProcessInstanceId("=", processInstanceId);
									costDao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_33);
									if(costDao.countRows() <= 0){
										List<BaseProjectCost> costList = new ArrayList<>();
										for(BaseCarCostAllocation obj : ccaList){
											BaseProjectCost cost = new BaseProjectCost();
											cost.setAmount(obj.getCostAllocation());
											cost.setProjectId(obj.getId());
											cost.setCostDate(date);
											cost.setEmployeeId(bean.getEmployeeId());
											cost.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
											cost.setProcessType(StaticUtils.PROCESS_TYPE_33);
											cost.setBusinessId(businessId);
											cost.setProcessId(processId);
											cost.setProcessInstanceId(processInstanceId);
											costList.add(cost);
										}
										costDao.clear();
										costDao.save(costList);
									}
								}
							}
						}
					}
					pbDao.setIsCompleted(true);
					pbDao.conditionalUpdate();
					ThreadConnection.commit();
				}catch(Exception e) {
					e.printStackTrace();
					ThreadConnection.rollback();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
