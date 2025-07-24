package com.pomplatform.client.revenuecapitalsinfo.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.aboutrevenueamount.panel.AboutRevenueAmountPanel;
import com.pomplatform.client.revenuecapitalsinfo.datasource.DSRevenueCapitalsInfo;
import com.pomplatform.client.revenuecapitalsinfo.form.RevenueCapitalsInfoSearchForm;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;

public class RevenueCapitalsInfoPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			RevenueCapitalsInfoPanel cm = new RevenueCapitalsInfoPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "RevenueCapitalsInfo";
		}

	}

	@Override
	public void init(){
		super.init();
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("year");
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("contractId");
		fields[index].setShowGridSummary(false);
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("contractCode");
		index++;
		fields[index] = new ListGridField("contractName");
		fields[index].setAutoFitWidth(true);
		index++;
		fields[index] = new ListGridField("customerName");
		fields[index].setAutoFitWidth(true);
		index++;
		fields[index] = new ListGridField("revenueAmountStart");
		index++;
		fields[index] = new ListGridField("capitalAmountStart");
		index++;
		fields[index] = new ListGridField("revenueOneQuarter");
		index++;
		fields[index] = new ListGridField("capitalOneQuarter");
		index++;
		fields[index] = new ListGridField("revenueTwoQuarter");
		index++;
		fields[index] = new ListGridField("capitalTwoQuarter");
		index++;
		fields[index] = new ListGridField("revenueTreeQuarter");
		index++;
		fields[index] = new ListGridField("capitalTreeQuarter");
		index++;
		fields[index] = new ListGridField("revenueFourQuarter");
		index++;
		fields[index] = new ListGridField("capitalFourQuarter");
		index++;
		fields[index] = new ListGridField("revenueAmountEnd");
		index++;
		fields[index] = new ListGridField("capitalAmountEnd");
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setFields(fields);
		resultGrid.setShowGridSummary(true);
		resultGrid.setDataSource(getDataSource());
		resultGrid.setHeaderHeight(50);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
				new HeaderSpan("期初",new String[]{"revenueAmountStart","capitalAmountStart"}),
				new HeaderSpan("第一季度",new String[]{"revenueOneQuarter","capitalOneQuarter"}),
				new HeaderSpan("第二季度",new String[]{"revenueTwoQuarter","capitalTwoQuarter"}),
				new HeaderSpan("第三季度",new String[]{"revenueTreeQuarter","capitalTreeQuarter"}),
				new HeaderSpan("第四季度",new String[]{"revenueFourQuarter","capitalFourQuarter"}),
				new HeaderSpan("期末",new String[]{"revenueAmountEnd","capitalAmountEnd"}),
			    });
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton viewButton = new IButton("查看详细");
		viewButton.hide();
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton reckonButton = new IButton("计算");
		reckonButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("计算回款与营收");
				popupWindow.setWidth("30%");
				popupWindow.setHeight("30%");
				ReckonButtonPanel reckonButtonPanel = new ReckonButtonPanel();
				reckonButtonPanel.initComponents();
				popupWindow.addItem(reckonButtonPanel);
				reckonButtonPanel.addDataEditedHandler(new DataEditedHandler(){
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
					}
				});
				reckonButtonPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		controlLayout.addMember(reckonButton);
		
		IButton exportButton = new IButton("导出报表");
		controlLayout.addMember(exportButton);
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportReckonRevenueCapitals", condition);
			}
		});
		commonQuery();
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
				detail.setTitle("合同下的回款与营收"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				/*RevenueCapitalsInfoViewer detailForm = new RevenueCapitalsInfoViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();*/
				Record records=resultGrid.getSelectedRecord();
				AboutRevenueAmountPanel panel=new AboutRevenueAmountPanel();
				panel.setRecord(records);
				panel.commonQuery();
				detail.setContent(panel);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(criteria.containsKey("years") && null != criteria.get("years")){
			int year=BaseHelpUtils.getIntValue(criteria.get("years"));
			criteria.put("years", year-1);
			criteria.put("year",year);
		}else {
			Date date=new Date();
			int year=DateUtil.getDisplayYear(date);
			criteria.put("years", year-1);
			criteria.put("year",year);
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new RevenueCapitalsInfoSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSRevenueCapitalsInfo.getInstance();
	}
    
	public int getSearchFormHeight() {
        return 60;
    }

}

