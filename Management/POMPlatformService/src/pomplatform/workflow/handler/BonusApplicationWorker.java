package pomplatform.workflow.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBonusPaymentDetail;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseSalaryOfBonus;
import com.pomplatform.db.bean.BaseSpecialDeductionDetail;
import com.pomplatform.db.dao.BonusPaymentDetail;
import com.pomplatform.db.dao.BonusPaymentRecord;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.SalaryOfBonus;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.bonusPayment.bean.BaseLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.bean.ConditionLoadEmployeeForSendBonusTwo;
import pomplatform.bonusPayment.query.QueryLoadEmployeeForSendBonusTwo;
import pomplatform.common.utils.StaticUtils;
import pomplatform.salary.bean.BaseSalaryOfFactBonus;
import pomplatform.salary.bean.ConditionSalaryOfFactBonus;
import pomplatform.salary.query.QuerySalaryOfFactBonus;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordsor;
import pomplatform.specialDeduction.query.QueryMspecialdeductionrecordsor;
import pomplatform.workflow.bean.BaseBonusPaymentRecordWithB;
import pomplatform.workflow.dao.BonusPaymentRecordWithB;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class BonusApplicationWorker implements GenericWorkflowProcessor {

	protected BaseBonusPaymentRecordWithB bean = new BaseBonusPaymentRecordWithB();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getBonusPaymentRecordId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
				return null;
			}
		}
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		
		if(completed){
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {// 被驳回
				bean.setState( StaticUtils.BONUS_PAYMENT_DISAGREE);//审核不通过
				bean.setOpinion("审核不通过");
				
				// 不通过本次奖金发放申请详情（每个员工）的审核
				List<BaseBonusPaymentDetail> detailBonusPaymentDetail = bean.getDetailBonusPaymentDetail();
				if(null!=detailBonusPaymentDetail &&detailBonusPaymentDetail.size()>0) {
					for (BaseBonusPaymentDetail baseBonusPaymentDetail : detailBonusPaymentDetail) {
						baseBonusPaymentDetail.setState( StaticUtils.BONUS_PAYMENT_DISAGREE);
					}
				}else {
					throw new SQLException(String.format("操作异常：奖金发放申请详情为空！"));
				}
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				// 通过本次奖金发放申请总记录的审核
				bean.setState( StaticUtils.BONUS_PAYMENT_AGREE);//审核通过
				bean.setOpinion("审核通过");
				
				// 通过本次奖金发放申请详情（每个员工）的审核
				List<BaseBonusPaymentDetail> detailBonusPaymentDetail = bean.getDetailBonusPaymentDetail();
				if(null!=detailBonusPaymentDetail &&detailBonusPaymentDetail.size()>0) {
					for (BaseBonusPaymentDetail baseBonusPaymentDetail : detailBonusPaymentDetail) {
						baseBonusPaymentDetail.setState( StaticUtils.BONUS_PAYMENT_AGREE);
					}
				}else {
					throw new SQLException(String.format("操作异常：奖金发放申请详情为空！"));
				}
				bonusToSend(detailBonusPaymentDetail);
			}
		}
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getBonusPaymentRecordId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		
		int	plateId = bean.getPlateId();
		if(roleId != null && roleId != 0&&roleId==StaticUtils.ROLE_PLATE_MANAGE_MANAGER) {//部门行政负责人
			System.out.println("a");
            Department d = new Department();
            d.setConditionPlateId("=", plateId);
            d.setConditionDeleteFlag("=", 0);
            List<BaseDepartment> deapartmentList = d.conditionalLoad();
            
            if(deapartmentList.size()>0) {
            	System.out.println("aa");
            	Object[] arr = new Object[deapartmentList.size()];
                int idx = 0;
                for (BaseDepartment dept : deapartmentList) {
                    arr[idx++] =dept.getDepartmentId();
                    System.out.println("aa.arr==="+BaseHelpUtils.getIntValue(dept.getDepartmentId()));
                }
            	EmployeeRole er = new EmployeeRole();
            	er.addCondition(BaseDepartment.CS_DEPARTMENT_ID, "in", arr);
                er.setConditionRoleId("=", roleId);
                List<BaseEmployeeRole> bers = er.conditionalLoad();
                if (bers.size() > 0) {
                	System.out.println("aaa");
                	for (BaseEmployeeRole baseEmployeeRole : bers) {
                		int size = bers.size();
                		int[] res = new int[size];
                		for (int i = 0; i < size; i++) {
                			res[i] = bers.get(i).getEmployeeId();
                			System.out.println("aaa.arr==="+BaseHelpUtils.getIntValue(bers.get(i).getEmployeeId()));
                		}
                		return res;
					}
                }
            }else {
            	String roleName = delicacy.system.executor.SelectValueCache.getSelectValue("roles", String.valueOf(roleId));
            	String plateName = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(plateId));
				throw new SQLException("查询异常:查询不到"+plateName+"部门下的"+roleName+"的角色人员");
            }
        
			
		}else if(roleId != null && roleId != 0&&roleId==StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER) {//部门分管领导
			System.out.println("b");
			 Department d = new Department();
	            d.setConditionPlateId("=", plateId);
	            d.setConditionDeleteFlag("=", 0);
	            List<BaseDepartment> deapartmentList = d.conditionalLoad();
	            
	            if(deapartmentList.size()>0) {
	            	System.out.println("bb");
	            	Object[] arr = new Object[deapartmentList.size()];
	                int idx = 0;
	                for (BaseDepartment dept : deapartmentList) {
	                    arr[idx++] =dept.getDepartmentId();
	                    System.out.println("bb.arr==="+BaseHelpUtils.getIntValue(dept.getDepartmentId()));
	                }
	            	
	            	EmployeeRole er = new EmployeeRole();
	            	er.addCondition(BaseDepartment.CS_DEPARTMENT_ID, "in", arr);
	                er.setConditionRoleId("=", roleId);
	                List<BaseEmployeeRole> bers = er.conditionalLoad();
	                if (bers.size() > 0) {
	                	System.out.println("bbb");
	                	for (BaseEmployeeRole baseEmployeeRole : bers) {
	                		int size = bers.size();
	                		int[] res = new int[size];
	                		for (int i = 0; i < size; i++) {
	                			res[i] = bers.get(i).getEmployeeId();
	                			System.out.println("bbb.arr==="+BaseHelpUtils.getIntValue(bers.get(i).getEmployeeId()));
	                		}
	                		return res;
						}
	                }
	            }else {
	            	String roleName = delicacy.system.executor.SelectValueCache.getSelectValue("roles", String.valueOf(roleId));
	            	String plateName = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(plateId));
					throw new SQLException("查询异常:查询不到"+plateName+"部门下的"+roleName+"的角色人员");
	            }
        
		}
		System.out.println("c");
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		dao.setBonusPaymentRecordId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}
	
	
	private void bonusToSend(List<BaseBonusPaymentDetail> detailBonusPaymentDetail) throws SQLException {
			ThreadConnection.beginTransaction();
			BonusPaymentRecord recordDao = new BonusPaymentRecord();
			BonusPaymentDetail detailDao = new BonusPaymentDetail();
			 
			int	plateId = bean.getPlateId();
			Date payDate = bean.getAuditingTime();//发放日期
			String remark = bean.getRemark() + "(营销提成奖金发放)";
			

			// 通过审核后，将当月份各位发了奖金员工的employee_report_records表中的数据更新：
			// ①奖金发放的值增加
			// ②总的价值积分减少
			if (null != detailBonusPaymentDetail && !detailBonusPaymentDetail.isEmpty()) {
				Employee eDao = new Employee();
				SalaryOfBonus sDao = new SalaryOfBonus();
				for (com.pomplatform.db.bean.BaseBonusPaymentDetail obj : detailBonusPaymentDetail) {
					// 获取发放次数
					int sendNumber = BaseHelpUtils.getIntValue(obj.getSendNumber());
					// 获取人员id
					int employeeId = obj.getEmployeeId();

					eDao.clear();
					int plateIds = 0;
					int departmentId = 0;
					int companyId = 0;
					eDao.setEmployeeId(employeeId);
					String employeeName = "";
					if (eDao.load()) {
						plateIds = eDao.getPlateId();
						departmentId = eDao.getDepartmentId();
						companyId = eDao.getCompanyId();
						employeeName = BaseHelpUtils.getString(eDao.getEmployeeName());
					} else {
						throw new SQLException("找不到人员信息");
					}

					if (sendNumber > 0) {
						int businessId = obj.getBonusPaymentDetailId();
						// 归属获取日期
						Date recordDate = obj.getPayDate();
						// 验证发放总金额是否等于每一次发放的累加金额
						// 获取总发放金额
						BigDecimal payIntegral = BaseHelpUtils.getBigDecimalValue(obj.getPayIntegral());
						// 获取第一次发放金额
						BigDecimal firstIntegral = BaseHelpUtils.getBigDecimalValue(obj.getFirstIntegral());
						// 获取第二次发放金额
						BigDecimal secondIntegral = BaseHelpUtils.getBigDecimalValue(obj.getSecondIntegral());
						// 获取第三次发放金额
						BigDecimal thirdIntegral = BaseHelpUtils.getBigDecimalValue(obj.getThirdIntegral());
						BigDecimal totalIntegral = firstIntegral.add(secondIntegral).add(thirdIntegral);
						if (payIntegral.compareTo(totalIntegral) != 0) {// 说明不相等
							throw new SQLException(String.format("操作异常：发放总金额(%1$s)不等于每一次发放的累加金额(%2$s)", payIntegral,
									totalIntegral));
						}

						// 设置第二次发放日期，及在第一次发放日期延后一个月
						Date secondDate = DateUtil.getNextMonth(payDate);
						// 设置第三次发放日期，及在第二次发放日期延后一个月
						Date thirdDate = DateUtil.getNextMonth(secondDate);

						if (firstIntegral.compareTo(BigDecimal.ZERO) > 0) {
							BigDecimal shouldTax = getShouldTax(firstIntegral);
							BigDecimal factBonus = firstIntegral.subtract(shouldTax);

							sDao.clear();
							sDao.setShouldBonus(BaseHelpUtils.getString(firstIntegral));// 应该奖金
							sDao.setShouldTax(BaseHelpUtils.getString(shouldTax));// 个税
							sDao.setFactBonus(BaseHelpUtils.getString(factBonus));// 实发奖金
							sDao.setRecordDate(payDate);
							sDao.setEmployeeId(employeeId);
							sDao.setYear(DateUtil.getYear(payDate));
							sDao.setMonth(DateUtil.getMonth(payDate));
							sDao.setPlateId(plateIds);
							sDao.setDepartmentId(departmentId);
							sDao.setCompanyId(companyId);
							sDao.setFlag(2);
							sDao.save();
						}

						if (secondIntegral.compareTo(BigDecimal.ZERO) > 0) {
							BigDecimal shouldTaxTwo = getShouldTax(secondIntegral);
							BigDecimal factBonusTwo = firstIntegral.subtract(shouldTaxTwo);

							sDao.clear();
							sDao.setShouldBonus(BaseHelpUtils.getString(secondIntegral));// 应该奖金
							sDao.setShouldTax(BaseHelpUtils.getString(shouldTaxTwo));// 个税
							sDao.setFactBonus(BaseHelpUtils.getString(factBonusTwo));// 实发奖金
							sDao.setRecordDate(secondDate);
							sDao.setEmployeeId(employeeId);
							sDao.setYear(DateUtil.getYear(secondDate));
							sDao.setMonth(DateUtil.getMonth(secondDate));
							sDao.setPlateId(plateIds);
							sDao.setDepartmentId(departmentId);
							sDao.setCompanyId(companyId);
							sDao.setFlag(2);
							sDao.save();
						}

						if (thirdIntegral.compareTo(BigDecimal.ZERO) > 0) {
							BigDecimal shouldTaxThree = getShouldTax(thirdIntegral);
							BigDecimal factBonusThree = firstIntegral.subtract(shouldTaxThree);
 
							sDao.clear();
							sDao.setShouldBonus(BaseHelpUtils.getString(thirdIntegral));// 应该奖金
							sDao.setShouldTax(BaseHelpUtils.getString(shouldTaxThree));// 个税
							sDao.setFactBonus(BaseHelpUtils.getString(factBonusThree));// 实发奖金
							sDao.setRecordDate(thirdDate);
							sDao.setEmployeeId(employeeId);
							sDao.setYear(DateUtil.getYear(thirdDate));
							sDao.setMonth(DateUtil.getMonth(thirdDate));
							sDao.setPlateId(plateIds);
							sDao.setDepartmentId(departmentId);
							sDao.setCompanyId(companyId);
							sDao.setFlag(2);
							sDao.save();

						}
						// 奖金发放入个人账户表
						AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId,
								AccountManageProcess.EMP_BT_BONUS_SEND, payIntegral, recordDate, "", -1);
					} else {
						throw new SQLException(String.format("操作异常：获取职员(%1$s)发放次数失败！", employeeName));
					}
				}
			}
			ThreadConnection.commit();
	}
	
	
	/*
	 * <=12000  税率0
	 * <=25000  税率0.2   速扣金额1410
	 * <=35000  税率0.25   速扣金额2660
	 * <=55000  税率0.3   速扣金额4410
	 * <=80000  税率0.35   速扣金额7160
	 * >80000  税率0.45   速扣金额15160
	 * */
	private   BigDecimal  getShouldTax(BigDecimal shouldTaxAchieve) {
		BigDecimal taxTotal = BigDecimal.ZERO;
		if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(12000)) <= 0){
			
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(25000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.2)).subtract(BigDecimal.valueOf(1410))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(35000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.25)).subtract(BigDecimal.valueOf(2660))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(55000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.3)).subtract(BigDecimal.valueOf(4410))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(80000)) <= 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.35)).subtract(BigDecimal.valueOf(7160))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}else if(shouldTaxAchieve.compareTo(BigDecimal.valueOf(80000)) > 0){
			taxTotal = (shouldTaxAchieve.multiply(BigDecimal.valueOf(0.45)).subtract(BigDecimal.valueOf(15160))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
		}
		return  taxTotal;
	}
	
	
	public static void main(String[] args) throws SQLException {/*
		
		SalaryOfBonus sDao =new SalaryOfBonus();
		QuerySalaryOfFactBonus query =new QuerySalaryOfFactBonus();
		ConditionSalaryOfFactBonus condition =new ConditionSalaryOfFactBonus();
		condition.setYear(2019);
		condition.setMonth(4);
		BaseCollection<BaseSalaryOfFactBonus> collection = query.executeQuery(condition.getKeyValues(), condition);
		if(collection!=null&& collection.getCollections().size()>0) {
			List<BaseSalaryOfFactBonus> list = collection.getCollections();
			for (BaseSalaryOfFactBonus baseSalaryOfBonus : list) {
				BigDecimal shouldBonus = baseSalaryOfBonus.getShouldBonus();
				BigDecimal shouldTax = getShouldTax(shouldBonus);
				BigDecimal factBonus = shouldBonus.subtract(shouldTax);
				
				sDao.clear();
				BaseSalaryOfBonus base =new BaseSalaryOfBonus();
				base.setSalaryOfBonusId(baseSalaryOfBonus.getSalaryOfBonusId());
				base.setShouldBonus(BaseHelpUtils.getString(shouldBonus));// 应该奖金
				base.setShouldTax(BaseHelpUtils.getString(shouldTax));// 个税
				base.setFactBonus(BaseHelpUtils.getString(factBonus));// 实发奖金
				sDao.setDataFromBase(base);
				sDao.update();
				
			}
		}
			
	*/}
		
		
		
		

	
	
	
	
	

}
