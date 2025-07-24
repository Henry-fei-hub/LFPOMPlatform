package com.pomplatform.client.platecostrecord.panel;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.ViewProcessWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.platecostrecord.datasource.DSPlateCostRecord;
import com.pomplatform.client.platecostrecord.form.PlateCostRecordViewer;
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

public class PlateCostRecordPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PlateCostRecordPanel cm = new PlateCostRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PlateCostRecord";
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
					double costIntegral = 0;
					Record[] records = new Record[length + 1];
					for (int i = 0; i < length; i++) {
						records[i] = recordList[i];
						costIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("costIntegral"));
					}
					Record record = new Record();
					record.setAttribute("plateId", "汇总");
					record.setAttribute("costIntegral", costIntegral);
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record selected = resultGrid.getSelectedRecords()[0];
				//如果是报销流转过来的数据，则看报销单的内容
				if(ClientUtil.checkAndGetIntValue(selected.getAttribute("processInstanceId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processId")) > 0 && ClientUtil.checkAndGetIntValue(selected.getAttribute("processType")) > 0){
					ViewProcessWindow Reimbursement = new ViewProcessWindow();
	                Reimbursement.setWidth("80%");
	                Reimbursement.setHeight("80%");
	                Reimbursement.setLayoutMode(0);
	                Reimbursement.setInstanceData(selected);
	                Reimbursement.initComponents();
	                Reimbursement.setTitle(ClientUtil.getProcessTypeName(selected));
	                Reimbursement.show();
				}else{//否则，直接显示成本基本信息
					GenericViewWindow detail = new GenericViewWindow();
					detail.setTitle("运营成本");
					detail.setWidth100();
					detail.setHeight100();
					PlateCostRecordViewer detailForm = new PlateCostRecordViewer();
					detailForm.setParentSearchForm(searchForm);
					detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
					detailForm.initComponents();
					detailForm.viewSelectedData(resultGrid);
					detail.setContent(detailForm);
					detail.centerInPage();
					detail.show();
				}
			}
		});
	}

	@Override
	public void init() {
		super.init();
		__needViewPage = false;
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
		criteria.put("addtionalCondition", "order by plate_cost_record_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		// return new PlateCostRecordSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSPlateCostRecord.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 70;
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
