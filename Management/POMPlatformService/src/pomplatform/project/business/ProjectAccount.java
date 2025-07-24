package pomplatform.project.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.bean.BaseProjectSettlementPerformance;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectSettlementPerformance;
import com.pomplatform.db.dao.ProjectStage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import delicacy.system.dao.Employee;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.operation.bean.BaseMprojectppor;
import pomplatform.operation.bean.ConditionMprojectppor;
import pomplatform.operation.query.QueryMprojectppor;

/**
 * 项目经费结算
 * @author lxf
 */
public class ProjectAccount implements GenericProcessor {

	private static Logger __logger = Logger.getLogger("");

	public static void main(String[] args) {
		try {
			ProjectAccount pa = new ProjectAccount();
//			pa.onAutoProjectManageIntegral(137,0);
//			pa.onSettlementProjectManageIntegral(3409, 0, "dddd");
//			pa.execute("{\"projectId\":\"137\",\"budget\":10000}", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		HttpCookie hc = new HttpCookie(request);
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> result = (Map<String, Object>) parser.parse(new BasicHandler());
		int projectId = BaseHelpUtils.getIntValue(result, "projectId");
		int stageId = BaseHelpUtils.getIntValue(result, "stageId");
		int settlementStatus = BaseHelpUtils.getIntValue(result, "settlementStatus");
		String settlementRemark = BaseHelpUtils.getString(result.get("settlementRemark"));
		String costIds = BaseHelpUtils.getString(result.get("costIds"));
		Date settlementDate = new Date();
		List<BaseProjectEmployee> projectEmployeesList = GenericBase.__getList(result.get("projectEmployees"),
				BaseProjectEmployee.newInstance());
		int operateEmployeeId = hc.getOperatorId();
		ProjectEmployee updateDao;
		Project p = new Project();
		p.setProjectIdClear(projectId);
		boolean isHave = p.load();
		if (!isHave) {
			throw new SQLException("没有这个项目");
		}
		ConditionMprojectppor cm = new ConditionMprojectppor();
		cm.setProjectId(projectId);
		QueryMprojectppor qm = new QueryMprojectppor();
		BaseCollection<BaseMprojectppor> bcqm = qm.executeQuery(null, cm);
		BigDecimal projectTotal = BigDecimal.ZERO;
		BigDecimal settledTotal = BigDecimal.ZERO;
		BigDecimal projectTotalCost = BigDecimal.ZERO;
		if (!BaseHelpUtils.isNullOrEmpty(bcqm.getCollections())) {
			BaseMprojectppor bm = bcqm.getCollections().get(0);
			projectTotal = BaseHelpUtils.getBigDecimalValue(bm.getProjectIntegral());// 项目总积分
			settledTotal = BaseHelpUtils.getBigDecimalValue(bm.getTotalAmount());// 项目已结算总积分
			projectTotalCost = BaseHelpUtils.getBigDecimalValue(bm.getTotalCost());// 已结算的总项目经费
		}

		// 项目已申报的经费
		BigDecimal totalCost = BigDecimal.ZERO;
		List<BaseProjectCost> costList = null;
		ProjectCost pc = new ProjectCost();
		if(!BaseHelpUtils.isNullOrEmpty(costIds)) {
			String[] costIdStrArr = costIds.split(",");
			int length = costIdStrArr.length;
			Integer[] costIdArr = new Integer[length];
			for(int i = 0; i < length; i++) {
				costIdArr[i] = BaseHelpUtils.getIntValue(costIdStrArr[i]);
			}
			pc.setConditionProjectId("=", projectId);
			pc.addCondition(BaseProjectCost.CS_PROJECT_COST_ID, "in", (Object[])costIdArr);
			pc.setConditionStatus("=", StaticUtils.SETTLEMENT_STATUS_NO);
			costList = pc.conditionalLoad(BaseProjectCost.CS_SETTLEMENT_STATUS + " is null");
			if(null == costList || costList.isEmpty() || costList.size() != length) {
				throw new Exception("成本数据不对，请关掉页面后再重新进行经费结算");
			}else {
				for(BaseProjectCost costBean : costList) {
					totalCost = totalCost.add(costBean.getAmount());
				}
			}
		}
		if (BaseHelpUtils.isNullOrEmpty(projectEmployeesList)) {
			throw new SQLException("没有可结算的成员");
		}else{
			//求出本次所有员工分摊的成本之和，然后与该项目的未结算成本之和比较，两者不想等，则不保存此次结算数据！
			BigDecimal employeeCost = BigDecimal.ZERO;
			for(BaseProjectEmployee obj : projectEmployeesList){
				employeeCost = employeeCost.add(obj.getCost()==null?BigDecimal.ZERO:obj.getCost());
			}
			if(employeeCost.compareTo(totalCost) != 0){
				throw new Exception("成本分摊有误，请重新分摊成本");
			}
		}
		// 获取当次结算时输入的总的实际积分
		BigDecimal totalAmountToSettle = BigDecimal.ZERO;
		boolean isHaveSureIntegral = false;
		for(BaseProjectEmployee e : projectEmployeesList){
			BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(e.getRealIntegral());
			totalAmountToSettle = totalAmountToSettle.add(sureIntegral);
			if(sureIntegral.compareTo(BigDecimal.ZERO) != 0){
				isHaveSureIntegral = true;
			}
		}
		if (!isHaveSureIntegral && totalCost.compareTo(BigDecimal.ZERO) == 0) {
			throw new SQLException("没有可结算的积分和成本");
		}

		// 获取当前项目的预留积分
		BigDecimal reserveIntegral = p.getReserveIntegral()==null?BigDecimal.ZERO:p.getReserveIntegral();
		//获取项目积分
		BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(p.getProjectIntegral());
		// 获取当前项目归属部门id
		int plateId = BaseHelpUtils.getIntValue(p.getPlateId());
		__logger.debug(String.format(
				"项目总积分: %1$.2f, 已累计结算（包括已结算的项目成本）: %2$.2f, 本次结算（包括本次需要结算的项目成本）: %3$.2f, 累计费用: %4$.2f, 本次费用: %5$.2f",
				projectTotal, settledTotal, totalAmountToSettle, projectTotalCost, totalCost));
		if (isHaveSureIntegral && projectTotal.compareTo(settledTotal.add(totalAmountToSettle)) < 0) {
			throw new SQLException("分配的积分超过了项目积分，请重新分配");
		}
		ProjectSettlement ps = new ProjectSettlement();
		ps.setProjectId(projectId);
		ps.setFlag(2);//新的结算状态，1：历史数据结算；2：新方式数据结算
		ps.setEmployeeId(operateEmployeeId);// 当前结算的操作人
		ps.setRemark(settlementRemark);
		ps.setSettlementDate(settlementDate);
		ps.setSettlementStatus(settlementStatus);
		// 当次结算的结果，即结算积分(当次结算时输入的总的实际积分减去项目目前已申报的经费(不包含已结算过的项目经费0：表示未结算;1:表示已计算))
		ps.setTotalAmount(totalAmountToSettle);
		ps.setTotalCost(totalCost);
		ps.setProjectAmount(p.getProjectIntegral());
		ps.setStageId(stageId);
		ps.setLeftAmount(p.getProjectIntegral()==null?BigDecimal.ZERO:p.getProjectIntegral().subtract(ps.getTotalAmount()).subtract(settledTotal));
		ps.save();
		int settlementId = ps.getSettlementId();
		// 只有当次结算的确认积分不为0和项目总积分不为0时，方可记录这一次结算的预留积分
		if (projectTotal.compareTo(BigDecimal.ZERO) != 0 && isHaveSureIntegral) {
			if(settlementStatus == 2){
				//检索该项目累计确认的积分
				ps.clear();
				ps.setConditionProjectId("=",projectId);
				ps.setConditionSettlementStatus("=",2);
				List<BaseProjectSettlement> psList = ps.conditionalLoad();
				//定义该项目累计确认的积分
				BigDecimal totalSureIntegral = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
					for(BaseProjectSettlement e : psList){
						//获取每一次确认的确认积分
						BigDecimal totalAmount = BaseHelpUtils.getBigDecimalValue(e.getTotalAmount());
						totalSureIntegral = totalSureIntegral.add(totalAmount);
					}
				}
				if(totalSureIntegral.compareTo(BigDecimal.ZERO) != 0 && projectIntegral.compareTo(BigDecimal.ZERO) > 0){
					//检索该项目部门上已经确认的确认积分
					BigDecimal totalPlateSureIntegral = BigDecimal.ZERO;
					PlateProjectAccountRecord plateProjectAccountRecordDao = new PlateProjectAccountRecord();
					plateProjectAccountRecordDao.setConditionProjectId("=",projectId);
					List<BasePlateProjectAccountRecord> pparList = plateProjectAccountRecordDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(pparList) && pparList.size() > 0){
						for(BasePlateProjectAccountRecord e : pparList){
							BigDecimal plateSureIntegral = BaseHelpUtils.getBigDecimalValue(e.getAccountIntegral());
							totalPlateSureIntegral = totalPlateSureIntegral.add(plateSureIntegral);
						}
					}
					//计算部门累计可确认积分=项目累计确认积分/项目积分*预留积分
					BigDecimal totalCanSureIntegral = totalSureIntegral.multiply(reserveIntegral).divide(projectIntegral,2,BigDecimal.ROUND_DOWN);
					//设置当前可结算积分=累计可确认积分-部门已确认积分
					BigDecimal currentSureIntegral = totalCanSureIntegral.subtract(totalPlateSureIntegral);
					if(currentSureIntegral.compareTo(BigDecimal.ZERO) > 0){
						// 往部门项目的结算预留积分的记录表中插入一条记录
						plateProjectAccountRecordDao.clear();
						plateProjectAccountRecordDao.setPlateId(plateId);
						plateProjectAccountRecordDao.setProjectId(projectId);
						plateProjectAccountRecordDao.setAccountIntegral(currentSureIntegral);
						plateProjectAccountRecordDao.setAccountDate(settlementDate);
						plateProjectAccountRecordDao.setStageId(stageId);
						plateProjectAccountRecordDao.setRemark(settlementRemark);
						plateProjectAccountRecordDao.setSettlementId(settlementId);
						plateProjectAccountRecordDao.save();
						int businessId = plateProjectAccountRecordDao.getPlateProjectAccountRecordId();
						//往部门账户表中插入数据
						AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_SURE_INTEGRAL, currentSureIntegral, settlementDate, settlementRemark, -1);
					}
				}
			}
		}
		//获取项目的投诉保证金，只有投诉保证金为0的订单方可计算绩效积分的扣留
		BigDecimal complaintIntegral = p.getComplaintIntegral()==null?BigDecimal.ZERO:p.getComplaintIntegral();
		if(complaintIntegral.compareTo(BigDecimal.ZERO) == 0 && totalAmountToSettle.compareTo(BigDecimal.ZERO) > 0){
			//项目经费结算时计算扣留的绩效积分
			onSettlementProjectPerformance(projectId, settlementId, stageId,settlementDate, operateEmployeeId, settlementRemark);
		}

		updateDao = new ProjectEmployee();
		ProjectSettlementDetail psd = new ProjectSettlementDetail();
		__logger.debug(String.format("totalIntegral is %1$.2f", totalAmountToSettle));
		//获取该项目的项目经理
		int projectManageId = p.getProjectManageId();
		Employee eDao = new Employee();
		//获取项目经理名称
		eDao.setEmployeeId(projectManageId);
		eDao.load();
		String projectManageName = eDao.getEmployeeName()==null?"":eDao.getEmployeeName();
		//获取订单编号和订单名称
		String sheetCode = p.getContractCode()==null?"":p.getContractCode();
		String sheetName = p.getProjectName()==null?"":p.getProjectName();
		for (BaseProjectEmployee e : projectEmployeesList) {
			// 获取职员id
			int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			// 获取当次结算时确认给成员的积分
			BigDecimal realIntegral = e.getRealIntegral()==null?BigDecimal.ZERO:e.getRealIntegral();
			// 获取当次结算时分摊到成员的项目成本
			BigDecimal projectCost = e.getCost()==null?BigDecimal.ZERO:e.getCost();
			// 如果人员未分配积分和分摊成本，则不进行操作
			if (realIntegral.compareTo(BigDecimal.ZERO) != 0 || projectCost.compareTo(BigDecimal.ZERO) != 0) {
				updateDao.clear();
				updateDao.setPrimaryKeyFromBase(e);
				psd.clear();
				psd.setProjectId(projectId);
				psd.setSettlementId(settlementId);
				psd.setEmployeeId(employeeId);
				psd.setWorkContent(e.getWorkContent());
				psd.setPlanAmount(e.getPlanIntegral());
				psd.setRealAmount(e.getRealIntegral());
				psd.setProjectCost(projectCost);
				psd.setFinalAmount(realIntegral.subtract(projectCost));
				psd.setSettlementDate(settlementDate);
				if(settlementStatus == 1){//待确认
					//如果分配的确认积分为负数，前当前人员不是项目经理，则设置为待确认状态
					if(realIntegral.compareTo(BigDecimal.ZERO) < 0 && employeeId != projectManageId){
						psd.setSettlementStatus(settlementStatus);
						//发送微信通知給他
						ERPWeixinUtils.sendWXMsgToUser(employeeId, String.format(WeixinStatics.MSG_SETTLEMENT,sheetCode,sheetName,projectManageName));
					}else{
						psd.setSettlementStatus(2);
					}
				}else{
					psd.setSettlementStatus(settlementStatus);
				}
				psd.save();
				if(settlementStatus == 2){
					//获取主键ID，即业务ID
					int businessId = psd.getSettlementDetailId();
					//确认积分插入个人账户表
					if(realIntegral.compareTo(BigDecimal.ZERO) != 0){
						AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_SURE_INTEGRAL, realIntegral, settlementDate, settlementRemark, -1);
					}
					if(projectCost.compareTo(BigDecimal.ZERO)>0){
						//项目成本插入个人账户表
						AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_PROJECT_COST, projectCost, settlementDate, settlementRemark, -1);
					}else if(projectCost.compareTo(BigDecimal.ZERO)<0){
						throw new SQLException("项目成本不可为负数");
					}
					updateDao.load();
					// 获取成员已结算的积分，即上一次结算后的实际获取积分+这一次结算的积分
					updateDao.setSettlement(BaseHelpUtils.getBigDecimalValue(updateDao.getSettlement()).add(psd.getFinalAmount()));
					updateDao.setRealIntegral(BigDecimal.ZERO);
					updateDao.update();
				}
			}
		}
		if(settlementStatus == 2) {
			pc.setStatus(StaticUtils.SETTLEMENT_STATUS_YES);
			//根据该项目归属的合同完工百分比，去自动计算该合同下的项目管理费的积分确认值(即給到大项目经理的数据集)
			onAutoProjectManageIntegral(projectId, operateEmployeeId);
			//部门预留订单的自动结算
			int reserveSheetId = BaseHelpUtils.getIntValue(p.getReserveSheetId());
			onSettlementReserveSheetIntegral(reserveSheetId);
		}else {
			pc.setSettlementStatus(settlementStatus);
		}
		if(!BaseHelpUtils.isNullOrEmpty(costIds)) {
			pc.setSettlementId(settlementId);
			pc.conditionalUpdate();
		}
		// 获取订单已确认总积分
		BigDecimal assignedTotalIntegral = getProjectAssignedTotalIntegral(projectId);
		//计算订单完成百分比=已确认积分/项目积分
		BigDecimal projectFinishPercent = (projectIntegral.compareTo(BigDecimal.ZERO) > 0)?assignedTotalIntegral.multiply(BigDecimal.valueOf(100)).divide(projectIntegral, 2, BigDecimal.ROUND_DOWN) : BigDecimal.ZERO;
		// 更新该项目的完成百分比
		p.clear();
		p.setProjectId(projectId);
		p.load();
		p.setProjectFinishPercent(projectFinishPercent);
		p.update();
		ThreadConnection.commit();
		BaseCollection bc = new BaseCollection();
		return bc.toJSON(0, null);
	}
	
	/**
	 * 项目经费结算时计算扣留的绩效积分
	 * @param projectId:项目ID
	 * @param settlementId：结算总表主键ID
	 * @param stageId：阶段ID
	 * @param operateEmployeeId：操作人
	 * @param remark：备注
	 * @throws SQLException 
	 */
	public void onSettlementProjectPerformance(int projectId,int settlementId,int stageId,Date settlementDate,int operateEmployeeId,String remark) throws SQLException{
		//检索该订单历史确认总积分
		BigDecimal sureIntegralTotal = BigDecimal.ZERO;
		ProjectSettlement psDao = new ProjectSettlement();
		psDao.setConditionProjectId("=",projectId);
		psDao.setConditionSettlementStatus("=",2);//只检索正常流转的数据
		List<BaseProjectSettlement> psList = psDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
			for(BaseProjectSettlement e : psList){
				sureIntegralTotal = sureIntegralTotal.add(BaseHelpUtils.getBigDecimalValue(e.getTotalAmount()));
			}
		}
		//检索该订单历史扣留的绩效积分
		BigDecimal deductIntegral = BigDecimal.ZERO;
		ProjectSettlementPerformance pspDao = new ProjectSettlementPerformance();
		pspDao.setConditionProjectId("=",projectId);
		List<BaseProjectSettlementPerformance> pspList = pspDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(pspList) && pspList.size() > 0){
			for(BaseProjectSettlementPerformance e : pspList){
				deductIntegral = deductIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getIntegral()));
			}
		}
		//计算累计扣留的绩效积分=历史确认总积分*5%
		BigDecimal fivePercent = BigDecimal.valueOf(0.05);
		BigDecimal totalIntegral = sureIntegralTotal.multiply(fivePercent);
		//设置本次结算的扣留绩效积分=累计扣留的绩效积分-历史扣留的绩效积分
		BigDecimal integral = BaseHelpUtils.format(totalIntegral.subtract(deductIntegral), 2);
		//插入扣留绩效积分表
		pspDao.clear();
		BaseProjectSettlementPerformance bean = new BaseProjectSettlementPerformance();
		bean.setProjectId(projectId);
		bean.setSettlementId(settlementId);
		bean.setStageId(stageId);
		bean.setIntegral(integral);
		bean.setRecordDate(settlementDate);
		bean.setOperateEmployeeId(operateEmployeeId);
		bean.setOperateTime(new Date());
		pspDao.setDataFromBase(bean);
		pspDao.save();
	}
	
	/**
	 * 部门预留订单的自动结算
	 * @param reserveSheetId
	 * @throws SQLException
	 */
	public void onSettlementReserveSheetIntegral(int reserveSheetId) throws SQLException{
		if(reserveSheetId > 0){
			Project dao = new Project();
			//加载部门预留的订单
			dao.setConditionSubContractId("=",reserveSheetId);
			BaseProject bean = dao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(bean)){
				//获取当前预留订单的项目Id
				int projectId = BaseHelpUtils.getIntValue(bean.getProjectId());
				int plateId = BaseHelpUtils.getIntValue(bean.getPlateId());
				//获取项目编号和名称
				String sheetCode = bean.getContractCode();
				String sheetName = bean.getProjectName();
				//获取当前预留订单部门上预留的积分
				BigDecimal reserveIntegral = BaseHelpUtils.getBigDecimalValue(bean.getReserveIntegral());
				PlateProjectAccountRecord pparDao = new PlateProjectAccountRecord();
				ProjectSettlement psDao = new ProjectSettlement();
				if(reserveIntegral.compareTo(BigDecimal.ZERO) > 0){
					//获取当前部门预留订单已结算的积分
					BigDecimal settlementReserveIntegral = BigDecimal.ZERO;
					pparDao.setConditionProjectId("=",projectId);
					List<BasePlateProjectAccountRecord> pparList = pparDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(pparList) && pparList.size() > 0){
						for(BasePlateProjectAccountRecord pparBean : pparList){
							BigDecimal accountIntegral = BaseHelpUtils.getBigDecimalValue(pparBean.getAccountIntegral());
							settlementReserveIntegral = settlementReserveIntegral.add(accountIntegral);
						}
					}
					//加载当前预留订单下绑定的订单数据集
					dao.clear();
					dao.setConditionReserveSheetId("=",reserveSheetId);
					List<BaseProject> list = dao.conditionalLoad();
					//设置关联订单累计的合同金额和累计营收金额
					BigDecimal totalSheetAmount = BigDecimal.ZERO;
					BigDecimal totalSheetRevenue = BigDecimal.ZERO;
					if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
						for(BaseProject e : list){
							//获取当前订单Id
							int sheetId = BaseHelpUtils.getIntValue(e.getProjectId());
							//获取订单的合同金额
							BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(e.getSheetAmount());
							totalSheetAmount = totalSheetAmount.add(sheetAmount);
							//获取订单的项目积分
							BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(e.getProjectIntegral());
							//获取该订单已确认积分
							psDao.clear();
							psDao.setConditionProjectId("=",sheetId);
							psDao.setConditionSettlementStatus("=",2);
							List<BaseProjectSettlement> psList = psDao.conditionalLoad();
							//初始化已经确认的积分为0
							BigDecimal sureIntegral = BigDecimal.ZERO;
							if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
								for(BaseProjectSettlement be : psList){
									sureIntegral = sureIntegral.add(be.getTotalAmount()==null?BigDecimal.ZERO:be.getTotalAmount());
								}
							}
							//设置当前订单的营收=确认积分/项目积分*订单合同金额
							BigDecimal sheetRevenue = projectIntegral.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:sureIntegral.multiply(sheetAmount).divide(projectIntegral, 2,BigDecimal.ROUND_DOWN);
							totalSheetRevenue = totalSheetRevenue.add(sheetRevenue);
						}
					}
					//设置该预留订单的进度比=关联订单的累计营收/关联订单的累计合同金额
					BigDecimal percent = totalSheetAmount.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:totalSheetRevenue.divide(totalSheetAmount, 4,BigDecimal.ROUND_DOWN);
					//设置当前预留订单累计的可计算积分=进度比*该订单的预留积分
					BigDecimal totalCanSettlementIntegral = BaseHelpUtils.format(percent.multiply(reserveIntegral), 2);
					//设置这一次可结算的积分=累计可结算积分-已结算积分
					BigDecimal thisCanSettlementIntegral = totalCanSettlementIntegral.subtract(settlementReserveIntegral);
					if(thisCanSettlementIntegral.compareTo(BigDecimal.ZERO) > 0){
						Date settlementDate = new Date();
						String remark = String.format("本笔结算来自项目%1$s(%2$s)的结算", sheetName,sheetCode);
						//往部门结算业务表中添加数据
						pparDao.clear();
						pparDao.setPlateId(plateId);
						pparDao.setProjectId(projectId);
						pparDao.setAccountIntegral(thisCanSettlementIntegral);
						pparDao.setAccountDate(settlementDate);
						pparDao.setRemark(remark);
						pparDao.save();
						int businessId = pparDao.getPlateProjectAccountRecordId();
						//插入部门账户
						AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_SURE_INTEGRAL, thisCanSettlementIntegral, settlementDate, remark, -1);
					}
				}
			}
		}
	}
	
	/**
	 * 自动结算项目管理订单积分
	 * @param projectId
	 * @param operateEmployeeId
	 * @throws SQLException
	 */
	public void onAutoProjectManageIntegral(int projectId,int operateEmployeeId) throws SQLException{
		Project dao = new Project();
		dao.setProjectId(projectId);
		if(dao.load()){
			//获取订单编号和订单名称
			String sheetCode = dao.getContractCode();
			String sheetName = dao.getProjectName();
			String remark = String.format("本笔结算来自项目%1$s(%2$s)的结算", sheetName,sheetCode);
			//获取该项目归属的合同ID
			int contractId = BaseHelpUtils.getIntValue(dao.getContractId());
			if(contractId > 0){//说明该合同存在
				//先获取合同下的管理订单（条线管理订单或项目管理费订单）
				dao.clear();
				dao.setConditionContractId("=",contractId);
				dao.setConditionIsAuto("=",Boolean.TRUE);
				dao.setConditionStatus("<>",10);//如果项目暂停，不进行自动结算
				dao.setConditionProjectManageId(">",0);//只检索有设定项目经理的管理费订单
				dao.addCondition(BaseProject.CS_PROJECT_TYPE,"in",16,33);
				List<BaseProject> manageList = dao.conditionalLoad("");
				if(!BaseHelpUtils.isNullOrEmpty(manageList) && manageList.size() > 0){
					ProjectSettlement projectsettDao = new ProjectSettlement();
					ProjectCost costDao = new ProjectCost();
					PlateProjectAccountRecord plateAccountDao = new PlateProjectAccountRecord();
					List<BaseProjectSettlement> projectSettList = null;
					List<BaseProjectCost> costList = null;
					List<BasePlateProjectAccountRecord> plateAccountList = null;
					Date currentDate = new Date();
					//根据该合同ID去检索该合同下的所有订单数据集
					dao.clear();
					dao.setConditionContractId("=",contractId);
					List<BaseProject> list = dao.conditionalLoad(" order by "+BaseProject.CS_PROJECT_ID+" asc ");
					if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
						//初始化订单的累计营收:累计营收=每个点单的累计营收(即订单确认积分/项目积分*订单的合同金额)
						BigDecimal sheetRevenueTotal = BigDecimal.ZERO;
						//获取合同下所有订单的累计合同金额==该订单归属的合同的合同金额
						BigDecimal contractAmount = BigDecimal.ZERO;
						for(BaseProject e : list){
							//获取项目ID
							int proId = BaseHelpUtils.getIntValue(e.getProjectId());
							//获取该订单的合同金额
							BigDecimal sheetAmount = e.getSheetAmount()==null?BigDecimal.ZERO:e.getSheetAmount();
							contractAmount = contractAmount.add(sheetAmount);
							//获取订单积分
							BigDecimal projectIntegral = e.getProjectIntegral()==null?BigDecimal.ZERO:e.getProjectIntegral();
							//获取项目类别，如果是项目管理费订单和条线管理订单，则不计算项目的确认积分
							int projectType = BaseHelpUtils.getIntValue(e.getProjectType());
							if(projectType != 16 && projectType != 33){
								//获取该订单的确认积分
								projectsettDao.clear();
								projectsettDao.setConditionProjectId("=",proId);
								projectsettDao.setConditionSettlementStatus("=",2);
								projectSettList = projectsettDao.conditionalLoad();
								//初始化已经确认的积分为0
								BigDecimal sureIntegral = BigDecimal.ZERO;
								if(!BaseHelpUtils.isNullOrEmpty(projectSettList) && projectSettList.size() > 0){
									for(BaseProjectSettlement be : projectSettList){
										sureIntegral = sureIntegral.add(be.getTotalAmount()==null?BigDecimal.ZERO:be.getTotalAmount());
									}
								}
								BigDecimal sheetRevenue = projectIntegral.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:sureIntegral.multiply(sheetAmount).divide(projectIntegral, 2,BigDecimal.ROUND_DOWN);
								sheetRevenueTotal = sheetRevenueTotal.add(sheetRevenue);
							}//项目类别判断结束projectType
						}//list for循环结束
						//设置合同完工比=订单累计营收/合同金额
						BigDecimal contractFinishPercent = contractAmount.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:sheetRevenueTotal.divide(contractAmount,4,BigDecimal.ROUND_DOWN);
						//循环管理订单数据集
						for(BaseProject me : manageList){
							//获取项目经理
							int projectManageId = BaseHelpUtils.getIntValue(me.getProjectManageId());
							if(projectManageId > 0){
								//获取订单Id
								int sheetId = BaseHelpUtils.getIntValue(me.getProjectId());
								//检索该项目管理费项目是否已经团队组建了，成员就是大项目经理
								ProjectEmployee projectEmpDao = new ProjectEmployee();
								projectEmpDao.setConditionProjectId("=",sheetId);
								projectEmpDao.setConditionEmployeeId("=",projectManageId);
								BaseProjectEmployee empBean = projectEmpDao.executeQueryOneRow();
								//获取订单的阶段ID
								ProjectStage stageDao = new ProjectStage();
								stageDao.setConditionProjectId("=",sheetId);
								BaseProjectStage stageBean = stageDao.executeQueryOneRow();
								int settlementId = 0;
								if(!BaseHelpUtils.isNullOrEmpty(empBean) && !BaseHelpUtils.isNullOrEmpty(stageBean)){//说明有数据
									//获取阶段Id
									int stageId = BaseHelpUtils.getIntValue(stageBean.getStageId());
									//获取项目积分和预留积分
									BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(me.getProjectIntegral());
									BigDecimal reserveIntegral = BaseHelpUtils.getBigDecimalValue(me.getReserveIntegral());
									if(projectIntegral.compareTo(BigDecimal.ZERO) > 0){
										projectsettDao.clear();
										projectsettDao.setConditionProjectId("=",sheetId);
										projectsettDao.setConditionSettlementStatus("=",2);
										projectSettList = projectsettDao.conditionalLoad();
										//初始化已经确认的积分为0
										BigDecimal sureIntegral = BigDecimal.ZERO;
										if(!BaseHelpUtils.isNullOrEmpty(projectSettList) && projectSettList.size() > 0){
											for(BaseProjectSettlement be : projectSettList){
												sureIntegral = sureIntegral.add(be.getTotalAmount()==null?BigDecimal.ZERO:be.getTotalAmount());
											}
										}
										//计算累计可结算积分=合同进度比*项目积分
										BigDecimal totalCanSettlementIntegral = contractFinishPercent.multiply(projectIntegral);
										//计算本地可计算积分=累计可结算积分-历史确认积分
										BigDecimal thisCanSettlementIntegral = totalCanSettlementIntegral.subtract(sureIntegral);
										if(thisCanSettlementIntegral.compareTo(BigDecimal.ZERO) > 0){
											//获取该项目管理费的未结算的项目成本
											costDao.clear();
											costDao.setConditionProjectId("=",sheetId);
											costDao.setConditionStatus("=",0);//只检索未结算的项目成本
											costList = costDao.conditionalLoad();
											//初始化项目成本
											BigDecimal projectCost = BigDecimal.ZERO;
											if(!BaseHelpUtils.isNullOrEmpty(costList) && costList.size() > 0){
												for(BaseProjectCost e : costList){
													projectCost = projectCost.add(BaseHelpUtils.getBigDecimalValue(e.getAmount()));
												}
											}
											projectsettDao.clear();
											projectsettDao.setProjectId(sheetId);
											projectsettDao.setEmployeeId(operateEmployeeId);
											projectsettDao.setSettlementDate(currentDate);
											projectsettDao.setTotalAmount(thisCanSettlementIntegral);
											projectsettDao.setTotalCost(projectCost);
											projectsettDao.setLeftAmount(thisCanSettlementIntegral.subtract(projectCost));
											projectsettDao.setProjectAmount(projectIntegral);
											projectsettDao.setStageId(stageId);
											projectsettDao.setRemark(remark);
											projectsettDao.setFlag(2);
											projectsettDao.save();
											//获取主键ID
											settlementId = projectsettDao.getSettlementId();
											//保存明细表
											ProjectSettlementDetail settDetailDao = new ProjectSettlementDetail();
											BaseProjectSettlementDetail settDetailBean = new BaseProjectSettlementDetail();
											settDetailBean.setSettlementId(settlementId);
											settDetailBean.setProjectId(sheetId);
											settDetailBean.setEmployeeId(projectManageId);
											settDetailBean.setSettlementDate(currentDate);
											settDetailBean.setPlanAmount(empBean.getPlanIntegral());
											settDetailBean.setRealAmount(thisCanSettlementIntegral);
											settDetailBean.setProjectCost(projectCost);
											settDetailBean.setFinalAmount(thisCanSettlementIntegral.subtract(projectCost));
											settDetailDao.setDataFromBase(settDetailBean);
											settDetailDao.save();
											int businessId = settDetailDao.getSettlementDetailId();
											//确认积分插入个人账户
											AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId, AccountManageProcess.EMP_BT_SURE_INTEGRAL, thisCanSettlementIntegral, new Date(), remark, -1);
											//如果有成本，结算后更新项目成本的状态值
											if(projectCost.compareTo(BigDecimal.ZERO) != 0){
												//项目成本插入个人账户
												AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId, AccountManageProcess.EMP_BT_PROJECT_COST, projectCost, new Date(), remark, -1);
												costDao.setStatus(1);//设置为已分摊
												costDao.setSettlementId(settlementId);
												costDao.conditionalUpdate();
											}
											//更新成员表数据
											empBean.setSettlement(BaseHelpUtils.getBigDecimalValue(empBean.getSettlement()).add(thisCanSettlementIntegral));
											empBean.setCost(BaseHelpUtils.getBigDecimalValue(empBean.getCost()).add(projectCost));
											projectEmpDao.clear();
											projectEmpDao.setDataFromBase(empBean);
											projectEmpDao.update();
										}
										
									}//判断项目积分结束
									
									if(reserveIntegral.compareTo(BigDecimal.ZERO) > 0){
										plateAccountDao.clear();
										plateAccountDao.setConditionProjectId("=",sheetId);
										plateAccountList = plateAccountDao.conditionalLoad();
										//设置累计确认积分
										BigDecimal plateSureIntegral = BigDecimal.ZERO;
										if(!BaseHelpUtils.isNullOrEmpty(plateAccountList) && plateAccountList.size() > 0){
											for(BasePlateProjectAccountRecord pe : plateAccountList){
												plateSureIntegral = plateSureIntegral.add(BaseHelpUtils.getBigDecimalValue(pe.getAccountIntegral()));
											}
										}
										//设置累计可结算积分=合同进度比*部门预留积分
										BigDecimal totalCanSettlementIntegral = contractFinishPercent.multiply(reserveIntegral);
										//设置本次可确认积分=累计可结算积分-已经确认积分
										BigDecimal thisCanSettlementIntegral = totalCanSettlementIntegral.subtract(plateSureIntegral);
										if(thisCanSettlementIntegral.compareTo(BigDecimal.ZERO) > 0){
											//获取该订单的业务部门
											int plateId = BaseHelpUtils.getIntValue(me.getPlateId());
											plateAccountDao.clear();
											plateAccountDao.setPlateId(plateId);
											plateAccountDao.setProjectId(sheetId);
											plateAccountDao.setStageId(stageId);
											plateAccountDao.setAccountIntegral(thisCanSettlementIntegral);
											plateAccountDao.setAccountDate(currentDate);
											plateAccountDao.setRemark(remark);
											plateAccountDao.setSettlementId(settlementId);
											plateAccountDao.save();
											int businessId = BaseHelpUtils.getIntValue(plateAccountDao.getPlateProjectAccountRecordId());
											//插入部门账户
											AccountManageProcess.onSavePlateAccount(plateId, businessId,AccountManageProcess.PLATE_BT_SURE_INTEGRAL, thisCanSettlementIntegral, currentDate, remark, operateEmployeeId);
										}
									}//判断预留积分结束
								}
							}
						}//manageList for循环结束
					}
				}
			}
		}
	}
	
	/**
	 * 根据该项目归属的合同完工百分比，去自动计算该合同下的项目管理费的积分确认值(即給到大项目经理的数据集)
	 * @param projectId
	 * @throws SQLException 
	 */
	public void onSettlementProjectManageIntegral(int projectId,int operateEmployeeId,String remark) throws SQLException{
		Project dao = new Project();
		dao.setProjectId(projectId);
		if(dao.load()){
			//获取订单编号和订单名称
			String sheetCode = dao.getContractCode();
			String sheetName = dao.getProjectName();
			remark = String.format("本笔结算来自项目%1$s(%2$s)的结算", sheetName,sheetCode);
			//获取该项目归属的合同ID
			int contractId = BaseHelpUtils.getIntValue(dao.getContractId());
			if(contractId > 0){//说明该合同存在
				//根据该合同ID去检索该合同下的所有订单数据集
				dao.clear();
				dao.setConditionContractId("=",contractId);
				List<BaseProject> list = dao.conditionalLoad(" order by "+BaseProject.CS_PROJECT_ID+" asc ");
				if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
					ProjectSettlement projectsettDao = new ProjectSettlement();
					//设置该合同下的项目管理费的项目经理和项目管理费，默认为0
					int sheetId = 0;
					int projectManageId = 0;
					boolean isAuto = false;
					//初始化项目管理费的项目积分为0
					BigDecimal projectManageIntegral = BigDecimal.ZERO;
					//初始化合同的完工比为0
					BigDecimal contractFinishPercent = BigDecimal.ZERO;
					//初始化项目管理费确认的积分
					BigDecimal projectManageSureIntegral = BigDecimal.ZERO;
					//初始化订单的累计营收:累计营收=每个点单的累计营收(即订单确认积分/项目积分*订单的合同金额)
					BigDecimal sheetRevenueTotal = BigDecimal.ZERO;
					//获取合同下所有订单的累计合同金额==该订单归属的合同的合同金额
					BigDecimal contractAmount = BigDecimal.ZERO;
					for(BaseProject e : list){
						//获取项目ID
						int proId = BaseHelpUtils.getIntValue(e.getProjectId());
						//获取项目类型
						int projectType = BaseHelpUtils.getIntValue(e.getProjectType());
						//获取该订单的合同金额
						BigDecimal sheetAmount = e.getSheetAmount()==null?BigDecimal.ZERO:e.getSheetAmount();
						contractAmount = contractAmount.add(sheetAmount);
						//获取订单积分
						BigDecimal projectIntegral = e.getProjectIntegral()==null?BigDecimal.ZERO:e.getProjectIntegral();
						//获取该订单的确认积分
						projectsettDao.clear();
						projectsettDao.setConditionProjectId("=",proId);
						projectsettDao.setConditionSettlementStatus("=",2);
						List<BaseProjectSettlement> projectSettList = projectsettDao.conditionalLoad();
						//初始化已经确认的积分为0
						BigDecimal sureIntegral = BigDecimal.ZERO;
						if(!BaseHelpUtils.isNullOrEmpty(projectSettList) && projectSettList.size() > 0){
							for(BaseProjectSettlement be : projectSettList){
								sureIntegral = sureIntegral.add(be.getTotalAmount()==null?BigDecimal.ZERO:be.getTotalAmount());
							}
						}
						if(projectType == 16){//说明是项目管理费
							isAuto = e.getIsAuto();
							projectManageId = BaseHelpUtils.getIntValue(e.getProjectManageId());
							sheetId = proId;
							projectManageIntegral = e.getProjectIntegral()==null?BigDecimal.ZERO:e.getProjectIntegral();
							projectManageSureIntegral = sureIntegral;
						}else{//说明是非项目管理费，则需计算每个订单的完工比，即项目确认积分/项目积分
							BigDecimal sheetRevenue = projectIntegral.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:sureIntegral.multiply(sheetAmount).divide(projectIntegral, 2,BigDecimal.ROUND_DOWN);
							sheetRevenueTotal = sheetRevenueTotal.add(sheetRevenue);
						}
					}
					if(isAuto){//如果是项目管理费，且是按项目进度自动结算的
						//设置合同完工比=订单营收/合同金额
						contractFinishPercent = contractAmount.compareTo(BigDecimal.ZERO)==0?BigDecimal.ZERO:sheetRevenueTotal.divide(contractAmount,4,BigDecimal.ROUND_DOWN);
						if(projectManageId > 0 && projectManageIntegral.compareTo(BigDecimal.ZERO) > 0 && contractFinishPercent.compareTo(BigDecimal.ZERO) != 0){
							//检索该项目管理费项目是否已经团队组建了，成员就是大项目经理
							ProjectEmployee projectEmpDao = new ProjectEmployee();
							projectEmpDao.setConditionProjectId("=",sheetId);
							projectEmpDao.setConditionEmployeeId("=",projectManageId);
							if(projectEmpDao.countRows() > 0){//说明有数据
								//根据合同完工比计算该项目经理目前可结算的积分，即项目管理费*合同完工比
								BigDecimal canSettlementIntegral = BigDecimal.ZERO;
								if(contractFinishPercent.compareTo(BigDecimal.ONE) == 0){//说明已竣工
									//检索已经确认的确认积分
									projectsettDao.clear();
									projectsettDao.setConditionProjectId("=",sheetId);
									List<BaseProjectSettlement> projectSettList = projectsettDao.conditionalLoad();
									//初始化已经确认的积分为0
									BigDecimal sureIntegral = BigDecimal.ZERO;
									if(!BaseHelpUtils.isNullOrEmpty(projectSettList) && projectSettList.size() > 0){
										for(BaseProjectSettlement e : projectSettList){
											sureIntegral = sureIntegral.add(e.getTotalAmount()==null?BigDecimal.ZERO:e.getTotalAmount());
										}
									}
									//设置可结算的积分=项目管理费-已经确认的积分
									canSettlementIntegral = projectManageIntegral.subtract(sureIntegral);
								}else{
									canSettlementIntegral = BaseHelpUtils.format(projectManageIntegral.multiply(contractFinishPercent),2);
								}
								//设置这一次可确认的积分=总的可确认积分-已确认积分
								BigDecimal thisCanSettlementIntegral = canSettlementIntegral.subtract(projectManageSureIntegral);
								canSettlementIntegral = BaseHelpUtils.format(thisCanSettlementIntegral.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:thisCanSettlementIntegral, 2);
								//如果可结算的积分不等于0，则保存到表中
								if(canSettlementIntegral.compareTo(BigDecimal.ZERO) != 0){
									//获取订单的阶段ID
									ProjectStage stageDao = new ProjectStage();
									stageDao.setConditionProjectId("=",sheetId);
									BaseProjectStage stageBean = stageDao.executeQueryOneRow();
									if(!BaseHelpUtils.isNullOrEmpty(stageBean)){
										//获取该项目管理费的未结算的项目成本
										ProjectCost costDao = new ProjectCost();
										costDao.setConditionProjectId("=",sheetId);
										costDao.setConditionStatus("=",0);//只检索未结算的项目成本
										List<BaseProjectCost> costList = costDao.conditionalLoad();
										//初始化项目成本
										BigDecimal projectCost = BigDecimal.ZERO;
										if(!BaseHelpUtils.isNullOrEmpty(costList) && costList.size() > 0){
											for(BaseProjectCost e : costList){
												projectCost = projectCost.add(BaseHelpUtils.getBigDecimalValue(e.getAmount()));
											}
										}
										int stageId = stageBean.getStageId();
										projectsettDao.clear();
										projectsettDao.setProjectId(sheetId);
										projectsettDao.setFlag(2);
										projectsettDao.setEmployeeId(operateEmployeeId);
										projectsettDao.setSettlementDate(new Date());
										projectsettDao.setTotalAmount(canSettlementIntegral);
										projectsettDao.setTotalCost(projectCost);
										projectsettDao.setLeftAmount(canSettlementIntegral.subtract(projectCost));
										projectsettDao.setProjectAmount(projectManageIntegral);
										projectsettDao.setStageId(stageId);
										projectsettDao.setRemark(remark);
										projectsettDao.save();
										//获取主键ID
										int settlementId = projectsettDao.getSettlementId();
										//保存明细表
										ProjectSettlementDetail settDetailDao = new ProjectSettlementDetail();
										BaseProjectSettlementDetail settDetailBean = new BaseProjectSettlementDetail();
										settDetailBean.setSettlementId(settlementId);
										settDetailBean.setProjectId(sheetId);
										settDetailBean.setEmployeeId(projectManageId);
										settDetailBean.setSettlementDate(new Date());
										settDetailBean.setPlanAmount(projectManageIntegral);
										settDetailBean.setRealAmount(canSettlementIntegral);
										settDetailBean.setProjectCost(projectCost);
										settDetailBean.setFinalAmount(canSettlementIntegral.subtract(projectCost));
										settDetailDao.setDataFromBase(settDetailBean);
										settDetailDao.save();
										int businessId = settDetailDao.getSettlementDetailId();
										//确认积分插入个人账户
										AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId, AccountManageProcess.EMP_BT_SURE_INTEGRAL, canSettlementIntegral, new Date(), remark, -1);
										//如果有成本，结算后更新项目成本的状态值
										if(projectCost.compareTo(BigDecimal.ZERO) != 0){
											//项目成本插入个人账户
											AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId, AccountManageProcess.EMP_BT_PROJECT_COST, projectCost, new Date(), remark, -1);
											costDao.setStatus(1);//设置为已分摊
											costDao.setSettlementId(settlementId);
											costDao.conditionalUpdate();
										}
										//更新成员表数据
										BaseProjectEmployee projectEmployeeBean = projectEmpDao.executeQueryOneRow();
										projectEmployeeBean.setSettlement(BaseHelpUtils.getBigDecimalValue(projectEmployeeBean.getSettlement()).add(canSettlementIntegral));
										projectEmployeeBean.setCost(BaseHelpUtils.getBigDecimalValue(projectEmployeeBean.getCost()).add(projectCost));
										projectEmpDao.clear();
										projectEmpDao.setDataFromBase(projectEmployeeBean);
										projectEmpDao.update();
									}else{
										__logger.info("该项目管理费尚未设定项目管理全阶段***********************************");
									}
									
								}
							}else{
								__logger.info("该项目管理费尚未设定大项目经理为项目的成员***********************************");
							}
						}else{
							__logger.info("该项目管理费不可进行项目经理的自动结算操作**************************************");
						}
					}else{
						__logger.info("该项目未设定合同***********************************");
					}
				}
			}
		}
	}

	/**
	 * 获取该项目已确认的积分
	 * 
	 * @param assignedTotalIntegral
	 * @param projectId
	 * @return
	 * @throws SQLException
	 */
	public BigDecimal getProjectAssignedTotalIntegral(Integer projectId) throws SQLException {
		BigDecimal assignedTotalIntegral = BigDecimal.ZERO;
		ProjectSettlement dao = new ProjectSettlement();
		dao.setConditionProjectId("=", projectId);
		List<BaseProjectSettlement> listBean = dao.conditionalLoad();
		if (!BaseHelpUtils.isNullOrEmpty(listBean) && listBean.size() > 0) {
			for (BaseProjectSettlement bean : listBean) {
				BigDecimal sureIntegral = bean.getTotalAmount()==null?BigDecimal.ZERO:bean.getTotalAmount();
				assignedTotalIntegral = assignedTotalIntegral.add(sureIntegral);
			}
		}
		return assignedTotalIntegral;
	}

}
