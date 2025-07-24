package com.pomplatform.client.newcontractppcor.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.newcontractppcor.datasource.DSScontractppcor1;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ScontractppcorUpdateForm1 extends AbstractWizadPage
{


	private final SelectItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final ComboBoxItem groupNameItem;
	private final ComboBoxItem customerIdItem;
//	private final ComboBoxItem customerNameItem;
	private final TextItem customerNameItem;
	private final TextItem projectCodeItem;
	private final SelectItem contractTypeItem;
	private final SelectItem projectLevelItem;
	private final SelectItem contractSigningStatusItem;
	private final DoubleItem signingMoneySumItem;
	private final TextItem projectAddressItem;
	private final TextItem relevantEmployeesNameItem;
	private final TextItem relevantEmployeesItem;
	private final TextAreaItem  remarkItem;
	private final DateItem contractDateItem;
	private final DateItem sendingDateItem;
	private final SelectItem signingCompanyNameItem;
	private final SelectItem businessTypeItem;
	private final TextItem infoCodeItem;
	private final IPickTreeItem  departmentIdItem;

	private final SelectItem contractStatusItem;
	private static Logger __logger = Logger.getLogger("");
	private DelicacyListGrid businessLineGrid;
	private VLayout buttonLayout;
	private IButton addButton;
	private IButton uploadButton;
	private VLayout mainalyout;
	private HLayout buttomlyout;
	private  VLayout toplayout;
	private  DynamicForm  searchForms;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private LinkedHashMap<String, String> customerNameMap = new LinkedHashMap<>();
	public ScontractppcorUpdateForm1() {
		DSScontractppcor1 ds = DSScontractppcor1.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		contractIdItem = new SelectItem("contractId", shouldNotBeNull+"合同编码");
		contractIdItem.setWidth("*");
		contractIdItem.setHidden(true);
//		contractIdItem.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdItem);
		contractIdItem.setDisabled(true);
		contractIdItem.setRequired(true);
		IsIntegerValidator contractIdValidator = new IsIntegerValidator();
		contractIdItem.setValidators(contractIdValidator);
		__formItems.add(contractIdItem);

		infoCodeItem = new TextItem("infoCode", shouldNotBeNull+"信息编号");
		infoCodeItem.setWidth("*");
		//infoCodeItem.setRequired(true);
		infoCodeItem.setCanEdit(false);
		infoCodeItem.setDisabled(true);
		__formItems.add(infoCodeItem);

		projectCodeItem = new TextItem("projectCode", shouldNotBeNull+"项目编号");
		projectCodeItem.setWidth("*");
		//projectCodeItem.setRequired(true);
		projectCodeItem.setCanEdit(false);
		projectCodeItem.setDisabled(true);
		__formItems.add(projectCodeItem);

		contractCodeItem = new TextItem("contractCode", shouldNotBeNull+"合同编号");
		contractCodeItem.setWidth("*");
		contractCodeItem.setRequired(true);
		contractCodeItem.setCanEdit(false);
		contractCodeItem.setDisabled(true);
		__formItems.add(contractCodeItem);

		contractStatusItem = new SelectItem("contractStatus", shouldNotBeNull+"合同状态");
		contractStatusItem.setHidden(true);
		//contractStatusItem.setRequired(true);
		contractStatusItem.setWidth("*");
		contractStatusItem.setCanEdit(true);
		contractStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));
		__formItems.add(contractStatusItem);

		contractNameItem = new TextItem("contractName",shouldNotBeNull+ "合同名称");
		contractNameItem.setRequired(true);
		contractNameItem.setWidth("*");
		__formItems.add(contractNameItem);

		
		groupNameItem = new ComboBoxItem("groupName","集团名称");
		groupNameItem.setWidth("*");
		groupNameItem.setChangeOnKeypress(false);
		groupNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("parent_customers_name",groupNameItem);
		groupNameItem.addChangeHandler(new com.smartgwt.client.widgets.form.fields.events.ChangeHandler() {
			
			@Override
			public void onChange(com.smartgwt.client.widgets.form.fields.events.ChangeEvent event) {
				int parentId = BaseHelpUtils.getIntValue(event.getValue());
				if(parentId<=0) {
					customerIdItem.setValueMap(KeyValueManager.getValueMap("customers_name")); 
				}else {
					Map<String,Object> params = new HashMap<>();
					params.put("parentId", parentId);
					params.put("optType", "loadCustomerNameByParentId");
					DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							customerNameMap.clear();
							if(dsResponse.getStatus() >= 0){
								SC.debugger();
								Record[] records = dsResponse.getData();
								if(records.length>0) {	
									for (Record record : records) {
										customerNameMap.put(record.getAttribute("customerId"), record.getAttribute("customerName"));
									}
								}
							}
							customerIdItem.setValue("");
							customerIdItem.setValueMap(customerNameMap); 
						}
					});
				}
				
			}
		});
		__formItems.add(groupNameItem);
		
		customerIdItem = new ComboBoxItem("customerId",shouldNotBeNull+"客户名称");
		customerIdItem.setWidth("*");
		customerIdItem.setRequired(true);
		customerIdItem.setChangeOnKeypress(false);
		customerIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		customerIdItem.setValueMap(KeyValueManager.getValueMap("customers_name")); 
		customerIdItem.addChangeHandler(new com.smartgwt.client.widgets.form.fields.events.ChangeHandler() {
			
			@Override
			public void onChange(com.smartgwt.client.widgets.form.fields.events.ChangeEvent event) {
				int customerId = BaseHelpUtils.getIntValue(event.getValue());
				if(customerId>0) {
					Map<String,Object> params = new HashMap<>();
					params.put("customerId", customerId);
					params.put("optType", "loadparentCustomerNameById");
					DBDataSource.callOperation("EP_PreProjectProcess", params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus()>=0) {
								Record[] data1 = dsResponse.getData();
								if(data1.length>0) {
									int parentId = BaseHelpUtils.getIntValue(data1[0].getAttribute("parentId"));
									if(parentId>0) {
										groupNameItem.setValue(parentId);
									}else {
										groupNameItem.setValue("");
									}
								}else {
									groupNameItem.setValue("");
								}
							}
						}
					});
				}
			}
		});
		__formItems.add(customerIdItem);
		
		customerNameItem = new TextItem("customerName", shouldNotBeNull+"客户名称");
		customerNameItem.hide();
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		
//		customerNameItem = new ComboBoxItem("customerName", shouldNotBeNull+"客户名称");
//		customerNameItem.setChangeOnKeypress(false);
//		customerNameItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		KeyValueManager.loadValueMap("customers",customerNameItem);
//		customerNameItem.setRequired(true);
//		customerNameItem.setWidth("*");
//		__formItems.add(customerNameItem);
//		customerIdItem.addChangedHandler(new ChangedHandler() {
//			
//			@Override
//			public void onChanged(ChangedEvent event) {
//				if(null != event.getValue()) {
//					customerNameItem.setValue(customerIdItem.getDisplayValue());
//				}
//			}
//		});

		projectLevelItem = new SelectItem("projectLevel", shouldNotBeNull+"项目等级");
		projectLevelItem.setWidth("*");
		projectLevelItem.setRequired(true);
		projectLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		__formItems.add(projectLevelItem);

		departmentIdItem = new IPickTreeItem("departmentId","从属部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setRequired(false);
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		__formItems.add(departmentIdItem);

		businessTypeItem = new SelectItem("businessType",shouldNotBeNull+ "业务类别");
		businessTypeItem.setRequired(true);
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessTypeItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int businessType=BaseHelpUtils.getIntValue(event.getValue());
				BigDecimal businessAmount=BaseHelpUtils.getBigDecimalValue(signingMoneySumItem.getValue());
				if(businessType==7) {
					RecordList  Rcordlist=new RecordList();
					businessLineGrid.setData(Rcordlist);
					addButton.setDisabled(false);
				}else {
					Record record=new Record();
					record.setAttribute("businessLineId", businessType);
					record.setAttribute("businessAmount", businessAmount);
					RecordList  Rcordlist=new RecordList();
					Rcordlist.add(record);
					businessLineGrid.setData(Rcordlist);
					addButton.setDisabled(true);

				}
			}
		});
		__formItems.add(businessTypeItem);

		signingMoneySumItem = new DoubleItem("signingMoneySum", shouldNotBeNull+"签约总金额");
		signingMoneySumItem.setRequired(true);
		signingMoneySumItem.setFormat("#,###,###,###,###,##0.00");
		signingMoneySumItem.setWidth("*");
		signingMoneySumItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int businessType=BaseHelpUtils.getIntValue(businessTypeItem.getValue());
				BigDecimal businessAmount=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(businessType==7) {
					RecordList  Rcordlist=new RecordList();
					businessLineGrid.setData(Rcordlist);
				}else {
					Record record=new Record();
					record.setAttribute("businessLineId", businessType);
					record.setAttribute("businessAmount", businessAmount);
					RecordList  Rcordlist=new RecordList();
					Rcordlist.add(record);
					businessLineGrid.setData(Rcordlist);

				}
			}
		});
		__formItems.add(signingMoneySumItem);

		contractTypeItem = new SelectItem("contractType", shouldNotBeNull+"合同类别");
		contractTypeItem.setHidden(true);
		contractTypeItem.setWidth("*");
		contractTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));
		__formItems.add(contractTypeItem);

		contractSigningStatusItem = new SelectItem("contractSigningStatus", shouldNotBeNull+"合同签订状态");
		contractSigningStatusItem.setWidth("*");
		contractSigningStatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_139"));
		contractSigningStatusItem.addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				int contractSigningStatus=BaseHelpUtils.getIntValue(event.getValue());
				if(contractSigningStatus==1) {//如果签约合同状态是已寄出状态,隐藏签订日期菜单 ,显示寄出日期  1已寄出  2已签订 3洽谈中
					sendingDateItem.show();
					sendingDateItem.setRequired(true);
					contractDateItem.hide(); 
					contractDateItem.setRequired(false);
				}else if(contractSigningStatus==2){//如果签约合同状态是已签订状态,都显示
					sendingDateItem.show();
					sendingDateItem.setRequired(true);
					contractDateItem.show();
					contractDateItem.setRequired(true);
				}else {
					sendingDateItem.hide();
					sendingDateItem.setRequired(false);
					contractDateItem.hide();
					contractDateItem.setRequired(false);
				}
			}
		});
		__formItems.add(contractSigningStatusItem);

		relevantEmployeesNameItem = new TextItem("relevantEmployeesName", "合同跟进人");
		relevantEmployeesNameItem.setCanEdit(false);
		relevantEmployeesNameItem.setDisabled(true);
		relevantEmployeesNameItem.setLength(100);
		relevantEmployeesNameItem.setWidth("*");
		__formItems.add(relevantEmployeesNameItem);
		
		relevantEmployeesItem = new TextItem("relevantEmployees", "合同跟进人id");
		relevantEmployeesItem.setCanEdit(false);
		relevantEmployeesItem.setWidth("*");
		relevantEmployeesItem.setHidden(true);
		__formItems.add(relevantEmployeesItem);
		
		
		signingCompanyNameItem = new SelectItem("signingCompanyName", shouldNotBeNull+"我方签约公司名称");
		signingCompanyNameItem.setWidth("*");
		signingCompanyNameItem.setRequired(true);
		signingCompanyNameItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		__formItems.add(signingCompanyNameItem);


		sendingDateItem = new DateItem("sendingDate", shouldNotBeNull+"合同寄出日期");
		sendingDateItem.setUseMask(true);
		sendingDateItem.setUseTextField(true);
		sendingDateItem.setWidth("*");   
		__formItems.add(sendingDateItem);

		contractDateItem = new DateItem("contractDate", shouldNotBeNull+"合同签订日期");
		contractDateItem.setUseMask(true);
		contractDateItem.setUseTextField(true);
		contractDateItem.setWidth("*");
		__formItems.add(contractDateItem);

		projectAddressItem = new TextItem("projectAddress", shouldNotBeNull+"项目地点");
		projectAddressItem.setWidth("*");
		projectAddressItem.setHidden(true);
		__formItems.add(projectAddressItem);

		searchForms=new DynamicForm();

		remarkItem = new TextAreaItem("remark", "备注");
		remarkItem.setWidth("*");
		remarkItem.setRowSpan(4);
		remarkItem.setHeight("35%");
		remarkItem.setLength(255);
		//__formItems.add(remarkItem);
		searchForms.setItems(remarkItem);
		searchForms.setMargin(10);
		searchForms.setPadding(2);
		searchForms.setHeight("25%");
		searchForms.setAlign(Alignment.LEFT);
		searchForms.setWidth("90%");
		searchForms.setNumCols(2);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(6);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		__form.setCellPadding(10);
		mainalyout=new VLayout();
		mainalyout.setWidth100();
		mainalyout.setHeight100();

		toplayout=new VLayout();
		toplayout.setWidth100();
		toplayout.setHeight("53%");
		toplayout.setAlign(Alignment.CENTER);
		toplayout.addMember(__form);
		mainalyout.addMember(toplayout);

		businessLineGrid = new DelicacyListGrid();
		int a = 0;
		ListGridField[] aFields = new ListGridField[2];
		aFields[a] = new ListGridField("businessLineId","业态");
		aFields[a].addChangedHandler(new com.smartgwt.client.widgets.grid.events.ChangedHandler() {
			@Override
			public void onChanged(com.smartgwt.client.widgets.grid.events.ChangedEvent event) {
				int businessLineId=BaseHelpUtils.getIntValue(event.getValue());
				int businessType=BaseHelpUtils.getIntValue(businessTypeItem.getValue());
				if(businessType==7) {
					if(businessLineId==7) {
						SC.say("业务类别为综合体，此处不能再选择综合体！");
						return;
					}
				}
			}
		});
		aFields[a].setCanEdit(true);
		aFields[a].setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		a++;
		aFields[a] = new ListGridField("businessAmount","金额");
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setCanEdit(true);
		businessLineGrid.setFields(aFields);
		businessLineGrid.setAutoFitFieldWidths(false);
		businessLineGrid.setCanRemoveRecords(true);
		businessLineGrid.setShowGridSummary(true);
		businessLineGrid.setHeaderHeight(60);
		businessLineGrid.setHeaderSpans(new HeaderSpan("条线金额", new String[] {"businessLineId","businessAmount"}));

		addButton = new IButton("新增");
		addButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				businessLineGrid.startEditingNew();
			}
		});
		
		uploadButton = PermissionControl.createPermissionButton("上传合同附件",
				ERPPermissionStatic.FINALLTY_INFO_UPLOAD_FILE_BUTTON);
		uploadButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final int contractId = BaseHelpUtils.getIntValue(contractIdItem.getValue());
				new CommonUploadWindow("上传合同附件", false, 100, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						Record fileData = null;
						for(String key : data.keySet()) {
							fileData = data.get(key);
							break;
						}
						if(null != fileData) {
							Map<String, Object> params = new HashMap<>();
							params.put("optType", "updateServiceSuggestBook");
							params.put("contractId", contractId);
							params.put("serviceSuggestBookId", fileData.getAttribute("fileId"));
							params.put("serviceSuggestBook", fileData.getAttribute("fileUrl"));
							DBDataSource.callOperation("EP_ContractChangeProcess", "find", params, new DSCallback() {
								
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									if(dsResponse.getStatus() >= 0) {
										SC.say("上传成功");
									}else {
										ClientUtil.displayErrorMessage(dsResponse);
									}
								}
							});
						}
					}
				});
			}
		});
		
		buttonLayout=new VLayout();
		buttonLayout.setMembersMargin(15);
		buttonLayout.setWidth("5%");
		buttonLayout.setHeight("35%");
		buttonLayout.setMargin(5);
		buttonLayout.setPadding(10);
		buttonLayout.addMember(addButton);
		buttonLayout.addMember(uploadButton);

		buttomlyout=new HLayout();
		buttomlyout.setWidth("100%");
		buttomlyout.setHeight("35%");
		buttomlyout.setMargin(5);
		buttomlyout.setPadding(10);
		buttomlyout.setAlign(Alignment.CENTER);
		
		
		buttomlyout.addMember(businessLineGrid);
		buttomlyout.addMember(buttonLayout);
		mainalyout.addMember(buttomlyout);
		mainalyout.addMember(searchForms);

		setPageMode(PAGE_MODE_UPDATE);
		addMember(mainalyout);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		int contractSigningStatus=BaseHelpUtils.getIntValue(contractSigningStatusItem.getValue());
		if(contractSigningStatus==1) {//如果签约合同状态是已寄出状态,隐藏签订日期菜单 ,显示寄出日期  1已寄出  2已签订 3洽谈中
			sendingDateItem.show();
			sendingDateItem.setRequired(true);
			contractDateItem.hide(); 
			contractDateItem.setRequired(false);
		}else if(contractSigningStatus==2){//如果签约合同状态是已签订状态,都显示
			sendingDateItem.show();
			sendingDateItem.setRequired(true);
			contractDateItem.show();
			contractDateItem.setRequired(true);
		}else {
			sendingDateItem.hide();
			sendingDateItem.setRequired(false);
			contractDateItem.hide();
			contractDateItem.setRequired(false);
		}
		int contractId=BaseHelpUtils.getIntValue(contractIdItem.getValue());
		//relevantEmployeesNameItem  ContractsRecords
		Map map=new HashMap<>();
		map.put("contractId",contractId);
		DBDataSource.callOperation("NQ_ContractsRecords", map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0) {
					Record[] records=dsResponse.getData();
					String  relevantEmployeesName="";
					String  relevantEmployees="";
					for (Record record : records) {
						relevantEmployeesName=record.getAttribute("relevantEmployeesName");
						relevantEmployees=record.getAttribute("relevantEmployees");
					}
					relevantEmployeesNameItem.setValue(relevantEmployeesName);
					relevantEmployeesItem.setValue(relevantEmployees);
				}
			}
		});

		//获取业务类别
		int businessType=BaseHelpUtils.getIntValue(businessTypeItem.getValue());
		//获取总金额
		BigDecimal signingMoneySum=BaseHelpUtils.getBigDecimalValue(signingMoneySumItem.getValue());
		if(businessType==0) {
			return;
		}
		//如果业务类别选择非综合体，则直接显示选择的业务类别
		if(businessType!=7) {
			Record record=new Record();
			record.setAttribute("businessLineId",businessType);
			record.setAttribute("businessAmount",signingMoneySum);
			RecordList  list=new RecordList();
			list.add(record);
			businessLineGrid.setData(list);
		}

	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSScontractppcor1.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()) {
			SC.say("请按系统提示修改信息");
			return false;
		}
		if(!searchForms.validate()) {
			SC.say("请按系统提示修改信息");
			return false;
		}
		/*if(businessLineGrid.getRecords().length==0) {
			SC.say("条线金额不能为空");
			return false;
		}*/
		/*Map value = __form.getValues();
		Record[] records=businessLineGrid.getRecords();
		//条线金额相加
		BigDecimal moneySum=BigDecimal.ZERO;
		//获取签约总金额
		BigDecimal signingMoneySum=BaseHelpUtils.getBigDecimalValue(value.get("signingMoneySum"));
		for (Record record : records) {
			moneySum=moneySum.add(BaseHelpUtils.getBigDecimalValue(record.getAttribute("businessAmount")));
		}
		if(moneySum.compareTo(signingMoneySum)!=0) {
			SC.say("条线总金额必须等于签约总金额,当前条线总金额为("+moneySum+")，签约总金额为("+signingMoneySum+")");
			return false;
		}else {
			return true;
		}*/
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public java.util.Map getValuesAsMap() {
		Map value = __form.getValues();
		value.put("remark", searchForms.getValues().get("remark"));
		value.put("updateTime", new Date());
		value.put("operator",ClientUtil.getEmployeeId());
		MapUtils.convertRecordToMap(businessLineGrid,businessLineGrid.getRecords(),value,"businessLine");
		return value;
	}


}
