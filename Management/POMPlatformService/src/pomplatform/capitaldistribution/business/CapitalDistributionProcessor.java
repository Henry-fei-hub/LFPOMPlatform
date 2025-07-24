package pomplatform.capitaldistribution.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseCapitalDistribution;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.CustomBaseCapitalDistribution;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CapitalDistribution;
import com.pomplatform.db.dao.CapitalLog;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.capitaldistribution.bean.BaseAutoFitInfo;
import pomplatform.capitaldistribution.bean.BaseGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.BaseGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.bean.BaseLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.BaseSearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.BaseSumCapitalBorrowMoney;
import pomplatform.capitaldistribution.bean.BaseSumCapitalDistribution;
import pomplatform.capitaldistribution.bean.BaseSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionAutoFitInfo;
import pomplatform.capitaldistribution.bean.ConditionGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.ConditionGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.bean.ConditionLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.ConditionSearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumCapitalBorrowMoney;
import pomplatform.capitaldistribution.bean.ConditionSumCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.query.QueryAutoFitInfo;
import pomplatform.capitaldistribution.query.QueryGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.query.QueryGetProjectSureAndLeftInteger;
import pomplatform.capitaldistribution.query.QueryLeftCapitalAmount;
import pomplatform.capitaldistribution.query.QuerySearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.query.QuerySumCapitalBorrowMoney;
import pomplatform.capitaldistribution.query.QuerySumCapitalDistribution;
import pomplatform.capitaldistribution.query.QuerySumDepartmentCapitalDistribution;
import pomplatform.common.utils.StaticUtils;

