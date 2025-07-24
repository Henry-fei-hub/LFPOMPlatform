package com.pomplatform.client.workflow.personnel.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
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
import com.pomplatform.client.workflow.panel.MyWorkDesignPanel;
import com.pomplatform.client.workflow.personnel.datasource.DSOnLoadRefuseListOfPersonnel;
import com.pomplatform.client.workflow.personnel.form.OnLoadRefuseListOfPersonnelSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OnLoadRefuseListOfPersonnelPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnLoadRefuseListOfPersonnelPanel cm = new OnLoadRefuseListOfPersonnelPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadRefuseListOfPersonnel";
		}

	}

	@Override
	public void init() {
//		super.init();
		resultGrid = new DelicacyListGrid(){
			 @Override
			 protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				 if(BaseHelpUtils.getIntValue(record.getAttribute("processStatus"))==5) {
					 return "font-weight:bold; color:#4fabff;";  
				 }else {
					 return "font-weight:bold; color:#555555;";  
				 }
			 }
		 };
    	resultGrid.setDataSource(getDataSource());
    	resultGrid.setShowRowNumbers(true);
        __layoutMode = LayoutConstant.LEFTRIGHT;
        __detailCanvas = new ArrayList<>();
        __controlPosition = LayoutConstant.RIGHT;
        __needPagenation = true;
        __needControl = true;
        __needViewPage = true;
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		
		resultGrid.setShowRowNumbers(true);
