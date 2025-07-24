package com.pomplatform.client.customer.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class ClientManageUpdateDesignPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private Window parWindow;
    private final String borderStyle = "1px solid #dbdbdb";
    private DynamicForm mainContactForm;
    private DelicacyListGrid otherContactGrid;
    private DynamicForm basicForm;
    private DynamicForm enterForm;
    private DynamicForm addressForm;
    private DynamicForm detailForm;
    protected List<FormItem> __customerFormItems = new ArrayList<>();
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    //设置默认没有选择主要联系人
    private boolean hasMainEmployee = false;
    private Map<String,Object> emptyMap = new HashMap<>();
    public ClientManageUpdateDesignPanel() {
    	//主板面板
    	VLayout mainLayout = new VLayout(10);
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	addMember(mainLayout);
    	
    	HLayout buttonLayout = new HLayout(10);
    	buttonLayout.setHeight("5%");
    	buttonLayout.setLayoutTopMargin(10);
    	mainLayout.addMember(buttonLayout);
    	IButton sureButton = new IButton("保存");
    	sureButton.addClickHandler(new ClickHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onClick(ClickEvent event) {
				boolean isSubmit = checkData();
				if(isSubmit){
					//获取客户相关信息
					Map<String,Object> customerInfoMap = getCustomerValueMap();
					//获取客户联系人员信息
					List<Map<String,Object>> listMap = new ArrayList<>();
					Record[] records = otherContactGrid.getRecords();
					for(Record r : records){
						listMap.add(r.toMap());
					}
					customerInfoMap.put("customerContacts", listMap);
					sureButton.setDisabled(true);
					customerInfoMap.put("operateEmployeeId",ClientUtil.getEmployeeId());
					customerInfoMap.put("optType","onCustomerInfoUpdate");
					DBDataSource.callOperation("EP_OnCustomerProcess",customerInfoMap, new DSCallback() {
			            @Override
			            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
			            	sureButton.setDisabled(false);
			                if (dsResponse.getStatus() >= 0) {
			                    SC.say("提示","保存成功");
			                    if (getParWindow() == null) {
			    					return;
			    				}
			    				getParWindow().destroy();
			    				DataEditEvent dee = new DataEditEvent();
			    				fireEvent(dee);
			                } else {
			                    @SuppressWarnings("rawtypes")
								Map errors = dsResponse.getErrors();
			                    SC.say("保存失败",errors.get("errorMsg")+"");
			                }
			            }
			        });
				}
			}
		});
    	IButton cancelButton = new IButton("取消");
    	cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (getParWindow() == null) {
					return;
				}
				getParWindow().destroy();
			}
		});
    	buttonLayout.addMember(sureButton);
    	buttonLayout.addMember(cancelButton);
    	
        SectionStack sectionStack = new SectionStack();  
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
        sectionStack.setWidth100();  
        sectionStack.setHeight("95%"); 
        mainLayout.addMember(sectionStack);
        
        SectionStackSection section1 = new SectionStackSection("摘要");  
        section1.setExpanded(true); 
        section1.setCanCollapse(false);  
        HLayout zyLayout = new HLayout(10);
        zyLayout.setHeight100();
        zyLayout.setWidth100();
        section1.addItem(zyLayout);  
        sectionStack.addSection(section1);  
        
        VLayout leftLayout = new VLayout();
        leftLayout.setBorder(borderStyle);
        leftLayout.setHeight100();
        leftLayout.setWidth("50%");
        zyLayout.addMember(leftLayout);
        basicForm = new DynamicForm();
        basicForm.setIsGroup(true);
        basicForm.setNumCols(2);
        basicForm.setGroupTitle("客户基本信息");
        leftLayout.addMember(basicForm);
        TextItem customerIdItem = new TextItem("customerId","ID");
        customerIdItem.setWidth("*");
        customerIdItem.hide();
        __customerFormItems.add(customerIdItem);
        TextItem companyNameItem = new TextItem("customerName",shouldNotBeNull+"客户名称");
        companyNameItem.setWidth("*");
        __customerFormItems.add(companyNameItem);
        TextItem companyMobileItem = new TextItem("companyMobile",shouldNotBeNull+"联系电话");
        companyMobileItem.setWidth("*");
        __customerFormItems.add(companyMobileItem);
        TextItem companyFaxItem = new TextItem("companyFax","传真");
        companyFaxItem.setWidth("*");
        __customerFormItems.add(companyFaxItem);
        SelectItem customerLevelItem = new SelectItem("customerLevel",shouldNotBeNull+"客户等级");
        customerLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_145"));
        customerLevelItem.setWidth("*");
        __customerFormItems.add(customerLevelItem);
        SelectItem customerTypeItem = new SelectItem("customerType",shouldNotBeNull+"客户类型");
        customerTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_151"));
        customerTypeItem.setWidth("*");
        __customerFormItems.add(customerTypeItem);
        SelectItem typeItem = new SelectItem("type",shouldNotBeNull+"客户分类");
        typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_159"));
        typeItem.setWidth("*");
        __customerFormItems.add(typeItem);
        basicForm.setFields(customerIdItem,companyNameItem,companyMobileItem,companyFaxItem,customerLevelItem,customerTypeItem,typeItem);
        //库存相关信息
        enterForm = new DynamicForm();
        enterForm.setIsGroup(true);
        enterForm.setNumCols(8);
        enterForm.setGroupTitle("库存信息");
        leftLayout.addMember(enterForm);
        ComboBoxItem reportEmployeeIdItem = new ComboBoxItem("reportEmployeeId","报备人");
