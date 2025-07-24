package delicacy.oa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.servlet.CommonTimer;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.bean.BaseSystemProcessInstanceActivity;
import delicacy.system.bean.BaseSystemProcessPooledTask;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.account.bean.BaseOnGetLeftIntegralOfEmployee;
import pomplatform.account.bean.ConditionOnGetLeftIntegralOfEmployee;
import pomplatform.account.query.QueryOnGetLeftIntegralOfEmployee;
import pomplatform.common.utils.StaticUtils;

public class PersonnelBusinessTask extends TimerTask {

	private static final Logger __logger = Logger.getLogger(PersonnelBusinessTask.class);

	@Override
	public void run() {
		try {
			Date date = new Date();
			SystemProcessInstanceActivity activity = new SystemProcessInstanceActivity();
			// 加班申请，薪酬专员这一节点，如果4小时内不审批，则自动通过
			activity.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_17);
			activity.setConditionStatus("=", SystemProcessConstants.ACTIVITY_STATUS_ACTIVE);
			activity.setConditionBackViewName("=", "薪酬专员");
			List<BaseSystemProcessInstanceActivity> list = activity
					.conditionalLoad(BaseSystemProcessInstanceActivity.CS_INSTANCE_ACTIVITY_START_TIME
							+ " is not null and " + BaseSystemProcessInstanceActivity.CS_OPERATE_TIME + " is null");
			int size = list.size();
			for (int i = 0; i < size; i++) {
				BaseSystemProcessInstanceActivity obj = list.get(i);
				if (date.getTime() - obj.getInstanceActivityStartTime().getTime() >= CommonTimer.PERIOD_HOUR * 4) {
					try {
						ThreadConnection.beginTransaction();
						obj.setStatus(SystemProcessConstants.ACTIVITY_STATUS_PASS);
						obj.setOperateTime(date);
						activity.clear();
						activity.setDataFromBase(obj);
						activity.update();
						SystemProcessInstance instance = new SystemProcessInstance();
						instance.setProcessInstanceId(obj.getProcessInstanceId());
						if (instance.load()) {
							instance.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_COMPLETED);
							instance.setCompleteTime(date);
							instance.update();
						}
						PersonnelBusines business = new PersonnelBusines();
						business.setPersonnelBusinessId(obj.getBusinessId());
						if (business.load()) {
							business.setIsCompleted(true);
							business.update();
						}
						ThreadConnection.commit();
					}catch(Exception e) {
						e.printStackTrace();
						ThreadConnection.rollback();
					}
				}
			}
			activity.clear();
			//凡是5天内没有审批的打卡申请，一概驳回
			activity.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_15);
			activity.setConditionStatus("=", SystemProcessConstants.ACTIVITY_STATUS_ACTIVE);
			activity.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
			activity.setConditionInstanceActivityStartTime("<=", new Date(date.getTime() - DateUtil.ONEDAY_MILLISECONDS * 5));
			activity.unsetSelectFlags();
			activity.setSelectProcessInstanceId(true);
			list = activity.conditionalLoad();
			size = list.size();
			if (size > 0) {
				try {
					ThreadConnection.beginTransaction();
					activity.setStatus(SystemProcessConstants.ACTIVITY_STATUS_REJECT);
					activity.setOperateTime(date);
					activity.conditionalUpdate();
					Set<Integer> instanceIds = new HashSet<>();
					Set<Integer> poolTask = new HashSet<>();
					for(BaseSystemProcessInstanceActivity activityBean : list){
						instanceIds.add(activityBean.getProcessInstanceId());
						poolTask.add(activityBean.getProcessInstanceActivityId());
					}
					SystemProcessInstance instanceDao = new SystemProcessInstance();
					instanceDao.addCondition(BaseSystemProcessInstance.CS_PROCESS_INSTANCE_ID, "in", instanceIds.toArray());
					instanceDao.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_REJECT);
					instanceDao.setCompleteTime(date);
					instanceDao.conditionalUpdate();
					SystemProcessPooledTask taskDao = new SystemProcessPooledTask();
					taskDao.addCondition(BaseSystemProcessPooledTask.CS_INSTANCE_ACTIVITY_ID, "in", poolTask.toArray());
					taskDao.setOperateTime(date);
					taskDao.setStatus(SystemProcessConstants.POOLED_TASK_STATUS_DONE);
					taskDao.conditionalUpdate();
					ThreadConnection.commit();
				}catch(Exception e) {
					e.printStackTrace();
					ThreadConnection.rollback();
				}
			}
			try {
				//杰拓的离职流程，任何一个节点超过三天没有审批，则此节点自动跳过
				ThreadConnection.beginTransaction();
				SystemProcessInstance spiDao = new SystemProcessInstance();
				spiDao.setConditionProcessId("=", 175);//仅限杰拓的离职流程
				spiDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
				Integer[] processStatusArr = {SystemProcessConstants.PROCESS_STATUS_NEW_CREATED, SystemProcessConstants.PROCESS_STATUS_WORKING};
				spiDao.addCondition(BaseSystemProcessInstance.CS_PROCESS_STATUS, "in", (Object[])processStatusArr);
				List<BaseSystemProcessInstance> spiList = spiDao.conditionalLoad();
				for(BaseSystemProcessInstance spiBean : spiList) {
					activity.clear();
					activity.setConditionProcessInstanceId("=", spiBean.getProcessInstanceId());
					activity.setConditionActivityId("<>", 0);
					activity.setConditionNextActivityId("<>", 0);
					List<BaseSystemProcessInstanceActivity> activityList = activity.conditionalLoad("order by activity_id");
					for(int i = 0; i < activityList.size(); i++) {
						BaseSystemProcessInstanceActivity activityBean = activityList.get(i);
						if(!Objects.equals(activityBean.getStatus(), SystemProcessConstants.ACTIVITY_STATUS_ACTIVE)) {
							continue;
						}
						if(null == activityBean.getInstanceActivityStartTime() || (date.getTime() - activityBean.getInstanceActivityStartTime().getTime() < CommonTimer.PERIOD_DAY * 3)) {
							continue;
						}
						activity.setDataFromBase(activityBean);
						activity.clearModifiedFlags();
						activity.setStatus(SystemProcessConstants.ACTIVITY_STATUS_PASS);
						activity.setOperateTime(date);
						activity.update();
						SystemProcessPooledTask spptDao = new SystemProcessPooledTask();
						spptDao.setConditionInstanceActivityId("=", activity.getProcessInstanceActivityId());
						spptDao.setStatus(SystemProcessConstants.ACTIVITY_STATUS_PASS);
						spptDao.conditionalUpdate();
						if(i + 1 == activityList.size()) {
							//流程走完
							spiDao.clear();
							spiDao.setDataFromBase(spiBean);
							spiDao.clearModifiedFlags();
							spiDao.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_COMPLETED);
							spiDao.setCompleteTime(date);
							spiDao.update();
							PersonnelBusines pbDao = new PersonnelBusines();
							pbDao.setPersonnelBusinessId(spiBean.getBusinessId());
							pbDao.load();
							ConditionOnGetLeftIntegralOfEmployee condition = new ConditionOnGetLeftIntegralOfEmployee();
					    	condition.setEmployeeId(pbDao.getEmployeeId());
					    	QueryOnGetLeftIntegralOfEmployee query = new QueryOnGetLeftIntegralOfEmployee();
					    	BaseCollection<BaseOnGetLeftIntegralOfEmployee> result = query.executeQuery(null, condition);
					    	if(null != result && null != result.getCollections() && !result.getCollections().isEmpty()) {
					    		BaseOnGetLeftIntegralOfEmployee employeeInteger = result.getCollections().get(0);
					    		pbDao.setLivingExpenses(BaseHelpUtils.getBigDecimalValue(employeeInteger.getIntegral()));
					    		BigDecimal fee = pbDao.getLivingExpenses().subtract(BaseHelpUtils.getBigDecimalValue(pbDao.getHousingFinance()));
					    		if(fee.compareTo(BigDecimal.ZERO) < 0) {
					    			fee = BigDecimal.ZERO;
					    		}
					    		pbDao.setFee(fee);
					    	}
					    	pbDao.setIsCompleted(true);
					    	pbDao.update();
						}else {
							//流程未走完，修改下一个节点为活跃状态
							activity.clear();
							activity.setDataFromBase(activityList.get(i + 1));
							activity.clearModifiedFlags();
							activity.setInstanceActivityStartTime(date);
							activity.setStatus(SystemProcessConstants.ACTIVITY_STATUS_ACTIVE);
							activity.update();
							//修改该节点的任务池为活跃状态
							spptDao.clear();
							spptDao.setConditionInstanceActivityId("=", activity.getProcessInstanceActivityId());
							spptDao.setStatus(SystemProcessConstants.POOLED_TASK_STATUS_ACTIVE);
							spptDao.conditionalUpdate();
							//修改该节点的知会节点为毁约状态
							SystemProcessAttention spaDao = new SystemProcessAttention();
							spaDao.setConditionInstanceActivityId("=", activity.getProcessInstanceActivityId());
							spaDao.setStatus(SystemProcessConstants.ATTENTION_STATUS_ACTIVE);
							spaDao.conditionalUpdate();
							//如果流程是新建状态，则修改为运行中状态
							if(Objects.equals(spiBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_NEW_CREATED)) {
								spiDao.clear();
								spiDao.setDataFromBase(spiBean);
								spiDao.clearModifiedFlags();
								spiDao.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_WORKING);
								spiDao.update();
							}
						}
						break;
					}
				}
				ThreadConnection.commit();
			}catch(Exception e) {
				e.printStackTrace();
				ThreadConnection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
