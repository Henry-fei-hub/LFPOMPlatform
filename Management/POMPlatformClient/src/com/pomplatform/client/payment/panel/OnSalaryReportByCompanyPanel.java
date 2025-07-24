package com.pomplatform.client.payment.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.payment.datasource.DSOnSalaryReportByCompany;
import com.pomplatform.client.payment.form.OnSalaryReportByCompanySearchForm;
import com.pomplatform.client.payment.form.OnSalaryReportByCompanyViewer;
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

public class OnSalaryReportByCompanyPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private OnSalaryReportByCompanySearchForm form;
	
	private IButton exportBtn;
	
	private IButton doReimBtn;
	
	private String processName;

	private Integer personnelBusinessId;

	public Integer getPersonnelBusinessId() {
		return personnelBusinessId;
	}

	public void setPersonnelBusinessId(Integer personnelBusinessId) {
		this.personnelBusinessId = personnelBusinessId;
	}

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalaryReportByCompanyPanel cm = new OnSalaryReportByCompanyPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryReportByCompany";
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
				int month = BaseHelpUtils.getIntValue(record.getAttribute("month"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				OnSalaryReportByPlatePanelCustom panel = new OnSalaryReportByPlatePanelCustom();
				pw.addItem(panel);
				panel.setCompanyId(companyId);
				panel.setProcessName(getProcessName());
				panel.setYear(year);
				panel.setMonth(month);
//				panel.initComponents();
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
		controlLayout.addMember(viewButton);
		
		exportBtn = new IButton("导出");
		exportBtn.hide();
		exportBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				DBDataSource.downloadFile("DW_OnSalaryReportByCompany", generateCriteria());
			}
		});
		controlLayout.addMember(exportBtn);
		
		doReimBtn = new IButton("发起日常报销");
		controlLayout.addMember(doReimBtn);
		doReimBtn.hide();
		doReimBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					Record selectRecord = resultGrid.getSelectedRecord();
					int year = selectRecord.getAttributeAsInt("year");
					int month = selectRecord.getAttributeAsInt("month");
					String company = selectRecord.getAttributeAsString("companyId");
					company = KeyValueManager.getValue("company_records", company);
					Map<String, Object> condition = new HashMap<String, Object>();
					//点击发起普通日常报销按钮之前弹出发放类型的页面
					PopupWindow popupWindow = new PopupWindow();
					popupWindow.setTitle(company + year + "年" + month + "月工资发放");
					popupWindow.setWidth("100%");
					popupWindow.setHeight("100%");
					popupWindow.centerInPage();
					DynamicPagesPanel panel = new DynamicPagesPanel();
					popupWindow.addMember(panel);
					//初始化页面的参数
					selectRecord.setAttribute("personnelBusinessId", personnelBusinessId);
					panel.setRecord(selectRecord);
					panel.initializationCalculation();
					popupWindow.show();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							popupWindow.close();
							condition.put("processName", "薪资发放普通日常报销");
							DBDataSource.callOperation("ST_SystemProcess", "find", condition, new DSCallback() {

								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0){
										int processId = dsResponse.getData()[0].getAttributeAsInt("processId");
										NewProcessWindow distribution = new NewProcessWindow();
										Record record = resultGrid.getSelectedRecord();
										record.setAttribute("personnelBusinessId", getPersonnelBusinessId());
										record.setAttribute("type", 1);
										distribution.setData(record);
										distribution.setTitle("普通日常报销");
										distribution.setProcessId(processId);
										distribution.setLayoutMode(0);
										distribution.initComponents();
										distribution.show();
									}

								}
							});
						}
					});
				}else{
					SC.say("请选择一条数据");
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("工资总表");
				detail.setWidth100();
				detail.setHeight100();
				OnSalaryReportByCompanyViewer detailForm = new OnSalaryReportByCompanyViewer();
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

	@SuppressWarnings("rawtypes")
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new OnSalaryReportByCompanySearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryReportByCompany.getInstance();
	}
	
	public void initPanel(String processName, int year, int month){
		this.processName = processName;
		if(!BaseHelpUtils.isNullOrEmpty(processName) && processName.contains("报销")){
			exportBtn.show();
			doReimBtn.show();
		}
		form.getField("year").setValue(year);
		form.getField("year").setDefaultValue(year);
		form.getField("year").setDisabled(true);
		form.getField("month").setValue(month);
		form.getField("month").setDefaultValue(month);
		form.getField("month").setDisabled(true);
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
}
