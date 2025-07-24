package com.pomplatform.client.projectsettlement.form;

import java.math.BigDecimal;
import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.operation.datasource.DSProjectManager;
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

public class ProfessionalApprovalApplicationNewForm extends AbstractWizadPage
{
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem plateIdItem;
	private final SelectItem designTypeItem;
	private final SelectItem projectLevelItem;
	private final TextItem plateManagerIdItem;
	private final ComboBoxItem departmentManagerIdItem;
	private final ComboBoxItem projectManageIdItem;
	private final TextItem humanAmountItem;
	private final TextItem commonAreaItem;
	private final TextItem logisticsAreaItem;
	private final TextItem bimAreaItem;
	private final TextItem cadAreaItem;
	private final TextItem totalAmountItem;
	private final TextItem percentageItem;
	private final TextItem oldProjectDiscountItem;
	private final TextItem projectGradeTypeItem;
	private final SelectItem contractCodeItem;
	private final TextItem subContractNameItem;
	private final SelectItem projectIdItem;
	private final SelectItem projectTypeItem;
	private final TextItem totalIntegralItem;
	private final TextItem reserveIntegralItem;
	private final TextItem projectIntegralItem;
	private final TextItem budgetItem;
	private final TextItem complaintPercentageItem;
	private final TextItem complaintIntegralItem;
	private final TextItem sureIntegralItem;
	private final SelectItem statusItem;
	private final SelectItem designPhaseItem;
	private final TextItem workHoursItem;
	private final TextItem projectProgressItem;
	private final TextItem appendTotalIntegralItem;
	private final TextItem appendIntegralItem;
	private final TextItem projectFinishPercentItem;
	private final ComboBoxItem parentIdItem;
	private final TextItem totalFinishPercentItem;
	private final TextItem lastPercentItem;
	private final TextItem timeCycleItem;

	private final BooleanItem isOrNotItem;
	private final SelectItem initiateDesignItem;

	public BigDecimal reserveIntegral;

	public BigDecimal getReserveIntegral() {
		return reserveIntegral;
	}

	public void setReserveIntegral(BigDecimal reserveIntegral) {
		this.reserveIntegral = reserveIntegral;
	}

