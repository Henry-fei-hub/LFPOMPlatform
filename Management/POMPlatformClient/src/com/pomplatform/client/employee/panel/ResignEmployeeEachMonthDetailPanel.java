package com.pomplatform.client.employee.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employee.datasource.DSResignEmployeeEachMonthDetail;
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

public class ResignEmployeeEachMonthDetailPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ResignEmployeeEachMonthDetailPanel cm = new ResignEmployeeEachMonthDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ResignEmployeeEachMonthDetail";
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
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map params = generateCriteria();
				DBDataSource.downloadFile("DW_ResignEmployeeEachMonthDetail", params);
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
				Record selected = resultGrid.getSelectedRecords()[0];
				if(null != selected.getAttribute("processInstanceId")){
					ViewProcessWindow Reimbursement = new ViewProcessWindow();
	                Reimbursement.setWidth("80%");
	                Reimbursement.setHeight("80%");
	                Reimbursement.setLayoutMode(0);
	                selected.setAttribute("backViewName", "薪酬专员");
	                Reimbursement.setInstanceData(selected);
	                Reimbursement.initComponents();
	                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
	                Reimbursement.show();
				}else{
					SC.say("该员工没有走ERP离职流程，无法展示数据");
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
//		return new ResignEmployeeEachMonthDetailSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSResignEmployeeEachMonthDetail.getInstance();
	}

	private String plateId;
	private String departmentId;
	private String year;
	private String month;
	
	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	
}

