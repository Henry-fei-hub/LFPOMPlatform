package com.pomplatform.client.contractinfo.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.i18n.client.NumberFormat;
import com.pomplatform.client.subcontractinfo.datasource.DSSubContractInfo;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;

public class CustomChildContractPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private final DelicacyListGrid SourceGrid;
    
	private Integer contractId;//主合同编号
	
	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public CustomChildContractPanel(int flowStatus) {
		final int __flowStatus = flowStatus;
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setDataSource(DSSubContractInfo.getInstance());
		SourceGrid.setCanEdit(false);
		
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
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
//		fields[idx] = new ListGridField("businessType");
//		fields[idx].setShowGridSummary(false);
//		idx++;
//		fields[idx] = new ListGridField("projectType");
//		fields[idx].setShowGridSummary(false);
//		idx++;
		fields[idx] = new ListGridField("departmentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		idx++;
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
//		idx++;
		fields[idx] = new ListGridField("moneySum","合同金额");
		idx++;
		fields[idx] = new ListGridField("ht_percentage");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return nf.format(((Number) value).doubleValue())+"%";  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });  
		idx++;
		fields[idx] = new ListGridField("createTime");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("sheetTotalIntegral","订单积分");
		idx++;
		fields[idx] = new ListGridField("dd_percentage","订单积分占比");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                if (value == null) return null;  
                try {  
                    NumberFormat nf = NumberFormat.getFormat("#,##0.00");  
                    return nf.format(((Number) value).doubleValue())+"%";  
                } catch (Exception e) {  
                    return value.toString();  
                }  
            }  
        });  
		idx++;
		fields[idx] = new ListGridField("jf", "积分/金额比");
		fields[idx].setFormat("##,###,###,###,##0.00");
		fields[idx].setCellFormatter(new CellFormatter() {  
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {  
                try {  
                	if(null != record.getAttribute("moneySum") && null != record.getAttribute("sheetTotalIntegral")){
                		NumberFormat nf = NumberFormat.getFormat("#,##0.00");
                        return nf.format(record.getAttributeAsDouble("sheetTotalIntegral")/record.getAttributeAsDouble("moneySum") * 100)+"%";  
                	}else{
                		return "0.00%";
                	}
                   
                } catch (Exception e) {  
                	return "0.00%";
                }  
            }  
        });  
//		idx++;
//		fields[idx] = new ListGridField("complaintPercentage");
//		fields[idx].setShowGridSummary(false);
//		idx++;
//		fields[idx] = new ListGridField("complaintIntegral");
//		idx++;
//		fields[idx] = new ListGridField("sheetIntegral");
		idx++;
		fields[idx] = new ListGridField("subContractName");
		idx++;
		fields[idx] = new ListGridField("projectManageId","专业负责人/管理人员");
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("remark","备注");
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setShowGridSummary(true);
		
		// 点击节点事件
		SourceGrid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = SourceGrid.getSelectedRecords();
				final int subContractId = ClientUtil.checkAndGetIntValue(selected[0].getAttribute("subContractId"));
				final String subContractName = selected[0].getAttribute("subContractName");
				final String remark = selected[0].getAttribute("remark");
				int projectType = BaseHelpUtils.getIntValue(selected[0].getAttribute("projectType"));
				CustomContractMainPanel.__infoForm.getItem("subContractCarouselRemark").setValue(remark);
//				if(projectType == 88){//部门预留订单
//					CustomContractMainPanel.considerationTitle.setContents("【"+subContractName+"】的绑定订单列表");
//				}else{
//					CustomContractMainPanel.considerationTitle.setContents("【"+subContractName+"】的拆分价列表");
//				}
//				CustomContractMainPanel.consideration.setSubContractId(subContractId);
//				CustomContractMainPanel.consideration.setContractId(contractId);
//				CustomContractMainPanel.consideration.setProjectType(projectType);
//				CustomContractMainPanel.consideration.startEdit();
			}
		});
		SourceGrid.addEditCompleteHandler(new EditCompleteHandler() {
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map params = SourceGrid.getRecord(event.getRowNum()).toMap();
				params.put("opt_type", "updateChildContart");
				//在处于可以修改承接部门时 可以创建子合同编号
				if(__flowStatus == 1){
					params.put("createSubCode", "createSubCode");
				}
				final int rowNumModified = event.getRowNum();
				
				DBDataSource.callOperation("EP_CustomSubContractHandler", "", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							DBDataSource.copyRecord(dsResponse.getData()[0], SourceGrid.getRecord(rowNumModified));
							SourceGrid.redraw();
						}
					}
				});
			}
		});
		addMember(SourceGrid);
	}

	@Override
	public void startEdit() {
		if (contractId > 0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getSubContract");
			condition.put("contractId", contractId);
			condition.put("isLoadAll", true);
			DBDataSource.callOperation("EP_CustomSubContractHandler", "", condition, new DSCallback() {
				@SuppressWarnings("unchecked")
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						SourceGrid.setData(dsResponse.getData());
						CustomContractMainPanel.onLoadSubContractRemark(contractId);
						//获取userData的数据集
//						Map<String,Object> userData = BaseHelpUtils.getResponseUserData(dsResponse);
//						if(!BaseHelpUtils.isNullOrEmpty(userData)) {
//							//获取订单总金额/合同总金额占比
//							String percent = BaseHelpUtils.getStringValue(userData,"percent");
//							//获取备注信息
//							String contentInfo = BaseHelpUtils.getStringValue(userData, "contentInfo");
//							CustomContractMainPanel.childContractTitle.setContents("子订单列表     "+percent);
//							//订单备注
//							CustomContractMainPanel.__infoForm.getItem("subContractRemark").setValue(contentInfo);
//						}
					}else {
						ClientUtil.displayErrorMessage(dsResponse);
					}
				}
			});
		}
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customChildContract");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}
	
	private boolean isLoadAll = false;

	public boolean isLoadAll() {
		return isLoadAll;
	}

	public void setLoadAll(boolean isLoadAll) {
		this.isLoadAll = isLoadAll;
	}
	
	public DelicacyListGrid getgirld(){
		return SourceGrid;
	}
	

	

}
