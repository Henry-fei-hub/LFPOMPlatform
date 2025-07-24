package com.pomplatform.client.account.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.LayoutConstant;
import com.pomplatform.client.employee.datasource.DSCommonEmployeeDataSource;
import com.pomplatform.client.employee.panel.CommonEmpoyeeSearchForm;
import com.pomplatform.client.shift.panel.EmployeeShiftPanel;
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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DepDeployEmployeePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			DepDeployEmployeePanel cm = new DepDeployEmployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "DepDeployEmployeePanel";
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
		Record[] toRecords = DepDeployPanel.grid.getRecords();
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
				DepDeployPanel.grid.addData(e);
				DepDeployPanel.grid.redraw();
			}
		}
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("status", 0);
		if(!BaseHelpUtils.isNullOrEmpty(criteria.get("employeeNo"))){
			criteria.put("employeeNo","%"+criteria.get("employeeNo")+"%");
		}
		if(!BaseHelpUtils.isNullOrEmpty(criteria.get("employeeName"))){
			criteria.put("employeeName","%"+criteria.get("employeeName")+"%");
		}
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	@Override
	public SearchForm generateSearchForm() {
		return new CommonEmpoyeeSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSCommonEmployeeDataSource.getInstance();
	}

}

