package pomplatform.workflow.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBorrowLimitManage;
import com.pomplatform.db.bean.BaseCodeManage;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePlateAccountRecord;
import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.BorrowLimitManage;
import com.pomplatform.db.dao.CodeManage;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.Duty;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.Role;
import com.pomplatform.db.dao.SubjectType;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.expression.Expression;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessAttention;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.bean.BaseSystemProcessInstanceActivity;
import delicacy.system.bean.BaseSystemProcessPooledTask;
import delicacy.system.bean.BaseSystemProcessType;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import delicacy.system.dao.SystemProcessType;
import delicacy.system.executor.SelectValueCache;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employee.bean.BaseEmployeeFinancialTransSum;
import pomplatform.employee.bean.ConditionEmployeeFinancialTransSum;
import pomplatform.employee.query.QueryEmployeeFinancialTransSum;
import pomplatform.financialtransactionaccount.utils.FinancialTransactionAccountUtils;
import pomplatform.role.bean.BaseEmployeeRoleInfo;
import pomplatform.role.bean.ConditionEmployeeRoleInfo;
import pomplatform.role.query.QueryEmployeeRoleInfo;
import pomplatform.workflow.bean.BaseEmployeeStuff;
import pomplatform.workflow.bean.BaseOnLoadFlowProcessTypeNum;
import pomplatform.workflow.bean.ConditionEmployeeStuff;
import pomplatform.workflow.bean.ConditionOnLoadFlowProcessTypeNum;
import pomplatform.workflow.query.QueryEmployeeStuff;
import pomplatform.workflow.query.QueryOnLoadFlowProcessTypeNum;

/**
 * 计算公司账户项目信息
 *
 * @author lxf
 */
