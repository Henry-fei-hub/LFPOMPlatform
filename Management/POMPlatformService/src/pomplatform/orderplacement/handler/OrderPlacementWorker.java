package pomplatform.orderplacement.handler;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import delicacy.common.*;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.executor.SystemProcessConstants;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contract.handler.CustomMainContractHandler;
import pomplatform.orderplacement.bean.BaseOrderInfoWithO;
import pomplatform.orderplacement.dao.OrderInfoWithO;
import pomplatform.outQuotations.bean.BaseOnLoadMainProjectBusinessTypeByContract;
import pomplatform.outQuotations.bean.ConditionOnLoadMainProjectBusinessTypeByContract;
import pomplatform.outQuotations.query.QueryOnLoadMainProjectBusinessTypeByContract;

public class OrderPlacementWorker implements GenericWorkflowProcessor {

    private static final java.util.logging.Logger logger = Logger.getLogger("订单下达的审核流程");

    /**
     * 合同id
     */
    int contractId;

    /**
     * 合同的flow_status
     */
    int flowStatus;

    /**
     * 新增流程面板
     */
    BasePersonnelBusines personnerBean = new BasePersonnelBusines();

    CustomMainContractHandler customMainContractHandler = new CustomMainContractHandler();

    BaseOrderInfo bean1 = new BaseOrderInfo();

    @Override
    public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
        contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
        flowStatus = BaseHelpUtils.getIntValue(params.get("flowStatus"));
        Contract contract = new Contract();
        contract.setContractId(contractId);
        contract.setConditionContractId("=", contractId);
        BaseContract baseContract = contract.executeQueryOneRow();

        if (!BaseHelpUtils.isNullOrEmpty(baseContract)) {
            bean1.setDataFromMap(baseContract.toMap());
            bean1.setRemark(BaseHelpUtils.getString(params.get("contentInfo")));
            bean1.setFileId(BaseHelpUtils.getIntValue(params.get("attachmentId")));
            bean1.setFileUrl(BaseHelpUtils.getString(params.get("attachment")));
            bean1.setFileName(BaseHelpUtils.getString(params.get("attachmentName")));
        }
        //保存流程主表数据
        OrderInfo dao1 = new OrderInfo();
        dao1.setDataFromBase(bean1);
        dao1.save();
        int orderInfoId = dao1.getOrderInfoId();

        Contract contractdao = new Contract();
        System.out.println("contractId===" + contractId);
        contractdao.setConditionContractId("=", contractId);
        contractdao.setFlowStatus(flowStatus);
        contractdao.setUpdateTime(new Date());
        contractdao.conditionalUpdate();


        //保存流程子表数据
        List<BaseOrderInfoChild> childRecords = GenericBase.__getList(params.get("childRecords"), BaseOrderInfoChild.newInstance());
        List<BaseOrderInfoChild> manageRecords = GenericBase.__getList(params.get("manageRecords"), BaseOrderInfoChild.newInstance());
        OrderInfoChild orderInfoChilddao = new OrderInfoChild();
        for (BaseOrderInfoChild child : childRecords) {
            child.setOrderInfoId(orderInfoId);
        }
        for (BaseOrderInfoChild child : manageRecords) {
            child.setOrderInfoId(orderInfoId);
        }
        orderInfoChilddao.save(childRecords);
        orderInfoChilddao.save(manageRecords);

        //因为提交订单肯定是拆分完了，这里直接进行main_project_business_types的数据修改
        BaseOnLoadMainProjectBusinessTypeByContract base = new BaseOnLoadMainProjectBusinessTypeByContract();
        int mainProjectId = 0;
        int outQuotationId = 0;
        QueryOnLoadMainProjectBusinessTypeByContract query = new QueryOnLoadMainProjectBusinessTypeByContract();
        ConditionOnLoadMainProjectBusinessTypeByContract condition = new ConditionOnLoadMainProjectBusinessTypeByContract();
        condition.setContractId(contractId);
        BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> execute = query.execute(null, condition);
        if (!BaseHelpUtils.isNullOrEmpty(execute) && execute.getCollections().size() > 0) {
            base = execute.getCollections().get(0);
            mainProjectId = BaseHelpUtils.getIntValue(base.getMainProjectId());
            outQuotationId = BaseHelpUtils.getIntValue(base.getOutQuotationId());
        }
        MainProjectBusinessType mDao = new MainProjectBusinessType();
        mDao.setConditionMainProjectId("=", mainProjectId);
        mDao.setConditionOutQuotationId("=", outQuotationId);
        mDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_3);//表示已拆分成子订单了
        mDao.conditionalUpdate();

        BusinessAbstract ba = new BusinessAbstract(dao1.getOrderInfoId(), "");
        return ba;
    }

    @Override
    public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
        int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
        personnerBean.setDataFromMap(params);

        flowStatus = BaseHelpUtils.getIntValue(params.get("flowStatus"));
        System.out.println("flowStatus=====" + flowStatus + "complete=====" + completed);
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

