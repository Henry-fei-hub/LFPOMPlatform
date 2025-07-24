package pomplatform.common.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.bean.BaseKeyValue;
import pomplatform.employee.bean.BaseGetDepartmentIdByRoleId;
import pomplatform.employee.bean.BaseGetPlateIdByRole;
import pomplatform.employee.bean.ConditionGetDepartmentIdByRoleId;
import pomplatform.employee.bean.ConditionGetPlateIdByRole;
import pomplatform.employee.query.QueryGetDepartmentIdByRoleId;
import pomplatform.employee.query.QueryGetPlateIdByRole;
import pomplatform.workflow.bean.BaseSearchProcessIdByUserId;
import pomplatform.workflow.bean.ConditionSearchProcessIdByUserId;
import pomplatform.workflow.query.QuerySearchProcessIdByUserId;

public class GetUserInfoProcessor implements GenericProcessor {
	//数据管理专员的角色ID,定义这个角色查看跨部门的信息
	public static final int ROLD_ID = 47;
	//考勤管理员的角色ID，查看跨部门的考勤信息
	public static final int ROLE_ID_16 = 16;
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取登录用户ID
        int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
        BaseCollection<BaseKeyValue> bc = new BaseCollection<>();
        List<BaseKeyValue> list = new ArrayList<>();
        String value = getUserPlateId(employeeId);
        if(null != value && value.length() > 0){
        	BaseKeyValue bean = new BaseKeyValue();
        	bean.setKey("rolePlateId");
        	bean.setValue(value);
        	list.add(bean);
        }
        List<BaseSearchProcessIdByUserId> processInfoList = getProcessInfo(employeeId);
        if(null != processInfoList && !processInfoList.isEmpty()){
        	StringBuilder idStr = new StringBuilder();
        	StringBuilder iconStr = new StringBuilder();
        	for(BaseSearchProcessIdByUserId obj : processInfoList){
        		if(idStr.length() > 0){
        			idStr.append(",");
        		}
        		if(iconStr.length() > 0){
        			iconStr.append(",");
        		}
        		idStr.append("\"").append(obj.getProcessExecuteName()).append("\":").append(obj.getProcessId()).append(":").append(obj.getParentProcessTypeId());
        		iconStr.append("\"").append(obj.getProcessExecuteName()).append("\":").append(obj.getIcon()).append(":").append(obj.getParentProcessTypeId());
        	}
        	BaseKeyValue idBean = new BaseKeyValue();
        	idBean.setKey("processId");
        	idBean.setValue(idStr.toString());
        	list.add(idBean);
        	BaseKeyValue iconBean = new BaseKeyValue();
        	iconBean.setKey("processIcon");
        	iconBean.setValue(iconStr.toString());
        	list.add(iconBean);
        }
        String departmentIds = getUserDepartmentId(employeeId);
        if(null != departmentIds && departmentIds.length() > 0){
        	BaseKeyValue bean = new BaseKeyValue();
        	bean.setKey("roleDepartmentId");
        	bean.setValue(departmentIds);
        	list.add(bean);
        }
        bc.setCollections(list);
        return bc.toJSON();
    }

    /**
     * 通过登录者的数据管理专员的角色，检索其关联的多个业务部门信息
     * @param employeeId
     */
    private String getUserPlateId(int employeeId) throws Exception{
        Set<Integer> plateIdSet = new HashSet<>();
        ConditionGetPlateIdByRole plateIdCondition = new ConditionGetPlateIdByRole();
        plateIdCondition.setEmployeeId(employeeId);
        plateIdCondition.setRoleId(ROLD_ID);
        QueryGetPlateIdByRole plateIdDao = new QueryGetPlateIdByRole();
        BaseCollection<BaseGetPlateIdByRole> plateIdCollection = plateIdDao.executeQuery(null, plateIdCondition);
        List<BaseGetPlateIdByRole> plateIdList = plateIdCollection.getCollections();
        if(null!=plateIdList && !plateIdList.isEmpty()){
        	for(BaseGetPlateIdByRole obj : plateIdList){
        		if(null != obj.getPlateId()){
        			plateIdSet.add(obj.getPlateId());
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(Integer plateId : plateIdSet){
        	if(sb.length()>0){
        		sb.append(",");
        	}
        	sb.append(plateId);
        }
        return sb.toString();
    }
    
    private List<BaseSearchProcessIdByUserId> getProcessInfo(int employeeId) throws Exception{
    	ConditionSearchProcessIdByUserId condition = new ConditionSearchProcessIdByUserId();
    	condition.setEmployeeId(employeeId);
//    	condition.setParentProcessTypeId(StaticUtils.PARENT_PROCESS_TYPE_1);
    	QuerySearchProcessIdByUserId query = new QuerySearchProcessIdByUserId();
    	BaseCollection<BaseSearchProcessIdByUserId> bc = query.executeQuery(null, condition);
    	return bc.getCollections();
	}
    
    /**
     * 通过登录者的考勤管理员的角色，检索其关联的多个部门信息
     * @param employeeId
     */
    private String getUserDepartmentId(int employeeId) throws Exception{
        ConditionGetDepartmentIdByRoleId condition = new ConditionGetDepartmentIdByRoleId();
        condition.setEmployeeId(employeeId);
        condition.setRoleId(ROLE_ID_16);
        QueryGetDepartmentIdByRoleId query = new QueryGetDepartmentIdByRoleId();
        BaseCollection<BaseGetDepartmentIdByRoleId> bc = query.executeQuery(null, condition);
        List<BaseGetDepartmentIdByRoleId> list = bc.getCollections();
        StringBuilder sb = new StringBuilder();
        if(null != list && !list.isEmpty()){
        	for(BaseGetDepartmentIdByRoleId obj : list){
        		if(null != obj.getDepartmentId()){
        			if(sb.length()>0){
                		sb.append(",");
                	}
                	sb.append(obj.getDepartmentId());
        		}
        	}
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		GetUserInfoProcessor a = new GetUserInfoProcessor
				();
		try{
		System.out.println(a.execute("{\"employeeId\":81}", null));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}