package com.pomplatform.client.personnel.form;

import java.util.*;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.CDOnLoadFlowAuditListOfPreProjectReportBuisnessData;

public class OnLoadFlowAuditListOfPreProjectReportBuisnessDataSearchForm extends SearchForm
{

	private static final Logger __LOGGER = Logger.getLogger("");
	private final SelectItem processStatusItem;
	private final TextItem employeeIdItem;
	private final TextItem processTypeItem;
	private final SelectItem companyIdItem;
	private final ComboBoxItem applyEmployeeIdItem;
	private final IPickTreeItem departmentIdItem;
	private final SelectItem statusItem;
	private final TextItem projectNameItem;
	private final TextItem projectNameOneItem;
	private final SelectItem projectTypeItem;

	private final ComboBoxItem projectSalesTeamItem;
	private final TextItem customerNameItem;
	private final ComboBoxItem provinceItem;
	private final ComboBoxItem cityItem;
	private final SelectItem projectOriginationItem;
	private final SelectItem isOperationDepartmentItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;




	public OnLoadFlowAuditListOfPreProjectReportBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadFlowAuditListOfPreProjectReportBuisnessData.getInstance());
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.setHidden(false);
		KeyValueManager.loadValueMap("process_status", processStatusItem);
		processStatusItem.setWidth("*");
		
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		statusItem = new SelectItem("status", "状态");
		statusItem.setHidden(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setHidden(true);
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		employeeIdItem = new TextItem("employeeId", "处理人");
		employeeIdItem.setHidden(true);


		applyEmployeeIdItem = new ComboBoxItem("applyEmployeeId", "报备人");
		applyEmployeeIdItem.setWidth("*");
		KeyValueManager.loadValueMap("employees",applyEmployeeIdItem);


		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.hide();

		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");

		projectNameOneItem = new TextItem("projectNameOne", "项目修改前项目名称");
		projectNameOneItem.setWidth("*");

		projectTypeItem = new SelectItem("projectType", "项目业态");
		KeyValueManager.loadValueMap("pre_business_type",projectTypeItem);
		projectTypeItem.setWidth("*");

		projectSalesTeamItem=new ComboBoxItem("projectSalesTeam","项目营销团队"); 
		projectSalesTeamItem.setWidth("*");
		KeyValueManager.loadValueMap("plate_str", projectSalesTeamItem);

		customerNameItem=new TextItem("customerName","客户名称");
		customerNameItem.setWidth("*");
		customerNameItem.hide();

		provinceItem=new ComboBoxItem("province","省");
		provinceItem.setWidth("*");
		provinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
		provinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
				provinceMap.put("optType", "getCityNames");
				provinceMap.put("province", provinceItem.getValue());
				DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] cityRecords = dsResponse.getData();
							LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
							for(Record e : cityRecords){
								cityMap.put(e.getAttribute("allName"), e.getAttribute("allName"));
							}
							cityItem.setValueMap(cityMap);
						}
					}
				});
			}
		});
		provinceItem.setChangeOnKeypress(true);

		cityItem=new ComboBoxItem("city","市");
		cityItem.setWidth("*");
		cityItem.setChangeOnKeypress(true);

		projectOriginationItem=new SelectItem("projectOrigination","项目来源渠道");
		projectOriginationItem.setWidth("*");
		projectOriginationItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));
		
		LinkedHashMap<Boolean, String> linkMap=new LinkedHashMap<>();
		linkMap.put(true, "是");
		linkMap.put(false, "否");

		isOperationDepartmentItem=new SelectItem("isOperationDepartment","是否运营组分配项目");
		isOperationDepartmentItem.setWidth("*");
		isOperationDepartmentItem.setValueMap(linkMap);
		
		startDateItem=new DateTimeItem("createTimeStart","登记开始时间");
		startDateItem.setUseTextField(true);   
		startDateItem.setWidth("*");

		endDateItem=new DateTimeItem("createTimeEnd","登记结束时间");
		endDateItem.setUseTextField(true);   
		endDateItem.setWidth("*");


		setItems(applyEmployeeIdItem,projectNameItem,projectNameOneItem,projectSalesTeamItem,customerNameItem,provinceItem,cityItem,projectOriginationItem,isOperationDepartmentItem,processStatusItem, processTypeItem, companyIdItem,departmentIdItem,statusItem, projectTypeItem,startDateItem,endDateItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}
	

}