//		1.先处理你改节点的业务逻辑的数据
        OrderInfoChild childdao = new OrderInfoChild();
        List<BaseOrderInfoChild> childRecords = GenericBase.__getList(params.get("childRecords"), BaseOrderInfoChild.newInstance());
        List<BaseOrderInfoChild> manageRecords = GenericBase.__getList(params.get("manageRecords"), BaseOrderInfoChild.newInstance());
        List<BaseSubContract> childRecords1 = GenericBase.__getList(params.get("childRecords"), BaseSubContract.newInstance());
        List<BaseSubContract> manageRecords1 = GenericBase.__getList(params.get("manageRecords"), BaseSubContract.newInstance());
        int orderInfo = BaseHelpUtils.getIntValue(params.get("orderInfoId"));
        for (BaseOrderInfoChild child : childRecords) {
            childdao.clear();
            if (BaseHelpUtils.getIntValue(child.getOrderInfoChildId()) != 0) {
                childdao.setDataFromBase(child);
                childdao.update();
            } else {
                childdao.setDataFromBase(child);
                childdao.setOrderInfoId(orderInfo);
                childdao.save();
            }
        }
        for (BaseOrderInfoChild child : manageRecords) {
            childdao.clear();
            if (BaseHelpUtils.getIntValue(child.getOrderInfoChildId()) != 0) {
                childdao.setDataFromBase(child);
                childdao.update();
            } else {
                childdao.setDataFromBase(child);
                childdao.setOrderInfoId(orderInfo);
                childdao.save();
            }
        }

        /**
         * 流程已完成，将数据插入到相应的表中
         */
        if (completed) {
            /**
             * 流程被驳回,修改主合同状态
             */
            if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
//				2.当流程被驳回的时候，如果修改了数据，你要把数据( sub_contracats等等 )恢复还原
                Contract contractDao = new Contract();
                contractDao.setConditionContractId("=", contractId);
                contractDao.setFlowStatus(0);
                contractDao.conditionalUpdate();
            } else if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
                SubContract dao = new SubContract();
                for (BaseSubContract child : childRecords1) {
                    if (BaseHelpUtils.getIntValue(child.getSubContractId()) != 0) {
                        dao.setConditionSubContractId("=", BaseHelpUtils.getIntValue(child.getSubContractId()));
                        List<BaseSubContract> list = dao.conditionalLoad();
                        if (!BaseHelpUtils.isNullOrEmpty(list.get(0))) {
                            dao.setDataFromBase(child);
                            dao.update();
                        } else {
                            dao.setDataFromBase(child);
                            dao.save();
                        }
                    } else {
                        dao.setDataFromBase(child);
                        dao.save();
                    }
                    dao = new SubContract();
                }
                for (BaseSubContract child : manageRecords1) {
                    if (BaseHelpUtils.getIntValue(child.getSubContractId()) != 0) {
                        dao.setConditionSubContractId("=", BaseHelpUtils.getIntValue(child.getSubContractId()));
                        List<BaseSubContract> list = dao.conditionalLoad();
                        if (!BaseHelpUtils.isNullOrEmpty(list.get(0))) {
                            dao.setDataFromBase(child);
                            dao.update();
                        } else {
                            dao.setDataFromBase(child);
                            dao.save();
                        }
                    } else {
                        dao.setDataFromBase(child);
                        dao.save();
                    }
                    dao = new SubContract();
                }
                /**
                 * 流程已完成的时候进行相应的判断
                 */
                Map<String, Object> flowsParams = params;
                flowsParams.put("contractId", contractId);
                flowsParams.put("operateEmployeeId", employeeId);
                flowsParams.put("flowStatus", flowStatus + 1);
                customMainContractHandler.goFlowMainContract(flowsParams);
            }
        }

        /**
         * 更新流程状态
         */
//		PersonnelBusines dao = new PersonnelBusines();
//		logger.info("驳回的合同id" + personnerBean.getParentId());
//		dao.setPrimaryKeyFromBase(personnerBean);
//		dao.load();
//		dao.clearModifiedFlags();
//		dao.setDataFromBase(personnerBean);
//		dao.update();
        BusinessAbstract ba = new BusinessAbstract(0, "");
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
        OrderInfoWithO dao = new OrderInfoWithO();
        dao.setOrderInfoId(businessId);
        dao.load();
        return dao.generateBaseExt().toJSON();
    }

}
