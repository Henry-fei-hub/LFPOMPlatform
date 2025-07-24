package com.pomplatform.client.departmentmanagerproject.panel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.departmentmanagerproject.datasource.DSMDepartmentManagerProject;
import com.pomplatform.client.departmentmanagerproject.form.MDepartmentManagerProjectSearchForm;
import com.pomplatform.client.myinvite.panel.MprojectTeamPanel;
import com.pomplatform.client.project.form.NewSprojectccporForm;
import com.pomplatform.client.project.form.UpdateSprojectccporForm;
import com.pomplatform.client.project.panel.SprojectccporPanelNew;
import com.pomplatform.client.projectview.form.SprojectViewViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MDepartmentManagerProjectPanel extends AbstractSearchPanel {

    private static Logger __logger = Logger.getLogger("");

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            MDepartmentManagerProjectPanel cm = new MDepartmentManagerProjectPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MDepartmentManagerProject";
        }

    }

    @Override
    public void initComponents() {
		//默认执行一次查询
        commonQuery();
	resultGrid.setShowRowNumbers(true);	
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
//        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });

        final IButton projectBuildButton = new IButton("项目立项");
        controlLayout.addMember(projectBuildButton);
        projectBuildButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {
                        NewSprojectccporForm detailForm = new NewSprojectccporForm();
                        detailForm.setTitle("项目立项");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                RecordList newList = new RecordList();
                                newList.addList(list.getRange(0, list.getLength()));
                                newList.add(event.getData());
                                resultGrid.setData(newList);
                                resultGrid.selectSingleRecord(newList.getLength() - 1);
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth100();
                        detailForm.setHeight100();
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });
        final IButton operation3Button = new IButton("项目修改");
        controlLayout.addMember(operation3Button);
        operation3Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        UpdateSprojectccporForm detailForm = new UpdateSprojectccporForm();
                        detailForm.setTitle("项目修改");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("projectId", event.getData().getAttribute("projectId"));
                                int index = list.findIndex(params);
                                if (index != -1) {
                                    RecordList newList = new RecordList();
                                    if (index > 0) {
                                        newList.addList(list.getRange(0, index));
                                    }
                                    newList.add(event.getData());
                                    if (index < list.getLength() - 1) {
                                        newList.addList(list.getRange(index + 1, list.getLength()));
                                    }
                                    resultGrid.setData(newList);
                                    resultGrid.selectSingleRecord(index);
                                }
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.setRecord(selected[0]);
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

        final IButton operation4Button = new IButton("项目移除");
        controlLayout.addMember(operation4Button);
        operation4Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        String projectId = selected[0].getAttribute("projectId");
                        Map param = new LinkedHashMap();
                        param.put("projectId", projectId);
                        String message = MapUtils.toJSON(param);
                        //删除方法
                        DBDataSource.callOperation("EP_ProjectDelete", "delete", message, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0) {
                                    SC.say("操作成功");
                                    //执行成功后重新执行查询，刷新表格数据
                                    commonQuery();
                                } else {
                                    Map errors = dsResponse.getErrors();
                                    SC.say("删除失败" + errors);
                                }
                            }
                        });
                    }
                });
            }
        });

        final IButton integralButton = new IButton("积分核算");
//        controlLayout.addMember(integralButton);
        integralButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        String message = MapUtils.toJSON(MapUtils.convertRecordToMap(resultGrid.getDataSource(), resultGrid.getSelectedRecord()));
                        //计算项目积分
                        DBDataSource.callOperation("EP_ProjectIntegralExcel", "excel", message, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0) {
                                    SC.say("操作成功");
                                    //执行成功后重新执行查询，刷新表格数据
                                    commonQuery();
                                } else {
                                    Map errors = dsResponse.getErrors();
                                    SC.say("操作失败" + errors);
                                }
                            }
                        });
                    }
                });
            }
        });

        IButton operation2Button = new IButton("查看队员");
        controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        String projectId = selected[0].getAttribute("projectId");
                        String projectName = selected[0].getAttribute("projectName");
                        PopupWindow pw = new PopupWindow();
                        MprojectTeamPanel myselfProject = new MprojectTeamPanel();
                        myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(myselfProject.getViewPanel());
                        pw.setTitle(projectName + "项目组成员");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
                    }
                });
            }
        });

        final IButton operation13Button = new IButton("项目时间表");
        controlLayout.addMember(operation13Button);
        operation13Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据修改");
                            return;
                        }
                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
                        String projectId = selected[0].getAttribute("projectId");
                        PopupWindow pw = new PopupWindow();
                        SprojectccporPanelNew myselfProject = new SprojectccporPanelNew();
                        myselfProject.setProjectId(ClientUtil.checkAndGetIntValue(projectId));
                        pw.addItem(myselfProject.getViewPanel());
                        pw.setTitle("项目时间表");
                        pw.setWidth100();
                        pw.setHeight100();
                        pw.centerInPage();
                        pw.show();
                        myselfProject.commonQuery();
                    }
                });
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
                detail.setTitle("板块运营负责人项目");
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
        });
    }

    @Override
    public int getSearchFormHeight() {
        return 50;
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("employeeId", Cookies.getCookie(ClientUtil.OPRERATORID_COOKIE));
        return true;
    }

    @Override
    public SearchForm generateSearchForm() {
        return new MDepartmentManagerProjectSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSMDepartmentManagerProject.getInstance();
    }
	
	@Override
	public void afterDataReceived(Record[] data){
		String noShowSummaryFields = "projectId,contractCode,contractName,customerName,officeType,departmentId,electromechanicalType,designPhase,oldProjectDiscount,projectType,projectCode,projectName,planStartDate,planEndDate,startDate,endDate,status,projectProgress,projectManageId,projectManageName,projectSize,projectDescription,auditReason,projectLevel,plateId";
		ClientUtil.setNoShowSummaryFields(resultGrid, noShowSummaryFields);
	}

}
