package com.pomplatform.client.shift.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.shift.datasource.DSOnCheckEmployeeShiftOfShift;
import com.pomplatform.client.shift.form.OnCheckEmployeeShiftOfShiftSearchForm;
import com.pomplatform.client.shift.form.OnCheckEmployeeShiftOfShiftViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class OnCheckEmployeeShiftOfShiftPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnCheckEmployeeShiftOfShiftPanel cm = new OnCheckEmployeeShiftOfShiftPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnCheckEmployeeShiftOfShift";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		resultGrid.setCanEdit(true);
		int idx = 0;
        ListGridField[] fields = new ListGridField[10];
        fields[idx] = new ListGridField("employeeShiftManageIdField");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("employeeId");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("employeeNo");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("employeeName");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("gender");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("departmentId");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("shiftManageId");
        idx++;
        fields[idx] = new ListGridField("year");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("month");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("recordDate");
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
		
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				DBDataSource.callOperation("ST_EmployeeShiftManage", "update", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							commonQuery();
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
				detail.setTitle("查看班次详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnCheckEmployeeShiftOfShiftViewer detailForm = new OnCheckEmployeeShiftOfShiftViewer();
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(employeeId > 0)criteria.put("employeeId", employeeId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnCheckEmployeeShiftOfShiftSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnCheckEmployeeShiftOfShift.getInstance();
	}

	private int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	

}

