package com.pomplatform.client.data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 *
 * @author guanxgun
 */
public class RoleDefinition {
	private static final Logger logger = Logger.getLogger("");
	// 公司高管团队
	final public static int ROLE_MANAGEMENT_TEAM = 1;
	// 事业部负责人
	final public static int ROLE_DEPARTMENT_DIRECTOR = 2;
	// 部门经理
	final public static int ROLE_DEPARTMENT_MANAGER = 3;
	// 专业负责人
	final public static int ROLE_PROJECT_MANAGER = 4;
	// 设计师
	final public static int ROLE_DESIGNER = 5;
	// 公司运营部员工
	final public static int ROLE_OPERATION_TEAM = 6;
	// 公司人力资源部
	final public static int ROLE_HUMAN_RESOURCE_TEAM = 7;
	// 公司IT
	final public static int ROLE_INFORMATION_TEAM = 8;
	// 公司部门助理
	final public static int ROLE_DEPARTMENT_TEAM = 9;
	// 公司合约部
	final public static int ROLE_CONTRACT_TEAM = 10;
	// 公司普通员工
	final public static int ROLE_NORMAL_PEOPLE = 0;
	// 考勤管理员
	final public static int ROLE_CHECK_TEAM = 11;
	//财务会计
	final public static int ROLE_FINANCIAL_ACCOUNTING = 14;

	public static String getRoleName(int roleId) {
		switch (roleId) {
		case ROLE_NORMAL_PEOPLE:
			return "";
		case ROLE_CONTRACT_TEAM:
			return "合约部";
		case ROLE_DEPARTMENT_TEAM:
			return "助理";
		case ROLE_INFORMATION_TEAM:
			return "IT";
		case ROLE_HUMAN_RESOURCE_TEAM:
			return "HR";
		case ROLE_OPERATION_TEAM:
			return "运营部";
		case ROLE_DESIGNER:
			return "设计师";
		case ROLE_PROJECT_MANAGER:
			return "专业负责人";
		case ROLE_DEPARTMENT_MANAGER:
			return "部门经理";
		case ROLE_DEPARTMENT_DIRECTOR:
			return "事业部负责人";
		case ROLE_MANAGEMENT_TEAM:
			return "高管";
		case ROLE_CHECK_TEAM:
			return "考勤管理员";
		case ROLE_FINANCIAL_ACCOUNTING:
			return "财务会计";
		}
		return "";
	}

	public static String getRoleName() {
		return getRoleName(ClientUtil.getRoleId());
	}

	public static String getFullEmployeeName() {
		StringBuilder sb = new StringBuilder();
		sb.append(getRoleName());
		sb.append(" ");
		sb.append(ClientUtil.getUserName());
		sb.append(" ");
		sb.append("您好!");
		return sb.toString();
	}

	public static String generateProjectID(String val) {
		StringBuilder sb = new StringBuilder();
		sb.append(val);
		switch (ClientUtil.getPlateId()) {
		case 1:
			sb.append("-B");
			break;
		case 2:
			sb.append("-H");
			break;
		case 3:
			sb.append("-O");
			break;
		case 4:
			sb.append("-M");
			break;
		case 5:
			sb.append("-E");
			break;
		case 6:
			sb.append("-C");
			break;
		default:
			sb.append("-U");
			break;
		}
		return sb.toString();
	}

	public static boolean checkProjectValidaion(Map data) {
		if (ClientUtil.isNullOrEmpty(data.get("projectName"))) {
			SC.say("项目名称必须输入");
			return false;
		}
		if (ClientUtil.isNullOrEmpty(data.get("projectManageId"))) {
			SC.say("专业负责人不能为空");
			return false;
		}
		if (ClientUtil.isNullOrEmpty(data.get("projectLevel"))) {
			SC.say("项目等级不能为空");
			return false;
		}
		int plateId = ClientUtil.getPlateId();
		switch (plateId) {
		case 1:
		case 3:
		case 5:
		case 6:
			if (ClientUtil.isNullOrZero(data.get("commonArea"))) {
				SC.say("公共面积必须输入");
				return false;
			}
			break;
		case 2:
			if (ClientUtil.isNullOrZero(data.get("totalAmount"))) {
				SC.say("项目总金额必须输入");
				return false;
			}
		case 4:
			if (ClientUtil.isNullOrZero(data.get("commonArea"))) {
				SC.say("公共面积必须输入");
				return false;
			}
			if (ClientUtil.isNullOrZero(data.get("totalAmount"))) {
				SC.say("项目总金额必须输入");
				return false;
			}
			break;
		}
		return true;
	}

