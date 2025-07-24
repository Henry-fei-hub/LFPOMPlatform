package pomplatform.contractstatus.business;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.dao.EmployeeRole;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.contractstatus.bean.BaseContractStatusMonth;
import pomplatform.workflow.contractstatus.bean.BaseContractWithoutSureIntegral;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatusMonth;
import pomplatform.workflow.contractstatus.bean.ConditionContractWithoutSureIntegral;
import pomplatform.workflow.contractstatus.query.QueryContractStatusMonth;
import pomplatform.workflow.contractstatus.query.QueryContractWithoutSureIntegral;
import pomplatform.workflow.contractstatus.utils.ContractStatusUtils;

public class ContractStatusTask extends TimerTask{

	private final int marketDepartmentId = 149;//市场部部门ID
	
	/**
	 * 生成提示信息
	 * @param map	存放提示信息的map，key是员工ID，value是提示信息
	 * @param employeeId	员工ID
	 * @param contractCode	合同编号
	 * @param contractName	合同名称
	 * @param standardMsg	提示信息
	 */
	public void generateMsgByEmployeeId(Map<Integer, String> map, Integer employeeId, String contractCode, String contractName, String standardMsg) {
		if(null == map || null == employeeId || BaseHelpUtils.isNullOrEmpty(contractCode) || BaseHelpUtils.isNullOrEmpty(contractName)) {
			return;
		}
		String msg = map.get(employeeId);
		if(BaseHelpUtils.isNullOrEmpty(msg)) {
			msg = standardMsg + "\r\n";
		}
		String contractInfo = contractCode + "  " + contractName;
		if(msg.indexOf(contractInfo) >= 0) {
			return;
		}
		msg = msg + contractInfo + "\r\n";
		map.put(employeeId, msg);
	}
	
