package com.pomplatform.client.plateIntegralAccount.panel;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.pomplatform.client.employeeIntegralReturn.datasource.DSEmployeeIntegralReturn;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeIntegralReturnPanel extends AbstractSearchPanel {

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			EmployeeIntegralReturnPanel cm = new EmployeeIntegralReturnPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeIntegralReturn";
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
		
		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] recordList = resultGrid.getRecords();
				int len = recordList.length;
				Record[] records = new Record[len + 1];
				if (len > 0) {
					double achieveIntegral = 0;
					for (int i = 0; i < len; i++) {
						if ("汇总".equals(recordList[i].getAttribute("employeeId"))) {// 如果已经存在汇总，则不可再进行汇总
							return;
						}
						achieveIntegral += ClientUtil
								.checkAndGetDoubleValue(recordList[i].getAttribute("achieveIntegral"));
						records[i] = recordList[i];
					}
					Record record = new Record();
					record.setAttribute("employeeId", "汇总");
					record.setAttribute("achieveIntegral", achieveIntegral);
					records[len] = record;
					resultGrid.setData(records);
					resultGrid.redraw();
					resultGrid.setCanEdit(false);
				}
			}
		});

	}

	@Override
	public void commonQuery() {
		Map condition = generateCriteria();
        if (condition == null) {
            return;
        }
		DBDataSource.callOperation("EP_EmployeeIntegralReturn", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
            	if(dsResponse.getStatus() >= 0){
            		resultGrid.setData(dsResponse.getData());
            	}
            }
		});
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("employeeId", employeeId);
		criteria.put("startDate", startDate);
		criteria.put("endDate", endDate);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeIntegralReturn.getInstance();
	}
	
	@Override
	public void init() {
		super.init();
		__needViewPage = false;
	}
	
	private int employeeId;
	private Date startDate;
	private Date endDate;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
