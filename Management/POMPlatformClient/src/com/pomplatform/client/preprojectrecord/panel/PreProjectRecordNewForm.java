package com.pomplatform.client.preprojectrecord.panel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ValidateUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.preprojectreimbursementnumber.datasource.DSPreProjectReimbursementNumbers;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.MultiComboBoxLayoutStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.MultiComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;

public class PreProjectRecordNewForm  extends AbstractWizadPage{
	private static final Logger __logger = Logger.getLogger("");
//	private final SelectItem relevantEmployeesItem;
	private final DateItem trackDateItem;
	private final SelectItem informationTypeItem;
	private final TextAreaItem  remarkItem;
	private final TextItem attachmentNameItem;
	private final TextItem attachmentIdItem;
	private final TextItem fileNameItem;
	private final ButtonItem uploadItem;
	private final TextItem registerEmployeeItem;
	private final DateItem registerDateItem;
	private final TextItem mainProjectIdItem;
	private TextItem winRateItem;
	private SelectItem contractSignStatusItem;
	private TextItem contractAmountItem;
	private TextAreaItem designPriceItem;
	private final MultiComboBoxItem relevantEmployeesItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	public  PreProjectRecordNewForm(Boolean isContract) {
		DSPreProjectReimbursementNumbers ds = DSPreProjectReimbursementNumbers.getInstance();
		
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		
		relevantEmployeesItem = new MultiComboBoxItem("relevantEmployees", "相关人员");  
		relevantEmployeesItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());  
		relevantEmployeesItem.setValueField("employeeId");
		relevantEmployeesItem.setDisplayField("employeeName");
		relevantEmployeesItem.setValue(new String[] { ClientUtil.getUserId() });
		relevantEmployeesItem.setOptionCriteria(c);
		relevantEmployeesItem.setLayoutStyle(MultiComboBoxLayoutStyle.FLOWREVERSE);
//		relevantEmployeesItem.setAutoFetchData(true);
		__formItems.add(relevantEmployeesItem);
		
		trackDateItem =new DateItem("trackDate",shouldNotBeNull+"跟踪时间");
		trackDateItem.setWidth("*");
		trackDateItem.setDisabled(true);
		trackDateItem.setUseTextField(true);
		trackDateItem.setDefaultValue(new Date());
		trackDateItem.setRequired(true);
		trackDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		__formItems.add(trackDateItem);
		
		informationTypeItem= new SelectItem("informationType",shouldNotBeNull+"信息类型");
		informationTypeItem.setWidth("*");
		informationTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_153"));
		informationTypeItem.setDisabled(true);
		__formItems.add(informationTypeItem);
		
		remarkItem = new TextAreaItem("remark",shouldNotBeNull+"情况描述");
		remarkItem.setWidth("*");
		remarkItem.setRequired(true);
		__formItems.add(remarkItem);
		
		attachmentNameItem = new  TextItem("attachmentName","附件路径");
		attachmentNameItem.setWidth("*");
		attachmentNameItem.setHidden(true);
		__formItems.add(attachmentNameItem);
		
		attachmentIdItem = new  TextItem("attachmentId","附件ID");
		attachmentIdItem.setWidth("*");
		attachmentIdItem.setHidden(true);
		__formItems.add(attachmentIdItem);
		
		fileNameItem = new  TextItem("fileName","附件");
		fileNameItem.setWidth("*");
		fileNameItem.setDisabled(true);
		fileNameItem.setCanEdit(false);
		__formItems.add(fileNameItem);
		
