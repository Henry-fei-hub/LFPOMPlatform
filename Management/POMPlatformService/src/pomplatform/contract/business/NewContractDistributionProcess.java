package pomplatform.contract.business;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.contract.bean.BaseShowContractDistributionNew;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler;
import pomplatform.revenueStatistical.query.QueryRevenueStatisticalOfRevenue;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Logger;

public class NewContractDistributionProcess implements GenericProcessor{
	private static final Logger __logger = Logger.getLogger("");
	//创建contractDistribution
	private static final String SAVECONTRACTDISTRIBUTION = "saveContractDistribution";
	//更新营收
	private static final String UPDATEREVENUE = "updateRevenue";
	//团队组建
	private static final String TEAMBUILDING = "teamBuilding";
	//分配积分
	private static final String SETTLEMENTPERCENTAGE = "settlementPercentage";
	//搜索时间段的运营的营收
	private static final String CALCULATE_INTERVAL_REVENUE = "calculateIntervalRevenue";
	//导出分配团队的所有的数据
	private static final String EXPORTCONTRACTDISTRIBUTIONDATA = "exportContractDistributionData";

	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "optType");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result)) {
			switch (optType) {
			case SAVECONTRACTDISTRIBUTION:
				return saveContractDistribution(result);
			case UPDATEREVENUE:
				return updateRevenue(result);
			case TEAMBUILDING:
				return teamBuilding(result);
			case CALCULATE_INTERVAL_REVENUE:
				return calculateIntervalRevenue(result);
				case EXPORTCONTRACTDISTRIBUTIONDATA:
				return 	exportContractDistributionData(result);
			default:
				break;
			}
		}
		return null;
	}

	//导出所有的分配团队的数据
	private String exportContractDistributionData(Map<String,Object> result) {

		return null;
	}

	//搜索时间段的运营的营收
	private static String calculateIntervalRevenue(Map<String, Object> condition) throws SQLException, ParseException {
		int startYearTime = BaseHelpUtils.getIntValue(condition.get("startYearTime"));
		int startMonthTime = BaseHelpUtils.getIntValue(condition.get("startMonthTime"));
		int endYearTime = BaseHelpUtils.getIntValue(condition.get("endYearTime"));
		int endMonthTime = BaseHelpUtils.getIntValue(condition.get("endMonthTime"));
		int currentPage = BaseHelpUtils.getIntValue(condition.get("currentPage"));
		String contractCode = BaseHelpUtils.getString(condition.get("contractCode")).trim();
		String contractName = BaseHelpUtils.getString(condition.get("contractName")).trim();
		String plateIds = BaseHelpUtils.getString(condition.get("plateIds"));
		Boolean isOriginal = null;
		Boolean isSubProject = null;
		//定义营收
		BigDecimal temp = BigDecimal.ZERO;
		//传递的参数不为空时进行计算时间段的营收
		if (startYearTime != 0 && startMonthTime != 0 && endYearTime != 0 && endMonthTime != 0) {
			//当项目编号为空的时候计算该部门下的所有的项目的营收
			if (BaseHelpUtils.isNullOrEmpty(contractCode) && BaseHelpUtils.isNullOrEmpty(contractName)){
				ContractDistribution cDistributionDao = new ContractDistribution();
				//查询该部门下的所有的营收订单
				cDistributionDao.setConditionDeleteFlag("=",0);
				String sql = "";
				if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
					int line1 = currentPage * 20 -19;
					int line2 =  20;
					sql = String.format(" plate_id in(%1$s)  limit "+line2+" OFFSET "+line1,plateIds);
				}else {
					int line1 = currentPage * 20 -19;
					int line2 =  20;
					sql = String.format(" 1 = 1 limit "+line2+" OFFSET "+line1);
				}

				List<BaseContractDistribution> contractDistributions = cDistributionDao.conditionalLoad(sql);
				List<BaseShowContractDistributionNew> lists = new ArrayList<>();
				BaseCollection bc = new BaseCollection<>();
				for (BaseContractDistribution baseContractDistribution : contractDistributions) {
					Integer contractId = baseContractDistribution.getContractId();
					BaseContract baseContract = new BaseContract();
					//提成
					BigDecimal totalRevenue = new BigDecimal("0");
					BigDecimal projectAmount = new BigDecimal("0");
					//订单的营收
					BigDecimal orderIncome = BigDecimal.ZERO;
					BigDecimal totalOrderIncome = BigDecimal.ZERO;
					if (contractId != null){
						Contract contractDao = new Contract();
						contractDao.setContractId(contractId);
						contractDao.load();
						//查询合同
						baseContract= contractDao.generateBase();
						//根据合同查询合同下的所有的订单
						Project dao = new Project();
						dao.setConditionContractId("=", contractId);
						List<BaseProject> beans = dao.conditionalLoad();
						//判断合同下面是否有项目编号
						String projectCode = null;
						if (!BaseHelpUtils.isNullOrEmpty(baseContract)) {
							projectCode = baseContract.getProjectCode();
						}
						if (!BaseHelpUtils.isNullOrEmpty(projectCode)) {
							MainProject mainProjectDao = new MainProject();
							mainProjectDao.setConditionProjectCode("=", projectCode);
							BaseMainProject baseMainProject = mainProjectDao.executeQueryOneRow();
							if (!BaseHelpUtils.isNullOrEmpty(baseMainProject)) {
								isOriginal = baseMainProject.getIsOriginal();
								isSubProject = baseMainProject.getIsSubProject();
							}
						}
						//合同下面有订单
						if (beans.size() != 0){
							for (BaseProject baseProject : beans) {
								int projectId = baseProject.getProjectId();
								//获取订单的编号，截取业态（订单表内的业态信息不全）
								int businessType = baseProject.getBusinessType();
								String sheetCode = baseProject.getContractCode();
								Integer projectId1 = baseProject.getProjectId();
								//订单的金额
								BigDecimal sheetAmountCurrent = baseProject.getSheetAmount();
								//计算所有的订单的总金额
								projectAmount = projectAmount.add(sheetAmountCurrent);
								//税率
								BigDecimal ratePercent = new BigDecimal("1.06");
								//计算起始时间的进度
//								RevenueStatisticalRecord revenueStatisticalRecordDao = new RevenueStatisticalRecord();
								QueryRevenueStatisticalOfRevenue q = new QueryRevenueStatisticalOfRevenue();
								ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
								c.setYear(endYearTime);
								c.setMonth(endMonthTime);
								c.setSheetCode(sheetCode);
								c.setProjectId(projectId1);
								CustomRevenueStatisticalOfRevenueHandler cc = new CustomRevenueStatisticalOfRevenueHandler();
								BaseCollection<BaseRevenueStatisticalOfRevenue> result = cc.getResult(c);
								List<BaseRevenueStatisticalOfRevenue> resultList = result.getCollections();
								BigDecimal totalPercent1 = new BigDecimal("0");
								if(!BaseHelpUtils.isNullOrEmpty(resultList)){
									BaseRevenueStatisticalOfRevenue aa = resultList.get(0);
									ratePercent = new BigDecimal("1.06");
									totalPercent1 = aa.getTotalPercent();
								}
								//取出结束时间的进度
								QueryRevenueStatisticalOfRevenue q1 = new QueryRevenueStatisticalOfRevenue();
								ConditionRevenueStatisticalOfRevenue c1 = new ConditionRevenueStatisticalOfRevenue();
								c1.setYear(startYearTime);
								c1.setMonth(startMonthTime);
								c1.setSheetCode(sheetCode);
								c1.setProjectId(projectId1);
								CustomRevenueStatisticalOfRevenueHandler cc1 = new CustomRevenueStatisticalOfRevenueHandler();
								BaseCollection<BaseRevenueStatisticalOfRevenue> result1 = cc1.getResult(c1);
								List<BaseRevenueStatisticalOfRevenue> resultList1 = result1.getCollections();
								BigDecimal totalPercent2 = new BigDecimal("0");
								if(!BaseHelpUtils.isNullOrEmpty(resultList1)){
									BaseRevenueStatisticalOfRevenue aa1 = resultList1.get(0);
									totalPercent2 = aa1.getTotalPercent();
								}

								BigDecimal revenue = null;
								BigDecimal sheetAmount = sheetAmountCurrent.divide(ratePercent,2,BigDecimal.ROUND_HALF_EVEN);
								//计算每个订单下面的营收
								//没有项目的编号(订单按业态来计算营收)
								if (BaseHelpUtils.isNullOrEmpty(projectCode)) {
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
									totalRevenue = totalRevenue.add(revenue);
								}else{
									//不是原创项目(营收提成系数1.1%)
									if (!isOriginal) {
										revenue = sheetAmount.multiply(new BigDecimal("0.011")).multiply(totalPercent1.subtract(totalPercent2));
										totalRevenue = totalRevenue.add(revenue);
									}else{
										if (isSubProject) {
											revenue = sheetAmount.multiply(new BigDecimal("0.014")).multiply(totalPercent1.subtract(totalPercent2));
											totalRevenue = totalRevenue.add(revenue);
										}else{
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
											//计算订单的营收(用于计算项目的进度)
											BigDecimal temp1 = sheetAmountCurrent.divide(ratePercent, 2, BigDecimal.ROUND_HALF_EVEN);
											orderIncome = temp1.multiply(totalPercent1.subtract(totalPercent2));
											totalOrderIncome = totalOrderIncome.add(orderIncome);
											//订单的提成
											totalRevenue = totalRevenue.add(revenue);
										}
									}
								}
							}
						}
					}
					BaseShowContractDistributionNew bean = new BaseShowContractDistributionNew();
					bean.setOrderId(baseContractDistribution.getOrderId());
					bean.setContractId(contractId);
					bean.setContractName(baseContract.getContractName());
					bean.setOrderStatus(baseContractDistribution.getOrderStatus());
					bean.setSigningMoneySum(baseContract.getSigningMoneySum());
					BigDecimal rateOfProgress = new BigDecimal("0");
					//当totalRevenue为0时有异常
					if (projectAmount.compareTo(BigDecimal.ZERO) == 0){
						rateOfProgress = new BigDecimal("0");
					}
					else{
						rateOfProgress = (totalOrderIncome.multiply(new BigDecimal("1.06"))).divide(projectAmount,4,BigDecimal.ROUND_DOWN);
						rateOfProgress = rateOfProgress.multiply(new BigDecimal(100));
					}
					bean.setRateOfProgress(rateOfProgress);
					bean.setAmount(totalRevenue);
					lists.add(bean);
				}
				bc.setCollections(lists);
				ContractDistribution cDistributionDao1 = new ContractDistribution();
				//查询该部门下的所有的营收订单
				cDistributionDao1.setConditionDeleteFlag("=",0);
				String sql1 = "";
				if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
					sql1 = String.format(" plate_id in(%1$s) ",plateIds);
				}

				List<BaseContractDistribution> contractDistributions2 = cDistributionDao1.conditionalLoad(sql1);
				bc.setTotalPages(contractDistributions2.size() / 20 + 1) ;
				bc.setTotalLines(20);
				bc.setCollections(lists);
				return bc.toJSON(0,"");
			}else {//合同编号不为空，则查询合同下的订单
				BigDecimal totalRevenue = new BigDecimal("0");
				BigDecimal projectAmount = new BigDecimal("0");
				//订单的营收
				BigDecimal orderIncome = BigDecimal.ZERO;
				BigDecimal totalOrderIncome = BigDecimal.ZERO;
				if (contractCode != null) {
					Contract contractDao = new Contract();
					if (!BaseHelpUtils.isNullOrEmpty(contractCode)){
						contractDao.setConditionContractCode("=",contractCode);
					}
					String sql = "";
					if (!BaseHelpUtils.isNullOrEmpty(contractName)){
						sql = String.format(" contract_name like %1$s","'" + contractName + "'");
					}
					BaseContract baseContract = contractDao.executeQueryOneRow(sql);
					Integer contractId = baseContract.getContractId();
					//查询contractDistribution
					ContractDistribution contractDistributionDao = new ContractDistribution();
					contractDistributionDao.setConditionContractId("=",contractId);
					BaseContractDistribution baseContractDistribution = contractDistributionDao.executeQueryOneRow();
					//根据合同查询合同下的所有的订单
					Project dao = new Project();
					dao.setConditionContractId("=", contractId);
					List<BaseProject> beans = dao.conditionalLoad();
					//判断合同下面是否有项目编号
					String projectCode = null;
					if (!BaseHelpUtils.isNullOrEmpty(baseContract)) {
						projectCode = baseContract.getProjectCode();
					}
					if (!BaseHelpUtils.isNullOrEmpty(projectCode)) {
						MainProject mainProjectDao = new MainProject();
						mainProjectDao.setConditionProjectCode("=", projectCode);
						BaseMainProject baseMainProject = mainProjectDao.executeQueryOneRow();
						if (!BaseHelpUtils.isNullOrEmpty(baseMainProject)) {
							isOriginal = baseMainProject.getIsOriginal();
							isSubProject = baseMainProject.getIsSubProject();
						}
					}
					//合同下面有订单
					if (beans.size() != 0) {
						for (BaseProject baseProject : beans) {
							//获取订单的编号，截取业态（订单表内的业态信息不全）
							int businessType = baseProject.getBusinessType();
							String sheetCode = baseProject.getContractCode();
							Integer projectId = baseProject.getProjectId();
							//订单的金额
							BigDecimal sheetAmountCurrent = baseProject.getSheetAmount();
							//计算所有的订单的总金额
							projectAmount = projectAmount.add(sheetAmountCurrent);
							//税率
							BigDecimal ratePercent = new BigDecimal("1.06");
							//计算起始时间的进度
//								RevenueStatisticalRecord revenueStatisticalRecordDao = new RevenueStatisticalRecord();
							QueryRevenueStatisticalOfRevenue q = new QueryRevenueStatisticalOfRevenue();
							ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
							c.setYear(endYearTime);
							c.setMonth(endMonthTime);
							c.setSheetCode(sheetCode);
							c.setProjectId(projectId);
							CustomRevenueStatisticalOfRevenueHandler cc = new CustomRevenueStatisticalOfRevenueHandler();
							BaseCollection<BaseRevenueStatisticalOfRevenue> result = cc.getResult(c);
							List<BaseRevenueStatisticalOfRevenue> resultList = result.getCollections();
							BigDecimal totalPercent1 = new BigDecimal("0");
							if (!BaseHelpUtils.isNullOrEmpty(resultList)) {
								BaseRevenueStatisticalOfRevenue aa = resultList.get(0);
								ratePercent = new BigDecimal("1.06");
								totalPercent1 = aa.getTotalPercent();
							}
							//取出结束时间的进度
							QueryRevenueStatisticalOfRevenue q1 = new QueryRevenueStatisticalOfRevenue();
							ConditionRevenueStatisticalOfRevenue c1 = new ConditionRevenueStatisticalOfRevenue();
							c1.setYear(startYearTime);
							c1.setMonth(startMonthTime);
							c1.setSheetCode(sheetCode);
							c1.setProjectId(projectId);
							CustomRevenueStatisticalOfRevenueHandler cc1 = new CustomRevenueStatisticalOfRevenueHandler();
							BaseCollection<BaseRevenueStatisticalOfRevenue> result1 = cc1.getResult(c1);
							List<BaseRevenueStatisticalOfRevenue> resultList1 = result1.getCollections();
							BigDecimal totalPercent2 = new BigDecimal("0");
							if (!BaseHelpUtils.isNullOrEmpty(resultList1)) {
								BaseRevenueStatisticalOfRevenue aa1 = resultList1.get(0);
								totalPercent2 = aa1.getTotalPercent();
							}

							BigDecimal revenue = null;
							BigDecimal sheetAmount = sheetAmountCurrent.divide(ratePercent, 2, BigDecimal.ROUND_HALF_EVEN);
							//计算每个订单下面的营收
							//没有项目的编号(订单按业态来计算营收)
							if (BaseHelpUtils.isNullOrEmpty(projectCode)) {
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
								totalRevenue = totalRevenue.add(revenue);
							} else {
								//不是原创项目(营收提成系数1.1%)
								if (!isOriginal) {
									revenue = sheetAmount.multiply(new BigDecimal("0.011")).multiply(totalPercent1.subtract(totalPercent2));
									totalRevenue = totalRevenue.add(revenue);
								} else {
									if (isSubProject) {
										revenue = sheetAmount.multiply(new BigDecimal("0.014")).multiply(totalPercent1.subtract(totalPercent2));
										totalRevenue = totalRevenue.add(revenue);
									} else {
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
//										sheetAmount = sheetAmountCurrent.divide(ratePercent,2,BigDecimal.ROUND_HALF_EVEN);
//										revenue = sheetAmount.multiply(totalPercent1.subtract(totalPercent2));
										//计算订单的营收(用于计算项目的进度)
										BigDecimal temp1 = sheetAmountCurrent.divide(ratePercent, 2, BigDecimal.ROUND_HALF_EVEN);
										orderIncome = temp1.multiply(totalPercent1.subtract(totalPercent2));
										totalOrderIncome = totalOrderIncome.add(orderIncome);
										//订单的提成
										totalRevenue = totalRevenue.add(revenue);
									}
								}
							}
						}
					}
					BaseCollection bc = new BaseCollection<>();
					BaseShowContractDistributionNew bean = new BaseShowContractDistributionNew();
					bean.setAmount(totalRevenue);
					BigDecimal rateOfProgress = new BigDecimal("0");
					//当totalRevenue为0时有异常
					if (projectAmount.compareTo(BigDecimal.ZERO) == 0){
						rateOfProgress = new BigDecimal("0");
					}
					else{
						rateOfProgress = (totalOrderIncome.multiply(new BigDecimal("1.06"))).divide(projectAmount,4,BigDecimal.ROUND_DOWN);
						rateOfProgress = rateOfProgress.multiply(new BigDecimal(100));
					}
					bean.setRateOfProgress(rateOfProgress);
 					bean.setContractId(contractId);
					bean.setContractName(baseContract.getContractName());
					bean.setSigningMoneySum(baseContract.getSigningMoneySum());
					bean.setOrderId(baseContractDistribution.getOrderId());
					bean.setOrderStatus(baseContractDistribution.getOrderStatus());
					ArrayList<BaseShowContractDistributionNew> lists = new ArrayList<>();
					lists.add(bean);

					ContractDistribution cDistributionDao1 = new ContractDistribution();
					//查询该部门下的所有的营收订单
					cDistributionDao1.setConditionDeleteFlag("=",0);
					String sql1 = "";
					if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
						sql1 = String.format(" plate_id in(%1$s) ",plateIds);
					}

					List<BaseContractDistribution> contractDistributions2 = cDistributionDao1.conditionalLoad(sql1);
					bc.setTotalPages(contractDistributions2.size() / 20 + 1) ;
					bc.setTotalLines(20);
					bc.setCollections(lists);
					return bc.toJSON(0,"");
				}

			}
		}
		return null;
	}

	//组建团队
	private String teamBuilding(Map<String, Object> result) throws SQLException {
		ThreadConnection.beginTransaction();
		int status = -1;
		BaseCollection<GenericBase> collection = new BaseCollection<>();
		Integer contractId = BaseHelpUtils.getIntValue(result, "contractId");
		int departmentRate = BaseHelpUtils.getIntValue(result, "departmentRate");
		boolean flag = true;
		//获取订单
		__logger.info("--------------------------------******" + departmentRate);
		TeamBuilding tDao = new TeamBuilding();
		tDao.setConditionContractId("=", contractId);
		List<BaseTeamBuilding> lists = tDao.conditionalLoad();
		//已经组建了团队
		if (lists.size() > 0) {
			//已经组建了团队的情况下先删除原有的团队
			tDao.clear();
			tDao.setConditionContractId("=",contractId);
			tDao.conditionalDelete();
			flag =false;
		}
		BaseTeamBuilding bean1 = new BaseTeamBuilding();
		if (BaseHelpUtils.isNullOrEmpty(contractId)) {
			throw new SQLException("获取合同ID失败");
		}
		ContractDistribution cDistributionDao = new ContractDistribution();
		cDistributionDao.setConditionContractId("=", contractId);
		BaseContractDistribution baseContractDistribution = cDistributionDao.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(baseContractDistribution)) {
			bean1.setDepartmentId(baseContractDistribution.getPlateId());
		}
		if (departmentRate > 0) {
			bean1.setRate(departmentRate);
			bean1.setContractId(contractId);
			bean1.setSettlement(new BigDecimal("0"));
			TeamBuilding dao = new TeamBuilding();
			dao.setDataFromBase(bean1);
			try {
				dao.save();
				status = 1;
			} catch (Exception e) {
				status = -1;
			}
		}
		List<Map<String, Object>> maps = (List<Map<String, Object>>)result.get("list");
		for (Map<String, Object> map : maps) {
			TeamBuilding dao2 =new TeamBuilding();
			BaseTeamBuilding bean2 = new BaseTeamBuilding();
			int employeeId = BaseHelpUtils.getIntValue(map, "employeeId");
			int employeeRate = BaseHelpUtils.getIntValue(map,"rate");
			if (employeeId > 0) {
				bean2.setEmployeeId(employeeId);
			}
			if (employeeRate > 0) {
				bean2.setRate(employeeRate);
			}
			bean2.setContractId(contractId);
			bean2.setSettlement(new BigDecimal("0"));
			dao2.setDataFromBase(bean2);
			try {
				dao2.save();
				status = 1;
			} catch (Exception e) {
				status = -1;
			}
		}

		//组建团队成功后在contractDistribution中设置一个已经分配团队的标识
        ContractDistribution contractDistribution = new ContractDistribution();
        contractDistribution.setConditionContractId("=",contractId);
        BaseContractDistribution bean = contractDistribution.executeQueryOneRow();
        bean.setOrderStatus(1);
        contractDistribution.setDataFromBase(bean);
        contractDistribution.update();
        ThreadConnection.commit();
		return collection.toJSON(status,null);
	}


	/**
	 * 更新营收
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String updateRevenue(Map<String, Object> result) throws SQLException {
		int status = -1;
		BaseCollection<GenericBase> collection = new BaseCollection<>();
		try {
			String orderId = BaseHelpUtils.getStringValue(result, "orderId");
			if (BaseHelpUtils.isNullOrEmpty(orderId)) {
				throw new SQLException("操作失败：传递参数失败");
			}
			ContractDistribution cDistributionDao = new ContractDistribution();
			cDistributionDao.setConditionOrderId("=", orderId);
			BaseContractDistribution baseContractDistribution = cDistributionDao.executeQueryOneRow();
			if (BaseHelpUtils.isNullOrEmpty(baseContractDistribution)) {
				throw new SQLException("操作失败：查询失败");
			}
			int contractId = baseContractDistribution.getContractId();
			int businessType = baseContractDistribution.getBusinessType();
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", contractId);
			params.put("businessType", businessType);
			BigDecimal totalRevenue = calculateRevenue(params);
			cDistributionDao.setAmount(totalRevenue);
			cDistributionDao.setUpdateTime(new Date());
			cDistributionDao.conditionalUpdate();
			status = 1;
			return collection.toJSON(status,"更新成功");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return collection.toJSON(status,"更新失败");
		}
		
	}


	/**
	 * 创建contractDistribution
	 * @param result
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private String saveContractDistribution(Map<String, Object> result) throws SQLException, ParseException {
		int status = -1;
		BaseCollection<BaseContractDistribution> bCollection = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		boolean flag = checkExist(contractId);
		//已经分配了营销团队
		if (flag){
			return bCollection.toJSON(status,"已经分配了营销团队");
		}
		//分配营销团队
		createContractDistribution(result);
		status = 1;
		return bCollection.toJSON(status,"");
	}


	/**
	 * 分配营销团队并且计算营收
	 * @param result
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private void createContractDistribution(Map<String, Object> result) throws SQLException, ParseException {
		int contractId = BaseHelpUtils.getIntValue(result,"contractId");
		int plateId = BaseHelpUtils.getIntValue(result, "plateId");
		int businessType = BaseHelpUtils.getIntValue(result, "businessType");
		int operator = BaseHelpUtils.getIntValue(result, "operator");
		Contract contractDao = new Contract();
		contractDao.setContractId(contractId);
		contractDao.load();
		BaseContract baseContract = contractDao.generateBase();
		if (!BaseHelpUtils.isNullOrEmpty(baseContract)) {
			Date contractDate = baseContract.getContractDate();
			String contractCode = baseContract.getContractCode();
			String orderId = contractCode +"."+"0"+ businessType + "-" + "88" + "-" + "889";
			//计算营销提成
			Map<String, Object> params = new HashMap<>();
			params.put("businessType", businessType); 
			params.put("contractId", contractId); 
			params.put("orderId", orderId); 
			BigDecimal amount = calculateRevenue(params);
			ContractDistribution contractDistributionDao = new ContractDistribution();
			contractDistributionDao.setContractId(contractId);
			contractDistributionDao.setPlateId(plateId);
			contractDistributionDao.setBusinessType(businessType);
			contractDistributionDao.setOperator(operator);
			contractDistributionDao.setContractDate(contractDate);
			contractDistributionDao.setOrderId(orderId);
			contractDistributionDao.setAmount(amount);
			contractDistributionDao.save();
		}
		
	}
	
	/**
	 * 计算营收
	 * @param params
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("unused")
	public static BigDecimal calculateRevenue(Map<String, Object> params) throws SQLException, ParseException {
		int contractId = BaseHelpUtils.getIntValue(params, "contractId");
//		int businessType = BaseHelpUtils.getIntValue(params, "businessType");
		String contractCode = BaseHelpUtils.getStringValue(params, "contractCode");
		String orderId = BaseHelpUtils.getStringValue(params, "orderId");
		Contract contractDao = new Contract();
		contractDao.setContractId(contractId);
		contractDao.load();
		Boolean isOriginal = null;
		Boolean isSubProject = null;
		BaseContract baseContract = contractDao.generateBase();
		//判断合同下面是否有项目编号
		String projectCode = null;
		if (!BaseHelpUtils.isNullOrEmpty(baseContract)) {
			projectCode = baseContract.getProjectCode();
		}
		BaseMainProject baseMainProject = null;
		if (!BaseHelpUtils.isNullOrEmpty(projectCode)) {
			MainProject mainProjectDao = new MainProject();
			mainProjectDao.setConditionProjectCode("=", projectCode);
			baseMainProject = mainProjectDao.executeQueryOneRow();
			if (!BaseHelpUtils.isNullOrEmpty(baseMainProject)) {
				isOriginal = baseMainProject.getIsOriginal();
				isSubProject = baseMainProject.getIsSubProject();
	 		}
		}
		//查询合同下的订单
		Project dao = new Project();
		dao.setConditionContractId("=", contractId);
		List<BaseProject> beans = dao.conditionalLoad();
		BigDecimal totalRevenue = new BigDecimal("0");
			//合同下有订单
			if (beans.size() != 0) {
				for (BaseProject baseProject : beans) {
					int projectId = baseProject.getProjectId();
					//获取订单的编号，截取业态（订单表内的业态信息不全）
//				String tempProjectCode = baseProject.getContractCode();
//				String temp1 = tempProjectCode.split(".")[2];
//				int businessType = Integer.parseInt(temp1.split("-")[0]);
					int businessType = baseProject.getBusinessType();
					String sheetCode = baseProject.getContractCode();
					//订单的金额
					BigDecimal sheetAmountCurrent = baseProject.getSheetAmount();
					//税率
					BigDecimal ratePercent = new BigDecimal("1.06");
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
					if (!BaseHelpUtils.isNullOrEmpty(resultList)) {
						BaseRevenueStatisticalOfRevenue aa = resultList.get(0);
						ratePercent = new BigDecimal("1.06");
						totalPercent1 = aa.getTotalPercent();
					}
//				//查询当前时间下的进度
//				revenueStatisticalRecordDao.setConditionYear("=", year);
//				revenueStatisticalRecordDao.setConditionMonth("=", month);
//				revenueStatisticalRecordDao.setConditionProjectId("=", projectId);
//				BaseRevenueStatisticalRecord baseRevenueStatisticalRecord = revenueStatisticalRecordDao.executeQueryOneRow();
//				BigDecimal totalPercent1 = new BigDecimal("0");
//				if (!BaseHelpUtils.isNullOrEmpty(baseRevenueStatisticalRecord)) {
//					if (!BaseHelpUtils.isNullOrEmpty(baseRevenueStatisticalRecord.getTotalPercent())) {
//						totalPercent1 = baseRevenueStatisticalRecord.getTotalPercent();
//						ratePercent = baseRevenueStatisticalRecord.getRatePercent();
//					}
//				}
//				//计算2017年12月的进度
//				revenueStatisticalRecordDao.setConditionYear("=", 2017);
//				revenueStatisticalRecordDao.setConditionMonth("=", 12);
//				revenueStatisticalRecordDao.setConditionProjectId("=", projectId);
//				BaseRevenueStatisticalRecord baseRevenueStatisticalRecord2 = revenueStatisticalRecordDao.executeQueryOneRow();
//				BigDecimal totalPercent2 = new BigDecimal("0");
//				if (!BaseHelpUtils.isNullOrEmpty(baseRevenueStatisticalRecord2)) {
//					if (!BaseHelpUtils.isNullOrEmpty(baseRevenueStatisticalRecord2.getTotalPercent())) {
//						totalPercent2 = baseRevenueStatisticalRecord2.getTotalPercent();
//					}
//				}
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
					if (!BaseHelpUtils.isNullOrEmpty(resultList1)) {
						BaseRevenueStatisticalOfRevenue aa1 = resultList1.get(0);
						totalPercent2 = aa1.getTotalPercent();
					}

					BigDecimal revenue = null;
					BigDecimal sheetAmount = sheetAmountCurrent.divide(ratePercent, 2, BigDecimal.ROUND_HALF_EVEN);
					//计算每个订单下面的营收
					//没有项目的编号(订单按业态来计算营收)
					if (!BaseHelpUtils.isNullOrEmpty(projectCode)) {
						//不是原创项目(营收提成系数1.1%)
						if(BaseHelpUtils.isNullOrEmpty(isOriginal) || BaseHelpUtils.isNullOrEmpty(isSubProject)){
							return new BigDecimal("-999999");
						}
						if (!isOriginal) {
							revenue = sheetAmount.multiply(new BigDecimal("0.011")).multiply(totalPercent1.subtract(totalPercent2));
							totalRevenue = totalRevenue.add(revenue);
						} else {
							if (isSubProject) {
								revenue = sheetAmount.multiply(new BigDecimal("0.014")).multiply(totalPercent1.subtract(totalPercent2)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
								totalRevenue = totalRevenue.add(revenue);
							} else {
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
								totalRevenue = totalRevenue.add(revenue);
							}
						}
					} else {
						if (BaseHelpUtils.isNullOrEmpty(businessType)) {
							return new BigDecimal("-999999");
						}
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
						totalRevenue = totalRevenue.add(revenue);
					}
				}
			}
		return totalRevenue;
	}

	/**
	 * 检查是否已经创建contractDistribution
	 * @param contractId·
	 * @return
	 * @throws SQLException 
	 */
	private boolean checkExist(int contractId) throws SQLException {
		ContractDistribution dao = new ContractDistribution();
		dao.setConditionContractId("=", contractId);
		BaseContractDistribution bean = dao.executeQueryOneRow();
		if (BaseHelpUtils.isNullOrEmpty(bean)) {
			return false;
		}
		String orderId = bean.getOrderId();
		if (BaseHelpUtils.isNullOrEmpty(orderId)) {
			return true;
		}
		return true;
	}
	
	/**
	 * 组建团队时分配营收提成
	 * @throws SQLException 
	 */
	public  static void settlementPercentage(int contractDistributionId) throws SQLException{
		ThreadConnection.beginTransaction();
		ContractDistribution dao = new ContractDistribution();
		dao.setContractDistributionId(contractDistributionId);
		dao.load();
		BaseContractDistribution baseContractDistribution = dao.generateBase();
			ContractDistribution dao1 = new ContractDistribution();
			String orderId = baseContractDistribution.getOrderId();
			int plateId = baseContractDistribution.getPlateId();
			PlateRecord plateRecord = new PlateRecord();
			String palteName = "";
			if (!BaseHelpUtils.isNullOrEmpty(plateId)) {
				plateRecord.setConditionPlateId("=", plateId);
				BasePlateRecord basePlateRecord = plateRecord.executeQueryOneRow();
				if (!BaseHelpUtils.isNullOrEmpty(basePlateRecord)) {
					palteName = basePlateRecord.getPlateName();
				}
			}
			int businessType = baseContractDistribution.getBusinessType();
			int contractId = baseContractDistribution.getContractId();
			Contract contractDao = new Contract();
			contractDao.setContractId(contractId);
			contractDao.load();
			BaseContract baseContract = contractDao.generateBase();
			String contractCode = "";
			String contractName = "";
			if (!BaseHelpUtils.isNullOrEmpty(baseContract)) {
				contractCode = baseContract.getContractCode();
				contractName = baseContract.getContractName();
			}
			BigDecimal currentAmount = new BigDecimal("0");
				currentAmount = baseContractDistribution.getAmount();
			//记录流水
			CommissionSettlementRecord commissionSettlementRecordDao = new CommissionSettlementRecord();
			commissionSettlementRecordDao.setOrderId(orderId);
			commissionSettlementRecordDao.setCountType(3);
			commissionSettlementRecordDao.setAmount(currentAmount);
			commissionSettlementRecordDao.setDepartmentId(14);
			commissionSettlementRecordDao.setSettlementType(2);
			commissionSettlementRecordDao.save();
			BaseCommissionSettlementRecord bean = commissionSettlementRecordDao.generateBase();
			//营销一级账户所需结算的积分
			AccountManageProcess accountManageProcess = new AccountManageProcess();
			accountManageProcess.onSavePlateAccount1(14, bean.getCommissionSettlementRecordId(), 26, currentAmount, bean.getSettlementTime(),contractCode+"——"+contractName+"——"+"提成分配支出"+"("+palteName+")", -1);
			
			TeamBuilding teamBuildingDao = new TeamBuilding();
			teamBuildingDao.setConditionOrderId("=", orderId);
			List<BaseTeamBuilding> baseTeamBuildings = teamBuildingDao.conditionalLoad();
			for (BaseTeamBuilding baseTeamBuilding : baseTeamBuildings) {
				//分配部门预留的积分
				if (!BaseHelpUtils.isNullOrEmpty(baseTeamBuilding.getDepartmentId())) {
					int departmentId = baseTeamBuilding.getDepartmentId();
					double rate = (double)baseTeamBuilding.getRate()/(double)100;
					BigDecimal settlement = currentAmount.multiply(new BigDecimal(rate));
					//在团队组建表中记录
					teamBuildingDao.setSettlement(settlement);
					teamBuildingDao.conditionalUpdate();
					
					//记录流水
					CommissionSettlementRecord commissionSettlementRecordDao1 = new CommissionSettlementRecord();
					commissionSettlementRecordDao1.setOrderId(orderId);
					commissionSettlementRecordDao1.setCountType(2);
					commissionSettlementRecordDao1.setDepartmentId(departmentId);
					commissionSettlementRecordDao1.setAmount(settlement);
					commissionSettlementRecordDao1.setSettlementType(1);
					commissionSettlementRecordDao1.save();
					BaseCommissionSettlementRecord bean1 = commissionSettlementRecordDao1.generateBase();
					//分配积分到部门账户
					AccountManageProcess accountManageProcess1 = new AccountManageProcess();
					accountManageProcess1.onSavePlateAccount1(departmentId, bean1.getCommissionSettlementRecordId(), 25, settlement, bean1.getSettlementTime(), contractCode+"——"+contractName+"——"+"提成分配收入", -1);
				}
				//分配个人的积分
				if (!BaseHelpUtils.isNullOrEmpty(baseTeamBuilding.getEmployeeId())) {
					int employeeId = baseTeamBuilding.getEmployeeId();
					double rate = (double)baseTeamBuilding.getRate()/(double)100;
					BigDecimal settlement = currentAmount.multiply(new BigDecimal(rate));
					//在团队组建表中记录
					teamBuildingDao.setSettlement(settlement);
					teamBuildingDao.conditionalUpdate();
					
					//记录流水
					CommissionSettlementRecord commissionSettlementRecordDao1 = new CommissionSettlementRecord();
					commissionSettlementRecordDao1.setOrderId(orderId);
					commissionSettlementRecordDao1.setCountType(1);
					commissionSettlementRecordDao1.setEmployeeId(employeeId);
					commissionSettlementRecordDao1.setAmount(settlement);
					commissionSettlementRecordDao1.setSettlementType(1);
					commissionSettlementRecordDao1.save();
					BaseCommissionSettlementRecord bean2 = commissionSettlementRecordDao1.generateBase();
					//分配积分到个人账户
					AccountManageProcess accountManageProcess1 = new AccountManageProcess();
					accountManageProcess1.onSaveEmployeeAccount1(employeeId, bean2.getCommissionSettlementRecordId(), 20, settlement, bean2.getSettlementTime(), contractCode+"-"+contractName+"-"+"提成分配收入", -1);
				}
			}
		ThreadConnection.commit();
	}
	
	public static void main(String[] args) throws Exception {
		String ss = "{\"optType\": \"calculateIntervalRevenue\",\"startYearTime\":\"2017\",\"startMonthTime\":\"12\",\"endYearTime\":\"2019\",\"endMonthTime\":\"1\",\"plateIds\":\"36\",\"contractCode\":\"BP.201707001\"}";
		NewContractDistributionProcess process = new NewContractDistributionProcess();
		HashMap<String, Object> params = new HashMap<>();
//		params.put("contractId" , 951);
		process.execute(ss , null);
//		calculateRevenue(params);
//		process.execute(ss, null);
//		System.out.println();
//		String plateIds = "36";
//		ContractDistribution cDistributionDao = new ContractDistribution();
//		//查询该部门下的所有的营收订单
//		cDistributionDao.setConditionDeleteFlag("=",0);
//		String sql = String.format(" plate_id in(%1$s)",plateIds);
//		BaseShowContractDistributionNew bean = new BaseShowContractDistributionNew();
//		List<BaseContractDistribution> contractDistributions = cDistributionDao.conditionalLoad(sql);
//        ContractDistribution contractDistribution = new ContractDistribution();
//        contractDistribution.setConditionOrderId("=","JA.201711004.02-88-889");
//        BaseContractDistribution bean = contractDistribution.executeQueryOneRow();
//        bean.setOrderStatus(1);
//        contractDistribution.setDataFromBase(bean);
//        contractDistribution.update();
	}
}
