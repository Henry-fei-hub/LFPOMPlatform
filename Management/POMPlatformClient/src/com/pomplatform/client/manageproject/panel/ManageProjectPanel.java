package com.pomplatform.client.manageproject.panel;

import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.SetManageProjectIntegralAssign;
import com.pomplatform.client.manageproject.datasource.DSManageProject;
import com.pomplatform.client.manageproject.form.ManageProjectNew;
import com.pomplatform.client.manageprojectemployee.panel.ManageProjectEmployeePanel;
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
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class ManageProjectPanel extends AbstractSearchPanel {
	private static final Logger __logger = Logger.getLogger("");
	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			ManageProjectPanel cm = new ManageProjectPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ManageProject";
		}

	}

	@Override
	public void initComponents() {
		resultGrid.setShowRowNumbers(true);
		//判断是否有更改权限
        if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_PROJECT_UPDATE_BUTTON)){
            resultGrid.setCanEdit(true);
        }
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
				//判断是否有更改权限
		        if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_PROJECT_UPDATE_BUTTON)){
		            resultGrid.setCanEdit(true);
		        }
			}
		});

		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("manageProjectName");
		idx++;
		fields[idx] = new ListGridField("totalIntegral");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("leftIntegral");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("plateId");
		fields[idx].setCanEdit(false);
		SelectItem plateIdPickTree = new SelectItem	();
		plateIdPickTree.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		fields[idx].setEditorProperties(plateIdPickTree);
		idx++;
		fields[idx] = new ListGridField("remark");
		idx++;
		resultGrid.setFields(fields);
		resultGrid.setShowFilterEditor(true);
		resultGrid.setFilterOnKeypress(false);
		
		IButton newButton = PermissionControl.createPermissionButton("项目新建", ERPPermissionStatic.MANAGE_PROJECT_SAVE_BUTTON);
		controlLayout.addMember(newButton);
		newButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
