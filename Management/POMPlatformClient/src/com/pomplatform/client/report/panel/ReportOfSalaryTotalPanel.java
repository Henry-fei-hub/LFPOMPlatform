package com.pomplatform.client.report.panel;

import java.util.ArrayList;
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
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.payment.panel.OnSalaryReportByDepartmentPanel;
import com.pomplatform.client.report.datasource.DSReportOfSalaryTotal;
import com.pomplatform.client.report.form.ReportOfSalaryTotalSearchForm;
import com.pomplatform.client.report.form.ReportOfSalaryTotalViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ReportOfSalaryTotalPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ReportOfSalaryTotalPanel cm = new ReportOfSalaryTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReportOfSalaryTotal";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setShowGridSummary(true);
		resultGrid.setAutoFitFieldWidths(false);
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
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				Record record = resultGrid.getSelectedRecord();
				int plateId = BaseHelpUtils.getIntValue(record.getAttribute("plateId"));
				// 获取业务部门名称
				String plateName = KeyValueManager.getValue("system_dictionary_1", plateId + "");
				// 获取年月份
				int year = BaseHelpUtils.getIntValue(record.getAttribute("year"));
				// 获取检索栏的开始日期和结束日期
				PopupWindow pw = new PopupWindow();
				ReportOfSalaryTotalByDepartmentPanel panel = new ReportOfSalaryTotalByDepartmentPanel();
				pw.addItem(panel);
				panel.setPlateId(plateId);
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
		
		IButton exportButton = new IButton("导出");
		exportButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_OnDownloadReportOfSalaryTotal", condition);
			}
		});
		controlLayout.addMember(exportButton);
		
		
		IButton exportDetailButton = new IButton("导出二级部门");
		exportDetailButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				SC.debugger();
				Map criteria = generateCriteria();
				
				List<Map> keyvalues = new ArrayList<>();
				Map<String, String> kv = new HashMap<>();
				StringBuffer str=new StringBuffer();
				SC.debugger();
				//如果拥有查查所有部门的权限
				if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_ALL)) {
					str.append("1,2,3");
					kv.put("key", "a.company_id =?");
					kv.put("value", "a.company_id =? and pr.plate_type in ("+str.toString()+")");
					keyvalues.add(kv);
					criteria.put("keyValues", keyvalues);
					DBDataSource.downloadFile("DW_ExportReportOfSalaryTotalByDepartment", criteria);
				}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_1)||ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_2)||ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_3)){
					// 查看所有事业部 权限
					if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_1)) {
						str.append("1,");
					}
					// 查看所有职能部 权限
					if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_2)) {
						str.append("2,");
					}
					// 3 查看所有营销部 权限
					if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_3)) {
						str.append("3");
						kv.put("key", "a.company_id =?");
						kv.put("value", "a.company_id =? and pr.plate_type in ("+str.toString()+")");
						keyvalues.add(kv);
						criteria.put("keyValues", keyvalues);
					}else {
						//去掉最后一个逗号
						kv.put("key", "a.company_id =?");
						kv.put("value", "a.company_id =? and pr.plate_type in ("+str.toString().substring(0, str.toString().length()-1)+")");
						keyvalues.add(kv);
						criteria.put("keyValues", keyvalues);
					}
					DBDataSource.downloadFile("DW_ExportReportOfSalaryTotalByDepartment", criteria);
				}else {
					SC.say("提示","抱歉你没有查看权限");
				}
				
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
				detail.setTitle("ReportOfSalaryTotal"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ReportOfSalaryTotalViewer detailForm = new ReportOfSalaryTotalViewer();
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
		List<Map> keyvalues = new ArrayList<>();
		Map<String, String> kv = new HashMap<>();
		StringBuffer str=new StringBuffer();
		SC.debugger();
		//如果拥有查查所有部门的权限
		if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_ALL)) {
			str.append("1,2,3");
			kv.put("key", "aa.plate_id >= 0");
			kv.put("value", "aa.plate_id >= 0 and pr.plate_type in ("+str.toString()+")");
			keyvalues.add(kv);
			criteria.put("keyValues", keyvalues);
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_1)||ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_2)||ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_3)){
			// 查看所有事业部 权限
			if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_1)) {
				str.append("1,");
			}
			// 查看所有职能部 权限
			if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_2)) {
				str.append("2,");
			}
			// 3 查看所有营销部 权限
			if (ClientUtil.checkIsHavePermission(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL_3)) {
				str.append("3");
				kv.put("key", "aa.plate_id >= 0");
				kv.put("value", "aa.plate_id >= 0 and pr.plate_type in ("+str.toString()+")");
				keyvalues.add(kv);
				criteria.put("keyValues", keyvalues);
			}else {
				//去掉最后一个逗号
				kv.put("key", "aa.plate_id >= 0");
				kv.put("value", "aa.plate_id >= 0 and pr.plate_type in ("+str.toString().substring(0, str.toString().length()-1)+")");
				keyvalues.add(kv);
				criteria.put("keyValues", keyvalues);
			}
		}else {
			SC.say("提示","抱歉没有查看权限");
			return false;
		}
		
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ReportOfSalaryTotalSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSReportOfSalaryTotal.getInstance();
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

