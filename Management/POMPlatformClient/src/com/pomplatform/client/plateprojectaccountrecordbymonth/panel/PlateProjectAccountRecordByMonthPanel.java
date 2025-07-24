package com.pomplatform.client.plateprojectaccountrecordbymonth.panel;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.plateprojectaccountrecordbymonth.datasource.DSPlateProjectAccountRecordByMonth;
import com.pomplatform.client.plateprojectaccountrecordbymonth.form.PlateProjectAccountRecordByMonthViewer;
import com.pomplatform.client.plateprojectaccountrecordbyproject.panel.PlateProjectAccountRecordByProjectPanel;
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

public class PlateProjectAccountRecordByMonthPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PlateProjectAccountRecordByMonthPanel cm = new PlateProjectAccountRecordByMonthPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateProjectAccountRecordByMonth";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
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
				ListGridRecord[] selected = resultGrid.getSelectedRecords();
				int plateId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("plateId"));
				PlateProjectAccountRecordByProjectPanel panel = new PlateProjectAccountRecordByProjectPanel();
				panel.setPlateId(plateId);
				panel.setRecordYear(ClientUtil.checkAndGetIntValue(selected[0].getAttribute("recordYear")));
				panel.setRecordMonth(ClientUtil.checkAndGetIntValue(selected[0].getAttribute("recordMonth")));
				panel.commonQuery();
				PopupWindow pw = new PopupWindow();
				pw.addItem(panel);
				pw.setTitle("项目结算按月汇总明细");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double accountIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("plateId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						accountIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("accountIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("accountIntegral", accountIntegral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
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
				detail.setTitle("项目结算");
				detail.setWidth100();
				detail.setHeight100();
				PlateProjectAccountRecordByMonthViewer detailForm = new PlateProjectAccountRecordByMonthViewer();
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
		criteria.put("plateId", plateId);
		criteria.put("startDate", startDate);
		criteria.put("endDate", endDate);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new PlateProjectAccountRecordByMonthSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateProjectAccountRecordByMonth.getInstance();
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
