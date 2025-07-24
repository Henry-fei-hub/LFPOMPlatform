package com.pomplatform.client.employeereportrecorddetail.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeereportrecorddetail.datasource.DSPlateGetViolationChargesMonthlyDetail;
import com.pomplatform.client.employeereportrecorddetail.form.PlateGetViolationChargesMonthlyDetailViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class PlateGetViolationChargesMonthlyDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PlateGetViolationChargesMonthlyDetailPanel cm = new PlateGetViolationChargesMonthlyDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateGetViolationChargesMonthlyDetail";
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
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		int idx = 0;
		ListGridField[] fields = new ListGridField[7];
		fields[idx] = new ListGridField("plateId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("employeeId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("violationCharges");
		idx++;
		fields[idx] = new ListGridField("violationDate");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("operator");
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
				detail.setTitle("部门每月项目违规金明细"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				PlateGetViolationChargesMonthlyDetailViewer detailForm = new PlateGetViolationChargesMonthlyDetailViewer();
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
		if (null != plateId) {
			criteria.put("plateId", plateId);
		}
		if (null != employeeId) {
			criteria.put("employeeId", employeeId);
		}
		if (null != year && null != month) {
			criteria.put("year", year);
			criteria.put("month", month);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new PlateGetViolationChargesMonthlyDetailSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateGetViolationChargesMonthlyDetail.getInstance();
	}

	private Integer plateId;
	private Integer employeeId;
	private Integer year;
	private Integer month;

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

