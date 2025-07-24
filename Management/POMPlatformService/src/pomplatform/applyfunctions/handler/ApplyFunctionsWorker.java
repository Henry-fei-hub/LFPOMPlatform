package pomplatform.applyfunctions.handler;
import com.pomplatform.db.bean.BaseFunctionBusiness;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.FunctionBusiness;
import com.pomplatform.db.dao.PersonnelBusines;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.*;
import delicacy.system.dao.EmployeeFunction;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * 申请权限的流程
 */
public class ApplyFunctionsWorker implements GenericWorkflowProcessor {

    protected BasePersonnelBusines bean = new BasePersonnelBusines();

    /**
     * 新建流程的时候调用
     *
     * @param pd
     * @param params
     * @param employeeId
     * @return
     * @throws Exception
     */
    @Override
    public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {

        System.out.println("新建流程节点的方法ApplyFunctionsWorker"+params);

        bean.setDataFromMap(params);
        bean.setProcessType(BaseHelpUtils.getIntValue(pd.getProcessTypeId()));
        bean.setDrafter(bean.getEmployeeId());
        PersonnelBusines dao = new PersonnelBusines();
        dao.setDataFromBase(bean);
        dao.save();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("detailRoleFunction");

        /**
         * 如果用户的权限已经在功能权限表里存在的话则将该权限勾选
         */
        if (null != list && !list.isEmpty()) {
            for (Map<String, Object> map : list) {
                list1.add(BaseHelpUtils.getIntValue(map.get("functionId")));
            }

            //根据传入的员工id将员工拥有的权限查出来
            EmployeeFunction edao = new EmployeeFunction();
            edao.setConditionEmployeeId("=", bean.getEmployeeId());

            List<BaseEmployeeFunction> elist = edao.conditionalLoad();

            for (BaseEmployeeFunction efBean : elist) {
                list2.add(BaseHelpUtils.getIntValue(efBean.getFunctionId()));
            }
            //从右边功能区将已获得的权限移除，这样就得到了可以申请的权限列表
            list1.removeAll(list2);

            System.out.println("移除后的可申请权限列表"+list.removeAll(list2));

        }

        /**
         * 判断list1条件，然后
         */
        if (null != list1 && !list1.isEmpty()) {
            List<BaseFunctionBusiness> newFunctionList = new ArrayList<>();
            for (Integer functionId : list1) {
                BaseFunctionBusiness obj = new BaseFunctionBusiness();
                obj.setFunctionId(functionId);
                obj.setPersonnelBusinessId(dao.getPersonnelBusinessId());
                obj.setEmployeeId(dao.getEmployeeId());
                obj.setStartDate(dao.getStartDate());
                obj.setEndDate(dao.getEndDate());
                obj.setFunctionType(BaseHelpUtils.getIntValue(params.get("parentId")));
                obj.setDays(BaseHelpUtils.getBigDecimalValue(params.get("days")));

                //是否是永久权限
                if (BaseHelpUtils.getBigDecimalValue(params.get("days")) != null) {
                    obj.setIsForever(false);
                } else {
                    obj.setIsForever(true);
                }

                obj.setIsCompleted(false);
                newFunctionList.add(obj);
            }

            if (newFunctionList.size() > 0) {
                //将申请的权限数据插入到数据库中
                FunctionBusiness fbDao = new FunctionBusiness();
                fbDao.save(newFunctionList);
            }
        }
        BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
        return ba;
    }

