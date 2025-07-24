package pomplatform.project.business;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import com.pomplatform.db.handler.CwdTaskTemplateHandler;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import org.apache.log4j.Logger;
import pomplatform.sealKeepers.bean.BaseRankMax;
import pomplatform.sealKeepers.bean.ConditionRankMax;
import pomplatform.sealKeepers.query.QueryRankMax;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liubin
 */
public class ProjectCommonProcess implements GenericProcessor {

    private static final Logger logger = Logger.getLogger(CwdTaskTemplateHandler.class);

    /**
     * 流程类型: 物品归还
     */
    private static int processType_31 = 31;

    /**
     * 方法: 修改订单的项目经理
     */
    private final String EDITOR_DEPARTMENT_MANAGER = "editorDepartmentManager";

    /**
     * 方法: 获取申请人所有的未归还的物品
     */
    private final String GET_ITEMS_NEED_TO_RETURN = "getItemsNeedToReturn";

    /**
     * 方法: 获取归还物品的业务表数据
     */
    private final String GET_PERSONNEL_BUSINESS_LINK_RETURN = "getPersonnelBusinessLinkReturn";

    /**
     * 方法: 维护直接的比例
     */
    private final String RANK_MAINTENANCE = "rankMaintenance";

    /**
     * 方法: 新增职级
     */
    private final String ADD_RANK = "addRank";

    /**
     * 方法: 删除职级
     */
    private final String DELETE_RANK = "deleteRank";


