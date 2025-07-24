package com.pomplatform.client.report.panel;

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
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.report.datasource.DSSalaryBonusAnalysisByDepartment;
import com.pomplatform.client.report.form.SalaryBonusAnalysisByDepartmentSearchForm;
import com.pomplatform.client.report.form.SalaryBonusAnalysisByDepartmentViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SalaryBonusAnalysisByDepartmentPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SalaryBonusAnalysisByDepartmentPanel cm = new SalaryBonusAnalysisByDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SalaryBonusAnalysisByDepartment";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
		__needControl = false;
	}

	@Override
	public void initComponents() {
		
		resultGrid.setHeaderHeight(60); 
		resultGrid.setHeaderSpans(new HeaderSpan[] {
		   new HeaderSpan("第一季度", new String[] {"firstQuarter","firstPayIntegral","one"}),
		   new HeaderSpan("第二季度", new String[] {"secondQuarter","secondPayIntegral","two"}),
		   new HeaderSpan("第三季度", new String[] {"thirdQuarter","thirdPayIntegral","three"}),
		   new HeaderSpan("第四季度", new String[] {"fourthQuarter","fourthPayIntegral","four"})
	    });	
		
	resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
		@Override
		public void onDoubleClick(DoubleClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				SC.debugger();
				Record record = resultGrid.getSelectedRecord();
				int departmentId = BaseHelpUtils.getIntValue(record.getAttribute("departmentId"));
				// 获取业务部门名称
				String plateName = KeyValueManager.getValue("departments", departmentId + "");
				// 获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				SalaryBonusAnalysisByEmployeePanel panel = new SalaryBonusAnalysisByEmployeePanel();
				pw.addItem(panel);
				panel.setDepartmentId(departmentId);
				panel.setYear(year);
//				panel.initComponents();
				panel.commonQuery();
				pw.setTitle("业务部门(" + plateName + ")下的归属部门汇总");
				pw.setWidth100();
				pw.setHeight100();
				pw.centerInPage();
				pw.show();
			}
	});
	}



	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if (plateId > 0) {
			criteria.put("plateId", plateId);
		}else {
			SC.say("提示", "业务部门不可为空");
			return false;
		}
		if (year > 0) {
			criteria.put("year", year);
			criteria.put("firstStart", year+"-01-01");
			criteria.put("firstEnd", year+"-03-31");
			criteria.put("secondStart", year+"-04-01");
			criteria.put("secondEnd", year+"-06-30");
			criteria.put("thirdStart", year+"-07-01");
			criteria.put("thirdEnd", year+"-09-31");
			criteria.put("fourthStart", year+"-10-01");
			criteria.put("fourthEnd", year+"-12-31");
		}else {
			SC.say("提示", "年份不可为空");
			return false;
		}
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return null;
//		return new SalaryBonusAnalysisByDepartmentSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSalaryBonusAnalysisByDepartment.getInstance();
	}
	
	private int year;
	private int plateId;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	
	


}

