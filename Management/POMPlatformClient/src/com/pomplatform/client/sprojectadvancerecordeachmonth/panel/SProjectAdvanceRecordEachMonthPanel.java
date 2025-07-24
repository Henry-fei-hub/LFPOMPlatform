package com.pomplatform.client.sprojectadvancerecordeachmonth.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.sprojectadvancerecord.panel.SProjectAdvanceRecordPanel;
import com.pomplatform.client.sprojectadvancerecordeachmonth.datasource.DSSProjectAdvanceRecordEachMonth;
import com.pomplatform.client.sprojectadvancerecordeachmonth.form.SProjectAdvanceRecordEachMonthViewer;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SProjectAdvanceRecordEachMonthPanel extends AbstractSearchPanel {

	private static final Logger logger = Logger.getLogger("");
	
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SProjectAdvanceRecordEachMonthPanel cm = new SProjectAdvanceRecordEachMonthPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SProjectAdvanceRecordEachMonth";
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
					if ("汇总".equals(recordList[length - 1].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					double advanceIntegral = 0;
					double leftIntegral = 0;
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						advanceIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("advanceIntegral"));
						leftIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("leftIntegral"));
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("advanceIntegral", advanceIntegral);
					record.setAttribute("leftIntegral", leftIntegral);
					records[length] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});
		resultGrid.setShowRowNumbers(true);

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (resultGrid.anySelected()) {
					Record record = resultGrid.getSelectedRecords()[0];
					SProjectAdvanceRecordPanel panel = new SProjectAdvanceRecordPanel();
					panel.setPlateId(plateId);
					panel.setYear(ClientUtil.checkAndGetIntValue(record.getAttribute("advanceYear")));
					panel.setMonth(ClientUtil.checkAndGetIntValue(record.getAttribute("advanceMonth")));
					panel.commonQuery();
					PopupWindow window = new PopupWindow();
					window.setWidth100();
					window.setHeight100();
					window.addMember(panel);
					window.setTitle("项目补贴明细");
					window.centerInPage();
					window.show();
				}
			}
		});

	}

	@Override
	public void init() {
		super.init();
		__needViewPage = false;
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
				detail.setTitle("部门每月项目补贴汇总");
				detail.setWidth100();
				detail.setHeight100();
				SProjectAdvanceRecordEachMonthViewer detailForm = new SProjectAdvanceRecordEachMonthViewer();
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
		// return new SProjectAdvanceRecordEachMonthSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSProjectAdvanceRecordEachMonth.getInstance();
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
