package com.pomplatform.client.workflow.personnel.panel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.workflow.panel.MyAdministrationDesignPanel;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.pomplatform.client.workflow.panel.MyPersonnelFlowDesignPanel;
import com.pomplatform.client.workflow.personnel.datasource.DSMyAuditListOfPersonnel;
import com.pomplatform.client.workflow.personnel.form.MyAuditListOfPersonnelSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MyAuditListOfPersonnelPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private IButton deleteCostButton;
	private IButton newProcessButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MyAuditListOfPersonnelPanel cm = new MyAuditListOfPersonnelPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MyAuditListOfPersonnel";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		newProcessButton = PermissionControl.createPermissionButton("调整薪资", ERPPermissionStatic.MY_PERSONNEL_SALARY_ADJUSTMENT_BUTTON);
		newProcessButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条数据");
							return;
						}
						Record record = resultGrid.getSelectedRecords()[0];
						if(null != record.getAttribute("processType") && record.getAttributeAsInt("processType") == MyPersonnelFlowDesignPanel.PROCESS_TYPE_29){
							NewProcessWindow Reimbursement = new NewProcessWindow();
							Map<String,String> processIdMap = PomPlatformClientUtil.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
							for(String key : processIdMap.keySet()){
								if(key.equals("Salary_adjustment_apply")){
									int processId = ClientUtil.checkAndGetIntValue(processIdMap.get(key));
									Reimbursement.setProcessId(processId);
									Reimbursement.setTitle(KeyValueManager.getValue("employee_processes", processId + ""));
									break;
								}
							}
							Record data = new Record();
							data.setAttribute("employeeId", record.getAttribute("employeeId"));
							Reimbursement.setData(data);
							Reimbursement.initComponents();
							Reimbursement.show();
						}
					}
				});
			}
		});
		controlLayout.addMember(newProcessButton);
		
		deleteCostButton = new IButton("删除成本");
		deleteCostButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条记录后，再执行本操作");
						}else{
					    	Map<Object,Object> param = resultGrid.getSelectedRecords()[0].toMap();
					    	if(param.get("isRemoteCity").toString().equals("false")){
					    		SC.say("该用车申请已删除成本，请不要重复删除");
					    		return;
					    	}
					    	param.put("optType","deleteCarAllocation");
					    	__LOGGER.info(param.toString());
					    	DBDataSource.callOperation("EP_OnWrokflowProcess", "find", param, new DSCallback() {
					            @Override
					            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					                if (dsResponse.getStatus() >= 0) {
					                	SC.say("成本已删除");
					                } else {
					                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
					                }
					            }
					        });
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面");
					}
				});
		    }
		});
		controlLayout.addMember(deleteCostButton);
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				ListGridRecord selected = resultGrid.getSelectedRecord();
                LinkedHashMap<String, String> map = KeyValueManager.getValueMap("processExecutors");
                ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setWidth("80%");
                Reimbursement.setHeight("80%");
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(selected);
                Reimbursement.initComponents();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
                Reimbursement.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new MyAuditListOfPersonnelSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMyAuditListOfPersonnel.getInstance();
	}

	@Override
	public void afterDataReceived(Record[] data) {
		String showFields = "";
		switch (processType) {
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_13://请假申请
			showFields = "statusField, processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, typeField, "
					+ "startDateField, endDateField, daysField, reasonField, remarkField";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 0);
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("leave_types"));
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_14://出差申请
			showFields = "statusField, processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, "
					+ "startDateField, endDateField, daysField, reasonField, remarkField, addressField, planField, transportationField";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 1);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_15://打卡申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField,  startDateField,  typeField,"
					 + "reasonField, remarkField, createTimeField,";
			ClientUtil.formatDateTime(resultGrid, "startDateField", 1);
			resultGrid.getField("startDate").setTitle("漏打卡日期");
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("system_dictionary_74"));
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_16://外出申请
			showFields = "statusField, processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, "
					+ "startDateField, endDateField, daysField, reasonField, remarkField, addressField, planField, transportationField, feeField,"
					+ "unitField, contactPersonField";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 1);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_17://加班申请
			showFields = "statusField, processTypeField, employeeIdField, employeeNoField, departmentIdField, companyIdField, "
					+ "startDateField, endDateField, reasonField, remarkField";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 0);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_18:
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, remarkField,"
					+ "createTimeField, empStatusField, projectNameField, projectCodeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_19:
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, remarkField,"
					+ "createTimeField, empStatusField, projectNameField, projectCodeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_20:
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, remarkField,"
					+ "createTimeField, empStatusField, projectNameField, projectCodeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_23:
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, remarkField,"
					+ "createTimeField, empStatusField, projectNameField, projectCodeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_25://离职申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField,"
					 + "reasonField, createTimeField";
			ClientUtil.formatDateTime(resultGrid, "startDateField", 1);
			resultGrid.getField("startDate").setTitle("入职时间");
			resultGrid.getField("endDate").setTitle("最后工作时间");
			resultGrid.getField("reason").setTitle("离职原因");
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_26:///转岗
			showFields = "employeeIdField, employeeNoField, departmentIdField, parentIdField, startDateField, endDateField,"
					 + "reasonField, remarkField, createTimeField, attachmentField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_27:
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, createTimeField, reasonField, attachmentField, feeField, planField,"
					 + "isRemoteCityField, projectNameField, projectCodeField, remarkField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_29://转正申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, startDateField, endDateField, createTimeField";
			resultGrid.getField("employeeId").setTitle("转正员工");
			resultGrid.getField("startDate").setTitle("入职时间");
			resultGrid.getField("endDate").setTitle("转正时间");
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 1);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_30://调薪申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, typeField, startDateField, createTimeField";
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("system_dictionary_95"));
			resultGrid.getField("type").setTitle("调薪类型");
			resultGrid.getField("startDate").setTitle("调薪日期");
			ClientUtil.formatDateTime(resultGrid, "startDateField", 1);
			break;
		case MyAdministrationDesignPanel.PROCESS_TYPE_31://物品申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, startDateField, reasonField, createTimeField";
			resultGrid.getField("startDate").setTitle("领用日期");
			resultGrid.getField("reason").setTitle("申请缘由");
			ClientUtil.formatDateTime(resultGrid, "startDateField", 1);
			break;
		case MyAdministrationDesignPanel.PROCESS_TYPE_33://用车申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, typeField, unitField, addressField, startDateField, endDateField, projectNameField, projectCodeField, reasonField, createTimeField";
			resultGrid.getField("type").setTitle("用车范围");
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("system_dictionary_104"));
			resultGrid.getField("unit").setTitle("同行人数");
			resultGrid.getField("address").setTitle("申请用车车型");
			resultGrid.getField("startDate").setTitle("用车开始时间");
			resultGrid.getField("endDate").setTitle("用车结束时间");
			resultGrid.getField("projectName").setTitle("出发地");
			resultGrid.getField("projectCode").setTitle("目的地");
			break;
		case MyAdministrationDesignPanel.PROCESS_TYPE_34://名片申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, unitField, planField, cardField, projectCodeField, projectNameField, addressField, reasonField, createTimeField";
			resultGrid.getField("unit").setTitle("英文名");
			resultGrid.getField("plan").setTitle("职位");
			resultGrid.getField("plan").setValueMap(KeyValueManager.getValueMap("duties"));
			resultGrid.getField("card").setTitle("手机号码");
			resultGrid.getField("projectCode").setTitle("座机号码");
			resultGrid.getField("projectName").setTitle("传真机号码");
			resultGrid.getField("address").setTitle("邮箱");
			break;
		case MyAdministrationDesignPanel.PROCESS_TYPE_35://刻章申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, typeField, projectNameField, projectNameField, subTypeField, subTypeStrField, reasonField, createTimeField";
			resultGrid.getField("type").setTitle("印章种类");
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("system_dictionary_107"));
			resultGrid.getField("projectName").setTitle("刻章字样");
			resultGrid.getField("projectCode").setTitle("刻章内容");
			resultGrid.getField("subType").setTitle("印章尺寸");
			resultGrid.getField("subTypeStr").setTitle("印章形状");
			resultGrid.getField("reason").setTitle("申请原因");
			resultGrid.getField("reason").setValueMap(KeyValueManager.getValueMap("system_dictionary_108"));
			break;
		case MyAdministrationDesignPanel.PROCESS_TYPE_36://采购申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, feeField, reasonField, createTimeField";
			resultGrid.getField("fee").setTitle("预计采购费用（元）");
			break;
		case MyAdministrationDesignPanel.PROCESS_TYPE_37://薪资发放申请
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("system_dictionary_127"));
			showFields = "employeeIdField, employeeNoField, departmentIdField, typeField, companyProvinceField, targetProvinceField, feeField";
			break;
		case MyAdministrationDesignPanel.PROCESS_TYPE_40://网络权限
			showFields = "employeeIdField, employeeNoField, departmentIdField, subTypeStrField, reasonField, createTimeField";
			resultGrid.getField("subTypeStr").setTitle("申请的网络权限类型");
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_41://收款单位还款
			showFields = "employeeIdField, employeeNoField, departmentIdField, parentIdField, startDateField, feeField, projectIdField,"
					 + "projectNameField, projectCodeField, createTimeField";
