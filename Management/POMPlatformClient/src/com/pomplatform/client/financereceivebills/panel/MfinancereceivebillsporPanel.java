package com.pomplatform.client.financereceivebills.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.financereceivebills.datasource.DSMfinancereceivebillspor;
import com.pomplatform.client.financereceivebills.form.MfinancereceivebillsporSearchForm;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class MfinancereceivebillsporPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MfinancereceivebillsporPanel cm = new MfinancereceivebillsporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mfinancereceivebillspor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		
		ListGridField [] fields = new ListGridField[10];
		int index = 0;
		fields[index] = new ListGridField("applicant");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("processType");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("code");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("amount");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("updateTime");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("receiveStatus");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("sendee");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("handlePerson");
		fields[index].setCanEdit(true);
		index ++;
		fields[index] = new ListGridField("remark");
		fields[index].setCanEdit(true);
		index ++;
		fields[index] = new ListGridField("detailRemark");
		fields[index].setCanEdit(false);
		index ++;
		fields[index] = new ListGridField("processStatus");
		fields[index].setCanEdit(false);
		
		resultGrid.setFields(fields);
		resultGrid.setCanEdit(true);
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				
				Map params = event.getNewValues();
				params.put("financeReceiveBillId", event.getOldValues().getAttribute("financeReceiveBillId"));
				DBDataSource.callOperation("ST_FinanceReceiveBill", "update", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
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
		IButton addButton = new IButton("收单");
		addButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						PopupWindow pw = new PopupWindow();
						VLayout mainLayout = new VLayout();
						mainLayout.setHeight100();
						mainLayout.setWidth100();
						DynamicForm form = new DynamicForm();
						form.setHeight(65);
						Label label = new Label("");
						label.setWidth("90%");
						label.setHeight(30);
						TextItem textItem = new TextItem("barCode", "扫描入口");
						textItem.addKeyPressHandler(new KeyPressHandler() {
							
							@Override
							public void onKeyPress(KeyPressEvent event) {
								if(event.getKeyName().equals("Enter")){
									if(textItem.getValueAsString().length() == 13){
										label.setContents("");
										Map<String, Object> params = new HashMap<>();
										params.put("opt_type", "getInfoByBarcodeToadd");
										params.put("employeeId", ClientUtil.getEmployeeId());
										params.put("departmentName", KeyValueManager.getValue("departments", ClientUtil.getDepartmentId()+""));
										params.put("barCode", textItem.getValueAsString());
										DBDataSource.callOperation("EP_CustomFinanceReceiveBillProcess", params, new DSCallback() {
											
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() > 0){
													label.setContents("&nbsp;&nbsp;<font size='3px' color = 'red'>收单成功</font>");
													commonQuery();
												}else{
													ClientUtil.displayErrorMessage(dsResponse);
												}
												textItem.clearValue();
												textItem.focusInItem();
											}
										});
									}else{
										SC.say("请扫描正确的报销单");
									}
								}
								
							}
						});
						textItem.setWidth("90%");
						form.setFields(textItem);
						ClientUtil.DynamicFormProcessAccordingToDevice(form);
						mainLayout.addMember(form);
						mainLayout.addMember(label);
						pw.addItem(mainLayout);
						pw.setTitle("录入");
						pw.setWidth(500);
						pw.setHeight(180);
						pw.centerInPage();
						pw.show();
						
					}
					
					@Override
					public void onFailure(Throwable reason) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
		});
		controlLayout.addMember(addButton);
		IButton changeStatusButton = new IButton("处理单据");
		changeStatusButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					GWT.runAsync(new RunAsyncCallback() {
						
						@Override
						public void onSuccess() {
							ListGridField employeeNoField = new ListGridField("employeeNo");
							ListGridField employeeNameField = new ListGridField("employeeName");
							ListGridField departmentIdField = new ListGridField("departmentId");
							Map params = resultGrid.getSelectedRecord().toMap();
							PopupWindow pw = new PopupWindow();
							VLayout mainLayout = new VLayout();
							mainLayout.setHeight100();
							mainLayout.setWidth100();
							DynamicForm form = new DynamicForm();
							form.setHeight(180);
							form.setMargin(10);
							ComboBoxItem toEmployeeIdItem = new ComboBoxItem("toEmployeeId", "接收人");
							SelectItem billStatusItem = new SelectItem("billStatus", "状态");
							billStatusItem.setWidth("*");
							billStatusItem.setRequired(true);
							billStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_130"));
							billStatusItem.addChangedHandler(new ChangedHandler() {
								
								@Override
								public void onChanged(ChangedEvent event) {
									if(null == event.getValue()){
										toEmployeeIdItem.hide();
									}else{
										int billStatus = BaseHelpUtils.getIntValue(event.getValue());
										if(billStatus == 2 || billStatus == 3){
											toEmployeeIdItem.show();
											if(billStatus == 2){
												toEmployeeIdItem.disable();
												toEmployeeIdItem.setValue(params.get("applicant"));
											}
										}else{
											toEmployeeIdItem.hide();
										}
									}
									
								}
							});
							
							
							toEmployeeIdItem.hide();
							toEmployeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
							toEmployeeIdItem.setChangeOnKeypress(false);
							toEmployeeIdItem.setRequired(true);
							toEmployeeIdItem.setWidth("*");
							toEmployeeIdItem.setValueField("employeeId");
							toEmployeeIdItem.setDisplayField("employeeName");
							toEmployeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
							toEmployeeIdItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
							
							form.setFields(billStatusItem, toEmployeeIdItem);
							ClientUtil.DynamicFormProcessAccordingToDevice(form);
							
							HLayout controlLayout = new HLayout();
							controlLayout.setAlign(Alignment.CENTER);
							controlLayout.setAlign(VerticalAlignment.CENTER);
							controlLayout.setPadding(5);
							controlLayout.setMembersMargin(12);
							controlLayout.setWidth("100%");
							controlLayout.setHeight(40);
							IButton confirmBtn = new IButton("确定");
							confirmBtn.addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									if(form.validate()){
										String financeReceiveBillIds = "";
										Record [] records = resultGrid.getSelectedRecords();
										for (int i = 0; i < records.length; i++) {
											if(i != 0){
												financeReceiveBillIds += ",";
											}
											financeReceiveBillIds += records[i].getAttribute("financeReceiveBillId");
										}
										params.put("financeReceiveBillIds", financeReceiveBillIds);
										params.put("employeeId", ClientUtil.getEmployeeId());
										params.put("departmentName", KeyValueManager.getValue("departments", ClientUtil.getDepartmentId()+""));
										params.putAll(form.getValues());
										params.put("opt_type", "changeBillStatus");
										DBDataSource.callOperation("EP_CustomFinanceReceiveBillProcess", params, new DSCallback() {
											
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() > 0){
													commonQuery();
													pw.destroy();
												}else{
													ClientUtil.displayErrorMessage(dsResponse);
												}
												
											}
										});
									}
									
								}
							});
							IButton cancelBtn = new IButton("取消");
							cancelBtn.addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									pw.destroy();
									
								}
							});
							
							
							controlLayout.addMember(confirmBtn);
							controlLayout.addMember(cancelBtn);
							mainLayout.addMember(form);
							mainLayout.addMember(controlLayout);
							pw.addItem(mainLayout);
							pw.setTitle("处理单据");
							pw.setWidth(500);
							pw.setHeight(300);
							pw.centerInPage();
							pw.show();
						}
						
						@Override
						public void onFailure(Throwable reason) {
							// TODO Auto-generated method stub
							
						}
					});
					
				}else{
					SC.say("请选择一条需要处理的单");
				}
				
			}
		});
		controlLayout.addMember(changeStatusButton);
		commonQuery();
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
					SC.say("请选择一条数据");
					return;
				}
				ViewProcessWindow Reimbursement = new ViewProcessWindow();
                Reimbursement.setWidth("80%");
                Reimbursement.setHeight("80%");
                Reimbursement.setLayoutMode(0);
                Reimbursement.setInstanceData(resultGrid.getSelectedRecord());
                Reimbursement.initComponents();
                Reimbursement.setTitle(ClientUtil.getProcessTypeName(resultGrid.getSelectedRecord()));
                Reimbursement.show();
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("Mfinancereceivebillspor");
//				detail.setWidth100();
//				detail.setHeight100();
//				MfinancereceivebillsporViewer detailForm = new MfinancereceivebillsporViewer();
//				detailForm.setParentSearchForm(searchForm);
//				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				detailForm.initComponents();
//				detailForm.viewSelectedData(resultGrid);
//				detail.setContent(detailForm);
//				detail.centerInPage();
//				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by finance_receive_bill_id");
		criteria.put("addtionalCondition", "order by process_instance_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new MfinancereceivebillsporSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMfinancereceivebillspor.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 150;
	}

}
