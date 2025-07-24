package com.pomplatform.client.payment.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryReportByDepartment;
import com.pomplatform.client.payment.form.OnSalaryReportByDepartmentViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class OnSalaryReportByDepartmentPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private String processName;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalaryReportByDepartmentPanel cm = new OnSalaryReportByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryReportByDepartment";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		__needViewPage = false;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		// IButton refreshButton = new IButton("刷新");
		// controlLayout.addMember(refreshButton);
		// refreshButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// commonQuery();
		// }
		// });
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int departmentId = BaseHelpUtils.getIntValue(record.getAttribute("departmentId"));
				// 获取归属部门名称
				String departmentName = KeyValueManager.getValue("departments", departmentId + "");
				// 获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				int month = BaseHelpUtils.getIntValue(record.getAttribute("month"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				OnSalaryReportByEmployeePanel panel = new OnSalaryReportByEmployeePanel();
				pw.addItem(panel);
				panel.setCompanyId(companyId);
				panel.setPlateId(plateId);
				panel.setDepartmentId(departmentId);
				panel.setYear(year);
				panel.setMonth(month);
//				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("归属部门(" + departmentName + ")下的人员薪资明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		if(null != getProcessName() && getProcessName().contains("财务经理")){
			resultGrid.setNoDoubleClicks(true);
		}
		// IButton viewButton = new IButton("查看详细");
		// viewButton.addClickHandler(new ClickHandler(){
		// @Override
		// public void onClick(ClickEvent event) {
		// showDetail();
		// }
		// });
		// controlLayout.addMember(viewButton);
		// commonQuery();
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
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("工资归属部门汇总表");
				detail.setWidth100();
				detail.setHeight100();
				OnSalaryReportByDepartmentViewer detailForm = new OnSalaryReportByDepartmentViewer();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if (companyId >= 0) {
			criteria.put("companyId", companyId);
		}
		if (plateId > 0) {
			criteria.put("plateId", plateId);
		}
		if (year > 0) {
			criteria.put("year", year);
		}
		if (month > 0) {
			criteria.put("month", month);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new OnSalaryReportByDepartmentSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryReportByDepartment.getInstance();
	}

	private int companyId = -1;
	private int plateId;
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

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
