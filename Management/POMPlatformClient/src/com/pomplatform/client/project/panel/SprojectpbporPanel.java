package com.pomplatform.client.project.panel;

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
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.project.datasource.DSSprojectpbpor;
import com.pomplatform.client.project.datasource.DSSprojectpricechangedrecordcppor;
import com.pomplatform.client.project.form.GetProjectsSearchForm;
import com.pomplatform.client.project.form.SprojectpbporSearchForm;
import com.pomplatform.client.project.form.SprojectpbporViewer;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SprojectpbporPanel extends AbstractExpansionRelatedPage
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private Map <String , Object> map ;
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SprojectpbporPanel cm = new SprojectpbporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sprojectpbpor";
		}

	}

/*	@Override
	public void init(){
		super.init();
		resultGrid.setCanEdit(true);
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
	}*/

	@Override
	public void initComponents() {
		resultGrid.setCanEdit(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton dwButton = new IButton("导出");
		controlLayout.addMember(dwButton);
		dwButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> condition = new HashMap<>();
				if(!BaseHelpUtils.isNullOrEmpty(map)) {
					condition.putAll(map);
				}
				DBDataSource.downloadFile("DW_Sprojectpbpor", condition);
			}
		});
		
		
		IButton changedMoneyButton = new IButton("补贴登记");
		controlLayout.addMember(changedMoneyButton);
		changedMoneyButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据修改");
                    return;
                }
				SC.debugger();
                ListGridRecord selectedRecord = resultGrid.getSelectedRecord();
                int projectId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("projectId"));
                String projectName = BaseHelpUtils.getString(selectedRecord.getAttribute("projectName"));
                String contractCode = BaseHelpUtils.getString(selectedRecord.getAttribute("contractCode"));
                int plateId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("plateId"));
                 PopupWindow popupWindow = new PopupWindow("补贴登记");
                 popupWindow.setWidth("45%");
                 popupWindow.setHeight("50%");
                 popupWindow.centerInPage();
                 SprojectPriceChangedRecordPanel panel = new SprojectPriceChangedRecordPanel();
                 panel.addDataEditedHandler(new DataEditedHandler() {
             		@Override
             		public void onDataEdited(DataEditEvent event) {
             			 commonQuery();
             		}
             	});
                 panel.setProjectId(projectId);
                 panel.setPlateId(plateId);
                 panel.setProjectName(projectName);
                 panel.setContractCode(contractCode); 
                 panel.initComponents();
                 popupWindow.addItem(panel);
                 panel.setParentWindow(popupWindow);
                 popupWindow.centerInPage();
                 popupWindow.show();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@SuppressWarnings("rawtypes")
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_Project", "update", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						}else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});
		
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
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("项目详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SprojectpbporViewer detailForm = new SprojectpbporViewer();
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
		criteria.put("addtionalCondition", "order by project_id");
		map=new HashMap<>();
		map.putAll(criteria);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new SprojectpbporSearchForm();
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public DataSource getDataSource() {
		return DSSprojectpbpor.getInstance();
	}
	
	@Override
	public DataSource getChildDataSource() {
		return DSSprojectpricechangedrecordcppor.getInstance();
	}


}