public class OnWrokflowProcess implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");
    // 定义模块类型
    private static final int ACTIVITY_TYPE_1 = 1;// 我的发起(发起/进行中)
    private static final int ACTIVITY_TYPE_2 = 2;// 我的驳回(已驳回)
    private static final int ACTIVITY_TYPE_3 = 3;// 我的归档(已完成)
    private static final int ACTIVITY_TYPE_4 = 4;// 待办-审核
    private static final int ACTIVITY_TYPE_5 = 5;// 待办-知会
    private static final int ACTIVITY_TYPE_6 = 6;// 待办-任务池
    private static final int ACTIVITY_TYPE_7 = 7;// 已办-审核
    private static final int ACTIVITY_TYPE_8 = 8;// 已办-知会
    private static final int ACTIVITY_TYPE_9 = 9;// 已办-任务池
    //定义流程类型
    public static final int PROCESS_TYPE_2 = 2;//项目日常报销
    public static final int PROCESS_TYPE_3 = 3;//普通日常报销
    public static final int PROCESS_TYPE_4 = 4;//项目差旅报销
    public static final int PROCESS_TYPE_5 = 5;//普通差旅报销
    public static final int PROCESS_TYPE_6 = 6;//借款申请
    public static final int PROCESS_TYPE_7 = 7;//预付款申请
    public static final int PROCESS_TYPE_8 = 8;//前期项目日常报销
    public static final int PROCESS_TYPE_9 = 9;//前期项目差旅报销
    public static final int PROCESS_TYPE_10 = 10;//公司日常报销
    //定义流程条件名称
    public static final String LINE_AMOUNT_NAME = "金额";
    public static final String LINE_DEP_NAME = "部门";
    public static final String LINE_DUTY_NAME = "职务";
    public static final String LINE_COMPANY_NAME = "公司";
    public static final String LINE_ROLE_NAME = "角色";
    public static final String LINE_SUB_TYPE_NAME = "报销科目";
    public static final String LINE_FEE_TYPE_NAME = "费用类型";
    public static final String LINE_DEP_TYPE_NAME = "部门类型";
    public static final String BUDGET_MANAGEMENT_STATUS = "预算是否审批";

    // 操作类型
    private static final String OPT_TYPE = "optType";
    // 获取人员欠款总金额
    private static final String ON_GET_EMPLOYEE_BORROW_MONEY = "onGetEmployeeBorrowMoney";
    // 加载我的事务的数据集
    private static final String ON_LOAD_DATA = "onLoadData";
    // 删除用车申请的成本关联
    private static final String DELETE_CAR_ALLOCATION = "deleteCarAllocation";
    //加载流程模块人员的流程类型及数目
    private static final String ON_LOAD_FLOW_PROCESS_TYPE_NUM = "onLoadFLowProcessTypeNum";

    //重入锁，为防止报销编号重复
    private static Lock lock = new ReentrantLock();

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        // 获取操作类型
        String optType = BaseHelpUtils.getStringValue(param, OPT_TYPE);
        if (ON_GET_EMPLOYEE_BORROW_MONEY.equals(optType)) {
            return OnGetEmployeeBorrowMoney(param);
        } else if (ON_LOAD_DATA.equals(optType)) {
            // return OnLoadData(param);
            return loadEmployeeStuff(param);
        }else if(optType.equals(DELETE_CAR_ALLOCATION)){
            return deleteCarAllocation(param);
        }else if(optType.equals(ON_LOAD_FLOW_PROCESS_TYPE_NUM)){
            return onLoadFLowProcessTypeNum(param);
        }
        return null;
    }
    /**
     * 加载流程模块人员的流程类型及数目
     * @param param
     * @return
     * @throws SQLException
     */
    public String onLoadFLowProcessTypeNum(Map<String, Object> param) throws SQLException {
        //获取流程模块id
        int parentProcessTypeId = BaseHelpUtils.getIntValue(param, "parentProcessTypeId");
        //获取人员id
        int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
        //加载数据集
        QueryOnLoadFlowProcessTypeNum dao = new QueryOnLoadFlowProcessTypeNum();
        ConditionOnLoadFlowProcessTypeNum con = new ConditionOnLoadFlowProcessTypeNum();
        if(parentProcessTypeId > 0) {
            con.setParentProcessTypeId(parentProcessTypeId);
        }
        con.setEmployeeId(employeeId);
        BaseCollection<BaseOnLoadFlowProcessTypeNum> result = dao.executeQuery(null, con);
        List<BaseSystemProcessInstanceActivity> backList = new ArrayList<>();
        if(!BaseHelpUtils.isNullOrEmpty(result)) {
            List<BaseOnLoadFlowProcessTypeNum> list = result.getCollections();
            if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
                BaseSystemProcessInstanceActivity bean = null;
                String typeName = null;
                for(BaseOnLoadFlowProcessTypeNum e : list) {
                    //获取标识类型1：表示发起人模块；2：表示审批人模块；3：表示知会人模块
                    int typeFlag = BaseHelpUtils.getIntValue(e.getTypeFlag());
                    //获取类型id
                    int processType = BaseHelpUtils.getIntValue(e.getProcessType());
                    //获取类型类型名称
                    String processTypeName = BaseHelpUtils.getString(e.getProcessTypeName());
                    //获取正在运行的数目
                    int runCount = BaseHelpUtils.getIntValue(e.getRunCount());
                    //获取已完成数目
                    int finishCount = BaseHelpUtils.getIntValue(e.getFinishCount());
                    //说明是发起人模块
                    if(typeFlag == 1) {
                        //获取驳回的数目
                        int baskCount = BaseHelpUtils.getIntValue(e.getBackCount());
                        if(runCount > 0) {
                            typeName = OnSetProcessTypeName(processTypeName, runCount);
                            bean = new BaseSystemProcessInstanceActivity();
                            bean.setProcessType(processType);
                            bean.setActivityType(ACTIVITY_TYPE_1);
                            bean.setBusinessName(typeName);
                            backList.add(bean);
                        }
                        finishCount = finishCount+baskCount;
                        if(finishCount > 0) {
                            typeName = OnSetProcessTypeName(processTypeName, finishCount);
                            bean = new BaseSystemProcessInstanceActivity();
                            bean.setProcessType(processType);
                            bean.setActivityType(ACTIVITY_TYPE_3);
                            bean.setBusinessName(typeName);
                            backList.add(bean);
                        }
                    }

                    //说明是审批人模块
                    if(typeFlag == 2) {
                        if(runCount > 0) {
                            typeName = OnSetProcessTypeName(processTypeName, runCount);
                            bean = new BaseSystemProcessInstanceActivity();
                            bean.setProcessType(processType);
                            bean.setActivityType(ACTIVITY_TYPE_4);
                            bean.setBusinessName(typeName);
                            backList.add(bean);
                        }
                        if(finishCount > 0) {
                            typeName = OnSetProcessTypeName(processTypeName, finishCount);
                            bean = new BaseSystemProcessInstanceActivity();
                            bean.setProcessType(processType);
                            bean.setActivityType(ACTIVITY_TYPE_7);
                            bean.setBusinessName(typeName);
                            backList.add(bean);
                        }
                    }

                    //说明是知会人模块
                    if(typeFlag == 3) {
                        if(runCount > 0) {
                            typeName = OnSetProcessTypeName(processTypeName, runCount);
                            bean = new BaseSystemProcessInstanceActivity();
                            bean.setProcessType(processType);
                            bean.setActivityType(ACTIVITY_TYPE_5);
                            bean.setBusinessName(typeName);
                            backList.add(bean);
                        }
                        if(finishCount > 0) {
                            typeName = OnSetProcessTypeName(processTypeName, finishCount);
                            bean = new BaseSystemProcessInstanceActivity();
                            bean.setProcessType(processType);
                            bean.setActivityType(ACTIVITY_TYPE_8);
                            bean.setBusinessName(typeName);
                            backList.add(bean);
                        }
                    }

                }
            }
        }
        BaseCollection<BaseSystemProcessInstanceActivity> bc = new BaseCollection<>();
        bc.setCollections(backList);
        return bc.toJSON(0,"");
    }

    /**
     * 设置流程类型名称
     * @param processTypeName
     * @param count
     * @return
     */
    public String OnSetProcessTypeName(String processTypeName,int count) {
        if(!BaseHelpUtils.isNullOrEmpty(processTypeName) && count > 0) {
            processTypeName = String.format("%1$s(%2$s)", processTypeName,count);
        }
        return processTypeName;
    }

    /**
     * 获取人员的借款额度、欠款总金额
     *
     * @return
     * @throws SQLException
     */
    public String OnGetEmployeeBorrowMoney(Map<String, Object> param) throws SQLException {
        // 获取职员id
        int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
        ConditionEmployeeFinancialTransSum condition = new ConditionEmployeeFinancialTransSum();
        condition.setAccountType(FinancialTransactionAccountUtils.ACCOUNT_TYPE_EMPLOYEE);
        condition.setEntityId(employeeId);
        condition.setCompanyId(BaseHelpUtils.getIntValue(param.get("companyId")));
        QueryEmployeeFinancialTransSum query = new QueryEmployeeFinancialTransSum();
        BaseCollection<BaseEmployeeFinancialTransSum> bc = query.execute(null, condition);
        // 获取该人员的借款额度
        BigDecimal borrowLimit = BigDecimal.ZERO;
        BorrowLimitManage limitDao = new BorrowLimitManage();
        limitDao.setConditionEmployeeId("=", employeeId);
        BaseBorrowLimitManage limitBean = limitDao.executeQueryOneRow();
        borrowLimit = limitBean == null ? BigDecimal.ZERO : limitBean.getBorrowLimitMoney();
        if(bc.getCollections().isEmpty()) {
            BaseEmployeeFinancialTransSum bean = new BaseEmployeeFinancialTransSum();
            bean.setBorrowLimit(borrowLimit);
            bean.setStandardCredit(BigDecimal.ZERO);
            bean.setStandardDebit(BigDecimal.ZERO);
            List<BaseEmployeeFinancialTransSum> list = new ArrayList<>();
            list.add(bean);
            bc.setCollections(list);
        }else {
            BaseEmployeeFinancialTransSum bean = bc.getCollections().get(0);
            bean.setBorrowLimit(borrowLimit);
            BigDecimal amount = bean.getStandardDebit().subtract(bean.getStandardCredit());
            if(amount.compareTo(BigDecimal.ZERO) >= 0) {
                bean.setStandardDebit(amount);
                bean.setStandardCredit(BigDecimal.ZERO);
            }else {
                bean.setStandardDebit(BigDecimal.ZERO);
                bean.setStandardCredit(amount);
            }
        }
        return bc.toJSON();
    }

    public String loadEmployeeStuff(Map<String, Object> param) throws SQLException {
        // 获取职员id
        int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
        //获取流程的父级ID
        int parentProcessTypeId = BaseHelpUtils.getIntValue(param,"parentProcessTypeId");
        QueryEmployeeStuff dao = new QueryEmployeeStuff();
        ConditionEmployeeStuff c = new ConditionEmployeeStuff();
        c.setEmployeeId(employeeId);
        c.setParentProcessTypeId(parentProcessTypeId);
        BaseCollection<BaseEmployeeStuff> res = dao.executeQuery(null, c);
        return res.toJSON();
    }

    /**
     * 获取我的事务的数据集
     *
     * @return
     * @throws SQLException
     */
    public String OnLoadData(Map<String, Object> param) throws SQLException {
        // 获取职员id
        int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
        // 定义返回的数据集
        List<BaseSystemProcessInstanceActivity> result = new ArrayList<>();
        BaseSystemProcessInstanceActivity bean;

        // 加载流程类型的数据集
        SystemProcessType processTypeDao = new SystemProcessType();
        List<BaseSystemProcessType> processTypeList = processTypeDao.conditionalLoad();
        // 定义装载流程类型的map
        Map<Integer, String> processTypeMap = new HashMap<>();
        if (!processTypeList.isEmpty()) {// 遍历放入map中
            for (BaseSystemProcessType e : processTypeList) {
                processTypeMap.put(BaseHelpUtils.getIntValue(e.getProcessTypeId()),
                        BaseHelpUtils.getString(e.getProcessTypeName()));
            }
        }

        // 查询我的申请表的数据集
        SystemProcessInstance processInstanceDao = new SystemProcessInstance();
        processInstanceDao.setConditionEmployeeId("=", employeeId);
        processInstanceDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
        List<BaseSystemProcessInstance> processInstanceList = processInstanceDao.conditionalLoad();
        // 查询我的审批表的数据集
        SystemProcessInstanceActivity processInstanceActivityDao = new SystemProcessInstanceActivity();
        processInstanceActivityDao.setConditionEmployeeId("=", employeeId);
        processInstanceActivityDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
        List<BaseSystemProcessInstanceActivity> processInstanceActivityList = processInstanceActivityDao
                .conditionalLoad();
        // 查询我的知会表的数据集
        SystemProcessAttention processAttentionDao = new SystemProcessAttention();
        processAttentionDao.setConditionEmployeeId("=", employeeId);
        processAttentionDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
        List<BaseSystemProcessAttention> processAttentionList = processAttentionDao.conditionalLoad();
        // 查询我的任务池表的数据集
        SystemProcessPooledTask processPooledTaskDao = new SystemProcessPooledTask();
        processPooledTaskDao.setConditionEmployeeId("=", employeeId);
        processPooledTaskDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
        List<BaseSystemProcessPooledTask> processPooledTaskList = processPooledTaskDao.conditionalLoad();

        // 根据流程类型进行归类
        if (!processTypeMap.isEmpty() && processTypeMap.size() > 0) {
            int runCount = 0;
            int backCount = 0;
            int finishCount = 0;
            for (Integer processTypeId : processTypeMap.keySet()) {
                // 获取流程类型名称
                String processTypeName = BaseHelpUtils.getString(processTypeMap.get(processTypeId));
                // 申请表数据归集
                if (!processInstanceList.isEmpty()) {
                    // 归类，有我的发起（进行中）、我的驳回（已驳回）、我的归档（已完成）
                    runCount = 0;
                    backCount = 0;
                    finishCount = 0;
                    for (BaseSystemProcessInstance e : processInstanceList) {
                        if (processTypeId == BaseHelpUtils.getIntValue(e.getProcessType())) {
                            if (0 == BaseHelpUtils.getIntValue(e.getProcessStatus())
                                    || 1 == BaseHelpUtils.getIntValue(e.getProcessStatus())) {// 发起/进行中
                                runCount++;
                            } else if (3 == BaseHelpUtils.getIntValue(e.getProcessStatus())) {// 已完成
                                finishCount++;
                            } else if (5 == BaseHelpUtils.getIntValue(e.getProcessStatus())) {// 已驳回
                                backCount++;
                            }
                        }
                    }
                    if (runCount > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_1);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, runCount));
                        result.add(bean);
                    }
                    if (backCount > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_2);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, backCount));
                        result.add(bean);
                    }
                    if (finishCount > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_3);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, finishCount));
                        result.add(bean);
                    }
                }
                Map<Integer, Integer> activeActivities = new HashMap<>();
                Map<Integer, Integer> finishedActivities = new HashMap<>();
                // 审核表数据归集
                if (!processInstanceActivityList.isEmpty()) {
                    runCount = 0;
                    finishCount = 0;
                    for (BaseSystemProcessInstanceActivity e : processInstanceActivityList) {
                        if (processTypeId == BaseHelpUtils.getIntValue(e.getProcessType())
                                && (2 == BaseHelpUtils.getIntValue(e.getActivityType())
                                || 3 == BaseHelpUtils.getIntValue(e.getActivityType()))) {
                            if (1 == BaseHelpUtils.getIntValue(e.getStatus())) {// 激活状态
                                runCount++;
                                activeActivities.put(e.getProcessInstanceId(), runCount);
                            } else if (2 == BaseHelpUtils.getIntValue(e.getStatus())) {// 已完成
                                finishCount++;
                                finishedActivities.put(e.getProcessInstanceId(), finishCount);
                            }
                        }
                    }
                    if (activeActivities.size() > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_4);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, activeActivities.size()));
                        result.add(bean);
                    }
                    if (finishedActivities.size() > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_7);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, finishedActivities.size()));
                        result.add(bean);
                    }
                }
                Map<Integer, Integer> activeattentions = new HashMap<>();
                Map<Integer, Integer> finishedattentions = new HashMap<>();
                // 知会表数据归集
                if (!processAttentionList.isEmpty()) {
                    runCount = 0;
                    finishCount = 0;
                    for (BaseSystemProcessAttention e : processAttentionList) {
                        if (processTypeId == BaseHelpUtils.getIntValue(e.getProcessType())) {
                            if (1 == BaseHelpUtils.getIntValue(e.getStatus())) {// 激活状态
                                runCount++;
                                activeattentions.put(e.getProcessInstanceId(), runCount);
                            } else if (2 == BaseHelpUtils.getIntValue(e.getStatus())) {// 已完成
                                finishCount++;
                                finishedattentions.put(e.getProcessInstanceId(), finishCount);
                            }
                        }
                    }
                    if (activeattentions.size() > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_5);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, activeattentions.size()));
                        result.add(bean);
                    }
                    if (finishedattentions.size() > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_8);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, finishedattentions.size()));
                        result.add(bean);
                    }
                }
                Map<Integer, Integer> activetasks = new HashMap<>();
                Map<Integer, Integer> finishedtasks = new HashMap<>();
                // 任务池表数据归集
                if (!processPooledTaskList.isEmpty()) {
                    runCount = 0;
                    finishCount = 0;
                    for (BaseSystemProcessPooledTask e : processPooledTaskList) {
                        if (processTypeId == BaseHelpUtils.getIntValue(e.getProcessType())) {
                            if (1 == BaseHelpUtils.getIntValue(e.getStatus())) {// 激活状态
                                runCount++;
                                activetasks.put(e.getProcessInstanceId(), runCount);
                            } else if (2 == BaseHelpUtils.getIntValue(e.getStatus())) {// 已完成
                                finishCount++;
                                finishedtasks.put(e.getProcessInstanceId(), finishCount);
                            }
                        }
                    }
                    if (activetasks.size() > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_6);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, activetasks.size()));
                        result.add(bean);
                    }
                    if (finishedtasks.size() > 0) {
                        bean = new BaseSystemProcessInstanceActivity();
                        bean.setProcessType(processTypeId);
                        bean.setActivityType(ACTIVITY_TYPE_9);
                        bean.setBusinessName(String.format("%1$s(%2$s)", processTypeName, finishedtasks.size()));
                        result.add(bean);
                    }
                }
            }
        }
        BaseCollection<BaseSystemProcessInstanceActivity> collection = new BaseCollection<>();
        collection.setCollections(result);
        return collection.toJSON(0, null);
    }

    /**
     * 获取当月最新的编码
     *
     * @return
     * @throws SQLException
     */
    public static String getNewCode(int processTypeId) throws Exception {
        String code = "";
        if (lock.tryLock()) {//尝试获取锁成功获取则返回true
            try {
                Calendar calendar = Calendar.getInstance();
                // 设置为当前日期，并初始化为当前月的第一天
                calendar.setTime(new Date());
                calendar.set(Calendar.DATE, 1);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                String monthStr = String.format("%02d", month);
                // 从编号管理表中取获取到当前年份和月份的值
                CodeManage dao = new CodeManage();
                dao.setConditionYear("=", year);
                dao.setConditionMonth("=", month);
                BaseCodeManage bean = dao.executeQueryOneRow();
                if (BaseHelpUtils.isNullOrEmpty(bean)) {// 如果为空，则说明当前年月份下暂无数据
                    code = String.format("%1$s%2$s-00001", year, monthStr);
                    bean = new BaseCodeManage();
                    bean.setRecordDate(calendar.getTime());
                    bean.setYear(year);
                    bean.setMonth(month);
                    bean.setCode(code);
                    bean.setOrderNum(1);// 初始化为1
                    dao.clear();
                    dao.setDataFromBase(bean);
                    dao.save();
                } else {// 否则取到序列号，并递增
                    code = BaseHelpUtils.getString(bean.getCode());
                    int orderNum = BaseHelpUtils.getIntValue(bean.getOrderNum()) + 1;
                    String order = getOrderNum(orderNum + "");
                    code = String.format("%1$s%2$s-%3$s", year, monthStr, order);
                    bean.setCode(code);
                    bean.setOrderNum(orderNum);
                    dao.clear();
                    dao.setPrimaryKeyFromBase(bean);
                    if (dao.load()) {
                        dao.setDataFromBase(bean);
                        dao.update();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();   //释放锁
            }
        } else {
            throw new Exception("网络繁忙，请稍后重试!");
        }
        return code;
        //不同的报销类型，设置不同的字母编码进行区别
//		switch (processTypeId) {
//		case PROCESS_TYPE_2:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_XR,code);
//			break;
//		case PROCESS_TYPE_3:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_PR,code);
//			break;
//		case PROCESS_TYPE_4:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_XC,code);
//			break;
//		case PROCESS_TYPE_5:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_PC,code);
//			break;
//		case PROCESS_TYPE_6:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_JK,code);
//			break;
//		case PROCESS_TYPE_7:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_YF,code);
//			break;
//		case PROCESS_TYPE_8:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_QR,code);
//			break;
//		case PROCESS_TYPE_9:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_QC,code);
//			break;
//		case PROCESS_TYPE_10:
//			code = String.format("%1$s%2$s", PROCESS_TYPE_GR,code);
//			break;
//		default:
//			break;
//		}
    }

    /**
     * 根据序列号返回5位字符串编号
     *
     * @param orderNum
     * @return
     */
    public static String getOrderNum(String orderNum) {
        int len = orderNum.length();
        for (int i = len; i < 5; i++) {
            orderNum = "0" + orderNum;
        }
        return orderNum;
    }

    public String deleteCarAllocation(Map<String, Object> param) throws SQLException {
        BaseCollection bc = new BaseCollection<>();
        BasePersonnelBusines bean = new BasePersonnelBusines();
        bean.setDataFromMap(param);
        if(null != bean.getStartDateDetail()){
            ThreadConnection.beginTransaction();
            int processInstanceId = BaseHelpUtils.getIntValue(param.get("processInstanceId"));
            if(bean.getStartDateDetail().equals(StaticUtils.DEPARTMENT_COST)){
                //部门成本
                PlateCostRecord costDao = new PlateCostRecord();
                costDao.setConditionProcessInstanceId("=", processInstanceId);
                List<BasePlateCostRecord> costList = costDao.conditionalLoad();
                if(null != costList && !costList.isEmpty()){
                    int size = costList.size();
                    Integer[] costIds = new Integer[size];
                    for(int i = 0; i < size; i++){
                        costIds[i] = BaseHelpUtils.getIntValue(costList.get(i).getPlateCostRecordId());
                    }
                    PlateAccountRecord accountDao = new PlateAccountRecord();
                    accountDao.setConditionBusinessTypeId("=", AccountManageProcess.PLATE_BT_PLATE_COST);
                    accountDao.addCondition(BasePlateAccountRecord.CS_BUSINESS_ID, "in", (Object[]) costIds);
                    accountDao.conditionalDelete();
                    costDao.conditionalDelete();
                }
            }else if(bean.getStartDateDetail().equals(StaticUtils.PROJECT_COST)){
                //项目成本
                ProjectCost costDao = new ProjectCost();
                costDao.setConditionProcessInstanceId("=", processInstanceId);
                costDao.setConditionStatus("=", StaticUtils.SETTLEMENT_STATUS_YES);
                if(costDao.countRows() > 0){
                    return bc.toJSON(-1, "已有项目分摊了成本，无法删除");
                }
                costDao.setConditionStatus("=", StaticUtils.SETTLEMENT_STATUS_NO);
                costDao.conditionalDelete();
            }
            PersonnelBusines dao = new PersonnelBusines();
            dao.setPrimaryKeyFromBase(bean);
            if(dao.load()){
                dao.setIsRemoteCity(false);
                dao.update();
            }
            ThreadConnection.commit();
            return bc.toJSON();
        }
        return bc.toJSON(-1, "用车类型不确定，无法删除");
    }

    /**
     * 线上条件设置
     * @param expression
     * @param e
     * @return
     * @throws Exception
     */
    public static Expression setExpression(String expression,Expression e,Integer employeeId,BigDecimal amount,Integer feeType,Integer subType) throws Exception {
        if(!BaseHelpUtils.isNullOrEmpty(expression) && !BaseHelpUtils.isNullOrEmpty(e)) {
            //金额
            if(expression.contains(LINE_AMOUNT_NAME)){
                e.setValue(LINE_AMOUNT_NAME,BaseHelpUtils.getBigDecimalValue(amount));
            }
            //费用类型
            if(expression.contains(LINE_FEE_TYPE_NAME)) {
                e.setValue(LINE_FEE_TYPE_NAME,BaseHelpUtils.getString(SelectValueCache.getSelectValue("system_dictionary_86",feeType+"")));
            }
            //报销科目
            if(expression.contains(LINE_SUB_TYPE_NAME)) {
                SubjectType stDao = new SubjectType();
                stDao.setSubjectTypeId(BaseHelpUtils.getIntValue(subType));
                if(stDao.load()) {
                    e.setValue(LINE_SUB_TYPE_NAME,BaseHelpUtils.getString(stDao.getSubjectName()));
                }else {
                    e.setValue(LINE_SUB_TYPE_NAME, "");
                    __logger.info(String.format("条件线设置异常：找不到报销科目(%1$s)的信息",BaseHelpUtils.getIntValue(subType)));
                }
            }
            if(BaseHelpUtils.getIntValue(employeeId) > 0) {
                Employee dao = new Employee();
                dao.unsetSelectFlags();
                dao.setSelectDutyId(true);
                dao.setSelectDepartmentId(true);
                dao.setSelectCompanyId(true);
                dao.setSelectEmployeeName(true);
                dao.setSelectPlateId(true);
                dao.setEmployeeId(employeeId);
                if(dao.load()) {
                    String empName = BaseHelpUtils.getString(dao.getEmployeeName());
                    //部门类型
                    if(expression.contains(LINE_DEP_TYPE_NAME)){
                        //获取业务部门
                        Integer plateId = dao.getPlateId();
                        if(BaseHelpUtils.isNullOrEmpty(plateId)) {
                            e.setValue(LINE_DEP_TYPE_NAME,"");
                        }else {
                            PlateRecord prDao = new PlateRecord();
                            prDao.setConditionPlateId("=",plateId);
                            BasePlateRecord prBean = prDao.executeQueryOneRow();
                            if(BaseHelpUtils.isNullOrEmpty(prBean)) {
                                e.setValue(LINE_DEP_TYPE_NAME,"");
                            }else {
                                //获取部门类型
                                int plateType = BaseHelpUtils.getIntValue(prBean.getPlateType());
                                String name = BaseHelpUtils.getString(SelectValueCache.getSelectValue("system_dictionary_164",plateType+""));
                                e.setValue(LINE_DEP_TYPE_NAME,name);
                            }
                        }
                    }
                    //公司
                    if(expression.contains(LINE_COMPANY_NAME)) {
                        int companyId = BaseHelpUtils.getIntValue(dao.getCompanyId());
                        CompanyRecord crDao = new CompanyRecord();
                        crDao.setCompanyRecordId(companyId);
                        if(crDao.load()) {
                            //获取公司简称
                            String name = BaseHelpUtils.getString(crDao.getCompanyNameSimple());
                            e.setValue(LINE_COMPANY_NAME,name);
                        }else {
                            e.setValue(LINE_COMPANY_NAME,"");
                        }
                    }
                    //职务
                    if(expression.contains(LINE_DUTY_NAME)){
                        int dutyId = BaseHelpUtils.getIntValue(dao.getDutyId());
                        Duty dutyDao = new Duty();
                        dutyDao.unsetSelectFlags();
                        dutyDao.setSelectDutyName(true);
                        dutyDao.setDutyId(dutyId);
                        if(dutyDao.load()){
                            e.setValue(LINE_DUTY_NAME,BaseHelpUtils.getString(dutyDao.getDutyName()));
                        }else{
                            e.setValue(LINE_DUTY_NAME, "");
                            __logger.info(String.format("条件线设置异常：找不到该员工(%1$s)的职务信息",empName));
                        }
                    }
                    //角色
                    if(expression.contains(LINE_ROLE_NAME)){
                        ConditionEmployeeRoleInfo condition = new ConditionEmployeeRoleInfo();
                        condition.setEmployeeId(employeeId);
                        QueryEmployeeRoleInfo query = new QueryEmployeeRoleInfo();
                        BaseCollection<BaseEmployeeRoleInfo> bc = query.execute(null, condition);
                        if(null == bc || null == bc.getCollections() || bc.getCollections().isEmpty()) {
                            e.setValue(LINE_ROLE_NAME, "");
                            __logger.info(String.format("条件线设置异常：找不到该员工(%1$s)的默认角色信息",empName));
                        }else {
                            List<BaseEmployeeRoleInfo> list = bc.getCollections();
                            StringBuilder sb = new StringBuilder();
                            for(BaseEmployeeRoleInfo erBean : list) {
                                if(BaseHelpUtils.isNullOrEmpty(erBean.getRoleName())) {
                                    continue;
                                }
                                if(sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(erBean.getRoleName());
                            }
                            e.setValue(LINE_ROLE_NAME, sb.toString());
                        }
                    }
                    //部门
                    if(expression.contains(LINE_DEP_NAME)) {
                        int depId = BaseHelpUtils.getIntValue(dao.getDepartmentId());
                        Department dDao = new Department();
                        dDao.setDepartmentId(depId);
                        if(dDao.load()) {
                            e.setValue(LINE_DEP_NAME,BaseHelpUtils.getString(dDao.getDepartmentName()));
                        }else {
                            e.setValue(LINE_DEP_NAME, "");
                            __logger.info(String.format("条件线设置异常：找不到该员工(%1$s)的部门信息",empName));
                        }
                    }
                }
            }
        }
        return e;
    }

    /**
     * 线上条件设置
     * @param expression
     * @param e
     * @return
     * @throws Exception
     */
    public static Expression setExpression(String expression,Expression e,Integer employeeId,Integer companyId,Integer departmentId,BigDecimal amount,Integer feeType,Integer subType) throws Exception {
        if(!BaseHelpUtils.isNullOrEmpty(expression) && !BaseHelpUtils.isNullOrEmpty(e) && employeeId > 0) {
            Employee dao = new Employee();
            dao.unsetSelectFlags();
            dao.setSelectPlateId(true);
            dao.setSelectDutyId(true);
            dao.setSelectDepartmentId(true);
            dao.setSelectCompanyId(true);
            dao.setSelectEmployeeName(true);
            dao.setEmployeeId(employeeId);
            if(dao.load()) {
                String empName = BaseHelpUtils.getString(dao.getEmployeeName());
                //部门类型
                if(expression.contains(LINE_DEP_TYPE_NAME)){
                    //获取业务部门
                    Integer plateId = dao.getPlateId();
                    if(BaseHelpUtils.isNullOrEmpty(plateId)) {
                        e.setValue(LINE_DEP_TYPE_NAME,"");
                    }else {
                        PlateRecord prDao = new PlateRecord();
                        prDao.setConditionPlateId("=",plateId);
                        BasePlateRecord prBean = prDao.executeQueryOneRow();
                        if(BaseHelpUtils.isNullOrEmpty(prBean)) {
                            e.setValue(LINE_DEP_TYPE_NAME,"");
                        }else {
                            //获取部门类型
                            int plateType = BaseHelpUtils.getIntValue(prBean.getPlateType());
                            String name = BaseHelpUtils.getString(SelectValueCache.getSelectValue("system_dictionary_164",plateType+""));
                            e.setValue(LINE_DEP_TYPE_NAME,name);
                        }
                    }
                }
                //金额
                if(expression.contains(LINE_AMOUNT_NAME)){
                    e.setValue(LINE_AMOUNT_NAME,BaseHelpUtils.getBigDecimalValue(amount));
                }
                //公司
                if(expression.contains(LINE_COMPANY_NAME)) {
                    if(BaseHelpUtils.isNullOrEmpty(companyId)) {
                        companyId = BaseHelpUtils.getIntValue(dao.getCompanyId());
                    }
                    CompanyRecord crDao = new CompanyRecord();
                    crDao.setCompanyRecordId(companyId);
                    if(crDao.load()) {
                        //获取公司简称
                        String name = BaseHelpUtils.getString(crDao.getCompanyNameSimple());
                        e.setValue(LINE_COMPANY_NAME,name);
                    }else {
                        e.setValue(LINE_COMPANY_NAME,"");
                    }
                }
                //费用类型
                if(expression.contains(LINE_FEE_TYPE_NAME)) {
                    e.setValue(LINE_FEE_TYPE_NAME,BaseHelpUtils.getString(SelectValueCache.getSelectValue("system_dictionary_86",feeType+"")));
                }
                //职务
                if(expression.contains(LINE_DUTY_NAME)){
                    int dutyId = BaseHelpUtils.getIntValue(dao.getDutyId());
                    Duty dutyDao = new Duty();
                    dutyDao.unsetSelectFlags();
                    dutyDao.setSelectDutyName(true);
                    dutyDao.setDutyId(dutyId);
                    if(dutyDao.load()){
                        e.setValue(LINE_DUTY_NAME,BaseHelpUtils.getString(dutyDao.getDutyName()));
                    }else{
                        e.setValue(LINE_DUTY_NAME, "");
                        __logger.info(String.format("条件线设置异常：找不到该员工(%1$s)的职务信息",empName));
                    }
                }
                //角色
                if(expression.contains(LINE_ROLE_NAME)){
                    EmployeeRole erDao = new EmployeeRole();
                    erDao.setConditionEmployeeId("=",employeeId);
                    erDao.setConditionIsDefault("=",true);
                    BaseEmployeeRole erBean = erDao.executeQueryOneRow();
                    int roleId = -1;
                    if(!BaseHelpUtils.isNullOrEmpty(erBean)){
                        roleId = BaseHelpUtils.getIntValue(erBean.getRoleId());
                    }
                    Role rDao = new Role();
                    rDao.setRoleId(roleId);
                    if(rDao.load()) {
                        e.setValue(LINE_ROLE_NAME,BaseHelpUtils.getString(rDao.getRoleName()));
                    }else{
                        e.setValue(LINE_ROLE_NAME, "");
                        __logger.info(String.format("条件线设置异常：找不到该员工(%1$s)的默认角色信息",empName));
                    }
                }
                //部门
                if(expression.contains(LINE_DEP_NAME)) {
                    if(BaseHelpUtils.isNullOrEmpty(departmentId)) {
                        departmentId = BaseHelpUtils.getIntValue(dao.getDepartmentId());
                    }
                    Department dDao = new Department();
                    dDao.setDepartmentId(departmentId);
                    if(dDao.load()) {
                        e.setValue(LINE_DEP_NAME,BaseHelpUtils.getString(dDao.getDepartmentName()));
                    }else {
                        e.setValue(LINE_DEP_NAME, "");
                        __logger.info(String.format("条件线设置异常：找不到该员工(%1$s)的部门信息",empName));
                    }
                }
                //报销科目
                if(expression.contains(LINE_SUB_TYPE_NAME)) {
                    SubjectType stDao = new SubjectType();
                    stDao.setSubjectTypeId(BaseHelpUtils.getIntValue(subType));
                    if(stDao.load()) {
                        e.setValue(LINE_SUB_TYPE_NAME,BaseHelpUtils.getString(stDao.getSubjectName()));
                    }else {
                        e.setValue(LINE_SUB_TYPE_NAME, "");
                        __logger.info(String.format("条件线设置异常：找不到报销科目(%1$s)的信息",BaseHelpUtils.getIntValue(subType)));
                    }
                }
            }
        }
        return e;
    }

}
