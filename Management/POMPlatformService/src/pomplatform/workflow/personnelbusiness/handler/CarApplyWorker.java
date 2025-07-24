package pomplatform.workflow.personnelbusiness.handler;

import com.pomplatform.db.bean.BaseCarCostAllocation;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.*;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.*;
import delicacy.system.dao.Department;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.project.bean.BaseGetProjectManagerByProjectId;
import pomplatform.project.bean.ConditionGetProjectManagerByProjectId;
import pomplatform.project.query.QueryGetProjectManagerByProjectId;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.commonNormalReimbursement.handler.NormalReimbursementWithDepartmentWorker;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithC;
import pomplatform.workflow.personnelbusiness.dao.PersonnelBusinesWithC;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 新的用车申请审批流程
 * @author xiaolong
 */
public class CarApplyWorker implements GenericWorkflowProcessor {
    protected BasePersonnelBusinesWithC bean = new BasePersonnelBusinesWithC();

    @Override
    public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
        bean.setDataFromMap(params);
        bean.setProcessType(pd.getProcessTypeId());
        PersonnelBusinesWithC dao = new PersonnelBusinesWithC();
        dao.setDataFromBase(bean);
        dataValidate(dao);
        dao.save();
        BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
        return ba;
    }

    @Override
    public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
                                            boolean completed) throws Exception {
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
            if (!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
                return null;
            }
        }
        PersonnelBusinesWithC dao = new PersonnelBusinesWithC();
        dao.setPrimaryKeyFromBase(bean);
        if (!dao.load()) throw new SQLException("Business data not found");
        dao.setDataFromBase(bean);
        if (null == dao.getDetailCarCostAllocation()) {
            CarCostAllocation costDao = new CarCostAllocation();
            costDao.setConditionPersonnelBusinessId("=", dao.getPersonnelBusinessId());
            dao.setDetailCarCostAllocation(costDao.conditionalLoad());
        }
        dataValidate(dao);

        if (completed) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


            Employee empDao = new Employee();
            empDao.setEmployeeId(dao.getEmployeeId());
            empDao.unsetSelectFlags();
            empDao.setSelectEmployeeName(true);
            empDao.setSelectMobile(true);
            sb1.append("您的用车申请已通过审批，详情信息如下：\n出发地：")
                    .append(dao.getProjectName())
                    .append("；\n目的地：")
                    .append(dao.getProjectCode())
                    .append("；\n出发时间：")
                    .append(format.format(dao.getStartDate()))
                    .append("。\n祝您一路顺风！");

            sb2.append("您有一条派车任务，详情如下：\n出发地：")
                    .append(dao.getProjectName())
                    .append("；\n目的地：")
                    .append(dao.getProjectCode())
                    .append("；\n出发时间：")
                    .append(format.format(dao.getStartDate()));

            if (empDao.load()) {
                sb2.append("；\n出行人：").append(empDao.getEmployeeName());
            }
            sb2.append("；\n出行人联系方式：").append(dao.getCard()).append("。\n祝您一路顺风！");


            if (null != dao.getDrafter()) {
                // 发消息给申请人
                ERPWeixinUtils.sendWXMsgToUser(dao.getDrafter(), sb1.toString());
            }
            if (null != dao.getContactPerson()){
                // 发消息给司机
                ERPWeixinUtils.sendWXMsgToUser(BaseHelpUtils.getIntValue(dao.getContactPerson()), sb2.toString());
            }

            if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
                dao.setIsCompleted(true);
                //成本归属
                if (null != dao.getStartDateDetail() && null != dao.getDetailCarCostAllocation() && !dao.getDetailCarCostAllocation().isEmpty()) {
                    dao.setIsRemoteCity(true);
                    List<BaseCarCostAllocation> list = dao.getDetailCarCostAllocation();
                    Integer processTypeId = pi.getProcessInstance().getProcessType();
                    Integer businessId = dao.getPersonnelBusinessId();
                    String remark = dao.getReason();
                    Integer processId = pi.getProcessInstance().getProcessId();
                    Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
                    if (dao.getStartDateDetail().intValue() == StaticUtils.DEPARTMENT_USE_CAR) {
                        //部门成本
                        Date date = new Date();
                        Calendar c = Calendar.getInstance();
                        c.setTime(date);
                        PlateCostRecord pcrDao = new PlateCostRecord();
                        pcrDao.setConditionProcessInstanceId("=", processInstanceId);
                        pcrDao.setConditionProcessType("=", processTypeId);
                        if (pcrDao.countRows() <= 0) {
                            for (BaseCarCostAllocation obj : list) {
                                //保存部门成本
                                PlateCostRecord plateCostRecord = new PlateCostRecord();
                                Department department = new Department();
                                department.setDepartmentId(obj.getId());
                                if (department.load()) {
                                    plateCostRecord.setPlateId(department.getPlateId());
                                }
                                plateCostRecord.setCostIntegral(obj.getCostAllocation());
                                plateCostRecord.setSalaryIntegral(new BigDecimal("0"));
                                plateCostRecord.setIsSettlement(false);
                                //获取当前的年月
                                plateCostRecord.setYear(c.get(Calendar.YEAR));
                                plateCostRecord.setMonth(c.get(Calendar.MONTH) + 1);
                                plateCostRecord.setCostDate(date);
                                plateCostRecord.setProcessType(processTypeId);
                                plateCostRecord.setBusinessId(businessId);
                                plateCostRecord.setProcessId(processId);
                                plateCostRecord.setProcessInstanceId(processInstanceId);
                                plateCostRecord.setRemark(remark);
                                plateCostRecord.save();
                                //同时更新数据到部门积分汇总表中
                                PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
                                plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
                                plateAccountRecordDao.setBusinessId(plateCostRecord.getPlateCostRecordId());
                                plateAccountRecordDao.setPlateId(plateCostRecord.getPlateId());
                                plateAccountRecordDao.setIntegral(plateCostRecord.getCostIntegral());
                                plateAccountRecordDao.setRecordDate(plateCostRecord.getCostDate());
                                plateAccountRecordDao.setOperateEmployeeId(dao.getEmployeeId());
                                plateAccountRecordDao.setOperateTime(date);
                                plateAccountRecordDao.setRemark(remark);
                                plateAccountRecordDao.save();
                            }
                        }
                    } else if (dao.getStartDateDetail().intValue() == StaticUtils.PROJECT_USE_CAR) {
                        //项目成本挂钩到项目上去
                        ProjectCost costDao = new ProjectCost();
                        costDao.setConditionProcessInstanceId("=", processInstanceId);
                        costDao.setConditionProcessType("=", processTypeId);
                        if (costDao.countRows() <= 0) {
                            Date date = new Date();
                            Integer costEmployeeId = dao.getEmployeeId();
                            List<BaseProjectCost> costList = new ArrayList<>();
                            for (BaseCarCostAllocation obj : list) {
                                BaseProjectCost cost = new BaseProjectCost();
                                cost.setAmount(obj.getCostAllocation());
                                cost.setProjectId(obj.getId());
                                cost.setCostDate(date);
                                cost.setEmployeeId(costEmployeeId);
                                cost.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
                                cost.setProcessType(processTypeId);
                                cost.setBusinessId(businessId);
                                cost.setProcessId(processId);
                                cost.setProcessInstanceId(processInstanceId);
                                costList.add(cost);
                            }
                            costDao.clear();
                            costDao.save(costList);
                        }
                    }
                }
            }
        }
        dao.update();
        BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
        return ba;
    }

    @Override
    public boolean computeExpression(String expression) throws Exception {
        Expression e = new Expression(expression);
        int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
        e = OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
        e.setValue("用车范围", bean.getType().intValue() == 0 ? "市内用车" : "");
        e.setValue("类型", bean.getStartDateDetail().intValue() == StaticUtils.DEPARTMENT_USE_CAR ? "部门用车" : "");
        return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
    }

    @Override
    public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
                                   Integer poolType) throws Exception {
        Employee employee = new Employee();
        employee.setConditionEmployeeId("=",processCreator);
        BaseEmployee employeeBean = employee.executeQueryOneRow();
        int myDepartmentId = 0;
        if (null!=employeeBean){
            myDepartmentId = employeeBean.getDepartmentId();
        }

        int[] arr;
        if (null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)) {
            Set<Integer> ownerSet = new HashSet<>();

            //获取部门经理
            EmployeeRole roles = new EmployeeRole();
            roles.setConditionDepartmentId("=", myDepartmentId);
            roles.setConditionRoleId("=", 3);
            List<BaseEmployeeRole> employeeRoleList = roles.conditionalLoad();
            roles.clear();

            EmployeeRole rolesTwo = new EmployeeRole();
            //获取部门副经理
            rolesTwo.setConditionDepartmentId("=", myDepartmentId);
            rolesTwo.setConditionRoleId("=", 146);
            List<BaseEmployeeRole> employeeRoleListTwo = rolesTwo.conditionalLoad();

            if (employeeRoleList.size() > 0 && !BaseHelpUtils.isNullOrEmpty(employeeRoleList)) {
                int count = 0;
                for (BaseEmployeeRole baseEmployeeRole : employeeRoleList) {
                    if (null != baseEmployeeRole.getEmployeeId()) {
                        count++;
                        ownerSet.add(baseEmployeeRole.getEmployeeId());
                    }
                    if (count == 0) {
                        throw new Exception("未获取到部门经理或副经理，流程发起失败");
                    }
                }

            }

            if (employeeRoleListTwo.size() > 0 && !BaseHelpUtils.isNullOrEmpty(employeeRoleListTwo)) {
                int count = 0;
                for (BaseEmployeeRole baseEmployeeRole : employeeRoleListTwo) {
                    if (null != baseEmployeeRole.getEmployeeId()) {
                        count++;
                        ownerSet.add(baseEmployeeRole.getEmployeeId());
                    }
                    if (count == 0) {
                        throw new Exception("未获取到部门经理或副经理，流程发起失败");
                    }
                }
            }

            if (ownerSet.isEmpty()) {
                return new int[0];
            }
            arr = new int[ownerSet.size()];
            int j = 0;

            for (Integer id : ownerSet) {
                arr[j++] = id;
            }

            if (null != bean.getStartDateDetail()) {
                if (bean.getStartDateDetail().intValue() == StaticUtils.PRE_PROJECT_USE_CAR) {
                    int[] ids = {bean.getNextAuditor()};
                    return ids;
                } else if (bean.getStartDateDetail().intValue() == StaticUtils.PROJECT_USE_CAR) {
                    //专业负责人
                    Set<Integer> set = new HashSet<>();
                    List<BaseCarCostAllocation> list = bean.getDetailCarCostAllocation();
                    if (null != list && !list.isEmpty()) {
                        for (BaseCarCostAllocation obj : list) {
                            ConditionGetProjectManagerByProjectId condition = new ConditionGetProjectManagerByProjectId();
                            condition.setProjectId(obj.getId());
                            QueryGetProjectManagerByProjectId query = new QueryGetProjectManagerByProjectId();
                            BaseCollection<BaseGetProjectManagerByProjectId> bc = query.executeQuery(null, condition);
                            if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty() && null != bc.getCollections().get(0).getProjectManageId()) {
                                set.add(bc.getCollections().get(0).getProjectManageId());
                            }
                        }
                    }
                    if (set.size() > 0) {
                        int size = set.size();
                        int[] ids = new int[size];
                        int i = 0;
                        for (Integer id : set) {
                            if (i < size) {
                                ids[i++] = id;
                            }
                        }
                        return ids;
                    } else {
                        return new int[0];
                    }
                }
            }
            return arr;
        }

        if (null != roleId && roleId.equals(StaticUtils.ROLE_DEPARTMENT_LEADER)) {
            Set<Integer> ownerSet = new HashSet<>();
            List<BaseCarCostAllocation> list = bean.getDetailCarCostAllocation();
            switch (bean.getStartDateDetail().intValue()) {
                case StaticUtils.DEPARTMENT_USE_CAR:
                    if (list == null || list.isEmpty()) {
                        throw new SQLException("请选择一个部门！");
                    }
                    for (BaseCarCostAllocation b : list) {
                        Integer id = b.getId();
                        if (id == null || id.equals(0)) {
                            throw new Exception("请选择一个部门！");
                        }
                        findNextOwnerByDepIdAndRoleId(id, roleId, ownerSet);
                    }
                case StaticUtils.PROJECT_USE_CAR:
                    if (list == null || list.isEmpty()) {
                        throw new SQLException("请选择一个订单！");
                    }
                    StringBuilder sb = new StringBuilder();
                    for (BaseCarCostAllocation b : list) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(BaseHelpUtils.getIntValue(b.getId()));
                    }
                    Employee eDao = new Employee();
                    eDao.setEmployeeId(bean.getNextAuditor());
                    eDao.unsetSelectFlags();
                    eDao.setSelectDepartmentId(true);
                    List<BaseEmployee> eList = eDao.conditionalLoad("employee_id in ( select project_manage_id from projects where project_id in (" + sb.toString() + "))");
                    for (BaseEmployee eBean : eList) {
                        findNextOwnerByDepIdAndRoleId(eBean.getDepartmentId(), roleId, ownerSet);
                    }
                    break;
                case StaticUtils.PRE_PROJECT_USE_CAR:
                    if (null == bean.getNextAuditor()) {
                        throw new Exception("请选择项目经理");
                    }
                    Employee employeeDao = new Employee();
                    employeeDao.setEmployeeId(bean.getNextAuditor());
                    employeeDao.unsetSelectFlags();
                    employeeDao.setSelectDepartmentId(true);
                    if (employeeDao.load()) {
                        findNextOwnerByDepIdAndRoleId(employeeDao.getDepartmentId(), roleId, ownerSet);
                    }
                    break;
            }

            if (!ownerSet.isEmpty()) {
                int length = ownerSet.size();
                int[] activityOwners = new int[length];
                int i = 0;
                for (Integer obj : ownerSet) {
                    activityOwners[i++] = BaseHelpUtils.getIntValue(obj);
                }
                return activityOwners;
            } else {
                return new int[0];
            }
        }
        return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
    }

    /**
     * 根据部门ID和角色ID查找符合条件的在职员工ID
     *
     * @param departmentId
     * @param roleId
     * @param ownerSet
     * @throws Exception
     */
    public void findNextOwnerByDepIdAndRoleId(Integer departmentId, Integer roleId, Set<Integer> ownerSet) throws Exception {
        do {
            int[] tempArr = NormalReimbursementWithDepartmentWorker.findNextOwner(departmentId, roleId);
            if (null != tempArr && tempArr.length > 0) {
                for (int userId : tempArr) {
                    ownerSet.add(userId);
                }
                break;
            } else {
                Department departmentDao = new Department();
                departmentDao.unsetSelectFlags();
                departmentDao.setSelectParentId(true);
                departmentDao.setConditionDepartmentId("=", departmentId);
                departmentId = departmentDao.executeQueryOneRow().getParentId();
            }
        } while (null != departmentId && !departmentId.equals(1) && !departmentId.equals(0));
    }

    @Override
    public String getBusinessData(Integer businessId) throws Exception {
        PersonnelBusinesWithC dao = new PersonnelBusinesWithC();
        dao.setPersonnelBusinessId(businessId);
        dao.load(true);
        return dao.generateBaseExt().toJSON();
    }

    private void dataValidate(PersonnelBusinesWithC dao) throws Exception {
        if (BaseHelpUtils.isNullOrZero(dao.getProcessType())) {
            throw new Exception("流程类型错误");
        }
        if (BaseHelpUtils.isNullOrZero(dao.getEmployeeId())) {
            throw new Exception("申请人不能为空");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getCard())) {
            throw new Exception("请填写手机号码");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getType())) {
            throw new Exception("请选择用车范围");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getUnit())) {
            throw new Exception("请填写同行人数");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getAddress())) {
            throw new Exception("请填写申请用车车型");
        }
        Date startDate = dao.getStartDate();
        if (BaseHelpUtils.isNullOrEmpty(startDate)) {
            throw new Exception("用车开始时间不能为空");
        }
        Date endDate = dao.getEndDate();
        if (BaseHelpUtils.isNullOrEmpty(endDate)) {
            throw new Exception("用车结束时间不能为空");
        }
        if (startDate.getTime() >= endDate.getTime()) {
            throw new Exception("用车结束时间必须晚于用车开始时间");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getProjectName())) {
            throw new Exception("请填写出发地");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getProjectCode())) {
            throw new Exception("请填写目的地");
        }
        if (BaseHelpUtils.isNullOrEmpty(dao.getReason())) {
            throw new Exception("请填写用车目的");
        }
        if (null == dao.getDetailCarCostAllocation() || dao.getDetailCarCostAllocation().isEmpty()) {
            throw new Exception("请填写用车成本分摊记录");
        }
    }


    /**
     * 测试获取到的部门经理和部门副经理
     *
     * @param args
     */
    public static void main(String[] args) throws SQLException {

        EmployeeRole roles = new EmployeeRole();
        roles.setConditionEmployeeId("=", 8);
        roles.setConditionRoleId("=", 3);
        roles.setConditionRoleId("=", 146);

        List<BaseEmployeeRole> employeeRoleList = roles.conditionalLoad();
        for (BaseEmployeeRole baseEmployeeRole : employeeRoleList) {
            System.out.println("获取到的角色id" + baseEmployeeRole.getEmployeeId());
        }
    }

}
