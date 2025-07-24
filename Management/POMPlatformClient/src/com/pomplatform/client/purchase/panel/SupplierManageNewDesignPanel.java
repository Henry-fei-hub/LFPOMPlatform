package com.pomplatform.client.purchase.panel;

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
import com.smartgwt.client.data.Criteria;
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
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
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

public class SupplierManageNewDesignPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private Window parWindow;
    private final String borderStyle = "1px solid #dbdbdb";
    private DynamicForm mainContactForm;
    private DelicacyListGrid otherContactGrid;
    protected List<FormItem> __customerFormItems = new ArrayList<>();
    protected List<FormItem> __annoucementFormItems = new ArrayList<>();
    protected List<FormItem> __activityFormItems = new ArrayList<>();
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private static String majorContactPerson = "";
    //设置默认没有选择主要联系人
    private boolean hasMainEmployee = false;
    private Map<String,Object> emptyMap = new HashMap<>();
    public SupplierManageNewDesignPanel() {
        Criteria c = new Criteria();
        c.addCriteria("status", 0);
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
					customerInfoMap.put("supplierContacts", listMap);
					sureButton.setDisabled(true);
					customerInfoMap.put("createEmployeeId",ClientUtil.getEmployeeId());
					customerInfoMap.put("majorContactPerson",majorContactPerson);
					customerInfoMap.put("optType","onPurchaseInfoSave");
					DBDataSource.callOperation("EP_OnPurchaseProcess",customerInfoMap, new DSCallback() {
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
			                	ClientUtil.displayErrorMessage(dsResponse);
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
        leftLayout.setWidth("60%");
        zyLayout.addMember(leftLayout);
        DynamicForm basicForm = new DynamicForm();
        basicForm.setIsGroup(true);
        basicForm.setNumCols(2);
        basicForm.setGroupTitle("供应商基本信息");
        leftLayout.addMember(basicForm);
        
        TextItem supplierNameItem = new TextItem("supplierName",shouldNotBeNull+"供应商名称");
        supplierNameItem.setWidth("*");
        __customerFormItems.add(supplierNameItem);
        
        TextItem abbreviatedNameItem = new TextItem("abbreviatedName","供应商简称");
        abbreviatedNameItem.setWidth("*");
        __customerFormItems.add(abbreviatedNameItem);
        
        SelectItem supplierTypeItem = new SelectItem("supplierType",shouldNotBeNull+"供应商类型");
        supplierTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_187"));
        supplierTypeItem.setWidth("*");
        __customerFormItems.add(supplierTypeItem);
        
        SelectItem supplierLevelItem = new SelectItem("supplierLevel",shouldNotBeNull+"供应商级别");
        supplierLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_188"));
        supplierLevelItem.setWidth("*");
        __customerFormItems.add(supplierLevelItem);
        
        TextItem contactMobileItem = new TextItem("contactPhone","联系电话");
        contactMobileItem.setWidth("*");
        __customerFormItems.add(contactMobileItem);
        
        TextItem emailItem = new TextItem("email","邮箱");
        emailItem.setWidth("*");
        __customerFormItems.add(emailItem);
        
        TextItem faxItem = new TextItem("fax","传真");
        faxItem.setWidth("*");
        __customerFormItems.add(faxItem);
        
        TextItem postCodeItem = new TextItem("postCode","邮编");
        postCodeItem.setWidth("*");
        __customerFormItems.add(postCodeItem);
        
        basicForm.setFields(supplierNameItem,abbreviatedNameItem,supplierTypeItem,supplierLevelItem,contactMobileItem,emailItem,faxItem,postCodeItem);
        
        //支付相关信息
        DynamicForm enterForm = new DynamicForm();
        enterForm.setIsGroup(true);
        enterForm.setNumCols(4);
        enterForm.setGroupTitle("支付信息");
        leftLayout.addMember(enterForm);
        
        TextItem bankNameItem = new TextItem("bankName","银行名称");
        bankNameItem.setWidth("*");
        __customerFormItems.add(bankNameItem);
        
        TextItem payNameItem = new TextItem("payName","账户名称");
        payNameItem.setWidth("*");
        __customerFormItems.add(payNameItem);
        
        TextItem payCodeItem = new TextItem("payCode","银行账号");
        payCodeItem.setWidth("*");
        __customerFormItems.add(payCodeItem);
        
        TextItem taxCodeItem = new TextItem("taxCode","税号");
        taxCodeItem.setWidth("*");
        __customerFormItems.add(taxCodeItem);
        
        enterForm.setFields(bankNameItem,payNameItem,payCodeItem,taxCodeItem);
        
        DynamicForm addressForm = new DynamicForm();
        addressForm.setIsGroup(true);
        addressForm.setNumCols(4);
        addressForm.setGroupTitle("供应商地址信息");
        leftLayout.addMember(addressForm);
        ComboBoxItem countryItem = new ComboBoxItem("country",shouldNotBeNull+"所在国家");
        countryItem.setWidth("*");
        countryItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        countryItem.setValueMap(KeyValueManager.getValueMap("countries"));
        __customerFormItems.add(countryItem);
        
        ComboBoxItem cityItem = new ComboBoxItem("city",shouldNotBeNull+"所在城市");
        cityItem.setWidth("*");
        cityItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        __customerFormItems.add(cityItem);
        
        ComboBoxItem provinceItem = new ComboBoxItem("province",shouldNotBeNull+"所在省份");
        provinceItem.setWidth("*");
        provinceItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        __customerFormItems.add(provinceItem);
        provinceItem.setValueMap(KeyValueManager.getValueMap("provinces"));
        provinceItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int id = BaseHelpUtils.getIntValue(event.getValue());
				if(id > 0) {
					//根据省份id去检索该省份下的城市，并封装数据
					Map<String,Object> params = new HashMap<>();
					params.put("parentId",id);
	        	    DBDataSource.callOperation("ST_Area","find",params, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if(dsResponse.getStatus() >= 0){
								Record[] cityRecords = dsResponse.getData();
								LinkedHashMap<String, String> cityMap = new LinkedHashMap<>();
								for(Record e : cityRecords){
									cityMap.put(e.getAttribute("areaId"), e.getAttribute("allName"));
								}
								cityItem.setValueMap(cityMap);
							}
						}
	        	    	
	        	    });
				}
			}
		});
        
        TextItem addressItem = new TextItem("address","详细地址");
        addressItem.setWidth("*");
        __customerFormItems.add(addressItem);
        addressForm.setFields(countryItem,provinceItem,cityItem,addressItem);
        
        DynamicForm detailForm = new DynamicForm();
        detailForm.setIsGroup(true);
        detailForm.setNumCols(4);
        detailForm.setGroupTitle("供应商详细信息");
        leftLayout.addMember(detailForm);
        
        ComboBoxItem createEmployeeIdItem = new ComboBoxItem("createEmployeeId","登记人");
        createEmployeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
        createEmployeeIdItem.setDisabled(true);
        createEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        createEmployeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        createEmployeeIdItem.setWidth("*");
        createEmployeeIdItem.setHidden(true);
        __customerFormItems.add(createEmployeeIdItem);
        
        ComboBoxItem parentIdItem = new ComboBoxItem("parentId","父级供应商");
        parentIdItem.setWidth("*");
        parentIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        parentIdItem.setValueMap(KeyValueManager.getValueMap("suppliers"));
        __customerFormItems.add(parentIdItem);
        
        IntegerItem startOrderCountItem = new IntegerItem("startOrderCount", "起订量");
        startOrderCountItem.setWidth("*");
        __customerFormItems.add(startOrderCountItem);
        
        IntegerItem productionCycleItem = new IntegerItem("productionCycle", "生产周期");
        productionCycleItem.setWidth("*");
        __customerFormItems.add(productionCycleItem);
        
        IntegerItem logisticsCycleItem = new IntegerItem("logisticsCycle", "物流周期");
        logisticsCycleItem.setWidth("*");
        __customerFormItems.add(logisticsCycleItem);
        
        ComboBoxItem logisticsTypeItem = new ComboBoxItem("logisticsType","物流方式");
        logisticsTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_189"));
        logisticsTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        logisticsTypeItem.setWidth("*");
        __customerFormItems.add(logisticsTypeItem);
        
        TextItem warrantyPeriodItem = new TextItem("warrantyPeriod","质保期");
        warrantyPeriodItem.setWidth("*");
        __customerFormItems.add(warrantyPeriodItem);
        
        DateItem startCoworkDateItem = new DateItem("startCoworkDate","开始合作日期");
        startCoworkDateItem.setWidth("*");
        startCoworkDateItem.setUseTextField(true);  
        __customerFormItems.add(startCoworkDateItem);
        
        TextItem accountPeriodItem = new TextItem("accountPeriod","账期");
        accountPeriodItem.setWidth("*");
        __customerFormItems.add(accountPeriodItem);
        
        DateItem registeredDateItem = new DateItem("registeredDate","注册日期");
        registeredDateItem.setWidth("*");
        registeredDateItem.setUseTextField(true);  
        __customerFormItems.add(registeredDateItem);
        
        TextItem registeredCapitalItem = new TextItem("registeredCapital","注册资金");
        registeredCapitalItem.setWidth("*");
        __customerFormItems.add(registeredCapitalItem);
        
        TextItem registeredAddressItem = new TextItem("registeredAddress","注册地址");
        registeredAddressItem.setWidth("*");
        __customerFormItems.add(registeredAddressItem);
        
        TextItem productionAddressItem = new TextItem("productionAddress","生产地址");
        productionAddressItem.setWidth("*");
        __customerFormItems.add(productionAddressItem);
        
        TextItem majorBusinessItem = new TextItem("majorBusiness","主要业务");
        majorBusinessItem.setWidth("*");
        __customerFormItems.add(majorBusinessItem);
        
        BooleanItem isIncludeInstallItem = new BooleanItem("isIncludeInstall","是否包含安装");
        isIncludeInstallItem.setWidth("*");
        __customerFormItems.add(isIncludeInstallItem);
        
        TextAreaItem remarkItem = new TextAreaItem("remark","备注");
        remarkItem.setStartRow(true);
        remarkItem.setWidth("*");
        remarkItem.setColSpan(4);
        remarkItem.setRowSpan(3);
        __customerFormItems.add(remarkItem);
        
        detailForm.setFields(createEmployeeIdItem,parentIdItem,startOrderCountItem,productionCycleItem,logisticsCycleItem,logisticsTypeItem
		,warrantyPeriodItem,startCoworkDateItem,accountPeriodItem,registeredDateItem,registeredCapitalItem,registeredAddressItem
		,productionAddressItem,majorBusinessItem,isIncludeInstallItem,remarkItem);
        
        
        
        VLayout rightLayout = new VLayout();
        rightLayout.setHeight100();
        rightLayout.setBorder(borderStyle);
        rightLayout.setWidth("40%");
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
				AddSupplierContactPanel childPanel = new AddSupplierContactPanel();
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
							int contactType = BaseHelpUtils.getIntValue(valueMap,"contactType");
							Record re = new Record(valueMap);
							Record[] oldGirdData = otherContactGrid.getRecords();
							int len = oldGirdData.length;
							Record[] newGirdData = new Record[len+1];
							if(len > 0){
								for(int i = 0;i<len;i++){
									//如果已经存在了主要联系人，则更新主要联系人,确保主要联系人只有一个
									newGirdData[i] = oldGirdData[i];
									if(hasMainEmployee && contactType == 1){
										if(BaseHelpUtils.getIntValue(newGirdData[i].getAttribute("contactType")) == 1){
											newGirdData[i].setAttribute("contactType",2);
										}
									}
								}
							}
							newGirdData[len] = re;
							otherContactGrid.setData(newGirdData);
							if(contactType == 1){//说明是主要联系人
								mainContactForm.setValues(valueMap);
								//设置主要联系人
								majorContactPerson = BaseHelpUtils.getStringValue(valueMap, "contactName");
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
        TextItem contactNameItem = new TextItem("contactName","姓名");
        contactNameItem.setDisabled(true);
        contactNameItem.setWidth("*");
        TextItem contactPhoneItem = new TextItem("contactPhone","联系电话");
        contactPhoneItem.setDisabled(true);
        contactPhoneItem.setWidth("*");
        TextItem contactEmailItem = new TextItem("contactEmail","邮箱");
        contactEmailItem.setDisabled(true);
        contactEmailItem.setWidth("*");
        mainContactForm.setFields(contactNameItem,contactPhoneItem,contactEmailItem);
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
		fields[fieldIdx] = new ListGridField("supplierContactId");
		fields[fieldIdx].setHidden(true);
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactName","姓名");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactPhone","联系电话");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactEmail","邮箱");
		fieldIdx++;
		fields[fieldIdx] = new ListGridField("contactType","联系人类型");
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
				int contactType = BaseHelpUtils.getIntValue(r.getAttribute("contactType"));
				if(contactType == 1){
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
					AddSupplierContactPanel childPanel = new AddSupplierContactPanel();
					childPanel.initComponents();
					popupWindow.addItem(childPanel);
					childPanel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							Object obj = popupWindow.getLayoutData();
							if(!BaseHelpUtils.isNullOrEmpty(obj)){
								Map<String, Object> valueMap = (Map<String,Object>)obj;
								//获取联系人类型
								int contactType = BaseHelpUtils.getIntValue(valueMap,"contactType");
								Record oldRecord = otherContactGrid.getSelectedRecord();
								int oldEmployeeType = BaseHelpUtils.getIntValue(oldRecord.getAttribute("contactType"));
								if(contactType == 1){
									if(oldEmployeeType != 1){
										if(hasMainEmployee){//说明原就有一个主要联系人员，则需要把原来那个主要联系人员状态改为其他联系人员
											Record[] datas = otherContactGrid.getRecords();
											if(!BaseHelpUtils.isNullOrEmpty(datas) && datas.length > 0){
												for(Record r : datas){
													if(BaseHelpUtils.getIntValue(r.getAttribute("contactType")) == 1){
														r.setAttribute("contactType",2);
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
					if(name == "supplierName"){
						SC.say("提示","供应商名称不可为空");
						isSubmit = false;
						break;
					}else if(name == "supplierType"){
						SC.say("提示","供应商类型不可为空");
						isSubmit = false;
						break;
					}else if(name == "supplierLevel"){
						SC.say("提示","供应商级别不可为空");
						isSubmit = false;
						break;
					}else if(name == "country"){
						SC.say("提示","所在国家不可为空");
						isSubmit = false;
						break;
					}else if(name == "city"){
						SC.say("提示","所在城市不可为空");
						isSubmit = false;
						break;
					}else if(name == "province"){
						SC.say("提示","所在省份不可为空");
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
    public java.util.Map getValuesAsMap() {
        return null;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_ClientRecord";
    }

}
