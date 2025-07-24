package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.mainprojectinfo.datasource.DSMainProjectInfo;

public class MainProjectInfoGroupname3Update extends AbstractWizadPage
{


	private final ComboBoxItem clientIdItem;
	private final TextItem projectSalesTeamItem;
	private final SelectItem projectSalesmanItem;
	private final SelectItem projectSalesTeamManagerItem;
	private final SelectItem designTeamItem;
	private final SelectItem projectManagerItem;
	private final SelectItem projectLeaderItem;
	private final SelectItem projectBaseOnItem;
	private final TextItem clientNameItem;
	private final TextItem clientPhoneItem;
	private final TextItem clientCompanyItem;
	private final TextItem clientCompanyAddressItem;

	public MainProjectInfoGroupname3Update() {
		DSMainProjectInfo ds = DSMainProjectInfo.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		clientIdItem = new ComboBoxItem("clientId", "客户编码");
		clientIdItem.setWidth("*");
		__formItems.add(clientIdItem);
		projectSalesTeamItem = new TextItem("projectSalesTeam", "项目营销团队");
		__formItems.add(projectSalesTeamItem);
		projectSalesmanItem = new SelectItem("projectSalesman", "项目营销员");
		projectSalesmanItem.setValueMap((LinkedHashMap)ds.getField("projectSalesman").getValueMap());
		__formItems.add(projectSalesmanItem);
		projectSalesTeamManagerItem = new SelectItem("projectSalesTeamManager", "运营董事");
		projectSalesTeamManagerItem.setValueMap((LinkedHashMap)ds.getField("projectSalesTeamManager").getValueMap());
		__formItems.add(projectSalesTeamManagerItem);
		designTeamItem = new SelectItem("designTeam", "主办设计团队");
		designTeamItem.setValueMap((LinkedHashMap)ds.getField("designTeam").getValueMap());
		__formItems.add(designTeamItem);
		projectManagerItem = new SelectItem("projectManager", "项目经理");
		projectManagerItem.setValueMap((LinkedHashMap)ds.getField("projectManager").getValueMap());
		__formItems.add(projectManagerItem);
		projectLeaderItem = new SelectItem("projectLeader", "项目主管领导");
		projectLeaderItem.setValueMap((LinkedHashMap)ds.getField("projectLeader").getValueMap());
		__formItems.add(projectLeaderItem);
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setValueMap((LinkedHashMap)ds.getField("projectBaseOn").getValueMap());
		__formItems.add(projectBaseOnItem);
		clientNameItem = new TextItem("clientName", "客户姓名");
		clientNameItem.setWidth("*");
		__formItems.add(clientNameItem);
		clientPhoneItem = new TextItem("clientPhone", "客户联系方式");
		clientPhoneItem.setWidth("*");
		__formItems.add(clientPhoneItem);
		clientCompanyItem = new TextItem("clientCompany", "客户所在公司名称");
		clientCompanyItem.setWidth("*");
		__formItems.add(clientCompanyItem);
		clientCompanyAddressItem = new TextItem("clientCompanyAddress", "客户公司地址");
		clientCompanyAddressItem.setWidth("*");
		__formItems.add(clientCompanyAddressItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		setName("项目详情3");
		addMember(__form);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMainProjectInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
