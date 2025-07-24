package com.pomplatform.client.contractinfo.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

import static com.pomplatform.client.contractinfo.panel.CustomAddSubContractMainTwoDisposePanel.childManageContract;

public class CustomAddChildContractDisposePanel extends AbstractWizadPage {

    private static final Logger logger = Logger.getLogger("");
    public static DelicacyListGrid SourceGrid;
    private boolean isLoadAll;

    private BigDecimal hundred = new BigDecimal(100);
    BigDecimal signingMoneySum = BigDecimal.ZERO;
    BigDecimal outputValueSum = BigDecimal.ZERO;


    public CustomAddChildContractDisposePanel(int flowStatus, CustomAddConsiderationPanel consideration) {
        SourceGrid = new DelicacyListGrid() {
            @Override
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
                if (record.getAttributeAsBoolean("isHistory")) {
                    return "color: red;";
                } else {
                    return super.getCellCSSText(record, rowNum, colNum);
                }
            }
        };
        SourceGrid.setDataSource(DSSubContractInfo.getInstance());

        if (!(flowStatus != 0)) {
            SourceGrid.setCanEdit(true);
        }

        ListGridField[] fields = new ListGridField[14];
        int idx = 0;

        fields[idx] = new ListGridField("subContractId");
        fields[idx].setShowGridSummary(false);
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("parentId");
        fields[idx].setShowGridSummary(false);
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("subContractCode");
        idx++;
        fields[idx] = new ListGridField("subContractName");
        idx++;
        fields[idx] = new ListGridField("projectCode");
        fields[idx].setHidden(true);
//		idx++;
//		fields[idx] = new ListGridField("businessType");
//		fields[idx].setShowGridSummary(false);
//		idx++;
//		fields[idx] = new ListGridField("projectType");
//		fields[idx].addChangedHandler(new ChangedHandler() {
//			
//			@Override
//			public void onChanged(ChangedEvent event) {
//				int thisVal = BaseHelpUtils.getIntValue(event.getValue());
//				DynamicForm df = event.getForm();
//				if(thisVal == 16){
//					df.getField("projectType").setValue("");
//					SC.say("已有项目管理费");
//				}
//				if(thisVal == 27){
//					df.getField("projectType").setValue("");
//					SC.say("不可在此模块设定物料订单");
//				}
//			}
//		});
//		fields[idx].setShowGridSummary(false);
        idx++;
        fields[idx] = new ListGridField("departmentId");
        fields[idx].setShowGridSummary(false);
        fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
//		idx++;
//		fields[idx] = new ListGridField("businessLine","条线");
//		fields[idx].setShowGridSummary(false);
//		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));
//		idx++;
//		fields[idx] = new ListGridField("commonArea");
//		fields[idx].setShowGridSummary(false);
//		idx++;	
//		fields[idx] = new ListGridField("logisticsArea");
//		fields[idx].setShowGridSummary(false);
//		idx++;
//		fields[idx] = new ListGridField("designArea");
//		fields[idx].setShowGridSummary(false);
        idx++;
        fields[idx] = new ListGridField("moneySum", "合同金额");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("createTime");
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("isHistory");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("percentage");//子订单占比
        fields[idx].setCanEdit(true);
        fields[idx].setWidth("*");
        fields[idx].addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                SC.debugger();
                BigDecimal sheetTotalIntegral = BigDecimal.ZERO;
                BigDecimal moneySum = BigDecimal.ZERO;
                BigDecimal percentage = BigDecimal.ZERO;
                int i = 0;
                for (Record r : SourceGrid.getRecords()) {
                    if(event.getRowNum()==i++){
                        continue;
                    }
                    sheetTotalIntegral = sheetTotalIntegral.add(BaseHelpUtils.getBigDecimalValue(r.getAttribute("sheetTotalIntegral")));
                    moneySum = moneySum.add(BaseHelpUtils.getBigDecimalValue(r.getAttribute("moneySum")));
                    percentage = percentage.add(BaseHelpUtils.getBigDecimalValue(r.getAttribute("percentage")));
                }
                //判断占比(输入的值)
                BigDecimal thisVal = BaseHelpUtils.getBigDecimalValue(event.getValue());
                //最大差值，填写的占比不得超过这个value
                BigDecimal diffValue = hundred.subtract(percentage).setScale(2, BigDecimal.ROUND_HALF_DOWN);

                if (thisVal.compareTo(diffValue) > 0) {
                    DynamicForm df = event.getForm();
                    df.getField("percentage").setValue(BigDecimal.ZERO);
                    df.getField("moneySum").setValue(BigDecimal.ZERO);
                    df.getField("sheetTotalIntegral").setValue(BigDecimal.ZERO);
//								df.getField("sheetIntegral").setValue(BigDecimal.ZERO);
                    SC.say("提示", "占比最大值不能超过:" + diffValue);
                } else if (thisVal.compareTo(diffValue) == 0) {
                    DynamicForm df = event.getForm();
                    df.getField("percentage").setValue(thisVal);
                    df.getField("moneySum").setValue(signingMoneySum.subtract(moneySum));
                    df.getField("sheetTotalIntegral").setValue(outputValueSum.subtract(sheetTotalIntegral));
//								df.getField("sheetIntegral").setValue(outputValueSum.subtract(sheetTotalIntegral));
                } else {
                    DynamicForm df = event.getForm();
                    df.getField("percentage").setValue(thisVal);
                    BigDecimal p = thisVal.divide(hundred).setScale(4);
                    BigDecimal signingMoney = signingMoneySum.multiply(p).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    BigDecimal outputValue = outputValueSum.multiply(p).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    df.getField("moneySum").setValue(signingMoney);
                    df.getField("sheetTotalIntegral").setValue(outputValue);
//								df.getField("sheetIntegral").setValue(outputValue);
                }
            }
        });
        idx++;
        fields[idx] = new ListGridField("sheetTotalIntegral");
        fields[idx].setCanEdit(false);
        idx++;