//        reportEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employee_list"));
		KeyValueManager.loadValueMap("employee_list",reportEmployeeIdItem);
        reportEmployeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        reportEmployeeIdItem.setWidth("*");
        __customerFormItems.add(reportEmployeeIdItem);
        BooleanItem isSureItem = new BooleanItem("isSure","是否为正式客户");
        isSureItem.setWidth("*");
        __customerFormItems.add(isSureItem);
        BooleanItem isWarehousItem = new BooleanItem("isWarehous","是否入库");
        isWarehousItem.setWidth("*");
        __customerFormItems.add(isWarehousItem);
        BooleanItem isApplyQuoteItem = new BooleanItem("isApplyQuote","是否已提供战略报价");
        isApplyQuoteItem.setWidth("*");
        __customerFormItems.add(isApplyQuoteItem);
        enterForm.setFields(reportEmployeeIdItem,isSureItem,isWarehousItem,isApplyQuoteItem);
        
        addressForm = new DynamicForm();
        addressForm.setIsGroup(true);
        addressForm.setNumCols(4);
        addressForm.setGroupTitle("客户地址信息");
        leftLayout.addMember(addressForm);
        TextItem postCodeItem = new TextItem("postCode","邮编");
        postCodeItem.setWidth("*");
        __customerFormItems.add(postCodeItem);
        SelectItem companyCityItem = new SelectItem("companyCity",shouldNotBeNull+"所在城市");
        companyCityItem.setWidth("*");
        __customerFormItems.add(companyCityItem);
        SelectItem companyProvinceItem = new SelectItem("companyProvince",shouldNotBeNull+"所在省份");
        companyProvinceItem.setWidth("*");
        __customerFormItems.add(companyProvinceItem);
        companyProvinceItem.setValueMap(KeyValueManager.getValueMap("provinces_names"));
        companyProvinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Map<String,Object> provinceMap = new HashMap<>();
        	    provinceMap.put("optType", "getCityNames");
        	    provinceMap.put("province", companyProvinceItem.getValue());
        	    DBDataSource.callOperation("EP_PreProjectProcess", provinceMap, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							Record[] cityRecords = dsResponse.getData();
							LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
							for(Record e : cityRecords){
								cityMap.put(e.getAttribute("allName"), e.getAttribute("allName"));
							}
							companyCityItem.setValueMap(cityMap);
						}
					}
        	    	
        	    });
			}
		});
        
        TextItem companyAddressItem = new TextItem("companyAddress","详细地址");
        companyAddressItem.setWidth("*");
        __customerFormItems.add(companyAddressItem);
        addressForm.setFields(postCodeItem,companyAddressItem,companyProvinceItem,companyCityItem);
        
        detailForm = new DynamicForm();
        detailForm.setIsGroup(true);
        detailForm.setNumCols(2);
        detailForm.setGroupTitle("客户详细信息");
        leftLayout.addMember(detailForm);
        TextItem webSiteItem = new TextItem("webSite","网站");
        webSiteItem.setWidth("*");
        __customerFormItems.add(webSiteItem);
        TextItem companyStockCodeItem = new TextItem("companyStockCode","股票代码");
        companyStockCodeItem.setWidth("*");
        __customerFormItems.add(companyStockCodeItem);
        SpinnerItem companyEmployeeNumItem = new SpinnerItem("companyEmployeeNum","公司人数");
        companyEmployeeNumItem.setDefaultValue(0);  
        companyEmployeeNumItem.setMin(0);  
        companyEmployeeNumItem.setMax(100000000);  
        companyEmployeeNumItem.setStep(1);  
        companyEmployeeNumItem.setWidth("*");
        __customerFormItems.add(companyEmployeeNumItem);
        DateItem companySetupItem = new DateItem("companySetup","成立时间");
        companySetupItem.setWidth("*");
        companySetupItem.setUseTextField(true);
        __customerFormItems.add(companySetupItem);
        TextItem companyNatureItem = new TextItem("companyNature","企业性质");
        companyNatureItem.setWidth("*");
        __customerFormItems.add(companyNatureItem);
        TextItem companyQualificationItem = new TextItem("companyQualification","企业资质");
        companyQualificationItem.setWidth("*");
        __customerFormItems.add(companyQualificationItem);
