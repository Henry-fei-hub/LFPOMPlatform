package com.pomplatform.client.projectemployee.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.projectemployee.datasource.DSProjectEmployeeAudit;
import com.pomplatform.client.projectemployee.form.ProjectEmployeeAuditSearchForm;
import com.pomplatform.client.projectemployee.form.ProjectEmployeeAuditViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;


public class ProjectEmployeeAuditPanel extends AbstractSearchPanel
{


	private static final Logger __LOGGER = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;
		@Override
		public Canvas create() {
			ProjectEmployeeAuditPanel cm = new ProjectEmployeeAuditPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectEmployeeAudit";
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
		
		IButton agreeButton = new IButton("同意");
		controlLayout.addMember(agreeButton);
		agreeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						ListGridRecord[] records = resultGrid.getSelectedRecords();
						StringBuilder sb = new StringBuilder();
						for(ListGridRecord r : records) {
							if(sb.length() > 0) {
								sb.append(",");
							}
							sb.append(BaseHelpUtils.getIntValue(r.getAttributeAsObject("projectEmployeeId")));
						}
						Map<String, String> params = new HashMap<>();
						params.put("optType", "agreeProjectEmployee");
						params.put("id", sb.toString());
						DBDataSource.callOperation("EP_ProjectEmployeeProcessor", "find", params, new DSCallback() {
							
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
								if(dsResponse.getStatus() >= 0) {
									commonQuery();
								}else {
									ClientUtil.displayErrorMessage(dsResponse);
								}
							}
						});
					}
				});
			}
		});
		
		IButton disagreeButton = new IButton("不同意");
		controlLayout.addMember(disagreeButton);
		disagreeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say(ClientStaticUtils.WARNING);
					}
					@Override
					public void onSuccess() {
						if (!resultGrid.anySelected()) {
							SC.say("请选择一条数据");
							return;
						}
						SC.confirm("您确定不同意该协作申请吗？", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value) {
									ListGridRecord[] records = resultGrid.getSelectedRecords();
									StringBuilder sb = new StringBuilder();
									for(ListGridRecord r : records) {
										if(sb.length() > 0) {
											sb.append(",");
										}
										sb.append(BaseHelpUtils.getIntValue(r.getAttributeAsObject("projectEmployeeId")));
									}
									Map<String, String> params = new HashMap<>();
									params.put("optType", "disagreeProjectEmployee");
									params.put("id", sb.toString());
									DBDataSource.callOperation("EP_ProjectEmployeeProcessor", "find", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if(dsResponse.getStatus() >= 0) {
												commonQuery();
											}else {
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
								}
							}
						});
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
				detail.setTitle("跨部门协作审批"); 
				detail.setWidth100(); 
				detail.setHeight100(); 
				ProjectEmployeeAuditViewer detailForm = new ProjectEmployeeAuditViewer();
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
		if (!ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_EMPLOYEE_AUDIT_ALL_PLATE)
				&& ClientUtil.checkIsHavePermission(ERPPermissionStatic.PROJECT_EMPLOYEE_AUDIT_MY_PLATE)) {
			criteria.put("plateId", ClientUtil.getPlateId());
		}
		//待定项目成员
		criteria.put("flag", 1);
		return true;
	}


	@Override
	public SearchForm generateSearchForm() {
		return new ProjectEmployeeAuditSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSProjectEmployeeAudit.getInstance();
	}

}

