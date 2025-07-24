package com.pomplatform.client.ja.ht.form;

import java.util.*;

import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.ja.ht.datasource.CDMainProject;

public class MainProjectSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final CheckboxItem hasContractItem;
	private final SelectItem projectBaseOnItem;
	private final TextItem infoCodeItem;
	private final TextItem designTeamItem;
	private final ComboBoxItem leaderItem;
	private final ComboBoxItem secretaryItem;
	private final ComboBoxItem chargePersonItem;

	public MainProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMainProject.getInstance());
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		hasContractItem = new CheckboxItem("hasContract", "是否有主合同");
		hasContractItem.setWidth("*");
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		designTeamItem = new TextItem("designTeam", "主办设计团队");
		designTeamItem.setWidth("*");
//		designTeamItem.setValueMap(KeyValueManager.getValueMap("departments"));

//		designTeamItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		leaderItem = new ComboBoxItem("leader", "项目主管领导");
		leaderItem.setValueMap(KeyValueManager.getValueMap("employees"));
		leaderItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		leaderItem.setWidth("*");
		secretaryItem = new ComboBoxItem("secretary", "项目秘书");
		secretaryItem.setValueMap(KeyValueManager.getValueMap("employees"));
		secretaryItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		secretaryItem.setWidth("*");
		chargePersonItem = new ComboBoxItem("chargePerson", "项目负责人");
		chargePersonItem.setValueMap(KeyValueManager.getValueMap("employees"));
		chargePersonItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		chargePersonItem.setWidth("*");

		setItems(projectCodeItem, projectNameItem, projectBaseOnItem, infoCodeItem, designTeamItem, leaderItem, secretaryItem, chargePersonItem, hasContractItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
