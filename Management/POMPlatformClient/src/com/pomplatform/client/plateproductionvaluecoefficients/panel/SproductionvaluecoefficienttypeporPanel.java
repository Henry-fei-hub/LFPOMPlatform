package com.pomplatform.client.plateproductionvaluecoefficients.panel;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.plateproductionvaluecoefficients.datasource.DSProductionValueCoefficient;
import com.pomplatform.client.plateproductionvaluecoefficients.datasource.DSSproductionvaluecoefficienttypepor;
import com.pomplatform.client.plateproductionvaluecoefficients.form.NewProductionValueCoefficientTypeForm;
import com.pomplatform.client.plateproductionvaluecoefficients.form.ProductionValueCoefficientTypeViewer;
import com.pomplatform.client.plateproductionvaluecoefficientstype.form.UpdateProductionValueCoefficientTypeForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 产值系数管理首页面
 *
 * @author xiaolong
 */
public class SproductionvaluecoefficienttypeporPanel extends AbstractExpansionRelatedPage implements HasHandlers {

    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            SproductionvaluecoefficienttypeporPanel cm = new SproductionvaluecoefficienttypeporPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "Sproductionvaluecoefficienttypepor";
        }

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
                        NewProductionValueCoefficientTypeForm detailForm = new NewProductionValueCoefficientTypeForm();
                        detailForm.setTitle("新建产值系数");
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
                        detailForm.setWidth("60%");
                        detailForm.setHeight("60%");
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
                        UpdateProductionValueCoefficientTypeForm detailForm = new UpdateProductionValueCoefficientTypeForm();
                        detailForm.setTitle("修改");
                        detailForm.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                DBDataSource.copyRecord(event.getData(), selected1);
                                commonQuery();
                            }
                        });

                        detailForm.setSearchForm(searchForm);
                        detailForm.setRecord(selected1);
                        detailForm.initComponents();
                        detailForm.startEdit();
                        detailForm.setWidth("60%");
                        detailForm.setHeight("60%");
                        detailForm.centerInPage();
                        detailForm.show();
                    }
                });
            }
        });


        IButton removeButton = new IButton("删除");
        controlLayout.addMember(removeButton);
        removeButton.setIcon("[SKIN]/actions/remove.png");
        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    SC.say("请选择一条数据");
                    return;
                }
                SC.ask("提示", "你确认要进行删除吗?", new BooleanCallback() {
                    @Override
                    public void execute(Boolean value) {
                        if (value) {
                            final ListGridRecord selected = resultGrid.getSelectedRecord();
                            int productionValueCoefficientTypeId = selected.getAttributeAsInt("productionValueCoefficientTypeId");
                            __LOGGER.info("获取到的主键id" + productionValueCoefficientTypeId);

                            Map<String, Object> params = new HashMap<>(0);
                            params.put("productionValueCoefficientTypeId", productionValueCoefficientTypeId);
                            params.put("opt_type", "deleteProductionValue");
                            DBDataSource.callOperation("EP_ProductionValueProcessor", params, new DSCallback() {
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
                detail.setTitle("类型维护");
                detail.setWidth("30%");
                detail.setHeight("40%");
                ProductionValueCoefficientTypeViewer detailForm = new ProductionValueCoefficientTypeViewer();
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
        criteria.put("addtionalCondition", "order by production_value_coefficient_type_id");
        return true;
    }


    @Override
    public SearchForm generateSearchForm() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return DSSproductionvaluecoefficienttypepor.getInstance();
    }

    @Override
    public DataSource getChildDataSource() {
        return DSProductionValueCoefficient.getInstance();
    }


    @Override
    public int getSearchFormHeight() {
        return 60;
    }

    @Override
    public void setChildGridOption(ListGrid resultChildGrid) {

        ListGridField[] fields = new ListGridField[12];
        int index = 0;

        fields[index] = new ListGridField("intervalRange");
        fields[index].setShowGridSummary(false);
        index++;

        fields[index] = new ListGridField("coefficient");
        fields[index].setShowGridSummary(false);

        fields[index].setShowGridSummary(false);
        resultChildGrid.setShowGridSummary(true);
        resultChildGrid.setFields(fields);

    }

}

