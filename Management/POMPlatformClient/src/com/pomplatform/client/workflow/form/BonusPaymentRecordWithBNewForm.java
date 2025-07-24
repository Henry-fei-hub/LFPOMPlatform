package com.pomplatform.client.workflow.form;

import java.math.BigDecimal;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.workflow.datasource.DSBonusPaymentRecordWithB;

public class BonusPaymentRecordWithBNewForm extends AbstractWizadPage
{


	private final SelectItem plateIdItem;
	private final TextItem payIntegralItem;
	private final DateItem payDateItem;
	private final TextAreaItem remarkItem;
	private final TextItem applicantItem;
	private final DateItem applyTimeItem;
	private final DateItem auditingTimeItem;
	private final TextItem stateItem;
	
	private final String plateIds = PomPlatformClientUtil.getRolePlateId();
	private int plateId;
	
	public BonusPaymentRecordWithBNewForm() {
		DSBonusPaymentRecordWithB ds = DSBonusPaymentRecordWithB.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		if(null!=plateIds){
			if(plateIds.indexOf(",")>0) {
				plateId=ClientUtil.checkAndGetIntValue(plateIds.split(",")[0]);
			}else {					
				plateId=ClientUtil.checkAndGetIntValue(plateIds);
			}
		}else {
			plateId=ClientUtil.getPlateId();
		}
		plateIdItem.setDefaultValue(plateId);
		plateIdItem.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				String tempPlateId = BaseHelpUtils.getString(event.getValue());
				boolean hasChanged = false;
				String[] plateIdArray = plateIds.split(",");
				for (String str : plateIdArray) {
					if (tempPlateId.equals(str)) {
						plateId = BaseHelpUtils.getIntValue(str);
						hasChanged = true;
//						load();
//						grid.setData(new RecordList());
						break;
					}
				}
				if (!hasChanged) {
					plateIdItem.setValue(event.getOldValue());
					SC.warn("提示", "您没有该部门的奖金发放申请权限");
				}
			}
		});
		
		plateIdItem.setWidth("*");
		__formItems.add(plateIdItem);
		payIntegralItem = new DoubleItem("payIntegral", "发放积分");
		payIntegralItem.setLength(12);
		payIntegralItem.setDecimalPad(2);
		payIntegralItem.setFormat("#,###,###,##0.00");
		payIntegralItem.setWidth("*");
		payIntegralItem.setCanEdit(false);
		__formItems.add(payIntegralItem);
		applyTimeItem = new DateItem("applyTime", "创建时间");
		applyTimeItem.setWidth("*");
		applyTimeItem.setDisabled(true);
		applyTimeItem.setUseTextField(true);
		applyTimeItem.setDefaultValue(new Date());
		applyTimeItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(applyTimeItem);
		auditingTimeItem = new DateItem("auditingTime", "发放时间");
		auditingTimeItem.setWidth("*");
		auditingTimeItem.setUseTextField(true);
		auditingTimeItem.setDefaultValue(new Date());
		auditingTimeItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(auditingTimeItem);
		payDateItem = new DateItem("payDate", "申请时间");
		payDateItem.setWidth("*");
		payDateItem.setUseTextField(true);
		payDateItem.setDefaultValue(new Date());
		payDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(payDateItem);
		remarkItem = new TextAreaItem("remark", "申请缘由");
		remarkItem.setLength(512);
		remarkItem.setColSpan(6);
		remarkItem.setRowSpan(2);
		remarkItem.setWidth("*");
		remarkItem.setHeight(70);
		__formItems.add(remarkItem);
		applicantItem = new TextItem("applicant", "申请人");
		applicantItem.setDefaultValue(ClientUtil.getUserId());
		applicantItem.hide();
		__formItems.add(applicantItem);
		stateItem = new TextItem("state", "审核状态  0未审核   1审核通过    2审核不通过");
		stateItem.setDefaultValue(0);
		stateItem.hide();
		__formItems.add(stateItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(8);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(BaseHelpUtils.getIntValue(plateIdItem.getValue())<=0){
			SC.say("提示","业务部门不能为空");
			return false;
		}
		if(BaseHelpUtils.getBigDecimalValue(payIntegralItem.getValue()).compareTo(BigDecimal.ZERO)<=0){
			SC.say("提示","发放积分不能少于0");
			return false;
		}
		if(null==payDateItem.getValue()){
			SC.say("提示","申请时间不能为空");
			return false;
		}
		if(null==auditingTimeItem.getValue()){
			SC.say("提示","发放时间不能为空");
			return false;
		}
		if(null==remarkItem.getValue()){
			SC.say("提示","申请缘由不能为空");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSBonusPaymentRecordWithB.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}

	public SelectItem getPlateIdItem() {
		return plateIdItem;
	}

	public TextItem getPayIntegralItem() {
		return payIntegralItem;
	}

	public DateItem getPayDateItem() {
		return payDateItem;
	}

	public TextAreaItem getRemarkItem() {
		return remarkItem;
	}

	public TextItem getApplicantItem() {
		return applicantItem;
	}

	public DateItem getApplyTimeItem() {
		return applyTimeItem;
	}

	public TextItem getStateItem() {
		return stateItem;
	}
	
	
	
	

}