    @Override
    public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {

        JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param, "opt_type");
        switch (optType) {
            case EDITOR_DEPARTMENT_MANAGER:
                return editorDepartmentManager(param);
            case GET_ITEMS_NEED_TO_RETURN:
                return getItemsNeedToReturn(param);
            case GET_PERSONNEL_BUSINESS_LINK_RETURN:
                return getPersonnelBusinessLinkReturn(param);
            case RANK_MAINTENANCE:
                return rankMaintenance(param);
            case ADD_RANK:
                return addRank(param);
            case DELETE_RANK:
                return deleteRank(param);
            default:
                return null;
        }
    }

    /**
     * @param param
     * @return java.lang.String
     * @author liubin
     * @creed: write code
     * @date 2020/1/9 18:14
     * @describe: 删除职级的下拉值
     */
    private String deleteRank(Map<String, Object> param) throws SQLException {
        logger.info("----------------------------- param :" + param);
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        List<Map> lists = (List<Map>) param.get("list");
        if (BaseHelpUtils.isNullOrEmpty(lists) || lists.size() == 0) {
            return collection.toJSON(-1, "数据异常: 没有获取到需要删除的数据");
        }
        Employee employee = new Employee();
        SystemDictionary systemDictionary = new SystemDictionary();
        RankFactorMaintenance rankFactorMaintenance = new RankFactorMaintenance();
        for (Map map : lists) {
            //获取职级的ID
            int dicTypeValueId = BaseHelpUtils.getIntValue(map.get("dicTypeValueId"));
            employee.clear();
            employee.setConditionGradeId("=", dicTypeValueId);
            if (employee.isExist()) {
                continue;
            }
            else{
                systemDictionary.clear();
                systemDictionary.setConditionDicTypeId("=", 3);
                systemDictionary.setConditionDicTypeValueId("=", dicTypeValueId);
                systemDictionary.conditionalDelete();
                //删除关联表的数据
                rankFactorMaintenance.clear();
                rankFactorMaintenance.setConditionRankId("=", dicTypeValueId);
                rankFactorMaintenance.conditionalDelete();
            }
        }
        return collection.toJSON(1, "删除数据");
    }

    /**
     * @param param
     * @return java.lang.String
     * @author liubin
     * @creed: write code
     * @date 2020/1/9 17:48
     * @describe: 新增职级并且维护系数
     */
    private String addRank(Map<String, Object> param) throws SQLException {
        logger.info("------------------------- param");
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        //获取新增的直接的名称
        String dicTypeValue = BaseHelpUtils.getString(param.get("dicTypeValue"));
        //获取职级的系数
        BigDecimal rate = BaseHelpUtils.getBigDecimalValue(param.get("rate"));
        SystemDictionary systemDictionary = new SystemDictionary();
        systemDictionary.setConditionDicTypeId("=", 3);
        systemDictionary.setConditionDicTypeValue("=", dicTypeValue);
        if (systemDictionary.isExist()) {
            return collection.toJSON(-1, "新增的职级已经存在");
        }
        int maxId;
        QueryRankMax queryRankMax = new QueryRankMax();
        ConditionRankMax conditionRankMax = new ConditionRankMax();
        BaseCollection<BaseRankMax> baseRankMaxBaseCollection = queryRankMax.executeQuery(null, conditionRankMax);
        //没有最大的职级则表明是一个数据，则职级的Id从1开始
        if (BaseHelpUtils.isNullOrEmpty(baseRankMaxBaseCollection) || baseRankMaxBaseCollection.getCollections().size() == 0) {
            maxId = 1;
        } else {
            maxId = BaseHelpUtils.getIntValue(baseRankMaxBaseCollection.getCollections().get(0).getMax());
            maxId++;
        }
        BaseSystemDictionary baseSystemDictionary = new BaseSystemDictionary();
        //职级类型ID
        baseSystemDictionary.setDicTypeId(3);
        baseSystemDictionary.setDicTypeValueId(maxId);
        baseSystemDictionary.setDicTypeName("职级");
        baseSystemDictionary.setDicTypeValue(dicTypeValue);
        systemDictionary.clear();
        systemDictionary.setDataFromBase(baseSystemDictionary);
        systemDictionary.save();
        //保存职级系数表的数据
        RankFactorMaintenance rankFactorMaintenance = new RankFactorMaintenance();
        BaseRankFactorMaintenance baseRankFactorMaintenance = new BaseRankFactorMaintenance();
        baseRankFactorMaintenance.setRankId(maxId);
        baseRankFactorMaintenance.setCreateTime(new Date());
        baseRankFactorMaintenance.setCoefficient(rate);
        rankFactorMaintenance.setDataFromBase(baseRankFactorMaintenance);
        rankFactorMaintenance.save();
        return collection.toJSON(1, "新增成功");
    }


    /**
     * @param param
     * @return java.lang.String
     * @author liubin
     * @creed: write code
     * @date 2020/1/9 17:22
     * @describe: 维护职级的系数
     */
    private String rankMaintenance(Map<String, Object> param) throws SQLException {
        logger.info("--------------------- param: " + param);
        //获取维护的系数
        BigDecimal rate = BaseHelpUtils.getBigDecimalValue(param.get("rate"));
        List<Map> lists = (List<Map>) param.get("lists");
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        if (BaseHelpUtils.isNullOrEmpty(lists) || lists.size() == 0) {
            return collection.toJSON(-1, "没有获取到需要维护的直接");
        }
        RankFactorMaintenance rankFactorMaintenance = new RankFactorMaintenance();
        for (Map map : lists) {
            //获取直接的ID
            int dicTypeValueId = BaseHelpUtils.getIntValue(map.get("dicTypeValueId"));
            rankFactorMaintenance.clear();
            rankFactorMaintenance.setConditionRankId("=", dicTypeValueId);
            //如果不存在则更新系数
            if (!rankFactorMaintenance.isExist()) {
                BaseRankFactorMaintenance baseRankFactorMaintenance = new BaseRankFactorMaintenance();
                baseRankFactorMaintenance.setCoefficient(rate);
                baseRankFactorMaintenance.setCreateTime(new Date());
                baseRankFactorMaintenance.setRankId(dicTypeValueId);
                rankFactorMaintenance.clear();
                rankFactorMaintenance.setDataFromBase(baseRankFactorMaintenance);
                rankFactorMaintenance.save();
            } else {
                rankFactorMaintenance.setCoefficient(rate);
                rankFactorMaintenance.setCreateTime(new Date());
                rankFactorMaintenance.conditionalUpdate();
            }

        }
        return collection.toJSON(1, "保存成功");
    }

    /**
     * @author liubin
     * @date 2019/12/24 15:12
     * @param [param]
     * @return java.lang.String
     * @description: 获取归还物品的业务表数据
     */
    private String getPersonnelBusinessLinkReturn(Map<String, Object> param) {
        logger.info("------------------------------ param：" + param);
        //获取业务流程表的数据
        int personnelBusinessId = BaseHelpUtils.getIntValue(param.get("personnelBusinessId"));
        return null;
    }

    /**
     * @author liubin
     * @date 2019/12/20 16:42
     * @param [param]
     * @return java.lang.String
     * @description: 获取申请人所有的未归还的物品
     */
    private String getItemsNeedToReturn(Map<String, Object> param) throws SQLException {
        logger.info("---------------------- param ：" + param);
        int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
        //查询该员工所有的没有归还的物品
        ArrayList<BasePersonnelBusinessLinkEquipment> lists = new ArrayList<>();
        BaseCollection<BasePersonnelBusinessLinkEquipment> bc = new BaseCollection<>();
        PersonnelBusinessLinkEquipment personnelBusinessLinkEquipment = new PersonnelBusinessLinkEquipment();
        PersonnelBusines personnelBusines = new PersonnelBusines();
        //查询该员工所有的物品申请的流程
        personnelBusines.setConditionProcessType("=", processType_31);
        personnelBusines.setConditionEmployeeId("=", employeeId);
        //知查询物品类型为借用的流程
        personnelBusines.setConditionType("=", 1);
        List<BasePersonnelBusines> basePersonnelBusiness = personnelBusines.conditionalLoad();
        if (!BaseHelpUtils.isNullOrEmpty(basePersonnelBusiness) && basePersonnelBusiness.size() != 0) {
            SystemProcessInstance systemProcessInstance = new SystemProcessInstance();
            for (BasePersonnelBusines personnelBusiness : basePersonnelBusiness) {
                Integer personnelBusinessId = personnelBusiness.getPersonnelBusinessId();
                //查询关联的流程实例表（制查询已经审批完成的 去除驳回和正在发起的）
                systemProcessInstance.clear();
                systemProcessInstance.setConditionBusinessId("=", personnelBusinessId);
                systemProcessInstance.setConditionProcessType("=", 31);
                BaseSystemProcessInstance baseSystemProcessInstance = systemProcessInstance.executeQueryOneRow();
                if (null == baseSystemProcessInstance) {
                    continue;
                }
                int processStatus = BaseHelpUtils.getIntValue(baseSystemProcessInstance.getProcessStatus());
                int deleteFlag = BaseHelpUtils.getIntValue(baseSystemProcessInstance.getDeleteFlag());
                if (processStatus != 3 || deleteFlag ==1) {
                    continue;
                }
                personnelBusinessLinkEquipment.clear();
                personnelBusinessLinkEquipment.setConditionParentId("=", personnelBusinessId);
                personnelBusinessLinkEquipment.setConditionIsReturn("=", false);
                List<BasePersonnelBusinessLinkEquipment> basePersonnelBusinessLinkEquipments = personnelBusinessLinkEquipment.conditionalLoad();
                if (!BaseHelpUtils.isNullOrEmpty(basePersonnelBusinessLinkEquipments) && basePersonnelBusinessLinkEquipments.size() != 0) {
                    for (BasePersonnelBusinessLinkEquipment basePersonnelBusinessLinkEquipment : basePersonnelBusinessLinkEquipments) {
                        //获取归还的数量
                        int returnAmount = BaseHelpUtils.getIntValue(basePersonnelBusinessLinkEquipment.getReturnAmount());
                        //获取借用的总数
                        int amount = BaseHelpUtils.getIntValue(basePersonnelBusinessLinkEquipment.getAmount());
                        int remainingAmount = amount - returnAmount;
                        basePersonnelBusinessLinkEquipment.setRemainingReturn(remainingAmount);
                        basePersonnelBusinessLinkEquipment.setReturnAmount(returnAmount);
                        lists.add(basePersonnelBusinessLinkEquipment);
                    }
                }
            }
        }
        bc.setCollections(lists);
        return bc.toJSON(1,"成功");
    }

    /**
     * 批量修改订单的部门经理
     * @param param
     * @return
     */
    private String editorDepartmentManager(Map<String, Object> param) throws SQLException {
        logger.info("------------------------------ param :" + param);
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        Project project = new Project();
        //获取需要更改的订单信息
        List<Map<String, Object>> list = (List<Map<String, Object>>)param.get("list");
        //获取新的部门经理的信息
        int departmentManager = BaseHelpUtils.getIntValue(param.get("departmentManager"));
        if (departmentManager == 0) {
            return collection.toJSON(-1, "数据异常,没有获取到新部门经理的信息");
        }
        for (Map<String, Object> map : list) {
            int projectId = BaseHelpUtils.getIntValue(map.get("projectId"));
            if (projectId == 0) {
                continue;
            }
            project.clear();
            project.setProjectId(projectId);
            if (!project.load()) {
                continue;
            }
            BaseProject baseProject = project.generateBase();
            baseProject.setDepartmentManagerId(departmentManager);
            project.clear();
            project.setDataFromBase(baseProject);
            project.update();
        }
        return collection.toJSON(1, "更新成功");
    }
}
