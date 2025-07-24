package pomplatform.workflow.handler;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.GenericProcessor;
import delicacy.servlet.HttpCookie;
import delicacy.system.bean.BaseSystemProcessAttention;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.executor.SystemProcessConstants;


public class AttentionBatchProcessor implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	BaseSystemProcessAttention bspa = new BaseSystemProcessAttention();
        bspa.setDataFromJSON(creteria);
        HttpCookie cookies = new HttpCookie(request);
        //获取当前批阅的审批人，即当前登录人
        int employeeId = cookies.getOperatorId();
        if(employeeId <= 0){
        	employeeId = bspa.getEmployeeId();
        }
        SystemProcessAttention spa = new SystemProcessAttention();
        if(null != bspa.getProcessType() && bspa.getProcessType() > 0 && employeeId > 0){
        	spa.setConditionProcessType("=", bspa.getProcessType());
        	spa.setConditionEmployeeId("=", employeeId);
        	spa.setStatus(SystemProcessConstants.ATTENTION_STATUS_DONE);
        	spa.conditionalUpdate();
        }
        spa.setDataFromBase(bspa);
        return spa.generateBase().toOneLineJSON();
    }
    
}
