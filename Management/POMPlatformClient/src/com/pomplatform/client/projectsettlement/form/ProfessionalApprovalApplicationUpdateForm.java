package com.pomplatform.client.projectsettlement.form;

import java.math.BigDecimal;
import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.projectsettlement.datasource.DSProfessionalApprovalApplication;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ProfessionalApprovalApplicationUpdateForm extends AbstractWizadPage
{


	private final TextItem professionalApproval_idItem;
	private final SelectItem employeeIdItem;
	private final SelectItem employeeNoItem;
	private final DateTimeItem startDateItem;
	private final TextItem deleteFlagItem;
	private final TextItem projectIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem plateIdItem;
	private final TextItem designTypeItem;
	private final TextItem projectTypeItem;
	private final TextItem plateManagerIdItem;
	private final TextItem projectLevelItem;
	private final TextItem departmentManagerIdItem;
	//private final TextItem projectManageIdItem;
	private final ComboBoxItem projectManageIdItem;
	//private final TextItem projectManageNameItem;
	//private final TextItem projectManageDepartmentIdItem;
	private final TextItem commonAreaItem;
	private final TextItem logisticsAreaItem;
	private final TextItem cadAreaItem;
	private final TextItem totalIntegralItem;
	private final TextItem projectIntegralItem;
	private final TextItem reserveIntegralItem;
	private final TextItem percentageItem;

	public ProfessionalApprovalApplicationUpdateForm() {
		DSProfessionalApprovalApplication ds = DSProfessionalApprovalApplication.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		professionalApproval_idItem = new TextItem("professionalApproval_id", "专业负责人审批编码");
		professionalApproval_idItem.setDisabled(true);
		professionalApproval_idItem.setRequired(true);
		professionalApproval_idItem.setHidden(true);
		IsIntegerValidator professionalApproval_idValidator = new IsIntegerValidator();
		professionalApproval_idItem.setValidators(professionalApproval_idValidator);
		__formItems.add(professionalApproval_idItem);
		employeeIdItem = new SelectItem("employeeId", "创建人");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		employeeNoItem = new SelectItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		employeeNoItem.setValueMap(KeyValueManager.getValueMap(""));
		__formItems.add(employeeNoItem);
		startDateItem = new DateTimeItem("startDate", "开始日期");
		startDateItem.setDisabled(true);
		startDateItem.setWidth("*");
		__formItems.add(startDateItem);
		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagItem.setHidden(true);
		__formItems.add(deleteFlagItem);
		projectIdItem = new TextItem("projectId", "项目");
		projectIdItem.setHidden(true);
		__formItems.add(projectIdItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setDisabled(true);
		projectCodeItem.setWidth("*");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		__formItems.add(projectNameItem);
		contractIdItem = new TextItem("contractId", "合同编码");
		contractIdItem.setDisabled(true);
		contractIdItem.setHidden(true);
		__formItems.add(contractIdItem);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setHidden(true);
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setHidden(true);
		__formItems.add(contractNameItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setDisabled(true);
		plateIdItem.setWidth("*");
		__formItems.add(plateIdItem);
		designTypeItem = new TextItem("designType", "业务类别");
		designTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		designTypeItem.setDisabled(true);
		designTypeItem.setWidth("*");
		__formItems.add(designTypeItem);
		projectTypeItem = new TextItem("projectType", "项目类型");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		projectTypeItem.setDisabled(true);
		projectTypeItem.setWidth("*");
		__formItems.add(projectTypeItem);
		plateManagerIdItem = new TextItem("plateManagerId", "事业部负责人");
		plateManagerIdItem.setDisabled(true);
		plateManagerIdItem.setWidth("*");
		__formItems.add(plateManagerIdItem);
		projectLevelItem = new TextItem("projectLevel", "项目等级");
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		projectLevelItem.setDisabled(true);
		projectLevelItem.setWidth("*");
		__formItems.add(projectLevelItem);
		departmentManagerIdItem = new TextItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentManagerIdItem.setDisabled(true);
		departmentManagerIdItem.setWidth("*");
		__formItems.add(departmentManagerIdItem);
		//projectManageIdItem = new TextItem("projectManageId", "积分管理员");
		//projectManageIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		//projectManageIdItem.setHidden(true);
		//__formItems.add(projectManageIdItem);

		/*projectManageNameItem = new TextItem("projectManageName", "专业负责人");
		projectManageNameItem.setWidth("*");
		__formItems.add(projectManageNameItem);
		projectManageDepartmentIdItem = new TextItem("projectManageDepartmentId", "专业负责人部门");
		projectManageDepartmentIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		projectManageDepartmentIdItem.setWidth("*");
		__formItems.add(projectManageDepartmentIdItem);*/
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		eNameField.setCanFilter(true);
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		projectManageIdItem = new ComboBoxItem("projectManageId","专业负责人");
		projectManageIdItem.setWidth("*");
		projectManageIdItem.setRequired(true);
		projectManageIdItem.setChangeOnKeypress(false);
		projectManageIdItem.setPickListWidth(500);
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		projectManageIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		projectManageIdItem.setDefaultToFirstOption(false);
		projectManageIdItem.setOptionCriteria(c);
		projectManageIdItem.setValueField("employeeId");
		projectManageIdItem.setDisplayField("employeeName");
		projectManageIdItem.setUseClientFiltering(true);
		projectManageIdItem.setPickListFields(eNoField, eNameField,departmentIdField);
		projectManageIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(projectManageIdItem);

		commonAreaItem = new TextItem("commonArea", "公区面积");
		commonAreaItem.setDisabled(true);
		commonAreaItem.setWidth("*");
		__formItems.add(commonAreaItem);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		logisticsAreaItem.setDisabled(true);
		logisticsAreaItem.setWidth("*");
		__formItems.add(logisticsAreaItem);
		cadAreaItem = new TextItem("cadArea", "设计面积");
		cadAreaItem.setDisabled(true);
		cadAreaItem.setWidth("*");
		__formItems.add(cadAreaItem);
		totalIntegralItem = new TextItem("totalIntegral", "项目总积分");
		totalIntegralItem.setDisabled(true);
		totalIntegralItem.setWidth("*");
		__formItems.add(totalIntegralItem);
		projectIntegralItem = new TextItem("projectIntegral", "项目积分");
		projectIntegralItem.setDisabled(true);
		projectIntegralItem.setWidth("*");
		__formItems.add(projectIntegralItem);
		reserveIntegralItem = new TextItem("reserveIntegral", "预留积分");
		reserveIntegralItem.setDisabled(true);
		reserveIntegralItem.setWidth("*");
		__formItems.add(reserveIntegralItem);
		percentageItem = new TextItem("percentage", "核算比例%");
		percentageItem.setWidth("*");
		percentageItem.addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				BigDecimal percentage = BaseHelpUtils.getBigDecimalValue(event.getValue());
				//核算比例取值0-10%
				if(percentage.compareTo(BigDecimal.ZERO)<0  || percentage.compareTo(BigDecimal.TEN)>0) {
					percentageItem.setValue(0);
					SC.say("核算比例取值范围0-10%");
				}else {
					percentageItem.setValue(percentage);
					SC.debugger();

					percentage =percentage.multiply(new BigDecimal(0.01)).setScale(2,BigDecimal.ROUND_HALF_DOWN);

					//获取项目总积分
					BigDecimal totalIntegral = BaseHelpUtils.getBigDecimalValue(totalIntegralItem.getValue());

					//预留积分
					BigDecimal reserveIntegral = totalIntegral.multiply(percentage).setScale(2, BigDecimal.ROUND_HALF_DOWN);
					//setReserveIntegral(reserveIntegral);
					reserveIntegralItem.setValue(reserveIntegral);

					BigDecimal projectIntegral = totalIntegral.subtract(reserveIntegral);
					projectIntegralItem.setValue(projectIntegral);

				}
			}
		});
		__formItems.add(percentageItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	public void startEdit() {
		if(getRecord() != null){
			__form.editRecord(getRecord());
			Map<String,Object> params = new HashMap<>();
			params.put("projectId", record.getAttribute("projectId"));
			DBDataSource.callOperation("ST_ProjectSettlement","find", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0&& dsResponse.getData().length > 0) {
						percentageItem.setDisabled(true);
					}else{
						percentageItem.setDisabled(false);
					}
				}
			});
		}else{
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSProfessionalApprovalApplication.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
