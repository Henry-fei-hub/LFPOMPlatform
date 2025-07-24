package com.pomplatform.client.preprojectmyrecords.panel;

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
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.preprojectmyrecords.datasource.DSPreProjectMyRecords;
import com.pomplatform.client.preprojectmyrecords.form.PreProjectMyRecordsSearchForm;
import com.pomplatform.client.preprojectmyrecords.form.PreProjectMyRecordsViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PreProjectMyRecordsPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PreProjectMyRecordsPanel cm = new PreProjectMyRecordsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PreProjectMyRecords";
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
		viewButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		
		IButton PreProjectMyRecordsButton = new IButton("导出报表");
		controlLayout.addMember(PreProjectMyRecordsButton);
		PreProjectMyRecordsButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				DBDataSource.downloadFile("DW_ExportPreProjectMyRecords", condition);

			}
		});
		controlLayout.addMember(PreProjectMyRecordsButton);
		
		
		
		
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
				detail.setTitle("PreProjectMyRecords"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				PreProjectMyRecordsViewer detailForm = new PreProjectMyRecordsViewer();
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
		
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PRE_PROJECT_MY_REPORT)){
			criteria.put("relevantEmployees", ClientUtil.getEmployeeId());
		}
		List<Map> keyvalues = new ArrayList<>();
		//项目流程状态多选时
		if(criteria.containsKey("status") && null != criteria.get("status")){
			String status = criteria.get("status").toString().replace("[", "").replace("]", "");
			if(status.indexOf(",") >= 0){
				criteria.remove("status");
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "P.status");
				kv.put("value", "P.status in (" + status +") and  P.status");
				keyvalues.add(kv);
			}else{
				//单选
				criteria.put("status", status);
			}
		}
		//项目状态多选时
		if(criteria.containsKey("projectStatus") && null != criteria.get("projectStatus")){
			String projectStatus = criteria.get("projectStatus").toString().replace("[", "").replace("]", "");
			if(projectStatus.indexOf(",") >= 0){
				criteria.remove("projectStatus");
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "P.project_status");
				kv.put("value", "P.project_status in (" + spilt(projectStatus) +") and P.project_status");
				keyvalues.add(kv);
			}else{
				//单选
				criteria.put("projectStatus", projectStatus);
			}
		}
		//立项依据多选时
		if(criteria.containsKey("projectBaseOn") && null != criteria.get("projectBaseOn")){
			String projectBaseOn = criteria.get("projectBaseOn").toString().replace("[", "").replace("]", "");
			if(projectBaseOn.indexOf(",") >= 0){
				criteria.remove("projectBaseOn");
				Map<String, String> kv = new HashMap<>();
				kv.put("key", "P.project_base_on");
				kv.put("value", "P.project_base_on in (" + projectBaseOn +") and P.project_base_on ");
				keyvalues.add(kv);
			}else{
				//单选
				criteria.put("projectBaseOn", projectBaseOn);
			}
		}


		if(keyvalues.size() > 0){
			criteria.put("keyValues", keyvalues);
		}
		
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new PreProjectMyRecordsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPreProjectMyRecords.getInstance();
	}
	//把字符串中逗号之前的字符加上单引号
	private String spilt(String str) {
		StringBuffer sb = new StringBuffer();
		String[] temp = str.split(",");
		for (int i = 0; i < temp.length; i++) {
			if (!"".equals(temp[i]) && temp[i] != null)
				sb.append("'" + temp[i] + "',");
		}
		String result = sb.toString();
		String tp = result.substring(result.length() - 1, result.length());
		if (",".equals(tp))
			return result.substring(0, result.length() - 1);
		else
			return result;

	}

	public int getSearchFormHeight() {




		return 80;
	}

}

