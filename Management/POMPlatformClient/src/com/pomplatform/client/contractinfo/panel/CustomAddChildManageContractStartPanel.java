package com.pomplatform.client.contractinfo.panel;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
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
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.VLayout;

import static com.pomplatform.client.contractinfo.panel.CustomAddSubContractMainTwoStartPanel.childContract;

public class CustomAddChildManageContractStartPanel extends AbstractWizadPage {

    private static final Logger logger = Logger.getLogger("");
    public static DelicacyListGrid SourceGrid;
    private ComboBoxItem projectManageItem;

    public CustomAddChildManageContractStartPanel(int flowStatus, Map<String, String> map) {
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

        ListGridField[] fields = new ListGridField[10];
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
        projectManageItem = new ComboBoxItem();
        fields[idx] = new ListGridField("projectManageId", "管理人员");
//        fields[idx].addChangedHandler(new ChangedHandler() {
//            @Override
//            public void onChanged(ChangedEvent event) {
//                int rowNum = event.getRowNum();
//                Record rowRecord = SourceGrid.getRecord(rowNum);
//                Map params = rowRecord.toMap();
//                params.put("opt_type", "changeSubContractCode");
//                DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "", params, new DSCallback() {
//                    @Override
//                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
//                        if (dsResponse.getStatus() < 0) {
//                            ClientUtil.displayErrorMessage(dsResponse);
//                        } else {
//                            //获取返回的订单编号percentage
//                            Record record = dsResponse.getData()[0];
//                            DBDataSource.copyRecord(record, SourceGrid.getRecord(rowNum));
//                            SourceGrid.redraw();
//                        }
//                    }
//                });
//            }
//        });
        projectManageItem.setChangeOnKeypress(false);
//		if(null != map && !map.isEmpty()){
//			LinkedHashMap<String, Object> linked = new LinkedHashMap<>();
//			for(String key : map.keySet()){
//				linked.put(key, map.get(key));
//			}
//			projectManageItem.setValueMap(linked);
//		}
        projectManageItem.setValueMap(KeyValueManager.getValueMap("use_employees"));
        projectManageItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        fields[idx].setEditorProperties(projectManageItem);
        fields[idx].setShowGridSummary(false);
        idx++;
        fields[idx] = new ListGridField("projectCode");
        fields[idx].setHidden(true);
        idx++;
//		fields[idx] = new ListGridField("businessType");
//		fields[idx].setShowGridSummary(false);
//		idx++;
        fields[idx] = new ListGridField("projectType");
        fields[idx].setDefaultValue(16);
        fields[idx].setHidden(true);
        idx++;
        fields[idx] = new ListGridField("departmentId");
        fields[idx].setShowGridSummary(false);
        fields[idx].setCanEdit(false);
        fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        idx++;
//		fields[idx] = new ListGridField("businessLine","条线");
//		fields[idx].setShowGridSummary(false);
//		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));
//		idx++;
        fields[idx] = new ListGridField("percentage", "占比");
        fields[idx].setCanEdit(false);
        fields[idx].addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {

            }
        });
        idx++;
        fields[idx] = new ListGridField("moneySum", "合同金额");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("sheetTotalIntegral");
        idx++;
        fields[idx] = new ListGridField("isHistory");
        fields[idx].setCanEdit(false);
        idx++;
        fields[idx] = new ListGridField("remark", "备注");
        fields[idx].setWidth(200);
        idx++;
        fields[idx] = new ListGridField("subContractName");
        idx++;
        fields[idx] = new ListGridField("isAuto", "是否自动结算");
        fields[idx].setType(ListGridFieldType.BOOLEAN);
        fields[idx].setDefaultValue(true);
        fields[idx].setCanEdit(false);
        SourceGrid.setFields(fields);