//			resultGrid.getField("parentId").setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
			KeyValueManager.loadValueMap("receive_unit_manages_company",resultGrid.getField("parentId"));
			resultGrid.getField("projectId").setValueMap(KeyValueManager.getValueMap("company_records"));
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_45://工资异常申请
			showFields = "employeeIdField, employeeNoField, departmentIdField,createTimeField,reasonField";
			
			break;
		case MyCostAllocationDesignPanel.PROCESS_TYPE_51://运营流程，订单跨阶段评审流程
			showFields = "employeeIdField, employeeNoField, departmentIdField,planField,reasonField,projectNameField,createTimeField";
			resultGrid.getField("plan").setTitle("确认函编码");
			resultGrid.getField("reason").setTitle("确认函名称");
			break;
		default:
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, remarkField,"
					+ "createTimeField, empStatusField, projectNameField, projectCodeField";
			break;
		}
		PersonnelFieldTitleUtil.formatGridFieldTitle(resultGrid, processType);
		ClientUtil.setShowOrHiddenFields(resultGrid, showFields);
	}
	private int processType;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
		if(processType != MyAdministrationDesignPanel.PROCESS_TYPE_33){
			deleteCostButton.hide();
		}
		if(processType != MyAdministrationDesignPanel.PROCESS_TYPE_37){
			newProcessButton.hide();
		}
	}
	
}

