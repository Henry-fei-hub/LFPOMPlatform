package com.pomplatform.client.receiveunit.panel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.receiveunit.datasource.DSMprocessbilllistsmmeor;
import com.pomplatform.client.receiveunit.form.MprocessbilllistsmmeorSearchForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ListGridFieldType;
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

public class MprocessbilllistsmmeorPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private MprocessbilllistsmmeorSearchForm form;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MprocessbilllistsmmeorPanel cm = new MprocessbilllistsmmeorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mprocessbilllistsmmeor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
	}
	
	@Override
	public Canvas generateHDataCanvas() {
        resultGrid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
            	if(record.getAttribute("remark").equals("全额付款")){
            		return "color: #ABABAB;";
            	}else{
            		return "color: #5DD031;";
            	}
//        		 if (null  == record.getAttribute("processBillListId") || record.getAttributeAsInt("processType") == 7) {  
//        			 return "color: #ABABAB;";
//                 }else if(record.getAttributeAsInt("processType") != 7){
//                	 return "color: #5DD031;";
//                 }else {  
//                     return super.getCellCSSText(record, rowNum, colNum);  
//                 }  
            }  
        };  
        resultGrid.setDataSource(getDataSource());
        resultGrid.setWidth100();
        resultGrid.setHeight100();
        return resultGrid;
    }
	
	
	@Override
	public void initComponents() {
		
		int index = 0;
		ListGridField [] fields = new ListGridField[4];
//		fields[index] = new ListGridField("payeeName");
//		fields[index].setShowGridSummary(false);
//		index ++;
		fields[index] = new ListGridField("payMoney");
		fields[index].setShowGridSummary(true);
		index ++;
		fields[index] = new ListGridField("balanceAmount");
		index ++;
		fields[index] = new ListGridField("initAmount", "余额");
		fields[index].setFormat("##,###,###,###,##0.00");
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("employeeId");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("completeTime");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("otherName");
		fields[index].setShowGridSummary(false);
		index ++;
		fields[index] = new ListGridField("remark");
		fields[index].setShowGridSummary(false);
		
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
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
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		IButton exportBtn = new IButton("导出");
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map params = generateCriteria();
				DBDataSource.downloadFile("DW_Mprocessbilllistsmmeor", params);
				
			}
		});
		controlLayout.addMember(exportBtn);
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
				ListGridRecord selected = resultGrid.getSelectedRecord();
				if(null == selected.getAttribute("processBillListId") && null == selected.getAttribute("processType")){
					return;
				}
				Map params = selected.toMap();
				params.put("opt_type", "getSystemInstanceData");
				DBDataSource.callOperation("EP_CollectionDistribution", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() > 0){
							Record __record = dsResponse.getData()[0];
							ViewProcessWindow Reimbursement = new ViewProcessWindow();
			                Reimbursement.setWidth("80%");
			                Reimbursement.setHeight("80%");
			                Reimbursement.setLayoutMode(0);
			                Reimbursement.setInstanceData(__record);
			                Reimbursement.initComponents();
			                Reimbursement.setTitle(ClientUtil.getProcessTypeName(__record));
			                Reimbursement.show();
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
						
					}
				});
			}
		});
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		
		if(null == criteria.get("payeeName")){
			SC.say("请从左边数据栏双击选择收款单位");
			return false;
		}
		
		criteria.put("addtionalCondition", "order by process_bill_list_id");
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.RUC_SHOW_ALL)) {

		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.RUC_SHOW_OWN)) {
			criteria.put("employeeId", ClientUtil.getEmployeeId());
		} else {
			criteria.put("employeeId", ClientUtil.getEmployeeId());
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new MprocessbilllistsmmeorSearchForm();
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.RUC_SHOW_ALL)) {

		} else if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.RUC_SHOW_OWN)) {
			form.getField("employeeId").setDefaultValue(ClientUtil.getEmployeeId());
			form.getField("employeeId").setDisabled(true);
		} else {
			form.getField("employeeId").setDefaultValue(ClientUtil.getEmployeeId());
			form.getField("employeeId").setDisabled(true);
		}
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSMprocessbilllistsmmeor.getInstance();
	}


	public MprocessbilllistsmmeorSearchForm getForm() {
		return form;
	}

	public void setForm(MprocessbilllistsmmeorSearchForm form) {
		this.form = form;
	}

}