	/**
	 * 根据板块和角色获取专业负责人下拉
	 * 
	 * @param item
	 * @param plateId
	 */
	public static void setProjectManagerItemValueMap(FormItem item, int plateId) {
		Map<String,Object> params = new HashMap<>();
		if(plateId > 0){
			params.put("plateId", plateId);
		}
		params.put("roleId", ROLE_PROJECT_MANAGER);
		KeyValueManager.setValueMapFromQuery("NQ_Semployeepdror", MapUtils.toJSON(params), item);
	}
	
	
	public static void getValueMapFromQuery(int plateId,Map<String,String> backMap) {
		Map<String,Object> params = new HashMap<>();
		if(plateId > 0){
			params.put("plateId", plateId);
		}
		params.put("roleId", ROLE_PROJECT_MANAGER);
		DBDataSource.callOperation("NQ_Semployeepdror", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					String idFieldName = "idd";
					String valFieldName = "val";
					if (dsResponse.getData() != null && dsResponse.getData().length > 0) {
						for (Record r : dsResponse.getData()) {
							backMap.put(r.getAttribute(idFieldName), r.getAttribute(valFieldName));
						}
						logger.info("backMap-----------1"+backMap);
					}
				}
			}
		});
	}

	/**
	 * 根据板块获取项目下拉
	 * 
	 * @param item
	 * @param plateId
	 */
	public static void setProjectItemValueMap(FormItem item, int plateId) {
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		KeyValueManager.setValueMapFromQuery("NQ_SprojectItem", MapUtils.toJSON(params), item);
	}

	// 根据角色ID获取属于该角色的职员下拉列表数据
	public static void setEmployeeItemValueMapByRoleId(FormItem item, int roleId) {
		Map<String,Object> params = new HashMap<>();
		params.put("roleId", roleId);
		KeyValueManager.setValueMapFromQuery("NQ_GetEmployeesByRole", MapUtils.toJSON(params), item);
	}
	
	// 根据角色ID和业务部门ID,获取到改业务部门下该角色的人员，如果有多名，则只选择一名
	public static void setEmployeeByPlateIdAndRoleId(FormItem item,int plateId, int roleId) {
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		params.put("roleId", roleId);
		DBDataSource.callOperation("NQ_GetEmployeesByRole", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (dsResponse.getData() != null && dsResponse.getData().length > 0) {
						Record r = dsResponse.getData()[0];
						int employeeId = BaseHelpUtils.getIntValue(r.getAttribute("idd"));
						item.setDefaultValue(employeeId);
						
						LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
						for (Record rr : dsResponse.getData()) {
							lhm.put(rr.getAttribute("idd"), rr.getAttribute("val"));
						}
						item.setValueMap(lhm);
					}
				}
			}
		});
	}

	/**
	 * 获取板块下的成员下拉
	 * 
	 * @param item
	 * @param plateId
	 */
	public static void setPlageEmployeeItemValueMap(FormItem item, int plateId) {
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		KeyValueManager.setValueMapFromQuery("NQ_Semployeepdror", MapUtils.toJSON(params), item);
	}

	/**
	 * 获取板块下的部门对应成员下拉
	 * 
	 * @param item
	 * @param deptId
	 */
	public static void setPlageDeptIdEmployeeItemValueMap(FormItem item, int deptId) {
		Map<String,Object> params = new HashMap<>();
		params.put("departmentId", deptId);
		KeyValueManager.setValueMapFromQuery("EP_CustomDeptIdEmployeeProcessor", MapUtils.toJSON(params), item);
	}

	/**
	 * 获取板块下的部门下拉
	 * 
	 * @param item
	 * @param plateId
	 */
	public static void setPlageDeptIdItemValueMap(FormItem item, int plateId) {
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		KeyValueManager.setValueMapFromQuery("NQ_Sdepartmentdor", MapUtils.toJSON(params), item);
	}
	
	//获取指定业务部门下的一级归属部门
	public static void setPlateOfDepartmentId(FormItem item, int plateId) {
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
//		params.put("parentId", 1);
		DBDataSource.callOperation("NQ_Sdepartmentdor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (dsResponse.getData() != null && dsResponse.getData().length > 0) {
						Record r = dsResponse.getData()[0];
						int departmentId = BaseHelpUtils.getIntValue(r.getAttribute("departmentId"));
						item.setDefaultValue(departmentId);
					}
				}
			}
		});
	}

	/**
	 * 获取部门下拥有补贴的项目
	 * 
	 * @param item
	 * @param plateId
	 * @param employeeId
	 */
	public static void setProjectAdvanceValueMap(FormItem item, int plateId, int employeeId) {
		Map<String,Object> params = new HashMap<>();
		params.put("plateId", plateId);
		params.put("employeeId", employeeId);
		KeyValueManager.setValueMapFromQuery("EP_OnGetProjectAdvanceItem", MapUtils.toJSON(params), item);
	}
	
	/**
	 * 获取付款申请收款单位的下拉框
	 * @param item
	 * @param val
	 */
	public static void setReceiveUnitItemValueMap(FormItem item, String val) {
		Map<String,Object> params = new HashMap<>();
		params.put("val", val);
		KeyValueManager.setValueMapFromQuery("NQ_OnPayMoneyManageBusiness", MapUtils.toJSON(params), item);
	}
	
	/**
	 * 获取付款申请收款单位的下拉框
	 * @param item
	 * @param val
	 */
	public static void setPlateItemValueMap(FormItem item, String val) {
		Map<String,Object> params = new HashMap<>();
		params.put("optType","onLoadPlateDataList");
		params.put("plateIds", val);
		KeyValueManager.setValueMapFromQuery("EP_OnCommonProcess", MapUtils.toJSON(params), item);
	}

	/**
	 * 获取积分变更的项目下拉列表
	 * 
	 * @param item
	 * @param plateId
	 * @param employeeId
	 */
	public static void getProjectChangeValueMap(FormItem item,int projectManageId) {
		Map<String,Object> params = new HashMap<>();
		params.put("projectManageId", projectManageId);
		KeyValueManager.setValueMapFromQuery("NQ_OnLoadProjectChangeList", MapUtils.toJSON(params), item);
	}
}
