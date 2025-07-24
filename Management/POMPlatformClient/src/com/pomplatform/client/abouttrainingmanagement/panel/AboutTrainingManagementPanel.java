package com.pomplatform.client.abouttrainingmanagement.panel;

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
import com.smartgwt.client.types.Alignment;
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
import com.pomplatform.client.abouttrainingmanagement.datasource.DSAboutTrainingManagement;
import com.pomplatform.client.abouttrainingmanagement.form.AboutTrainingManagementSearchForm;
import com.pomplatform.client.abouttrainingmanagement.form.AboutTrainingManagementViewer;
import com.pomplatform.client.payseqaddinfo.panel.PaySeqAddInfoPanel;
import com.pomplatform.client.totaltrainingmanagement.panel.TotalTrainingManagementPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AboutTrainingManagementPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			AboutTrainingManagementPanel cm = new AboutTrainingManagementPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AboutTrainingManagement";
		}

	}

	@Override
	public void init(){
		super.init();
		int index = 0;
		ListGridField[] fields = new ListGridField[14];
		fields[index] = new ListGridField("year");
		fields[index].setWidth("25%");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("month");
		fields[index].setWidth("25%");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setShowGridSummary(false);
		index++;
		fields[index] = new ListGridField("departmentId");
		fields[index].setWidth("35%");
		fields[index].setAlign(Alignment.RIGHT);
		fields[index].setShowGridSummary(false);
		KeyValueManager.loadValueMap("departments", fields[index]);
		index++;
		fields[index] = new ListGridField("number");
		fields[index].setWidth("35%");
		fields[index].setShowGridSummary(true);
		fields[index].setAlign(Alignment.RIGHT);
		resultGrid.setFields(fields);
		resultGrid.setDataSource(getDataSource());
		resultGrid.setAutoFitFieldWidths(false);
		resultGrid.setShowGridSummary(true);
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
		
		IButton tolButton = new IButton("汇总");
		tolButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GenericViewWindow details = new GenericViewWindow();
				details.setTitle("培训年度汇总"); 
				details.setWidth("100%"); 
				details.setHeight("100%"); 
				TotalTrainingManagementPanel panel = new  TotalTrainingManagementPanel();  
				panel.commonQuery();
				details.setContent(panel);
				details.centerInPage();
				details.show();
			}
		});
		controlLayout.addMember(tolButton);
		
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
				GenericViewWindow details = new GenericViewWindow();
				details.setTitle("培训汇总详情"); 
				details.setWidth("100%"); 
				details.setHeight("100%"); 
				AboutTrainingManagementDetailPanel panel =new AboutTrainingManagementDetailPanel();
				Record records=resultGrid.getSelectedRecord();
				panel.setRecord(records);
				panel.commonQuery();
				details.setContent(panel);
				details.centerInPage();
				details.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new AboutTrainingManagementSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSAboutTrainingManagement.getInstance();
	}
	
	public int getSearchFormHeight() {
        return 80;
    }

}