public class CapitalDistributionProcessor implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {
		case "loadCapitalDistributionOfProject":
			return loadCapitalDistributionOfProject(params);
		case "prepareCapitalDistributionInfo":
			return prepareCapitalDistributionInfo(params);
		case "saveCapitalDistribution":
			return saveCapitalDistribution(params);
		case "lockOrUnlockCapitalDistribution":
			return lockOrUnlockCapitalDistribution(params);
		case "isOkToFit":
			return isOkToFit(params);
		case "getAllDistribution":
			return getAllDistribution(params);
		case "deleteCapitalDistribution":
			return deleteCapitalDistribution(params);
		case "autoFit":
			return autoFit(params);
		case "autoFitByProjectSheetAmount":// 按订单合同金额自动回款分配
			return autoFitByProjectSheetAmount(params);
		case "capitalDistributionAnalyze":
			return capitalDistributionAnalyze(params);
		case "selectPlateIdForDistribution":
			return selectPlateIdForDistribution(params);
		default:
			return null;
		}
	}

	public String loadCapitalDistributionOfProject(Map<String, Object> params) throws Exception {
		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
		Map<Object, Object> map = new HashMap<>();
		BaseCollection bc = new BaseCollection<>();
		if (contractId > 0) {
			Project pDao = new Project();
			pDao.setConditionContractId("=", contractId);
			pDao.unsetSelectFlags();
			pDao.setSelectProjectId(true);
			List<BaseProject> projectList = pDao.conditionalLoad("order by " + BaseProject.CS_PROJECT_ID);
			if (null != projectList && !projectList.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				ConditionSearchProjectCapitalDistribution pCondition = new ConditionSearchProjectCapitalDistribution();
				pCondition.setContractId(contractId);
				QuerySearchProjectCapitalDistribution pQuery = new QuerySearchProjectCapitalDistribution();
				BaseCollection<BaseSearchProjectCapitalDistribution> pCollection = pQuery.executeQuery(null,
						pCondition);
				if (null != pCollection && null != pCollection.getCollections()
						&& !pCollection.getCollections().isEmpty()) {
					Capital capitalDao = new Capital();
					capitalDao.setConditionContractId("=", contractId);
					Object[] moneyAttributeArr = {StaticUtils.CAPITAL_MONEY_ATTRIBUTION_1, StaticUtils.CAPITAL_MONEY_ATTRIBUTION_11, StaticUtils.CAPITAL_MONEY_ATTRIBUTION_13};
					capitalDao.addCondition(BaseCapital.CS_MONEY_ATTRIBUTE, "in", moneyAttributeArr);
					List<BaseCapital> capitalList = capitalDao
							.conditionalLoad("order by " + BaseCapital.CS_HAPPEN_DATE + " desc");
					map.put("capitalAmount", capitalList.size());
					List<BaseSearchProjectCapitalDistribution> pList = pCollection.getCollections();
					int projectSize = projectList.size();
					Number[] arr = new Number[projectSize];
					int number = 0;
					int orderNo = 0;
					// 待回款数据
					for (BaseProject projectBean : projectList) {
						if (sb.length() > 0) {
							sb.append(",");
						}
						sb.append(projectBean.getProjectId());
						for (int i = 0; i < pList.size(); i++) {
							BaseSearchProjectCapitalDistribution bean = pList.get(i);
							if (bean.getCapitalId() == 0 && bean.getId().equals(projectBean.getProjectId())) {
								arr[number++] = bean.getDistributionAmount();
								pList.remove(bean);
								break;
							}
							if (i == pList.size() - 1) {
								arr[number++] = 0;
								break;
							}
						}
					}
					map.put(orderNo++, arr);
					// 已回款数据
					for (BaseCapital capitalBean : capitalList) {
						Integer capitalId = capitalBean.getCapitalId();
						arr = new Number[projectSize];
						number = 0;
						for (BaseProject projectBean : projectList) {
							if (pList.isEmpty()) {
								arr[number++] = 0;
							} else {
								for (int i = 0; i < pList.size(); i++) {
									BaseSearchProjectCapitalDistribution bean = pList.get(i);
									if (bean.getCapitalId().equals(capitalId)
											&& bean.getId().equals(projectBean.getProjectId())) {
										arr[number++] = bean.getDistributionAmount();
										pList.remove(bean);
										break;
									}
									if (i == pList.size() - 1) {
										arr[number++] = 0;
										break;
									}
								}
							}
						}
						map.put(orderNo++, arr);
					}
					ConditionGetProjectSureAndLeftInteger integralCondition = new ConditionGetProjectSureAndLeftInteger();
					integralCondition.setContractId(contractId);
					QueryGetProjectSureAndLeftInteger integralQuery = new QueryGetProjectSureAndLeftInteger();
					BaseCollection<BaseGetProjectSureAndLeftInteger> integralCollection = integralQuery
							.executeQuery(null, integralCondition);
					List<BaseGetProjectSureAndLeftInteger> integralList = integralCollection.getCollections();
					Number[] sureArr = new Number[projectSize];
					Number[] leftArr = new Number[projectSize];
					for (int i = 0; i < projectSize; i++) {
						sureArr[i] = 100;
						leftArr[i] = 0;
					}
					number = 0;
					for (BaseProject projectBean : projectList) {
						for (int i = 0; i < integralList.size(); i++) {
							BaseGetProjectSureAndLeftInteger obj = integralList.get(i);
							if (obj.getProjectId().equals(projectBean.getProjectId())) {
								if (null == obj.getSureIntegral()) {
									obj.setSureIntegral(BigDecimal.ZERO);
								}
								if (null == obj.getLeftIntegral()) {
									obj.setLeftIntegral(BigDecimal.ZERO);
								}
								// 陈总说的，确认积分和订单积分都为0时，都给默认值100，也就是确认积分为100，剩余积分0
								if (obj.getSureIntegral().compareTo(BigDecimal.ZERO) == 0
										&& obj.getLeftIntegral().compareTo(BigDecimal.ZERO) == 0) {
									sureArr[number++] = new BigDecimal(100);
								} else {
									sureArr[number] = obj.getSureIntegral();
									leftArr[number++] = obj.getLeftIntegral();
								}
								integralList.remove(obj);
								break;
							}
						}
					}
					map.put("sureIntegral", sureArr);
					map.put("leftIntegral", leftArr);
					map.put("projectId", sb.toString());
					bc.setUserData(map);
					return bc.toJSON();
				}
			}
		}
		return bc.toJSON(-1, null);
	}

	public String prepareCapitalDistributionInfo(Map<String, Object> params) throws Exception {
		int capitalId = BaseHelpUtils.getIntValue(params.get("capitalId"));
		int operator = BaseHelpUtils.getIntValue(params.get("operator"));
		BaseCollection<CustomBaseCapitalDistribution> bc = new BaseCollection<>();
		Capital capitalDao = new Capital();
		capitalDao.unsetSelectFlags();
		capitalDao.setSelectContractId(true);
		capitalDao.setSelectBorrowMoney(true);
		capitalDao.setCapitalId(capitalId);
		if (capitalDao.load()) {
			if (null == capitalDao.getContractId()) {
				return bc.toJSON(-1, "回款没有绑定合同");
			}
			if (null == capitalDao.getBorrowMoney()) {
				return bc.toJSON(-1, "该回款的回款金额为空");
			}
			ConditionGetProjectInfoAndLeftAmount condition = new ConditionGetProjectInfoAndLeftAmount();
			condition.setContractId(capitalDao.getContractId());
			QueryGetProjectInfoAndLeftAmount query = new QueryGetProjectInfoAndLeftAmount();
			BaseCollection<BaseGetProjectInfoAndLeftAmount> collection = query.executeQuery(null, condition);
			List<BaseGetProjectInfoAndLeftAmount> projectList = collection.getCollections();
			if (null != projectList && !projectList.isEmpty()) {
				CapitalDistribution dao = new CapitalDistribution();
				dao.setConditionType("=", StaticUtils.CAPITAL_DISTRIBUTION_TYPE_2);
				dao.setConditionCapitalId("=", capitalId);
				dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
				List<BaseCapitalDistribution> originalList = dao.conditionalLoad();
				List<CustomBaseCapitalDistribution> list = new ArrayList<>();
				Map<Integer, BaseGetProjectInfoAndLeftAmount> map = new HashMap<>();
				for (BaseGetProjectInfoAndLeftAmount obj : projectList) {
					map.put(obj.getProjectId(), obj);
				}
				if (null != originalList && !originalList.isEmpty()) {
					for (BaseCapitalDistribution obj : originalList) {
						CustomBaseCapitalDistribution bean = new CustomBaseCapitalDistribution();
						obj.cloneCopy(bean);
						BaseGetProjectInfoAndLeftAmount projectInfo = map.get(bean.getProjectId());
						bean.setLeftAmount(projectInfo.getLeftAmount());
						bean.setPlateId(projectInfo.getPlateId());
						bean.setSheetAmount(projectInfo.getSheetAmount());
						bean.setDistributedAmount(projectInfo.getDistributedAmount());
						bean.setProjectIntegral(projectInfo.getProjectIntegral());
						bean.setSureIntegral(projectInfo.getSureIntegral());
						list.add(bean);
					}
				} else {
					for (BaseGetProjectInfoAndLeftAmount obj : projectList) {
						CustomBaseCapitalDistribution bean = new CustomBaseCapitalDistribution();
						bean.setCapitalId(capitalId);
						bean.setProjectId(obj.getProjectId());
						bean.setCode(obj.getContractCode());
						bean.setTotalAmount(capitalDao.getBorrowMoney());
						bean.setOperator(operator);
						bean.setContractId(capitalDao.getContractId());
						bean.setType(StaticUtils.CAPITAL_DISTRIBUTION_TYPE_2);
						bean.setLeftAmount(obj.getLeftAmount());
						bean.setPlateId(obj.getPlateId());
						bean.setSheetAmount(obj.getSheetAmount());
						bean.setDistributedAmount(obj.getDistributedAmount());
						bean.setProjectIntegral(obj.getProjectIntegral());
						bean.setSureIntegral(obj.getSureIntegral());
						list.add(bean);
					}
				}
				Collections.sort(list, new Comparator<CustomBaseCapitalDistribution>() {
					public int compare(CustomBaseCapitalDistribution o1, CustomBaseCapitalDistribution o2) {
						return o2.getSheetAmount().compareTo(o1.getSheetAmount());
					}
				});
				bc.setCollections(list);
				return bc.toJSON();
			} else {
				return bc.toJSON(-1, "该合同没有找到相对应的订单");
			}
		} else {
			return bc.toJSON(-1, "回款不存在");
		}
	}

	public String getAllDistribution(Map<String, Object> params) throws Exception {
		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
		BaseCollection<CustomBaseCapitalDistribution> bc = new BaseCollection<>();
		ConditionGetProjectInfoAndLeftAmount condition = new ConditionGetProjectInfoAndLeftAmount();
		condition.setContractId(contractId);
		QueryGetProjectInfoAndLeftAmount query = new QueryGetProjectInfoAndLeftAmount();
		BaseCollection<BaseGetProjectInfoAndLeftAmount> collection = query.executeQuery(null, condition);
		List<BaseGetProjectInfoAndLeftAmount> projectList = collection.getCollections();
		if (null != projectList && !projectList.isEmpty()) {
			List<CustomBaseCapitalDistribution> list = new ArrayList<>();
			for (BaseGetProjectInfoAndLeftAmount obj : projectList) {
				CustomBaseCapitalDistribution bean = new CustomBaseCapitalDistribution();
				bean.setProjectId(obj.getProjectId());
				bean.setCode(obj.getContractCode());
				bean.setContractId(contractId);
				bean.setType(StaticUtils.CAPITAL_DISTRIBUTION_TYPE_2);
				bean.setLeftAmount(obj.getLeftAmount());
				bean.setPlateId(obj.getPlateId());
				bean.setSheetAmount(obj.getSheetAmount());
				bean.setDistributedAmount(obj.getDistributedAmount());
				bean.setProjectIntegral(obj.getProjectIntegral());
				bean.setSureIntegral(obj.getSureIntegral());
				list.add(bean);
			}
			bc.setCollections(list);
			return bc.toJSON();
		} else {
			return bc.toJSON(-1, "没有回款分配记录");
		}
	}

	public String saveCapitalDistribution(Map<String, Object> params) throws Exception {
		List<BaseCapitalDistribution> list = GenericBase.__getList(params.get("details"),
				BaseCapitalDistribution.newInstance());
		int type = BaseHelpUtils.getIntValue(params.get("type"));
		int capitalId = BaseHelpUtils.getIntValue(params.get("capitalId"));
		Capital capitalDao = new Capital();
		capitalDao.setCapitalId(capitalId);
		capitalDao.unsetSelectFlags();
		capitalDao.setSelectHappenDate(true);
		capitalDao.setSelectBorrowMoney(true);
		capitalDao.setSelectRemark(true);
		capitalDao.setSelectContractId(true);
		if (capitalDao.load()) {
			ThreadConnection.beginTransaction();
			BigDecimal sum = BigDecimal.ZERO;
			CapitalDistribution capitalDistributionDao = new CapitalDistribution();
			capitalDistributionDao.setConditionCapitalId("=", capitalId);
			capitalDistributionDao.setConditionType("=", type);
			capitalDistributionDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
			String basicInfo = "【回款分配变动信息】\r\n  操作人：" + BaseHelpUtils.getString(params.get("operator")) + "\r\n  操作时间："
					+ DateUtil.formatDateTimeString(new Date()) + "\r\n  回款日期："
					+ DateUtil.formatDateString(capitalDao.getHappenDate()) + "\r\n  回款金额："
					+ capitalDao.getBorrowMoney() + "\r\n  回款备注：" + capitalDao.getRemark();
			StringBuilder sb = new StringBuilder();
			// 加载原有的数据
			List<BaseCapitalDistribution> originalList = capitalDistributionDao.conditionalLoad();

			boolean sendToAll = true;
			if (null != originalList && !originalList.isEmpty()) {
				sendToAll = false;
			}
			// 记录回款涉及的订单的最终变动积分
			Map<Integer, BaseProject> projectMap = new HashMap<>();
			Set<Integer> projects = new HashSet<>();
			if (list != null) {
				// need to delete list.
				List<BaseCapitalDistribution> needToDeleteList = new ArrayList<>();
				// need to add list.
				List<BaseCapitalDistribution> needToAddList = new ArrayList<>();
				// find the record that exists in the original list and update.
				for (BaseCapitalDistribution bean : list) {
					boolean found = false;
					// 从原有的数据集合中循环取数据，比对主键，主键一致的：更新；没找到的：新增；
					for (BaseCapitalDistribution originalBean : originalList) {
						// 如果主键一致，则直接修改数据
						if (bean.compareTo(originalBean) == 0) {
							found = true;
							capitalDistributionDao.clear();
							capitalDistributionDao.setDataFromBase(originalBean);
							capitalDistributionDao.clearModifiedFlags();
							capitalDistributionDao.setDataFromBase(bean);
							// 修改回款分配时，提取修改的信息
							updateDistributionMsg(capitalDistributionDao, sb, projects, projectMap);
							if (null != capitalDistributionDao.getDistributionAmount()) {
								sum = sum.add(capitalDistributionDao.getDistributionAmount());
							}
							capitalDistributionDao.update();
							break;
						}
					}
					if (!found && null != bean.getDistributionAmount()
							&& bean.getDistributionAmount().compareTo(BigDecimal.ZERO) != 0) {
						needToAddList.add(bean);
					}
				}
				// 找出需要删除的数据
				for (BaseCapitalDistribution originalBean : originalList) {
					boolean foundNeedToDelete = false;
					for (BaseCapitalDistribution bean : list) {
						if (bean.compareTo(originalBean) == 0) {
							foundNeedToDelete = true;
							break;
						}
					}
					if (!foundNeedToDelete)
						needToDeleteList.add(originalBean);
				}
				// process need-to-add list
				for (BaseCapitalDistribution bean : needToAddList) {
					capitalDistributionDao.setPrimaryKeyFromBase(bean);
					if (capitalDistributionDao.isPrimaryKeyNull()) {
						capitalDistributionDao.clearCurrentData();
						capitalDistributionDao.setDataFromBase(bean);
						capitalDistributionDao.save();
						createDistributionMsg(sb, bean, projects, projectMap);
					} else {
						if (capitalDistributionDao.load()) {
							capitalDistributionDao.setDataFromBase(bean);
							// 获取回款分配修改的内容
							updateDistributionMsg(capitalDistributionDao, sb, projects, projectMap);
							capitalDistributionDao.update();
						} else {
							capitalDistributionDao.clearCurrentData();
							capitalDistributionDao.setDataFromBase(bean);
							capitalDistributionDao.save();
							// 获取回款分配新增的内容
							createDistributionMsg(sb, bean, projects, projectMap);
						}
					}
					if (null != capitalDistributionDao.getDistributionAmount()) {
						sum = sum.add(capitalDistributionDao.getDistributionAmount());
					}
				}
				// process need-to-delete list
				for (BaseCapitalDistribution bean : needToDeleteList) {
					capitalDistributionDao.setDataFromBase(bean);
					capitalDistributionDao.clearModifiedFlags();
					capitalDistributionDao.setDeleteFlag(StaticUtils.HAS_DELETE);
					// 获取回款分配删除的内容
					deleteDistributionMsg(sb, bean, projects, projectMap);
					capitalDistributionDao.update();
				}
			} else {
				// if current list is empty, then delete all original list.
				for (BaseCapitalDistribution bean : originalList) {
					capitalDistributionDao.setDataFromBase(bean);
					capitalDistributionDao.clearModifiedFlags();
					capitalDistributionDao.setDeleteFlag(StaticUtils.HAS_DELETE);
					// 获取回款分配删除的内容
					deleteDistributionMsg(sb, bean, projects, projectMap);
					capitalDistributionDao.update();
				}
			}
			if (sb.length() > 0) {
				String content = basicInfo + sb.toString();
				// 发送消息
				CapitalLog logDao = new CapitalLog();
				logDao.setLogContent(content.replaceAll("\r\n", "<br>").replaceAll("  ", "&nbsp;&nbsp;"));
				logDao.setOperator(BaseHelpUtils.getIntValue(params.get("operatorId")));
				logDao.setCapitalId(capitalId);
				logDao.save();
				CapitalDistributionMsg msgUtil = new CapitalDistributionMsg();
				if (sendToAll) {
					msgUtil.sendToProjectAndDepartmentManagerByContractId(capitalDao.getContractId(), content,
							projectMap);
				} else {
					msgUtil.sendToProjectAndDepartmentManagerByProjectIdSet(projects, content, projectMap);
				}
			}
			if (sum.compareTo(BigDecimal.ZERO) == 0) {
				capitalDao.setHasDistributionCollection(false);
				capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_0);
			} else if (sum.compareTo(capitalDao.getBorrowMoney()) == 0) {
				capitalDao.setHasDistributionCollection(true);
				capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_2);
			} else {
				capitalDao.setHasDistributionCollection(true);
				capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_1);
			}
			capitalDao.setConditionCapitalId("=", capitalId);
			capitalDao.conditionalUpdate();
			ThreadConnection.commit();
		}
		BaseCollection bc = new BaseCollection<>();
		return bc.toJSON();
	}

	public void deleteDistributionMsg(StringBuilder sb, BaseCapitalDistribution bean, Set<Integer> projects,
			Map<Integer, BaseProject> projectMap) throws SQLException {
		if (null != bean.getProjectId()) {
			if (null != projects) {
				projects.add(bean.getProjectId());
			}
			Project projectDao = new Project();
			projectDao.unsetSelectFlags();
			projectDao.setSelectProjectId(true);
			projectDao.setSelectProjectName(true);
			projectDao.setSelectContractCode(true);
			projectDao.setSelectProjectManageId(true);
			projectDao.setSelectDepartmentManagerId(true);
			projectDao.setSelectPlateId(true);
			projectDao.setProjectId(bean.getProjectId());
			if (projectDao.load()) {
				if (null != projectMap) {
					Integer projectId = projectDao.getProjectId();
					BaseProject projectBean;
					if (projectMap.containsKey(projectId)) {
						projectBean = projectMap.get(projectId);
					} else {
						projectBean = projectDao.generateBase();
						projectBean.setTotalAmount(BigDecimal.ZERO);
						projectMap.put(projectId, projectBean);
					}
					projectBean.setTotalAmount(projectBean.getTotalAmount().add(bean.getDistributionAmount().negate()));
				}
				sb.append("\r\n").append("【删除数据】 ").append(projectDao.getProjectName()).append("(")
						.append(projectDao.getContractCode()).append(")分配的回款金额为").append(bean.getDistributionAmount());
			}
		}
	}

	public void createDistributionMsg(StringBuilder sb, BaseCapitalDistribution bean, Set<Integer> projects,
			Map<Integer, BaseProject> projectMap) throws SQLException {
		if (null != bean.getProjectId()) {
			if (null != projects) {
				projects.add(bean.getProjectId());
			}
			Project projectDao = new Project();
			projectDao.unsetSelectFlags();
			projectDao.setSelectProjectId(true);
			projectDao.setSelectProjectName(true);
			projectDao.setSelectContractCode(true);
			projectDao.setSelectProjectManageId(true);
			projectDao.setSelectDepartmentManagerId(true);
			projectDao.setSelectPlateId(true);
			projectDao.setProjectId(bean.getProjectId());
			if (projectDao.load()) {
				if (null != projectMap) {
					Integer projectId = projectDao.getProjectId();
					BaseProject projectBean;
					if (projectMap.containsKey(projectId)) {
						projectBean = projectMap.get(projectId);
					} else {
						projectBean = projectDao.generateBase();
						projectBean.setTotalAmount(BigDecimal.ZERO);
						projectMap.put(projectId, projectBean);
					}
					projectBean.setTotalAmount(projectBean.getTotalAmount().add(bean.getDistributionAmount()));
				}
				sb.append("\r\n").append("【新增数据】 ").append(projectDao.getProjectName()).append("(")
						.append(projectDao.getContractCode()).append(")分配的回款金额为").append(bean.getDistributionAmount());
			}
		}
	}

	public void updateDistributionMsg(CapitalDistribution capitalDistributionDao, StringBuilder sb,
			Set<Integer> projects, Map<Integer, BaseProject> projectMap) throws SQLException {
		if (null != capitalDistributionDao.getProjectId()) {
			ColumnChangedData projectChangedData = capitalDistributionDao
					.getColumnChangedData(BaseCapitalDistribution.CS_PROJECT_ID);
			ColumnChangedData amountChangedData = capitalDistributionDao
					.getColumnChangedData(BaseCapitalDistribution.CS_DISTRIBUTION_AMOUNT);
			Project projectDao = new Project();
			projectDao.unsetSelectFlags();
			projectDao.setSelectProjectId(true);
			projectDao.setSelectProjectName(true);
			projectDao.setSelectContractCode(true);
			projectDao.setSelectProjectManageId(true);
			projectDao.setSelectPlateId(true);
			projectDao.setSelectDepartmentManagerId(true);
			if (null != projectChangedData && null == amountChangedData) {
				if (null != projects) {
					projects.add(BaseHelpUtils.getIntValue(projectChangedData.getOriginal()));
					projects.add(capitalDistributionDao.getProjectId());
				}
				sb.append("\r\n").append("【订单变动】 ");
				projectDao.setProjectId(BaseHelpUtils.getIntValue(projectChangedData.getOriginal()));
				if (projectDao.load()) {
					if (null != projectMap) {
						Integer projectId = projectDao.getProjectId();
						BaseProject projectBean;
						if (projectMap.containsKey(projectId)) {
							projectBean = projectMap.get(projectId);
						} else {
							projectBean = projectDao.generateBase();
							projectBean.setTotalAmount(BigDecimal.ZERO);
							projectMap.put(projectId, projectBean);
						}
						projectBean.setTotalAmount(projectBean.getTotalAmount()
								.add(capitalDistributionDao.getDistributionAmount().negate()));
					}
					sb.append("分配的订单从").append(projectDao.getProjectName()).append("(")
							.append(projectDao.getContractCode()).append(")").append(" 更改为 ");
				}
				projectDao.setProjectId(capitalDistributionDao.getProjectId());
				if (projectDao.load()) {
					if (null != projectMap) {
						Integer projectId = projectDao.getProjectId();
						BaseProject projectBean;
						if (projectMap.containsKey(projectId)) {
							projectBean = projectMap.get(projectId);
						} else {
							projectBean = projectDao.generateBase();
							projectBean.setTotalAmount(BigDecimal.ZERO);
							projectMap.put(projectId, projectBean);
						}
						projectBean.setTotalAmount(
								projectBean.getTotalAmount().add(capitalDistributionDao.getDistributionAmount()));
					}
					sb.append(projectDao.getProjectName()).append("(").append(projectDao.getContractCode()).append(")");
				}
			} else if (null == projectChangedData && null != amountChangedData) {
				if (null != projects) {
					projects.add(capitalDistributionDao.getProjectId());
					projectDao.setProjectId(capitalDistributionDao.getProjectId());
				}
				if (projectDao.load()) {
					if (null != projectMap) {
						Integer projectId = projectDao.getProjectId();
						BaseProject projectBean;
						if (projectMap.containsKey(projectId)) {
							projectBean = projectMap.get(projectId);
						} else {
							projectBean = projectDao.generateBase();
							projectBean.setTotalAmount(BigDecimal.ZERO);
							projectMap.put(projectId, projectBean);
						}
						projectBean.setTotalAmount(projectBean.getTotalAmount()
								.add(BaseHelpUtils.getBigDecimalValue(amountChangedData.getValue())
										.subtract(BaseHelpUtils.getBigDecimalValue(amountChangedData.getOriginal()))));
					}
					sb.append("\r\n").append("【金额变动】 ").append(projectDao.getProjectName()).append("(")
							.append(projectDao.getContractCode()).append(")分配的回款金额由")
							.append(amountChangedData.getOriginal()).append("变更为").append(amountChangedData.getValue());
				}
			} else if (null != projectChangedData && null != amountChangedData) {
				if (null != projects) {
					projects.add(BaseHelpUtils.getIntValue(projectChangedData.getOriginal()));
					projects.add(capitalDistributionDao.getProjectId());
				}
				sb.append("\r\n").append("【订单&金额变动】 ");
				projectDao.setProjectId(BaseHelpUtils.getIntValue(projectChangedData.getOriginal()));
				if (projectDao.load()) {
					if (null != projectMap) {
						Integer projectId = projectDao.getProjectId();
						BaseProject projectBean;
						if (projectMap.containsKey(projectId)) {
							projectBean = projectMap.get(projectId);
						} else {
							projectBean = projectDao.generateBase();
							projectBean.setTotalAmount(BigDecimal.ZERO);
							projectMap.put(projectId, projectBean);
						}
						projectBean.setTotalAmount(projectBean.getTotalAmount()
								.add(BaseHelpUtils.getBigDecimalValue(amountChangedData.getOriginal()).negate()));
					}
					sb.append("分配的订单从").append(projectDao.getProjectName()).append("(")
							.append(projectDao.getContractCode()).append(")").append(" 更改为 ");
				}
				projectDao.setProjectId(capitalDistributionDao.getProjectId());
				if (projectDao.load()) {
					if (null != projectMap) {
						Integer projectId = projectDao.getProjectId();
						BaseProject projectBean;
						if (projectMap.containsKey(projectId)) {
							projectBean = projectMap.get(projectId);
						} else {
							projectBean = projectDao.generateBase();
							projectBean.setTotalAmount(BigDecimal.ZERO);
							projectMap.put(projectId, projectBean);
						}
						projectBean.setTotalAmount(
								projectBean.getTotalAmount().add(capitalDistributionDao.getDistributionAmount()));
					}
					sb.append(projectDao.getProjectName()).append("(").append(projectDao.getContractCode()).append(")");
				}
				sb.append("；金额从").append(amountChangedData.getOriginal()).append("变更为")
						.append(amountChangedData.getValue());
			}

		}
	}

	public String lockOrUnlockCapitalDistribution(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		String[] ids = BaseHelpUtils.getString(params.get("capitalId")).split(",");
		if (null != ids && ids.length > 0) {
			int length = ids.length;
			Integer[] capitalIds = new Integer[length];
			for (int i = 0; i < length; i++) {
				capitalIds[i] = BaseHelpUtils.getIntValue(ids[i]);
			}
			boolean locked = BaseHelpUtils.getBoolean(params.get("locked"));
			ThreadConnection.beginTransaction();
			CapitalDistribution dao = new CapitalDistribution();
			dao.addCondition(BaseCapitalDistribution.CS_CAPITAL_ID, "in", (Object[]) capitalIds);
			dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
			dao.setLocked(locked);
			dao.conditionalUpdate();
			Capital capitalDao = new Capital();
			if (locked) {
				capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_3);
				capitalDao.addCondition(BaseCapital.CS_CAPITAL_ID, "in", (Object[]) capitalIds);
				capitalDao.conditionalUpdate();
			} else {
				for (Integer capitalId : capitalIds) {
					ConditionLeftCapitalAmount condition = new ConditionLeftCapitalAmount();
					condition.setCapitalId(capitalId);
					QueryLeftCapitalAmount query = new QueryLeftCapitalAmount();
					BaseCollection<BaseLeftCapitalAmount> collection = query.executeQuery(null, condition);
					if (null != collection.getCollections() && !collection.getCollections().isEmpty()) {
						if (collection.getCollections().get(0).getLeftAmount().compareTo(BigDecimal.ZERO) == 0) {
							capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_2);
						} else {
							capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_1);
						}
					}
					capitalDao.setConditionCapitalId("=", capitalId);
					capitalDao.conditionalUpdate();
				}
			}
			ThreadConnection.commit();
			return bc.toJSON();
		}
		return bc.toJSON(-1, "没有回款ID");
	}

	public String isOkToFit(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		BigDecimal distributionAmount = BaseHelpUtils.getBigDecimalValue(params.get("distributionAmount"));
		Integer projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
		Integer contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
		if (projectId > 0 && contractId > 0) {
			Project dao = new Project();
			dao.setProjectId(projectId);
			dao.unsetSelectFlags();
			dao.setSelectSheetAmount(true);
			if (dao.load() && null != dao.getSheetAmount()) {
				CapitalDistribution distributionDao = new CapitalDistribution();
				distributionDao.setConditionContractId("=", contractId);
				distributionDao.setConditionProjectId("=", projectId);
				distributionDao.setConditionType("=", StaticUtils.CAPITAL_DISTRIBUTION_TYPE_2);
				distributionDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
				distributionDao.unsetSelectFlags();
				distributionDao.setSelectDistributionAmount(true);
				List<BaseCapitalDistribution> list = distributionDao.conditionalLoad();
				BigDecimal left = dao.getSheetAmount();
				if (null != list && !list.isEmpty()) {
					for (BaseCapitalDistribution obj : list) {
						if (null != obj.getDistributionAmount()) {
							left = left.subtract(obj.getDistributionAmount());
						}
					}
				}
				if (left.compareTo(distributionAmount) >= 0) {
					// 本次可以自动填充
					return bc.toJSON();
				}
			}
		}
		return bc.toJSON(-1, null);
	}

	public String deleteCapitalDistribution(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String[] idsStr = BaseHelpUtils.getString(params.get("ids")).split(",");
		int size = idsStr.length;
		Integer[] ids = new Integer[size];
		for (int i = 0; i < size; i++) {
			ids[i] = BaseHelpUtils.getIntValue(idsStr[i]);
		}
		ThreadConnection.beginTransaction();
		CapitalDistribution dao = new CapitalDistribution();
		dao.addCondition(BaseCapitalDistribution.CS_CAPITAL_ID, "in", (Object[]) ids);
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseCapitalDistribution> list = dao.conditionalLoad();
		String basicInfo = "【回款分配变动信息】\r\n  操作人：" + BaseHelpUtils.getString(params.get("operator")) + "\r\n  操作时间："
				+ DateUtil.formatDateTimeString(new Date());
		StringBuilder sb = new StringBuilder();
		Map<Integer, BaseProject> projectMap = new HashMap<>();
		for (BaseCapitalDistribution bean : list) {
			deleteDistributionMsg(sb, bean, null, projectMap);
		}
		dao.setDeleteFlag(StaticUtils.HAS_DELETE);
		int num = dao.conditionalUpdate();
		if (sb.length() > 0) {
			String content = basicInfo + sb.toString();
			for (Integer capitalId : ids) {
				CapitalLog logDao = new CapitalLog();
				logDao.setOperator(BaseHelpUtils.getIntValue(params.get("operatorId")));
				logDao.setCapitalId(capitalId);
				logDao.setLogContent(content.replaceAll("\r\n", "<br>").replaceAll("  ", "&nbsp;&nbsp;"));
				logDao.save();
			}
			CapitalDistributionMsg msgUtil = new CapitalDistributionMsg();
			Capital capitalDao = new Capital();
			capitalDao.unsetSelectFlags();
			capitalDao.setSelectContractId(true);
			capitalDao.addCondition(BaseCapital.CS_CAPITAL_ID, "in", (Object[]) ids);
			List<BaseCapital> capitalList = capitalDao.conditionalLoad();
			capitalDao.setHasDistributionCollection(false);
			capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_0);
			capitalDao.conditionalUpdate();
			if (null != capitalList && !capitalList.isEmpty()) {
				Set<Integer> contractSet = new HashSet<>();
				for (BaseCapital bean : capitalList) {
					if (!BaseHelpUtils.isNullOrZero(bean.getContractId())) {
						contractSet.add(bean.getContractId());
					}
				}
				for (Integer id : contractSet) {
					msgUtil.sendToProjectAndDepartmentManagerByContractId(id, content, projectMap);
				}
			}
		}
		ThreadConnection.commit();
		return bc.toJSON(num, "共删除" + num + "条数据");
	}

	/**
	 * 按确认积分自动分配
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String autoFit(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		Date date = DateUtil.getFirstDayOfNextMonth(new Date(BaseHelpUtils.getLongValue(params.get("date"))));
		String[] idsStr = BaseHelpUtils.getString(params.get("ids")).split(",");
		int size = idsStr.length;
		if (size > 0) {
			Integer[] ids = new Integer[size];
			for (int i = 0; i < size; i++) {
				ids[i] = BaseHelpUtils.getIntValue(idsStr[i]);
			}
			ConditionLeftCapitalAmount leftCondition = new ConditionLeftCapitalAmount();
			if (size == 1) {
				leftCondition.setCapitalId(ids[0]);
			} else {
				StringBuilder sb = new StringBuilder();
				for (Integer key : ids) {
					if (sb.length() > 0) {
						sb.append(",");
					}
					sb.append(key);
				}
				KeyValuePair keyValue = new KeyValuePair();
				keyValue.setKey("a.capital_id = ?");
				keyValue.setValue("a.capital_id = ? and a.capital_id in (" + sb.toString() + ")");
				KeyValuePair[] keyValueArr = { keyValue };
				leftCondition.setKeyValues(keyValueArr);
			}
			QueryLeftCapitalAmount leftQuery = new QueryLeftCapitalAmount();
			BaseCollection<BaseLeftCapitalAmount> leftCollection = leftQuery.executeQuery(leftCondition.getKeyValues(),
					leftCondition);
			if (null != leftCollection && null != leftCollection.getCollections()
					&& !leftCollection.getCollections().isEmpty()) {
				List<BaseLeftCapitalAmount> leftList = leftCollection.getCollections();
				int contractId = BaseHelpUtils.getIntValue(leftList.get(0).getContractId());
				Set<Integer> notInProjectId = new HashSet<>();
				CapitalDistribution distributionDao = new CapitalDistribution();
				distributionDao.addCondition(BaseCapitalDistribution.CS_CAPITAL_ID, "in", (Object[]) ids);
				distributionDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
				distributionDao.unsetSelectFlags();
				distributionDao.setSelectProjectId(true);
				if (size > 1) {
					// 只能针对全部都没有分配过的回款来操作
					if (distributionDao.countRows() > 0) {
						return bc.toJSON(-1, "您选择的回款中，有回款已经做了分配操作，系统无法实现批量自动分配");
					}
				} else {
					// 单笔回款，已分配的订单不参与本次自动分配运算
					List<BaseCapitalDistribution> distributionList = distributionDao.conditionalLoad();
					for (BaseCapitalDistribution obj : distributionList) {
						if (null != obj.getProjectId()) {
							notInProjectId.add(obj.getProjectId());
						}
					}
				}
				ConditionAutoFitInfo condition = new ConditionAutoFitInfo();
				condition.setContractId(contractId);
				condition.setEndDate(date);
				if (notInProjectId.size() > 0) {
					StringBuilder sb = new StringBuilder();
					for (Integer key : notInProjectId) {
						if (sb.length() > 0) {
							sb.append(",");
						}
						sb.append(key);
					}
					KeyValuePair keyValue = new KeyValuePair();
					keyValue.setKey("a.contract_id = ?");
					keyValue.setValue("a.contract_id = ? and a.project_id not in (" + sb.toString() + ")");
					KeyValuePair[] keyValueArr = { keyValue };
					condition.setKeyValues(keyValueArr);
				}
				QueryAutoFitInfo query = new QueryAutoFitInfo();
				BaseCollection<BaseAutoFitInfo> collection = query.executeQuery(condition.getKeyValues(), condition);
				if (null != collection && null != collection.getCollections()
						&& !collection.getCollections().isEmpty()) {
					List<BaseAutoFitInfo> list = collection.getCollections();
					// 本次理论上可以得到的总的回款金额
					BigDecimal total = BigDecimal.ZERO;
					for (BaseAutoFitInfo obj : list) {
						if (obj.getProjectIntegral().compareTo(BigDecimal.ZERO) == 0) {
							continue;
						}
						// 本次该订单理论可分配到的回款金额
						BigDecimal calculation = obj.getSheetAmount().multiply(obj.getSureIntegral())
								.subtract((obj.getDistributionAmount().multiply(obj.getProjectIntegral())))
								.divide(obj.getProjectIntegral(), BigDecimal.ROUND_DOWN, 2);
						if (calculation.compareTo(BigDecimal.ZERO) <= 0) {
							obj.setCalculationResult(BigDecimal.ZERO);
						} else {
							obj.setCalculationResult(calculation);
						}
						total = total.add(obj.getCalculationResult());
					}
					CapitalDistribution dao = new CapitalDistribution();
					dao.setContractId(contractId);
					dao.setType(StaticUtils.CAPITAL_DISTRIBUTION_TYPE_2);
					dao.setOperator(BaseHelpUtils.getIntValue(params.get("operator")));
					String operatorName = BaseHelpUtils.getString(params.get("operatorName"));
					ThreadConnection.beginTransaction();
					for (BaseLeftCapitalAmount capital : leftList) {
						String basicInfo = "【回款分配变动信息】\r\n  操作人：" + operatorName + "\r\n  操作时间："
								+ DateUtil.formatDateTimeString(new Date()) + "\r\n  回款日期："
								+ DateUtil.formatDateString(capital.getHappenDate()) + "\r\n  回款金额："
								+ capital.getBorrowMoney() + "\r\n  回款备注：" + capital.getRemark();
						StringBuilder sb = new StringBuilder();
						Map<Integer, BaseProject> projectMap = new HashMap<>();
						dao.setCapitalId(capital.getCapitalId());
						dao.setTotalAmount(capital.getBorrowMoney());
						int infoSize = list.size();
						BigDecimal tempTotal = BigDecimal.ZERO;
						for (int i = 0; i < infoSize; i++) {
							BaseAutoFitInfo obj = list.get(i);
							if (obj.getCalculationResult().compareTo(BigDecimal.ZERO) > 0) {
								dao.setCapitalDistributionId(null);
								dao.setProjectId(obj.getProjectId());
								dao.setPlateId(obj.getPlateId());
								if (i < infoSize - 1) {
									// 本次计算出来的可以得到的回款金额
									BigDecimal calculateResult = obj.getCalculationResult()
											.multiply(capital.getLeftAmount()).divide(total, BigDecimal.ROUND_DOWN, 2);
									// 本次最多可以得到的回款金额（主要用来确保订单分到的回款金额不会超过订单合同金额）
									BigDecimal actualResult = obj.getSheetAmount()
											.subtract(obj.getDistributionAmount());
									// 本次实际可以得到的回款金额
									if (actualResult.compareTo(calculateResult) >= 0) {
										actualResult = calculateResult;
									}
									dao.setDistributionAmount(actualResult);
									tempTotal = tempTotal.add(actualResult);
								} else {
									// 本次计算出来的可以得到的回款金额
									BigDecimal calculateResult = capital.getLeftAmount().subtract(tempTotal);
									// 本次最多可以得到的回款金额（主要用来确保订单分到的回款金额不会超过订单合同金额）
									BigDecimal actualResult = obj.getSheetAmount()
											.subtract(obj.getDistributionAmount());
									// 本次实际可以得到的回款金额
									if (actualResult.compareTo(calculateResult) >= 0) {
										actualResult = calculateResult;
									}
									dao.setDistributionAmount(actualResult);
									tempTotal = tempTotal.add(actualResult);
								}
								if (tempTotal.compareTo(BigDecimal.ZERO) > 0) {
									Capital capitalDao = new Capital();
									capitalDao.setCapitalId(capital.getCapitalId());
									capitalDao.load();
									capitalDao.setHasDistributionCollection(true);
									if (tempTotal.compareTo(capital.getBorrowMoney()) == 0) {
										capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_2);
									} else if (tempTotal.compareTo(capital.getBorrowMoney()) > 0){
										capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_2);
										dao.setDistributionAmount(dao.getDistributionAmount().subtract(tempTotal.subtract(capital.getBorrowMoney())));
									} else {
										capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_1);
									}
									capitalDao.update();
								}
								createDistributionMsg(sb, dao.generateBase(), null, projectMap);
								dao.save();
								if(tempTotal.compareTo(capital.getBorrowMoney()) >= 0){
									break;
								}
							}
						}
						if (sb.length() > 0) {
							String content = basicInfo + sb.toString();
							// 发送消息
							CapitalLog logDao = new CapitalLog();
							logDao.setLogContent(content.replaceAll("\r\n", "<br>").replaceAll("  ", "&nbsp;&nbsp;"));
							logDao.setOperator(BaseHelpUtils.getIntValue(params.get("operator")));
							logDao.setCapitalId(capital.getCapitalId());
							logDao.save();
							CapitalDistributionMsg msgUtil = new CapitalDistributionMsg();
							msgUtil.sendToProjectAndDepartmentManagerByContractId(capital.getContractId(), content,
									projectMap);
						}
					}
					ThreadConnection.commit();
					return bc.toJSON();
				} else {
					return bc.toJSON(-1, "查询不到可分配的订单信息");
				}
			} else {
				return bc.toJSON(-1, "查询不到回款信息");
			}
		} else {
			return bc.toJSON(-1, "回款记录为空");
		}
	}

	/**
	 * 按订单合同金额自动分配
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String autoFitByProjectSheetAmount(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String[] idsStr = BaseHelpUtils.getString(params.get("ids")).split(",");
		String projectStr = BaseHelpUtils.getString(params.get("projectIds"));
		String[] projectIdStr = projectStr.split(",");
		Integer operator = BaseHelpUtils.getIntValue(params.get("operator"));
		String operatorName = BaseHelpUtils.getString(params.get("operatorName"));
		int size = projectIdStr.length;
		if (size > 0) {
			Integer[] ids = new Integer[size];
			for (int i = 0; i < size; i++) {
				ids[i] = BaseHelpUtils.getIntValue(projectIdStr[i]);
			}
			ConditionAutoFitInfo condition = new ConditionAutoFitInfo();
			KeyValuePair keyValue = new KeyValuePair();
			keyValue.setKey("a.contract_id = ?");
			keyValue.setValue("a.contract_id = ? and a.project_id in (" + projectStr + ")");
			KeyValuePair[] keyValueArr = { keyValue };
			condition.setKeyValues(keyValueArr);
			QueryAutoFitInfo query = new QueryAutoFitInfo();
			BaseCollection<BaseAutoFitInfo> collection = query.executeQuery(condition.getKeyValues(), condition);
			Map<Integer, BaseAutoFitInfo> map = new HashMap<>();
			if (null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()) {
				List<BaseAutoFitInfo> list = collection.getCollections();
				for (BaseAutoFitInfo obj : list) {
					map.put(obj.getProjectId(), obj);
				}
			} else {
				return bc.toJSON(-1, "没有符合条件的订单参与本次分配");
			}
			for (String capitalIdStr : idsStr) {
				int capitalId = BaseHelpUtils.getIntValue(capitalIdStr);
				ConditionLeftCapitalAmount leftCondition = new ConditionLeftCapitalAmount();
				leftCondition.setCapitalId(capitalId);
				QueryLeftCapitalAmount leftQuery = new QueryLeftCapitalAmount();
				BaseCollection<BaseLeftCapitalAmount> leftCollection = leftQuery
						.executeQuery(leftCondition.getKeyValues(), leftCondition);
				if (null != leftCollection && null != leftCollection.getCollections()
						&& !leftCollection.getCollections().isEmpty()) {
					BaseLeftCapitalAmount capitalBean = leftCollection.getCollections().get(0);
					Set<Integer> set = new HashSet<>();// 存放已经分配的订单的ID，本次分配跳过这些订单
					// 回款的回款金额和剩下可分配金额不一致，则证明已有分配记录
					if (capitalBean.getBorrowMoney().compareTo(capitalBean.getLeftAmount()) != 0) {
						CapitalDistribution distributionDao = new CapitalDistribution();
						distributionDao.setConditionCapitalId("=", capitalId);
						distributionDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
						distributionDao.unsetSelectFlags();
						distributionDao.setSelectProjectId(true);
						List<BaseCapitalDistribution> distributionList = distributionDao.conditionalLoad();
						for (BaseCapitalDistribution obj : distributionList) {
							set.add(obj.getProjectId());
						}
					}
					// 最终参与本次分配的订单信息
					Set<Integer> distributionSet = new HashSet<>();
					List<BaseAutoFitInfo> fitList = new ArrayList<>();
					for (Integer key : map.keySet()) {
						if (!set.contains(key)) {
							BaseAutoFitInfo bean = map.get(key);
							if (bean.getSheetAmount()
									.compareTo(bean.getDistributionAmount().add(bean.getCalculationResult())) > 0) {
								fitList.add(bean);
								distributionSet.add(bean.getProjectId());
							}
						}
					}
					// 分超的钱都放到这个amount中，给未超的做二次分配
					BigDecimal amount = BigDecimal.ZERO;
					BigDecimal leftAmount = capitalBean.getLeftAmount();
					do {
						amount = BigDecimal.ZERO;
						BigDecimal sum = BigDecimal.ZERO;
						for (BaseAutoFitInfo obj : fitList) {
							sum = sum.add(obj.getSheetAmount());
						}
						int listSize = fitList.size();
						BigDecimal distributionAmount = BigDecimal.ZERO;
						for (int i = 0; i < listSize; i++) {
							BaseAutoFitInfo obj = fitList.get(i);
							if (i == listSize - 1) {
								obj.setCalculationResult(
										obj.getCalculationResult().add(leftAmount.subtract(distributionAmount)));
							} else {
								obj.setCalculationResult(obj.getCalculationResult().add(obj.getSheetAmount()
										.multiply(leftAmount).divide(sum, BigDecimal.ROUND_DOWN, 2)));
								distributionAmount = distributionAmount.add(obj.getCalculationResult());
							}
						}
						for (int i = 0; i < fitList.size(); i++) {
							BaseAutoFitInfo obj = fitList.get(i);
							if (obj.getSheetAmount().subtract(obj.getDistributionAmount())
									.subtract(obj.getCalculationResult()).compareTo(BigDecimal.ZERO) < 0) {
								fitList.remove(obj);
								amount = amount.add(obj.getCalculationResult()
										.subtract(obj.getSheetAmount().subtract(obj.getDistributionAmount())));
								obj.setCalculationResult(obj.getSheetAmount().subtract(obj.getDistributionAmount()));
								i--;
							}
							map.put(obj.getProjectId(), obj);
						}
						if (amount.compareTo(BigDecimal.ZERO) > 0) {
							leftAmount = amount;
						}
					} while (amount.compareTo(BigDecimal.ZERO) > 0 && fitList.size() > 0);
					CapitalDistribution dao = new CapitalDistribution();
					dao.setContractId(capitalBean.getContractId());
					dao.setType(StaticUtils.CAPITAL_DISTRIBUTION_TYPE_2);
					dao.setOperator(operator);
					ThreadConnection.beginTransaction();
					Capital capitalDao = new Capital();
					capitalDao.setCapitalId(capitalBean.getCapitalId());
					capitalDao.load();
					capitalDao.setHasDistributionCollection(true);
					if (amount.compareTo(BigDecimal.ZERO) == 0) {
						capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_2);
					} else {
						capitalDao.setProcessStatus(StaticUtils.CAPITAL_PROCESS_STATUS_1);
					}
					capitalDao.update();
					String basicInfo = "【回款分配变动信息】\r\n  操作人：" + operatorName + "\r\n  操作时间："
							+ DateUtil.formatDateTimeString(new Date()) + "\r\n  回款日期："
							+ DateUtil.formatDateString(capitalBean.getHappenDate()) + "\r\n  回款金额："
							+ capitalBean.getBorrowMoney() + "\r\n  回款备注：" + capitalBean.getRemark();
					StringBuilder sb = new StringBuilder();
					Map<Integer, BaseProject> projectMap = new HashMap<>();
					dao.setCapitalId(capitalBean.getCapitalId());
					dao.setTotalAmount(capitalBean.getBorrowMoney());
					fitList.clear();
					for (Integer id : distributionSet) {
						fitList.add(map.get(id));
					}
					for (BaseAutoFitInfo obj : fitList) {
						dao.setCapitalDistributionId(null);
						dao.setProjectId(obj.getProjectId());
						dao.setPlateId(obj.getPlateId());
						dao.setDistributionAmount(obj.getCalculationResult());
						createDistributionMsg(sb, dao.generateBase(), null, projectMap);
						obj.setDistributionAmount(obj.getDistributionAmount().add(obj.getCalculationResult()));
						obj.setCalculationResult(BigDecimal.ZERO);
						map.put(obj.getProjectId(), obj);
						dao.save();
					}
					if (sb.length() > 0) {
						String content = basicInfo + sb.toString();
						// 发送消息
						CapitalLog logDao = new CapitalLog();
						logDao.setLogContent(content.replaceAll("\r\n", "<br>").replaceAll("  ", "&nbsp;&nbsp;"));
						logDao.setOperator(BaseHelpUtils.getIntValue(params.get("operator")));
						logDao.setCapitalId(capitalBean.getCapitalId());
						logDao.save();
						CapitalDistributionMsg msgUtil = new CapitalDistributionMsg();
						msgUtil.sendToProjectAndDepartmentManagerByContractId(capitalBean.getContractId(), content,
								projectMap);
					}
				}
				ThreadConnection.commit();
			}
			return bc.toJSON();
		} else {
			return bc.toJSON(-1, "参与分配的订单数量为空");
		}
	}

	public String capitalDistributionAnalyze(Map<String, Object> params) throws Exception {
		BigDecimal capitalAmount = BigDecimal.ZERO;
		BigDecimal distributionAmount = BigDecimal.ZERO;
		BigDecimal departmentAmount = BigDecimal.ZERO;
		Date startDate = null;
		if(params.containsKey("startDate")) {
			startDate = DateUtil.getNextDayOfDay(new Date(BaseHelpUtils.getLongValue(params.get("startDate"))), 0);
		}
		Date endDate = null;
		if(params.containsKey("endDate")) {
			endDate = DateUtil.getNextDayOfDay(new Date(BaseHelpUtils.getLongValue(params.get("endDate"))), 1);
		}
		ConditionSumCapitalBorrowMoney capitalAmountCondition = new ConditionSumCapitalBorrowMoney();
		capitalAmountCondition.setStartDate(startDate);
		capitalAmountCondition.setEndDate(endDate);
		KeyValuePair keyValue = new KeyValuePair();
		keyValue.setKey("money_attribute = ?");
		keyValue.setValue(String.format("money_attribute = ? and money_attribute in (%1$s, %2$s, %3$s)", StaticUtils.CAPITAL_MONEY_ATTRIBUTION_1, StaticUtils.CAPITAL_MONEY_ATTRIBUTION_11, StaticUtils.CAPITAL_MONEY_ATTRIBUTION_13));
		KeyValuePair[] keyValues = new KeyValuePair[1];
		keyValues[0] = keyValue;
		QuerySumCapitalBorrowMoney capitalAmountQuery = new QuerySumCapitalBorrowMoney();
		BaseCollection<BaseSumCapitalBorrowMoney> capitalAmountBc = capitalAmountQuery.executeQuery(keyValues, capitalAmountCondition);
		if(null != capitalAmountBc && null != capitalAmountBc.getCollections() && !capitalAmountBc.getCollections().isEmpty()){
			BaseSumCapitalBorrowMoney bean = capitalAmountBc.getCollections().get(0);
			if(null != bean.getAmount()){
				capitalAmount = bean.getAmount();
			}
		}
		ConditionSumCapitalDistribution distributionAmountCondition = new ConditionSumCapitalDistribution();
		distributionAmountCondition.setStartDate(startDate);
		distributionAmountCondition.setEndDate(endDate);
		QuerySumCapitalDistribution distributionAmountQuery = new QuerySumCapitalDistribution();
		BaseCollection<BaseSumCapitalDistribution> distributionAmountBc = distributionAmountQuery.executeQuery(null, distributionAmountCondition);
		if(null != distributionAmountBc && null != distributionAmountBc.getCollections() && !distributionAmountBc.getCollections().isEmpty()){
			BaseSumCapitalDistribution bean = distributionAmountBc.getCollections().get(0);
			if(null != bean.getAmount()){
				distributionAmount = bean.getAmount();
			}
		}
		ConditionSumDepartmentCapitalDistribution departmentAmountCondition = new ConditionSumDepartmentCapitalDistribution();
		departmentAmountCondition.setStartDate(startDate);
		departmentAmountCondition.setEndDate(endDate);
		QuerySumDepartmentCapitalDistribution departmentAmountQuery = new QuerySumDepartmentCapitalDistribution();
		BaseCollection<BaseSumDepartmentCapitalDistribution> departmentAmountBc = departmentAmountQuery.executeQuery(null, departmentAmountCondition);
		if(null != departmentAmountBc && null != departmentAmountBc.getCollections() && !departmentAmountBc.getCollections().isEmpty()){
			BaseSumDepartmentCapitalDistribution bean = departmentAmountBc.getCollections().get(0);
			if(null != bean.getAmount()){
				departmentAmount = bean.getAmount();
			}
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		Map<String, String> value = new HashMap<>();
		DecimalFormat format = new DecimalFormat("###,###,###,##0.00");
		value.put("capitalAmount", format.format(capitalAmount));
		value.put("distributionAmount", format.format(distributionAmount));
		value.put("departmentAmount", format.format(departmentAmount));
		bc.setUserData(value);
		return bc.toJSON();
	}
	
	public String selectPlateIdForDistribution(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String ids = BaseHelpUtils.getString(params.get("ids"));
		if(BaseHelpUtils.isNullOrEmpty(ids)){
    		return bc.toJSON(-1, "请选择需要更改业务部门的记录");
    	}
    	String[] idStrArr = ids.split(",");
    	int length = idStrArr.length;
		Integer[] idArr = new Integer[length];
		for(int i = 0; i < length; i++){
			idArr[i] = BaseHelpUtils.getIntValue(idStrArr[i]);
		}
		int plateId = BaseHelpUtils.getIntValue(params.get("plateId"));
		CapitalDistribution dao = new CapitalDistribution();
		dao.addCondition(BaseCapitalDistribution.CS_CAPITAL_DISTRIBUTION_ID, "in", (Object[]) idArr);
		dao.setPlateId(plateId);
		int num = dao.conditionalUpdate();
		return bc.toJSON(num, null);
	}
	
	
	public static void main(String[] args) {
		CapitalDistributionProcessor a = new CapitalDistributionProcessor();
		Map<String, Object> params = new HashMap<>();
//		params.put("distributionAmount", 72425);
//		params.put("projectId", 818);
		// params.put("optType", "prepareCapitalDistributionInfo");
		params.put("contractId", 1173);
		// {"optType":"isOkToFit","distributionAmount":72425,"projectId":"372","contractId":"259"}
		// String xx =
		// "{\"details\":[{\"capitalDistributionId\":22024,\"contractId\":172,\"type\":2,\"capitalId\":588,\"projectId\":2366,\"code\":\"JA.201309004\",\"sheetAmount\":5754668,\"distributedAmount\":1156,\"totalAmount\":157000,\"distributionAmount\":1156,\"operator\":1101,\"leftAmount\":5753512,\"projectIntegral\":0,\"createTime\":1506679516049},
		// {\"capitalDistributionId\":22023,\"contractId\":172,\"type\":2,\"capitalId\":588,\"plateId\":2,\"projectId\":532,\"code\":\"JA.201309004.02-03-802\",\"sheetAmount\":280876,\"distributedAmount\":76,\"totalAmount\":157000,\"distributionAmount\":76,\"operator\":1101,\"leftAmount\":280800,\"projectIntegral\":4800,\"sureIntegral\":4800,\"createTime\":1506679335213},
		// {\"capitalDistributionId\":22021,\"contractId\":172,\"type\":2,\"capitalId\":588,\"projectId\":2569,\"code\":\"JA.201309004.01-04-805\",\"sheetAmount\":0.5,\"distributedAmount\":124,\"totalAmount\":157000,\"distributionAmount\":13,\"operator\":1101,\"leftAmount\":-123.5,\"projectIntegral\":0,\"createTime\":1506754696480},
		// {\"contractId\":172,\"type\":2,\"capitalId\":588,\"plateId\":6,\"projectId\":198,\"code\":\"JA.201309004.01-02-808\",\"sheetAmount\":\"222740\",\"totalAmount\":157000,\"distributionAmount\":1121,\"operator\":1101,\"createTime\":1506754733814}],\"type\":2,\"capitalId\":\"588\",\"optType\":\"saveCapitalDistribution\",\"operator\":\"陈浩\"}";
//		String xx = "{\"details\":[{\"capitalDistributionId\":1539,\"contractId\":260,\"type\":2,\"capitalId\":5116,\"projectId\":2417,\"code\":\"JA.201509008.01-01-810\",\"sheetAmount\":800000,\"distributedAmount\":800012,\"totalAmount\":320000,\"distributionAmount\":233,\"operator\":97,\"leftAmount\":-12,\"projectIntegral\":0,\"createTime\":1520408354084}, {\"capitalDistributionId\":3951,\"contractId\":260,\"type\":2,\"capitalId\":5116,\"plateId\":49,\"projectId\":168,\"code\":\"JA.201509008.01-02-808\",\"sheetAmount\":680790,\"distributedAmount\":179461,\"totalAmount\":320000,\"distributionAmount\":34,\"operator\":97,\"leftAmount\":501329,\"projectIntegral\":171637.76,\"sureIntegral\":151683,\"createTime\":1520408356615}, {\"capitalDistributionId\":3952,\"contractId\":260,\"type\":2,\"capitalId\":5116,\"plateId\":5,\"projectId\":561,\"code\":\"JA.201509008.01-05-805\",\"sheetAmount\":328500,\"distributedAmount\":328846,\"totalAmount\":320000,\"distributionAmount\":1346,\"operator\":97,\"leftAmount\":-346,\"projectIntegral\":117761.21,\"sureIntegral\":115711.8,\"createTime\":1520408362582}, {\"contractId\":260,\"type\":2,\"capitalId\":5116,\"plateId\":52,\"projectId\":524,\"code\":\"JA.201509008.01-01-801\",\"sheetAmount\":\"1382210\",\"totalAmount\":320000,\"distributionAmount\":123,\"operator\":97,\"createTime\":1520408373727}],\"type\":2,\"capitalId\":\"5116\",\"optType\":\"saveCapitalDistribution\",\"operator\":\"贾小娟\",\"operatorId\":\"97\"}";
		try {
			// a.isOkToFit(params);
//			a.execute(xx, null);
			a.loadCapitalDistributionOfProject(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
