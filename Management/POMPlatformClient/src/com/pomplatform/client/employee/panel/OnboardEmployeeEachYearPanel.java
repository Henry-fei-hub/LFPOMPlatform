package com.pomplatform.client.employee.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.employee.datasource.DSOnboardEmployeeEachYear;
import com.pomplatform.client.employee.form.OnboardEmployeeEachYearSearchForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class OnboardEmployeeEachYearPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnboardEmployeeEachYearPanel cm = new OnboardEmployeeEachYearPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnboardEmployeeEachYear";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
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
		
		IButton downloadButton = new IButton("导出");
		downloadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map params = generateCriteria();
				DBDataSource.downloadFile("DW_DownloadOnboardEmployees", params);
			}
		});
		controlLayout.addMember(downloadButton);
		
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
				Record record = resultGrid.getSelectedRecord();
				PopupWindow popupWindow = new PopupWindow(record.getAttribute("year") + "年" + KeyValueManager.getValue("system_dictionary_1", record.getAttribute("plateId")) + "入职员工统计");
				popupWindow.setWidth100(); 
				popupWindow.setHeight100(); 
				OnboardEmployeeEachMonthPanel detailForm = new OnboardEmployeeEachMonthPanel();
				detailForm.setPlateId(record.getAttribute("plateId"));
				detailForm.setYear(BaseHelpUtils.getIntValue(record.getAttribute("year")));
				detailForm.commonQuery();
				popupWindow.addMember(detailForm);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		List<Map> keyvalues = new ArrayList<>();
		if(BaseHelpUtils.isNullOrEmpty(searchForm.getItem("month").getValue())){
			Map<String, Object> kv = new HashMap<>();
		    kv.put("key", "AND EXTRACT(MONTH FROM e.onboard_date) =");
		    kv.put("value", "AND 1 =");
		    keyvalues.add(kv);
		    criteria.put("keyValues", keyvalues);
		}
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new OnboardEmployeeEachYearSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnboardEmployeeEachYear.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}


}

