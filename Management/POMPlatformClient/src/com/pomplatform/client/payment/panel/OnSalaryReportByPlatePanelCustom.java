package com.pomplatform.client.payment.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.payment.datasource.DSOnSalaryReportByPlate;
import com.pomplatform.client.payment.form.OnSalaryReportByPlateViewer;
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

public class OnSalaryReportByPlatePanelCustom extends AbstractSearchPanel {
	
	private String processName;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalaryReportByPlatePanelCustom cm = new OnSalaryReportByPlatePanelCustom();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryReportByPlate";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
        __needViewPage = false;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
        IButton printButton = new IButton("打印");
        controlLayout.addMember(printButton);
        printButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map<String,Object> param = new HashMap<>();
                param.put("companyId",companyId);
                param.put("year",year);
                param.put("month",month);
                OnCompanySalaryPanel printHtml = new OnCompanySalaryPanel();
                //获取列表数据集
                Record[] records = resultGrid.getRecords();
                if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                    printHtml.setRecords(records);
                    printHtml.setPrintData(param);
                    Print.it(printHtml.generatePrintHTML());
                }else{
                    SC.say("提示","没有可打印的数据");
                }
            }
        });

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				//检索是否有查看部门下成员的数据权限，如果有，则可点击进入，否则不可点击
				if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.SALARY_TOTAL_CHECK_EXCEPT_EMPLOYEE)) {
					SC.say("提示","您没有查看部门下成员的权限");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				//获取业务部门名称
				String plateName = KeyValueManager.getValue("system_dictionary_1",plateId+"");
				//获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				int month = BaseHelpUtils.getIntValue(record.getAttribute("month"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				OnSalaryReportByDepartmentPanel panel = new OnSalaryReportByDepartmentPanel();
				pw.addItem(panel);
				panel.setCompanyId(companyId);
				panel.setProcessName(getProcessName());
				panel.setPlateId(plateId);
				panel.setYear(year);
				panel.setMonth(month);
//				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("业务部门("+plateName+")下的归属部门汇总");
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("工资分表");
				detail.setWidth100();
				detail.setHeight100();
				OnSalaryReportByPlateViewer detailForm = new OnSalaryReportByPlateViewer();
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
		if(companyId >= 0){
			criteria.put("companyId", companyId);
		}
		if(year > 0){
			criteria.put("year", year);
		}
		if(month > 0){
			criteria.put("month", month);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryReportByPlate.getInstance();
	}

	private int companyId=-1;
	private int year;
	private int month;
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

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
}
