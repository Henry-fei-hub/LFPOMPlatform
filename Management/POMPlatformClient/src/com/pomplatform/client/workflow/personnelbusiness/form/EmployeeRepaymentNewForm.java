package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.budgetmanagement.panel.OnPayForSeqPanel;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeRepayment;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeRepaymentNewForm extends AbstractWizadPage {
	private final Logger __logger = Logger.getLogger("");
	private final TextItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem departmentIdItem;
	private final SelectItem companyIdItem;
	private final DateItem startDateItem;
	private final TextAreaItem remarkItem;
	private final ComboBoxItem parentIdItem;
	private final TextItem drafterItem;
	private final SelectItem otherNameItem;
	private final SelectItem otherBankNameItem;
	private final SelectItem otherBankAccountItem;
	private final FloatItem feeItem;
	private final SelectItem costAttributionItem;

	private final VLayout mainLayout;
	private final LinkedHashMap<Integer, String> projectMap = new LinkedHashMap<>();
	private final ButtonItem payseqIButItem;
	/*private final DoubleItem projectIntegralItem;
	private final DoubleItem costIntegralItem;
	private final DoubleItem leftIntegralItem;
	private final ComboBoxItem projectItem;*/

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public EmployeeRepaymentNewForm() {
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		DSEmployeeRepayment ds = DSEmployeeRepayment.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		mainLayout = new VLayout();
		
		drafterItem = new TextItem("drafter", "起草人");
		drafterItem.setDefaultValue(ClientUtil.getUserId());
		drafterItem.hide();
		__formItems.add(drafterItem);
		
		employeeIdItem = new TextItem("employeeId", "申请人");
		employeeIdItem.setRequired(true);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setDefaultValue(ClientUtil.getUserId());
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		__formItems.add(employeeIdItem);

		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setRequired(true);
		employeeNoItem.setDefaultValue(ClientUtil.getUserNo());
		employeeNoItem.setWidth("*");
		employeeNoItem.setDisabled(true);
		__formItems.add(employeeNoItem);

		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.setRequired(true);
		departmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		departmentIdItem.setDisabled(true);
		__formItems.add(departmentIdItem);

		companyIdItem = new SelectItem("companyId", shouldNotBeNull + "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setRequired(true);
		companyIdItem.setDisabled(true);
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		
		otherNameItem = new SelectItem("projectId", "收款方");
		otherNameItem.setWidth("*");
		otherNameItem.setRequired(true);
		otherNameItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		otherNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankNameItem.clearValue();
				otherBankAccountItem.clearValue();
				setSelectBankAddressByCompanyId(BaseHelpUtils.getIntValue(event.getValue()));
				
			}
		});
		__formItems.add(otherNameItem);
		
		startDateItem = new DateItem("startDate", shouldNotBeNull + "实际还款日期");
		startDateItem.setDefaultValue(new Date());
		startDateItem.setRequired(true);
		startDateItem.setUseTextField(true);
		startDateItem.setUseMask(true);
		startDateItem.setWidth("*");
		__formItems.add(startDateItem);
		
		otherBankNameItem = new SelectItem("projectName", "银行名称(收款方)");
		otherBankNameItem.setValueMap(new LinkedHashMap<>());
		otherBankNameItem.setWidth("*");
		otherBankNameItem.setRequired(true);
		otherBankNameItem.addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				otherBankAccountItem.clearValue();
				setSelectBankAccountByCompanyIdAndBankName(BaseHelpUtils.getIntValue(otherNameItem.getValue()), event.getValue().toString());
			}
		});
		__formItems.add(otherBankNameItem);
		
		Criteria cd = new Criteria();
		cd.addCriteria("status", "0");
		parentIdItem = new ComboBoxItem("parentId", shouldNotBeNull + "付款人");
		parentIdItem.setChangeOnKeypress(false);
		parentIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		parentIdItem.setRequired(true);
		parentIdItem.setWidth("*");
		parentIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		parentIdItem.setOptionCriteria(cd);
		parentIdItem.setValueField("employeeId");
		parentIdItem.setDisplayField("employeeName");
		parentIdItem.setPickListFields(employeeNoField, employeeNameField, departmentIdField);
		__formItems.add(parentIdItem);
		
		otherBankAccountItem = new SelectItem("projectCode", "银行账号(收款方)");
		otherBankAccountItem.setValueMap(new LinkedHashMap<>());
		otherBankAccountItem.setWidth("*");
		otherBankAccountItem.setRequired(true);
		__formItems.add(otherBankAccountItem);
		
		costAttributionItem = new SelectItem("costAttribution", "货币类型");
		costAttributionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));
		costAttributionItem.setRequired(true);
		costAttributionItem.setWidth("*");
		__formItems.add(costAttributionItem);
		
		feeItem = new FloatItem("fee", "还款金额");
		feeItem.setWidth("*");
		feeItem.setRequired(true);
		__formItems.add(feeItem);
		
		/*projectItem=new ComboBoxItem("projectIds","项目");
	    projectItem.setWidth("*");
	    projectItem.setChangeOnKeypress(false);
	    projectItem.setColSpan(4);
	    projectItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
	    projectItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				if(null != projectItem.getValue() && null != projectMap && !projectMap.isEmpty()){
					//获取项目名称
					String value = projectMap.get(ClientUtil.checkAndGetIntValue(projectItem.getValue()));
					projectIntegralItem.show();
					costIntegralItem.show(); 
					leftIntegralItem.show();
					Map<String, Object> map = new HashMap<>();
					int projectId=BaseHelpUtils.getIntValue(projectItem.getValue());
					map.put("projectId",projectId);
					DBDataSource.callOperation("NQ_PayMoneyProject",map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record record[] = dsResponse.getData();
									for (Record obj : record) {
										projectIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("totalIntegral")));
										costIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("costIntegral")));
										leftIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("leftIntegral")));
								}
							}
						}
					});
				}
			}
		});
	  
	    __formItems.add(projectItem);
		
	    projectIntegralItem=new DoubleItem("projectIntegral","项目积分");  
	    projectIntegralItem.setWidth("*");
	    projectIntegralItem.setDisabled(true);
	    projectIntegralItem.setWidth("*");
	    projectIntegralItem.setCanEdit(false);
	    __formItems.add( projectIntegralItem);
	    
	    costIntegralItem=new DoubleItem("costIntegral","项目已用积分");
	    costIntegralItem.setWidth("*");
	    costIntegralItem.setDisabled(true);
	    costIntegralItem.setWidth("*");
	    costIntegralItem.setCanEdit(false);
	    __formItems.add( costIntegralItem);
		
	    
	    leftIntegralItem=new DoubleItem("leftIntegral","项目剩余积分");
	    leftIntegralItem.setWidth("*");
	    leftIntegralItem.setDisabled(true);
	    leftIntegralItem.setWidth("*");
	    leftIntegralItem.setCanEdit(false);
	    __formItems.add( leftIntegralItem); */
	    
	    
	    payseqIButItem=new ButtonItem("预算付款序列");
		payseqIButItem.setStartRow(true);
		payseqIButItem.hide();
		payseqIButItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			@Override
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				PopupWindow popupWindow = new PopupWindow("预算付款序列");
				popupWindow.setWidth("80%");
				popupWindow.setHeight("40%");
				OnPayForSeqPanel payseqPanel=new OnPayForSeqPanel();
				payseqPanel.setRecord(budgetRecord);
				payseqPanel.init();
				popupWindow.addItem(payseqPanel);
				popupWindow.centerInPage();
				popupWindow.show();
				
			}
		});
		__formItems.add(payseqIButItem);

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setColSpan(4);
		remarkItem.setRowSpan(3);
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		mainLayout.addMember(__form);
		addMember(mainLayout);

	}

	private void setSelectBankAccountByCompanyIdAndBankName(int __companyId, String bankAddress){
		otherBankAccountItem.setValueMap(new LinkedHashMap<>());
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankcardByCmpAndAddress");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		params.put("bankAddress", bankAddress);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), otherBankAccountItem);
	}
	
	private void setSelectBankAddressByCompanyId(int __companyId){
		otherBankNameItem.setValueMap(new LinkedHashMap<>());
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getBankAddressByCompany");
		params.put("objectId", __companyId);
		params.put("objectType", 2);
		KeyValueManager.setValueMapFromQuery("EP_CustomSprocessbilllistppporProcess", MapUtils.toJSON(params), otherBankNameItem);
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
		/*projectIntegralItem.hide();
		costIntegralItem.hide(); 
		leftIntegralItem.hide();
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", ClientUtil.getEmployeeId());
		map.put("optType", "getProjectName");
		DBDataSource.callOperation("EP_GetUserInfoById", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] record = dsResponse.getData();
						for (Record obj : record) {
							projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
					}
					projectItem.setValueMap(projectMap);
				}
			}
		});
		projectItem.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(final KeyPressEvent event) {
				if (event.getKeyName().equals("Enter")) {
					final String value = projectItem.getValueAsString();
					Map<String, Object> map = new HashMap<>();
					map.put("projectName", value);
					DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								Record[] record = dsResponse.getData();
									for (Record obj : record) {
										projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
								}
								projectItem.setValueMap(projectMap);
							} else {
								SC.say("没有找到与关键字：【" + value + "】相匹配的项目");
							}
							event.cancel();
						}
					});
				}
				
			}
		});*/
		loadBudgetDate();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSEmployeeRepayment.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<Object,Object> param = __form.getValues();
		if(budgetRecord!=null) {
			//获取预算管理Id
			int budgetManagementId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("budgetManagementId"));
			//获取附件id
			int budgetAttachmentId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("budgetAttachmentId"));
			//获取付款序列id
			int paymentSequenceId=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("paymentSequenceId"));
			param.put("budgetManagementId", budgetManagementId);
			param.put("budgetAttachmentId", budgetAttachmentId);
			param.put("paymentSequenceId",paymentSequenceId);
		}
		return param;
	}
	
	private Record budgetRecord;

	public Record getBudgetRecord() {
		return budgetRecord;
	}

	public void setBudgetRecord(Record budgetRecord) {
		this.budgetRecord = budgetRecord;
	}

	public void loadBudgetDate() {
		if(budgetRecord!=null) {
			payseqIButItem.show();
			BigDecimal returnAmount=BaseHelpUtils.getBigDecimalValue(budgetRecord.getAttribute("returnAmount"));
			feeItem.setValue(returnAmount);
			parentIdItem.setValue(ClientUtil.getEmployeeId());
			/*//获取项目ID
			int projectIds=BaseHelpUtils.getIntValue(budgetRecord.getAttribute("projectIds"));
			String projectId=BaseHelpUtils.getString(projectIds);
			String value = KeyValueManager.getValue("projects", projectId);
			Map<String, Object> map = new HashMap<>();
			map.put("projectName", value);
			DBDataSource.callOperation("EP_GetProjectByProjectName", map, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if (dsResponse.getStatus() >= 0) {
						Record[] record = dsResponse.getData();
						projectMap.clear();
						for (Record obj : record) {
							projectMap.put(obj.getAttributeAsInt("projectId"), obj.getAttribute("projectName"));
						}
						projectItem.setValueMap(projectMap);
						projectItem.setValue(projectIds);
					}
				}
			});

			if(projectIds>0) {
				Map<String, Object> maps = new HashMap<>();
				maps.put("projectId",projectIds);
				DBDataSource.callOperation("NQ_PayMoneyProject",maps, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						projectIntegralItem.show();
						costIntegralItem.show(); 
						leftIntegralItem.show();
						if (dsResponse.getStatus() >= 0) {
							Record record[] = dsResponse.getData();
							for (Record obj : record) {
								projectIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("totalIntegral")));
								costIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("costIntegral")));
								leftIntegralItem.setValue(BaseHelpUtils.getBigDecimalValue(obj.getAttribute("leftIntegral")));
							}
						}
					}
				});
			}*/

		}
	}
	
}