    /**
     * 执行流程节点的方法
     *
     * @param pi
     * @param params
     * @param employeeId
     * @param modified
     * @param completed
     * @return
     * @throws Exception
     */
    @Override
    public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {

        System.out.println("执行流程节点的方法ApplyFunctionsWorker"+params);

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

        //人事业务表
        PersonnelBusines dao = new PersonnelBusines();
        dao.setPrimaryKeyFromBase(bean);
        if (!dao.load()) {
            throw new SQLException("Business data not found");
        }
        dao.setDataFromBase(bean);

        int employeeIds = BaseHelpUtils.getIntValue(params.get("employeeId"));
        Date startDate = new Date(BaseHelpUtils.getLongValue(params.get("startDate")));
        Date endDate = new Date(BaseHelpUtils.getLongValue(params.get("endDate")));
        BigDecimal days = BaseHelpUtils.getBigDecimalValue(params.get("days"));
        int parentId = BaseHelpUtils.getIntValue(params.get("parentId"));

        //默认为永久权限
        boolean isForever = true;
        /**
         * 判断结束日期是否为空
         */
        if (endDate != null) {
            isForever = false;
        }

        int personnelBusines = dao.getPersonnelBusinessId();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        //员工权限表
        EmployeeFunction eDao = new EmployeeFunction();

        //申请的权限业务表
        FunctionBusiness fDao = new FunctionBusiness();

        //未审核的权限流程
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("detailRoleFunction");
        if (!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
            fDao.setConditionPersonnelBusinessId("=", personnelBusines);
            fDao.conditionalDelete();
            fDao.clear();

            for (Map<String, Object> map : list) {
                Integer functionId = BaseHelpUtils.getIntValue(map.get("functionId"));
                list1.add(functionId);
            }

            eDao.setConditionEmployeeId("=", employeeIds);

            List<BaseEmployeeFunction> eList = eDao.conditionalLoad();
            for (BaseEmployeeFunction baseEmployeeFunction : eList) {
                Integer functionId = BaseHelpUtils.getIntValue(baseEmployeeFunction.getFunctionId());
                list2.add(functionId);
            }
            list1.removeAll(list2);
        }


        /**
         * 流程顺利完成执行的方法（判断list1是否为空，为空的话从前端页面获取数据）
         */
        if (completed) {
            if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
                if (list1.isEmpty()) {
                    fDao.clear();
                    fDao.setConditionPersonnelBusinessId("=", dao.getPersonnelBusinessId());
                    List<BaseFunctionBusiness> fbList = fDao.conditionalLoad();
                    System.out.println("fbList size ： " + fbList.size());
                    for (BaseFunctionBusiness fbBean : fbList) {
                        fDao.setDataFromBase(fbBean);
                        fDao.setIsCompleted(true);
                        fDao.update();
                        eDao.clear();

                        eDao.setFunctionId(BaseHelpUtils.getIntValue(fDao.getFunctionId()));
                        eDao.setEmployeeId(BaseHelpUtils.getIntValue(fDao.getEmployeeId()));
                        eDao.setApplicationId(1);
                        eDao.save();
                    }
                } else {
                    /**
                     * list不为空的话将数据插入到function和employeefunction表中
                     */
                    for (Integer functionId : list1) {
                        fDao.setEmployeeId(employeeIds);
                        fDao.setStartDate(startDate);
                        fDao.setEndDate(endDate);
                        fDao.setDays(days);
                        fDao.setIsCompleted(true);
                        fDao.setPersonnelBusinessId(personnelBusines);
                        fDao.setFunctionId(functionId);
                        fDao.setFunctionType(parentId);
                        fDao.setIsForever(isForever);
                        fDao.save();

                        eDao.clear();
                        eDao.setFunctionId(BaseHelpUtils.getIntValue(fDao.getFunctionId()));
                        eDao.setEmployeeId(BaseHelpUtils.getIntValue(fDao.getEmployeeId()));
                        eDao.setApplicationId(1);
                        eDao.save();
                    }
                }
                dao.setIsCompleted(true);
            }
        } else {
            for (Integer functionId : list1) {
                fDao.setEmployeeId(employeeIds);
                fDao.setStartDate(startDate);
                fDao.setEndDate(endDate);
                fDao.setDays(days);
                fDao.setIsCompleted(false);
                fDao.setPersonnelBusinessId(personnelBusines);
                fDao.setFunctionId(functionId);
                fDao.setFunctionType(parentId);
                fDao.setIsForever(isForever);
                fDao.save();
            }
        }
        dao.update();
        BusinessAbstract ba = new BusinessAbstract(personnelBusines, "");
        return ba;
    }


    @Override
    public boolean computeExpression(String expression) throws Exception {
        return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
    }

    @Override
    public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
        return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
    }

    @Override
    public String getBusinessData(Integer businessId) throws Exception {
        PersonnelBusines dao = new PersonnelBusines();
        dao.setPersonnelBusinessId(businessId);
        dao.load();
        return dao.generateBase().toJSON();
    }

//    public static void main(String[] args) throws Exception {
//        ApplyFunctionsWorker apply = new ApplyFunctionsWorker();
//
//        Map<String, Object> map = new HashMap<>(0);
//        List resList = new ArrayList();
//
//        Map lm = new HashMap(0);
//        lm.put("functionId", 103);
//        lm.put("applicationId", 1);
//        resList.add(lm);
//
//        map.put("detailRoleFunction", resList);
//        map.put("employeeId", 12283);
//        map.put("startDate", "2019-06-24");
//        map.put("endDate", "");
//        map.put("days", "");
//        map.put("isForever", false);
//
//        apply.startNewWorkflow(null, map, 12283);
//    }
}
