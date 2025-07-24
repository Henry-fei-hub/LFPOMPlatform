package com.pomplatform.client.platesalaryadvancerecord.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.platesalaryadvancerecord.datasource.DSPlateSalaryAdvanceRecord;
import com.pomplatform.client.platesalaryadvancerecord.form.PlateSalaryAdvanceRecordSearchForm;
import com.pomplatform.client.platesalaryadvancerecord.form.PlateSalaryAdvanceRecordViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PlateSalaryAdvanceRecordPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PlateSalaryAdvanceRecordPanel cm = new PlateSalaryAdvanceRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateSalaryAdvanceRecord";
		}

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

		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				if (null != recordList && recordList.length > 0) {
					int length = recordList.length;
					if ("汇总".equals(recordList[length - 1].getAttribute("employeeName"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					double salaryReturn = 0;
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						salaryReturn += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("salaryReturn"));
					}
					Record record = new Record();
					record.setAttribute("employeeName", "汇总");
					record.setAttribute("salaryReturn", salaryReturn);
					records[length] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});
		
		resultGrid.setShowRowNumbers(true);
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
				detail.setTitle("积分补贴");
				detail.setWidth100();
				detail.setHeight100();
				PlateSalaryAdvanceRecordViewer detailForm = new PlateSalaryAdvanceRecordViewer();
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
		if (null != plateId) {
			criteria.put("plateId", plateId);
		}
		if (null != year && null != month) {
			criteria.put("recordYear", year);
			criteria.put("recordMonth", month);
		}
		criteria.put("addtionalCondition", "order by plate_salary_advance_record_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new PlateSalaryAdvanceRecordSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateSalaryAdvanceRecord.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	private Integer plateId;
	private Integer year;
	private Integer month;

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
