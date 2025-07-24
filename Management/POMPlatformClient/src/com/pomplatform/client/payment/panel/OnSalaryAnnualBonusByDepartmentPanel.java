package com.pomplatform.client.payment.panel;

import java.util.Map;

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
import com.pomplatform.client.payment.datasource.DSOnSalaryAnnualBonusByDepartment;
import com.pomplatform.client.payment.form.OnSalaryAnnualBonusByDepartmentViewer;
import com.pomplatform.client.salary.panel.SalaryAnnualbonusPanelByEmployee;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class OnSalaryAnnualBonusByDepartmentPanel extends AbstractSearchPanel
{

	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryAnnualBonusByDepartmentPanel cm = new OnSalaryAnnualBonusByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryAnnualBonusByDepartment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needControl = false;
		__needViewPage = false;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int departmentId = BaseHelpUtils.getIntValue(record.getAttribute("departmentId"));
				//获取部门名称
				String departmentName = KeyValueManager.getValue("departments",departmentId+"");
				//获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				//获取业务Id
				int personnelBusinessId = BaseHelpUtils.getIntValue(record.getAttribute("personnelBusinessId"));
				PopupWindow pw = new PopupWindow();
				SalaryAnnualbonusPanelByEmployee panel = new SalaryAnnualbonusPanelByEmployee();
				pw.addItem(panel);
				panel.setCompanyId(companyId);
				panel.setPlateId(plateId);
				panel.setDepartmentId(departmentId);
				panel.setYear(year);
				panel.setPersonnelBusinessId(personnelBusinessId);
				panel.commonQuery();
				pw.setTitle("归属部门("+departmentName+")下的人员列表汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
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
				detail.setTitle("年终奖金分表"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnSalaryAnnualBonusByDepartmentViewer detailForm = new OnSalaryAnnualBonusByDepartmentViewer();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		criteria.put("personnelBusinessId", personnelBusinessId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryAnnualBonusByDepartment.getInstance();
	}

	private int companyId = -1;
	private int plateId;
	private int year;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(int personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}

}

