package com.pomplatform.client.payment.panel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.NewProcessWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSOnSalaryBonusTotalData;
import com.pomplatform.client.payment.form.OnSalaryBonusTotalDataSearchForm;
import com.pomplatform.client.payment.form.OnSalaryBonusTotalDataViewer;
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

public class OnSalaryBonusTotalDataPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private OnSalaryBonusTotalDataSearchForm form;
	
	private IButton doReimBtn;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			OnSalaryBonusTotalDataPanel cm = new OnSalaryBonusTotalDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryBonusTotalData";
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

				PopupWindow pw = new PopupWindow();
				OnSalaryPlateBonusByCompanyPanel panel = new OnSalaryPlateBonusByCompanyPanel();
				panel.setCompanyId(companyId);
				panel.setYear(year);
				panel.setMonth(month);
				panel.setPersonnelBusinessId(getPersonnelBusinessId());
				// panel.initComponents();
				panel.commonQuery();
				pw.addItem(panel);
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
		doReimBtn = new IButton("发起日常报销");
		controlLayout.addMember(doReimBtn);
		doReimBtn.hide();
		doReimBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (null == getPersonnelBusinessId() || getPersonnelBusinessId() < 0) {
					SC.say("数据异常");
					return;
				}
				if (resultGrid.anySelected()) {
					Map<String, Object> condition = new HashMap<String, Object>();
					Record record = resultGrid.getSelectedRecord();
					SC.debugger();
					String company = BaseHelpUtils.getString(record.getAttribute("companyId"));
					company = KeyValueManager.getValue("company_records", company);
					int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
					int month = BaseHelpUtils.getIntValue(record.getAttribute("month"));
					//点击发起普通日常报销按钮之前弹出发放类型的页面
					PopupWindow popupWindow = new PopupWindow();
					popupWindow.setTitle(company + year + "年" + month + "月工资奖金");
					popupWindow.setWidth("100%");
					popupWindow.setHeight("100%");
					popupWindow.centerInPage();
					BonusDynamicPagesPanel panel = new BonusDynamicPagesPanel();
					popupWindow.addMember(panel);
					//初始化页面的参数
					record.setAttribute("personnelBusinessId", personnelBusinessId);
					panel.setRecord(record);
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
									if (dsResponse.getStatus() >= 0) {
										int processId = dsResponse.getData()[0].getAttributeAsInt("processId");
										NewProcessWindow distribution = new NewProcessWindow();
										record.setAttribute("personnelBusinessId", getPersonnelBusinessId());
										record.setAttribute("type", 2);
										distribution.setData(record);
										SC.debugger();
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


				} else {
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
				detail.setTitle("奖金总表");
				detail.setWidth100();
				detail.setHeight100();
				OnSalaryBonusTotalDataViewer detailForm = new OnSalaryBonusTotalDataViewer();
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
		__LOGGER.info("getPersonnelBusinessId()==========="+getPersonnelBusinessId());
		if(getPersonnelBusinessId() != null ){
			criteria.put("personnelBusinessId", getPersonnelBusinessId());
		}
		return true;
	} 

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		form = new OnSalaryBonusTotalDataSearchForm();
		return form;
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryBonusTotalData.getInstance();
	}

	public void initPanel(String processName, int year, int month) {
		this.processName = processName;
		if (!BaseHelpUtils.isNullOrEmpty(processName) && processName.contains("报销")) {
			// exportBtn.show();
			 doReimBtn.show();
		}
		form.getField("year").setValue(year);
		form.getField("year").setDefaultValue(year);
		form.getField("year").setDisabled(true);
		form.getField("month").setValue(month);
		form.getField("month").setDefaultValue(month);
		form.getField("month").setDisabled(true);
	}

	private String processName;
	private Integer personnelBusinessId;
	private List<Map> keyvalues;
	
	public List<Map> getKeyvalues() {
		return keyvalues;
	}

	public void setKeyvalues(List<Map> keyvalues) {
		this.keyvalues = keyvalues;
	}

	public Integer getPersonnelBusinessId() {
		return personnelBusinessId;
	}
	
	public void setPersonnelBusinessId(Integer personnelBusinessId){
		this.personnelBusinessId = personnelBusinessId;
	}
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
