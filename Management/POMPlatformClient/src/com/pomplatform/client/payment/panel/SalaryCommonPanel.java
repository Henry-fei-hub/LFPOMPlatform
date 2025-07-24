package com.pomplatform.client.payment.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.payment.datasource.DSSalaryCommon;
import com.pomplatform.client.payment.form.SalaryCommonViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
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

public class SalaryCommonPanel extends AbstractSearchPanel {

	private final String layoutGroupStyle = "2px solid #555555;border-top-width:22px;border-radius:5px;";
	private static final Logger __LOGGER = Logger.getLogger("");

	private HashMap<String, Object> map;

	public SalaryCommonPanel() {

	}

	public SalaryCommonPanel(HashMap<String, Object> map) {
		this.map = map;
//		commonQuery();
	}

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SalaryCommonPanel cm = new SalaryCommonPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryCommon";
		}

	}

	@Override
	public void init() {
		super.init();

		__needControl = false;
		__needPagenation = false;
//		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		ListGridField [] fields = new ListGridField[6];
		int index = 0;
		fields[index] = new ListGridField("employeeId", "员工姓名");
		fields[index].setValueMap(KeyValueManager.getValueMap("employees"));
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("employeeNo", "员工编号");
		fields[index].setHidden(false);
		fields[index].setShowGridSummary(false);
		index++;

		fields[index] = new ListGridField("factSalary", "应发合计");
		fields[index].setHidden(false);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("#,###,###,###,###,##0.00");
		fields[index].setShowGridSummary(true);
		index++;

		fields[index] = new ListGridField("fundraisingProjectRate", "发放比例");
		fields[index].setHidden(false);
		fields[index].setCanEdit(true);
		fields[index].setShowGridSummary(false);
		fields[index].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent changedEvent) {
				BigDecimal fundraisingProjectRate = BaseHelpUtils.getBigDecimalValue(changedEvent.getValue());
				DynamicForm df = changedEvent.getForm();
				//应发金额
				BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(df.getField("factSalary").getValue());
				//冲账金额
				BigDecimal amountOfCredit = (factSalary.subtract(factSalary.multiply(fundraisingProjectRate.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP)))).setScale(2, BigDecimal.ROUND_HALF_UP);
				//实发金额
				BigDecimal actualAmount = factSalary.subtract(amountOfCredit);

				df.getField("actualAmount").setValue(actualAmount);
				df.getField("amountOfCredit").setValue(amountOfCredit);
			}
		});
		index++;

		fields[index] = new ListGridField("actualAmount", "实发金额");
		fields[index].setHidden(false);
		fields[index].setCanEdit(false);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("#,###,###,###,###,##0.00");
		fields[index].setShowGridSummary(true);
		index++;

		fields[index] = new ListGridField("amountOfCredit", "冲账金额");
		fields[index].setHidden(false);
		fields[index].setCanEdit(false);
		fields[index].setType(ListGridFieldType.FLOAT);
		fields[index].setFormat("#,###,###,###,###,##0.00");
		fields[index].setShowGridSummary(true);
		index++;

		fields[index] = new ListGridField("personnelBusinessId", "流程主表主键");
		fields[index].setHidden(false);
		fields[index].setCanEdit(false);
		fields[index].setShowGridSummary(true);

		resultGrid.setFields(fields);
		resultGrid.setShowRowNumbers(true);
		this.setIsGroup(true);
		this.setGroupBorderCSS(layoutGroupStyle);
		this.setGroupLabelBackgroundColor("#555555");
		this.setGroupLabelStyleName("layoutGroupTitleStyle");
		resultGrid.setShowGridSummary(true);
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
				detail.setTitle("SalaryCommon");
				detail.setWidth100();
				detail.setHeight100();
				SalaryCommonViewer detailForm = new SalaryCommonViewer();
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
		if (null != map) {
			int year = BaseHelpUtils.getIntValue(map.get("year"));
			int month = BaseHelpUtils.getIntValue(map.get("month"));
			int fundraisingProjectType = BaseHelpUtils.getIntValue(map.get("fundraisingProjectType"));
			int companyId = BaseHelpUtils.getIntValue(map.get("companyId"));
				criteria.put("year" , year);
				criteria.put("month", month);
				criteria.put("companyId", companyId);
				criteria.put("fundraisingProjectType", fundraisingProjectType);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryCommon.getInstance();
	}

	@Override
	public void afterDataReceived(Record[] data) {
		super.afterDataReceived(data);
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
		int fundraisingProjectType = BaseHelpUtils.getIntValue(condition.get("fundraisingProjectType"));
		if (fundraisingProjectType == 0) {
			DBDataSource.callOperation("NQ_NormalSalaryCommon", "find", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
					loading.destroy();
					if (searchForm != null) {
						searchButton.setIcon("[SKIN]/actions/search.png");
					}
					if (dsResponse.getStatus() >= 0) {
						Record [] records = dsResponse.getData();
						for (int i = 0; i < records.length; i++) {
							records[i].setAttribute("fundraisingProjectRate" , 100);
							BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(records[i].getAttribute("factSalary"));
							records[i].setAttribute("actualAmount" , factSalary);
							records[i].setAttribute("amountOfCredit" , 0);
							records[i].setAttribute("personnelBusinessId" , map.get("personnelBusinessId"));
						}
						resultGrid.setData(records);
						afterDataReceived(records);
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
		}else{
			DBDataSource.callOperation(operationName, "find", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					loading.destroy();
					if (searchForm != null) {
						searchButton.setIcon("[SKIN]/actions/search.png");
					}
					if (dsResponse.getStatus() >= 0) {
						Record [] records = dsResponse.getData();
						for (int i = 0; i < records.length; i++) {
							records[i].setAttribute("fundraisingProjectRate" , 100);
							BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(records[i].getAttribute("factSalary"));
							records[i].setAttribute("actualAmount" , factSalary);
							records[i].setAttribute("amountOfCredit" , 0);
							records[i].setAttribute("personnelBusinessId" , map.get("personnelBusinessId"));
						}
						resultGrid.setData(records);
						afterDataReceived(records);
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
	}

	/**
	 * @Author: liubin
	 * @Description : 疯转页面获取数据的方法
	 * @Date: 14:50 2019/4/22
	 */
	public List<Map> getValues() {
		List<Map> list = new ArrayList<>();
		ListGridRecord[] records = resultGrid.getRecords();
		for (ListGridRecord record : records) {
			list.add(record.toMap());
		}
		return list;
	}
}

