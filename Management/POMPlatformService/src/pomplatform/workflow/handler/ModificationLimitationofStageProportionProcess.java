package pomplatform.workflow.handler;

import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.bean.BaseSystemProcessInstanceActivity;
import com.pomplatform.db.dao.*;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import org.apache.bcel.generic.NEW;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.util.*;

public class ModificationLimitationofStageProportionProcess implements GenericProcessor {
    @Override
    public String execute(String s, HttpServletRequest httpServletRequest) throws Exception {
        JSON parser = new JSON(new StringReader(s));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        // 获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {
            case "ModificationLimitationofStageProportion":
                return find(params);
            case "confirmationLetterFind":
                return confirmationLetterFind(params);
        }
        return null;
    }


    /**
     * 查询回收确认函，如果运营中心节点审批不超过15天，可确认积分和成本，如果超过15天，看合同的所有订单的确认函是否回收了，如果没有，则不能确认积分和成本
     *
     * @param params
     * @return
     */
    private String confirmationLetterFind(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection();

        int projectId = BaseHelpUtils.getIntValue(params, "projectId");
        Project project = new Project();
        project.setProjectId(projectId);
        if (project.load()) {
            PersonnelBusines busines = new PersonnelBusines();
            busines.setConditionProjectId("=", project.getProjectId());
            busines.setConditionProcessType("=", 51);
            List<BasePersonnelBusines> businesList = busines.conditionalLoad();
            //有没有跨流程申请记录
            if (!BaseHelpUtils.isNullOrEmpty(businesList)) {
                for (BasePersonnelBusines b : businesList) {
                    SystemProcessInstance instance = new SystemProcessInstance();
                    instance.setConditionBusinessId("=", b.getPersonnelBusinessId());
                    instance.setConditionProcessType("=", 51);
                    List<BaseSystemProcessInstance> baseInstances = instance.conditionalLoad();
                    //有没有跨流程审批记录
                    if (!BaseHelpUtils.isNullOrEmpty(baseInstances)) {
                        for (BaseSystemProcessInstance baseInstance : baseInstances) {
                            SystemProcessInstanceActivity activity = new SystemProcessInstanceActivity();
                            activity.setConditionProcessInstanceId("=", baseInstance.getProcessInstanceId());
                            activity.setConditionProcessType("=", 51);
                            activity.setConditionStatus("=", 2);
                            activity.setConditionBackViewName("=", "运营中心");
                            List<BaseSystemProcessInstanceActivity> baseActivitys = activity.conditionalLoad();
                            //有跨流程审批，而且运营中心节点审批通过
                            if (!BaseHelpUtils.isNullOrEmpty(baseActivitys)) {
                                for (BaseSystemProcessInstanceActivity baseActivity : baseActivitys) {
                                    //获取申请的时间
                                    Date operate_time = baseActivity.getInstanceActivityCreateTime();
                                    Date newDate = new Date();
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.setTime(newDate);
                                    calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 15);
                                    newDate = calendar.getTime();
                                    //如果当前时间减15天还比审批的操作时间要大，需要查看是否确认函都绑定了
                                    if (newDate.compareTo(operate_time) > 0) {
                                        SubContract contract = new SubContract();
                                        contract.setConditionSubContractCode("=", project.getContractCode());
                                        List<BaseSubContract> baseSubContractss = contract.conditionalLoad();
                                        //主合同是否存在
                                        if (!BaseHelpUtils.isNullOrEmpty(baseSubContractss)) {
                                            for (BaseSubContract baseSubContracts : baseSubContractss) {
                                                AttachmentManage manage = new AttachmentManage();
                                                manage.setConditionContractId("=", baseSubContracts.getParentId());
                                                List<BaseAttachmentManage> baseManages = manage.conditionalLoad();
                                                //子合同是否存在
                                                if (!BaseHelpUtils.isNullOrEmpty(baseManages)) {
                                                    boolean bool = false;
                                                    for (BaseAttachmentManage a : baseManages) {
                                                        Date operateTime = a.getOperateTime();
                                                        if(newDate.compareTo(operateTime) > 0){
                                                            //如果没有回收确认函
                                                            if (!a.getConfirmationLetter()) {
                                                                bool = true;
                                                            }
                                                        }

                                                    }
                                                    if (bool) {
                                                        return bc.toJSON(1, "有未回收的确认函，无法进行经费结算");
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                            }

                        }

                    }
                }
            }
        }

        return bc.toJSON(-1, null);
    }

    /**
     * 阶段占比修改限制，当经费结算跨阶段流程的发起后，获取跨阶段流程的状态
     *
     * @param params
     * @return
     * @throws Exception
     */
    private String find(Map<String, Object> params) throws Exception {
        BaseCollection<BaseSystemProcessInstance> bc = new BaseCollection<>();
        List<BaseSystemProcessInstance> list = new ArrayList<>();
        int projectId = BaseHelpUtils.getIntValue(params, "projectId");
        int stageId = BaseHelpUtils.getIntValue(params, "stageId");
        PersonnelBusines dao = new PersonnelBusines();
        dao.setConditionProjectId("=", projectId);
        dao.setConditionProcessType("=", 51);
        dao.setConditionStageId("=", stageId);
        BasePersonnelBusines bpb = dao.executeQueryOneRow();
        //该阶段是否有夸阶段审批流程，
        if (!BaseHelpUtils.isNullOrEmpty(bpb)) {
            SystemProcessInstanceActivity systemProcessInstanceActivity = new SystemProcessInstanceActivity();
            systemProcessInstanceActivity.setConditionBusinessId("=", bpb.getPersonnelBusinessId());
            BaseSystemProcessInstanceActivity bspia = systemProcessInstanceActivity.executeQueryOneRow();
            //查询跨阶段审批流程的状态
            if (!BaseHelpUtils.isNullOrEmpty(bspia)) {
                SystemProcessInstance instance = new SystemProcessInstance();
                int piId = bspia.getProcessInstanceId();
                instance.setConditionProcessInstanceId("=", piId);
                BaseSystemProcessInstance base = instance.executeQueryOneRow();
                list.add(base);
                bc.setCollections(list);
                return bc.toJSON();
            } else {
                bc.setCollections(list);
                return bc.toJSON(0, null);
            }
        } else {
            bc.setCollections(list);
            return bc.toJSON(0, null);
        }

    }

    public static void main(String[] args) throws Exception {
        ModificationLimitationofStageProportionProcess m = new ModificationLimitationofStageProportionProcess();
        Map<String, Object> map = new HashMap<>();
        map.put("projectId", 6293);
        map.put("optType", "confirmationLetterFind");
        String s = m.confirmationLetterFind(map);
        System.out.println(s);
    }
}
