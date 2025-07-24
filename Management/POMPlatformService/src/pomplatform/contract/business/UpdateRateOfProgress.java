package pomplatform.contract.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractDistribution;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractDistribution;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.RevenueStatisticalRecord;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler;
import pomplatform.revenueStatistical.query.QueryRevenueStatisticalOfRevenue;

/**
 * @author liubin
 * 实时更新项目的进度
 */
public class UpdateRateOfProgress extends TimerTask {

	@SuppressWarnings("unused")
	@Override
	public void run() {
		try {
			//查询出所有已经分配团队的项目
			ContractDistribution cDistributionDao = new ContractDistribution();
//			cDistributionDao.setConditionContractId("=",754);
			List<BaseContractDistribution> baseContractDistributions = cDistributionDao.conditionalLoad(" order_id is not null");
			//循环遍历每一条数据
			if (baseContractDistributions.size() == 0) {
				return;
			}
			for (BaseContractDistribution baseContractDistribution : baseContractDistributions) {
				BigDecimal rate = new BigDecimal("0");
				BigDecimal revenue = null;
				BigDecimal totalRevenue = new BigDecimal("0");
				BigDecimal projectAmount = new BigDecimal("0");
				//取出合同的编号
				Integer contractId = baseContractDistribution.getContractId();
				//根据合同id查询合同
				Contract contractDao = new Contract();
				if (contractId != null) {
					contractDao.setContractId(contractId);
					contractDao.load();
					BaseContract baseContract = contractDao.generateBase();
					//查询合同下的订单
					Project projectDao = new Project();
					projectDao.setConditionContractId("=", contractId);
					List<BaseProject> projects = projectDao.conditionalLoad();
					//计算合同下面所有订单的总和
					if (projects.size() != 0) {
						for (BaseProject baseProject2 : projects) {
							//订单的金额
							BigDecimal sheetAmountCurrent = baseProject2.getSheetAmount();
							//计算所有的订单的总金额
							projectAmount = projectAmount.add(sheetAmountCurrent);
							//税率
							BigDecimal ratePercent = new BigDecimal("1.06");
							String sheetCode = baseProject2.getContractCode();
							Integer projectId = BaseHelpUtils.getIntValue(baseProject2.getProjectId());
							//取出当前时间年份和月份
							Calendar cal = Calendar.getInstance();
							int month = cal.get(Calendar.MONTH) + 1;
							int year = cal.get(Calendar.YEAR);
							RevenueStatisticalRecord revenueStatisticalRecordDao = new RevenueStatisticalRecord();
							//取出当前时间的进度
							QueryRevenueStatisticalOfRevenue q = new QueryRevenueStatisticalOfRevenue();
							ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
							c.setYear(year);
							c.setMonth(month);
							c.setSheetCode(sheetCode);
							c.setProjectId(projectId);
							CustomRevenueStatisticalOfRevenueHandler cc = new CustomRevenueStatisticalOfRevenueHandler();
							BaseCollection<BaseRevenueStatisticalOfRevenue> result = cc.getResult(c);
							List<BaseRevenueStatisticalOfRevenue> resultList = result.getCollections();
							BigDecimal totalPercent1 = new BigDecimal("0");
							if(!BaseHelpUtils.isNullOrEmpty(resultList)){
								BaseRevenueStatisticalOfRevenue aa = resultList.get(0);
								ratePercent = new BigDecimal("1.06");
								totalPercent1 = aa.getTotalPercent();
							}
							//取出2017年12月时间的进度
							QueryRevenueStatisticalOfRevenue q1 = new QueryRevenueStatisticalOfRevenue();
							ConditionRevenueStatisticalOfRevenue c1 = new ConditionRevenueStatisticalOfRevenue();
							c1.setYear(2017);
							c1.setMonth(12);
							c1.setSheetCode(sheetCode);
							c1.setProjectId(projectId);
							CustomRevenueStatisticalOfRevenueHandler cc1 = new CustomRevenueStatisticalOfRevenueHandler();
							BaseCollection<BaseRevenueStatisticalOfRevenue> result1 = cc1.getResult(c1);
							List<BaseRevenueStatisticalOfRevenue> resultList1 = result1.getCollections();
							BigDecimal totalPercent2 = new BigDecimal("0");
							if(!BaseHelpUtils.isNullOrEmpty(resultList1)){
								BaseRevenueStatisticalOfRevenue aa1 = resultList1.get(0);
								totalPercent2 = aa1.getTotalPercent();
							}

							BigDecimal sheetAmount = sheetAmountCurrent.divide(ratePercent,2,BigDecimal.ROUND_HALF_EVEN);
							revenue = sheetAmount.multiply(totalPercent1.subtract(totalPercent2));
							totalRevenue = totalRevenue.add(revenue);
						}
					}
				}
				if (totalRevenue.compareTo(BigDecimal.ZERO) == 0) {
					rate = new BigDecimal(0);
				}
				else {
					rate = (totalRevenue.multiply(new BigDecimal("1.06"))).divide(projectAmount,4,BigDecimal.ROUND_DOWN);
					rate = rate.multiply(new BigDecimal(100));
				}
				//更新进度百分比
				baseContractDistribution.setRateOfProgress(rate);
				cDistributionDao.clear();
				cDistributionDao.setDataFromBase(baseContractDistribution);
				cDistributionDao.update();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		UpdateRateOfProgress updateRateOfProgress = new UpdateRateOfProgress();
		updateRateOfProgress.run();
	}

}
