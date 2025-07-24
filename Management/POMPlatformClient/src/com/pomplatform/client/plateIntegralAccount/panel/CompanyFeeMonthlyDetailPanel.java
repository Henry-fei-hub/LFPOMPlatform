package com.pomplatform.client.plateIntegralAccount.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.plateIntegralAccount.datasource.DSCompanyFeeMonthlyDetail;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CompanyFeeMonthlyDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CompanyFeeMonthlyDetailPanel cm = new CompanyFeeMonthlyDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CompanyFeeMonthlyDetail";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
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
		
		int idx = 0;
		ListGridField[] fields = new ListGridField[6];
		fields[idx] = new ListGridField("fromPlateId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("sendIntegral");
		idx++;
		fields[idx] = new ListGridField("sendDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("operateEmployeeId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("operateTime");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setShowGridSummary(false);
		
		resultGrid.setShowRowNumbers(true);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if (null != plateId) {
			criteria.put("fromPlateId", plateId);
		}
		if (null != year && null != month) {
			criteria.put("sendYear", year);
			criteria.put("sendMonth", month);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSCompanyFeeMonthlyDetail.getInstance();
	}

	private Integer plateId;
	private Integer year;
	private Integer month;

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
}

