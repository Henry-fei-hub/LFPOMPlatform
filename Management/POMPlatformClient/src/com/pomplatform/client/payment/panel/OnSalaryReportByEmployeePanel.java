package com.pomplatform.client.payment.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryReportByEmployee;
import com.pomplatform.client.payment.form.OnSalaryReportByEmployeeSearchForm;
import com.pomplatform.client.payment.form.OnSalaryReportByEmployeeViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class OnSalaryReportByEmployeePanel extends AbstractSearchPanel
{
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryReportByEmployeePanel cm = new OnSalaryReportByEmployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryReportByEmployee";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
	}

	@Override
	public void initComponents() {
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				detail.setTitle("工资明细表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryReportByEmployeeViewer detailForm = new OnSalaryReportByEmployeeViewer();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(companyId >= 0){
			criteria.put("companyId", companyId);
		}
		if(plateId > 0){
			criteria.put("plateId", plateId);
		}
		if(departmentId > 0){
			criteria.put("departmentId", departmentId);
		}
		if(year > 0){
			criteria.put("year", year);
		}
		if(month > 0){
			criteria.put("month", month);
		}
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnSalaryReportByEmployeeSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryReportByEmployee.getInstance();
	}

	private int companyId = -1;
	private int plateId;
	private int departmentId;
	private int year;
	private int month;
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	

}

