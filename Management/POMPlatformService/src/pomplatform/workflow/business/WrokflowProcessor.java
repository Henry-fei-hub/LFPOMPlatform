package pomplatform.workflow.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import delicacy.system.bean.BaseSystemProcessPooledTask;
import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import delicacy.system.dao.SystemProcessType;
import delicacy.system.executor.SystemProcessConstants;
import message.common.ERPWeixinUtils;
import pomplatform.workflow.bean.BaseUpdateActivityEmployee;

public class WrokflowProcessor implements GenericProcessor {
	private static Logger __logger = Logger.getLogger("");

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, "optType");
		switch(optType) {
		case "delayReject":
			return delayReject(params);
		case "updateActivityEmployee":
			return updateActivityEmployee(params);
		default :
			return null;
		}
	}
	
	/**
	 * 流程滞留驳回
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String delayReject(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int processInstanceId = BaseHelpUtils.getIntValue(params.get("processInstanceId"));
		if(processInstanceId == 0) {
			return bc.toJSON(-1, "参数错误");
		}
		int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
		String code = BaseHelpUtils.getString(params.get("code"));
		Date date = new Date();
		ThreadConnection.beginTransaction();
		SystemProcessInstance spiDao = new SystemProcessInstance();
		spiDao.setProcessInstanceId(processInstanceId);
		if(spiDao.load()) {
			Integer msgReceiver = spiDao.getEmployeeId();
			spiDao.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_DELAY_REJECT);
			spiDao.setCompleteTime(date);
			spiDao.update();
			SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
			spiaDao.setConditionProcessInstanceId("=", processInstanceId);
			spiaDao.setConditionStatus("=", SystemProcessConstants.ACTIVITY_STATUS_ACTIVE);
			BaseSystemProcessInstanceActivity spiaBean = spiaDao.executeQueryOneRow();
			if(null != spiaBean) {
				spiaDao.setDataFromBase(spiaBean);
				spiaDao.clearModifiedFlags();
				spiaDao.setProcessComment("停滞驳回");
				spiaDao.setStatus(SystemProcessConstants.ACTIVITY_STATUS_DELAY_REJECT);
				spiaDao.setOperateTime(date);
				spiaDao.setEmployeeId(employeeId);
				spiaDao.update();
				if(null == spiaBean.getEmployeeId()) {
					SystemProcessPooledTask taskDao = new SystemProcessPooledTask();
					taskDao.setConditionInstanceActivityId("=", spiaBean.getProcessInstanceActivityId());
					taskDao.setStatus(SystemProcessConstants.ACTIVITY_STATUS_DELAY_REJECT);
					taskDao.setOperateTime(date);
					taskDao.conditionalUpdate();
				}
			}
			ThreadConnection.commit();
			SystemProcessType typeDao = new SystemProcessType();
			typeDao.setProcessTypeId(spiDao.getProcessType());
			typeDao.load();
			ERPWeixinUtils.sendWXMsgToUser(msgReceiver, String.format("你发起的%1$s单号[%2$s]因滞留时间过长，已被驳回", typeDao.getProcessTypeName(), code));
		}else {
			return bc.toJSON(-1, "无法获取流程数据");
		}
		return bc.toJSON();
	}

	/**
	 * 更改节点审批人
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String updateActivityEmployee(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		List<BaseUpdateActivityEmployee> dataList = GenericBase.__getList(params.get("activityDatas"), BaseUpdateActivityEmployee.newInstance());
		if(null == dataList || dataList.isEmpty()) {
			return bc.toJSON(-1, "请选择需要更改节点审批人的记录");
		}
		int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
		Set<Integer> activityIds = new HashSet<>();
		Set<Integer> taskIds = new HashSet<>();
		Integer[] activityStatus = {SystemProcessConstants.ACTIVITY_STATUS_NEW_CREATED, SystemProcessConstants.ACTIVITY_STATUS_ACTIVE};
		Integer[] poolTaskStatus = {SystemProcessConstants.POOLED_TASK_STATUS_NEW, SystemProcessConstants.POOLED_TASK_STATUS_ACTIVE};
		for(BaseUpdateActivityEmployee activity : dataList) {
			if(Objects.equals(1, activity.getNodeType())) {
				activityIds.add(BaseHelpUtils.getIntValue(activity.getNodeId()));
			}else if(Objects.equals(2, activity.getNodeType())) {
				taskIds.add(BaseHelpUtils.getIntValue(activity.getNodeId()));
			}
		}
		if(activityIds.size() > 0) {
			SystemProcessInstanceActivity dao = new SystemProcessInstanceActivity();
			dao.addCondition(BaseSystemProcessInstanceActivity.CS_PROCESS_INSTANCE_ACTIVITY_ID, "in", activityIds.toArray());
			dao.addCondition(BaseSystemProcessInstanceActivity.CS_STATUS, "in", (Object[])activityStatus);
			dao.setEmployeeId(employeeId);
			dao.conditionalUpdate();
		}
		if(taskIds.size() > 0) {
			SystemProcessPooledTask dao = new SystemProcessPooledTask();
			dao.addCondition(BaseSystemProcessPooledTask.CS_PROCESS_POOLED_TASK_ID, "in", taskIds.toArray());
			dao.addCondition(BaseSystemProcessPooledTask.CS_STATUS, "in", (Object[])poolTaskStatus);
			dao.setEmployeeId(employeeId);
			dao.conditionalUpdate();
		}
		return bc.toJSON();
	}
}
