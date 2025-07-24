package com.pomplatform.client.contractinfo.panel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ja.ht.datasource.DSDesignConsideration;
import com.pomplatform.client.outquotations.datasource.DSOnLoadMainProjectBusinessTypeByContract;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class CustomAddConsiderationPanel extends AbstractWizadPage {

	private static final Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid resultGrid ;
	

	public CustomAddConsiderationPanel() {
		resultGrid = new DelicacyListGrid();
		resultGrid.setAutoFitFieldWidths(false);
		VLayout SearchSourceLayout = new VLayout();
		resultGrid.setDataSource(DSOnLoadMainProjectBusinessTypeByContract.getInstance());
//		resultGrid.setDataSource(DSDesignConsideration.getInstance());
		SearchSourceLayout.setWidth100();
		ListGridField[] fields = new ListGridField[13];
		int idx = 0;
		fields[idx] = new ListGridField("contractId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("mainProjectId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("outQuotationId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		idx++;
		fields[idx] = new ListGridField("projectName");
		idx++;
		fields[idx] = new ListGridField("signingMoneySum");
		fields[idx].setShowGridSummary(true);
		idx++;
		fields[idx] = new ListGridField("outputValueSum");
		fields[idx].setShowGridSummary(true);
		resultGrid.setFields(fields);
//		resultGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		resultGrid.setShowGridSummary(true);
		
        
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(resultGrid);
		addMember(SearchSourceLayout);
	}

	@Override
	public void startEdit() {
		if (contractId > 0) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "onLoadMainProjectBusinessTypeByContract");
			condition.put("contractId", contractId);
			DBDataSource.callOperation("EP_CustomSubContractFlowHandler", "find", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						resultGrid.setData(dsResponse.getData());
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
	
	
	private Integer contractId;
	
	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
}