//				resultGrid.startEditingNew();
				PopupWindow popupWindow = new PopupWindow("项目新建");
                popupWindow.setWidth("50%");
                popupWindow.setHeight("60%");
                popupWindow.centerInPage();
                ManageProjectNew projectBuild = new ManageProjectNew();
                projectBuild.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }
                });
                projectBuild.initComponents(null,0,"",0,"");
                popupWindow.addItem(projectBuild);
                projectBuild.setParentWindow(popupWindow);
                popupWindow.centerInPage();
                popupWindow.show();
			}
		});

		resultGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = resultGrid.getRecord(event.getRowNum()).toMap();
				final int rowNumModified = event.getRowNum();
				DBDataSource.callOperation("ST_ManageProject", "saveOrUpdate", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							DBDataSource.copyRecord(dsResponse.getData()[0], resultGrid.getRecord(rowNumModified));
							resultGrid.redraw();
						}
					}
				});
			}
		});

		IButton removeButton = PermissionControl.createPermissionButton("项目移除", ERPPermissionStatic.MANAGE_PROJECT_DELETE_BUTTON);
		controlLayout.addMember(removeButton);
		removeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
					SC.say("Please select a data to remove.");
				}
				SC.ask("提示","您确定要进行删除吗?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							final ListGridRecord selected = resultGrid.getSelectedRecord();
							//获取项目总积分
			                double totalIntegral = ClientUtil.checkAndGetDoubleValue(selected.getAttribute("totalIntegral"));
			                //获取剩余积分
			                double leftIntegral = ClientUtil.checkAndGetDoubleValue(selected.getAttribute("leftIntegral"));
			                if(totalIntegral > leftIntegral){//表示该项目有下发积分到成员身上，不可删除
			                	SC.say("提示","该项目已补贴积分到成员,不可删除");
			                	return;
			                }
							DBDataSource.callOperation("ST_ManageProject", "delete", selected.toMap(), new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if (dsResponse.getStatus() < 0) {
										ClientUtil.displayErrorMessage(dsResponse);
									} else {
										int indexNum = resultGrid.getRowNum(selected);
										resultGrid.removeData(selected);
										resultGrid.selectSingleRecord(indexNum);
									}
								}
							});
						}
					}
				});
			}
		});
		
		IButton manageProjectIntegralAssignButton = PermissionControl.createPermissionButton("积分发放", ERPPermissionStatic.MANAGE_PROJECT_ASSIGN_INTEGRAL_BUTTON);
        controlLayout.addMember(manageProjectIntegralAssignButton);
        manageProjectIntegralAssignButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                int manageProjectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("manageProjectId"));
                //获取项目名称
                String manageProjectName = selected[0].getAttribute("manageProjectName");
                //获取项目总积分
                double totalIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("totalIntegral"));
                //获取剩余积分
                double leftIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("leftIntegral"));
                final PopupWindow popupWindow = new PopupWindow("积分发放");
                popupWindow.setWidth("70%");
                popupWindow.setHeight("90%");
                popupWindow.centerInPage();
                SetManageProjectIntegralAssign assignIntegral = new SetManageProjectIntegralAssign();
                assignIntegral.addDataEditedHandler(new DataEditedHandler() {
                	@Override
                	public void onDataEdited(DataEditEvent event) {
                		commonQuery();
                	}
                });
                assignIntegral.initComponents(manageProjectId,manageProjectName,totalIntegral,leftIntegral);
                assignIntegral.load(manageProjectId);
                popupWindow.addItem(assignIntegral);
                popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
        				commonQuery();
					}
				});
                assignIntegral.setParentWindow(popupWindow);
                popupWindow.centerInPage();
                popupWindow.show();
            }
        });
        
        IButton manageProjectEmployeeButton = PermissionControl.createPermissionButton("发放人员", ERPPermissionStatic.MANAGE_PROJECT_EMPLOYEE_BUTTON);
        controlLayout.addMember(manageProjectEmployeeButton);
        manageProjectEmployeeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                int manageProjectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("manageProjectId"));
                //获取项目名称
                String manageProjectName = selected[0].getAttribute("manageProjectName");
                PopupWindow pw = new PopupWindow();
                ManageProjectEmployeePanel assignIntegral = new ManageProjectEmployeePanel();
                assignIntegral.setManageProjectId(manageProjectId);
                pw.addItem(assignIntegral.getViewPanel());
                pw.setTitle("项目("+manageProjectName+")成员发放记录");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                assignIntegral.commonQuery();
            }
        });
        
        IButton updateButton = PermissionControl.createPermissionButton("积分追加", ERPPermissionStatic.MANAGE_PROJECT_UPDATE_BUTTON);
		controlLayout.addMember(updateButton);
		updateButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                //获取项目总积分
                double totalIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("totalIntegral"));
                //获取剩余积分
                double leftIntegral = ClientUtil.checkAndGetDoubleValue(selected[0].getAttribute("leftIntegral"));
                int manageProjectId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("manageProjectId"));
                //获取项目名称
                String manageProjectName = selected[0].getAttribute("manageProjectName");
                //获取备注
                String remark = selected[0].getAttribute("remark");
				final PopupWindow popupWindow = new PopupWindow("积分追加");
                popupWindow.setWidth("50%");
                popupWindow.setHeight("60%");
                popupWindow.centerInPage();
                ManageProjectNew projectBuild = new ManageProjectNew();
                projectBuild.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
                    }
                });
                projectBuild.initComponents(manageProjectId,totalIntegral,manageProjectName,leftIntegral,remark);
                popupWindow.addItem(projectBuild);
                popupWindow.addCloseClickHandler(new CloseClickHandler() {
					@Override
					public void onCloseClick(CloseClickEvent event) {
						popupWindow.destroy();
        				commonQuery();
					}
				});
                projectBuild.setParentWindow(popupWindow);
                popupWindow.centerInPage();
                popupWindow.show();
			}
		});
		
		IButton totalButton = new IButton("汇总");
		controlLayout.addMember(totalButton);
		totalButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
                ListGridRecord[] recordList = resultGrid.getRecords();
                int len = recordList.length;
                Record[] records = new Record[len+1];
                if(len>0){
                	double totalIntegral = 0;
                	double leftIntegral = 0;
                	for(int i=0;i<len;i++){
                		if("汇总".equals(recordList[i].getAttribute("manageProjectName"))){//如果已经存在汇总，则不可再进行汇总
                			return;
                		}
                		totalIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("totalIntegral"));
                		leftIntegral += ClientUtil.checkAndGetDoubleValue(recordList[i].getAttribute("leftIntegral"));
                		records[i]=recordList[i];
                	}
                	Record record = new Record();
                	record.setAttribute("manageProjectName", "汇总");
                	record.setAttribute("totalIntegral", totalIntegral);
                	record.setAttribute("leftIntegral", leftIntegral);
                	records[len] = record;
                	resultGrid.setData(records);
                	resultGrid.redraw();
                	resultGrid.setCanEdit(false);
                }
                
			}
		});

		commonQuery();
	}
	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		//如果没有查看所有管理项目，则只检索自己部门下的数据
        if(!ClientUtil.checkIsHavePermission(ERPPermissionStatic.MANAGE_PROJECT_CHECK_ALL_DATA)){
            int plateId = ClientUtil.getPlateId();
            criteria.put("plateId", plateId);
        }
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSManageProject.getInstance();
	}

}
