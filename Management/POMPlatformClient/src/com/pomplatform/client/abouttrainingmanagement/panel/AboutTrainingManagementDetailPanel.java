package com.pomplatform.client.abouttrainingmanagement.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.Print;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Image;
import com.pomplatform.client.trainingmanagement.datasource.DSTrainingManagement;
import com.pomplatform.client.trainingmanagement.form.NewTrainingManagementForm;
import com.pomplatform.client.trainingmanagement.form.TrainingManagementSearchForm;
import com.pomplatform.client.trainingmanagement.form.TrainingManagementViewer;
import com.pomplatform.client.trainingmanagement.form.UpdateTrainingManagementForm;
import com.pomplatform.client.trainingmanagementdetailor.datasource.DSStrainingmanagementdetailor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AboutTrainingManagementDetailPanel  extends AbstractExpansionRelatedPage {
	
	private static final Logger __LOGGER = Logger.getLogger("");

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			AboutTrainingManagementDetailPanel cm = new AboutTrainingManagementDetailPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "AboutTrainingManagementDetail";
		}

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

	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("培训管理");
				detail.setWidth100();
				detail.setHeight100();
				TrainingManagementViewer detailForm = new TrainingManagementViewer();
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
		if(getRecord()!=null) {
			criteria.put("departmentId", BaseHelpUtils.getIntValue(getRecord().getAttribute("departmentId")));
			criteria.put("year", BaseHelpUtils.getIntValue(getRecord().getAttribute("year")));
			criteria.put("month", BaseHelpUtils.getIntValue(getRecord().getAttribute("month")));
		}
		criteria.put("addtionalCondition", "order by training_management_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSTrainingManagement.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSStrainingmanagementdetailor.getInstance();
	}
	
	private Record record;

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
