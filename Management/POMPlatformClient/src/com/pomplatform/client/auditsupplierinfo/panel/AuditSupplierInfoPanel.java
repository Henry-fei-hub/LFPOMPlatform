package com.pomplatform.client.auditsupplierinfo.panel;

import java.util.ArrayList;
import java.util.Date;

import com.pomplatform.client.onsupplierinfo.form.OnSupplierInfoViewer;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PooledTaskWindow;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.ApprovalmentWindow;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.auditsupplierinfo.datasource.DSAuditSupplierInfo;
import com.pomplatform.client.auditsupplierinfo.form.AuditSupplierInfoSearchForm;
import com.pomplatform.client.auditsupplierinfo.form.AuditSupplierInfoViewer;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AuditSupplierInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private static IButton auditButton;
	private static IButton batchAuditButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AuditSupplierInfoPanel cm = new AuditSupplierInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AuditSupplierInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("supplierId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("supplierName");
		index++;
		fields[index] = new ListGridField("supplierContact");
		index++;
		fields[index] = new ListGridField("supplierPhone");
		index++;
		fields[index] = new ListGridField("supplierEmail");
		index++;
		fields[index] = new ListGridField("teamSize");
		index++;
		fields[index] = new ListGridField("areasExpertise");
		KeyValueManager.loadValueMap("system_dictionary_213", fields[index]);
		index++;
		fields[index] = new ListGridField("fileUrl","附件");
		fields[index].setCanEdit(false);
		fields[index].setLinkText("相关文件下载/预览");
		index++;
		fields[index] = new ListGridField("employeeId");
		KeyValueManager.loadValueMap("employees",fields[index]);
		index++;
		fields[index] = new ListGridField("createTime");
		index++;
		fields[index] = new ListGridField("isUse");
		fields[index].setAlign(Alignment.CENTER);
		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		linkMap.put(0, "无效");
		linkMap.put(1, "有效");
		fields[index].setValueMap(linkMap);
		index++;
		fields[index] = new ListGridField("status");
		KeyValueManager.loadValueMap("system_dictionary_38",fields[index]);
		resultGrid.setAutoFitFieldWidths(true);
		resultGrid.setFields(fields);
		resultGrid.setDataSource(getDataSource());
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
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

		auditButton = new IButton("审批");
		controlLayout.addMember(auditButton);
		auditButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					ListGridRecord selected = resultGrid.getSelectedRecords()[0];
					if(BaseHelpUtils.getIntValue(selected.getAttributeAsObject("typeFlag")) == ClientStaticUtils.ACTIVITY_TYPE_FLAG_POOL) {
						//	任务池审批
						PooledTaskWindow Reimbursement = new PooledTaskWindow();
						Reimbursement.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						Reimbursement.setLayoutMode(0);
						Reimbursement.setInstanceData(selected);
						Reimbursement.setProcessId(ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")));
						Reimbursement.setData(selected);
						Reimbursement.initComponents();
						if(processType == 42){
							Reimbursement.setWidth("50%");
							Reimbursement.setHeight100();
						}
						Reimbursement.centerInPage();
						Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
						Reimbursement.show();
					}else {
						//	普通节点审批
						if(processType == 42){
							Map<String,String> params = new HashMap<>();
							params.putAll(selected.toMap());
							params.put("optType", "checkSimilarPercent");
							DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {

								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										Record record = dsResponse.getData()[0];
										ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
										Reimbursement.addDataEditedHandler(new DataEditedHandler(){
											@Override
											public void onDataEdited(DataEditEvent event) {
												commonQuery();
											}
										});
										if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) != MyCostAllocationDesignPanel.PROCESS_TYPE_42 && ClientUtil.checkAndGetIntValue(selected.getAttribute("activityType")) == 3){
											Reimbursement.setNeedPagination(true);
										}
										Reimbursement.setLayoutMode(0);
										Reimbursement.setInstanceData(selected);
										Reimbursement.setData(selected);
										Reimbursement.initComponents();
										if(BaseHelpUtils.isNullOrEmpty(record)){//如果为空则说明没有相似度大于等于60%的项目存在
											Reimbursement.setWidth("40%");
											Reimbursement.setHeight("98%");
										}else{
											Reimbursement.setWidth("70%");
											Reimbursement.setHeight("98%");
										}
										Reimbursement.centerInPage();
										Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
										Reimbursement.show();
									}
								}
							});
						}else{
							ApprovalmentWindow Reimbursement = new ApprovalmentWindow();
							Reimbursement.addDataEditedHandler(new DataEditedHandler(){
								@Override
								public void onDataEdited(DataEditEvent event) {
									commonQuery();
								}
							});
							if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) != MyCostAllocationDesignPanel.PROCESS_TYPE_42 && ClientUtil.checkAndGetIntValue(selected.getAttribute("activityType")) == 3){
								Reimbursement.setNeedPagination(true);
							}
							Reimbursement.setLayoutMode(0);
							Reimbursement.setInstanceData(selected);
							Reimbursement.setData(selected);
							Reimbursement.initComponents();
							Reimbursement.centerInPage();
							Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
							Reimbursement.show();
						}
					}
				}else{
					SC.say("please select a record to edit");
					return;
				}
			}
		});

		batchAuditButton = new IButton("批量审批");
		batchAuditButton.hide();
		controlLayout.addMember(batchAuditButton);
		batchAuditButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord[] records = resultGrid.getSelection();
				if(null != records && records.length > 0){
					SC.confirm("您确定已经要进行批量操作吗？", new BooleanCallback() {
						@Override
						public void execute(Boolean value) {
							if (value) {
								if(null != records){
									for(ListGridRecord record: records){
										if(ClientUtil.checkAndGetIntValue(record.getAttribute("activityType")) == 3){
											SC.say("对不起，处理节点不支持批量审批");
											return;
										}
										record.setAttribute("resetCostId", record.getAttribute("businessId"));
										final int recordSize = records.length;
										Map params = record.toMap();
										params.put("approvalment", 0);
										params.put("userData", record.toMap());
										String operationName = null;
										if(BaseHelpUtils.getIntValue(record.getAttributeAsObject("typeFlag")) == ClientStaticUtils.ACTIVITY_TYPE_FLAG_POOL) {
											operationName = "EP_WorkFlowPooledTaskProcessor";
										}else {
											operationName = "EP_WorkFlowActivityProcessor";
										}
										DBDataSource.callOperation(operationName, params, new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if (dsResponse.getStatus() >= 0) {
													successSize++;
													if(recordSize == successSize){
														commonQuery();
													}
												}else{
													SC.say(dsResponse.getErrors().get("errorMsg").toString());
													return;
												}
											}
										});
									}
								}
							}
						}
					});
				}else{
					SC.say("please select a record");
					return;
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("供应商详情");
				detail.setWidth100();
				detail.setHeight100();
				OnSupplierInfoViewer detailForm = new OnSupplierInfoViewer();
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
		criteria.put("employeeId", ClientUtil.getUserId());
		criteria.put("processType", processType);
 		List<Map> keyvalues = new ArrayList<>();
		if(status == 1){
			criteria.put("status", status);
		}else {
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "spia.status =?");
			kv.put("value", "spia.status =? and spia.status in (2,3,4,5,6)");
			keyvalues.add(kv);

			Map<String, String> kv3 = new HashMap<>();
			kv3.put("key", "sppt.status =?");
			kv3.put("value", "sppt.status =? and sppt.status in (2,3,4,5,6)");
			keyvalues.add(kv3);
		}
		if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
			criteria.put("keyValues", keyvalues);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new AuditSupplierInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAuditSupplierInfo.getInstance();
	}

	private int successSize = 0;
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
		if(status == 2){//如果是已审核，则隐藏审批按钮
			auditButton.hide();
			batchAuditButton.hide();
		}else{
			resultGrid.setSelectionType(SelectionStyle.SIMPLE);  
			resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		}
		this.status = status;
	}

	@Override
	public int getSearchFormHeight() {
		return 80;
	}


}