//		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        SourceGrid.setShowGridSummary(true);
        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setWidth100();

        SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
            //            @SuppressWarnings({"unchecked", "rawtypes"})
            @Override
            public void onEditComplete(EditCompleteEvent event) {
                SC.debugger();
                if (!BaseHelpUtils.isNullOrEmpty(event.getNewValues().get("remark"))) {
                    SourceGrid.redraw();
                    return;
                }
                int rowNum = event.getRowNum();
                Record rowRecord = SourceGrid.getRecord(rowNum);
                Map params = rowRecord.toMap();
//                if (!BaseHelpUtils.isNullOrEmpty(event.getNewValues().get("projectManageId"))) {
                ListGridRecord[] records1 = SourceGrid.getRecords();
                ListGridRecord[] records2 = childContract.SourceGrid.getRecords();
                List<ListGridRecord> list = new ArrayList<>();
                records1[rowNum] = new ListGridRecord();
                for (ListGridRecord record : records1) {
                    if ((!BaseHelpUtils.isNullOrEmpty(record.getAttribute("subContractCode"))) && (rowRecord != record) && BaseHelpUtils.isNullOrEmpty(event.getNewValues().get("remark"))) {
                        list.add(record);
                    }
                }
                for (ListGridRecord record : records2) {
                    if ((!BaseHelpUtils.isNullOrEmpty(record.getAttribute("subContractCode")))) {
                        list.add(record);
                    }
                }

                params.put("records", list);
//                }
                params.put("opt_type", "changeSubContractCode");
                DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() < 0) {
                            ClientUtil.displayErrorMessage(dsResponse);
                        } else {
                            //获取返回的订单编号percentage
                            Record record = dsResponse.getData()[0];
                            DBDataSource.copyRecord(record, SourceGrid.getRecord(rowNum));
                            if (BaseHelpUtils.isNullOrEmpty(event.getOldValues()) && (BaseHelpUtils.getIntValue(event.getNewValues().get("sheetTotalIntegral"))) == 0) {
                                SourceGrid.redraw();
                                return;
                            }
                            if ((BaseHelpUtils.getIntValue(event.getNewValues().get("projectManageId"))) > 0) {
                                SourceGrid.redraw();
                                return;
                            }
                        }
                    }
                });
                if (BaseHelpUtils.isNullOrEmpty(event.getOldValues()) && (BaseHelpUtils.getIntValue(event.getNewValues().get("sheetTotalIntegral"))) == 0) {
                    return;
                }
                if ((BaseHelpUtils.getIntValue(event.getNewValues().get("projectManageId"))) > 0 || (!BaseHelpUtils.isNullOrEmpty(event.getNewValues().get("remark")))) {
                    return;
                }

                //本次改变的值
                BigDecimal newValue = BaseHelpUtils.getBigDecimalValue(event.getNewValues().get("sheetTotalIntegral")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                BigDecimal sheetTotalIntegral = BigDecimal.ZERO;
                BigDecimal hundred = new BigDecimal(100);
                BigDecimal sum = BigDecimal.ZERO;
                Record[] records = SourceGrid.getRecords();
//				Record selected  = SourceGrid.getSelectedRecord();
                //原来的值
//				BigDecimal oldValue = BaseHelpUtils.getBigDecimalValue(rowRecord.getAttribute("sheetTotalIntegral")).setScale(2,BigDecimal.ROUND_HALF_DOWN);
                rowRecord.setAttribute("sheetTotalIntegral", newValue);
                records[rowNum] = rowRecord;
                for (Record r : records) {
                    sheetTotalIntegral = sheetTotalIntegral.add(BaseHelpUtils.getBigDecimalValue(r.getAttribute("sheetTotalIntegral")));
                }

                int i = 0;
                int len = records.length;
                for (Record r : records) {
                    i++;
                    if (i == len) {
                        r.setAttribute("percentage", hundred.subtract(sum));
                    } else {
                        if (sheetTotalIntegral.compareTo(BigDecimal.ZERO) == 0) {
                            r.setAttribute("percentage", BigDecimal.ZERO);
                        } else {
                            BigDecimal value = BaseHelpUtils.getBigDecimalValue(r.getAttribute("sheetTotalIntegral")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                            BigDecimal percentage = value.divide(sheetTotalIntegral, 4, BigDecimal.ROUND_HALF_DOWN).multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                            sum = sum.add(percentage);
                            r.setAttribute("percentage", percentage);
                        }
                    }
                }
                SourceGrid.setData(records);
                SourceGrid.redraw();
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
        SC.debugger();

        if (contractId > 0) {
            Map<String, Object> condition = new HashMap<>();
            condition.put("parentId", contractId);
            condition.put("projectType", 16);
            DBDataSource.callOperation("ST_SubContract", "find", condition, new DSCallback() {
                @Override
                public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                    if (dsResponse.getStatus() >= 0) {
                        SourceGrid.setData(dsResponse.getData());
                    }

                }
            });
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

    @Override
    public Map getValuesAsMap() {
        //获取到全部的项目经理id，然后返回，通过在另一个页面获取getValuesAsmap方法获取
        Map param = new HashMap(0);
        MapUtils.convertRecordToMap(SourceGrid.getDataSource(), SourceGrid.getRecords(), param, "getProjectManagerId");
        return param;
    }
}