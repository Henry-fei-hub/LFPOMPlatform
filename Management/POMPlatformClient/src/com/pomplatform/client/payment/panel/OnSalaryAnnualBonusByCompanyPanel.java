package com.pomplatform.client.payment.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryAnnualBonusByCompany;
import com.pomplatform.client.payment.form.OnSalaryAnnualBonusByCompanySearchForm;
import com.pomplatform.client.payment.form.OnSalaryAnnualBonusByCompanyViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
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

public class OnSalaryAnnualBonusByCompanyPanel extends AbstractSearchPanel {
	
	private String processName;
	private OnSalaryAnnualBonusByCompanySearchForm form;
	private IButton doReimBtn;
	
	private Integer personnelBusinessId;
	private Integer year;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalaryAnnualBonusByCompanyPanel cm = new OnSalaryAnnualBonusByCompanyPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryAnnualBonusByCompany";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int companyId = BaseHelpUtils.getIntValue(record.getAttribute("companyId"));
				// 获取公司名称
				String companyName = KeyValueManager.getValue("company_records", companyId + "");
				// 获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				//获取业务Id
				int personnelBusinessId = BaseHelpUtils.getIntValue(record.getAttribute("personnelBusinessId"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				OnSalaryAnnualBonusByPlatePanelCustom panel = new OnSalaryAnnualBonusByPlatePanelCustom();
				pw.addItem(panel);
				panel.setCompanyId(companyId);
				panel.setYear(year);
				panel.setPersonnelBusinessId(personnelBusinessId);
				panel.commonQuery();
				pw.setTitle("公司(" + companyName + ")下的业务部门汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		doReimBtn = new IButton("发起日常报销");
		controlLayout.addMember(doReimBtn);
		doReimBtn.hide();
		doReimBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Map<String, Object> condition = new HashMap<String, Object>();
					condition.put("processName", "薪资发放普通日常报销");
					DBDataSource.callOperation("ST_SystemProcess", "find", condition, new DSCallback() {
						
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								int processId = dsResponse.getData()[0].getAttributeAsInt("processId");
								NewProcessWindow distribution = new NewProcessWindow();
								Record record = resultGrid.getSelectedRecord();
								record.setAttribute("type", 3);
								distribution.setData(record);
								distribution.setTitle("普通日常报销");
								distribution.setProcessId(processId);
								distribution.setLayoutMode(0);
								distribution.initComponents();
								distribution.show();
							}
							
						}
					});
					
				}else{
					SC.say("请选择一条数据");
				}
				
			}
		});
		controlLayout.addMember(viewButton);
//		commonQuery();
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
				detail.setTitle("年终奖金总表");
				detail.setWidth100();
				detail.setHeight100();
				OnSalaryAnnualBonusByCompanyViewer detailForm = new OnSalaryAnnualBonusByCompanyViewer();
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
	
	public void initPanel(String processName, Integer year, Integer personnelBusinessId) {
		setYear(year);
		setPersonnelBusinessId(personnelBusinessId);
		this.processName = processName;
		if (!BaseHelpUtils.isNullOrEmpty(processName) && processName.contains("报销")) {
			// exportBtn.show();
			 doReimBtn.show();
		}
		form.getField("year").setValue(year);
		form.getField("year").setDefaultValue(year);
		form.getField("year").setDisabled(true);
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(null != getPersonnelBusinessId()){
			criteria.put("personnelBusinessId", getPersonnelBusinessId());
		}
		if(null != getYear()){
			criteria.put("year", getYear());
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new OnSalaryAnnualBonusByCompanySearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryAnnualBonusByCompany.getInstance();
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Integer getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(Integer personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
