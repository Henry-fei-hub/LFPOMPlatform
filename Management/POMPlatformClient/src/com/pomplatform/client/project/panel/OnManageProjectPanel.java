package com.pomplatform.client.project.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
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
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.project.datasource.DSOnDevelopProject;
import com.pomplatform.client.project.form.NewOnDevelopProjectForm;
import com.pomplatform.client.project.form.OnDevelopProjectViewer;
import com.pomplatform.client.project.form.OnManageProjectSearchForm;
import com.pomplatform.client.project.form.UpdateOnDevelopProjectForm;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
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
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OnManageProjectPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			OnManageProjectPanel cm = new OnManageProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnManageProject";
		}

	}

	@Override
	public void init(){
		super.init();
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

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		
		//公司的立项
		IButton operation1Button = PermissionControl.createPermissionButton("立项", ERPPermissionStatic.MANAGE_PROJECT_COMPANY_NEW);
		controlLayout.addMember(operation1Button);
		operation1Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						//初始化信息
						int businessType = 1;//业务类型(默认为商业)
						int projectType = 56;//项目类型(默认为管理项目)
						int projectFlag = 3;//项目标示类型(默认为管理项目)
						int plateId = 17;//归属部门(默认为运营中心)
						int projectSetupFlag = 1;//立项标示(默认为公司立项)
						Map<String,Object> param = new HashMap<>();
						param.put("optType", "onLoadProjectCode");
						param.put("plateId",plateId);
						param.put("businessType",businessType);
						param.put("projectType",projectType);
						param.put("projectFlag",projectFlag);
						//加载项目编码
						DBDataSource.callOperation("EP_OnProjectCommonProcess", "load",param, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									Record record = dsResponse.getData()[0];
									String contractCode = record.getAttribute("projectCode");
									String projectCode = record.getAttribute("code");
									record.setAttribute("contractCode", contractCode);
									record.setAttribute("projectCode", projectCode);
									record.setAttribute("businessType",businessType);
									record.setAttribute("projectType", projectType);
									record.setAttribute("projectFlag", projectFlag);
									record.setAttribute("projectSetupFlag", projectSetupFlag);
									NewOnDevelopProjectForm detailForm = new NewOnDevelopProjectForm();
									detailForm.setTitle("立项");
									detailForm.addDataEditedHandler(new DataEditedHandler(){
										@Override
										public void onDataEdited(DataEditEvent event) {
											commonQuery();
										}
									});
									detailForm.setSearchForm(searchForm);
									detailForm.setRecord(record);
									detailForm.initComponents();
									detailForm.startEdit();
									detailForm.setWidth100();
									detailForm.setHeight100();
									detailForm.centerInPage();
									detailForm.show();
								}
							}
						});
						
					}
				});
			}
		});
		//部门研发的立项
		IButton departmentButton = PermissionControl.createPermissionButton("立项", ERPPermissionStatic.MANAGE_PROJECT_DEPARTMENT_NEW);
		controlLayout.addMember(departmentButton);
		departmentButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download");
					}
					@Override
					public void onSuccess() {
						//初始化信息
						int businessType = 1;//业务类型(默认为商业)
						int projectType = 56;//项目类型(默认为管理项目)
						int projectFlag = 3;//项目标示类型(默认为管理项目)
						int projectSetupFlag = 2;//立项标示(默认为部门立项)
						Map<String,Object> param = new HashMap<>();
						param.put("optType", "onLoadProjectCode");
						param.put("plateId",ClientUtil.getPlateId());
						param.put("businessType",businessType);
						param.put("projectType",projectType);
						param.put("projectFlag",projectFlag);
						//加载项目编码
						DBDataSource.callOperation("EP_OnProjectCommonProcess", "load",param, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if (dsResponse.getStatus() < 0) {
									ClientUtil.displayErrorMessage(dsResponse);
								} else {
									Record record = dsResponse.getData()[0];
									String contractCode = record.getAttribute("projectCode");
									String projectCode = record.getAttribute("code");
									record.setAttribute("contractCode", contractCode);
									record.setAttribute("projectCode", projectCode);
									record.setAttribute("businessType", businessType);
									record.setAttribute("projectType", projectType);
									record.setAttribute("projectFlag", projectFlag);
									record.setAttribute("projectSetupFlag", projectSetupFlag);
									NewOnDevelopProjectForm detailForm = new NewOnDevelopProjectForm();
									detailForm.setTitle("立项");
									detailForm.addDataEditedHandler(new DataEditedHandler(){
										@Override
										public void onDataEdited(DataEditEvent event) {
											commonQuery();
										}
									});
									detailForm.setSearchForm(searchForm);
									detailForm.setRecord(record);
									detailForm.initComponents();
									detailForm.startEdit();
									detailForm.setWidth100();
									detailForm.setHeight100();
									detailForm.centerInPage();
									detailForm.show();
								}
							}
						});
						
					}
				});
			}
		});
		
		IButton operation2Button = PermissionControl.createPermissionButton("修改", ERPPermissionStatic.MANAGE_PROJECT_UPDATE);
		controlLayout.addMember(operation2Button);
		operation2Button.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						if(!resultGrid.anySelected()){ SC.say("请选择一条数据修改"); return;}
						final ListGridRecord selected1 = resultGrid.getSelectedRecord();
						UpdateOnDevelopProjectForm detailForm = new UpdateOnDevelopProjectForm();
						detailForm.setTitle("修改");
						detailForm.addDataEditedHandler(new DataEditedHandler(){
							@Override
							public void onDataEdited(DataEditEvent event) {
								commonQuery();
							}
						});
						detailForm.setSearchForm(searchForm);
						detailForm.setRecord(selected1);
						detailForm.setCurrentPage(getCurrentPage());
						detailForm.initComponents();
						detailForm.startEdit();
						detailForm.setWidth100();
						detailForm.setHeight100();
						detailForm.centerInPage();
						detailForm.show();
						setCurrentPage(detailForm.getCurrentPage());
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
				detail.setTitle("研发项目"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				OnDevelopProjectViewer detailForm = new OnDevelopProjectViewer();
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
	public int getSearchFormHeight() {
		return 60;
	}

	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("projectFlag",3);//只检索研发项目
		criteria.put("addtionalCondition", "order by project_id");
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new OnManageProjectSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSOnDevelopProject.getInstance();
	}

}

