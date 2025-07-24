package pomplatform.contract.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import org.apache.bcel.generic.IF_ACMPEQ;

import com.pomplatform.db.bean.BaseCommissionSettlementRecord;
import com.pomplatform.db.bean.BaseOldProjectRevenue;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.CommissionSettlementRecord;
import com.pomplatform.db.dao.OldProjectRevenue;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.RevenueStatisticalRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler;
import pomplatform.revenueStatistical.query.QueryRevenueStatisticalOfRevenue;

/**
 * @author liubin
 *	更新2017年以前的订单的营收并分配积分到部门
 */
public class OldProjectRevenueTask extends TimerTask{

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			ThreadConnection.beginTransaction();
			OldProjectRevenue dao = new OldProjectRevenue();
			dao.setConditionIsFinish("=", 2);
			List<BaseOldProjectRevenue> baseOldProjectRevenues = dao.conditionalLoad();
			for (BaseOldProjectRevenue baseOldProjectRevenue : baseOldProjectRevenues) {
				//获取订单的编号
				String projectCode = baseOldProjectRevenue.getProjectCode();
				//没有归属的营销团队时跳过
				if (BaseHelpUtils.isNullOrEmpty(baseOldProjectRevenue.getPalteId())) {
					continue;
				}
				int palteId = baseOldProjectRevenue.getPalteId();
				PlateRecord plateRecordDao = new PlateRecord();
				plateRecordDao.setConditionPlateId("=", palteId);
				BasePlateRecord basePlateRecord = plateRecordDao.executeQueryOneRow();
				String plateName = "";
				if (!BaseHelpUtils.isNullOrEmpty(basePlateRecord)) {
					plateName = basePlateRecord.getPlateName();
				}
				Project projectDao = new Project();
				projectDao.setConditionContractCode("=", projectCode);
				BaseProject baseproject = projectDao.executeQueryOneRow();
				String projectName = "";
				if (!BaseHelpUtils.isNullOrEmpty(baseproject)) {
					projectName = baseproject.getProjectName();
				}
				
				if (!BaseHelpUtils.isNullOrEmpty(baseproject)) {
					//订单的金额
					BigDecimal sheetAmountCurrent = baseproject.getSheetAmount();
					//税率
					BigDecimal ratePercent = new BigDecimal("1.06");
					//获取订单的业态
					int businessType = baseOldProjectRevenue.getBuniessType();
					//取出当前时间年份和月份
					Calendar cal = Calendar.getInstance();
					int month = cal.get(Calendar.MONTH) + 1;
			        int year = cal.get(Calendar.YEAR);
			        //计算订单的营收
			        RevenueStatisticalRecord revenueStatisticalRecordDao = new RevenueStatisticalRecord();
			        //取出当前时间的进度
					QueryRevenueStatisticalOfRevenue q = new QueryRevenueStatisticalOfRevenue();
					ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
					c.setYear(year);
					c.setMonth(month);
					c.setSheetCode(projectCode);
					CustomRevenueStatisticalOfRevenueHandler cc = new CustomRevenueStatisticalOfRevenueHandler();
					BaseCollection<BaseRevenueStatisticalOfRevenue> result = cc.getResult(c);
					List<BaseRevenueStatisticalOfRevenue> resultList = result.getCollections();
					BigDecimal totalPercent1 = new BigDecimal("0");
					if(!BaseHelpUtils.isNullOrEmpty(resultList)){
						BaseRevenueStatisticalOfRevenue aa = resultList.get(0);
						ratePercent = new BigDecimal("1.06");
						totalPercent1 = aa.getTotalPercent();
					}
					
					//取出当前时间的进度
					QueryRevenueStatisticalOfRevenue q1 = new QueryRevenueStatisticalOfRevenue();
					ConditionRevenueStatisticalOfRevenue c1 = new ConditionRevenueStatisticalOfRevenue();
					c1.setYear(2017);
					c1.setMonth(12);
					c1.setSheetCode(projectCode);
					CustomRevenueStatisticalOfRevenueHandler cc1 = new CustomRevenueStatisticalOfRevenueHandler();
					BaseCollection<BaseRevenueStatisticalOfRevenue> result1 = cc1.getResult(c1);
					List<BaseRevenueStatisticalOfRevenue> resultList1 = result1.getCollections();
					BigDecimal totalPercent2 = new BigDecimal("0");
					if(!BaseHelpUtils.isNullOrEmpty(resultList1)){
						BaseRevenueStatisticalOfRevenue aa1 = resultList1.get(0);
						totalPercent2 = aa1.getTotalPercent();
					}
					//当订单的进度为负数时不进行计算
//					if((totalPercent2.subtract(totalPercent1)).compareTo(BigDecimal.ZERO) == -1) {
//						continue;
//					}
					BigDecimal revenue = null;
					//除去税率后的订单金额
					BigDecimal sheetAmount = sheetAmountCurrent.divide(ratePercent,2,BigDecimal.ROUND_HALF_EVEN);
					switch (businessType) {
					case 1://商业(营收提成系数1.5%)
						revenue = sheetAmount.multiply(new BigDecimal("0.015")).multiply(totalPercent1.subtract(totalPercent2));
						break;
					case 2://酒店(营收提成系数1.9%)	
						revenue = sheetAmount.multiply(new BigDecimal("0.019")).multiply(totalPercent1.subtract(totalPercent2));
						break;
					case 8://地产(营收提成系数1.9%)
						revenue = sheetAmount.multiply(new BigDecimal("0.019")).multiply(totalPercent1.subtract(totalPercent2));
						break;
					case 3://办公(营收提成系数1.7%)
						revenue = sheetAmount.multiply(new BigDecimal("0.017")).multiply(totalPercent1.subtract(totalPercent2));
						break;
					case 6://公建(营收提成系数1.7%)
						revenue = sheetAmount.multiply(new BigDecimal("0.017")).multiply(totalPercent1.subtract(totalPercent2));
						break;	
					case 5://医养(营收提成系数2.5%)
						revenue = sheetAmount.multiply(new BigDecimal("0.025")).multiply(totalPercent1.subtract(totalPercent2));
						break;
					case 4://轨交(营收提成系数5%)
						revenue = sheetAmount.multiply(new BigDecimal("0.05")).multiply(totalPercent1.subtract(totalPercent2));
						break;
					default:
						revenue = new BigDecimal("0");
						break;
					}
					//本次营收保留两位小数
					if (!BaseHelpUtils.isNullOrEmpty(revenue)) {
						revenue =  revenue.setScale(2,BigDecimal.ROUND_HALF_UP);
					}else {
						revenue = new BigDecimal("0");
					}
					//取出上一次的营收
					BigDecimal oldRevenue = baseOldProjectRevenue.getAmount();
					//更新订单的营收
					baseOldProjectRevenue.setAmount(revenue);
					baseOldProjectRevenue.setContractCode(baseproject.getProjectCode());
					baseOldProjectRevenue.setProjectName(baseproject.getProjectName());
					if (totalPercent1.equals(new BigDecimal("1.00"))) {
						baseOldProjectRevenue.setIsFinish(1);
					}else {
						baseOldProjectRevenue.setIsFinish(2);
					}
					OldProjectRevenue dao2 = new OldProjectRevenue();
					dao2.setDataFromBase(baseOldProjectRevenue);
					dao2.update();
					
					if (BaseHelpUtils.isNullOrEmpty(oldRevenue)) {
						oldRevenue = new BigDecimal("0");
					}
					//计算本次进度的营收
					BigDecimal settlement = revenue.subtract(oldRevenue);
					//营销部门一级账户提成支出
					if (palteId == 0) {//订单的归属id等于0时只更新营收不分配积分
						continue;
					}
					//记录流水
	 				CommissionSettlementRecord commissionSettlementRecordDao = new CommissionSettlementRecord();
					commissionSettlementRecordDao.setOrderId(projectCode);
					commissionSettlementRecordDao.setCountType(3);
					commissionSettlementRecordDao.setAmount(settlement);
					commissionSettlementRecordDao.setDepartmentId(14);
					commissionSettlementRecordDao.setSettlementType(1);
					commissionSettlementRecordDao.save();
					BaseCommissionSettlementRecord bean = commissionSettlementRecordDao.generateBase();
					//营销一级账户所需结算的积分
					int flag = settlement.compareTo(BigDecimal.ZERO);
					//本次进度结算为正数
					if (flag == 1) {
						AccountManageProcess accountManageProcess = new AccountManageProcess();
						accountManageProcess.onSavePlateAccount1(14, bean.getCommissionSettlementRecordId(), 26, settlement,
								bean.getSettlementTime(), projectCode+"——"+projectName+"——"+"提成分配支出"+"("+ plateName +")", -1);
					}
					//进度回退退钱
					if (flag == -1) {
						AccountManageProcess accountManageProcess = new AccountManageProcess();
						settlement = settlement.abs();
						accountManageProcess.onSavePlateAccount1(14, bean.getCommissionSettlementRecordId(), 25, settlement,
								bean.getSettlementTime(), projectCode+"——"+projectName+"——"+"提成分配收入"+"("+ plateName +")", -1);
					}
					//根据订单的营收
					//记录流水
					int plateId = baseOldProjectRevenue.getPalteId();
					CommissionSettlementRecord commissionSettlementRecordDao1 = new CommissionSettlementRecord();
					commissionSettlementRecordDao1.setOrderId(projectCode);
					commissionSettlementRecordDao1.setCountType(2);
					commissionSettlementRecordDao1.setDepartmentId(plateId);
					commissionSettlementRecordDao1.setAmount(settlement);
					commissionSettlementRecordDao1.setSettlementType(1);
					commissionSettlementRecordDao1.save();
					BaseCommissionSettlementRecord bean1 = commissionSettlementRecordDao1.generateBase();
					//分配积分到部门账户
					if (flag == 1) {
						AccountManageProcess accountManageProcess1 = new AccountManageProcess();
						accountManageProcess1.onSavePlateAccount1(palteId, bean1.getCommissionSettlementRecordId(),
								25, settlement, bean1.getSettlementTime(), projectCode+"——"+projectName+"——"+"提成分配收入", -1);
					}
					//积分回退
					if (flag == -1) {
						settlement = settlement.abs();
						AccountManageProcess accountManageProcess1 = new AccountManageProcess();
						accountManageProcess1.onSavePlateAccount1(palteId, bean1.getCommissionSettlementRecordId(),
								26, settlement, bean1.getSettlementTime(), projectCode+"——"+projectName+"——"+"提成分配支出", -1);
					}
					
				}
			}
			ThreadConnection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		OldProjectRevenueTask dd = new OldProjectRevenueTask();
		dd.run();
	}
}
