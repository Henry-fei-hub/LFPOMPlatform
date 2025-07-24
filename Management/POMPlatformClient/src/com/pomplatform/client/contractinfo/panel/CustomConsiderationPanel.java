package com.pomplatform.client.contractinfo.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ja.ht.datasource.DSDesignConsideration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class CustomConsiderationPanel extends AbstractWizadPage {

	private static final Logger __LOGGER = Logger.getLogger("");
	private final DelicacyListGrid resultGrid = new DelicacyListGrid();
	
	private Integer subContractId;
	private Integer contractId;
	private Integer projectType;
	
	public Integer getSubContractId() {
		return subContractId;
	}

	public void setSubContractId(Integer subContractId) {
		this.subContractId = subContractId;
	}
	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	
	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}



	private static DataSource childSheetDataSource = DSDesignConsideration.getInstance();
	private static ListGridField[] fields = new ListGridField[13];
	private static DataSource reserveSheetDetailSource;
	
	public CustomConsiderationPanel() {
		
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth100();
		setSheetDataSource();
		resultGrid.setShowRowNumbers(true);
		resultGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(resultGrid);
		addMember(SearchSourceLayout);
	}
	
	private void setSheetDataSource(){
		resultGrid.setDataSource(childSheetDataSource);
		int idx = 0;
		fields[idx] = new ListGridField("businessType");
		idx++;
		fields[idx] = new ListGridField("projectType");
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		idx++;
		fields[idx] = new ListGridField("decorationStatus");
		idx++;
		fields[idx] = new ListGridField("designArea");
		idx++;
		fields[idx] = new ListGridField("designUnitPrice");
		idx++;
		fields[idx] = new ListGridField("moneySum");
		idx++;
		fields[idx] = new ListGridField("interiorPrice");
		idx++;
		fields[idx] = new ListGridField("interiorMoneySum");
		idx++;
		fields[idx] = new ListGridField("splitPrice");
		idx++;
		resultGrid.setFields(fields);
		
		//定义部门预留订单项目表的字段信息
		DataSourceTextField subContractCodeField = new DataSourceTextField("subContractCode","订单编号");
		DataSourceIntegerField businessTypeField = new DataSourceIntegerField("businessType","业务类别");
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		DataSourceIntegerField projectTypeField = new DataSourceIntegerField("projectType","项目类别");
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		DataSourceIntegerField departmentIdField = new DataSourceIntegerField("departmentId","承接部门");
		departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		DataSourceFloatField sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral","订单总积分");
		sheetTotalIntegralField.setDecimalPad(2);
		sheetTotalIntegralField.setFormat("##,###,###,###,##0.00");
		DataSourceTextField subContractNameField = new DataSourceTextField("subContractName","订单名称");
		DataSourceTextField remarkField = new DataSourceTextField("remark","备注");
		reserveSheetDetailSource = new DataSource();
		reserveSheetDetailSource.addField(subContractCodeField);
		reserveSheetDetailSource.addField(businessTypeField);
		reserveSheetDetailSource.addField(projectTypeField);
		reserveSheetDetailSource.addField(departmentIdField);
		reserveSheetDetailSource.addField(sheetTotalIntegralField);
		reserveSheetDetailSource.addField(subContractNameField);
		reserveSheetDetailSource.addField(remarkField);
		
	}
	
	@Override
	public void startEdit() {
		if (subContractId > 0) {
			Map<String, Object> params = new HashMap<>();
			if(projectType == 88){
				params.put("reserveSheetId",subContractId);
				DBDataSource.callOperation("ST_SubContract","find",params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							resultGrid.setDataSource(reserveSheetDetailSource);
							resultGrid.setData(dsResponse.getData());
						} else {
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}else{
				params.put("opt_type", "getConsiderationsByCtr");
				params.put("subContractId", subContractId);
				params.put("contractId", contractId);
				DBDataSource.callOperation("EP_CustomSubContractHandler", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							resultGrid.setDataSource(childSheetDataSource);
							resultGrid.setFields(fields);
							resultGrid.setData(dsResponse.getData());
						}
					}
				});
			}
		}
	}

	

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailRoleFunction");
		return res;
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public boolean checkData() {
		return false;
	}
}
