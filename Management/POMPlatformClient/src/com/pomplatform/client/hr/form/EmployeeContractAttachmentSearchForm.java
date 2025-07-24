package com.pomplatform.client.hr.form;

import java.util.*;

import com.delicacy.client.BasicPermissionStatic;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValue;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.hr.datasource.CDEmployeeContractAttachment;

public class EmployeeContractAttachmentSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final ComboBoxItem plateIdItem;
	private final IPickTreeItem departmentIdItem;
	private final SelectItem statusItem;
	private final SelectItem contractTypeItem;
	private final SelectItem signTypeItem;
	private final DateItem startDateItem;
	private final SelectItem willEndItem;
	private final IntegerItem companyIdItem;

	public EmployeeContractAttachmentSearchForm() {
		setWidth100();
		setHeight100();
		
		employeeIdItem = new ComboBoxItem("employeeId", "职员姓名");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		statusItem = new SelectItem("status", "职员状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		statusItem.setWidth("*");
		statusItem.setDefaultValue(0);
		
		contractTypeItem = new SelectItem("contractType", "合同类型");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_111"));
		contractTypeItem.setWidth("*");
		
		signTypeItem = new SelectItem("signType", "签订类型");
		signTypeItem.setWidth("*");
		signTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_112"));
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		startDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		
		willEndItem = new SelectItem("willEnd", "合同状态");
		willEndItem.setWidth("*");
		willEndItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_113"));

		companyIdItem = new IntegerItem("companyId", "归属公司");
		companyIdItem.setHidden(true);
		//控制只有查看自己员工的权限
		if (ClientUtil.checkIsHavePermission(BasicPermissionStatic.EMPLOYEE_CHECK_OWN_COMPANY_DATA)) {
			int companyId = ClientUtil.getCompanyId();
			companyIdItem.setDefaultValue(companyId);
		}
		
		setItems(employeeIdItem, plateIdItem, departmentIdItem, statusItem, contractTypeItem, signTypeItem, startDateItem, willEndItem ,companyIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
