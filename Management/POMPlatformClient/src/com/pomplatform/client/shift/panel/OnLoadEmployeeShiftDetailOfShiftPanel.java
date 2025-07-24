package com.pomplatform.client.shift.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.shift.datasource.DSOnLoadEmployeeShiftDetailOfShift;
import com.pomplatform.client.shift.form.OnLoadEmployeeShiftDetailOfShiftSearchForm;
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

public class OnLoadEmployeeShiftDetailOfShiftPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnLoadEmployeeShiftDetailOfShiftPanel cm = new OnLoadEmployeeShiftDetailOfShiftPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnLoadEmployeeShiftDetailOfShift";
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
		if(BaseHelpUtils.getIntValue(shiftManageId) == 0){SC.say("提示","请选择您要排班的班次");return;}
		//获取当前面板已选择的数据集
		Record[] fromRecords = resultGrid.getSelectedRecords();
		//获取要追加数据集的gird的所有数据集
		Record[] toRecords = EmployeeShiftPanel.grid.getRecords();
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
				e.setAttribute("startDate",startDate);
				e.setAttribute("endDate",endDate);
				EmployeeShiftPanel.grid.addData(e);
				EmployeeShiftPanel.grid.redraw();
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

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(startDate != null){
			criteria.put("startDate", startDate);
		}
		if(endDate != null){
			criteria.put("endDate", endDate);
		}
		return true;
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}
	
	@Override
	public void afterDataReceived(Record[] data) {
		if(data != null){
			for(Record e : data){
				//获取数目
				int count = BaseHelpUtils.getIntValue(e.getAttribute("count"));
				if(count > 0){//说明本月有考勤
					e.setAttribute("isShift",Boolean.TRUE);
				}
			}
			resultGrid.setData(data);
			resultGrid.redraw();
		}
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnLoadEmployeeShiftDetailOfShiftSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnLoadEmployeeShiftDetailOfShift.getInstance();
	}

	private Date startDate;
    private Date endDate;
    private Integer shiftManageId;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getShiftManageId() {
		return shiftManageId;
	}

	public void setShiftManageId(Integer shiftManageId) {
		this.shiftManageId = shiftManageId;
	}
	

}

