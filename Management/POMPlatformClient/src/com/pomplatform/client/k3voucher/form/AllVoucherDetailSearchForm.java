package com.pomplatform.client.k3voucher.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3voucher.datasource.CDAllVoucherDetail;

public class AllVoucherDetailSearchForm extends SearchForm
{


	private final TextItem voucherYearItem;
	private final TextItem voucherMonthItem;
	private final SelectItem voucherTypeItem;
	private final TextItem sequenceNumberItem;
	private final DateItem vestingDateItem;

	public AllVoucherDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAllVoucherDetail.getInstance());
		voucherYearItem = new TextItem("voucherYear", "凭证年份");
		voucherMonthItem = new TextItem("voucherMonth", "凭证月份");
		voucherTypeItem = new SelectItem("voucherType", "凭证类型");
		voucherTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_117"));
		sequenceNumberItem = new TextItem("sequenceNumber", "凭证号");
		vestingDateItem = new DateItem("vestingDate", "归属日期");
		vestingDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, vestingDateItem);
			}
		});

		setItems(voucherYearItem, voucherMonthItem, voucherTypeItem, sequenceNumberItem, vestingDateItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
