package com.pomplatform.client.projectteambuild.panel;

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
import com.pomplatform.client.projectteambuild.datasource.DSProjectEmployeePlanIntegralProgress;
import com.pomplatform.client.projectteambuild.form.ProjectEmployeePlanIntegralProgressSearchForm;
import com.pomplatform.client.projectteambuild.form.ProjectEmployeePlanIntegralProgressViewer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ProjectEmployeePlanIntegralProgressPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectEmployeePlanIntegralProgressPanel cm = new ProjectEmployeePlanIntegralProgressPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectEmployeePlanIntegralProgress";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
        __needPagenation = false;
        __needControl = false;
        __needViewPage = false;
	}

	@Override
	public void initComponents() {
		
	}


	@Override
	public boolean checkSearchCriteria(Map criteria) {
		if(!BaseHelpUtils.isNullOrEmpty(projectId)&&projectId>0) {
			criteria.put("projectId", projectId);
			return true;
		}
		return false;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ProjectEmployeePlanIntegralProgressSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectEmployeePlanIntegralProgress.getInstance();
	}
	
	public int getSearchFormHeight() {
		return 60;
	}

	private int projectId;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	

}

