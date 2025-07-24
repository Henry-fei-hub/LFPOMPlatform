package com.pomplatform.client.payment.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.ui.*;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.ValueCallback;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.util.SC;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.payment.datasource.DSFiveInsuranceOneGoldsPaymentBase;
import com.pomplatform.client.payment.form.FiveInsuranceOneGoldsPaymentBaseSearchForm;
import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.form.SearchForm;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**五险一金缴费基数界面
 * @author xiaolong
 */
public class FiveInsuranceOneGoldsPaymentBasePanel extends AbstractSearchPanel {

    private static boolean canCheck = false;
    private static final Logger __LOGGER = Logger.getLogger("");

    public static class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            FiveInsuranceOneGoldsPaymentBasePanel cm = new FiveInsuranceOneGoldsPaymentBasePanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "FiveInsuranceOneGoldsPaymentBase";
        }

    }

    @Override
    public void init() {
        super.init();
        canCheck = false;
        __controlPosition = LayoutConstant.RIGHT;
    }

    @Override
    public void initComponents() {
        resultGrid.setHeaderHeight(60);
        resultGrid.setHeaderSpans(new HeaderSpan[]{
                new HeaderSpan("公积金", new String[]{"accumulationFundGolePaymentBase", "accumulationFundGoleCompanyPaymentRatio", "accumulationFundGoleIndividualPaymentRatio"}),
                new HeaderSpan("养老保险", new String[]{"unitPensionPaymentBase", "unitPensionPaymentRatio", "personalPensionPaymentRatio"}),
                new HeaderSpan("医疗保险", new String[]{"unitMedicalInsurancePaymentBase", "unitMedicalInsurancePaymentRatio", "personalMedicalInsurancePaymentRatio"}),
                new HeaderSpan("失业保险", new String[]{"unitUnemploymentInsurancePaymentBase", "unitUnemploymentInsurancePaymentRatio", "personalUnemploymentInsurancePaymentRatio"}),
                new HeaderSpan("工伤保险", new String[]{"unitInjuryInsuranceBase", "unitInjuryInsuranceRatio"}),
                new HeaderSpan("生育保险", new String[]{"unitGiveBirthInsurancePaymentBase", "unitGiveBirthInsurancePaymentRatio"}),
        });

        IButton refreshButton = new IButton("刷新");
        controlLayout.addMember(refreshButton);
        refreshButton.setIcon("[SKIN]/actions/refresh.png");
        refreshButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!canCheck) {
                    commonSelect();
                }else {
                    commonQuery();
                }
            }
        });

        IButton downloadData = new IButton("导出");
        controlLayout.addMember(downloadData);
        downloadData.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (!canCheck) {
                    commonSelect();
                } else {
                    Map condition = generateCriteria();
                    DBDataSource.downloadFile("DW_FiveInsuranceOneGoldsPaymentBase", condition);
                }
            }
        });


        IButton delbut = PermissionControl.createPermissionButton("删除", ERPPermissionStatic.DELETE_SOCIAL_AND_FUND);
        controlLayout.addMember(delbut);
        delbut.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!canCheck) {
                    commonQuery();
                } else {
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
                                                    commonSelect();
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
            }
        });

        commonSelect();
    }


    /**
     * 密码弹出框的公共方法
     */
    public void commonSelect() {

        if (!canCheck) {
            SC.askforValue("提示", "您需输入正确的解锁密码方可查看数据", new ValueCallback() {
                @Override
                public void execute(String value) {
                    if (BaseHelpUtils.isNullOrEmpty(value)) {
                        SC.say("提示", "请输入正确的解锁密码");
                    } else {
                        Map<String, Object> params = new HashMap<>(0);
                        params.put("password", BaseHelpUtils.getString(value));
                        params.put("optType", "onComparePassword");
                        DBDataSource.callOperation("EP_OnPaymentManageProcess", "find", params, new DSCallback() {
                            @Override
                            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                                if (dsResponse.getStatus() < 0) {
                                    SC.say("提示", "密码匹配错误");
                                } else {
                                    canCheck = true;
                                    commonQuery();
                                }
                            }
                        });
                    }
                }
            });
            return;
        } else {
            commonQuery();
        }
    }

    @Override
    public boolean checkSearchCriteria(Map criteria) {
        criteria.put("addtionalCondition", "order by five_insurance_one_gold_id");
        return true;
    }

    //上面的表单
    @Override
    public SearchForm generateSearchForm() {
        return new FiveInsuranceOneGoldsPaymentBaseSearchForm();
    }

    //下面的表格信息
    @Override
    public DataSource getDataSource() {
        return DSFiveInsuranceOneGoldsPaymentBase.getInstance();
    }


}

