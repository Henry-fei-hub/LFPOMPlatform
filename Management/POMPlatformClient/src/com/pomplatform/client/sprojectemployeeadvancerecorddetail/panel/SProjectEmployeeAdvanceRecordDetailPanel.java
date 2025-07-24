package com.pomplatform.client.sprojectemployeeadvancerecorddetail.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.sprojectemployeeadvancerecorddetail.datasource.DSSProjectEmployeeAdvanceRecordDetail;
import com.pomplatform.client.sprojectemployeeadvancerecorddetail.form.SProjectEmployeeAdvanceRecordDetailViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class SProjectEmployeeAdvanceRecordDetailPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			SProjectEmployeeAdvanceRecordDetailPanel cm = new SProjectEmployeeAdvanceRecordDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SProjectEmployeeAdvanceRecordDetail";
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
					if ("汇总".equals(recordList[length - 1].getAttribute("projectId"))) {// 如果已经存在汇总，则不可再进行汇总
						return;
					}
					double advancedIntegral = 0;
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						advancedIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("advancedIntegral"));
					}
					Record record = new Record();
					record.setAttribute("projectId", "汇总");
					record.setAttribute("advancedIntegral", advancedIntegral);
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
				detail.setTitle("员工每月补贴记录明细");
				detail.setWidth100();
				detail.setHeight100();
				SProjectEmployeeAdvanceRecordDetailViewer detailForm = new SProjectEmployeeAdvanceRecordDetailViewer();
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
		criteria.put("employeeId", employeeId);
		if (null != advanceYear && null != advanceMonth) {
			criteria.put("advanceYear", advanceYear);
			criteria.put("advanceMonth", advanceMonth);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new SProjectEmployeeAdvanceRecordDetailSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSProjectEmployeeAdvanceRecordDetail.getInstance();
	}

	@Override
	public void init() {
		super.init();
		__needViewPage = false;
	}

	private int employeeId;
	private Integer advanceYear;
	private Integer advanceMonth;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getAdvanceYear() {
		return advanceYear;
	}

	public void setAdvanceYear(Integer advanceYear) {
		this.advanceYear = advanceYear;
	}

	public Integer getAdvanceMonth() {
		return advanceMonth;
	}

	public void setAdvanceMonth(Integer advanceMonth) {
		this.advanceMonth = advanceMonth;
	}

}
