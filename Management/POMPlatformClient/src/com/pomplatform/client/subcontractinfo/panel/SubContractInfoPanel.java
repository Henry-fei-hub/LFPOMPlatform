package com.pomplatform.client.subcontractinfo.panel;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.DownloadFileByUrl;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.common.UploadSubContract;
import com.pomplatform.client.designconsiderationinfo.panel.DesignConsiderationInfoPanel;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.pomplatform.client.subcontractinfo.form.SubContractInfoSearchForm;
import com.pomplatform.client.subcontractinfo.form.SubContractInfoViewer;
import com.pomplatform.client.subcontractinfo.form.UpdateSubContractInfoForm;
import com.smartgwt.client.data.DataSource;
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

public class SubContractInfoPanel extends AbstractSearchPanel {

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SubContractInfoPanel cm = new SubContractInfoPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "SubContractInfo";
        }

    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        commonQuery();
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                ListGridRecord[] selected = resultGrid.getSelectedRecords();
                String subContractId = selected[0].getAttribute("subContractId");
                PopupWindow pw = new PopupWindow("设计要素");
                DesignConsiderationInfoPanel panel = new DesignConsiderationInfoPanel();
                panel.setSubContractId(ClientUtil.checkAndGetIntValue(subContractId));
                pw.addItem(panel.getViewPanel());
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
                panel.commonQuery();
            }
        });
        IButton operation1Button =  new IButton("修改子合同");
        		//PermissionControl.createPermissionButton("修改子合同", ERPPermissionStatic.CONTRACT_INFO_UPDATE_SON_CONTRACTS_BUTTON);
        controlLayout.addMember(operation1Button);
        operation1Button.addClickHandler(new ClickHandler() {
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
                        UpdateSubContractInfoForm detailForm = new UpdateSubContractInfoForm();
                        detailForm.setTitle("修改子合同");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("subContractId", event.getData().getAttribute("subContractId"));
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
        IButton operation2Button = new IButton("下载模板");
        		//PermissionControl.createPermissionButton("下载模板", ERPPermissionStatic.CONTRACT_INFO_DOWNLOAD_PLATE_BUTTON);
        controlLayout.addMember(operation2Button);
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	DownloadFileByUrl.download("/files/subContract.xls");
            }
        });

        IButton operation3Button = new IButton("导入子合同");
        		//PermissionControl.createPermissionButton("导入子合同", ERPPermissionStatic.CONTRACT_INFO_UPLOAD_SON_CONTRACTS_BUTTON);
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
                        UploadSubContract a = new UploadSubContract(getContractId());
                        a.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
//                                        SC.say("提示","操作成功");
                                commonQuery();
                            }
                        });
                        a.show();
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
                detail.setTitle("子合同详情");
                detail.setWidth100();
                detail.setHeight100();
                SubContractInfoViewer detailForm = new SubContractInfoViewer();
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
        return new SubContractInfoSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSubContractInfo.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 63;
    }

    private int contractId = 0;

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("parentId", contractId);
        return true;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getContractId() {
        return contractId;
    }

}