	@Override
	public void run() {
		try {
			//处于合同运行状态的合同，系统判断近3个月内该合同是否有积分确认，若无，则自动变为“合同缓慢”状态
			Calendar calendar = Calendar.getInstance();
			Date endDate = calendar.getTime();
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 3);
			Date startDate = calendar.getTime();
			ContractStatusUtils util = new ContractStatusUtils();
			ConditionContractWithoutSureIntegral sureCondition = new ConditionContractWithoutSureIntegral();
			sureCondition.setContractStatus(StaticUtils.CONTRACT_STATUS_6);
			sureCondition.setStartDate(startDate);
			sureCondition.setEndDate(endDate);
			QueryContractWithoutSureIntegral sureQuery = new QueryContractWithoutSureIntegral();
			BaseCollection<BaseContractWithoutSureIntegral> sureCollection = sureQuery.executeQuery(null, sureCondition);
			if(null != sureCollection && null != sureCollection.getCollections() && !sureCollection.getCollections().isEmpty()) {
				for(BaseContractWithoutSureIntegral bean : sureCollection.getCollections()) {
					util.updateContractAndProjectStatusWithLog(bean.getContractId(), StaticUtils.CONTRACT_STATUS_9, null, "处于合同运行状态的合同3个月内没有积分确认，自动变为合同缓慢状态");
				}
			}
			//处于合同缓慢状态的合同，系统判断近3个月内该合同是否有积分确认，若有，则自动变为“合同运行”状态
			sureCondition.setContractStatus(StaticUtils.CONTRACT_STATUS_9);
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("m.sure_integral = 0");
			kv.setValue("m.sure_integral != 0");
			KeyValuePair[] kvs = {kv};
			sureCollection = sureQuery.executeQuery(kvs, sureCondition);
			if(null != sureCollection && null != sureCollection.getCollections() && !sureCollection.getCollections().isEmpty()) {
				for(BaseContractWithoutSureIntegral bean : sureCollection.getCollections()) {
					util.updateContractAndProjectStatusWithLog(bean.getContractId(), StaticUtils.CONTRACT_STATUS_6, null, "处于合同缓慢状态的合同在3个月内有积分确认，自动变为合同运行状态");
				}
			}
			//周一才发企业微信消息
			boolean sendMsg = DateUtil.getDayOfWeek(new Date()) == 1 ? true : false;
			if(!sendMsg) {
				return;
			}
			//查找处于未出结果状态超过3个月的合同
			ConditionContractStatusMonth condition = new ConditionContractStatusMonth();
			condition.setNewStatus(StaticUtils.CONTRACT_STATUS_1);
			condition.setRoleId(StaticUtils.ROLE_DEPARTMENT_LEADER);
			condition.setContractMonth(3);
			QueryContractStatusMonth query = new QueryContractStatusMonth();
			BaseCollection<BaseContractStatusMonth> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
				Map<Integer, String> noResultMsgMap = new HashMap<>();
				Map<Integer, String> losingBidMsgMap = new HashMap<>();
				EmployeeRole erDao = new EmployeeRole();
				//找市场部总监
				erDao.setConditionRoleId("=", StaticUtils.ROLE_67);
				erDao.setConditionDepartmentId("=", marketDepartmentId);
				List<BaseEmployeeRole> noResultList = erDao.conditionalLoad();
				//找到运营专员
				erDao.clear();
				erDao.setConditionRoleId("=", StaticUtils.ROLE_OPERATION_SPECIALIST);
				List<BaseEmployeeRole> losingBidList = erDao.conditionalLoad();
				for(BaseContractStatusMonth bean : bc.getCollections()) {
					if(bean.getContractMonth() >= 6) {
						//未出结果超过6个月，提醒强制落标，生成发送给运营专员的消息文本
						if(null != losingBidList && !losingBidList.isEmpty()) {
							for(BaseEmployeeRole er : losingBidList) {
								generateMsgByEmployeeId(losingBidMsgMap, er.getEmployeeId(), bean.getContractCode(), bean.getContractName(), ContractStatusUtils.LOSING_BID_MSG);
							}
						}
						//生成发送给市场部总监的消息文本
						if(null != noResultList && !noResultList.isEmpty()) {
							for(BaseEmployeeRole er : noResultList) {
								generateMsgByEmployeeId(losingBidMsgMap, er.getEmployeeId(), bean.getContractCode(), bean.getContractName(), ContractStatusUtils.LOSING_BID_MSG);
							}
						}
						//生成发送给前期项目报备人的消息文本
						generateMsgByEmployeeId(losingBidMsgMap, bean.getApplyEmployeeId(), bean.getContractCode(), bean.getContractName(), ContractStatusUtils.LOSING_BID_MSG);
						if(BaseHelpUtils.isNullOrEmpty(bean.getDepartmentLeader())) {
							String[] arr = bean.getDepartmentLeader().split("，");
							for(String id : arr) {
								//生成发送给前期项目报备人所在部门的部门负责人的消息文本
								generateMsgByEmployeeId(losingBidMsgMap, BaseHelpUtils.getIntValue(id), bean.getContractCode(), bean.getContractName(), ContractStatusUtils.LOSING_BID_MSG);
							}
						}
					}else {
						//未出结果超过3个月，触发提醒给营销中心进行跟进
						//生成发送给市场部总监的消息文本
						if(null != noResultList && !noResultList.isEmpty()) {
							for(BaseEmployeeRole er : noResultList) {
								generateMsgByEmployeeId(noResultMsgMap, er.getEmployeeId(), bean.getContractCode(), bean.getContractName(), ContractStatusUtils.NO_RESULT_MSG);
							}
						}
						//生成发送给前期项目报备人的消息文本
						generateMsgByEmployeeId(noResultMsgMap, bean.getApplyEmployeeId(), bean.getContractCode(), bean.getContractName(), ContractStatusUtils.NO_RESULT_MSG);
						if(BaseHelpUtils.isNullOrEmpty(bean.getDepartmentLeader())) {
							String[] arr = bean.getDepartmentLeader().split("，");
							for(String id : arr) {
								//生成发送给前期项目报备人所在部门的部门负责人的消息文本
								generateMsgByEmployeeId(noResultMsgMap, BaseHelpUtils.getIntValue(id), bean.getContractCode(), bean.getContractName(), ContractStatusUtils.NO_RESULT_MSG);
							}
						}
					}
				}
				for(Integer key : noResultMsgMap.keySet()) {
					ERPWeixinUtils.sendWXMsgToUser(key, noResultMsgMap.get(key));
				}
				for(Integer key : losingBidMsgMap.keySet()) {
					ERPWeixinUtils.sendWXMsgToUser(key, losingBidMsgMap.get(key));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ContractStatusTask a = new ContractStatusTask();
		a.run();
	}
}