/*		resultGrid.setCellFormatter(new CellFormatter() {
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				SC.debugger();
				String val = null==value ? "":value.toString();
				int processStatus = BaseHelpUtils.getIntValue(record.getAttribute("processStatus"));
				String a="";
				if(processStatus==5&&val!="") {
					 a="<font color ='red'>"+val+"</font>";
				}
				return a;
			}
		});*/
		
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
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);

		IButton delayedFilingBtn = new IButton("申请延期");
		delayedFilingBtn.hide();
		delayedFilingBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					NewProcessWindow newWindow = new NewProcessWindow();
					newWindow.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							// 操作成功
							commonQuery();
						}
					});
					Map<String, String> processIdMap = PomPlatformClientUtil
							.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
					Integer value = ClientUtil
							.checkAndGetIntValue(processIdMap.get("Delay_business_project_trip_apply"));
					newWindow.setData(resultGrid.getSelectedRecord());
					newWindow.setProcessId(value);
					newWindow.setLayoutMode(0);
					newWindow.initComponents();
					newWindow.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
					newWindow.show();
				} else {
					SC.say("请选择一条记录");
				}

			}
		});
		controlLayout.addMember(delayedFilingBtn);
		IButton changeTravelBtn = new IButton("更改行程");
		changeTravelBtn.hide();
		changeTravelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					NewProcessWindow distribution = new NewProcessWindow();
					distribution.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							// 操作成功
							commonQuery();
						}
					});
					Map<String, String> processIdMap = PomPlatformClientUtil
							.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
					Integer value = ClientUtil
							.checkAndGetIntValue(processIdMap.get("Change_travel_business_project_trip_apply"));
					distribution.setData(resultGrid.getSelectedRecord());
					distribution.setProcessId(value);
					distribution.setLayoutMode(0);
					distribution.initComponents();
					distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
					distribution.show();
				} else {
					SC.say("请选择一条记录");
				}

			}
		});
		controlLayout.addMember(changeTravelBtn);
		
		IButton delayAccreditBtn = new IButton("申请延期");
		delayAccreditBtn.hide();
		delayAccreditBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					NewProcessWindow distribution = new NewProcessWindow();
					distribution.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							// 操作成功
							commonQuery();
						}
					});
					Map<String, String> processIdMap = PomPlatformClientUtil
							.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
					Integer value = ClientUtil
							.checkAndGetIntValue(processIdMap.get("Delay_project_accredit_apply"));
					distribution.setData(resultGrid.getSelectedRecord());
					distribution.setProcessId(value);
					distribution.setLayoutMode(0);
					distribution.initComponents();
					distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
					distribution.show();
				} else {
					SC.say("请选择一条记录");
				}

			}
		});
		controlLayout.addMember(delayAccreditBtn);
		
		IButton confirmAccreditBtn = new IButton("申请加班");
		confirmAccreditBtn.hide();
		confirmAccreditBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (resultGrid.anySelected()) {
					NewProcessWindow distribution = new NewProcessWindow();
					distribution.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							// 操作成功
							commonQuery();
						}
					});
					Map<String, String> processIdMap = PomPlatformClientUtil
							.getUserProcessId(PomPlatformClientUtil.PARENT_PROCESS_TYPE_2);
					Integer value = ClientUtil
							.checkAndGetIntValue(processIdMap.get("Confirm_project_accredit_apply"));
					distribution.setData(resultGrid.getSelectedRecord());
					distribution.setProcessId(value);
					distribution.setLayoutMode(0);
					distribution.initComponents();
					distribution.setTitle(KeyValueManager.getValue("employee_processes", String.valueOf(value)));
					distribution.show();
				} else {
					SC.say("请选择一条记录");
				}

			}
		});
		controlLayout.addMember(confirmAccreditBtn);

		IButton canelButton = new IButton("销假");
		canelButton.hide();
		canelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				if (resultGrid.anySelected()) {
					ListGridRecord record = resultGrid.getSelectedRecord();
					int status = record.getAttributeAsInt("processStatus");
					if (status !=3) {
						SC.say("该申请不能取消");
						return ;
					}
				SC.confirm("你确认要销假吗？注意：该操作不可撤回! ", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
								submit(1);
								commonQuery();
						}
					}
				});}
				else {
					SC.say("请选择一条记录");
				}
			}
		});
		controlLayout.addMember(canelButton);

	}


		public void submit(final int approvalment) {
//		if (businessPanel != null) {
//			businessPanel.setCustomerOperation(approvalment);
//		}
		SC.debugger();
		ListGridRecord listGridRecord =	resultGrid.getSelectedRecord();
		Map params = new HashMap();
//		if (selectApprovalment.getValue() != null) {
//			params.put("additionalApprovalment", selectApprovalment.getValue());
//		}
		params.put("approvalment", approvalment);
//		params.put("processComment", approvalComment.getValue());
		boolean needApprovalComment = false;
//		if (activityType == 3) {
//			Map values = businessPanel.getValues();
//			needApprovalComment = businessPanel.isNeedApprovalComment();
//			if (!businessPanel.checkData(values)) {
//				return;
//			}
			params.put("userData", listGridRecord.toMap());
			params.put("optType", "canelHoliday");
			params.put("employeeId", ClientUtil.getUserId());
//		} else if (activityType == 2) {
//			Map values = viewPanel.getValues();
//			params.put("userData", values);
//			needApprovalComment = viewPanel.isNeedApprovalComment();
//		}
//		if (approvalment == 0 && needApprovalComment && null == approvalComment.getValue()) {
//			SC.say("请填写审核意见");
//			return;
//		}
		DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//				if (approvalment == 0 && activityType == 3) {
//					DSCallback callback = businessPanel.getCallback();
//					if (callback != null) {
//						callback.execute(dsResponse, data, dsRequest);
//					}
//				}
				if (dsResponse.getStatus() >= 0) {
					commonQuery();
//					final DataEditEvent evt = new DataEditEvent();
//					if (dsResponse.getData() != null && dsResponse.getData().length > 0) {
//						evt.setData(dsResponse.getData()[0]);
//						//ClientUtil.showWorkFlow(dsResponse.getData()[0]);
//					}
//					fireEvent(evt);
//					destroy();
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
			}
		});
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("please select a record to edit");
					return;
				}
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
		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		kv.put("key", "spia.status =?");
		kv.put("value", "spia.status =? and spia.status in (3,5,7)");
		keyvalues.add(kv);
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues) && keyvalues.size() > 0){
	        criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadRefuseListOfPersonnelSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadRefuseListOfPersonnel.getInstance();
	}

	@Override
	public void afterDataReceived(Record[] data) {
		String showFields = "";
		switch (processType) {
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_13:// 请假申请
			if(this.status == 3){
				controlLayout.getMember(6).show();
			}
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, typeField, startDateField, endDateField"
						+ "daysField, reasonField, remarkField,processStatusField, createTimeField";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 0);
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("leave_types"));
			resultGrid.getField("processStatus").setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_14:// 非项目出差申请
			if(this.status == 3){
				controlLayout.getMember(2).show();
				controlLayout.getMember(3).show();
			}
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField"
					+ "daysField, reasonField, remarkField, addressField, planField, transportationField, createTimeField";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 1);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_15://打卡申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField,  startDateField,  typeField,"
					 + "reasonField, remarkField, createTimeField,";
			ClientUtil.formatDateTime(resultGrid, "startDateField", 1);
			resultGrid.getField("startDate").setTitle("漏打卡日期");
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("system_dictionary_74"));
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_16:// 外出申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField"
					+ "daysField, reasonField, remarkField, addressField, planField, transportationField, feeField, unitField, contactPersonField"
					+ "createTimeField,";
			resultGrid.getField("days").setTitle("小时数");
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 1);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_17:// 加班申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField"
					+ "reasonField, remarkField, createTimeField,";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 0);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_18://项目出差申请
			if(this.status == 3){
				controlLayout.getMember(2).show();
				controlLayout.getMember(3).show();
			}
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField, "
					+ "reasonField, remarkField, addressField, planField, transportationField, projectNameField, projectCodeField, createTimeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_19://项目出差延期
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField"
					+ "daysField, reasonField, remarkField, createTimeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_20://出差更改行程申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField"
					+ "daysField, reasonField, remarkField, addressField, planField, transportationField, createTimeField";
			break;	
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_21://项目派驻申请
			if(this.status == 3){
				controlLayout.getMember(4).show();
				controlLayout.getMember(5).show();
			}
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField, reasonField,"
					+ " remarkField, addressField, planField, transportationField, projectNameField, projectCodeField, createTimeField";
			break;	
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_22://项目派驻申请延期
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField"
					+ "daysField, reasonField, remarkField, createTimeField";
			break;	
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_23://项目确定派驻申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField"
					+ "daysField, reasonField, remarkField, attachmentField, createTimeField";
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
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_27://确认函申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, createTimeField, reasonField, attachmentField, feeField, planField,"
					 + "isRemoteCityField, projectNameField, projectCodeField, remarkField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_28://员工还款
			showFields = "employeeIdField, employeeNoField, departmentIdField, parentIdField, startDateField, feeField, projectIdField,"
					 + "projectNameField, projectCodeField, createTimeField";
			resultGrid.getField("parentId").setValueMap(KeyValueManager.getValueMap("employees"));
			resultGrid.getField("projectId").setValueMap(KeyValueManager.getValueMap("company_records"));
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
			if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_SHOW_TOTAL_FEE)) {
				showFields = "employeeIdField, employeeNoField, departmentIdField, typeField, companyProvinceField, targetProvinceField, feeField";
			} else {
				showFields = "employeeIdField, employeeNoField, departmentIdField, typeField, companyProvinceField, targetProvinceField";
			}
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
		case MyCostAllocationDesignPanel.PROCESS_TYPE_61://运营流程，权限申请流程
			showFields = "employeeIdField, employeeNoField, departmentIdField,companyIdField,startDateField,endDateField,daysField,reasonField";
			resultGrid.getField("reason").setTitle("申请缘由");
			break;
		case MyCostAllocationDesignPanel.PROCESS_TYPE_71://盖章申请流程
			showFields = "employeeIdField, employeeNoField, departmentIdField, startDateField, endDateField, remarkField,"
					+ "createTimeField, empStatusField, projectNameField, projectCodeField";
			break;
		case MyWorkDesignPanel.PROCESS_TYPE_78://我的出图
			showFields = "employeeIdField, employeeNoField, departmentIdField, typeField, projectCodeField, projectNameField, projectTypeField, startDateDetailField, startDateField, createTimeField";
			resultGrid.getField("type").setTitle("出图类型");
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("system_dictionary_239"));
			resultGrid.getField("projectType").setTitle("专业");
			resultGrid.getField("projectType").setValueMap(KeyValueManager.getValueMap("pm_specials"));
			resultGrid.getField("startDateDetail").setTitle("版本");
			resultGrid.getField("startDateDetail").setValueMap(KeyValueManager.getValueMap("system_dictionary_242"));
			ClientUtil.formatDateTime(resultGrid, "startDateField", 1);
			resultGrid.getField("startDate").setTitle("日期");
			break;
		case MyWorkDesignPanel.PROCESS_TYPE_81://配合申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, projectCodeField, projectNameField, projectTypeField, typeField, subTypeField, reasonField, remarkField, startDateField, createTimeField";
			resultGrid.getField("type").setTitle("配合部门");
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("departments"));
			resultGrid.getField("projectType").setTitle("专业");
			resultGrid.getField("projectType").setValueMap(KeyValueManager.getValueMap("pm_specials"));
			resultGrid.getField("subType").setTitle("产值");
			resultGrid.getField("reason").setTitle("配合内容");
			resultGrid.getField("remark").setTitle("申请内容");
			resultGrid.getField("startDate").setTitle("提交时间");
		case MyWorkDesignPanel.PROCESS_TYPE_82://结算申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, projectCodeField, projectNameField, subTypeField, reasonField, startDateField, createTimeField";
			resultGrid.getField("subType").setTitle("产值申请数量");
			resultGrid.getField("reason").setTitle("配合内容");
			resultGrid.getField("startDate").setTitle("配合时间");
			break;
			case MyAdministrationDesignPanel.PROCESS_TYPE_83://物品归还
				showFields = "employeeIdField, employeeNoField, departmentIdField, startDataField, remarkField";
				resultGrid.getField("startData").setTitle("申请时间");
				break;
			case MyCostAllocationDesignPanel.PROCESS_TYPE_84://我的工时
				showFields = "employeeIdField, employeeNoField,companyIdField,departmentIdField, startDateField,remarkField";
				resultGrid.getField("startDate").setTitle("日期");
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
	private int status;

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
		 
		


}
