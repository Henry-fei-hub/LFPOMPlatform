package com.pomplatform.client.payment.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
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
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.payment.datasource.DSOnSalaryTotalDataSummarize;
import com.pomplatform.client.payment.form.OnSalaryTotalDataSummarizeSearchForm;
import com.pomplatform.client.payment.form.OnSalaryTotalDataSummarizeViewer;
import com.pomplatform.client.payment.form.OnSalaryTotalDataViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OnSalaryTotalDataSummarizePanel extends AbstractSearchPanel
{


	private Window parentWindow;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnSalaryTotalDataSummarizePanel cm = new OnSalaryTotalDataSummarizePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnSalaryTotalDataSummarize";
		}

	}

	@Override
	public void init(){
		super.init();
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
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
				PopupWindow popupWindow = new PopupWindow("工资汇总详情");
			    popupWindow.setWidth("100%");
                popupWindow.setHeight("100%");
                popupWindow.centerInPage();
                OnSalaryTotalDataPanel2 panel = new OnSalaryTotalDataPanel2();
//                 panel.initComponents();
                panel.setEmployeeId(resultGrid.getSelectedRecord().getAttributeAsInt("employeeId"));
                panel.setYear(resultGrid.getSelectedRecord().getAttributeAsInt("startyear"));
                popupWindow.addItem(panel);
                panel.setParentWindow(popupWindow);
                panel.commonQuery();
                popupWindow.centerInPage();
                popupWindow.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		int startyear = BaseHelpUtils.getIntValue(criteria.get("startyear"));
		criteria.put("endyear", startyear);
		criteria.put("startmonth", 1);
		criteria.put("endmonth", 12);
		if(startyear<=0) {
			SC.say("提示","请选择开始年份");
			return false;
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnSalaryTotalDataSummarizeSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnSalaryTotalDataSummarize.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}



}

