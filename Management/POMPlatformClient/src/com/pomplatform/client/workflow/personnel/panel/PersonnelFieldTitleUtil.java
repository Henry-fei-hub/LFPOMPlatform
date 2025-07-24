package com.pomplatform.client.workflow.personnel.panel;

import java.util.HashMap;
import java.util.Map;

import com.pomplatform.client.workflow.panel.MyPersonnelFlowDesignPanel;
import com.smartgwt.client.widgets.grid.ListGrid;

/**
 * 
 * @Title: PersonnelFieldTitleUtil.java 
 * @Package com.pomplatform.client.workflow.personnel.panel 
 * @Description: 
 * @author CL  
 * @date 2017年4月27日
 */
public class PersonnelFieldTitleUtil {
	/**
	 * 确认函申请流程title
	 */
	@SuppressWarnings("serial")
	public static Map<String, String> attachmentTitle = new HashMap<String, String>() {
		{
			put("plan", "合同特殊事项备注");
			put("fee", "确认函金额");
			put("attachment", "附件路径");
			put("reason", "附件名称");
			put("isRemoteCity", "是否有收款");
			put("projectName", "合同名称");
			put("projectCode", "合同编号");
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String, String> applyForTransferTitle = new HashMap<String, String>() {
		{
			put("startDate", "申请调岗时间");
			put("endDate", "实际调岗时间");
			put("parentId", "转调部门");
		}
	};
	
	/**
	 * 派驻申请流程title
	 */
	@SuppressWarnings("serial")
	public static Map<String, String> inTitle = new HashMap<String, String>() {
		{
			put("startDate", "驻场开始日期");
			put("startDateDetail", "驻场开始时段");
			put("endDate", "驻场结束日期");
			put("endDateDetail", "驻场结束时段");
			put("nextAuditor", "项目经理");
			put("contactPerson", "派驻项目甲方名称");
			put("fee", "预计费用（元）");
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String, String> employeeRepaymentTitle = new HashMap<String, String>() {
		{
			put("startDate", "实际还款日期");
			put("fee", "还款金额");
			put("projectId", "收款方");
			put("projectName", "收款银行");
			put("projectCode", "收款账号");
			put("parentId", "付款人");
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String, String> recevieUnitRepaymentTitle = new HashMap<String, String>() {
		{
			put("startDate", "实际还款日期");
			put("fee", "还款金额");
			put("projectId", "收款方");
			put("projectName", "收款银行");
			put("projectCode", "收款账号");
			put("parentId", "付款公司");
		}
	};
	
	@SuppressWarnings("serial")
	public static Map<String, String> payrollApplyTitle = new HashMap<String, String>(){
		{
			put("companyProvince", "年份");
			put("targetProvince", "月份");
			put("fee", "发放总金额");
			put("type", "发放类型");
		}
	};
	
	public static void formatGridFieldTitle(ListGrid resultGrid, int processType){
		Map<String, String> fieldTitles = new HashMap<>();
		switch (processType) {
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_13://请假申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_14://非出差申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_15://打卡申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_16://外出申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_17://加班申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_18://项目出差申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_19://出差延期申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_20://出差更改行程申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_21://项目派驻申请
			fieldTitles = inTitle;
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_22://项目派驻申请延期
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_23://项目派驻确认申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_24://入职申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_25://离职申请
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_26://转岗申请
			fieldTitles = applyForTransferTitle;
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_27://确认函申请
			fieldTitles = attachmentTitle;
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_28://员工还款申请
			fieldTitles = employeeRepaymentTitle;
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_37://薪资发放申请
			fieldTitles = payrollApplyTitle;
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_41://收款单位还款申请
			fieldTitles = recevieUnitRepaymentTitle;
			break;
		default:
			break;
		}
		if(fieldTitles.size() > 0){
			for (String key : fieldTitles.keySet()) {
				if(null != resultGrid.getField(key)){
					resultGrid.getField(key).setTitle(fieldTitles.get(key));
				}
			}
		}
	}
}
