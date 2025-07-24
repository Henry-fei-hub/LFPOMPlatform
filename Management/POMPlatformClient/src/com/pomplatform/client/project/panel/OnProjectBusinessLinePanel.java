package com.pomplatform.client.project.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.UploadJobSubsidysData;
import com.pomplatform.client.project.datasource.DSOnProjectBusinessLine;
import com.pomplatform.client.project.form.OnProjectBusinessLineSearchForm;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class OnProjectBusinessLinePanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnProjectBusinessLinePanel cm = new OnProjectBusinessLinePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnProjectBusinessLinePanel";
		}

	}

	@Override
	public void init(){
		super.init();
		resultGrid.setCanEdit(true);
		resultGrid.setAutoFitFieldWidths(false);
		__controlPosition = LayoutConstant.RIGHT;
	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		
		IButton dwButton = new IButton("导出");
		controlLayout.addMember(dwButton);
		dwButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map condition = generateCriteria();
				condition.put("optType","onDWBusinessLineExportData");
//				condition.put("optType","onEmployeeAccountExportData");
				String replaceAll = BaseHelpUtils.getStringValue(map , "contractCode").replaceAll("%", "");
				map.put("contractCode", replaceAll);
				condition.putAll(map);
				DBDataSource.downloadFile("DW_ProjectsDWProcess", condition);
			}
		});
		
/*		IButton importData = new IButton("导入");
		controlLayout.addMember(importData);
		importData.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}

					@Override
					public void onSuccess() {
						UploadJobSubsidysData uploadXls = new UploadJobSubsidysData();
						uploadXls.addDataEditedHandler(new DataEditedHandler() {
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						uploadXls.show();
					}
				});

			}
		});*/
		
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
				if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord record = resultGrid.getSelectedRecord();
                if(ClientUtil.checkAndGetIntValue(record.getAttribute("projectId"))>0){
                	GenericViewWindow detail = new GenericViewWindow();
                    detail.setTitle("项目详情");
                    detail.setWidth100();
                    detail.setHeight100();
                    SprojectViewViewer detailForm = new SprojectViewViewer();
                    detailForm.setParentSearchForm(searchForm);
                    detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
                    detailForm.initComponents();
                    detailForm.viewSelectedData(resultGrid);
                    detail.setContent(detailForm);
                    detail.centerInPage();
                    detail.show();
                }
			}
		});
	}
	
	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		String contractCode = BaseHelpUtils.getStringValue(criteria, "contractCode");
		if(!BaseHelpUtils.isNullOrEmpty(contractCode)) {
			contractCode="%"+contractCode+"%";
			criteria.put("contractCode",contractCode);
		}
//		criteria.put("projectFlag",1);//只检索设计项目
		criteria.put("addtionalCondition", " project_flag in (1,4) order by project_id");
		
		map=new HashMap<>();
		map.putAll(criteria);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnProjectBusinessLineSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnProjectBusinessLine.getInstance();
	}
	
	
	private Map<String,Object> map ;

}

