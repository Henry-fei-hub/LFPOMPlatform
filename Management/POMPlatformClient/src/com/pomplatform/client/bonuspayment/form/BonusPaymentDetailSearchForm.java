package com.pomplatform.client.bonuspayment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.bonuspayment.datasource.CDBonusPaymentDetail;

public class BonusPaymentDetailSearchForm extends SearchForm
{


	private final TextItem bonusPaymentRecordIdItem;

	public BonusPaymentDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDBonusPaymentDetail.getInstance());
		bonusPaymentRecordIdItem = new TextItem("bonusPaymentRecordId", "奖金发放记录编码");

		setItems(bonusPaymentRecordIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
