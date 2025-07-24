package com.pomplatform.client.employee.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employee.datasource.DSResignEmployeeEachMonth;
import com.pomplatform.client.employee.form.ResignEmployeeEachMonthSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ResignEmployeeEachMonthPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ResignEmployeeEachMonthPanel cm = new ResignEmployeeEachMonthPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ResignEmployeeEachMonth";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		ListGridField[] fields = new ListGridField[3];
		int idx = 0;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("year");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("month");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		
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
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map params = generateCriteria();
				DBDataSource.downloadFile("DW_DownloadResignEmployees", params);
			}
		});
		controlLayout.addMember(downloadButton);
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
				PopupWindow window = new PopupWindow(record.getAttribute("year") + "年" + record.getAttribute("month") + "月" + KeyValueManager.getValue("departments", record.getAttribute("departmentId")) + "离职员工明细表");
				window.setWidth100();
				window.setHeight100();
				ResignEmployeeEachMonthDetailPanel panel = new ResignEmployeeEachMonthDetailPanel();
				panel.setDepartmentId(record.getAttribute("departmentId"));
				panel.setYear(record.getAttribute("year"));
				panel.setMonth(record.getAttribute("month"));
				panel.commonQuery();
				window.addMember(panel);
				window.centerInPage();
				window.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("parentId", parentId);
		criteria.put("year", year);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ResignEmployeeEachMonthSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSResignEmployeeEachMonth.getInstance();
	}

	private String parentId;
	private String year;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	
}

