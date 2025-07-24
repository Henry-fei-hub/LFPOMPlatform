package com.pomplatform.client.employeedetail.panel;

import java.util.Map;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeedetail.datasource.DSSureIntegralDetail;
import com.pomplatform.client.employeedetail.form.SureIntegralDetailViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SureIntegralDetailPanel extends AbstractSearchPanel
{

	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SureIntegralDetailPanel cm = new SureIntegralDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SureIntegralDetail";
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
                int len = recordList.length;
                Record[] records = new Record[len+1];
                if(len>0){
                	double realAmount = 0;
                	for(int i=0;i<len;i++){
                		if("汇总".equals(recordList[i].getAttribute("employeeId"))){//如果已经存在汇总，则不可再进行汇总
                			return;
                		}
                		realAmount += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("realAmount"));
                		records[i]=recordList[i];
                	}
                	Record record = new Record();
                	record.setAttribute("employeeId", "汇总");
                	record.setAttribute("realAmount", realAmount);
                	records[len] = record;
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("确认积分"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SureIntegralDetailViewer detailForm = new SureIntegralDetailViewer();
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
		criteria.put("settlementYear", settlementYear);
		criteria.put("settlementMonth", settlementMonth);
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new SureIntegralDetailSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSSureIntegralDetail.getInstance();
	}
	
	@Override
	public void init() {
		super.init();
		__needViewPage = false;
	}

	private int employeeId;
	private int settlementYear;
	private int settlementMonth;
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSettlementYear() {
		return settlementYear;
	}

	public void setSettlementYear(int settlementYear) {
		this.settlementYear = settlementYear;
	}

	public int getSettlementMonth() {
		return settlementMonth;
	}

	public void setSettlementMonth(int settlementMonth) {
		this.settlementMonth = settlementMonth;
	}
	
	
}

