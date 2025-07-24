package com.pomplatform.client.workflow.personnel.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.EditProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.panel.MyAdministrationDesignPanel;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.pomplatform.client.workflow.panel.MyPersonnelFlowDesignPanel;
import com.pomplatform.client.workflow.panel.MyWorkDesignPanel;
import com.pomplatform.client.workflow.personnel.datasource.DSOnLoadApplyListOfPersonnel;
import com.pomplatform.client.workflow.personnel.form.OnLoadApplyListOfPersonnelSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
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

public class OnLoadApplyListOfPersonnelPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private IButton uploadButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadApplyListOfPersonnelPanel cm = new OnLoadApplyListOfPersonnelPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadApplyListOfPersonnel";
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
		
		IButton editButton = new IButton("撤销修改");
		controlLayout.addMember(editButton);
		editButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("please select a record to edit");
							return;
						}
						ListGridRecord selected = resultGrid.getSelectedRecord();
						int processType = BaseHelpUtils.getIntValue(selected.getAttribute("processType"));
						int type = BaseHelpUtils.getIntValue(selected.getAttribute("type"));
						if (processType == 83) {
							SC.say("对不起，该申请不能修改！");
							return;
						}
						int status = selected.getAttributeAsInt("processStatus");
						if (status != 0) {
							SC.say("对不起，该申请不能修改！");
							return;
						}
						EditProcessWindow Reimbursement = new EditProcessWindow();
						Reimbursement.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								DBDataSource.copyRecord(event.getData(), resultGrid.getSelectedRecord());
								resultGrid.redraw();
							}
						});
						Reimbursement.setLayoutMode(0);
						Reimbursement.setProcessId(selected.getAttributeAsInt("processId"));
						Reimbursement.setInstanceData(selected);
						Reimbursement.initComponents();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						Reimbursement.show();
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
					}
				});
				
			}
		});
		
		IButton deleteButton = new IButton("删除", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条记录，再点击删除按钮");
							return;
						}
						SC.confirm("确定要删除这条记录吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									Record record = resultGrid.getSelectedRecords()[0];
									if(null != record.getAttribute("processStatus") && record.getAttribute("processStatus").toString().equals("0")){
										Map<String,Object> map = new HashMap<>();
										map.put("optType", "deletePersonnelBusiness");
										if(null != record.getAttribute("processInstanceId")){
											int processInstanceId = ClientUtil.checkAndGetIntValue(record.getAttribute("processInstanceId"));
											if(processInstanceId > 0){
												map.put("processInstanceId", processInstanceId);
											}else{
												return;
											}
										}else{
											return;
										}
										if(null != record.getAttribute("businessId")){
											int businessId = ClientUtil.checkAndGetIntValue(record.getAttribute("businessId"));
											if(businessId > 0){
												map.put("businessId", businessId);
											}else{
												return;
											}
										}else{
											return;
										}
										DBDataSource.callOperation("EP_DeleteWrokflowProcessor", map, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if (dsResponse.getStatus() < 0) {
													ClientUtil.displayErrorMessage(dsResponse);
												} else {
													commonQuery();
												}
											}
										});
									}else{
										SC.say("抱歉，该记录无法删除！");
										return;
									}
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("请按Ctrl+F5刷新页面再操作");
					}
				});
				
			}
		});
		controlLayout.addMember(deleteButton);
	}

	public void createUploadButton(){
		if(processType == 13){
			IButton uploadButton = new IButton("上传病历证明", new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(!resultGrid.anySelected()){
						SC.say("请选择一条没有病历证明的病假申请上传附件");
					}else{
						final Record record = resultGrid.getSelectedRecords()[0];
						if(record.getAttribute("type").equals("20") && null == record.getAttribute("attachment")){
							new CommonUploadWindow("上传病历证明", false, 100, 2, 1, new UploadCallBack() {
								
								@Override
								public void execute(Map<String, Record> data) {
									Map<String, Object> map = new HashMap<>();
									map.put("employeeId", ClientUtil.getUserId());
									for(String key : data.keySet()) {
										map.put("id", record.getAttribute("personnelBusinessId"));
										map.put("fileId", data.get(key).getAttribute("fileId"));
				                    	map.put("fileUrl", data.get(key).getAttribute("fileUrl"));
				                    	map.put("fileName", data.get(key).getAttribute("fileName"));
				                    	map.put("optType", "saveUploadFileAddress");
				                    	DBDataSource.callOperation("EP_MyPersonnelProcessor", map, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() < 0){
													ClientUtil.displayErrorMessage(dsResponse);
												}else{
													SC.say("病历证明上传成功");
													commonQuery();
												}
											}
										});
									}
								}
							});
						}else{
							SC.say("只有未上传病历证明的病假申请才能上传附件");
						}
					}
				}
			});
			controlLayout.addMember(uploadButton);
		}
		
		if(processType == 25){
			IButton button_1 = new IButton("离职申请书");
			controlLayout.addMember(button_1);
			button_1.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					GWT.runAsync(new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							if(!resultGrid.anySelected()){
								SC.say("请选择一条记录，再打印离职申请书");
							}else{
								Record record = resultGrid.getSelectedRecords()[0];
								int companyId = ClientUtil.checkAndGetIntValue(record.getAttribute("companyId"));
								int employeeId = ClientUtil.checkAndGetIntValue(record.getAttribute("employeeId"));
								int departmentId = ClientUtil.checkAndGetIntValue(record.getAttribute("departmentId"));
								Date endDate = record.getAttributeAsDate("endDate");
								String reason = record.getAttribute("reason");
								PersonnelPrintPanel panel = new PersonnelPrintPanel();
								panel.printWindow3(companyId, employeeId, departmentId, endDate, reason);
							}
						}
						
						@Override
						public void onFailure(Throwable reason) {
							SC.say("请按Ctrl+F5刷新页面");
						}
					});
				}
			});
		}
		if (showControlPanel()) {
            setControlLayoutWidth();
        }
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType",processType);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadApplyListOfPersonnelSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadApplyListOfPersonnel.getInstance();
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		String showFields = "";
		switch (processType) {
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_13://请假申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, typeField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, createTimeField, hoursField, "
					 + "attachmentField, subTypeStrField ";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 0);
			resultGrid.getField("type").setValueMap(KeyValueManager.getValueMap("leave_types"));
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_14://非项目出差申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, addressField, planField, transportationField,  createTimeField";
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
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, addressField, planField, transportationField, feeField, createTimeField,"
					 + "attachmentField ";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 1);
			resultGrid.getField("days").setTitle("小时数");
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_17://加班申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, hoursField,"
					 + "reasonField, remarkField, createTimeField, attachmentField";
			ClientUtil.formatDateTime(resultGrid, "startDateField,endDateField", 0);
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_18://项目出差申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, addressField, planField, transportationField, projectNameField, projectCodeField, createTimeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_19://出差延期申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, createTimeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_20://出差更改行程申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, addressField, planField, transportationField, createTimeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_21://项目派驻申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, addressField, planField, transportationField, createTimeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_22://项目派驻申请延期
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, createTimeField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_23:///项目派驻确认申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, addressField, createTimeField, attachmentField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_26:///转岗
			showFields = "employeeIdField, employeeNoField, departmentIdField, parentIdField, startDateField, endDateField,"
					 + "reasonField, remarkField, createTimeField, attachmentField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_27://确认函申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, createTimeField, reasonField, attachmentField, feeField, planField,"
					 + "isRemoteCityField, projectNameField, projectCodeField, remarkField";
			break;
		case MyPersonnelFlowDesignPanel.PROCESS_TYPE_25://离职申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField,"
					 + "reasonField, createTimeField";
			ClientUtil.formatDateTime(resultGrid, "startDateField", 1);
			resultGrid.getField("startDate").setTitle("入职时间");
			resultGrid.getField("endDate").setTitle("最后工作时间");
			resultGrid.getField("reason").setTitle("离职原因");
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
			resultGrid.getField("address").setValueMap(KeyValueManager.getValueMap("system_dictionary_122"));
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
		case MyAdministrationDesignPanel.PROCESS_TYPE_40:
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
			break;
		case MyWorkDesignPanel.PROCESS_TYPE_82://结算申请
			showFields = "employeeIdField, employeeNoField, departmentIdField, projectCodeField, projectNameField, subTypeField, reasonField, startDateField, createTimeField";
			resultGrid.getField("subType").setTitle("产值申请数量");
			resultGrid.getField("reason").setTitle("配合内容");
			resultGrid.getField("startDate").setTitle("配合时间");
			break;
			case MyAdministrationDesignPanel.PROCESS_TYPE_83://物品归还
				showFields = "employeeIdField, employeeNoField, departmentIdField, startDataField, remarkField";
				break;
			case MyCostAllocationDesignPanel.PROCESS_TYPE_84://我的工时
				showFields = "employeeIdField, employeeNoField,companyIdField,departmentIdField, startDateField,remarkField";
				resultGrid.getField("startDate").setTitle("日期");
				break;
		default:
			showFields = "employeeIdField, employeeNoField, departmentIdField, companyIdField, startDateField, endDateField, daysField,"
					 + "reasonField, remarkField, addressField, planField, transportationField,  createTimeField,  attachmentField";
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
	}

}

