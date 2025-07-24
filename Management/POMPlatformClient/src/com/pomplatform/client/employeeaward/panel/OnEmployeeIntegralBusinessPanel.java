package com.pomplatform.client.employeeaward.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.employeeaward.datasource.DSOnEmployeeIntegralBusiness;
import com.pomplatform.client.employeeaward.form.OnEmployeeIntegralBusinessSearchForm;
import com.pomplatform.client.employeeaward.form.OnEmployeeIntegralBusinessViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class OnEmployeeIntegralBusinessPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnEmployeeIntegralBusinessPanel cm = new OnEmployeeIntegralBusinessPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnEmployeeIntegralBusiness";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid = new DelicacyListGrid(){
			@Override
			protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
				
				String fieldName = this.getFieldName(colNum); 
				int status = record.getAttributeAsInt("status");
				if (fieldName.equals("buttonField")) { 
				HLayout recordCanvas = new HLayout(3);  
				recordCanvas.setHeight(18);  
				recordCanvas.setWidth100(); 
				recordCanvas.setMembersMargin(10);
				recordCanvas.setAlign(Alignment.LEFT);
				Label agreed = new Label("已同意");
				Label disagreed = new Label("已拒绝");
				if(status == 1){
					IButton agreeButton = new IButton("同意");  
					agreeButton.setAlign(Alignment.CENTER);
					recordCanvas.addMember(agreeButton); 
					agreeButton.addClickHandler(new ClickHandler() {  
						public void onClick(ClickEvent event) {  
							Map<String,Object> params = new HashMap<>();
							params.put("businessId", record.getAttribute("businessId"));
							params.put("employeeId", record.getAttribute("employeeId"));
							params.put("businessTypeId", record.getAttribute("businessTypeId"));
							params.put("status", 2);
							DBDataSource.callOperation("EP_OnEmpIntegralBusinessProcessor", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										commonQuery();
									}
								}
							});
						}  
					});  
					
					IButton disagreeButton = new IButton("不同意");  
					disagreeButton.setAlign(Alignment.CENTER);  
					recordCanvas.addMember(disagreeButton); 
					disagreeButton.addClickHandler(new ClickHandler() {  
						public void onClick(ClickEvent event) {
							Map<String,Object> params = new HashMap<>();
							params.put("businessId", record.getAttribute("businessId"));
							params.put("employeeId", record.getAttribute("employeeId"));
							params.put("businessTypeId", record.getAttribute("businessTypeId"));
							params.put("status", 3);
							DBDataSource.callOperation("EP_OnEmpIntegralBusinessProcessor", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										commonQuery();
									}
								}
							});
						}  
					});  
				}else if(status == 2){
					recordCanvas.addMember(agreed);
				}else if(status == 3){
					recordCanvas.addMember(disagreed);
				}
				return recordCanvas;
				} else { 
					return null;  
				}  
			}
		};
		
		ListGridField businessTypeIdField = new ListGridField("businessTypeId","业务功能id");
		businessTypeIdField.setHidden(true);
		ListGridField businessTypeNameField = new ListGridField("businessTypeName","业务功能名称");
		ListGridField integralField = new ListGridField("integral","积分");
		integralField.setFormat("#,###,###,###,###,##0.00");
		ListGridField employeeIdField = new ListGridField("employeeId","职员姓名");
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		ListGridField recordDateField = new ListGridField("recordDate","日期");
		ListGridField statusField = new ListGridField("buttonField", "状态");
		ListGridField remarkField = new ListGridField("remark","备注");
		ListGridField businessIdField = new ListGridField("businessId","业务id");
		businessIdField.setHidden(true);
		
		resultGrid.setShowRowNumbers(true);
		resultGrid.setShowRecordComponents(true);          
		resultGrid.setShowRecordComponentsByCell(true);
		resultGrid.setFields(businessTypeIdField,businessTypeNameField,employeeIdField,integralField,recordDateField,remarkField,statusField,businessIdField);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.redraw();
	}

	@Override
	public void initComponents() {
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("OnEmployeeIntegralBusiness"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnEmployeeIntegralBusinessViewer detailForm = new OnEmployeeIntegralBusinessViewer();
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
		criteria.put("addtionalCondition", "order by employee_integral_business_id");
		if(ClientUtil.getEmployeeId() != 0){
			criteria.put("employeeId", ClientUtil.getEmployeeId());
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnEmployeeIntegralBusinessSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnEmployeeIntegralBusiness.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}
}