//		fields[idx] = new ListGridField("sheetIntegral");
//		fields[idx].setCanEdit(false);
//		fields[idx].setHidden(true);
//		idx++;
        fields[idx] = new ListGridField("remark", "备注");
        fields[idx].setWidth(200);
        SourceGrid.setFields(fields);
//		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceGrid.setShowGridSummary(true);

        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setWidth100();

        SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                SC.debugger();
                ListGridRecord[] records1 = SourceGrid.getRecords();
                ListGridRecord[] records2 = childManageContract.SourceGrid.getRecords();
                Record rowRecord = SourceGrid.getRecord(event.getRowNum());
                List<ListGridRecord> list = new ArrayList<>();
                for (ListGridRecord record : records1){
                    if((!BaseHelpUtils.isNullOrEmpty(record.getAttribute("subContractCode")))&&(rowRecord!=record)){
                        list.add(record);
                    }
                }
                for (ListGridRecord record : records2){
                    if((!BaseHelpUtils.isNullOrEmpty(record.getAttribute("subContractCode")))){
                        list.add(record);
                    }
                }
                Map params = rowRecord.toMap();
                params.put("opt_type", "updateChildContart");
                params.put("contractId", contractId);
                params.put("records", list);
                params.put("projectCode", rowRecord.getAttributeAsString("projectCode"));
                params.put("departmentId", rowRecord.getAttributeAsString("departmentId"));
                // 在处于可以修改承接部门时 可以创建子合同编号
                if (rowRecord.getAttributeAsBoolean("isHistory")) {
                    params.put("createSubCode", "updateHistory");
                } else {
                    params.put("createSubCode", "createSubCode");
                }

                final int rowNumModified = event.getRowNum();
                Record record = SourceGrid.getRecord(rowNumModified);

                //检验编辑的是不是汇总的行，不给编辑
                String tempData = (String) params.get("subContractCode");
                if ("总计".equals(tempData)) {
                    SC.say("总计这行数据不能编辑");
                    startEdit();
                    return;
                }

                DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        } else {
                            SC.debugger();
                            consideration.startEdit();
                            DBDataSource.copyRecord(dsResponse.getData()[0], SourceGrid.getRecord(rowNumModified));
                            SourceGrid.redraw();
                        }
                    }
                });
            }
        });
        SearchSourceLayout.setHeight100();
        SearchSourceLayout.setLayoutTopMargin(10);
        SearchSourceLayout.setLayoutRightMargin(5);
        SearchSourceLayout.setMembersMargin(10);
        SearchSourceLayout.addMember(SourceGrid);
        addMember(SearchSourceLayout);
    }

    @Override
    public void startEdit() {
        if (contractId > 0) {
            Map<String, Object> condition = new HashMap<>();
            condition.put("opt_type", "getOrderInfoChild");
            condition.put("contractId", contractId);
            condition.put("orderInfoId", orderInfoId);
            condition.put("isLoadAll", isLoadAll);
            DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "", condition, new DSCallback() {
                @SuppressWarnings("unchecked")
                @Override
                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    if (dsResponse.getStatus() >= 0) {
                        Record[] records = dsResponse.getData();
                        SourceGrid.setData(records);

//                        CustomAddSubContractMainTwoPanel.onLoadSubContractRemark(contractId);
                    } else {
                        ClientUtil.displayErrorMessage(dsResponse);
                    }
                }
            });

            Map<String, Object> map = new HashMap<>();
            map.put("opt_type", "onLoadMainProjectBusinessTypeByContract");
            map.put("contractId", contractId);
            DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "find", map, new DSCallback() {
                @Override
                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    if (dsResponse.getStatus() >= 0 && dsResponse.getData().length > 0) {
                        Record r = dsResponse.getData()[0];
                        //合同金额
                        signingMoneySum = BaseHelpUtils.getBigDecimalValue(r.getAttribute("signingMoneySum"));
                        //产值
                        outputValueSum = BaseHelpUtils.getBigDecimalValue(r.getAttribute("outputValueSum"));
                    }
                }
            });
        } else {
            SC.say("提示", "合同信息contractid不能为空");
        }
    }

    @Override
    public Set<String> getItemNames() {
        Set<String> res = new HashSet<>();
        res.add("customAddConsideration");
        return res;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean checkData() {
        return false;
    }

    private Integer contractId;// 主合同编号

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    private Integer orderInfoId;// 主表编号

    public Integer getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Integer orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    @Override
    public Map getValuesAsMap() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isLoadAll() {
        return isLoadAll;
    }

    public void setLoadAll(boolean isLoadAll) {
        this.isLoadAll = isLoadAll;
    }
}