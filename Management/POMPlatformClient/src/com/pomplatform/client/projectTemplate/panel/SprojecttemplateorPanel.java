package com.pomplatform.client.projectTemplate.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.projectTemplate.datasource.DSSprojecttemplateor;
import com.pomplatform.client.projectTemplate.form.SprojecttemplateorSearchForm;
import com.pomplatform.client.projectTemplate.form.SprojecttemplateorViewer;
import com.pomplatform.client.projectTemplate.form.UpdateProjectTemplateForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;

public class SprojecttemplateorPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			SprojecttemplateorPanel cm = new SprojecttemplateorPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "Sprojecttemplateor";
		}

	}

	@Override
	public void init(){
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		resultGrid.setAutoFitFieldWidths(false);
	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});
		
		final IButton addButton = PermissionControl.createPermissionButton("新增", ERPPermissionStatic.PROJECT_STAGE_TMEPLATE_MANAGEMENT_ADD);
		controlLayout.addMember(addButton);
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
//				commonQuery();
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                    	UpdateProjectTemplateForm detailForm = new UpdateProjectTemplateForm();
                        detailForm.setTitle("新增项目阶段模板");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.setWidth("80%");
                        detailForm.setHeight("80%");
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            
			}
		});
		
		final IButton updateButton = PermissionControl.createPermissionButton("编辑", ERPPermissionStatic.PROJECT_STAGE_TMEPLATE_MANAGEMENT_UPDATE);
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                    	if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
                    	UpdateProjectTemplateForm detailForm = new UpdateProjectTemplateForm();
                    	Record selected = resultGrid.getSelectedRecords()[0];
                        detailForm.setTitle("编辑项目阶段模板");
                        int intValue = BaseHelpUtils.getIntValue(selected.getAttribute("projectTemplateId"));
                        detailForm.setProjectTemplateId(BaseHelpUtils.getIntValue(selected.getAttribute("projectTemplateId")));
                        detailForm.setProjectTemplateName(selected.getAttribute("projectTemplateName"));
                        detailForm.setProjectType(BaseHelpUtils.getIntValue(selected.getAttribute("projectType")));
                        detailForm.setBusinessType(BaseHelpUtils.getIntValue(selected.getAttribute("businessType")));
                        detailForm.setPlateId(BaseHelpUtils.getIntValue(selected.getAttribute("plateId")));
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                       
                        detailForm.setSearchForm(searchForm);
                        detailForm.setRecord(selected);
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.setWidth("80%");
                        detailForm.setHeight("80%");
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            
			}
		});
		
		
		final IButton delButton = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.PROJECT_STAGE_TMEPLATE_MANAGEMENT_DEL);
		controlLayout.addMember(delButton);
		delButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                    	if(!resultGrid.anySelected()){ SC.say("请选择一条数据"); return;}
                    	
                    	SC.confirm("提示", "确认删除该数据？", new BooleanCallback() {
							@Override
							public void execute(Boolean value) {
								if (!value)return;
								
								Record selected = resultGrid.getSelectedRecords()[0];
								Map <String ,Object> params =new HashMap<>();
								int projectTemplateId = BaseHelpUtils.getIntValue(selected.getAttribute("projectTemplateId"));
								
								params.put("projectTemplateId", projectTemplateId);
								params.put("optType", "DelProjecTempletWithStage");
								
								DBDataSource.callOperation("EP_OnProjectWithStageCommon", params, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if(dsResponse.getStatus() >= 0){
											SC.say("删除成功");
											 commonQuery();
										}
									}
								});
								
								
							}
						});
                    }
                });
            
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
				detail.setTitle("项目模板详情"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				SprojecttemplateorViewer detailForm = new SprojecttemplateorViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
//				GenericViewWindow detail = new GenericViewWindow();
//            	detail.setTitle("项目详情");
//            	detail.setWidth100();
//            	detail.setHeight100();
//            	SprojectViewViewer detailForm = new SprojectViewViewer();
//            	detailForm.setParentSearchForm(searchForm);
//            	detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
//            	detailForm.initComponents();
//            	detailForm.viewSelectedData(resultGrid);
//            	detail.setContent(detailForm);
//            	detail.centerInPage();
//            	detail.show();
			}
		});
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		return true;
	}

	@Override
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new SprojecttemplateorSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSSprojecttemplateor.getInstance();
	}


}

