package com.pomplatform.client.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.specialdeduction.datasource.CDMspecialdeductionrecordsor;

public class MspecialdeductionrecordsorSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final ComboBoxItem employeIdItem;
	private final SelectItem documentTypeItem;
	private final SelectItem spouseSituationItem;
	private final TextItem nameItem;
	private final SelectItem specialDeductionTypeIdItem;
	private final SelectItem educationTypeItem;
	private final SelectItem educationStageItem;
	private final SelectItem houseBorrowerItem;
	private final SelectItem houseTypeItem;
	private final SelectItem houseFirstItem;
	private final SelectItem loanTypeItem;
	private final SelectItem singleChildItem;
	private final SelectItem changeTypeItem;
	private final SelectItem processStatusItem;
	private final ComboBoxItem plateIdItem;
	private final TextItem companyIdItem;

	public MspecialdeductionrecordsorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMspecialdeductionrecordsor.getInstance());
		Date d = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		employeIdItem = new ComboBoxItem("employeId", "纳税申请人");
		employeIdItem.setWidth("*");
		employeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeIdItem.setChangeOnKeypress(false);
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		documentTypeItem = new SelectItem("documentType", "身份证件类型");
		documentTypeItem.setWidth("*");
		documentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));

		spouseSituationItem = new SelectItem("spouseSituation", "配偶情况");
		spouseSituationItem.setWidth("*");
		spouseSituationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		
		nameItem = new TextItem("name", "姓名");
		nameItem.setWidth("*");
		
		specialDeductionTypeIdItem = new SelectItem("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdItem.setWidth("*");
		specialDeductionTypeIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_223"));
		
		
		educationTypeItem = new SelectItem("educationType", "继续教育类型");
		educationTypeItem.setWidth("*");
		educationTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_221"));
		
		educationStageItem = new SelectItem("educationStage", "教育阶段");
		educationStageItem.setWidth("*");
		educationStageItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_218"));
		
		houseBorrowerItem = new SelectItem("houseBorrower", "是否房屋贷款借款人");
		houseBorrowerItem.setWidth("*");
		houseBorrowerItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		
		houseTypeItem = new SelectItem("houseType", "房屋证书类型");
		houseTypeItem.setWidth("*");
		houseTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_219"));
		
		houseFirstItem = new SelectItem("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		houseFirstItem.setWidth("*");
		houseFirstItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		
		loanTypeItem = new SelectItem("loanType", "贷款类型");
		loanTypeItem.setWidth("*");
		loanTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_225"));
		
		singleChildItem = new SelectItem("singleChild", "是否独生");
		singleChildItem.setWidth("*");
		singleChildItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		
		changeTypeItem = new SelectItem("changeType", "较上次报送信息是否发生变化");
		changeTypeItem.setWidth("*");
		changeTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_226"));
		
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setWidth("*");
		processStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();
		setItems(yearItem, employeIdItem, documentTypeItem, spouseSituationItem, nameItem, specialDeductionTypeIdItem, educationTypeItem, educationStageItem, houseBorrowerItem, houseTypeItem, houseFirstItem, loanTypeItem, singleChildItem, changeTypeItem, processStatusItem, plateIdItem, companyIdItem);

		setNumCols(20);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
