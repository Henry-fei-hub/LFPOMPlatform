package com.pomplatform.client.employeereportrecorddetail.panel;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.employeereportrecorddetail.datasource.DSEmployeeMonthlyAchieveIntegral;
import com.pomplatform.client.employeereportrecorddetail.form.EmployeeMonthlyAchieveIntegralViewer;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class EmployeeMonthlyAchieveIntegralPanel extends AbstractSearchPanel
{

	private Integer plateId;
	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			EmployeeMonthlyAchieveIntegralPanel cm = new EmployeeMonthlyAchieveIntegralPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeMonthlyAchieveIntegral";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
		resultGrid.setShowRowNumbers(true);
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(false);
		resultGrid.setShowFilterEditor(true);
        resultGrid.setFilterOnKeypress(false);
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				addRecord();
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
				detail.setTitle("在职员工每月价值积分"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				EmployeeMonthlyAchieveIntegralViewer detailForm = new EmployeeMonthlyAchieveIntegralViewer();
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
		criteria.put("plateId", plateId);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new EmployeeMonthlyAchieveIntegralSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSEmployeeMonthlyAchieveIntegral.getInstance();
	}

	//当双击和点击同步图标按钮时触发的公用方法
    public void addRecord(){
    	if (!resultGrid.anySelected()) {
            SC.say("请选择一条数据");
            return;
        }
    	ListGridRecord[] selected = resultGrid.getSelectedRecords();
    	if(null != selected && selected.length > 0){
	    	//获取右边所有的gird数据
			ListGridRecord[] records = PlateGetViolationChargesPanel.grid.getRecords();
	    	Set<Integer> oldData = new HashSet<>();
	    	if(null != records && records.length > 0){
	    		for(ListGridRecord obj : records){
	    			oldData.add(ClientUtil.checkAndGetIntValue(obj.getAttribute("employeeId")));
	    		}
	    	}
	    	for(ListGridRecord obj : selected){
	    		//获取到职员id
	    		int employeeId = ClientUtil.checkAndGetIntValue(obj.getAttribute("employeeId"));
	    		if(employeeId <= 0){
	    			continue;
	    		}
	    		//获取业务部门
	    		int plateId = ClientUtil.checkAndGetIntValue(obj.getAttribute("plateId"));
	    		if(plateId <= 0){
	    			continue;
	    		}
	    		if(oldData.contains(employeeId)){
					continue;
    			}
	    		//左边gird新增一条记录
	    		Record record  = new Record();
	    		record.setAttribute("employeeId", employeeId);
	    		record.setAttribute("plateId", plateId);
	    		record.setAttribute("violationCharges", 0);
	    		PlateGetViolationChargesPanel.grid.addData(record);
	    	}
    	}
    }

	public Integer getPlateId() {
		return plateId;
	}

	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}
	
}

