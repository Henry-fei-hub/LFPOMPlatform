package com.pomplatform.client.employeereportrecorddetail.panel;

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
import com.pomplatform.client.employeereportrecorddetail.datasource.DSEmployeeViolationChargesMonthly;
import com.pomplatform.client.employeereportrecorddetail.form.EmployeeViolationChargesMonthlySearchForm;
import com.pomplatform.client.employeereportrecorddetail.form.EmployeeViolationChargesMonthlyViewer;
import com.pomplatform.client.plateIntegralAccount.panel.CompanyFeeMonthlyDetailPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class EmployeeViolationChargesMonthlyPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeViolationChargesMonthlyPanel cm = new EmployeeViolationChargesMonthlyPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeViolationChargesMonthly";
		}

	}

	@Override
	public void init(){
		super.init();
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

		int idx = 0;
		ListGridField[] fields = new ListGridField[3];
		fields[idx] = new ListGridField("violationYear");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("violationMonth");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("violationCharges");
		resultGrid.setShowRowNumbers(true);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
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
				Record record = resultGrid.getSelectedRecords()[0];
				PlateGetViolationChargesMonthlyDetailPanel panel = new PlateGetViolationChargesMonthlyDetailPanel();
				panel.setPlateId(plateId);
				panel.setEmployeeId(employeeId);
				panel.setYear(ClientUtil.checkAndGetIntValue(record.getAttribute("violationYear")));
				panel.setMonth(ClientUtil.checkAndGetIntValue(record.getAttribute("violationMonth")));
				panel.commonQuery();
				PopupWindow window = new PopupWindow();
				window.setWidth100();
				window.setHeight100();
				window.addMember(panel);
				window.setTitle("公司每月收取的项目违规金明细");
				window.centerInPage();
				window.show();
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
		if (null != startDate) {
			criteria.put("startDate", startDate);
		}
		if (null != endDate) {
			criteria.put("endDate", endDate);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new EmployeeViolationChargesMonthlySearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeViolationChargesMonthly.getInstance();
	}

	private Integer plateId;
	private Integer employeeId;
	private Date startDate;
	private Date endDate;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}

