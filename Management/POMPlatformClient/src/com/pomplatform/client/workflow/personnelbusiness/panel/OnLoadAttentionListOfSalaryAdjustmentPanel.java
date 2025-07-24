package com.pomplatform.client.workflow.personnelbusiness.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSOnLoadAttentionListOfSalaryAdjustment;
import com.pomplatform.client.workflow.personnelbusiness.form.OnLoadAttentionListOfSalaryAdjustmentSearchForm;
import com.pomplatform.client.workflow.personnelbusiness.form.OnLoadAttentionListOfSalaryAdjustmentViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OnLoadAttentionListOfSalaryAdjustmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	private IButton agreeButton;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadAttentionListOfSalaryAdjustmentPanel cm = new OnLoadAttentionListOfSalaryAdjustmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadAttentionListOfSalaryAdjustment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setCanEdit(false);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[12];
		int idx = 0;
		fields[idx] = new ListGridField("employeeId");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("employeeNo");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("targetProvince");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("departmentId");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("startDate");
		fields[idx++].setCanEdit(false);
		fields[idx++] = new ListGridField("endDate");
		fields[idx] = new ListGridField("fee");
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("originalPay");
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("severance");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		fields[idx] = new ListGridField("monthPay");
		fields[idx++].setType(ListGridFieldType.FLOAT);
		fields[idx] = new ListGridField("subType");
		fields[idx].setType(ListGridFieldType.FLOAT);
		fields[idx++].setCanEdit(false);
		fields[idx] = new ListGridField("remark");
		fields[idx].setCanEdit(false);
		resultGrid.setFields(fields);
		
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
				if(!resultGrid.anySelected()){
					SC.say("请选择一条数据");
					return;
				}
				Record selected = resultGrid.getSelectedRecords()[0];
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
		controlLayout.addMember(viewButton);
		
		agreeButton = new IButton("已阅");
		agreeButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						ListGridRecord[] records = resultGrid.getSelectedRecords();
						List<Map> list = new ArrayList<>();
						Map<String, Object> params = new HashMap<>();
						params.put("optType", "agreeSalaryAdjustmentAttention");
						for(ListGridRecord record : records){
							Map map = record.toMap();
							map.put("approvalment", 0);
							list.add(map);
						}
						params.put("list", list);
						params.put("operator", ClientUtil.getUserId());
						DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								commonQuery();
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(agreeButton);
		
		IButton showProgressButton = new IButton("查看进度");
		showProgressButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){
							SC.say("请选择一条记录");
							return;
						}
						Map params = new HashMap();
						params.put("processInstanceId", resultGrid.getSelectedRecords()[0].getAttribute("processInstanceId"));
						DBDataSource.callOperation("EP_GetProcessInstance", params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() >= 0) {
									Record[] records = dsResponse.getData();
									if (records.length == 0) {
										return;
									}
									Record record = records[0];
									Record processInstance = record.getAttributeAsRecord("processInstance");
									ClientUtil.showWorkFlow(processInstance);
								} else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
				});
			}
		});
		controlLayout.addMember(showProgressButton);
		
		IButton summaryButton = new IButton("部门汇总");
		summaryButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow("部门调薪汇总");
				window.setWidth100();
				window.setHeight100();
				window.centerInPage();
				PlateSalaryAdjustmentSummaryPanel panel = new PlateSalaryAdjustmentSummaryPanel();
				window.addMember(panel);
				window.show();
			}
		});
		controlLayout.addMember(summaryButton);
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
				detail.setTitle("调薪申请知会"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadAttentionListOfSalaryAdjustmentViewer detailForm = new OnLoadAttentionListOfSalaryAdjustmentViewer();
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
		criteria.put("auditor", ClientUtil.getUserId());
		criteria.put("status", status);
		List<Map> keyvalues = new ArrayList<>();
        if(BaseHelpUtils.isNullOrEmpty(criteria.get("year"))){
        	Map<String, String> kv = new HashMap<>();
        	kv.put("key", "(extract(year from b.end_date))");
        	kv.put("value", "1");
        	keyvalues.add(kv);
        }
        if(BaseHelpUtils.isNullOrEmpty(criteria.get("month"))){
        	Map<String, String> kv = new HashMap<>();
        	kv.put("key", "(extract(month from b.end_date))");
        	kv.put("value", "1");
        	keyvalues.add(kv);
        }
        if(!BaseHelpUtils.isNullOrEmpty(keyvalues)){
        	criteria.put("keyValues", keyvalues);
        }
		criteria.put("addtionalCondition", "order by system_process_attention_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadAttentionListOfSalaryAdjustmentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadAttentionListOfSalaryAdjustment.getInstance();
	}

	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
		if(null != status && status.intValue() == 2){
			agreeButton.hide();
		}else{
			agreeButton.show();
		}
	}
	
}