//        TextItem companyParentNameItem = new TextItem("companyParentName","集团名称");
//        companyParentNameItem.setWidth("*");
//        __customerFormItems.add(companyParentNameItem);
//        TextItem companyParentAddressItem = new TextItem("companyParentAddress","集团地址");
//        companyParentAddressItem.setWidth("*");
//        __customerFormItems.add(companyParentAddressItem);
        ComboBoxItem parentIdItem = new ComboBoxItem("parentId","上级集团");
        parentIdItem.setWidth("*");
        parentIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//        parentIdItem.setValueMap(KeyValueManager.getValueMap("customers"));
		KeyValueManager.loadValueMap("customers",parentIdItem);
        __customerFormItems.add(parentIdItem);
        
        TextItem companyChildNameItem = new TextItem("companyChildName","分支机构");
        companyChildNameItem.setWidth("*");
        __customerFormItems.add(companyChildNameItem);
        TextItem companyOrganizationalItem = new TextItem("companyOrganizational","组织架构");
        companyOrganizationalItem.setWidth("*");
        __customerFormItems.add(companyOrganizationalItem);
        TextAreaItem companyBriefItem = new TextAreaItem("companyBrief","公司简介");
        companyBriefItem.setWidth("*");
        __customerFormItems.add(companyBriefItem);
        detailForm.setFields(webSiteItem,companyStockCodeItem,companyEmployeeNumItem,companySetupItem,companyNatureItem,companyQualificationItem
		,parentIdItem,companyChildNameItem,companyOrganizationalItem,companyBriefItem);
        
        VLayout rightLayout = new VLayout();
        rightLayout.setHeight100();
        rightLayout.setBorder(borderStyle);
        rightLayout.setWidth("50%");
        zyLayout.addMember(rightLayout);
        
        Label addContact = new Label();  
        addContact.setHeight("10%");  
        addContact.setPadding(10);
        addContact.setAlign(Alignment.LEFT);  
        addContact.setValign(VerticalAlignment.CENTER);  
        addContact.setIcon("icons/16/approved.png");  
        addContact.setContents("<i><span style='color:blue;font-family:FangSong;font-size:1.2em; text-overflow:ellipsis;font-weight: bold'>点击添加联系人->></span></i>");
        rightLayout.addMember(addContact);
        addContact.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final PopupWindow popupWindow = new PopupWindow("添加联系人员");
				popupWindow.setWidth("50%");
				popupWindow.setHeight("75%");
				popupWindow.centerInPage();
				AddCustomerContactPanel childPanel = new AddCustomerContactPanel();
				childPanel.initComponents();
				popupWindow.addItem(childPanel);
				childPanel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Object obj = popupWindow.getLayoutData();
						if(!BaseHelpUtils.isNullOrEmpty(obj)){
							@SuppressWarnings("unchecked")
							Map<String, Object> valueMap = (Map<String,Object>)obj;
							//获取联系人类型
							int employeeType = BaseHelpUtils.getIntValue(valueMap,"employeeType");
							Record re = new Record(valueMap);
							Record[] oldGirdData = otherContactGrid.getRecords();
							int len = oldGirdData.length;
							Record[] newGirdData = new Record[len+1];
							if(len > 0){
								for(int i = 0;i<len;i++){
									//如果已经存在了主要联系人，则更新主要联系人,确保主要联系人只有一个
									newGirdData[i] = oldGirdData[i];
									if(hasMainEmployee && employeeType == 1){
										if(BaseHelpUtils.getIntValue(newGirdData[i].getAttribute("employeeType")) == 1){
											newGirdData[i].setAttribute("employeeType",2);
										}
									}
								}
							}
							newGirdData[len] = re;
							otherContactGrid.setData(newGirdData);
							if(employeeType == 1){//说明是主要联系人
								mainContactForm.setValues(valueMap);
								if(!hasMainEmployee){
									hasMainEmployee = true;
								}
							}
						}
					}
				});
				childPanel.setParentWindow(popupWindow);
				popupWindow.centerInPage();
				popupWindow.show();
			}
		});
        //主要联系人面板
        SectionStack mainContactStack = new SectionStack();  
        mainContactStack.setHeight("20%");  
        rightLayout.addMember(mainContactStack);
        
        SectionStackSection mainContactSection = new SectionStackSection("主要联系人");  
        mainContactSection.setCanCollapse(false);  
        mainContactSection.setExpanded(true); 
        
        mainContactForm = new DynamicForm();
        mainContactForm.setNumCols(2);
        leftLayout.addMember(addressForm);
        TextItem contactNameItem = new TextItem("name","姓名");
        contactNameItem.setDisabled(true);
        contactNameItem.setWidth("*");
        TextItem contactMobileItem = new TextItem("mobile","座机");
        contactMobileItem.setDisabled(true);
        contactMobileItem.setWidth("*");
        TextItem contactEmailItem = new TextItem("email","邮箱");
        contactEmailItem.setDisabled(true);
        contactEmailItem.setWidth("*");
        mainContactForm.setFields(contactNameItem,contactMobileItem,contactEmailItem);
        mainContactSection.setItems(mainContactForm);
        mainContactStack.setSections(mainContactSection);
        
        
        //其他联系人面板
        SectionStack otherContactStack = new SectionStack();  
        otherContactStack.setHeight("70%");  
        rightLayout.addMember(otherContactStack);
        
        SectionStackSection otherContactSection = new SectionStackSection("其他联系人");  
        otherContactSection.setCanCollapse(false);  
        otherContactSection.setExpanded(true); 
        
        otherContactGrid = new DelicacyListGrid();
        otherContactGrid.setCanRemoveRecords(true);
        otherContactGrid.setAutoFitFieldWidths(false);
        ListGridField[] fields = new ListGridField[5];
		int fieldIdx = 0;
		fields[fieldIdx] = new ListGridField("customerContactId");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("name","姓名");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("mobile","座机");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("email","邮箱");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("employeeType","联系人类型");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
        otherContactGrid.setFields(fields);
        otherContactSection.setItems(otherContactGrid);
        otherContactGrid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				int rowNum = event.getRowNum();
				Record r = otherContactGrid.getRecord(rowNum);
				//获取联系人类型，如果移除的主要联系人，则去除表单显示的主要联系人信息
				int employeeType = BaseHelpUtils.getIntValue(r.getAttribute("employeeType"));
				if(employeeType == 1){
					mainContactForm.setValues(emptyMap);
					hasMainEmployee = false;
				}
			}
		});
        otherContactGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record r = otherContactGrid.getSelectedRecord();
				if(!BaseHelpUtils.isNullOrEmpty(r)){
					final PopupWindow popupWindow = new PopupWindow("修改联系人员");
					popupWindow.setWidth("50%");
					popupWindow.setHeight("75%");
					popupWindow.centerInPage();
					AddCustomerContactPanel childPanel = new AddCustomerContactPanel();
					childPanel.initComponents();
					popupWindow.addItem(childPanel);
					childPanel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							Object obj = popupWindow.getLayoutData();
							if(!BaseHelpUtils.isNullOrEmpty(obj)){
								Map<String, Object> valueMap = (Map<String,Object>)obj;
								//获取联系人类型
								int employeeType = BaseHelpUtils.getIntValue(valueMap,"employeeType");
								Record oldRecord = otherContactGrid.getSelectedRecord();
								int oldEmployeeType = BaseHelpUtils.getIntValue(oldRecord.getAttribute("employeeType"));
								if(employeeType == 1){
									if(oldEmployeeType != 1){
										if(hasMainEmployee){//说明原就有一个主要联系人员，则需要把原来那个主要联系人员状态改为其他联系人员
											Record[] datas = otherContactGrid.getRecords();
											if(!BaseHelpUtils.isNullOrEmpty(datas) && datas.length > 0){
												for(Record r : datas){
													if(BaseHelpUtils.getIntValue(r.getAttribute("employeeType")) == 1){
														r.setAttribute("employeeType",2);
														otherContactGrid.updateData(r);
														otherContactGrid.redraw();
														break;
													}
												}
											}
										}else{
											hasMainEmployee = true;
										}
									}
									mainContactForm.setValues(valueMap);
								}else{
									if(oldEmployeeType == 1){
										hasMainEmployee = false;
										mainContactForm.setValues(emptyMap);
									}
								}
								otherContactGrid.updateData(copyAttribute(valueMap,oldRecord));
								otherContactGrid.redraw();
							}
						}
					});
					childPanel.setParentWindow(popupWindow);
					childPanel.setValueRecord(r.toMap());
					popupWindow.centerInPage();
					popupWindow.show();
				}
			}
		});
        otherContactStack.setSections(otherContactSection);
  
  
    }

    //获取客户表单相关信息
    public Map<String,Object> getCustomerValueMap(){
		Map<String,Object> valueMap = new HashMap<>();
		int len = __customerFormItems.size();
		if(len > 0){
			for(FormItem r : __customerFormItems){
				valueMap.put(r.getName(),r.getValue());
			}
		}
		return valueMap;
	} 
    
    @Override
    public void startEdit() {
        if (getRecord() != null) {
        }
    }
    
	private Record copyAttribute(Map<String,Object> map,Record r){
    	if(!BaseHelpUtils.isNullOrEmpty(map)){
    		for(String key : map.keySet()){
    			r.setAttribute(key,map.get(key));
    		}
    	}
    	return r;
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSemployeeNew.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
    	int len = __customerFormItems.size();
		boolean isSubmit = true;
		if(len > 0){
			for(FormItem r : __customerFormItems){
				String name = r.getName();
				Object value = r.getValue();
				if(BaseHelpUtils.isNullOrEmpty(value)){
					if(name == "customerName"){
						SC.say("提示","客户名称不可为空");
						isSubmit = false;
						break;
					}else if(name == "companyMobile"){
						SC.say("提示","联系电话不可为空");
						isSubmit = false;
						break;
					}else if(name == "customerLevel"){
						SC.say("提示","客户等级不可为空");
						isSubmit = false;
						break;
					}else if(name == "customerType"){
						SC.say("提示","客户类型不可为空");
						isSubmit = false;
						break;
					}else if(name == "companyCity"){
						SC.say("提示","所在城市不可为空");
						isSubmit = false;
						break;
					}else if(name == "companyProvince"){
						SC.say("提示","所在省份不可为空");
						isSubmit = false;
						break;
					}else if(name == "type"){
						SC.say("提示","客户分类不可为空");
						isSubmit = false;
						break;
					}
				}
			}
		}
		if(!hasMainEmployee){
			SC.say("提示","请添加主要联系人员");
			isSubmit = false;
		}
		return isSubmit;
    }
    
    //修改装载数据
  	public void setValueRecord(Map<String,Object> valueMap){
  		if(!BaseHelpUtils.isNullOrEmpty(valueMap)){
  			basicForm.setValues(valueMap);
  			enterForm.setValues(valueMap);
  			addressForm.setValues(valueMap);
  			detailForm.setValues(valueMap);
  			//获取客户主键Id
  			int customerId = BaseHelpUtils.getIntValue(valueMap, "customerId");
  			//加载客户联系人信息
  			loadCustomerContact(customerId);
  		}
  	}
  	
  	//加载客户相关联系人员
  	public void loadCustomerContact(int customerId){
  		Map<String,Object> param = new HashMap<>();
  		param.put("customerId",customerId);
  		DBDataSource.callOperation("ST_CustomerContact","find",param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	Record[] records = dsResponse.getData();
                	otherContactGrid.setData(records);
                	if(!BaseHelpUtils.isNullOrEmpty(records) && records.length > 0){
                		for(Record r : records){
                			//获取联系人类型，如果有主要联系人，则显示主要联系人信息
                			int employeeType = BaseHelpUtils.getIntValue(r.getAttribute("employeeType"));
                			if(employeeType == 1){//说明是主要联系人
                				mainContactForm.setValues(r.toMap());
                				hasMainEmployee = true;
                				break;
                			}
                		}
                	}
                } 
            }
        });
  	}
    
    protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}

	public Window getParWindow() {
		return parWindow;
	}

	public void setParWindow(Window parentWindow) {
		this.parWindow = parentWindow;
	}

    @SuppressWarnings("rawtypes")
	@Override
    public Map getValuesAsMap() {
        return null;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_ClientRecord";
    }

}
