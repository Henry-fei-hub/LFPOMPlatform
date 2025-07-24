package com.pomplatform.client.projectcost.panel;

import com.delicacy.client.MapUtils;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.pomplatform.client.projectcost.datasource.DSSprojectcostpcor;
import com.pomplatform.client.projectcost.form.SprojectcostpcorSearchForm;
import com.pomplatform.client.projectcost.form.SprojectcostpcorViewer;
import com.pomplatform.client.projectcost.form.NewSprojectcostpcorForm;
import com.pomplatform.client.projectcost.form.UpdateSprojectcostpcorForm;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.form.SearchForm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SprojectcostpcorPanel extends AbstractSearchPanel {

    private static Logger __logger = Logger.getLogger("");

	public SprojectcostpcorPanel(){
	}
    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    /**
     * @return the budget
     */
    public int getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

    public static class Factory implements PanelFactory {

        private String id;

        @Override
        public Canvas create() {
            SprojectcostpcorPanel cm = new SprojectcostpcorPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sprojectcostpcor";
        }

    }

    //项目id
    private int projectID = 0;
    //项目预算经费
    private int budget = 0;

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("projectId", getProjectID());
        return true;
    }

    @Override
    public void initComponents() {
        resultGrid.setShowRowNumbers(true);
        resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                showDetail();
            }
        });
        IButton operation1Button = new IButton("查看详情");
        controlLayout.addMember(operation1Button);
        operation1Button.setIcon("[SKIN]/actions/view.png");
        operation1Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                showDetail();
            }
        });
        IButton operation2Button = new IButton("新增费用");
        controlLayout.addMember(operation2Button);
        operation2Button.setIcon("[SKIN]/actions/add.png");
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //获取当前项目已经申报的项目经费
                int totalCost = 0;
                ListGridRecord[] records = resultGrid.getRecords();
                if (records != null && records.length > 0) {
                    for (Record e : records) {
                        totalCost += ClientUtil.checkAndGetIntValue(e.getAttribute("amount"));
                    }
                }
                if (totalCost > budget) {
                    SC.confirm("提示", "项目申报经费已超出项目预算总经费,超出经费将由团队成员等比例分摊，项目预算总经费为:" + budget + ",已申报的经费为:" + totalCost + ",您确定要继续申报吗？", new BooleanCallback() {
                        @Override
                        public void execute(Boolean r) {
                            if (r) {
                                showAddCost();
                            }
                        }
                    });
                } else {
                    showAddCost();
                }
            }
        });
        IButton operation3Button = new IButton("修改费用");
        controlLayout.addMember(operation3Button);
        operation3Button.setIcon("[SKIN]/actions/edit.png");
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
                        UpdateSprojectcostpcorForm detailForm = new UpdateSprojectcostpcorForm();
                        detailForm.setTitle("修改费用");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                RecordList list = resultGrid.getDataAsRecordList();
                                Map params = new HashMap();
                                params.put("projectCostId", event.getData().getAttribute("projectCostId"));
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
        IButton operation4Button = new IButton("删除费用");
        controlLayout.addMember(operation4Button);
        operation4Button.setIcon("[SKIN]/actions/cancel.png");
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
                        Map map = selected[0].toMap();
                        String projectCostId = selected[0].getAttribute("projectCostId");
                        Map param = new LinkedHashMap();
                        param.put("projectCostId", projectCostId);
                        String message = MapUtils.toJSON(param);
                        //删除方法
                        DBDataSource.callOperation("EP_ProjectCostDelete", "delete", message, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() >= 0) {
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
    }

    public void showAddCost() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                SC.say("failure to download");
            }

            @Override
            public void onSuccess() {
                NewSprojectcostpcorForm detailForm = new NewSprojectcostpcorForm();
                detailForm.setTitle("新增费用");
                detailForm.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        commonQuery();
//                        RecordList list = resultGrid.getDataAsRecordList();
//                        RecordList newList = new RecordList();
//                        newList.addList(list.getRange(0, list.getLength()));
//                        newList.add(event.getData());
//                        resultGrid.setData(newList);
//                        resultGrid.selectSingleRecord(newList.getLength() - 1);
                    }
                });
                detailForm.setSearchForm(searchForm);
                detailForm.initComponents(getProjectID());
                detailForm.startEdit();
                detailForm.setWidth100();
                detailForm.setHeight100();
                detailForm.centerInPage();
                detailForm.show();
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
                detail.setTitle("项目费用");
                detail.setWidth100();
                detail.setHeight100();
                SprojectcostpcorViewer detailForm = new SprojectcostpcorViewer();
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
        return new SprojectcostpcorSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSSprojectcostpcor.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 50;
    }

}
