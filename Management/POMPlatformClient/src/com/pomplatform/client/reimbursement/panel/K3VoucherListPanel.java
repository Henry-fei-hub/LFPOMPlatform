package com.pomplatform.client.reimbursement.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.k3code.datasource.DSSk3codetpor;
import com.pomplatform.client.reimbursement.datasource.DSK3VoucherList;
import com.pomplatform.client.reimbursement.form.K3VoucherListViewer;
import com.pomplatform.client.reimbursement.form.NewK3VoucherListForm;
import com.pomplatform.client.reimbursement.form.UpdateK3VoucherListForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;


public class K3VoucherListPanel extends AbstractSearchPanel
{

	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			K3VoucherListPanel cm = new K3VoucherListPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "K3VoucherList";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				if (record.getAttributeAsBoolean("locked")) {  //定稿标绿色
                    return "color:#00B736;";  
                } else if (record.getAttributeAsBoolean("needToChange")) {  //需要调整标红色
                    return "color:#F01813;";  
                } else {  
                    return super.getCellCSSText(record, rowNum, colNum);  
                }  
			}
		};
		resultGrid.setDataSource(getDataSource());
    	resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		//员工信息字段
		ListGridField k3CodeIdField = new ListGridField("k3CodeId");
		ListGridField k3CodeField = new ListGridField("k3Code");
		ListGridField k3NameField = new ListGridField("k3Name");
		ComboBoxItem codeItem = new ComboBoxItem("code", "科目代码");
        codeItem.setWidth("*");
        codeItem.setChangeOnKeypress(false);
        codeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        codeItem.setOptionDataSource(DSSk3codetpor.getInstance());
        codeItem.setValueField(k3CodeIdField.getName());
        codeItem.setDisplayField(k3CodeField.getName());
        codeItem.setPickListFields(k3NameField, k3CodeField);
        codeItem.setPickListWidth(600);
		ListGridField[] fields = new ListGridField[10];
		int idx = 0;
		fields[idx] = new ListGridField("code");
		fields[idx].setEditorProperties(codeItem);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("name");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("secondaryCode");
		fields[idx].setEditorProperties(codeItem);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("secondaryName");
		fields[idx].setCanEdit(false);
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("simplifyRemark", "凭证摘要");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("debitSide");
		idx++;
		fields[idx] = new ListGridField("creditSide");
		idx++;
		fields[idx] = new ListGridField("selfBankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("otherBankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("vestingDate");
		fields[idx].setShowGridSummary(false);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				int rowNum = resultGrid.getRowNum(resultGrid.getSelectedRecord());
				resultGrid.startEditing(rowNum);
			}
		});
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				final Record selected = resultGrid.getRecord(event.getRowNum());
				Map params = selected.toMap();
				Map newData = event.getNewValues();
				if(newData.containsKey("code")) {
					params.put("codeId", newData.get("code"));
				}
				if(newData.containsKey("secondaryCode")) {
					params.put("secondaryCodeId", newData.get("secondaryCode"));
				}
				params.remove("code");
				params.remove("secondaryCode");
				params.put("optType", "updateK3VoucherByDoubleClick");
				DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							Record record = dsResponse.getData()[0];
							DBDataSource.copyRecord(record, selected);
							resultGrid.redraw();
						}else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton viewReimbursementButton = new IButton("查看报销单");
		controlLayout.addMember(viewReimbursementButton);
		viewReimbursementButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						Record record = resultGrid.getSelectedRecord();
						if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("processInstanceId"))) {
							SC.say("该记录没有关联流程数据");
							return;
						}
						ViewProcessWindow Reimbursement = new ViewProcessWindow();
		                Reimbursement.setWidth("80%");
		                Reimbursement.setHeight("80%");
		                Reimbursement.setLayoutMode(0);
		                Reimbursement.setInstanceData(record);
		                Reimbursement.initComponents();
		                Reimbursement.setTitle(ClientUtil.getProcessTypeName(record));
		                Reimbursement.show();
					}
				});
			}
		});
		
		IButton operation2Button = new IButton("新建");
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						NewK3VoucherListForm detailForm = new NewK3VoucherListForm();
						Record[] records = resultGrid.getRecords();
						Record record = new Record();
						record.setAttribute("sequenceNumber", records[0].getAttribute("sequenceNumber"));
						record.setAttribute("reimbursementPackageCode", records[0].getAttribute("reimbursementPackageCode"));
						record.setAttribute("companyId", records[0].getAttribute("companyId"));
						record.setAttribute("internalSequenceNumber", records.length);
						if(null != records[0].getAttribute("vestingDate")){
							record.setAttribute("vestingDate", records[0].getAttributeAsDate("vestingDate"));
						}
						detailForm.setRecord(record);
						detailForm.setTitle("新建");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
					}
				});
			}
		});
		IButton operation3Button = new IButton("修改");
		controlLayout.addMember(operation3Button);
		operation3Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				updateMethod();
			}
		});
		
		
		IButton upButton = new IButton("上移");
		controlLayout.addMember(upButton);
		
		IButton downButton = new IButton("下移");
		controlLayout.addMember(downButton);
		
		upButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				upButton.setDisabled(true);
				downButton.setDisabled(true);
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					upButton.setDisabled(false);
					downButton.setDisabled(false);
					return;
				}
				ListGridRecord selectRecord = resultGrid.getSelectedRecords()[0];
				final int index = resultGrid.getRecordIndex(selectRecord);
				if(index == 0){
					SC.say("无法继续上移");
					upButton.setDisabled(false);
					downButton.setDisabled(false);
					return;
				}else{
					Map<String, Object> params = selectRecord.toMap();
					params.put("optType", "moveUp");
					DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								ListGridRecord[] records = resultGrid.getRecords();
								ListGridRecord prevRecord = null;
								int size = records.length;
								for(int i = 0; i < size; i++){
									if(i == (index - 1)){
										prevRecord = records[i];
										records[i] = selectRecord;
									}else if(i == index){
										records[i] = prevRecord;
									}
								}
								resultGrid.setData(records);
								resultGrid.selectRecord(index - 1);
								resultGrid.redraw();
								upButton.setDisabled(false);
								downButton.setDisabled(false);
							}
						}
					});
				}
			}
		});
		
		downButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				upButton.setDisabled(true);
				downButton.setDisabled(true);
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					upButton.setDisabled(false);
					downButton.setDisabled(false);
					return;
				}
				ListGridRecord selectRecord = resultGrid.getSelectedRecords()[0];
				final int index = resultGrid.getRecordIndex(selectRecord);
				ListGridRecord[] records = resultGrid.getRecords();
				int size = records.length;
				if(index == size - 1){
					SC.say("无法继续下移");
					upButton.setDisabled(false);
					downButton.setDisabled(false);
					return;
				}else{
					Map<String, Object> params = selectRecord.toMap();
					params.put("optType", "moveDown");
					DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() < 0) {
								ClientUtil.displayErrorMessage(dsResponse);
							} else {
								ListGridRecord nextRecord = null;
								for(int i = size; i > 0; i--){
									if(i == (index + 2)){
										nextRecord = records[i - 1];
										records[i - 1] = selectRecord;
									}else if(i == (index + 1)){
										records[i - 1] = nextRecord;
									}
								}
								resultGrid.setData(records);
								resultGrid.selectRecord(index + 1);
								resultGrid.redraw();
								upButton.setDisabled(false);
								downButton.setDisabled(false);
							}
						}
					});
				}
			}
		});
		
		IButton removeButton = new IButton("删除");
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				SC.confirm("确定要删除这些凭证吗？", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							Map<String, Object> params = new HashMap<>();
							params.put("optType", "deleteVoucher");
							MapUtils.convertRecordToMap(resultGrid.getDataSource(), resultGrid.getSelectedRecords(), params,
									"voucherList");
							DBDataSource.callOperation("EP_K3VoucherProcess", params, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										ListGridRecord[] records = resultGrid.getSelectedRecords();
										for(ListGridRecord selected : records){
											resultGrid.removeData(selected);
										}
										resultGrid.redraw();
									}
								}
							});
						}
					}
				});
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("K3凭证"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				K3VoucherListViewer detailForm = new K3VoucherListViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("reimbursementPackageCode", code);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new K3VoucherListSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSK3VoucherList.getInstance();
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void updateMethod(){
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}
			@Override
			public void onSuccess() {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
				final ListGridRecord selected1 = resultGrid.getSelectedRecord();
				UpdateK3VoucherListForm detailForm = new UpdateK3VoucherListForm();
				detailForm.setTitle("修改");
				detailForm.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				detailForm.setSearchForm(searchForm);
				detailForm.setRecord(selected1);
				detailForm.setCurrentPage(getCurrentPage());
				detailForm.initComponents();
				detailForm.startEdit();
				detailForm.setWidth100();
				detailForm.setHeight100();
				detailForm.centerInPage();
				detailForm.show();
				setCurrentPage(detailForm.getCurrentPage());
			}
		});
	}
}

