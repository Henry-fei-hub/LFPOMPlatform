package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseWorkHandover;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.WorkHandover;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.role.bean.BaseGetProjectManagersByEmployeeId;
import pomplatform.role.bean.ConditionGetProjectManagersByEmployeeId;
import pomplatform.role.query.QueryGetProjectManagersByEmployeeId;
import pomplatform.workflow.business.OnWrokflowProcess;

public class ApplyForTransferWorker implements GenericWorkflowProcessor {

    protected BasePersonnelBusines bean = new BasePersonnelBusines();

    @Override
    public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
        bean.setDataFromMap(params);
        bean.setProcessType(pd.getProcessTypeId());
        PersonnelBusines dao = new PersonnelBusines();
        dao.setDataFromBase(bean);
        dataValidate(dao);
        dao.save();
        List<com.pomplatform.db.bean.BaseWorkHandover> list = GenericBase.__getList(
                params.get("list"), com.pomplatform.db.bean.BaseWorkHandover.newInstance());
        if (null != list) {
            for (BaseWorkHandover obj : list) {
                obj.setLinkId(dao.getPersonnelBusinessId());
            }
            WorkHandover workDao = new WorkHandover();
            workDao.save(list);
        }
        params.put("personnelBusinessId", dao.getPersonnelBusinessId());
        BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
        //增加附件的引用次数
        FileManageProcessor.addTimesById(bean.getAttachmentId());
        return ba;
    }

    @Override
    public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
        bean.setDataFromMap(params);
        if (!modified) {
            ProcessInstance pIns = pi.getProcessInstance();
            if (BaseHelpUtils.isNullOrEmpty(pIns)) {
                return null;
            }
            //获取当前审批节点
            ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
            if (BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
                return null;
            }
            //获取当前节点类型
            int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
            //只有处理节点才可以更改数据
            if (!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
                return null;
            }
        }
        PersonnelBusines dao = new PersonnelBusines();
        dao.setPrimaryKeyFromBase(bean);
        if (!dao.load()) throw new SQLException("Business data not found");
        dao.setDataFromBase(bean);
        dataValidate(dao);
        ColumnChangedData attachmentIdData = dao.getColumnChangedData(BasePersonnelBusines.CS_ATTACHMENT_ID);
        //修改附件的引用次数
        FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
        if (completed) {
            if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
                dao.setIsCompleted(Boolean.TRUE);
            }
        }
        dao.update();
        List<com.pomplatform.db.bean.BaseWorkHandover> list = GenericBase.__getList(
                params.get("list"), com.pomplatform.db.bean.BaseWorkHandover.newInstance());
        if (null != list) {
            WorkHandover workDao = new WorkHandover();
            for (BaseWorkHandover obj : list) {
                workDao.clear();
                workDao.setPrimaryKeyFromBase(obj);
                if (workDao.isPrimaryKeyNull()) {
                    obj.setLinkId(dao.getPersonnelBusinessId());
                    workDao.setDataFromBase(obj);
                    workDao.save();
                } else if (dao.load()) {
                    workDao.setDataFromBase(obj);
                    workDao.update();
                }
            }
        }
        String deleteId = BaseHelpUtils.getString(params.get("deleteIds"));
        if (!BaseHelpUtils.isNullOrEmpty(deleteId)) {
            String[] idString = deleteId.split(",");
            int length = idString.length;
            Integer[] ids = new Integer[length];
            for (int i = 0; i < length; i++) {
                ids[i] = BaseHelpUtils.getIntValue(idString[i]);
            }
            WorkHandover workDao = new WorkHandover();
            workDao.addCondition(BaseWorkHandover.CS_WORK_HANDOVER_ID, "in", (Object[]) ids);
            workDao.conditionalDelete();
        }
        BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
        return ba;
    }

    @Override
    public boolean computeExpression(String expression) throws Exception {
        Expression e = new Expression(expression);
        int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
        e = OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
        e.setValue("天数", bean.getDays() == null ? 0.0 : bean.getDays().doubleValue());
        return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
    }

    @Override
    public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
        if (null != roleId) {
            if (roleId.equals(StaticUtils.ROLE_PROJECT_MANAGER)) {
                ConditionGetProjectManagersByEmployeeId condition = new ConditionGetProjectManagersByEmployeeId();
                condition.setEmployeeId(processCreator);
                if (!BaseHelpUtils.isNullOrZero(bean.getNextAuditor())) {
                    condition.setExcluder(bean.getNextAuditor());
                }
                QueryGetProjectManagersByEmployeeId query = new QueryGetProjectManagersByEmployeeId();
                BaseCollection<BaseGetProjectManagersByEmployeeId> bc = query.executeQuery(null, condition);
                if (null != bc && null != bc.getCollections()) {
                    List<BaseGetProjectManagersByEmployeeId> list = bc.getCollections();
                    int size = list.size();
                    int[] arr = new int[size];
                    for (int i = 0; i < size; i++) {
                        arr[i] = list.get(i).getProjectManageId();
                    }
                    return arr;
                }
            }
        }

        //接收部门经理(获取接收部门的部门经理角色，如果有多个的情况则并行处理，只要一个人审批就行了)
        if (null != roleId && null != bean.getParentId() && Objects.equals(roleId, StaticUtils.ROLE_CUSTOM_AUDITOR)) {
            Set<Integer> ownerSet = new HashSet<>();
            EmployeeRole roles = new EmployeeRole();
            roles.setConditionDepartmentId("=", bean.getParentId());
            roles.setConditionRoleId("=", 3);
            List<BaseEmployeeRole> employeeRoleList = roles.conditionalLoad();

            if (employeeRoleList.size() > 0 && !BaseHelpUtils.isNullOrEmpty(employeeRoleList)) {
                int count = 0;
                for (BaseEmployeeRole baseEmployeeRole : employeeRoleList) {
                    if (null != baseEmployeeRole.getEmployeeId()) {
                        count++;
                        ownerSet.add(baseEmployeeRole.getEmployeeId());
                    }
                    if (count == 0) {
                        throw new Exception("未获取到部门经，流程发起失败");
                    }
                }
            }
            if (ownerSet.isEmpty()) {
                return new int[0];
            }
            int [] arr = new int[ownerSet.size()];
            int j = 0;
            for (Integer id : ownerSet) {
                arr[j++] = id;
            }
            return arr;
        }

        //转岗部门的行政负责人审批
        if (null != roleId && null != bean.getParentId() && Objects.equals(roleId, StaticUtils.DEPARTMENT_CHIEF_EXECUTIVE)) {
            return ProcessUtil.findNextOwner(processCreator, employeeId, bean.getParentId(), StaticUtils.DEPARTMENT_CHIEF_EXECUTIVE);
        }
        //转岗部门的分管领导审批
        if (null != poolType && null != roleId && null != bean.getParentId() && Objects.equals(roleId, StaticUtils.ROLE_CUSTOM_AUDITOR)) {
            if (poolType == 0) {//找分管领导
                return ProcessUtil.findNextOwner(processCreator, employeeId, bean.getParentId(), StaticUtils.ROLE_DEPARTMENT_MANAGER);
                //				Department dDao = new Department();
                //				dDao.setDepartmentId(bean.getParentId());
                //				if(dDao.load() && null != dDao.getPlateId()){
                //					if(dDao.getParentId() == 1){
                //						return ProcessUtil.findNextOwner(processCreator, employeeId, bean.getParentId(), StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER);
                //					}else{
                //						int plateId = dDao.getPlateId();
                //						dDao.clear();
                //						dDao.setConditionParentId("=", 1);
                //						dDao.setConditionPlateId("=", plateId);
                //						if(null != dDao.executeQueryOneRow()){
                //							return ProcessUtil.findNextOwner(processCreator, employeeId, dDao.getDepartmentId(), StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER);
                //						}else{
                //							return new int[0];
                //						}
                //					}
                //				}else{
                //					return new int[0];
                //				}
            } else {//并行找考勤管理员
                return ProcessUtil.findNextOwner(processCreator, employeeId, bean.getParentId(), StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR);
            }
        }
        //申请人自己操作的节点
        if (null != roleId && null != bean.getEmployeeId() && Objects.equals(roleId, StaticUtils.ROLE_OWN)) {
            return new int[]{bean.getEmployeeId()};
        }
        return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
    }

    @Override
    public String getBusinessData(Integer businessId) throws Exception {
        PersonnelBusines dao = new PersonnelBusines();
        dao.setPersonnelBusinessId(businessId);
        dao.load();
        dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getAttachmentId()));
        return dao.generateBase().toJSON();
    }

    private void dataValidate(PersonnelBusines dao) throws Exception {
        if (BaseHelpUtils.isNullOrZero(dao.getProcessType())) {
            throw new Exception("流程类型错误");
        }
        if (BaseHelpUtils.isNullOrZero(dao.getEmployeeId())) {
            throw new Exception("申请人不能为空");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())) {
            throw new Exception("工号不能为空");
        }
        Date sureDate = null;
        if (null == dao.getEndDate()) {
            sureDate = dao.getStartDate();
        } else {
            sureDate = dao.getEndDate();
        }
        if (null == sureDate) {
            throw new Exception("转岗日期不能为空");
        }
    }
}
