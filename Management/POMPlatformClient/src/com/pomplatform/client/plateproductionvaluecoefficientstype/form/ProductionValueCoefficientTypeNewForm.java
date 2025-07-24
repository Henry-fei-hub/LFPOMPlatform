package com.pomplatform.client.plateproductionvaluecoefficientstype.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.plateproductionvaluecoefficientstype.datasource.DSProductionValueCoefficientType;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;

import java.util.Map;

public class ProductionValueCoefficientTypeNewForm extends AbstractWizadPage
{


	private final TextItem productionValueCoefficientTypeIdItem;
	private final TextItem coefficientTypeItem;

	public ProductionValueCoefficientTypeNewForm() {
		DSProductionValueCoefficientType ds = DSProductionValueCoefficientType.getInstance();
		__form.setWidth(300);
		__form.setHeight(300);
		productionValueCoefficientTypeIdItem = new TextItem("productionValueCoefficientTypeId", "类型");
		__formItems.add(productionValueCoefficientTypeIdItem);
		coefficientTypeItem = new TextItem("coefficientType", "产值类型");
		coefficientTypeItem.setRequired(true);
		IsStringValidator coefficientTypeValidator = new IsStringValidator();
		LengthRangeValidator coefficientTypeLengthValidator = new LengthRangeValidator();
		coefficientTypeLengthValidator.setMax(255);
		coefficientTypeItem.setValidators(coefficientTypeValidator, coefficientTypeLengthValidator);
		__formItems.add(coefficientTypeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProductionValueCoefficientType.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
