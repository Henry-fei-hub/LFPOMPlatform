package com.pomplatform.client.templet.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.templet.datasource.CDOutTemplet;

public class OutTempletSearchForm extends SearchForm
{


	private final ComboBoxItem businessTypeItem;

	public OutTempletSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOutTemplet.getInstance());
		businessTypeItem = new ComboBoxItem("businessType","业务类别");
		businessTypeItem.setDefaultValue(1);//默认选中商业
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
//		businessTypeItem.addChangedHandler(new ChangedHandler() {
//			
//			@Override
//			public void onChanged(ChangedEvent event) {
//				int businessType = BaseHelpUtils.getIntValue(event.getValue());
//				// TODO Auto-generated method stub
//				OutTempletPanel op=new OutTempletPanel();
//				op.setBusinessType(businessType);
//				op.commonQuery();
//			}
//		});

		setItems(businessTypeItem);
		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
