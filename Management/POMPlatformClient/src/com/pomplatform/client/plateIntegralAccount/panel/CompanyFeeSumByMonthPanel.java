package com.pomplatform.client.plateIntegralAccount.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.plateIntegralAccount.datasource.DSCompanyFeeSumByMonth;
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

public class CompanyFeeSumByMonthPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			CompanyFeeSumByMonthPanel cm = new CompanyFeeSumByMonthPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CompanyFeeSumByMonth";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
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

		int idx = 0;
		ListGridField[] fields = new ListGridField[3];
		fields[idx] = new ListGridField("sendYear");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("sendMonth");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("sendIntegral");
		resultGrid.setShowRowNumbers(true);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
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
				Record record = resultGrid.getSelectedRecords()[0];
				CompanyFeeMonthlyDetailPanel panel = new CompanyFeeMonthlyDetailPanel();
				panel.setPlateId(plateId);
				panel.setYear(ClientUtil.checkAndGetIntValue(record.getAttribute("sendYear")));
				panel.setMonth(ClientUtil.checkAndGetIntValue(record.getAttribute("sendMonth")));
				panel.commonQuery();
				PopupWindow window = new PopupWindow();
				window.setWidth100();
				window.setHeight100();
				window.addMember(panel);
				window.setTitle("公司费用每月明细");
				window.centerInPage();
				window.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if (null != plateId) {
			criteria.put("plateId", plateId);
		}
		if (null != startDate) {
			criteria.put("startDate", startDate);
		}
		if (null != endDate) {
			criteria.put("endDate", endDate);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSCompanyFeeSumByMonth.getInstance();
	}

	private Integer plateId;
	private Date startDate;
	private Date endDate;

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}

