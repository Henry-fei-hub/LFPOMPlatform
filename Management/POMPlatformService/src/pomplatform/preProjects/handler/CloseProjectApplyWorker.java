package pomplatform.preProjects.handler;

import java.sql.SQLException;
import java.util.Map;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.preProjects.bean.BasePreProjectWithMmm;
import pomplatform.preProjects.dao.PreProjectWithMmm;
import pomplatform.workflow.business.OnWrokflowProcess;

public class CloseProjectApplyWorker implements GenericWorkflowProcessor {

	protected BasePreProjectWithMmm bean = new BasePreProjectWithMmm();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd,Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		PreProjectWithMmm dao = new PreProjectWithMmm();
		dao.setPrimaryKeyFromBase(bean);
		dao.setDataFromBase(bean);
		dao.setStatus(4);//关闭进行中
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPreProjectId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi,Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}

			//获取当前审批节点
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			//获取当前节点类型
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			//只有处理节点才可以更改数据
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
				return null;
			}
		}
		PreProjectWithMmm dao = new PreProjectWithMmm();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setStatus(5);//关闭成功
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
				dao.setStatus(6);//关闭失败
			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPreProjectId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getApplyEmployeeId());
		e =OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
		if(expression.contains("前期项目状态") && BaseHelpUtils.getIntValue(bean.getStatus()) > 0){
			e.setValue("前期项目状态", SelectValueCache.getSelectValue("system_dictionary_161", String.valueOf(bean.getStatus())));
			return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
		}else{
			return false;
		}
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PreProjectWithMmm dao = new PreProjectWithMmm();
		dao.setPreProjectId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
