package com.pomplatform.client.payment.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.payment.datasource.DSOnSalaryEmpBonusByDepartment;
import com.pomplatform.client.payment.form.OnSalaryEmpBonusByDepartmentSearchForm;
import com.pomplatform.client.payment.form.OnSalaryEmpBonusByDepartmentViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OnSalaryEmpBonusByDepartmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryEmpBonusByDepartmentPanel cm = new OnSalaryEmpBonusByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryEmpBonusByDepartment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
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
				detail.setTitle("人员奖金明细"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryEmpBonusByDepartmentViewer detailForm = new OnSalaryEmpBonusByDepartmentViewer();
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
		if(personnelBusinessId > 0){
			criteria.put("personnelBusinessId", personnelBusinessId);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnSalaryEmpBonusByDepartmentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryEmpBonusByDepartment.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	private int companyId = -1;
	private int plateId;
	private int departmentId;
	private int year;
	private int month;
	private int personnelBusinessId;
	
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
	
	public int getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(int personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}
}

