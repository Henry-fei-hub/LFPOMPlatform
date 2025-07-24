package com.pomplatform.client.payment.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyMenuMain;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.LoadingWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.payment.datasource.DSResidualwageData;
import com.pomplatform.client.payment.form.ResidualwageDataSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ResidualwageDataPanel extends AbstractSearchPanel
{

	protected final HandlerManager handlerManager = new HandlerManager(this);
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ResidualwageDataPanel cm = new ResidualwageDataPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ResidualwageData";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		//重构页面
		ListGridField[] fields = new ListGridField[6];
		int index = 0;
		fields[index] = new ListGridField("companyId", "归属公司");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		index++;

		fields[index] = new ListGridField("employeeId", "员工姓名");
		fields[index].setValueMap(KeyValueManager.getValueMap("employees"));
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("employeeNo", "员工编号");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("bankAccount", "银行卡号");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("year", "年份");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("month", "月份");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("factSalary", "实发工资");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("issueMoney", "已发工资");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("balance", "剩余工资");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("ratio", "发放比例");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		fields[index].setCanEdit(true);
		fields[index].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent changedEvent) {
				BigDecimal ratio = BaseHelpUtils.getBigDecimalValue(changedEvent.getValue());
				DynamicForm df = changedEvent.getForm();
				//剩余未发金额
				BigDecimal balance = BaseHelpUtils.getBigDecimalValue(df.getField("balance").getValue());

				//本次发放金额
				BigDecimal thisIssuance = balance.multiply(ratio.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
				//本次剩余金额
				BigDecimal remainingThisTime = balance.subtract(thisIssuance);
				df.getField("thisIssuance").setValue(thisIssuance);
				df.getField("remainingThisTime").setValue(remainingThisTime);
			}
		});
		index++;

		fields[index] = new ListGridField("thisIssuance", "本次发放");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("remainingThisTime", "本次剩余");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		resultGrid.setFields(fields);

		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		//保存数据到员工资金表中
		IButton saveButton = new IButton("保存");
		controlLayout.addMember(saveButton);
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent clickEvent) {
				if (!resultGrid.anySelected()) {
					SC.say("请至少能选择一条数据保存");
				}
				else {
					//获取页面的数据
					List<Map> list = getValues();
					HashMap<String, Object> params = new HashMap<>();
					params.put("optType", "prepaymentSave");
					params.put("list", list);
					DBDataSource.callOperation("EP_EmployeeSalaryType", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								int status = dsResponse.getStatus();
								destroy();
								Record record = new Record();
								record.setAttribute("employeeFundIssuanceId", status);
								DataEditEvent dee = new DataEditEvent();
								dee.setData(record);
								fireEvent(dee);
							}
						}
					});
				}
			}
		});
		commonQuery();
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	@Override
	public void commonQuery() {
		if(!DelicacyMenuMain.checkLogin()) {
			destroy();
			return;
		}
		Map condition = generateCriteria();
		if (condition == null) {
			return;
		}
		if (searchForm != null) {
			searchButton.setIcon("loading38.gif");
		}
		DBDataSource ds = (DBDataSource) getDataSource();
		String operationName = ds.getActionMode() + ds.getActionName();
		final LoadingWindow loading = new LoadingWindow();
		DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				loading.destroy();
				if (searchForm != null) {
					searchButton.setIcon("[SKIN]/actions/search.png");
				}
				if (dsResponse.getStatus() >= 0) {
					Record[] records = dsResponse.getData();
					for (int i = 0; i < records.length; i++) {
						records[i].setAttribute("ratio" , 100);
						BigDecimal balance = BaseHelpUtils.getBigDecimalValue(records[i].getAttribute("balance"));
						records[i].setAttribute("thisIssuance" , balance);
						records[i].setAttribute("remainingThisTime" , 0);
					}
					resultGrid.setData(dsResponse.getData());
					afterDataReceived(dsResponse.getData());
					if (isNeedPagenation() && pager != null) {
						if (currentPage == 1) {
							totalPages = dsResponse.getAttributeAsInt("totalPages");
							pager.getTotalPages().setContents(String.valueOf(totalPages));
						}
					}
				} else {
					SC.say(dsResponse.getErrors().get("errorMsg").toString());
				}
				if (showPagination() && pager != null) {
					pager.getCurrentPage().setContents(String.valueOf(currentPage));
				}
			}
		});
	}

//	public void showDetail() {
//		GWT.runAsync(new RunAsyncCallback() {
//			@Override
//			public void onFailure(Throwable reason) {
//				SC.say("failure to download code");
//			}
//			@Override
//			public void onSuccess() {
//				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
//				GenericViewWindow detail = new GenericViewWindow();
//				detail.setTitle("ResidualwageData");
//				detail.setWidth100();
//				detail.setHeight100();
//				ResidualwageDataViewer detailForm = new ResidualwageDataViewer();
//				detailForm.setParentSearchForm(searchForm);
//				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//				detailForm.initComponents();
//				detailForm.viewSelectedData(resultGrid);
//				detail.setContent(detailForm);
//				detail.centerInPage();
//				detail.show();
//			}
//		});
//	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ResidualwageDataSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSResidualwageData.getInstance();
	}

	/**
	 * @Author: liubin
	 * @Description: 获取选中的数据
	 * @Date: 9:49 2019/4/27
	 */
	public List<Map> getValues() {
		List<Map> list = new ArrayList<>();
		ListGridRecord[] records = resultGrid.getSelectedRecords();
		for (ListGridRecord record : records) {
			list.add(record.toMap());
		}
		return list;
	}

}