		uploadItem = new ButtonItem("上传报价");
		uploadItem.setStartRow(false);
		uploadItem.setVAlign(VerticalAlignment.BOTTOM);
		uploadItem.setColSpan(1);
		__formItems.add(uploadItem);
		uploadItem.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传报价", false, 100, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							String fileName = data.get(key).getAttribute("fileName");
							attachmentNameItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							fileNameItem.setValue(fileName);
						}
					}
				});
			}
		
		});
		
		registerEmployeeItem = new TextItem("registerEmployee","登记人");
		registerEmployeeItem.setWidth("*");
		registerEmployeeItem.setCanEdit(false);
		registerEmployeeItem.setDisabled(true);
		registerEmployeeItem.setDefaultValue(ClientUtil.getEmployeeId());
		registerEmployeeItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(registerEmployeeItem);
		
		registerDateItem = new DateItem("registerDate","登记日期");
		registerDateItem.setWidth("*");
		registerDateItem.setDefaultValue(new Date());
		registerDateItem.setUseTextField(true);
		registerDateItem.setDisabled(true);
		registerDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH_DAY);
		registerDateItem.setCanEdit(false);
		__formItems.add(registerDateItem);

		mainProjectIdItem = new TextItem("preProjectId","项目ID");
		mainProjectIdItem.setWidth("*");
		mainProjectIdItem.setHidden(true);
		__formItems.add(mainProjectIdItem);
		
		if(!isContract){
			winRateItem = new TextItem("winRate",shouldNotBeNull+"赢率(%)");
			winRateItem.setWidth("*");
			winRateItem.setRequired(true);
			winRateItem.setValidators(ValidateUtils.isIntValidator());
			__formItems.add(winRateItem);
			
			informationTypeItem.setDefaultValue(1);//项目类型
		}else{
			contractSignStatusItem = new SelectItem("contractSignStatus","合同状态");
			contractSignStatusItem.setWidth("*");
			contractSignStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_139"));
			__formItems.add(contractSignStatusItem);
			
			informationTypeItem.setDefaultValue(2);//合同类型
		}
		
		contractAmountItem = new TextItem("contractAmount","设计费总价(元)");
		contractAmountItem.setWidth("*");
		contractAmountItem.setValidators(ValidateUtils.isIntValidator());
		__formItems.add(contractAmountItem);
		
		designPriceItem = new TextAreaItem("designPrice","设计详细报价"); 
		designPriceItem.setWidth("*");
		designPriceItem.setColSpan(4);
		__formItems.add(designPriceItem);
		
		setIsContract(isContract);
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		__form.setWidth("50%");
		__form.setPadding(10);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		remarkItem.setColSpan(4);
		relevantEmployeesItem.setColSpan(4);
		addMember(__form);
	}
	@Override
	public Map getValuesAsMap() {
		Map params = __form.getValues();
		String[] reRecords = relevantEmployeesItem.getValues();
		if(!BaseHelpUtils.isNullOrEmpty(reRecords) && reRecords.length > 0){
			StringBuilder sb = new StringBuilder();
			for (String arr : reRecords) {
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(arr);
			}
			params.put("relevantEmployees", sb.toString());
			params.put("relevantEmployeesDisplayValue", relevantEmployeesItem.getDisplayValue());
		}
		int applyEmployeeId = BaseHelpUtils.getIntValue(record.getAttribute("applyEmployeeId"));
		String projectSalesTeam = record.getAttribute("projectSalesTeam");
		String projectName = record.getAttribute("projectName");
		
		params.put("applyEmployeeId", applyEmployeeId);
		params.put("projectSalesTeam", projectSalesTeam);
		params.put("projectName", projectName);
		
		return params;
	}

	@Override
	public boolean checkData() {
		String fileName=BaseHelpUtils.getString(fileNameItem.getValue());
//		if(fileName.length()>0) {
//			contractAmountItem.setRequired(true);
//		}
//		String string = BaseHelpUtils.getString(contractAmountItem.getValue());
//		if(BaseHelpUtils.isNullOrEmpty(string)) {
//			SC.say("设计费总价不能为空");
//			return false;
//		}
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.setValue("preProjectId", getRecord().getAttribute("preProjectId"));
		Map<String,Object> param = new HashMap<>();
		int preProjectId = BaseHelpUtils.getIntValue(getRecord().getAttribute("preProjectId"));
		param.put("preProjectId", preProjectId);
		if(!getIsContract()){
			//加载上一次填写的赢率
			DBDataSource.callOperation("ST_PreProject", "find", param, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record record = dsResponse.getData()[0];
						__form.setValue("winRate", record.getAttribute("winRate"));
					}
				}
			});
		}else{
			__form.setValue("preProjectId", getRecord().getAttribute("contractId"));
		}
		//加载上一条保存的合同金额和设计报价
		DBDataSource.callOperation("NQ_SpreProjectRecordRrtor", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					Record result = dsResponse.getData()[0];
					__form.setValue("contractAmount", result.getAttribute("contractAmount"));
					__form.setValue("designPrice", result.getAttribute("designPrice"));
				}
			}
		});
	}

	private Boolean isContract;

	public Boolean getIsContract() {
		return isContract;
	}

	public void setIsContract(Boolean isContract) {
		this.isContract = isContract;
	}
}
