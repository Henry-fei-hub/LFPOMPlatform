package com.pomplatform.client.plateproductionvaluecoefficients.panel;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.plateproductionvaluecoefficients.datasource.DSProductionValueCoefficient;
import com.pomplatform.client.plateproductionvaluecoefficients.form.NewProductionValueCoefficientForm;
import com.pomplatform.client.plateproductionvaluecoefficients.form.ProductionValueCoefficientTypeSearchForm;
import com.pomplatform.client.plateproductionvaluecoefficients.form.ProductionValueCoefficientViewer;
import com.pomplatform.client.plateproductionvaluecoefficients.form.UpdateProductionValueCoefficientForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.Map;
import java.util.logging.Logger;


/**
 * 产值系数管理界面
 */
public class ProductionValueCoefficientPanel extends AbstractSearchPanel {


    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            ProductionValueCoefficientPanel cm = new ProductionValueCoefficientPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "ProductionValueCoefficient";
        }

    }
    @Override
    public void init() {
        super.init();
        resultGrid.setAutoFitFieldWidths(false);
        __controlPosition = LayoutConstant.RIGHT;
    }

    @Override
    public void initComponents() {
        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
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

        IButton operation2Button = new IButton("新建");
        controlLayout.addMember(operation2Button);
        operation2Button.setIcon("[SKIN]/actions/add.png");
        operation2Button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download");
                    }

                    @Override
                    public void onSuccess() {

                        NewProductionValueCoefficientForm detailForm = new NewProductionValueCoefficientForm();
                        detailForm.setTitle("新建");
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
                        detailForm.setWidth("40%");
                        detailForm.setHeight("50%");
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });
        IButton operation3Button = new IButton("修改");
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
                        final ListGridRecord selected1 = resultGrid.getSelectedRecord();
                        UpdateProductionValueCoefficientForm detailForm = new UpdateProductionValueCoefficientForm();
                        detailForm.setTitle("修改");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                DBDataSource.copyRecord(event.getData(), selected1);
                            }
                        });
                        detailForm.setSearchForm(searchForm);
                        detailForm.setRecord(selected1);
                        detailForm.setCurrentPage(getCurrentPage());
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth("20%");
                        detailForm.setHeight("30%");
                        detailForm.centerInPage();
                        detailForm.show();
                        setCurrentPage(detailForm.getCurrentPage());
                    }
                });
            }
        });

        IButton removeButton = new IButton("删除");
        controlLayout.addMember(removeButton);
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        if (!resultGrid.anySelected()) {
                            SC.say("请选择一条数据删除");
                            return;
                        }
                        SC.confirm("提示", "您确定删除该条记录吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean aBoolean) {

                                if (aBoolean) {
                                    final ListGridRecord selected = resultGrid.getSelectedRecord();
                                    selected.setAttribute("deleteFlag", 1);
                                    DBDataSource.callOperation("ST_ProductionValueCoefficient", "delete", selected.toMap(), new DSCallback() {
                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if (dsResponse.getStatus() >= 0) {
                                                int indexNum = resultGrid.getRowNum(selected);
                                                resultGrid.removeData(selected);
                                                resultGrid.selectSingleRecord(indexNum);
                                                SC.say("删除成功");
                                            } else {
                                                Map errors = dsResponse.getErrors();
                                                SC.say("delete failure" + errors);
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
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                GenericViewWindow detail = new GenericViewWindow();
                detail.setTitle("产值系数管理界面详情页");
                detail.setWidth100();
                detail.setHeight100();
                ProductionValueCoefficientViewer detailForm = new ProductionValueCoefficientViewer();
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
        criteria.put("addtionalCondition", "order by production_value_coefficient_id");
        return true;
    }


    @Override
    public SearchForm generateSearchForm() {
        return new ProductionValueCoefficientTypeSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSProductionValueCoefficient.getInstance();
    }


    @Override
    public int getSearchFormHeight() {
        return 60;
    }
}

