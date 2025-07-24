package delicacy.workflow.handler;

import java.util.Map;

import delicacy.common.BusinessAbstract;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.workflow.dao.ReimbursementWithR;

/**
 *
 * @author guangxun
 */
public class ReimbursementWithRExecutor extends ReimbursementWithRWorker {

    @Override
    public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
        bean.setDataFromMap(params);
        bean.setEmployeeId(employeeId);
        ReimbursementWithR dao = new ReimbursementWithR();
        dao.setDataFromBase(bean);
        dao.save();
        BusinessAbstract ba = new BusinessAbstract(dao.getReimbursementId(), dao.getSubject());
        return ba;
    }

    @Override
    public boolean computeExpression(String expression) throws Exception {
        return ProcessUtil.executeExpression(expression, "金额", bean.getAmount());
    }

    @Override
    public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
        // 如果角色是项目经理,需要知道申请人所选的项目,才能确定审批人员
        if (roleId != null && roleId == 4) {
            return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
        } else {
            return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
        }
    }

}
