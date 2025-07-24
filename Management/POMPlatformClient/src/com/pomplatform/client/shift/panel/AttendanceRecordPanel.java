package com.pomplatform.client.shift.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.shift.datasource.DSAttendanceRecord;
import com.pomplatform.client.shift.form.AttendanceRecordViewer;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class AttendanceRecordPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AttendanceRecordPanel cm = new AttendanceRecordPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttendanceRecord";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needViewPage = false;
		__needControl = false;
	}

	@Override
	public void initComponents() {

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				ListGridRecord selected = resultGrid.getSelectedRecord();
				Map<String,Object> map = new HashMap<>();
				map.put("employeeId", employeeId);
				map.put("checkDate", selected.getAttributeAsDate("recordDate"));
				GenericViewWindow detail = new GenericViewWindow();
            	detail.setTitle("打卡明细");
            	detail.setWidth("60%");
            	detail.setHeight("60%");
            	MyAttendanceDetailPanel detailForm = new MyAttendanceDetailPanel();
            	detailForm.initComponents();
            	detailForm.loadGridData(map);
            	detail.setContent(detailForm);
            	detail.centerInPage();
            	detail.show();
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
				detail.setTitle("考勤记录"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				AttendanceRecordViewer detailForm = new AttendanceRecordViewer();
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
		criteria.put("employeeId", employeeId);
		criteria.put("startDate", startDate);
		criteria.put("endDate", endDate);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new AttendanceRecordSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSAttendanceRecord.getInstance();
	}

	private String employeeId;
	private Date startDate;
	private Date endDate;
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

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

}

