package pomplatform.contract.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseCommissionSettlementRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractDistribution;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseTeamBuilding;
import com.pomplatform.db.dao.CommissionSettlementRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractDistribution;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.TeamBuilding;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import pomplatform.account.business.AccountManageProcess;

/**
 * @author liubin 更新项目的营收，以及分配积分
 */
public class SettlementPercentage extends TimerTask {

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			ThreadConnection.beginTransaction();
			NewContractDistributionProcess process = new NewContractDistributionProcess();
			ContractDistribution dao = new ContractDistribution();
//			 dao.setConditionContractId("=",1747);
			List<BaseContractDistribution> list = dao.conditionalLoad(" order_id is not null");
			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
				Date currentDate = new Date();
				ContractDistribution dao1 = new ContractDistribution();
				Contract contractDao = new Contract();
				PlateRecord plateRecord = new PlateRecord();
				TeamBuilding teamBuildingDao = new TeamBuilding();
				CommissionSettlementRecord commissionSettlementRecordDao = new CommissionSettlementRecord();
				AccountManageProcess accountManageProcess = new AccountManageProcess();
				CommissionSettlementRecord commissionSettlementRecordDao1 = new CommissionSettlementRecord();
				for (BaseContractDistribution baseContractDistribution : list) {
					String orderId = BaseHelpUtils.getString(baseContractDistribution.getOrderId());
					int businessType = BaseHelpUtils.getIntValue(baseContractDistribution.getBusinessType());
					int contractId = BaseHelpUtils.getIntValue(baseContractDistribution.getContractId());
					contractDao.clear();
					contractDao.setContractId(contractId);
					contractDao.load();
					BaseContract baseContract = contractDao.generateBase();
					String contractCode = "";
					String contractName = "";
					if (!BaseHelpUtils.isNullOrEmpty(baseContract)) {
						contractCode = baseContract.getContractCode();
						contractName = baseContract.getContractName();
					}
					int palteId = baseContractDistribution.getPlateId();
					plateRecord.clear();
					plateRecord.setConditionPlateId("=", palteId);
					BasePlateRecord basePlateRecord = plateRecord.executeQueryOneRow();
					String palteName = "";
					if (!BaseHelpUtils.isNullOrEmpty(basePlateRecord)) {
						palteName = plateRecord.getPlateName();
					}
					BigDecimal currentAmount = new BigDecimal("0");
					Map<String, Object> params = new HashMap<>();
					params.put("orderId", orderId);
					params.put("businessType", businessType);
					params.put("contractId", contractId);
					// 取出旧的营收之前必须放在更新营收的前面
					BigDecimal oldAmount = BaseHelpUtils.getBigDecimalValue(baseContractDistribution.getAmount());
					// 计算本次的营收
					BigDecimal newAmount = new BigDecimal("-999999");
					newAmount = process.calculateRevenue(params);
					if (newAmount.compareTo(new BigDecimal("-999999")) == 0) {
						continue;
					}
					newAmount = newAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
					
					// 自动结算积分
					currentAmount = newAmount.subtract(oldAmount);// 本次进度所需结算的积分
					if (currentAmount.compareTo(BigDecimal.ZERO) == 0) {// 计算所需结算的积分为0，则不要分配积分
						continue;
					}
					
					// 更新营收
					baseContractDistribution.setAmount(newAmount);
					dao1.clear();
					dao1.setDataFromBase(baseContractDistribution);
					dao1.update();
					
					// 没有分配团队时只更新营收不分配提成
					teamBuildingDao.clear();
					teamBuildingDao.setConditionOrderId("=", orderId);
					List<BaseTeamBuilding> baseTeamBuildings = teamBuildingDao.conditionalLoad();
					if (baseTeamBuildings.size() == 0) {
						continue;
					}
					
					// 记录流水
					// 营销一级账户所需结算的积分
					int flag = currentAmount.compareTo(BigDecimal.ZERO);
					commissionSettlementRecordDao.clear();
					commissionSettlementRecordDao.setOrderId(orderId);
					commissionSettlementRecordDao.setCountType(2);
					commissionSettlementRecordDao.setDepartmentId(14);
					if (flag == 1) {
						commissionSettlementRecordDao.setAmount(currentAmount);
						commissionSettlementRecordDao.setSettlementType(2);
					}
					if (flag == -1) {
						currentAmount = currentAmount.abs();
						commissionSettlementRecordDao.setAmount(currentAmount);
						commissionSettlementRecordDao.setSettlementType(1);
					}
					commissionSettlementRecordDao.save();
					BaseCommissionSettlementRecord bean = commissionSettlementRecordDao.generateBase();
					// 本次进度结算为正数
					if (flag == 1) {
						accountManageProcess.onSavePlateAccount1(14, bean.getCommissionSettlementRecordId(), 26,
								currentAmount, bean.getSettlementTime(),
								contractCode + "——" + contractName + "——" + "提成分配支出" + "(" + palteName + ")", -1);
					}
					// 进度回退退钱
					if (flag == -1) {
						currentAmount = currentAmount.abs();
						accountManageProcess.onSavePlateAccount1(14, bean.getCommissionSettlementRecordId(), 25,
								currentAmount, bean.getSettlementTime(),
								contractCode + "——" + contractName + "——" + "提成分配收入" + "(" + palteName + ")", -1);
					}
					
					int businessId = 0;
					for (BaseTeamBuilding baseTeamBuilding : baseTeamBuildings) {
						// 分配部门预留的积分
						Integer departmentId = baseTeamBuilding.getDepartmentId();
						if (!BaseHelpUtils.isNullOrEmpty(departmentId)) {
							BigDecimal oldSettlement = BaseHelpUtils.getBigDecimalValue(baseTeamBuilding.getSettlement());
							double rate = (double) baseTeamBuilding.getRate() / (double) 100;
							BigDecimal settlement = currentAmount.multiply(new BigDecimal(rate));
							// 在团队组建表中记录
							BigDecimal tempSettlement = settlement.add(oldSettlement);
							teamBuildingDao.setSettlement(tempSettlement);
							teamBuildingDao.conditionalUpdate();
							
							// 记录流水
							commissionSettlementRecordDao1.clear();
							commissionSettlementRecordDao1.setOrderId(orderId);
							commissionSettlementRecordDao1.setCountType(2);
							commissionSettlementRecordDao1.setDepartmentId(departmentId);
							if (flag == 1) {
								commissionSettlementRecordDao1.setSettlementType(1);
								commissionSettlementRecordDao1.setAmount(settlement);
							}
							if (flag == -1) {
								settlement = settlement.abs();
								commissionSettlementRecordDao1.setAmount(settlement);
								commissionSettlementRecordDao1.setSettlementType(2);
							}
							commissionSettlementRecordDao1.save();
							businessId = commissionSettlementRecordDao1.getCommissionSettlementRecordId();
							// 分配积分到部门账户
							if (flag == 1) {
								accountManageProcess.onSavePlateAccount1(departmentId,
										businessId, 25, settlement,currentDate,
										contractCode + "-" + contractName + "-" + "提成分配收入", -1);
							}
							// 积分回退
							if (flag == -1) {
								currentAmount = currentAmount.abs();
								accountManageProcess.onSavePlateAccount1(departmentId,
										businessId, 26, settlement,currentDate,
										contractCode + "-" + contractName + "-" + "提成分配支出", -1);
							}
						}
						// 分配个人的积分
						int employeeId = BaseHelpUtils.getIntValue(baseTeamBuilding.getEmployeeId());
						if (employeeId > 0) {
							BigDecimal oldSettlement = baseTeamBuilding.getSettlement();
							double rate = (double) baseTeamBuilding.getRate() / (double) 100;
							BigDecimal settlement = currentAmount.multiply(new BigDecimal(rate));
							// 在团队组建表中记录
							BigDecimal tempSettlement = settlement.add(oldSettlement);
							teamBuildingDao.setSettlement(tempSettlement);
							teamBuildingDao.conditionalUpdate();
							
							// 记录流水
							commissionSettlementRecordDao1.clear();
							commissionSettlementRecordDao1.setOrderId(orderId);
							commissionSettlementRecordDao1.setCountType(1);
							commissionSettlementRecordDao1.setEmployeeId(employeeId);
							if (flag == 1) {
								commissionSettlementRecordDao1.setSettlementType(1);
								commissionSettlementRecordDao1.setAmount(settlement);
							}
							if (flag == -1) {
								settlement = settlement.abs();
								commissionSettlementRecordDao1.setAmount(settlement);
								commissionSettlementRecordDao1.setSettlementType(2);
							}
							commissionSettlementRecordDao1.save();
							businessId = commissionSettlementRecordDao1.getCommissionSettlementRecordId();
							// 分配积分到个人账户
							if (flag == 1) {
								accountManageProcess.onSaveEmployeeAccount1(employeeId,
										businessId, 20, settlement, currentDate,
										contractCode + "——" + contractName + "——" + "提成分配收入", -1);
							}
							// 进度回退积分回收
							if (flag == -1) {
								settlement = settlement.abs();
								accountManageProcess.onSaveEmployeeAccount1(employeeId,
										businessId, 21, settlement, currentDate,
										contractCode + "——" + contractName + "——" + "提成分配支出", -1);
							}
							
						}
					}
				}
				
			}
			ThreadConnection.commit();
		} catch (Exception e) {
			ThreadConnection.rollback();
			e.printStackTrace();
		}
		//
	}

	public static void main(String[] args) {
		SettlementPercentage settlementPercentage = new SettlementPercentage();
		settlementPercentage.run();
	}

}
