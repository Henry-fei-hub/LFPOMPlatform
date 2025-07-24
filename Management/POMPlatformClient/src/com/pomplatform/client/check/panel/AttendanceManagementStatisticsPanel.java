package com.pomplatform.client.check.panel;

import java.util.Date;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.check.datasource.DSAttendanceManagementStatistics;
import com.pomplatform.client.check.form.AttendanceManagementStatisticsSearchForm;
import com.pomplatform.client.check.form.AttendanceManagementStatisticsViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.Map;
import java.util.logging.Logger;

public class AttendanceManagementStatisticsPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	protected AttendanceManagementStatisticsForm detailForm;
	
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AttendanceManagementStatisticsPanel cm = new AttendanceManagementStatisticsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AttendanceManagementStatistics";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
	}

	@Override
	public Canvas getViewPanel() {
		detailForm = new AttendanceManagementStatisticsForm();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
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
				detail.setTitle("AttendanceManagementStatistics"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				AttendanceManagementStatisticsViewer detailForm = new AttendanceManagementStatisticsViewer();
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
		criteria.put("today", new Date());
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new AttendanceManagementStatisticsSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAttendanceManagementStatistics.getInstance();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

}

