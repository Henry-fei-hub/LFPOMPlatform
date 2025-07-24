package pomplatform.workflow.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.dao.ProjectCost;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.projectNormalReimbursement.bean.BaseProjectNormalReimbursementWithPn;
import pomplatform.workflow.projectTravelReimbursement.bean.BaseTravelReimbursementWithTt;

public class InsertProjectCostProcessor implements GenericProcessor {
    private static Logger logger = Logger.getLogger("");
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getString(param.get("optType"));
		switch (optType) {
		case "projectNormalReimbursement"://将项目日常报销数据作为项目成本导入到项目中
			return insertProjectCostOfPNR(param);
		case "projectTravelReimbursement"://将项目差旅报销数据作为项目成本导入到项目中
			return insertProjectCostOfPTR(param);
		default:
			return null;
		}
    }
    
    public String insertProjectCostOfPNR(Map<String, Object> param) throws Exception{
    	Map userData = (Map)param.get("userData");
    	BaseCollection bc = new BaseCollection<>();
    	if(null != userData && !userData.isEmpty()){
    		BaseProjectNormalReimbursementWithPn bean = new BaseProjectNormalReimbursementWithPn();
    		bean.setDataFromMap(userData);
    		List<BaseNormalReimbursementLinkProject> list = bean.getDetailNormalReimbursementLinkProject();
    		if(null != list && !list.isEmpty()){
    			ThreadConnection.beginTransaction();
    			Date date = new Date();
    			List<BaseProjectCost> saveList = new ArrayList<>();
    			for(BaseNormalReimbursementLinkProject obj : list){
    				BaseProjectCost cost = new BaseProjectCost();
    				cost.setAmount(obj.getAmount());
    				cost.setProjectId(obj.getProjectId());
    				cost.setCostDate(date);
    				cost.setEmployeeId(bean.getEmployeeId());
    				cost.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
    				saveList.add(cost);
    			}
    			ProjectCost dao = new ProjectCost();
    			dao.save(saveList);
    			return bc.toJSON();
    		}
    	}
    	return bc.toJSON(-1, "数据有误，项目成本导入失败");
    }
    
    public String insertProjectCostOfPTR(Map<String, Object> param) throws Exception{
    	Map userData = (Map)param.get("userData");
    	BaseCollection bc = new BaseCollection<>();
    	if(null != userData && !userData.isEmpty()){
    		BaseTravelReimbursementWithTt bean = new BaseTravelReimbursementWithTt();
    		bean.setDataFromMap(userData);
    		List<BaseTravelReimbursementLinkProject> list = bean.getDetailTravelReimbursementLinkProject();
    		if(null != list && !list.isEmpty()){
    			ThreadConnection.beginTransaction();
    			Date date = new Date();
    			List<BaseProjectCost> saveList = new ArrayList<>();
    			for(BaseTravelReimbursementLinkProject obj : list){
    				BaseProjectCost cost = new BaseProjectCost();
    				cost.setAmount(obj.getAmount());
    				cost.setProjectId(obj.getProjectId());
    				cost.setCostDate(date);
    				cost.setEmployeeId(bean.getApplicant());
    				cost.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
    				saveList.add(cost);
    			}
    			ProjectCost dao = new ProjectCost();
    			dao.save(saveList);
    			return bc.toJSON();
    		}
    	}
    	return bc.toJSON(-1, "数据有误，项目成本导入失败");
    }
    
    public void deleteSystemProcess(int processInstanceId) throws Exception{
    	//流程实例逻辑删除
    	SystemProcessInstance instanceDao = new SystemProcessInstance();
    	instanceDao.setConditionProcessInstanceId("=", processInstanceId);
    	instanceDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	instanceDao.conditionalUpdate();
    	//流程节点逻辑删除
    	SystemProcessInstanceActivity activityDao = new SystemProcessInstanceActivity();
    	activityDao.setConditionProcessInstanceId("=", processInstanceId);
    	activityDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	activityDao.conditionalUpdate();
    	//流程任务池逻辑删除
    	SystemProcessPooledTask poolTaskDao = new SystemProcessPooledTask();
    	poolTaskDao.setConditionProcessInstanceId("=", processInstanceId);
    	poolTaskDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	poolTaskDao.conditionalUpdate();
    	//流程知会信息逻辑删除
    	SystemProcessAttention attentionDao = new SystemProcessAttention();
    	attentionDao.setConditionProcessInstanceId("=", processInstanceId);
    	attentionDao.setDeleteFlag(StaticUtils.HAS_DELETE);
    	attentionDao.conditionalUpdate();
    }
}
