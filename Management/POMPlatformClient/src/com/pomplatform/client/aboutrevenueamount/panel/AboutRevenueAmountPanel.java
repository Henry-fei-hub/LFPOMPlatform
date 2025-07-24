package com.pomplatform.client.aboutrevenueamount.panel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.aboutrevenueamount.datasource.DSAboutRevenueAmount;
import com.pomplatform.client.aboutrevenueamount.form.AboutRevenueAmountSearchForm;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class AboutRevenueAmountPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AboutRevenueAmountPanel cm = new AboutRevenueAmountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AboutRevenueAmount";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid = new DelicacyListGrid();
		ListGridField[] fieldss = new ListGridField[4];
		int idxs = 0;
		fieldss[idxs] = new ListGridField("contractId");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setShowGridSummary(false);
		fieldss[idxs].setHidden(true);
		idxs ++;
		fieldss[idxs] = new ListGridField("revenueCapitalsId");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setShowGridSummary(false);
		fieldss[idxs].setHidden(true);
		idxs ++;
		fieldss[idxs] = new ListGridField("contractCode");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("20%");
		idxs ++;
		fieldss[idxs] = new ListGridField("contractName");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("45%");
		idxs ++;
		fieldss[idxs] = new ListGridField("customerName");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("45%");
		idxs ++;
		fieldss[idxs] = new ListGridField("year");
		fieldss[idxs].setShowGridSummary(false);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("month");
		fieldss[idxs].setShowGridSummary(false);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("capitalAmount");
		fieldss[idxs].setCanEdit(true);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setType(ListGridFieldType.FLOAT);
		fieldss[idxs].setFormat("##,###,###,###,##0.00");
		idxs ++;
		fieldss[idxs] = new ListGridField("revenueAmount");
		fieldss[idxs].setCanEdit(true);
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setType(ListGridFieldType.FLOAT);
		fieldss[idxs].setFormat("##,###,###,###,##0.00");
		idxs ++;
		fieldss[idxs] = new ListGridField("isTrue");
		fieldss[idxs].setWidth("15%");
		fieldss[idxs].setHidden(true);
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("operateEmployeeId");
		fieldss[idxs].setAlign(Alignment.CENTER);
		fieldss[idxs].setWidth("15%");
		Map<String,Object> map=new HashMap<>();
		map.put("status", 0);
		Record[] records=SyncDataUtil.getValueByTableNames("ST_Employee", "find", map);
		LinkedHashMap<Integer, String> linkMap=new LinkedHashMap<>();
		for (Record record : records) {
			Integer employeeId=BaseHelpUtils.getIntValue(record.getAttribute("employeeId"));
			String  employeeName=BaseHelpUtils.getString(record.getAttribute("employeeName"));
			linkMap.put(employeeId, employeeName);
		}
		fieldss[idxs].setValueMap(linkMap);
		//KeyValueManager.loadValueMap("employees", fieldss[idxs]);
		fieldss[idxs].setShowGridSummary(false);
		fieldss[idxs].setCanEdit(false);
		idxs ++;
		fieldss[idxs] = new ListGridField("operateTime");
		fieldss[idxs].setCanEdit(false);
		fieldss[idxs].setWidth("15%");
		//fieldss[idxs].setAutoFitWidth(true);
		resultGrid.setFields(fieldss);
		resultGrid.setDataSource(getDataSource());
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				int rowNum = event.getRowNum();
				Record records=resultGrid.getRecord(rowNum);
				int revenueCapitalsId=BaseHelpUtils.getIntValue(records.getAttribute("revenueCapitalsId"));
				if(revenueCapitalsId<=0) {
					SC.say("获取主键失败");
					return;
				}
				BigDecimal capitalAmount=BaseHelpUtils.getBigDecimalValue(records.getAttribute("capitalAmount"));
				BigDecimal revenueAmount=BaseHelpUtils.getBigDecimalValue(records.getAttribute("revenueAmount"));
				Map<String,Object> params = new HashMap<>();
				params.putAll(records.toMap());
				params.put("revenueCapitalsId", revenueCapitalsId);
				params.put("capitalAmount", capitalAmount);
				params.put("revenueAmount", revenueAmount);
				params.put("operateEmployeeId", ClientUtil.getEmployeeId());
				params.put("operateTime", new Date());
				DBDataSource.callOperation("ST_RevenueCapitals","saveOrUpdate",params,new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0) {
							commonQuery();
						}else {
							SC.say("Failure" + dsResponse.getErrors().get("errorMsg"));
						}
					}
				});	

			}
		});
		__controlPosition = LayoutConstant.RIGHT;
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

		/*resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);*/
		//commonQuery();
	}

	

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		int contractId=BaseHelpUtils.getIntValue(record.getAttribute("contractId"));
		criteria.put("contractId", contractId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new AboutRevenueAmountSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAboutRevenueAmount.getInstance();
	}

	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	public int getSearchFormHeight() {
        return 60;
    }

}

