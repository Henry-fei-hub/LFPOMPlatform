package com.pomplatform.client.salary.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.salary.datasource.DSSalaryAnnualbonus;
import com.pomplatform.client.salary.form.SalaryAnnualbonusSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class SalaryAnnualbonusTaxPanel extends AbstractSearchPanel {
	
	private Integer personnelBusinessId;
	private Integer year;
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SalaryAnnualbonusTaxPanel cm = new SalaryAnnualbonusTaxPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryAnnualbonus";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setCanEdit(false);
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[13];
		int idx = 0;
		fields[idx] = new ListGridField("companyId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeNo");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeName");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("card");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("mobile");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("bankAccount");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("shouldTotal");
		idx++;
		fields[idx] = new ListGridField("alreadyBonus");
		idx++;
		fields[idx] = new ListGridField("shouldTaxAchieve");
		idx++;
		fields[idx] = new ListGridField("shouldTax");
		idx++;
		resultGrid.setFields(fields);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		IButton exportBtn = new IButton("导出");
		controlLayout.addMember(exportBtn);
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_SalaryAnnualbonus", generateCriteria());
				
			}
		});

	}

	public void initSearchData(Integer year, Integer personnelBusinessId){
		setYear(year);
		setPersonnelBusinessId(personnelBusinessId);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(null != getYear()){
			criteria.put("year", getYear());
		}
		if(null != getPersonnelBusinessId()){
			criteria.put("personnelBusinessId", getPersonnelBusinessId());
		}
		criteria.put("addtionalCondition", "order by employee_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SalaryAnnualbonusSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryAnnualbonus.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	public Integer getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(Integer personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
