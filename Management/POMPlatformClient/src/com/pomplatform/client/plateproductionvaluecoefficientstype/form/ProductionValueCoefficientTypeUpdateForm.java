package com.pomplatform.client.plateproductionvaluecoefficientstype.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.plateproductionvaluecoefficientstype.datasource.DSProductionValueCoefficientType;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

import java.util.Map;

public class ProductionValueCoefficientTypeUpdateForm extends AbstractWizadPage
{
	private final TextItem coefficientTypeItem;

	public ProductionValueCoefficientTypeUpdateForm() {
		DSProductionValueCoefficientType ds = DSProductionValueCoefficientType.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		coefficientTypeItem = new TextItem("coefficientType", "产值类型");
		coefficientTypeItem.setRequired(true);
		coefficientTypeItem.setWidth("*");
		IsStringValidator coefficientTypeValidator = new IsStringValidator();
		LengthRangeValidator coefficientTypeLengthValidator = new LengthRangeValidator();
		coefficientTypeLengthValidator.setMax(255);
		coefficientTypeItem.setValidators(coefficientTypeValidator, coefficientTypeLengthValidator);
		__formItems.add(coefficientTypeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProductionValueCoefficientType.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
