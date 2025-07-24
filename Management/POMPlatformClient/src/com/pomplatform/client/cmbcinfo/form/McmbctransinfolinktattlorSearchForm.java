package com.pomplatform.client.cmbcinfo.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cmbcinfo.datasource.CDMcmbctransinfolinktattlor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class McmbctransinfolinktattlorSearchForm extends SearchForm {

	private final TextItem bankAccountItem;
	private final SelectItem companyRecordIdItem;
	private final TextItem naryurItem;
	private final TextItem refnbrItem;
	private final TextItem reqnbrItem;
	private final TextItem busnamItem;
	private final TextItem nusageItem;
	private final TextItem yurrefItem;
	private final TextItem rpynamItem;
	private final TextItem rpyaccItem;
	private final TextItem rpybnkItem;
	private final TextItem rpyadrItem;
	private final DateTimeItem minTransDateItem;
	private final DateTimeItem maxTransDateItem;
	private final DateItem minVltdatItem;
	private final DateItem maxVltdatItem;
	private final DateTimeItem minCreateTimeItem;
	private final DateTimeItem maxCreateTimeItem;
	private final DateTimeItem minUpdateTimeItem;
	private final DateTimeItem maxUpdateTimeItem;
	private final TextItem cmbcTransInfoIdItem;
	private final TextItem trscodItem;
	private final TextItem amtcdrItem;
	private final TextItem trsanlItem;
	private final TextItem transTypeItem;
	private final TextItem linkNumItem;
	private final BooleanItem isLinkItem;

	public McmbctransinfolinktattlorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMcmbctransinfolinktattlor.getInstance());
		bankAccountItem = new TextItem("bankAccount", "公司账号");
		bankAccountItem.setWidth("*");
		companyRecordIdItem = new SelectItem("companyRecordId", "归属公司");
		companyRecordIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyRecordIdItem.setWidth("*");
		naryurItem = new TextItem("naryur", "摘要");
		naryurItem.hide();
		refnbrItem = new TextItem("refnbr", "流水号");
		refnbrItem.hide();
		reqnbrItem = new TextItem("reqnbr", "流程实例号");
		reqnbrItem.hide();
		busnamItem = new TextItem("busnam", "业务名称");
		busnamItem.hide();
		nusageItem = new TextItem("nusage", "用途");
		nusageItem.hide();
		yurrefItem = new TextItem("yurref", "业务参考号");
		yurrefItem.hide();
		rpynamItem = new TextItem("rpynam", "收/付方名称");
		rpynamItem.setWidth("*");
		rpyaccItem = new TextItem("rpyacc", "收/付方帐号");
		rpyaccItem.setWidth("*");
		rpybnkItem = new TextItem("rpybnk", "收/付方开户行名");
		rpybnkItem.setWidth("*");
		rpyadrItem = new TextItem("rpyadr", "收/付方开户行地址");
		rpyadrItem.hide();
		minTransDateItem = new DateTimeItem("minTransDate", "最早交易时间");
		minTransDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minTransDateItem);
			}
		});
		maxTransDateItem = new DateTimeItem("maxTransDate", "最晚交易时间");
		maxTransDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxTransDateItem);
			}
		});
		minVltdatItem = new DateItem("minVltdat", "最早起息日");
		minVltdatItem.hide();
		minVltdatItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minVltdatItem);
			}
		});
		maxVltdatItem = new DateItem("maxVltdat", "最晚起息日");
		maxVltdatItem.hide();
		maxVltdatItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxVltdatItem);
			}
		});
		minCreateTimeItem = new DateTimeItem("minCreateTime", "最早创建时间");
		minCreateTimeItem.hide();
		minCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minCreateTimeItem);
			}
		});
		maxCreateTimeItem = new DateTimeItem("maxCreateTime", "最晚创建时间");
		maxCreateTimeItem.hide();
		maxCreateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxCreateTimeItem);
			}
		});
		minUpdateTimeItem = new DateTimeItem("minUpdateTime", "最早修改时间");
		minUpdateTimeItem.hide();
		minUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, minUpdateTimeItem);
			}
		});
		maxUpdateTimeItem = new DateTimeItem("maxUpdateTime", "最晚修改时间");
		maxUpdateTimeItem.hide();
		maxUpdateTimeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, maxUpdateTimeItem);
			}
		});
		cmbcTransInfoIdItem = new TextItem("cmbcTransInfoId", "主键");
		cmbcTransInfoIdItem.hide();
		trscodItem = new TextItem("trscod", "交易类型 cmbc_codes trans_code");
		trscodItem.hide();
		amtcdrItem = new TextItem("amtcdr", "借贷标记 C贷 D借");
		amtcdrItem.hide();
		trsanlItem = new TextItem("trsanl", "交易分析码");
		trsanlItem.hide();
		transTypeItem = new TextItem("transType", "ERP收支表示  1收  2支");
		transTypeItem.hide();
		linkNumItem = new TextItem("linkNum", "数量");
		linkNumItem.hide();
		
		isLinkItem = new BooleanItem("isLink", "是否绑定");
		isLinkItem.setWidth("*");

		setItems(companyRecordIdItem, bankAccountItem, naryurItem, refnbrItem, reqnbrItem, busnamItem, nusageItem,
				yurrefItem, rpynamItem, rpyaccItem, rpybnkItem, rpyadrItem, minTransDateItem, maxTransDateItem,
				minVltdatItem, maxVltdatItem, minCreateTimeItem, maxCreateTimeItem, minUpdateTimeItem,
				maxUpdateTimeItem, cmbcTransInfoIdItem, trscodItem, amtcdrItem, trsanlItem, transTypeItem, linkNumItem,
				isLinkItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
