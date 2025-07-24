package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSStampCarvingApply;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class StampCarvingApplyNewForm extends AbstractWizadPage
{

	private static final Logger logger  = Logger.getLogger("");
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final TextItem companyIdItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;
	private final PickTreeItem addressItem;
	private final TextItem planItem;
	private final TextItem subTypeItem;
	private final TextItem subTypeStrItem;
	private final SelectItem reasonItem;
	private final TextItem drafterItem;
	private final TextAreaItem remarkItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	private final VLayout mainLayout;

	public StampCarvingApplyNewForm() {
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		mainLayout.setLayoutLeftMargin(30);
		mainLayout.setLayoutRightMargin(30);
		mainLayout.setLayoutTopMargin(15);
		
		DSStampCarvingApply ds = DSStampCarvingApply.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setTextBoxStyle("customInputTextStyle");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setTextBoxStyle("customInputTextStyle");
		companyIdItem.setDisabled(true);
		__formItems.add(companyIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setTextBoxStyle("customInputTextStyle");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "所在部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setTextBoxStyle("customInputTextStyle");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);
		
		addressItem = new PickTreeItem("address", shouldNotBeNull + "请选择印章种类");
		addressItem.setValueTree(KeyValueManager.getTree("system_dictionary_107"));
//		addressItem.setValueField("treeId");
		addressItem.setCanSelectParentItems(false);
		addressItem.setControlStyle("customInputTextStyle");
		addressItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()) {
					String[] ids = event.getValue().toString().split("/");
					int length = ids.length;
					StringBuilder sb = new StringBuilder();
					for(int i = 1; i < length; i++) {
						if(sb.length() > 0) {
							sb.append("/");
						}
						sb.append(KeyValueManager.getValue("system_dictionary_107", ids[i]));
					}
					planItem.setValue(sb.toString());
				}else {
					planItem.clearValue();
				}
			}
		});
		__formItems.add(addressItem);
		
		planItem = new TextItem("plan", shouldNotBeNull + "选中的印章种类");
		planItem.setTextBoxStyle("customInputTextStyle");
		planItem.setCanEdit(false);
		__formItems.add(planItem);
		
		projectNameItem = new TextItem("projectName", shouldNotBeNull + "刻章字样");
		projectNameItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectNameItem);
		
		projectCodeItem = new TextItem("projectCode", shouldNotBeNull + "刻章内容");
		projectCodeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(projectCodeItem);
		
		subTypeItem = new TextItem("subType", shouldNotBeNull + "印章尺寸");
		subTypeItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(subTypeItem);
		
		subTypeStrItem = new TextItem("subTypeStr", shouldNotBeNull + "印章形状");
		subTypeStrItem.setTextBoxStyle("customInputTextStyle");
		__formItems.add(subTypeStrItem);
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		reasonItem = new SelectItem("reason", shouldNotBeNull + "申请原因");
		reasonItem.setControlStyle("customInputTextStyle");
		reasonItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_108"));
		__formItems.add(reasonItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setColSpan(2);
		remarkItem.setRowSpan(3);
		remarkItem.setTextBoxStyle("customTextAreaStyle");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		mainLayout.addMember(__form);
		addMember(mainLayout);
		FormItem[] items = __form.getFields();
		int width = (mainLayout.getWidth()-30)/23*10;
		int width2 = width * 7 / 10;
		mainLayout.setLayoutLeftMargin(width * 3 / 10 + 10);
		mainLayout.setLayoutRightMargin(0);
		for(FormItem item : items){
			item.setWidth(width2);
		}
	}

	@Override
	public boolean checkData() {
		if(null == employeeIdItem.getValue()){
			SC.say("请重新登录之后再申请本流程");
			return false;
		}
		if(null == addressItem.getValue()){
			SC.say("请选择印章种类");
			return false;
		}
		if(null == projectNameItem.getValue()){
			SC.say("请填写刻章字样");
			return false;
		}
		if(null == projectCodeItem.getValue()){
			SC.say("请填写刻章内容");
			return false;
		}
		if(null == subTypeItem.getValue()){
			SC.say("请填写印章尺寸");
			return false;
		}
		if(null == subTypeStrItem.getValue()){
			SC.say("请填写印章形状");
			return false;
		}
		if(null == reasonItem.getValue()){
			SC.say("请选择申请原因");
			return false;
		}
		if(reasonItem.getDisplayValue().equals("其他") && null == remarkItem.getValue()){
			SC.say("申请原因选择其他，请在备注中写明具体原因");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		Record record = getRecord();
		if(record != null){
			__form.editRecord(record);
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSStampCarvingApply.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
