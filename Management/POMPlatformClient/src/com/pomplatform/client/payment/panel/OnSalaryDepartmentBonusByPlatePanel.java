package com.pomplatform.client.payment.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.payment.datasource.DSOnSalaryDepartmentBonusByPlate;
import com.pomplatform.client.payment.form.OnSalaryDepartmentBonusByPlateViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class OnSalaryDepartmentBonusByPlatePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryDepartmentBonusByPlatePanel cm = new OnSalaryDepartmentBonusByPlatePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryDepartmentBonusByPlate";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
        __needViewPage = false;
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_BONUS_CHECK_ALL_DATA)){
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
					//获取业务Id
					int personnelBusinessId = BaseHelpUtils.getIntValue(record.getAttribute("personnelBusinessId"));
					PopupWindow pw = new PopupWindow();
					OnSalaryEmpBonusByDepartmentPanel panel = new OnSalaryEmpBonusByDepartmentPanel();
					pw.addItem(panel);
					panel.setCompanyId(companyId);
					panel.setPlateId(plateId);
					panel.setDepartmentId(departmentId);
					panel.setYear(year);
					panel.setMonth(month);
					panel.setPersonnelBusinessId(personnelBusinessId);
					panel.commonQuery();
					pw.setTitle("归属部门(" + departmentName + ")下的人员奖金明细");
					pw.setWidth100();
					pw.setHeight100();
					pw.centerInPage();
					pw.show();				
				}
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
				detail.setTitle("OnSalaryDepartmentBonusByPlate"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryDepartmentBonusByPlateViewer detailForm = new OnSalaryDepartmentBonusByPlateViewer();
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
		if(year > 0){
			criteria.put("year", year);
		}
		if(month > 0){
			criteria.put("month", month);
		}
		if(plateId > 0){
			criteria.put("plateId", plateId);
		}
		if(personnelBusinessId > 0){
			criteria.put("personnelBusinessId", personnelBusinessId);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryDepartmentBonusByPlate.getInstance();
	}
	
	private int companyId=-1;
	private int year;
	private int month;
	private int plateId = -1;
	private int personnelBusinessId;
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public int getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(int personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}
}

