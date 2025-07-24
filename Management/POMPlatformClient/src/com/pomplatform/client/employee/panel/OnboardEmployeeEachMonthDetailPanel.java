package com.pomplatform.client.employee.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.employee.datasource.DSOnboardEmployeeEachMonthDetail;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class OnboardEmployeeEachMonthDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnboardEmployeeEachMonthDetailPanel cm = new OnboardEmployeeEachMonthDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnboardEmployeeEachMonthDetail";
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
		commonQuery();
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
				Record selected = resultGrid.getSelectedRecords()[0];
				if(null != selected.getAttribute("processInstanceId")){
					ViewProcessWindow window = new ViewProcessWindow();
					window.setWidth100();
					window.setHeight100();
					window.setLayoutMode(0);
	                window.setInstanceData(selected);
	                window.initComponents();
	                window.setTitle(ClientUtil.getProcessTypeName(selected));
	                window.show();
				}else{
					SC.say("该员工没有走ERP入职流程，无法展示数据");
				}
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("departmentId", departmentId);
		criteria.put("year", year);
		criteria.put("month", month);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new OnboardEmployeeEachMonthDetailSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnboardEmployeeEachMonthDetail.getInstance();
	}

	private String plateId;
	private String departmentId;
	private int year;
	private int month;
	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	

}

