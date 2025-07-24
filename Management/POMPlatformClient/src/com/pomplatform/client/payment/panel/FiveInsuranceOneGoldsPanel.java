package com.pomplatform.client.payment.panel;

import com.delicacy.client.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.UploadEmpFiveInsuranceOneGolds;
import com.pomplatform.client.payment.datasource.DSFiveInsuranceOneGolds;
import com.pomplatform.client.payment.form.FiveInsuranceOneGoldsSearchForm;
import com.pomplatform.client.payment.form.FiveInsuranceOneGoldsViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 五险一金的界面
 *
 * @author xiaolong
 */
public class FiveInsuranceOneGoldsPanel extends AbstractSearchPanel {

    private static boolean canCheck = false;
    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            FiveInsuranceOneGoldsPanel cm = new FiveInsuranceOneGoldsPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "FiveInsuranceOneGolds";
        }

    }

    @Override
    public void init() {
        super.init();
        __controlPosition = LayoutConstant.RIGHT;
    }


    /**
     * 这里的数据要在导入的时候进行相应的计算，如果数据库中有数据的话就新增一条新的记录进去
     * 应缴公积金合计 total_fund = unit_total_fund（单位）+personal_total_fund（个人）
     * 应缴社保合计 	total_insurance = unit_total_insurance（单位） + personal_total_insurance (个人)
     */

    @Override
    public void initComponents() {

        int idx = 0;
        ListGridField[] fields = new ListGridField[21];
        fields[idx] = new ListGridField("employeeNo");
        idx++;
        fields[idx] = new ListGridField("employeeId");
        idx++;
        fields[idx] = new ListGridField("companyId");
        idx++;
        fields[idx] = new ListGridField("departmentId");
        idx++;
        fields[idx] = new ListGridField("plateId");
        idx++;
        fields[idx] = new ListGridField("year");
        idx++;
        fields[idx] = new ListGridField("month");
        idx++;
        fields[idx] = new ListGridField("totalFund");
        idx++;
        fields[idx] = new ListGridField("unitTotalFund");
        idx++;
        fields[idx] = new ListGridField("personalTotalFund");
        idx++;
        fields[idx] = new ListGridField("totalInsurance");
        idx++;
        fields[idx] = new ListGridField("unitTotalInsurance");
        idx++;
        fields[idx] = new ListGridField("personalTotalInsurance");
        idx++;
        fields[idx] = new ListGridField("unitPension");
        idx++;
        fields[idx] = new ListGridField("unitMedicalInsurance");
        idx++;
        fields[idx] = new ListGridField("unitLargeMedicalInsurance");
        idx++;
        fields[idx] = new ListGridField("unitInjuryInsurance");
        idx++;
        fields[idx] = new ListGridField("unitUnemploymentInsurance");
        idx++;
        fields[idx] = new ListGridField("unitGiveBirthInsurance");
        idx++;
        fields[idx] = new ListGridField("personalPension");
        idx++;
        fields[idx] = new ListGridField("personalMedicalInsurance");
        idx++;
        fields[idx] = new ListGridField("personalLargeMedicalInsurance");
        idx++;
        fields[idx] = new ListGridField("personalSeriousIllInsurance");
        idx++;
        fields[idx] = new ListGridField("personalUnemploymentInsurance");
        idx++;
        fields[idx] = new ListGridField("personalHeating");
        resultGrid.setFields(fields);
        //标题从新写
        resultGrid.setHeaderHeight(60);
        resultGrid.setAutoFitFieldWidths(false);
        resultGrid.setShowGridSummary(true);

        resultGrid.setHeaderSpans(new HeaderSpan[]{
                new HeaderSpan("单位社会保险", new String[]{"unitPension", "unitMedicalInsurance", "unitLargeMedicalInsurance", "unitInjuryInsurance", "unitUnemploymentInsurance", "unitGiveBirthInsurance", "unitDisabilityInsurance"}),
                new HeaderSpan("个人社会保险", new String[]{"personalPension", "personalMedicalInsurance", "personalLargeMedicalInsurance", "personalSeriousIllInsurance", "personalUnemploymentInsurance", "personalHeating"})
        });

        resultGrid.setCanEdit(true);

        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                commonQuery();
            }
        });

        IButton downloadTemplate = new IButton("下载模板");
        controlLayout.addMember(downloadTemplate);
        downloadTemplate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                DownloadFileByUrl.download("/files/empInsurance.xlsx");
            }
        });

        IButton importData = new IButton("导入");
        controlLayout.addMember(importData);
        importData.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        SC.say("failure to download code");
                    }

                    @Override
                    public void onSuccess() {
                        UploadEmpFiveInsuranceOneGolds uploadXls = new UploadEmpFiveInsuranceOneGolds();
                        uploadXls.addDataEditedHandler(new DataEditedHandler() {
                            @Override
                            public void onDataEdited(DataEditEvent event) {
                                commonQuery();
                            }
                        });
                        uploadXls.show();
                    }
                });
            }
        });

        IButton downloadData = new IButton("导出");
        controlLayout.addMember(downloadData);
        downloadData.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Map condition = generateCriteria();
                DBDataSource.downloadFile("DW_OnDownloadInsurance", condition);
            }
        });

        IButton summary = new IButton("公司汇总");
        controlLayout.addMember(summary);
        if (ClientUtil.checkIsHavePermission(BasicPermissionStatic.EMPLOYEE_CHECK_OWN_COMPANY_DATA)) {
            summary.hide();
        }
        summary.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                PopupWindow pw = new PopupWindow();
                InsuranceSummaryDesignPanel panel = new InsuranceSummaryDesignPanel();
                pw.addItem(panel);
                panel.startEdit();
                pw.setTitle("各公司五险一金数据汇总");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
            }
        });

        IButton summaryPlate = new IButton("部门汇总");
        controlLayout.addMember(summaryPlate);
        if (ClientUtil.checkIsHavePermission(BasicPermissionStatic.EMPLOYEE_CHECK_OWN_COMPANY_DATA)) {
            summaryPlate.hide();
        }
        summaryPlate.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                PopupWindow pw = new PopupWindow();
                InsuranceSummaryPlateDesignPanel panel = new InsuranceSummaryPlateDesignPanel();
                pw.addItem(panel);
                panel.startEdit();
                pw.setTitle("各业务部门五险一金数据汇总");
                pw.setWidth100();
                pw.setHeight100();
                pw.centerInPage();
                pw.show();
            }
        });

        IButton delbut = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.DELETE_SOCIAL_AND_FUND);
        controlLayout.addMember(delbut);
        delbut.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (!resultGrid.anySelected()) {
                    PopupWindow pw = new PopupWindow();
                    DeleteFiveInsuranceOneGoldsPanel panel = new DeleteFiveInsuranceOneGoldsPanel();
                    pw.addItem(panel);
                    pw.setTitle("删除五险一金数据");
                    pw.setWidth("30%");
                    pw.setHeight("30%");
                    panel.addDataEditedHandler(new DataEditedHandler() {
                        @Override
                        public void onDataEdited(DataEditEvent event) {
                            commonQuery();
                        }
                    });
                    pw.addCloseClickHandler(new CloseClickHandler() {
                        @Override
                        public void onCloseClick(CloseClickEvent event) {
                            pw.destroy();
                        }
                    });
                    panel.setParentWindow(pw);
                    pw.centerInPage();
                    pw.show();
                } else {
                    Record record = resultGrid.getSelectedRecord();
                    int fiveInsuranceOneGoldId = BaseHelpUtils.getIntValue(record.getAttribute("fiveInsuranceOneGoldId"));
                    if (fiveInsuranceOneGoldId > 0) {
                        SC.ask("确定要删除吗？", new BooleanCallback() {
                            @Override
                            public void execute(Boolean value) {
                                if (value) {
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("fiveInsuranceOneGoldId", fiveInsuranceOneGoldId);
                                    DBDataSource.callOperation("ST_FiveInsuranceOneGold", "delete", map, new DSCallback() {
                                        @Override
                                        public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                            if (dsResponse.getStatus() >= 0) {
                                                SC.say("删除成功");
                                                commonQuery();
                                            }
                                        }
                                    });

                                }
                            }
                        });
                    } else {
                        SC.say("获取主键失败");
                        return;
                    }

                }
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
                detail.setTitle("五险一金");
                detail.setWidth100();
                detail.setHeight100();
                FiveInsuranceOneGoldsViewer detailForm = new FiveInsuranceOneGoldsViewer();
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
        criteria.put("addtionalCondition", "order by five_insurance_one_gold_id");
        return true;
    }


    @Override
    public SearchForm generateSearchForm() {
        return new FiveInsuranceOneGoldsSearchForm();
    }

    @Override
    public DataSource getDataSource() {
        return DSFiveInsuranceOneGolds.getInstance();
    }

    @Override
    public int getSearchFormHeight() {
        return 60;
    }

}

