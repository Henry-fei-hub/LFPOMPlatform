package com.pomplatform.client.poolmanage.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.poolmanage.datasource.DSPoolEmployees;
import com.pomplatform.client.poolmanage.form.PoolEmployeesPanelSearchForm;
import com.pomplatform.client.shift.form.OnLoadEmployeeShiftDetailOfShiftViewer;
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

public class PoolEmployeesPanel extends AbstractSearchPanel
{


	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			PoolEmployeesPanel cm = new PoolEmployeesPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PoolEmployeesPanel";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
        resultGrid.setFilterOnKeypress(false);
        
		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				addRecord();
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
		
		IButton addButton = new IButton("添加");
        controlLayout.addMember(addButton);
        addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addRecord();
			}
		});

	}
	
	public void addRecord(){
		if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
		//获取当前面板已选择的数据集
		Record[] fromRecords = resultGrid.getSelectedRecords();
		//获取要追加数据集的gird的所有数据集
		Record[] toRecords = PoolManagePanel.grid.getRecords();
		//遍历要追加的数据集的gird的数据，并将职员的ID保存至map中
		Map<Integer,Integer> empMap = new HashMap<>();
		for(Record e : toRecords){
			//获取职员ID
			int employeeId = BaseHelpUtils.getIntValue(e.getAttribute("employeeId"));
			empMap.put(employeeId,employeeId);
		}
		//遍历选择的的数据集，看职员是否已经选择过去(即已经存入map),如果没有则追加过去，有则不追加
		for(Record e : fromRecords){
			//获取职员ID
			int employeeId = BaseHelpUtils.getIntValue(e.getAttribute("employeeId"));
			if(!empMap.containsKey(employeeId)){//说明没有谁加过去，则需要追加
				PoolManagePanel.grid.addData(e);
				PoolManagePanel.grid.redraw();
			}
		}
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
				detail.setTitle("员工排班详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnLoadEmployeeShiftDetailOfShiftViewer detailForm = new OnLoadEmployeeShiftDetailOfShiftViewer();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("status",0);
		Object employeeNo = criteria.get("employeeNo");
		if(!BaseHelpUtils.isNullOrEmpty(employeeNo)) {
			criteria.put("employeeNo", "%"+employeeNo+"%");
		}
		Object employeeName = criteria.get("employeeName");
		if(!BaseHelpUtils.isNullOrEmpty(employeeName)) {
			criteria.put("employeeName", "%"+employeeName+"%");
		}
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return new PoolEmployeesPanelSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPoolEmployees.getInstance();
	}


}

