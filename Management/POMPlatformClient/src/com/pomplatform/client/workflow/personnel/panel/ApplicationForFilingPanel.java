package com.pomplatform.client.workflow.personnel.panel;

import java.util.Date;

import com.pomplatform.client.workflow.personnel.datasource.DSApplicationForFiling;
import com.pomplatform.client.workflow.personnel.form.ApplicationForFilingSearchForm;
import com.pomplatform.client.workflow.personnel.form.ApplicationForFilingViewer;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.LayoutConstant;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.ClientUtil;
import java.util.Objects;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ApplicationForFilingPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ApplicationForFilingPanel cm = new ApplicationForFilingPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ApplicationForFiling";
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






			}
		});



//		IButton operation1Button = new IButton("查看详情");
//		controlLayout.addMember(operation1Button);
//		operation1Button.setIcon("[SKIN]/actions/view.png");
//		operation1Button.addClickHandler(new ClickHandler(){
//			@Override
//			public void onClick(ClickEvent event) {
//				showDetail();
//			}
//		});
//		IButton removeButton = new IButton("删除");
//		controlLayout.addMember(removeButton);
//		removeButton.setIcon("[SKIN]/actions/remove.png");
//		removeButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				if (!resultGrid.anySelected()) {
//					SC.say("Please select a data to remove.");
//				}
//				final ListGridRecord selected = resultGrid.getSelectedRecord();
//				DBDataSource.callOperation("ST_ApplicationForFiling", "delete", selected.toMap(), new DSCallback() {
//					@Override
//					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//						if (dsResponse.getStatus() < 0) {
//							ClientUtil.displayErrorMessage(dsResponse);
//						} else {
//							int indexNum = resultGrid.getRowNum(selected);
//							resultGrid.removeData(selected);
//							resultGrid.selectSingleRecord(indexNum);
//						}
//					}
//				});
//			}
//		});
//
//		commonQuery();
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
				detail.setTitle("ApplicationForFiling"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ApplicationForFilingViewer detailForm = new ApplicationForFilingViewer();
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
		criteria.put("employeeId",getEmployeeId());
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
//		return new ApplicationForFilingSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSApplicationForFiling.getInstance();
	}


	private String employeeId;
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}

