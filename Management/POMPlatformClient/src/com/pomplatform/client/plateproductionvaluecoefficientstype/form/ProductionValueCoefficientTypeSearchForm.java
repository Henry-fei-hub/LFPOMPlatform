package com.pomplatform.client.plateproductionvaluecoefficientstype.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.plateproductionvaluecoefficientstype.datasource.CDProductionValueCoefficientType;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ProductionValueCoefficientTypeSearchForm extends SearchForm
{


	private final TextItem coefficientTypeItem;

	public ProductionValueCoefficientTypeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDProductionValueCoefficientType.getInstance());
		coefficientTypeItem = new TextItem("coefficientType", "产值类型");

		setItems(coefficientTypeItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
