package com.pomplatform.client.shift.panel;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.shift.datasource.DSOnLoadEmployeeShiftOfShift;
import com.pomplatform.client.shift.form.OnLoadEmployeeShiftOfShiftSearchForm;
import com.pomplatform.client.shift.form.OnLoadEmployeeShiftOfShiftViewer;
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

public class OnLoadEmployeeShiftOfShiftPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadEmployeeShiftOfShiftPanel cm = new OnLoadEmployeeShiftOfShiftPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadEmployeeShiftOfShift";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
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
				showDetail();
			}
		});
		
		IButton shiftButton = new IButton("员工排班");
		controlLayout.addMember(shiftButton);
		shiftButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow popupWindow = new PopupWindow("员工排班");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("80%");
				popupWindow.centerInPage();
				EmployeeShiftPanel panel = new EmployeeShiftPanel();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						commonQuery();
					}
				});
				panel.initComponents();
				popupWindow.addItem(panel);
				panel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
		
		IButton checkButton = new IButton("查看排班");
		controlLayout.addMember(checkButton);
		checkButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				Record record = resultGrid.getSelectedRecord();
				int employeeId = record==null?0:record.getAttributeAsInt("employeeId");
				PopupWindow popupWindow = new PopupWindow("查看员工排班详情");
				popupWindow.setWidth100();
				popupWindow.setHeight100();
				popupWindow.centerInPage();
				OnCheckEmployeeShiftOfShiftPanel panel = new OnCheckEmployeeShiftOfShiftPanel();
				popupWindow.addItem(panel);
				panel.setEmployeeId(employeeId);
				panel.commonQuery();
				popupWindow.centerInPage();
				popupWindow.show();
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
				if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("员工排班"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadEmployeeShiftOfShiftViewer detailForm = new OnLoadEmployeeShiftOfShiftViewer();
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//获取年份和月份
		int year = BaseHelpUtils.getIntValue(criteria.get("year"));
		int month = BaseHelpUtils.getIntValue(criteria.get("month"));
		Date date = new Date();
		if(year ==0){
			DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
			year = BaseHelpUtils.getIntValue(yearDf.format(date));
			criteria.put("year", year);
		}
		if(month == 0){
			DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
			month = BaseHelpUtils.getIntValue(monthDf.format(date));
			criteria.put("month", month);
		}
		return true;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadEmployeeShiftOfShiftSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadEmployeeShiftOfShift.getInstance();
	}


}

