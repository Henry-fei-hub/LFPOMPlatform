package com.pomplatform.client.ja.check.panel;

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
import com.pomplatform.client.ja.ht.datasource.DSOutDesignConsideration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class CheckOutAllDesignConsiderationPanel extends AbstractWizadPage {

	private static Logger __LOGGER = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	private DynamicForm __infoForm;
	private TextItem totalItem;
	private TextItem favorableTotalItem;

	public CheckOutAllDesignConsiderationPanel() {
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		addMember(SearchSourceLayout);
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setCanEdit(false);
		ListGridField[] fields = new ListGridField[8];
		int idx = 0;
		fields[idx] = new ListGridField("outDesignConsiderationId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("infoCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("businessType");
		fields[idx].setCanEdit(false);
		SelectItem selectBusinessTypeItem = new SelectItem();
		selectBusinessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		fields[idx].setEditorProperties(selectBusinessTypeItem);
		idx++;
		
		//专项 子项
		fields[idx] = new ListGridField("optionType");
		SelectItem selectOptionTypeItem = new SelectItem();
		selectOptionTypeItem.setValueMap(KeyValueManager.getValueMap("sys_classifications"));
		fields[idx].setEditorProperties(selectOptionTypeItem);
		idx++;
		fields[idx] = new ListGridField("projectType");
		fields[idx].setHidden(true);
		SelectItem selectProjectTypeItem = new SelectItem();
		selectProjectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		fields[idx].setEditorProperties(selectProjectTypeItem);
		idx++;
		fields[idx] = new ListGridField("mainDesignAreaName");
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("designArea");
		idx++;
		fields[idx] = new ListGridField("designUnitPrice");
		idx++;
		fields[idx] = new ListGridField("moneySum");
		idx++;
		fields[idx] = new ListGridField("remark");
		fields[idx].setWidth(80);
		idx++;
		fields[idx] = new ListGridField("interiorPrice");
		idx++;
		fields[idx] = new ListGridField("interiorMoneySum");
		idx++;
		fields[idx] = new ListGridField("subContractId");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("orderNo");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("disableType");
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("outQuotationId");
		fields[idx].setHidden(true);
		idx++;

		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.ROW_STYLE);
		SourceGrid.setDataSource(DSOutDesignConsideration.getInstance());
		SearchSourceLayout.addMember(SourceGrid);
		__infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("16%");
		__infoForm.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		SearchSourceLayout.addMember(__infoForm);
		totalItem = new TextItem("报价单汇总");
		totalItem.setCanEdit(false);
		totalItem.setWidth("*");
		favorableTotalItem=new TextItem("最终报价");
		favorableTotalItem.setCanEdit(false);
		favorableTotalItem.setWidth(120);
		__infoForm.setFields(totalItem,favorableTotalItem);
	}

	@Override
	public void startEdit() {
		__LOGGER.info(
				"CheckOutDesigneConsiderationHandler start load infoCode=" + infoCode + " projectCode=" + projectCode);

		if (!BaseHelpUtils.isNullOrEmpty(infoCode)) {
			Map<String, Object> condition = new HashMap<>();
			condition.put("opt_type", "getCheckConsiderationsList");
			condition.put("infoCode", infoCode);
			condition.put("projectCode", projectCode);
			condition.put("outQuotationId", outQuotationId);

			DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", "", condition, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					SourceGrid.setData(dsResponse.getData());
					// 设置汇总信息
					Object o=dsResponse.getErrors().get("errorMsg");
					String[] val=BaseHelpUtils.getString(o).split("-");
				    totalItem.setValue(BaseHelpUtils.getString(val[0]).substring(1));
				    String temp=BaseHelpUtils.getString(val[1]);
				    favorableTotalItem.setValue(temp.substring(0,(temp.length()-1)));
				}
			});
		}
	}

	// 效验数据
	@Override
	public boolean checkData() {
		boolean isFlag = true;
		return isFlag;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("checkOutDesignConsideration");
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

	private String infoCode;
	private String projectCode;
	private int outQuotationId;

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public int getOutQuotationId() {
		return outQuotationId;
	}

	public void setOutQuotationId(int outQuotationId) {
		this.outQuotationId = outQuotationId;
	}

}
