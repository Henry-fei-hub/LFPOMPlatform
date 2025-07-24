package com.pomplatform.client.designer.panel;

import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Cookies;
import com.pomplatform.client.designer.datasource.DSDesignerBaseInfo;
import com.pomplatform.client.designer.form.DesignerBaseInfoViewer;
import com.pomplatform.client.designer.form.UpdateDesignerForm;
import com.pomplatform.client.employeenew.form.SemployeeUploadImgForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.Map;

public class DesignerBaseInfoPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            DesignerBaseInfoPanel cm = new DesignerBaseInfoPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "SemployeeNew";
        }

    }

    @Override
    public void initComponents() {
        
//        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
//            @Override
//            public void onDoubleClick(DoubleClickEvent event) {
//                showDetail();
//            }
//        });
//        IButton operation1Button = new IButton("查看详情");
//        controlLayout.addMember(operation1Button);
//        operation1Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                showDetail();
//            }
//        });
        UpdateDesignerForm detailForm = new UpdateDesignerForm();
                        detailForm.setTitle("修改资料");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("employeeId", event.getData().getAttribute("employeeId"));
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
//                        detailForm.setRecord(selected[0]);
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth100();
                        detailForm.setHeight100();
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
//        controlLayout.addMember(detailForm);
//        IButton operation3Button = new IButton("职员修改");
//        controlLayout.addMember(operation3Button);
//        operation3Button.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                        UpdateDesignerForm detailForm = new UpdateDesignerForm();
//                        detailForm.setTitle("修改资料");
//                        detailForm.addDataEditedHandler(new DataEditedHandler() {
//                            @Override
//                            public void onDataEdited(DataEditEvent event) {
//                                RecordList list = resultGrid.getDataAsRecordList();
//                                Map params = new HashMap();
//                                params.put("employeeId", event.getData().getAttribute("employeeId"));
//                                int index = list.findIndex(params);
//                                if (index != -1) {
//                                    RecordList newList = new RecordList();
//                                    if (index > 0) {
//                                        newList.addList(list.getRange(0, index));
//                                    }
//                                    newList.add(event.getData());
//                                    if (index < list.getLength() - 1) {
//                                        newList.addList(list.getRange(index + 1, list.getLength()));
//                                    }
//                                    resultGrid.setData(newList);
//                                    resultGrid.selectSingleRecord(index);
//                                }
//                            }
//                        });
//                        detailForm.setSearchForm(searchForm);
//                        detailForm.setRecord(selected[0]);
//                        detailForm.setCurrentPage(getCurrentPage());
//                        detailForm.initComponents();
//                        detailForm.startEdit();
//                        detailForm.setWidth100();
//                        detailForm.setHeight100();
//                        detailForm.centerInPage();
//                        detailForm.show();
//                        setCurrentPage(detailForm.getCurrentPage());
//                    }
//                });
//            }
//        });

//        IButton imgButton = new IButton("添加头像");
//        controlLayout.addMember(imgButton);
//        imgButton.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                GWT.runAsync(new RunAsyncCallback() {
//                    @Override
//                    public void onFailure(Throwable reason) {
//                        SC.say("failure to download code");
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        if (!resultGrid.anySelected()) {
//                            SC.say("请选择一条数据修改");
//                            return;
//                        }
//                        ListGridRecord[] selected = resultGrid.getSelectedRecords();
//                        String employeeId = selected[0].getAttribute("employeeId");
//                        String employeeNo = selected[0].getAttribute("employeeNo");
//                        String employeeName = selected[0].getAttribute("employeeName");
//                        SemployeeUploadImgForm uploadImg = new SemployeeUploadImgForm(employeeId, employeeNo, employeeName);
//                        uploadImg.addDataEditedHandler(new DataEditedHandler(){
//                            @Override
//                            public void onDataEdited(DataEditEvent event) {
//                                commonQuery();
//                            }
//                        });
//                        uploadImg.show();
//                    }
//                });
//            }
//        });
        commonQuery();
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("employeeId", Cookies.getCookie(ClientUtil.OPRERATORID_COOKIE));
        return true;
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
                detail.setTitle("职员管理");
                detail.setWidth100();
                detail.setHeight100();
                DesignerBaseInfoViewer detailForm = new DesignerBaseInfoViewer();
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
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSDesignerBaseInfo.getInstance();
    }

}
