package com.pomplatform.client.purchase.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Window;
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
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class SupplierManageViewDesignPanel extends AbstractWizadPage {
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
    public SupplierManageViewDesignPanel() {
    	//主板面板
    	VLayout mainLayout = new VLayout(10);
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	addMember(mainLayout);
    	
        SectionStack sectionStack = new SectionStack();  
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
        sectionStack.setWidth100();  
        sectionStack.setHeight100(); 
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
        ComboBoxItem reportEmployeeIdItem = new ComboBoxItem("reportEmployeeId","报备人员");
        reportEmployeeIdItem.setValueMap(KeyValueManager.getValueMap("employee_list"));
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
        TextItem companyParentNameItem = new TextItem("companyParentName","集团名称");
        companyParentNameItem.setWidth("*");
        __customerFormItems.add(companyParentNameItem);
        TextItem companyParentAddressItem = new TextItem("companyParentAddress","集团地址");
        companyParentAddressItem.setWidth("*");
        __customerFormItems.add(companyParentAddressItem);
        TextItem companyChildNameItem = new TextItem("companyChildName","分支机构");
        companyChildNameItem.setWidth("*");
        __customerFormItems.add(companyChildNameItem);
        TextItem companyOrganizationalItem = new TextItem("companyOrganizational","组织架构");
        companyOrganizationalItem.setWidth("*");
        __customerFormItems.add(companyOrganizationalItem);
        TextAreaItem companyBriefItem = new TextAreaItem("companyBrief","公司简介");
        companyBriefItem.setWidth("*");
        __customerFormItems.add(companyBriefItem);
        detailForm.setFields(webSiteItem,companyStockCodeItem,companyEmployeeNumItem,companySetupItem,companyNatureItem,companyQualificationItem,companyParentNameItem
		,companyParentAddressItem,companyChildNameItem,companyOrganizationalItem,companyBriefItem);
        
        VLayout rightLayout = new VLayout();
        rightLayout.setHeight100();
        rightLayout.setBorder(borderStyle);
        rightLayout.setWidth("50%");
        zyLayout.addMember(rightLayout);
        //主要联系人面板
        SectionStack mainContactStack = new SectionStack();  
        mainContactStack.setHeight("30%");  
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
        otherContactGrid.setCanRemoveRecords(false);
        otherContactGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Record r = otherContactGrid.getSelectedRecord();
				if(!BaseHelpUtils.isNullOrEmpty(r)){
					final PopupWindow popupWindow = new PopupWindow("联系人员信息详情");
					popupWindow.setWidth("50%");
					popupWindow.setHeight("75%");
					popupWindow.centerInPage();
					AddSupplierContactPanel childPanel = new AddSupplierContactPanel();
					childPanel.initComponents();
					popupWindow.addItem(childPanel);
					childPanel.setParentWindow(popupWindow);
					childPanel.setValueRecord(r.toMap());
					childPanel.setFormItemDisabled();
					popupWindow.centerInPage();
					popupWindow.show();
				}
			}
		});
        otherContactStack.setSections(otherContactSection);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
        }
    }
    
    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(DSSemployeeNew.getInstance());
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
		return true;
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
  		int len = __customerFormItems.size();
		if(len > 0){
			for(FormItem r : __customerFormItems){
				r.setDisabled(true);
			}
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
                				break;
                			}
                		}
                	}
                } 
            }
        });
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
