package com.pomplatform.client.customer.panel;

import java.util.ArrayList;
import java.util.Date;
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
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.pomplatform.client.employeenew.datasource.DSSemployeeNew;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CompetitionUnitsNewDesignPanel extends AbstractWizadPage {
    private final Logger __logger = Logger.getLogger("");
    private Window parWindow;
    private final String borderStyle = "1px solid #dbdbdb";
    protected List<FormItem> __customerFormItems = new ArrayList<>();
    protected List<FormItem> __annoucementFormItems = new ArrayList<>();
    protected List<FormItem> __activityFormItems = new ArrayList<>();
    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
    private DynamicForm basicForm;
    private DynamicForm enterForm;
    private DynamicForm performanceForm;
    private DynamicForm detailForm;
    private IButton sureButton;
    
    public CompetitionUnitsNewDesignPanel() {
    	//主板面板
    	VLayout mainLayout = new VLayout(10);
    	mainLayout.setHeight100();
    	mainLayout.setWidth100();
    	addMember(mainLayout);
    	
        VLayout leftLayout = new VLayout();
        leftLayout.setBorder(borderStyle);
        leftLayout.setHeight("95%");
        leftLayout.setWidth100();
        mainLayout.addMember(leftLayout);
        basicForm = new DynamicForm();
        basicForm.setIsGroup(true);
        basicForm.setNumCols(6);
        basicForm.setGroupTitle("基本信息");
        leftLayout.addMember(basicForm);
        TextItem competitionUnitIdItem = new TextItem("competitionUnitId","ID");
        competitionUnitIdItem.setWidth("*");
        competitionUnitIdItem.hide();
        __customerFormItems.add(competitionUnitIdItem);
        
        TextItem nameItem = new TextItem("name",shouldNotBeNull+"名称");
        nameItem.setWidth("*");
        nameItem.setColSpan(6);
        __customerFormItems.add(nameItem);
        
        TextItem plateTypeNameItem = new TextItem("plateTypeName","英文名称");
        plateTypeNameItem.setWidth("*");
        plateTypeNameItem.setStartRow(true);
        __customerFormItems.add(plateTypeNameItem);
        TextItem areaNameItem = new TextItem("areaName",shouldNotBeNull+"区域");
        areaNameItem.setWidth("*");
        __customerFormItems.add(areaNameItem);
        TextItem companyEmployeeNumItem = new TextItem("companyEmployeeNum","公司人数");
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
        
        TextItem addressItem = new TextItem("address","地址");
        addressItem.setWidth("*");
        __customerFormItems.add(addressItem);
        
        TextItem webSiteItem = new TextItem("webSite","网站");
        webSiteItem.setWidth("*");
        __customerFormItems.add(webSiteItem);
        TextItem companyStockCodeItem = new TextItem("companyStockCode","股票代码");
        companyStockCodeItem.setWidth("*");
        __customerFormItems.add(companyStockCodeItem);
        
        TextItem companyOrganizationalItem = new TextItem("companyOrganizational","组织架构");
        companyOrganizationalItem.setWidth("*");
        __customerFormItems.add(companyOrganizationalItem);
        
        TextItem companyParentNameItem = new TextItem("companyParentName","集团名称");
        companyParentNameItem.setWidth("*");
        __customerFormItems.add(companyParentNameItem);
        TextItem companyParentAddressItem = new TextItem("companyParentAddress","集团地址");
        companyParentAddressItem.setWidth("*");
        __customerFormItems.add(companyParentAddressItem);
        TextItem companyChildNameItem = new TextItem("companyChildName","分支机构");
        companyChildNameItem.setWidth("*");
        __customerFormItems.add(companyChildNameItem);
        TextAreaItem companyBriefItem = new TextAreaItem("companyBrief","公司简介");
        companyBriefItem.setWidth("*");
        companyBriefItem.setColSpan(6);
        __customerFormItems.add(companyBriefItem);
        
        basicForm.setFields(competitionUnitIdItem,nameItem,plateTypeNameItem,areaNameItem,companyEmployeeNumItem
		,companySetupItem,companyNatureItem,companyQualificationItem
		,companyProvinceItem,companyCityItem,addressItem,webSiteItem,companyStockCodeItem,companyOrganizationalItem
		,companyParentNameItem,companyParentAddressItem,companyChildNameItem,companyBriefItem);
        
        //业务范围信息
        enterForm = new DynamicForm();
        enterForm.setIsGroup(true);
        enterForm.setNumCols(4);
        enterForm.setGroupTitle("业务范围信息");
        leftLayout.addMember(enterForm);
        TextItem businessPlateItem = new TextItem("businessPlate","业务板块");
        businessPlateItem.setWidth("*");
        __customerFormItems.add(businessPlateItem);
        TextItem professionalPlateItem = new TextItem("professionalPlate","专业板块");
        professionalPlateItem.setWidth("*");
        __customerFormItems.add(professionalPlateItem);
        enterForm.setFields(businessPlateItem,professionalPlateItem);
        
        //代表业绩及简介
        performanceForm = new DynamicForm();
        performanceForm.setIsGroup(true);
        performanceForm.setNumCols(4);
        performanceForm.setGroupTitle("代表业绩及简介");
        leftLayout.addMember(performanceForm);
        TextItem projectNameItem = new TextItem("projectName","项目名称");
        projectNameItem.setWidth("*");
        __customerFormItems.add(projectNameItem);
        TextItem projectVolumeItem = new TextItem("projectVolume","项目体量");
        projectVolumeItem.setWidth("*");
        __customerFormItems.add(projectVolumeItem);
        DateItem designDateItem = new DateItem("designDate","设计日期");
        designDateItem.setUseTextField(true);
        designDateItem.setWidth("*");
        __customerFormItems.add(designDateItem);
        TextItem designHighlightItem = new TextItem("designHighlight","设计亮点");
        designHighlightItem.setWidth("*");
        __customerFormItems.add(designHighlightItem);
        performanceForm.setFields(projectNameItem,projectVolumeItem,designDateItem,designHighlightItem);
        
        detailForm = new DynamicForm();
        detailForm.setIsGroup(true);
        detailForm.setNumCols(2);
        detailForm.setGroupTitle("其他信息");
        leftLayout.addMember(detailForm);
        
        TextItem mainWorkCustomerItem = new TextItem("mainWorkCustomer","主要合作客户");
        mainWorkCustomerItem.setWidth("*");
        __customerFormItems.add(mainWorkCustomerItem);
        TextItem mianAchievementItem = new TextItem("mianAchievement","主要合作业绩");
        mianAchievementItem.setWidth("*");
        __customerFormItems.add(mianAchievementItem);
        TextItem designFeeStandardItem = new TextItem("designFeeStandard","设计取费标准");
        designFeeStandardItem.setWidth("*");
        __customerFormItems.add(designFeeStandardItem);
        TextItem coreStrengthItem = new TextItem("coreStrength","核心优势");
        coreStrengthItem.setWidth("*");
        __customerFormItems.add(coreStrengthItem);
        TextItem weaknessesItem = new TextItem("weaknesses","劣势");
        weaknessesItem.setWidth("*");
        __customerFormItems.add(weaknessesItem);
        detailForm.setFields(mainWorkCustomerItem,mianAchievementItem,designFeeStandardItem,coreStrengthItem);
  
        HLayout buttonLayout = new HLayout(10);
    	buttonLayout.setHeight("5%");
    	buttonLayout.setLayoutTopMargin(10);
    	buttonLayout.setAlign(Alignment.RIGHT);
    	mainLayout.addMember(buttonLayout);
    	sureButton = new IButton("保存");
    	sureButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				boolean isSubmit = checkData();
				if(isSubmit){
					//获取客户相关信息
					Map<String,Object> customerInfoMap = getCustomerValueMap();
					customerInfoMap.put("operateEmployeeId",ClientUtil.getEmployeeId());
					customerInfoMap.put("createTime",new Date());
					DBDataSource.callOperation("ST_CompetitionUnit","saveOrUpdate",customerInfoMap, new DSCallback() {
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
    	IButton cancelButton = new IButton("关闭");
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
    
    //修改装载数据
  	public void setValueRecord(Map<String,Object> valueMap){
  		if(!BaseHelpUtils.isNullOrEmpty(valueMap)){
  			basicForm.setValues(valueMap);
  			enterForm.setValues(valueMap);
  			performanceForm.setValues(valueMap);
  			detailForm.setValues(valueMap);
  		}
  	}
  	
  	public void setFormDisabled(){
  		int len = __customerFormItems.size();
		if(len > 0){
			for(FormItem r : __customerFormItems){
				r.setDisabled(true);
			}
		}
		sureButton.hide();
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
					if(name == "areaName"){
						SC.say("提示","区域不可为空");
						isSubmit = false;
						break;
					}else if(name == "name"){
						SC.say("提示","名称不可为空");
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
					}
				}
			}
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
