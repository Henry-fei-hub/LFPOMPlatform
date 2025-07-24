package com.pomplatform.client.report.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.report.datasource.DSReportOnEmployeeNumTotal;
import com.pomplatform.client.report.form.ReportOnEmployeeNumTotalSearchForm;
import com.pomplatform.client.report.form.ReportOnEmployeeNumTotalViewer;
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
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;

public class ReportOnEmployeeNumTotalPanel extends AbstractSearchPanel
{

	private static int year;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOnEmployeeNumTotalPanel cm = new ReportOnEmployeeNumTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOnEmployeeNumTotal";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
	}

	@Override
	public void initComponents() {
		
		resultGrid.setHeaderHeight(60);
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("1月", new String[] {"oneBeforNum","oneAfterNum","oneAverageNum"}),
		   new HeaderSpan("2月", new String[] {"twoBeforNum","twoAfterNum","twoAverageNum"}),
		   new HeaderSpan("3月", new String[] {"threeBeforNum","threeAfterNum","threeAverageNum"}),
		   new HeaderSpan("4月", new String[] {"fourBeforNum","fourAfterNum","fourAverageNum"}),
		   new HeaderSpan("5月", new String[] {"fiveBeforNum","fiveAfterNum","fiveAverageNum"}),
		   new HeaderSpan("6月", new String[] {"sixBeforNum","sixAfterNum","sixAverageNum"}),
		   new HeaderSpan("7月", new String[] {"sevenBeforNum","sevenAfterNum","sevenAverageNum"}),
		   new HeaderSpan("8月", new String[] {"eightBeforNum","eightAfterNum","eightAverageNum"}),
		   new HeaderSpan("9月", new String[] {"nineBeforNum","nineAfterNum","nineAverageNum"}),
		   new HeaderSpan("10月", new String[] {"tenBeforNum","tenAfterNum","tenAverageNum"}),
		   new HeaderSpan("11月", new String[] {"elevenBeforNum","elevenAfterNum","elevenAverageNum"}),
		   new HeaderSpan("12月", new String[] {"twelfBeforNum","twelfAfterNum","twelfAverageNum"})
	    });
		
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				// 获取业务部门名称
				String plateName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				ReportOnEmployeeNumTotalByDepartmentPanel panel = new ReportOnEmployeeNumTotalByDepartmentPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
				panel.setYear(year);
				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("业务部门(" + plateName + ")下的员工人数汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
		});
		
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		IButton exportButton = new IButton("导出");
		exportButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_OnDownloadReportOnEmployeeNumTotal", condition);
			}
		});
		controlLayout.addMember(exportButton);
		
		IButton exportDetailButton = new IButton("导出二级部门");
		exportDetailButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				Map<String,Object> condition = new HashMap<>();
				condition.put("plateId", plateId);
				condition.put("year", year);
				DBDataSource.downloadFile("DW_ExportReportOnEmployeeNumTotal", condition);
			}
		});
		controlLayout.addMember(exportDetailButton);
		
		
		
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
				detail.setTitle("ReportOnEmployeeNumTotal"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportOnEmployeeNumTotalViewer detailForm = new ReportOnEmployeeNumTotalViewer();
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
		year = BaseHelpUtils.getIntValue(criteria.get("year"));
		
		/*//如果没有加载全部业务部门的权限,加载自己拥有的有事业部助理这个角色下的业务部门
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL_ALL)) {
			
		}
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL_ALL)&&ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL_OUR)) {
			criteria.put("plateId", ClientUtil.getPlateId());
			
			List<Map> keyvalues = new ArrayList<>();
			Map<String, String> kv = new HashMap<>();
			kv.put("key", "aa.plate_id =?");
			kv.put("value", "aa.plate_id =? and aa.plate_id  in ("+1+")");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
					
		}*/
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportOnEmployeeNumTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOnEmployeeNumTotal.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