	public ProfessionalApprovalApplicationNewForm(boolean isAuto) {
		DSProjectManager ds = DSProjectManager.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractCodeItem = new SelectItem("contractCode", "合同编号");
		contractCodeItem.setValueMap((LinkedHashMap) ds.getField("contractCode").getValueMap());
		contractCodeItem.hide();
		__formItems.add(contractCodeItem);
		contractCodeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Object val = event.getValue();
				if (ClientUtil.isNullOrEmpty(val)) {
					return;
				}
				projectCodeItem.setValue(RoleDefinition.generateProjectID(val.toString()));
				LinkedHashMap<String, String> keyValues = KeyValueManager.getValueMap("contracts");
				String contractName = keyValues.get(val.toString());
				String projectNameNew = contractName.replace("合同", "项目");
				if (projectNameNew.equals(contractName)) {
					projectNameNew = projectNameNew.concat("项目");
				}
				projectNameItem.setValue(projectNameNew);
			}

		});
		subContractNameItem = new TextItem("subContractName", "合同名称");
		subContractNameItem.hide();
		__formItems.add(subContractNameItem);
		projectIdItem = new SelectItem("projectId", "项目编码");
		KeyValueManager.loadValueMap("projects",projectIdItem);
		projectIdItem.setDisabled(true);
		projectIdItem.setRequired(true);
		projectIdItem.hide();
		IsIntegerValidator projectIdValidator = new IsIntegerValidator();
		projectIdItem.setValidators(projectIdValidator);
		__formItems.add(projectIdItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectCodeItem.setDisabled(true);
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectNameItem.setDisabled(true);
		__formItems.add(projectNameItem);
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setDisabled(true);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);
		designTypeItem = new SelectItem("designType", "业务类别");
		designTypeItem.setWidth("*");
		designTypeItem.setDisabled(true);
		designTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		__formItems.add(designTypeItem);
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setDisabled(true);
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		__formItems.add(projectTypeItem);
		plateManagerIdItem = new ComboBoxItem("plateManagerId", "事业部负责人");
		plateManagerIdItem.setWidth("*");
		plateManagerIdItem.setDisabled(true);
		plateManagerIdItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("employees",plateManagerIdItem);
		RoleDefinition.setEmployeeItemValueMapByRoleId(plateManagerIdItem, 2);
		__formItems.add(plateManagerIdItem);
		projectLevelItem = new SelectItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setDisabled(true);
		projectLevelItem.setValueMap((LinkedHashMap) ds.getField("projectLevel").getValueMap());
		__formItems.add(projectLevelItem);
		departmentManagerIdItem = new ComboBoxItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.setDisabled(true);
		departmentManagerIdItem.setWidth("*");
		departmentManagerIdItem.setChangeOnKeypress(false);
		KeyValueManager.loadValueMap("employees",departmentManagerIdItem);
		RoleDefinition.setEmployeeItemValueMapByRoleId(departmentManagerIdItem, 3);
		__formItems.add(departmentManagerIdItem);
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
		humanAmountItem = new TextItem("humanAmount", "手工计算积分");
		humanAmountItem.setDisabled(false);
		humanAmountItem.hide();
		humanAmountItem.setWidth("*");
		__formItems.add(humanAmountItem);
		commonAreaItem = new TextItem("commonArea", "公区面积");
		commonAreaItem.setDisabled(true);
		commonAreaItem.setWidth("*");
		commonAreaItem.setDefaultValue(0);
		__formItems.add(commonAreaItem);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		logisticsAreaItem.setDisabled(true);
		logisticsAreaItem.setWidth("*");
		logisticsAreaItem.setDefaultValue(0);
		__formItems.add(logisticsAreaItem);
		bimAreaItem = new TextItem("bimArea", "BIM面积");
		bimAreaItem.setWidth("*");
		bimAreaItem.setDisabled(true);
		bimAreaItem.hide();
		bimAreaItem.setDefaultValue(0);
		__formItems.add(bimAreaItem);
		cadAreaItem = new TextItem("cadArea", "设计面积");
		cadAreaItem.setWidth("*");
		cadAreaItem.setDisabled(true);
		cadAreaItem.setDefaultValue(0);
		__formItems.add(cadAreaItem);
		totalAmountItem = new TextItem("totalAmount", "项目总金额");
		totalAmountItem.setWidth("*");
		totalAmountItem.hide();
		totalAmountItem.setDisabled(true);
		totalAmountItem.setDefaultValue(0);
		__formItems.add(totalAmountItem);
		complaintPercentageItem = new TextItem("complaintPercentage", "投诉折算比例%");
		complaintPercentageItem.setWidth("*");
		complaintPercentageItem.setDefaultValue(0);
		complaintPercentageItem.hide();
		__formItems.add(complaintPercentageItem);
		oldProjectDiscountItem = new TextItem("oldProjectDiscount", "遗留项目折算%");
		oldProjectDiscountItem.setWidth("*");
		oldProjectDiscountItem.hide();
		oldProjectDiscountItem.setDefaultValue(50);
		__formItems.add(oldProjectDiscountItem);
		projectGradeTypeItem = new TextItem("projectGradeType", "项目级别类型");
		projectGradeTypeItem.setWidth("*");
		projectGradeTypeItem.hide();
		projectGradeTypeItem.setValue(KeyValueManager.getValueMap("system_dictionary_25"));
		__formItems.add(projectGradeTypeItem);

		totalIntegralItem = new TextItem("totalIntegral", "项目总积分");
		totalIntegralItem.setWidth("*");
		totalIntegralItem.setDisabled(true);
		__formItems.add(totalIntegralItem);
		projectIntegralItem = new TextItem("projectIntegral", "项目积分");
		projectIntegralItem.setWidth("*");
		projectIntegralItem.setDisabled(true);
		__formItems.add(projectIntegralItem);
		reserveIntegralItem = new TextItem("reserveIntegral", "预留积分");
		reserveIntegralItem.setWidth("*");
		reserveIntegralItem.setDisabled(true);
		__formItems.add(reserveIntegralItem);
		complaintIntegralItem = new TextItem("complaintIntegral", "投诉保证金");
		complaintIntegralItem.setWidth("*");
		complaintIntegralItem.setDisabled(true);
		complaintIntegralItem.hide();
		complaintIntegralItem.setDefaultValue(0);
		__formItems.add(complaintIntegralItem);
		percentageItem = new TextItem("percentage", "核算比例%");
		percentageItem.setWidth("*");
		percentageItem.setDefaultValue(0);
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
					setReserveIntegral(reserveIntegral);
					reserveIntegralItem.setValue(reserveIntegral);

					BigDecimal projectIntegral = totalIntegral.subtract(reserveIntegral);
					projectIntegralItem.setValue(projectIntegral);

				}
			}
		});

		__formItems.add(percentageItem);
		budgetItem = new TextItem("budget", "预算");
		budgetItem.hide();
		__formItems.add(budgetItem);
		sureIntegralItem = new TextItem("sureIntegral", "确认积分");
		sureIntegralItem.hide();
		sureIntegralItem.setRequired(true);
		IsFloatValidator sureIntegralValidator = new IsFloatValidator();
		sureIntegralItem.setValidators(sureIntegralValidator);
		__formItems.add(sureIntegralItem);
		statusItem = new SelectItem("status", "项目状态");
		statusItem.hide();
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		__formItems.add(statusItem);
		designPhaseItem = new SelectItem("designPhase", "设计阶段");
		designPhaseItem.hide();
		designPhaseItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
		__formItems.add(designPhaseItem);
		workHoursItem = new TextItem("workHours", "预估工时");
		workHoursItem.hide();
		__formItems.add(workHoursItem);
		projectProgressItem = new TextItem("projectProgress", "项目进度");
		projectProgressItem.hide();
		__formItems.add(projectProgressItem);
		appendTotalIntegralItem = new TextItem("appendTotalIntegral", "追加总积分");
		appendTotalIntegralItem.hide();
		__formItems.add(appendTotalIntegralItem);
		appendIntegralItem = new TextItem("appendIntegral", "追加积分");
		appendIntegralItem.hide();
		__formItems.add(appendIntegralItem);
		projectFinishPercentItem = new TextItem("projectFinishPercent", "项目完成百分比");
		projectFinishPercentItem.hide();
		__formItems.add(projectFinishPercentItem);
		parentIdItem = new ComboBoxItem("parentId", "父级项目");
		parentIdItem.hide();
		parentIdItem.setWidth("*");
		KeyValueManager.loadValueMap("projects",parentIdItem);
		__formItems.add(parentIdItem);
		totalFinishPercentItem = new TextItem("totalFinishPercent", "项目总完成百分比");
		totalFinishPercentItem.hide();
		__formItems.add(totalFinishPercentItem);
		lastPercentItem = new TextItem("lastPercent", "上次结算时的百分比");
		lastPercentItem.hide();
		__formItems.add(lastPercentItem);

		timeCycleItem = new TextItem("timeCycle","时间周期(月)");
		timeCycleItem.setWidth("*");
		if(!isAuto){
			__formItems.add(timeCycleItem);
		}

		isOrNotItem = new BooleanItem("isOrNot","是否需要审批");
		isOrNotItem.setWidth("*");
		isOrNotItem.hide();
		isOrNotItem.setDefaultValue(false);
		__formItems.add(isOrNotItem);

		initiateDesignItem = new SelectItem("initiateDesign","方案主创");
		initiateDesignItem.setWidth("*");
		initiateDesignItem.hide();
		RoleDefinition.setEmployeeItemValueMapByRoleId(initiateDesignItem,137);
		__formItems.add(initiateDesignItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);

		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		setName("基本信息");
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null){
			__form.editRecord(getRecord());
			Map<String,Object> params = new HashMap<>();
			//params.put("projectId", projectIdItem.getValue());
			params.put("projectId", record.getAttribute("projectId"));
			//params.put("stageId", record.getAttribute("stageId"));
			//params.put("settlementId", getRecord().getAttribute("settlementId"));
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
	public Map getValuesAsMap() {
		Map values = __form.getValues();
		values.put("operator", ClientUtil.getUserId());
		return values;
	}


}
