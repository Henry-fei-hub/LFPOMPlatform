package com.pomplatform.client.project.panel;

import java.math.BigDecimal;
import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.util.ValueCallback;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.project.datasource.DSMprojecttrcccsyyyseyymmymmor;
import com.pomplatform.client.project.form.MprojecttrcccsyyyseyymmymmorSearchForm;
import com.pomplatform.client.project.form.MprojecttrcccsyyyseyymmymmorViewer;
import com.pomplatform.client.projectreportrecorddetail.panel.ProjectEidtPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MprojecttrcccsyyyseyymmymmorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			MprojecttrcccsyyyseyymmymmorPanel cm = new MprojecttrcccsyyyseyymmymmorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Mprojecttrcccsyyyseyymmymmor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
//		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowRowNumbers(true);
		resultGrid.setHeaderHeight(60);  
		resultGrid.setHeaderSpans(new HeaderSpan[] {
				   new HeaderSpan("合同额", new String[] {"sumSheetAmount"}),
				   new HeaderSpan("营收", new String[] {"sumCurrentRevenue","sumCurrentRevenueProportion","targetType1","targetType1Proportion","rank1","percentageComplete1"}),
				   new HeaderSpan("现金流", new String[] {"sumDistributionAmount", "targetType2","percentageComplete2","rank2"})
			    }); 
		
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		

		IButton viewButton = new IButton("指标维护");
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("指标维护");
				StargetrecordbytorPanel editPanel = new StargetrecordbytorPanel();
				popupWindow.addItem(editPanel);
				editPanel.setParentCanvas(popupWindow);
//				editPanel.initComponents();
				popupWindow.setWidth("100%");
				popupWindow.setHeight("100%");
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		controlLayout.addMember(viewButton);
		
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
				detail.setTitle("Mprojecttrcccsyyyseyymmymmor"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				MprojecttrcccsyyyseyymmymmorViewer detailForm = new MprojecttrcccsyyyseyymmymmorViewer();
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
		int year = BaseHelpUtils.getIntValue(criteria, "year");
		int startMonth = BaseHelpUtils.getIntValue(criteria, "startMonth");
		int endMonth = BaseHelpUtils.getIntValue(criteria, "endMonth");
		String yearStr ="2018";
		String monthStartStr="01";
		String monthEndStr="12";
		if(year<=0) {
			SC.say("提示","年份不能为空");
			return false;
		}else {
			yearStr =""+year;
		}
		
		if(startMonth<=0) {
			SC.say("提示","开始月份不能为空");
			return false;
		}else if(startMonth>=1&&startMonth<10) {
			 monthStartStr="0"+startMonth;	
		}else {
			 monthStartStr=""+startMonth;
		}
		
		if(endMonth<=0||endMonth>12) {
			SC.say("提示","结束月份不能为空");
			return false;	
		}else if(endMonth>=1&&endMonth<10) {
			 monthEndStr="0"+endMonth;	
		}else {
			 monthEndStr=""+endMonth;
		}
		
		criteria.put("yearStr", yearStr);
		criteria.put("monthStartStr", monthStartStr);
		criteria.put("monthEndStr", monthEndStr);
		
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new MprojecttrcccsyyyseyymmymmorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSMprojecttrcccsyyyseyymmymmor.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}


}

