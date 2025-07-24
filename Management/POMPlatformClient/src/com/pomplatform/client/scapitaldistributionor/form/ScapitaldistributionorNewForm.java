package com.pomplatform.client.scapitaldistributionor.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.contractinfo.datasource.DSContractInfo;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.scapitaldistributionor.datasource.DSScapitaldistributionor;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class ScapitaldistributionorNewForm extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private final DelicacyListGrid __grid;
	
	private final TextItem codeItem;
	private final TextItem processInstanceIdItem;
	private final SelectItem applyEmployeeIdItem;
	private final SelectItem employeeIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem titleItem;
	private final TextItem companyIdItem;
	private final ComboBoxItem contractIdItem;
	private final ComboBoxItem capitalIdItem;
	private final DateTimeItem applyTimeItem;
	private final DateTimeItem completeTimeItem;
	private final TextAreaItem remarkItem;
	private final CheckboxItem isCompletedItem;
	private final SelectItem mainProfessionalItem;
	private final FloatItem contractChangeAmountItem;
	private final FloatItem contractAmountItem;
	private final FloatItem capitalAmountItem;
	
	private DelicacyListGrid subContractGrid;//子订单Grid

	public ScapitaldistributionorNewForm() {
		
		String employeeId = ClientUtil.getUserId();
		Map<String, String> map = new HashMap<>();
		map.put("employeeId", employeeId);

		DSScapitaldistributionor ds = DSScapitaldistributionor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		codeItem = new TextItem("code", "报销编号");
		codeItem.hide();
		codeItem.setWidth("*");
		__formItems.add(codeItem);
		processInstanceIdItem = new TextItem("processInstanceId", "流程编码");
		processInstanceIdItem.hide();
		__formItems.add(processInstanceIdItem);

		applyEmployeeIdItem = new SelectItem("applyEmployeeId", "起草人");
		applyEmployeeIdItem.setDefaultValue(employeeId);
		applyEmployeeIdItem.setWidth("*");
		applyEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		applyEmployeeIdItem.setDisabled(true);
		__formItems.add(applyEmployeeIdItem);

		employeeIdItem = new SelectItem("employeeId", "报销人");
		employeeIdItem.setDefaultValue(employeeId);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.hide();
		__formItems.add(employeeIdItem);

		departmentIdItem = new SelectItem("departmentId", "报销人所在部门");
		departmentIdItem.setDefaultValue(10);
		// departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		// map.put("optType", "departmentId");
		// DBDataSource.callOperation("EP_GetUserInfoById", map, new
		// DSCallback() {
		// @Override
		// public void execute(DSResponse dsResponse, Object data, DSRequest
		// dsRequest) {
		// if (dsResponse.getStatus() >= 0) {
		// Record[] record = dsResponse.getData();
		// if(null != record && record.length > 0){
		// departmentIdItem.setValue(record[0].getAttribute("departmentId"));
		// }
		// }
		// }
		// });
		departmentIdItem.setWidth("*");
		departmentIdItem.hide();
		__formItems.add(departmentIdItem);

		titleItem = new TextItem("title", "主题");
		titleItem.setRequired(true);
		titleItem.setWidth("*");
		__formItems.add(titleItem);

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();
		__formItems.add(companyIdItem);

		
		ListGridField contractIdField = new ListGridField("contractId", "编码", 32);
		ListGridField contractNameField = new ListGridField("contractName", "名称", 420);
		ListGridField contractCodeField = new ListGridField("contractCode", "编号");
		ListGridField signingMoneySumField = new ListGridField("signingMoneySum", "金额");
        
		contractIdItem = new ComboBoxItem("contractId", "合同");
		contractIdItem.setChangeOnKeypress(false);
		contractIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		contractIdItem.setRequired(true);
		contractIdItem.setWidth("*");
		contractIdItem.setDisplayField("contractName");
		contractIdItem.setValueField("contractId");
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		contractIdItem.setOptionDataSource(DSContractInfo.getInstance());
		contractIdItem.setPickListFields(contractIdField, contractNameField, contractCodeField, signingMoneySumField);
		contractIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				capitalIdItem.setDefaultValue("");
				capitalIdItem.clearValue();
				capitalIdItem.setValueMap(new LinkedHashMap<>());
				mainProfessionalItem.clearValue();
				mainProfessionalItem.setValueMap(new LinkedHashMap<>());
				capitalAmountItem.clearValue();
				__grid.setData(new RecordList());
				if(null != event.getValue()){
					int contractId = BaseHelpUtils.getIntValue(event.getValue());
					setCapitalsSelectValue(contractId);
					setMainProfessional(contractId);
					setContractInfo(contractId);
					setSubContractGridData(contractId);
				}
			}
		});
		__formItems.add(contractIdItem);

		capitalIdItem = new ComboBoxItem("capitalId", "回款信息");
		capitalIdItem.setChangeOnKeypress(false);
		capitalIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		capitalIdItem.setRequired(true);
		capitalIdItem.setWidth("*");
		capitalIdItem.setValueMap(new LinkedHashMap<>());
		capitalIdItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != event.getValue()){
					int capitalId = BaseHelpUtils.getIntValue(event.getValue());
					capitalAmountItem.clearValue();
					setCapitalAmount(capitalId);
				}
			}
		});
		__formItems.add(capitalIdItem);

		applyTimeItem = new DateTimeItem("applyTime", "申请时间");
		applyTimeItem.hide();
		__formItems.add(applyTimeItem);

		completeTimeItem = new DateTimeItem("completeTime", "完成时间");
		completeTimeItem.hide();
		__formItems.add(completeTimeItem);

		isCompletedItem = new CheckboxItem("isCompleted", "是否完成");
		isCompletedItem.hide();
		__formItems.add(isCompletedItem);

		mainProfessionalItem = new SelectItem("mainProfessional", "主专业");
		mainProfessionalItem.setWidth("*");
		mainProfessionalItem.setRequired(true);
		mainProfessionalItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				__grid.setData(new RecordList());
				if(null != event.getValue()){
					setGridData(contractIdItem.getValue(), event.getValue());
				}
				
			}
		});
		__formItems.add(mainProfessionalItem);

		contractAmountItem = new FloatItem("contractAmount", "合同金额(选定合同自动带出)");
		contractAmountItem.setWidth("*");
		contractAmountItem.setDisabled(true);
		__formItems.add(contractAmountItem);
		
		contractChangeAmountItem = new FloatItem("contractChangeAmount", "合同变更金额");
		contractChangeAmountItem.setWidth("*");
		__formItems.add(contractChangeAmountItem);
		
		capitalAmountItem = new FloatItem("capitalAmount", "回款金额(选择回款自动带出)");
		capitalAmountItem.setWidth("*");
		capitalAmountItem.setDisabled(true);
		__formItems.add(capitalAmountItem);
		
		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setRowSpan(3);
		remarkItem.setColSpan(4);
		remarkItem.setWidth("*");
		remarkItem.setRequired(true);
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		contractIdItem.setColSpan(4);
		capitalIdItem.setColSpan(4);
		
		ListGridField employeeNoField = new ListGridField("employeeNo", "员工编号");
		ListGridField employeeNameField = new ListGridField("employeeName", "员工姓名");
		ListGridField departmentIdField = new ListGridField("departmentId", "部门");
		ListGridField roleIdField = new ListGridField("roleId", "回款中的角色");
		
		__grid = new DelicacyListGrid();
		__grid.setDataSource(DSEmployee.getInstance());
		__grid.setFields(employeeNoField, employeeNameField, departmentIdField, roleIdField);
		__grid.setHeaderHeight(60);
		__grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("回款分配相关人员(选定主专业后进行筛选)", new String[] { "employeeNo", "employeeName", "departmentId", "roleId" }) });
		__grid.setHeight("40%");

		
		VLayout mainFrame = new VLayout();
		mainFrame.setWidth100();
		mainFrame.setHeight100();
		mainFrame.addMember(__form);
		mainFrame.addMember(__grid);
		addMember(mainFrame);
	}
	
	/**
	 * 
	 * @Title: setSubContractGridData 
	 * @Description: 设置子订单数据
	 * @param @param contractId   
	 * @return void   
	 * @throws
	 */
	private void setSubContractGridData(int contractId){
		Map<String, Object> params = new HashMap<>();
		params.put("contractId", contractId);
		params.put("opt_type", "getProjectByContractId");
		DBDataSource.callOperation("EP_CustomCapitalDistributionProcess", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				subContractGrid.setData(new RecordList());
				if(dsResponse.getStatus() > 0){
					Record [] record = dsResponse.getData();
					for (Record record2 : record) {
						record2.setAttribute("subContractId", record2.getAttribute("projectId"));
						record2.setAttribute("money", 0);
						record2.setAttribute("code", record2.getAttribute("projectId"));
					}
					subContractGrid.setData(record);
				} else {
					__logger.info("错误！ " + dsResponse.getErrors().get("errorMsg"));
				}
				
			}
		});
	}
	
	/**
	 * 
	 * @Title: setGridData 
	 * @Description: 设置人员GRID数据
	 * @param @param contractId
	 * @param @param plateId   
	 * @return void   
	 * @throws
	 */
	private void setGridData(Object contractId, Object plateId){
		if(null !=contractId  && null != plateId ){
			Map<String, Object> params = new HashMap<>();
			params.put("contractId", contractId);
			params.put("plateId", plateId);
			params.put("opt_type", "getRelevantPersonnelByContractId");
			DBDataSource.callOperation("EP_CustomCapitalDistributionProcess", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() > 0){
						__grid.setData(dsResponse.getData());
					} else {
						__logger.info("错误！ " + dsResponse.getErrors().get("errorMsg"));
					}
					
				}
			});
		}
	}
	
	/**
	 * 
	 * @Title: setCapitalAmount 
	 * @Description: 设置回款金额
	 * @param @param capitalId   
	 * @return void   
	 * @throws
	 */
	private void setCapitalAmount(int capitalId){
		if(capitalId > 0){
			Map<String, Object> params = new HashMap<>();
			params.put("opt_type", "getCapitalInfoById");
			params.put("capitalId", capitalId);
			DBDataSource.callOperation("EP_CustomCapitalDistributionProcess", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() > 0){
						Record record = dsResponse.getData()[0];
						capitalAmountItem.setValue(record.getAttribute("borrowMoney"));
					} else {
						ClientUtil.displayErrorMessage(dsResponse);
					}
					
				}
			});
		}
	}
	
	/**
	 * 
	 * @Title: setCapitalsSelectValue 
	 * @Description: 设置回款信息选择
	 * @param @param contractId   
	 * @return void   
	 * @throws
	 */
	private void setCapitalsSelectValue(int contractId){
		if(contractId > 0){
			Map<String, Object> params = new HashMap<>();
			params.put("opt_type", "getCapitalsByContractId");
			params.put("contractId", contractId);
			params.put("processStatus", 0);
			KeyValueManager.setValueMapFromQuery("EP_CustomCapitalDistributionProcess", MapUtils.toJSON(params), capitalIdItem);
		}
	}
	
	/**
	 * 
	 * @Title: setMainProfessional 
	 * @Description: 设置主专业选择数据
	 * @param @param contractId   
	 * @return void   
	 * @throws
	 */
	private void setMainProfessional(int contractId){
		if(contractId > 0){
			Map<String, Object> params = new HashMap<>();
			params.put("opt_type", "getPlatesByContractId");
			params.put("contractId", contractId);
			KeyValueManager.setValueMapFromQuery("EP_CustomCapitalDistributionProcess", MapUtils.toJSON(params), mainProfessionalItem);
		}
	}
	
	/**
	 * 
	 * @Title: setContractInfo 
	 * @Description: 设置合同相关信息
	 * @param @param contractId   
	 * @return void   
	 * @throws
	 */
	private void setContractInfo(int contractId){
		if(contractId > 0){
			Map<String, Object> params = new HashMap<>();
			params.put("opt_type", "getContractInfoById");
			params.put("contractId", contractId);
			DBDataSource.callOperation("EP_CustomCapitalDistributionProcess", params, new DSCallback() {
				
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() > 0){
						Record record = dsResponse.getData()[0];
						contractAmountItem.setValue(record.getAttribute("signingMoneySum"));
//						if(null == contractChangeAmountItem.getValue()){
							contractChangeAmountItem.setValue(record.getAttribute("signingMoneySum"));
//						}
					} else {
						ClientUtil.displayErrorMessage(dsResponse);
					}
					
				}
			});
		}
	}
	
	public void initNewData(Record record){
		if(null != record){
			int contractId = record.getAttributeAsInt("contractId");
			int capitalId = record.getAttributeAsInt("capitalId");
			contractIdItem.setDefaultValue(contractId);
			capitalIdItem.setDefaultValue(capitalId);
			setCapitalsSelectValue(contractId);
			setMainProfessional(contractId);
			setContractInfo(contractId);
			setSubContractGridData(contractId);
			setCapitalAmount(capitalId);
		}
		
	}
	
	@Override
	public boolean checkData() {
		return __form.validate();
	}

	@Override
	public void startEdit() {
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSScapitaldistributionor.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	public DelicacyListGrid getSubContractGrid() {
		return subContractGrid;
	}

	public void setSubContractGrid(DelicacyListGrid subContractGrid) {
		this.subContractGrid = subContractGrid;
	}

	
}
