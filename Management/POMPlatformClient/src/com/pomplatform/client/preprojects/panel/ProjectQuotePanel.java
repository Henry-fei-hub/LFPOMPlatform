package com.pomplatform.client.preprojects.panel;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.NewProcessWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.storage.client.Storage;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.common.SyncDataUtil;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DoubleItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.events.DataChangedEvent;
import com.smartgwt.client.widgets.grid.events.DataChangedHandler;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ProjectQuotePanel extends HLayout implements HasHandlers {

	private Window parentWindow;
	private static Logger __logger = Logger.getLogger("");
	private DelicacyListGrid  grid;
	private SelectItem projectTypeItem; 
	private SelectItem projectQuoteTemplatesParentIdItem; 
	private SelectItem customerTypeItem;
	private TextItem totalBuildingAreasItem;
	private TextItem provinceItem;
	private TextItem cityItem;
	private  DynamicForm form;
	private  DynamicForm topLeftForm;
	private  DynamicForm topRightForm;
	private TextItem competitionNameItem;
	private Label TitleView;
	private VLayout mainLayout;
	private VLayout formLayout;
	private HLayout topLayout;
	private HLayout topRightLayout;
	private HLayout topLeftLayout;
	private HLayout btnLayout;
	private TextAreaItem  remarkItem;
	private DoubleItem  basicAmountItem;//基准总额
	private DoubleItem  totalAmountItem;//小计总额
	private DoubleItem  upAmountItem;//上浮金额
	private DoubleItem  upPercentItem;//上浮系数
	private DoubleItem  preferentialAmountItem;//优惠金额
	private DoubleItem  perferentialPercentItem;//优惠系数
	private DoubleItem  specialDiscountAmountItem;//特殊折扣金额
	private DoubleItem  specialDiscountPercentItem;//特殊折扣系数
	private DoubleItem  finalAmountItem;//不含税合计
	private DoubleItem  finalPercentItem;//最终系数
	private DoubleItem  taxAmountItem;//税率
	private DoubleItem  getTaxAmountItem;//设计上税金额
	private DoubleItem  otherTaxAmountItem;//采买税率（其他）
	private DoubleItem  getOtherTaxAmountItem;//采买上税金额
	private DoubleItem  taxFinalAmountItem;//含税合计
	private DoubleItem  DesignPriceItem;//设计合计金额 
	private DoubleItem  ALLBuyPriceItem;//采买合计金额
	private TextItem   projectIdItem;//项目id

	private IButton okBtn;
	private IButton cleanBtn;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public void initComponents() {

		mainLayout=new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		formLayout = new VLayout();
		formLayout.setHeight100();
		formLayout.setMembersMargin(5);
		formLayout.setWidth100();
		formLayout.setAlign(Alignment.CENTER);
		mainLayout.addMember(formLayout);



		TitleView = new Label();
		TitleView.setContents("<font style=\"color:red;font-size:18px;font-weight:bold;\">项目报价</font>");
		TitleView.setWidth("100%");
		TitleView.setHeight("5%");
		TitleView.setAlign(Alignment.CENTER);
		formLayout.addMember(TitleView);

		projectTypeItem=new SelectItem("projectType","业态");
		projectTypeItem.setCanEdit(false);
		KeyValueManager.loadValueMap("pre_business_type",projectTypeItem);
		projectTypeItem.setWidth("*");


		projectQuoteTemplatesParentIdItem=new SelectItem("ProjectQuoteTemplatesParentId","报价模板");
		projectQuoteTemplatesParentIdItem.setCanEdit(true);
		int  projectType=BaseHelpUtils.getIntValue(recordData.getAttribute("projectType"));
		Map<String, Object> params = new HashMap<>();
		params.put("businessType",projectType);
		Record[] records=SyncDataUtil.getValueByTableNames("ST_ProjectQuoteTemplatesParent", "find", params);
		LinkedHashMap<Integer, String> linkmap=new LinkedHashMap<>();
		if(!BaseHelpUtils.isNullOrEmpty(records)){
			for (Record record : records) {
				int projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplatesParentId"));
				String parentName=BaseHelpUtils.getString(record.getAttribute("parentName"));
				linkmap.put(projectQuoteTemplatesParentId, parentName);
			}
			projectQuoteTemplatesParentIdItem.setValueMap(linkmap);
		}
		projectQuoteTemplatesParentIdItem.setWidth("*");
		projectQuoteTemplatesParentIdItem.addChangedHandler(new com.smartgwt.client.widgets.form.fields.events.ChangedHandler() {
			@Override
			public void onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent event) {
				lodaData();

			}
		});


		totalBuildingAreasItem=new TextItem("totalBuildingAreas","建筑面积");
		totalBuildingAreasItem.setCanEdit(false);
		totalBuildingAreasItem.setWidth("*");

		customerTypeItem=new SelectItem("customerType","客户类型");
		customerTypeItem.setCanEdit(false);
		customerTypeItem.setWidth("*"); 

		competitionNameItem=new TextItem("competitionName","竞争单位");
		competitionNameItem.setCanEdit(false);
		competitionNameItem.setWidth("*");


		provinceItem=new TextItem("province","省份");
		provinceItem.setCanEdit(false);
		provinceItem.setWidth("*");

		cityItem=new TextItem("city","城市");
		cityItem.setCanEdit(false);
		cityItem.setWidth("*");

		projectIdItem=new TextItem("preProjectId","项目ID");
		projectIdItem.setCanEdit(false);
		projectIdItem.setWidth("*");
		projectIdItem.setHidden(true);



		form = new DynamicForm();
		form.setAlign(Alignment.CENTER);
		form.setPadding(5);
		form.setMargin(2);
		form.setWidth100();
		form.setHeight("15%");


		form.setItems(projectTypeItem,projectQuoteTemplatesParentIdItem,totalBuildingAreasItem,customerTypeItem,competitionNameItem,provinceItem,cityItem,projectIdItem);
		form.setNumCols(14);
		ClientUtil.DynamicFormProcessAccordingToDevice(form);
		form.editRecord(recordData);
		String  customerName=BaseHelpUtils.getString(recordData.getAttribute("customerName"));
		Map<String, Object> maps = new HashMap<>();
		maps.put("customerName",customerName);
		Record recordss=SyncDataUtil.getValueByTableName("ST_Customer", "find", maps);
		int customerType=BaseHelpUtils.getIntValue(recordss.getAttribute("customerType"));
		customerTypeItem.setValue(customerType);
		KeyValueManager.loadValueMap("system_dictionary_151", customerTypeItem);
		formLayout.addMember(form);

		basicAmountItem=new DoubleItem("basicAmount","基准总额");
		basicAmountItem.setFormat("#,###,###,###,###,##0.00");
		basicAmountItem.setHint("各项根据预设价格*面积的总和");
		basicAmountItem.setShowHintInField(true);
		basicAmountItem.setWidth("*");

		totalAmountItem=new DoubleItem("totalAmount","小计总额");
		totalAmountItem.setFormat("#,###,###,###,###,##0.00");
		totalAmountItem.setHint("小计全部相加");
		totalAmountItem.setShowHintInField(true);
		totalAmountItem.setWidth("*");

		upAmountItem=new DoubleItem("upAmount","上浮金额");
		upAmountItem.setFormat("#,###,###,###,###,##0.00");
		upAmountItem.setHint("小计总额-基准总额");
		upAmountItem.setShowHintInField(true);
		upAmountItem.setWidth("*");

		upPercentItem=new DoubleItem("upPercent","上浮系数");
		upPercentItem.setFormat("#,###,###,###,###,##0.00");
		upPercentItem.setHint("（小计总额-基准总额）/基准总额");
		upPercentItem.setShowHintInField(true);
		upPercentItem.setWidth("*");

		preferentialAmountItem=new DoubleItem("preferentialAmount","优惠金额"); 
		preferentialAmountItem.setFormat("#,###,###,###,###,##0.00");
		preferentialAmountItem.setHint("基准总额-小计总额");
		preferentialAmountItem.setShowHintInField(true);
		preferentialAmountItem.setWidth("*");


		perferentialPercentItem=new DoubleItem("perferentialPercent","优惠系数");
		perferentialPercentItem.setHint("（基准总额-小计总额）/基准总额");
		perferentialPercentItem.setShowHintInField(true);
		perferentialPercentItem.setWidth("*");

		specialDiscountAmountItem=new DoubleItem("specialDiscountAmount","特殊折扣金额");
		specialDiscountAmountItem.setFormat("#,###,###,###,###,##0.00");
		specialDiscountAmountItem.setHint("可手动输入特殊折扣金额");
		specialDiscountAmountItem.setShowHintInField(true);
		specialDiscountAmountItem.setWidth("*");
		specialDiscountAmountItem.addChangedHandler(new  com.smartgwt.client.widgets.form.fields.events.ChangedHandler() {
			@Override
			public void onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent event) {
				//获取特殊折扣金额
				BigDecimal specialDiscountAmount=BaseHelpUtils.getBigDecimalValue(event.getValue());
				//获取基准金额
				BigDecimal basicAmount=BaseHelpUtils.getBigDecimalValue(basicAmountItem.getValue());
				//获取小计总金额
				BigDecimal alltotalPrice=BaseHelpUtils.getBigDecimalValue(totalAmountItem.getValue());
				if(BaseHelpUtils.isNullOrEmpty(alltotalPrice)||alltotalPrice.compareTo(BigDecimal.ZERO)<0) {
					SC.say("小计总额为空或者小于0");
					return;
				}
				if(BaseHelpUtils.isNullOrEmpty(basicAmount)||basicAmount.compareTo(BigDecimal.ZERO)<0) {
					SC.say("基准金额为空或者小于0");
					return;
				}
				if(specialDiscountAmount.compareTo(BigDecimal.ZERO)<0) {
					SC.say("特殊折扣金额不能为负数");
					return;
				}
				if(BaseHelpUtils.isNullOrEmpty(specialDiscountAmount)||specialDiscountAmount.compareTo(BigDecimal.ZERO)==0) {
					specialDiscountPercentItem.clearValue();
				}

				BigDecimal specialDiscountPercent=specialDiscountAmount.divide(basicAmount,2,RoundingMode.DOWN);//特殊折扣系数=特殊折扣/基准总价
				specialDiscountPercentItem.setValue(specialDiscountPercent);
				//基准金额与小计总额差
				BigDecimal differValue=basicAmount.subtract(alltotalPrice);
				//不含税合计金额
				BigDecimal finalAmount=BigDecimal.ZERO;
				//含税合计金额
				BigDecimal taxFinalAmount=BigDecimal.ZERO;
				//税率
				BigDecimal taxAmount=BaseHelpUtils.getBigDecimalValue(taxAmountItem.getValue());
				if(taxAmount.compareTo(BigDecimal.ZERO)>0) {
					taxAmount=taxAmount.divide(BigDecimal.valueOf(100));
				}
				//采买税率
				BigDecimal otherTaxAmount=BaseHelpUtils.getBigDecimalValue(otherTaxAmountItem.getValue());
				if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {
					otherTaxAmount=otherTaxAmount.divide(BigDecimal.valueOf(100));
				}

				//最终优惠系数=优惠系数+特殊折扣系数
				BigDecimal finalPercent=BigDecimal.ZERO;
				//设计上税金额
				BigDecimal getTaxAmount=BigDecimal.ZERO;
				//采买上税金额
				BigDecimal getOtherTaxAmount=BigDecimal.ZERO;

				//获取采买合计金额
				BigDecimal ALLBuyPrice=BigDecimal.ZERO;
				//获取设计合计金额
				BigDecimal DesignPrice=BigDecimal.ZERO;  
				Record[] recordgrid=grid.getRecords();
				for (Record record : recordgrid) {
					String designTypeName=BaseHelpUtils.getString(record.getAttribute("designTypeName"));
					if(designTypeName.contains("采买")) {
						ALLBuyPrice=BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalPrice")).add(ALLBuyPrice);
					}else {
						DesignPrice=BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalPrice")).add(DesignPrice);
					}
				}
				ALLBuyPriceItem.setValue(ALLBuyPrice);
				DesignPriceItem.setValue(DesignPrice);
				//设计上税金额为
				getTaxAmount=DesignPrice.multiply(taxAmount);
				getTaxAmountItem.setValue(getTaxAmount);
				if(differValue.compareTo(BigDecimal.ZERO)<0) {//如果系数为负数，说明基准<小计,则有上浮金额 ,合计=小计-特殊折扣额    
					perferentialPercentItem.clearValue();
					preferentialAmountItem.clearValue();
					upAmountItem.setValue(differValue.negate());
					BigDecimal upPercent=differValue.negate().divide(basicAmount,2,RoundingMode.HALF_DOWN);
					upPercentItem.setValue(upPercent);
					//不含税合计金额
					finalAmount=alltotalPrice.subtract(specialDiscountAmount);
					finalAmountItem.setValue(finalAmount);

					if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {//如果存在采买税率
						//采买上税金额
						getOtherTaxAmount=ALLBuyPrice.multiply(otherTaxAmount);
						getOtherTaxAmountItem.setValue(getOtherTaxAmount);
						//含税合计金额为
						taxFinalAmount=finalAmount.add(getTaxAmount).add(getOtherTaxAmount);

						taxFinalAmountItem.setValue(taxFinalAmount);
					}else {//若不存在采买税率
						taxFinalAmount=finalAmount.add(getTaxAmount);
						taxFinalAmountItem.setValue(taxFinalAmount);
					}
				}else if(differValue.compareTo(BigDecimal.ZERO)>0) {//如果系数为正数，说明基准>小计,则有优惠金额 , 合计=基准-优惠-特殊折扣
					upAmountItem.clearValue();
					upPercentItem.clearValue();
					//不含税合计金额
					finalAmount=basicAmount.subtract(differValue).subtract(specialDiscountAmount);//合计=基准-优惠-特殊折扣
					finalAmountItem.setValue(finalAmount);


					//优惠系数
					BigDecimal perferentialPercent=differValue.divide(basicAmount,2,RoundingMode.HALF_DOWN);
					preferentialAmountItem.setValue(differValue);//如果系数为正数，则有优惠金额
					perferentialPercentItem.setValue(perferentialPercent);

					//最终优惠系数=优惠系数+特殊折扣系数
					finalPercent=perferentialPercent.add(specialDiscountPercent);
					finalPercentItem.setValue(finalPercent);


					if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {//如果存在采买税率
						//采买上税金额
						getOtherTaxAmount=ALLBuyPrice.multiply(otherTaxAmount);
						getOtherTaxAmountItem.setValue(getOtherTaxAmount);
						//含税合计金额为
						taxFinalAmount=finalAmount.add(getTaxAmount).add(getOtherTaxAmount);

						taxFinalAmountItem.setValue(taxFinalAmount);
					}else {//若不存在采买税率

						taxFinalAmount=finalAmount.add(getTaxAmount);
						taxFinalAmountItem.setValue(taxFinalAmount);
					}
				}else if(differValue.compareTo(BigDecimal.ZERO)==0) {
					upAmountItem.clearValue();
					upPercentItem.clearValue();
					perferentialPercentItem.clearValue();
					preferentialAmountItem.clearValue();

					finalAmountItem.setValue(alltotalPrice);
					if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {//如果存在采买税率
						//采买上税金额
						getOtherTaxAmount=ALLBuyPrice.multiply(otherTaxAmount);
						getOtherTaxAmountItem.setValue(getOtherTaxAmount);
						//含税合计金额为
						taxFinalAmount=finalAmount.add(getTaxAmount).add(getOtherTaxAmount);

						taxFinalAmountItem.setValue(taxFinalAmount);
					}else {//若不存在采买税率
						taxFinalAmount=finalAmount.add(getTaxAmount);
						taxFinalAmountItem.setValue(taxFinalAmount);
					}
				}


			}
		});

		specialDiscountPercentItem=new DoubleItem("specialDiscountPercent","特殊折扣系数");
		specialDiscountPercentItem.setHint("特殊折扣系数=特殊折扣/基准总价");
		specialDiscountPercentItem.setShowHintInField(true);
		specialDiscountPercentItem.setWidth("*");

		finalAmountItem=new DoubleItem("finalAmount","不含税合计金额"); 
		finalAmountItem.setFormat("#,###,###,###,###,##0.00");
		finalAmountItem.setWidth("*");

		DesignPriceItem =new DoubleItem("DesignPrice","设计不含税合计"); 
		DesignPriceItem.setFormat("#,###,###,###,###,##0.00");
		DesignPriceItem.setWidth("*");

		ALLBuyPriceItem=new DoubleItem("ALLBuyPrice","采买不含税合计");
		ALLBuyPriceItem.hide();
		ALLBuyPriceItem.setFormat("#,###,###,###,###,##0.00");
		ALLBuyPriceItem.setWidth("*");

		finalPercentItem=new DoubleItem("finalPercent","最终优惠系数");
		finalPercentItem.setWidth("*");

		taxAmountItem=new DoubleItem("taxAmount","税率(%)");
		taxAmountItem.setWidth("*");

		getTaxAmountItem=new DoubleItem("getTaxAmount","设计上税金额");
		getTaxAmountItem.setFormat("#,###,###,###,###,##0.00");
		getTaxAmountItem.setWidth("*");

		getOtherTaxAmountItem=new DoubleItem("getOtherTaxAmount","采买上税金额");
		getOtherTaxAmountItem.hide();
		getOtherTaxAmountItem.setFormat("#,###,###,###,###,##0.00");
		getOtherTaxAmountItem.setWidth("*");


		otherTaxAmountItem=new DoubleItem("otherTaxAmount","采买税率(%)");
		otherTaxAmountItem.hide();
		otherTaxAmountItem.setHint("需要手动填写");
		otherTaxAmountItem.setShowHintInField(true);
		otherTaxAmountItem.setWidth("*");
		otherTaxAmountItem.addChangedHandler(new com.smartgwt.client.widgets.form.fields.events.ChangedHandler() {
			@Override
			public void onChanged(com.smartgwt.client.widgets.form.fields.events.ChangedEvent event) {
				//获取采买税率
				BigDecimal otherTaxAmount=BaseHelpUtils.getBigDecimalValue(event.getValue());
				if(otherTaxAmount.compareTo(BigDecimal.ZERO)<0) {
					SC.say("其他税金不能为负数");
					return;
				}
				if(otherTaxAmount.compareTo(BigDecimal.ONE)>100) {
					SC.say("其他税金不能大于100");
					return;
				}
				if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {
					otherTaxAmount=otherTaxAmount.divide(BigDecimal.valueOf(100));
				}

				//获取采买不含税合计
				BigDecimal ALLBuyPrice=BaseHelpUtils.getBigDecimalValue(ALLBuyPriceItem.getValue());

				//计算采买上税金额
				BigDecimal getOtherTaxAmount=ALLBuyPrice.multiply(otherTaxAmount);
				getOtherTaxAmountItem.setValue(getOtherTaxAmount);

				//获取设计上税金额
				BigDecimal getTaxAmount=BaseHelpUtils.getBigDecimalValue(getTaxAmountItem.getValue());

				//获取不含税合计金额
				BigDecimal finalAmount=BaseHelpUtils.getBigDecimalValue(finalAmountItem.getValue());

				//计算含税合计金额
				BigDecimal taxFinalAmount=finalAmount.add(getTaxAmount).add(getOtherTaxAmount);
				taxFinalAmountItem.setValue(taxFinalAmount);

			}
		});

		taxFinalAmountItem=new DoubleItem("taxFinalAmount","含税合计金额");
		taxFinalAmountItem.setFormat("#,###,###,###,###,##0.00");
		taxFinalAmountItem.setWidth("*");

		topRightForm = new DynamicForm();
		topRightForm.setAlign(Alignment.RIGHT);
		topRightForm.setPadding(5);
		topRightForm.setMargin(2);
		topRightForm.setCanEdit(false);
		otherTaxAmountItem.setCanEdit(true);
		specialDiscountAmountItem.setCanEdit(true);
		topRightForm.setWidth100();
		topRightForm.setNumCols(4);
		topRightForm.setHeight("100%");
		topRightForm.setItems(basicAmountItem,totalAmountItem,upAmountItem,upPercentItem,preferentialAmountItem,perferentialPercentItem,specialDiscountAmountItem,specialDiscountPercentItem,finalAmountItem,finalPercentItem,DesignPriceItem,ALLBuyPriceItem,taxAmountItem,otherTaxAmountItem,getTaxAmountItem,getOtherTaxAmountItem,taxFinalAmountItem);

		grid=new DelicacyListGrid () {
			@Override
			protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
				record.setAttribute("addChoose","add.png");
				return super.getCellCSSText(record, rowNum, colNum);
			}
		};
		grid.setWidth("100%");
		grid.setHeight("100%");
		int a=0;
		ListGridField[] aFields = new ListGridField[6];
		aFields[a] = new ListGridField("addChoose","新增");
		aFields[a].setWidth("10%");
		aFields[a].setAlign(Alignment.CENTER); 
		aFields[a].setType(ListGridFieldType.IMAGE);  
		aFields[a].setImageHeight(15);
		aFields[a].setCanEdit(false);
		aFields[a].setImageWidth(15);
		aFields[a].addRecordClickHandler(new RecordClickHandler() {
			@Override
			public void onRecordClick(RecordClickEvent event) {
				int rowNum=event.getRecordNum();
				Record beforeRecord=grid.getRecord(rowNum);
				Record[] records=grid.getRecords();
				Record record=new Record();
				record.setAttribute("projectQuoteTemplateId", BaseHelpUtils.getIntValue(beforeRecord.getAttribute("projectQuoteTemplateId")));
				record.setAttribute("designTypeName",beforeRecord.getAttributeAsString("designTypeName"));
				record.setAttribute("designContent",beforeRecord.getAttributeAsString("designContent"));
				record.setAttribute("remark",beforeRecord.getAttributeAsString("remark"));
				record.setAttribute("designStage",BaseHelpUtils.getIntValue(beforeRecord.getAttribute("designStage")));
				record.setAttribute("areaType",BaseHelpUtils.getIntValue(beforeRecord.getAttribute("areaType")));
				record.setAttribute("area",BigDecimal.ZERO);
				record.setAttribute("areaPrice",BigDecimal.ZERO);
				record.setAttribute("totalPrice",BigDecimal.ZERO);
				record.setAttribute("companyId",BaseHelpUtils.getIntValue(beforeRecord.getAttribute("companyId")));
				Record[] recordss=new Record[records.length+1];
				int i=0;
				for (Record record1 : records) {
					recordss[i]=record1;
					if(rowNum==i) {
						i++;
						recordss[i]=record;
						i++;
						continue;
					}
					i++;
				}
				grid.setData(recordss);
				grid.selectRecord(record);
			}
		});
		a++;
		aFields[a] = new ListGridField("projectQuoteTemplateId","模板ID");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		aFields[a].setHidden(true);
		a++;
		aFields[a] = new ListGridField("designTypeName","设计类型");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(false);
		a++;
		aFields[a] = new ListGridField("designContent","设计内容");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setCanEdit(false);
		aFields[a].setWidth("25%");
		a++;
		aFields[a] = new ListGridField("remark","补充说明");
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("35%");
		a++;
		aFields[a] = new ListGridField("designStage","设计阶段");
		aFields[a].setAlign(Alignment.CENTER);
		ComboBoxItem stageIdBoxItem = new ComboBoxItem();
		stageIdBoxItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("system_dictionary_7", aFields[a]);
		aFields[a].setEditorProperties(stageIdBoxItem);
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("areaType","面积类型");
		ComboBoxItem areaTypeItem = new ComboBoxItem();
		areaTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		KeyValueManager.loadValueMap("system_dictionary_203", aFields[a]);
		aFields[a].setAlign(Alignment.CENTER);
		aFields[a].setWidth("25%");
		aFields[a].setDefaultValue(new Date());
		a++;
		aFields[a] = new ListGridField("area","面积");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setWidth("25%");
		aFields[a].setDefaultValue(new Date());
		aFields[a].addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int rowNum=event.getRowNum();
				Record record=grid.getRecord(rowNum);
				//输入面积，根据面积区间，确定面积单价
				Map<String,Object> map=new HashMap<>();
				//获取面积
				BigDecimal area=BaseHelpUtils.getBigDecimalValue(event.getValue());
				int  projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(projectQuoteTemplatesParentIdItem.getValue());
				int  projectQuoteTemplateId=BaseHelpUtils.getIntValue(record.getAttribute("projectQuoteTemplateId"));
				map.put("projectQuoteTemplatesParentId", projectQuoteTemplatesParentId);
				map.put("projectQuoteTemplateId", projectQuoteTemplateId);
				map.put("areaRange", area);
				Record records=SyncDataUtil.getValueByTableName("NQ_GetprojectQuoteAreaRange","find",map);
				if(records==null) {
					event.getForm().getItem("areaPrice").setValue(BigDecimal.ZERO);
					event.getForm().getItem("totalPrice").setValue(BigDecimal.ZERO);
					return;
				}
				//获取单价
				BigDecimal areaPrice=BaseHelpUtils.getBigDecimalValue(records.getAttribute("areaPrice"));
				event.getForm().getItem("areaPrice").setValue(areaPrice);
				//小计
				BigDecimal totalPrice=BaseHelpUtils.getBigDecimalValue(area.multiply(areaPrice));
				event.getForm().getItem("totalPrice").setValue(totalPrice);
				if(area.compareTo(BigDecimal.ZERO)<=0) {
					basicAmountItem.clearValue();
					totalAmountItem.clearValue();
					upAmountItem.clearValue();
					upPercentItem.clearValue();
					preferentialAmountItem.clearValue();
					perferentialPercentItem.clearValue();
					specialDiscountAmountItem.clearValue();
					specialDiscountPercentItem.clearValue();
					finalAmountItem.clearValue();
					finalPercentItem.clearValue();
					taxAmountItem.clearValue();
					otherTaxAmountItem.clearValue();
					taxFinalAmountItem.clearValue();
				}
			}
		});
		a++;
		aFields[a] = new ListGridField("areaPrice","单价");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		//aFields[a].setShowGridSummary(false);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		aFields[a].addChangedHandler(new ChangedHandler() {

			@Override
			public void onChanged(ChangedEvent event) {
				int rowNum=event.getRowNum();
				Record record=grid.getRecord(rowNum);
				//获取面积
				BigDecimal area=BaseHelpUtils.getBigDecimalValue(record.getAttribute("area"));
				//获取单价
				BigDecimal areaPrice=BaseHelpUtils.getBigDecimalValue(event.getValue());
				//小计
				BigDecimal totalPrice=BaseHelpUtils.getBigDecimalValue(area.multiply(areaPrice));
				event.getForm().getItem("totalPrice").setValue(totalPrice);

			}
		});
		a++;
		aFields[a] = new ListGridField("totalPrice","小计");
		aFields[a].setAlign(Alignment.RIGHT);
		aFields[a].setType(ListGridFieldType.FLOAT);
		aFields[a].setFormat("##,###,###,###,##0.00");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		a++;
		aFields[a] = new ListGridField("companyId","归属公司");
		aFields[a].setWidth("25%");
		aFields[a].setCanEdit(true);
		KeyValueManager.loadValueMap("company_records", aFields[a]);
		grid.setFields(aFields);
		grid.setCanResizeFields(true);  
		grid.setCanRemoveRecords(true);
		grid.setShowRecordComponents(true);          
		grid.setShowRecordComponentsByCell(true);
		grid.setAutoFitFieldWidths(false);
		grid.setShowGridSummary(true);
		grid.setCanEdit(true);
		grid.addDataChangedHandler(new DataChangedHandler() {

			@Override
			public void onDataChanged(DataChangedEvent event) {
				ListGridRecord[] listGridRecords=grid.getGridSummaryData();

				//获取小计总额
				BigDecimal alltotalPrice=BigDecimal.ZERO;
				for (ListGridRecord ListGridRecord : listGridRecords) {
					alltotalPrice=BaseHelpUtils.getBigDecimalValue(ListGridRecord.getAttribute("totalPrice"));
				}
				totalAmountItem.setValue(alltotalPrice);

				//获取业态ID
				int projectType=BaseHelpUtils.getIntValue(projectTypeItem.getValue());
				Map<String,Object> map=new HashMap<>();
				int  projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(projectQuoteTemplatesParentIdItem.getValue());
				map.put("businessType", projectType);
				map.put("projectQuoteTemplatesParentId", projectQuoteTemplatesParentId);
				map.put("addtionalCondition", "order by design_type_name desc,project_quote_template_id");
				Record[] records=SyncDataUtil.getValueByTableNames("ST_ProjectQuoteTemplate","find",map);
				//获取模板单价
				BigDecimal areaPrices=BigDecimal.ZERO;
				//输入的面积
				BigDecimal area=BigDecimal.ZERO;
				//基准金额
				BigDecimal  basicAmount=BigDecimal.ZERO;
				Record[] recordGet=grid.getRecords();
				SC.debugger();
				for(int i=0;i<recordGet.length;i++) {
					area=BaseHelpUtils.getBigDecimalValue(recordGet[i].getAttribute("area"));
					//模板ID
					int projectQuoteTemplateId=BaseHelpUtils.getIntValue(records[i].getAttribute("projectQuoteTemplateId"));
					if(BaseHelpUtils.isNullOrEmpty(area)||area.compareTo(BigDecimal.ZERO)==0) {
						continue;
					}
					map.put("projectQuoteTemplatesParentId", projectQuoteTemplatesParentId);
					map.put("projectQuoteTemplateId", projectQuoteTemplateId);
					map.put("areaRange", area);
					Record recordRange=SyncDataUtil.getValueByTableName("NQ_GetprojectQuoteAreaRange","find",map);
					if(recordRange!=null) {
						//获取单价
						areaPrices=BaseHelpUtils.getBigDecimalValue(recordRange.getAttribute("areaPrice"));
						if(areaPrices.compareTo(BigDecimal.ZERO)>0) {
							basicAmount=basicAmount.add(area.multiply(areaPrices));
						}
					}
				}
				__logger.info("basicAmount+++++++++++++++++++++++"+basicAmount);
				basicAmountItem.setValue(basicAmount);
				//基准金额与小计总额差
				BigDecimal differValue=basicAmount.subtract(alltotalPrice);
				//不含税合计金额
				BigDecimal finalAmount=BigDecimal.ZERO;
				//含税合计金额
				BigDecimal taxFinalAmount=BigDecimal.ZERO;
				//税率
				BigDecimal taxAmount=BaseHelpUtils.getBigDecimalValue(taxAmountItem.getValue());
				if(taxAmount.compareTo(BigDecimal.ZERO)>0) {
					taxAmount=taxAmount.divide(BigDecimal.valueOf(100));
				}
				//采买税率
				BigDecimal otherTaxAmount=BaseHelpUtils.getBigDecimalValue(otherTaxAmountItem.getValue());
				if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {
					otherTaxAmount=otherTaxAmount.divide(BigDecimal.valueOf(100));
				}
				//设计上税金额
				BigDecimal getTaxAmount=BigDecimal.ZERO;
				//采买上税金额
				BigDecimal getOtherTaxAmount=BigDecimal.ZERO;

				//获取特殊折扣金额
				BigDecimal specialDiscountAmount=BaseHelpUtils.getBigDecimalValue(specialDiscountAmountItem.getValue());
				//特殊折扣系数
				BigDecimal specialDiscountPercent=specialDiscountAmount.divide(basicAmount,2,RoundingMode.DOWN);//特殊折扣系数=特殊折扣/基准总价
				specialDiscountPercentItem.setValue(specialDiscountPercent);
				//最终优惠系数=优惠系数+特殊折扣系数
				BigDecimal finalPercent=BigDecimal.ZERO;

				//获取采买合计金额
				BigDecimal ALLBuyPrice=BigDecimal.ZERO;
				//获取设计合计金额
				BigDecimal DesignPrice=BigDecimal.ZERO;  
				Record[] recordgrid=grid.getRecords();
				for (Record record : recordgrid) {
					String designTypeName=BaseHelpUtils.getString(record.getAttribute("designTypeName"));
					if(designTypeName.contains("采买")) {
						ALLBuyPrice=BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalPrice")).add(ALLBuyPrice);
					}else {
						DesignPrice=BaseHelpUtils.getBigDecimalValue(record.getAttribute("totalPrice")).add(DesignPrice);
					}
				}
				ALLBuyPriceItem.setValue(ALLBuyPrice);
				DesignPriceItem.setValue(DesignPrice);
				//设计上税金额为
				getTaxAmount=DesignPrice.multiply(taxAmount);
				getTaxAmountItem.setValue(getTaxAmount);
				if(differValue.compareTo(BigDecimal.ZERO)<0) {//如果系数为负数，说明基准<小计,则有上浮金额 ,合计=小计-特殊折扣额    
					perferentialPercentItem.clearValue();
					preferentialAmountItem.clearValue();
					finalPercentItem.clearValue();
					upAmountItem.setValue(differValue.negate());
					BigDecimal upPercent=differValue.negate().divide(basicAmount,2,RoundingMode.HALF_DOWN);
					upPercentItem.setValue(upPercent);
					//不含税合计金额
					finalAmount=alltotalPrice.subtract(specialDiscountAmount);
					finalAmountItem.setValue(finalAmount);

					if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {//如果存在采买税率
						//采买上税金额
						getOtherTaxAmount=ALLBuyPrice.multiply(otherTaxAmount);
						getOtherTaxAmountItem.setValue(getOtherTaxAmount);
						//含税合计金额为
						taxFinalAmount=finalAmount.add(getTaxAmount).add(getOtherTaxAmount);

						taxFinalAmountItem.setValue(taxFinalAmount);
					}else {//若不存在采买税率
						taxFinalAmount=finalAmount.add(getTaxAmount);
						taxFinalAmountItem.setValue(taxFinalAmount);
					}
				}else if(differValue.compareTo(BigDecimal.ZERO)>0) {//如果系数为正数，说明基准>小计,则有优惠金额 , 合计=基准-优惠-特殊折扣
					upAmountItem.clearValue();
					upPercentItem.clearValue();
					finalPercentItem.clearValue();
					//不含税合计金额
					finalAmount=basicAmount.subtract(differValue).subtract(specialDiscountAmount);//合计=基准-优惠-特殊折扣
					finalAmountItem.setValue(finalAmount);


					//优惠系数
					BigDecimal perferentialPercent=differValue.divide(basicAmount,2,RoundingMode.HALF_DOWN);
					preferentialAmountItem.setValue(differValue);//如果系数为正数，则有优惠金额
					perferentialPercentItem.setValue(perferentialPercent);

					//最终优惠系数=优惠系数+特殊折扣系数
					finalPercent=perferentialPercent.add(specialDiscountPercent);
					finalPercentItem.setValue(finalPercent);



					if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {//如果存在采买税率
						//采买上税金额
						getOtherTaxAmount=ALLBuyPrice.multiply(otherTaxAmount);
						getOtherTaxAmountItem.setValue(getOtherTaxAmount);
						//含税合计金额为
						taxFinalAmount=finalAmount.add(getTaxAmount).add(getOtherTaxAmount);

						taxFinalAmountItem.setValue(taxFinalAmount);
					}else {//若不存在采买税率

						taxFinalAmount=finalAmount.add(getTaxAmount);
						taxFinalAmountItem.setValue(taxFinalAmount);
					}
				}else if(differValue.compareTo(BigDecimal.ZERO)==0) {
					upAmountItem.clearValue();
					upPercentItem.clearValue();
					finalPercentItem.clearValue();
					perferentialPercentItem.clearValue();
					preferentialAmountItem.clearValue();

					finalAmountItem.setValue(alltotalPrice);
					if(otherTaxAmount.compareTo(BigDecimal.ZERO)>0) {//如果存在采买税率
						//采买上税金额
						getOtherTaxAmount=ALLBuyPrice.multiply(otherTaxAmount);
						getOtherTaxAmountItem.setValue(getOtherTaxAmount);
						//含税合计金额为
						taxFinalAmount=finalAmount.add(getTaxAmount).add(getOtherTaxAmount);

						taxFinalAmountItem.setValue(taxFinalAmount);
					}else {//若不存在采买税率
						taxFinalAmount=finalAmount.add(getTaxAmount);
						taxFinalAmountItem.setValue(taxFinalAmount);
					}
				}

			}
		});
		formLayout.addMember(grid);

		topLayout=new HLayout();
		topLayout.setWidth("100%");
		topLayout.setHeight("35%");
		mainLayout.addMember(topLayout);

		topLeftLayout=new HLayout();
		topLeftLayout.setHeight100();
		topLeftLayout.setWidth("40%");
		topLayout.addMember(topLeftLayout);

		topRightLayout=new HLayout();
		topRightLayout.setHeight100();
		topRightLayout.setWidth("60%");
		topLayout.addMember(topRightLayout);





		topRightLayout.addMember(topRightForm);

		remarkItem=new TextAreaItem("remark","备注:");
		remarkItem.setLength(500);
		remarkItem.setWidth("*");

		topLeftForm = new DynamicForm();
		topLeftForm.setAlign(Alignment.LEFT);
		topLeftForm.setPadding(15);
		topLeftForm.setMargin(2);
		topLeftForm.setWidth100();
		topLeftForm.setHeight("100%");
		topLeftForm.setItems(remarkItem);
		topLeftLayout.addMember(topLeftForm);

		btnLayout = new HLayout();
		btnLayout.setWidth100();
		btnLayout.setHeight("10%");
		btnLayout.setMembersMargin(10);
		btnLayout.setAlign(Alignment.RIGHT);

		okBtn = new IButton("提交审核");
		okBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record[] records=grid.getRecords();
				Record formRecord=form.getValuesAsRecord();
				Record topLeftFormRecord=topLeftForm.getValuesAsRecord();
				Record topRightFormRecord=topRightForm.getValuesAsRecord();
				NewProcessWindow panel=new NewProcessWindow();
				panel.setTitle("项目报价流程");
				Record record=new Record();
				record.setAttribute("info", records);
				record.setAttribute("formRecord", formRecord);
				record.setAttribute("topLeftFormRecord", topLeftFormRecord);
				record.setAttribute("topRightFormRecord", topRightFormRecord);
				panel.setProcessId(ClientUtil.checkAndGetIntValue(gerProcessId("On_Project_Quote_Template")));
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						getParentWindow().destroy();
					}
				});
				panel.setData(record);
				panel.setLayoutMode(0);
				panel.initComponents();
				panel.setWidth("100%");
				panel.setHeight("100%");
				panel.centerInPage();
				panel.show();
			}
		});

		cleanBtn = new IButton("关闭");
		cleanBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getParentWindow().destroy();
			}
		});

		btnLayout.addMember(okBtn);
		btnLayout.addMember(cleanBtn);
		mainLayout.addMember(btnLayout);
		addMember(mainLayout);
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

	public Window getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	private Record recordData;

	public Record getRecordData() {
		return recordData;
	}

	public void setRecordData(Record recordData) {
		this.recordData = recordData;
	}

	public void lodaData() {
		topRightForm.clearValues();
		topLeftForm.clearValues();
		otherTaxAmountItem.hide();
		getOtherTaxAmountItem.hide();
		ALLBuyPriceItem.hide();
		//获取业态ID
		int projectType=BaseHelpUtils.getIntValue(recordData.getAttribute("projectType"));
		//获取模板父级表主键
		int  projectQuoteTemplatesParentId=BaseHelpUtils.getIntValue(projectQuoteTemplatesParentIdItem.getValue());
		Map<String,Object> map=new HashMap<>();
		map.put("businessType", projectType);
		map.put("projectQuoteTemplatesParentId", projectQuoteTemplatesParentId);
		map.put("addtionalCondition", "order by design_type_name desc,project_quote_template_id");
		DBDataSource.callOperation("ST_ProjectQuoteTemplate", "find",map, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0) {
					Record[] records=dsResponse.getData();
					grid.setData(records);
					String designTypeName="";
					for (Record record : records) {
						designTypeName=BaseHelpUtils.getString(record.getAttribute("designTypeName"));
						if(designTypeName.contains("采买")) {
							otherTaxAmountItem.show();
							getOtherTaxAmountItem.show();
							ALLBuyPriceItem.show();
							break;
						}else {
							otherTaxAmountItem.hide();
							getOtherTaxAmountItem.hide();
							ALLBuyPriceItem.hide();
						}
					}
					for (Record record : records) {//用到两个循环，第二个循环遍历取出税率，因第一个循环需要break，无法合并
						designTypeName=BaseHelpUtils.getString(record.getAttribute("designTypeName"));
						if(designTypeName.contains("采买")) {
							BigDecimal buyTax=BaseHelpUtils.getBigDecimalValue(record.getAttribute("tax"));
							if(buyTax.compareTo(BigDecimal.ZERO)>0) {
								otherTaxAmountItem.setValue(buyTax);
							}
						}else {
							BigDecimal tax=BaseHelpUtils.getBigDecimalValue(record.getAttribute("tax"));
							if(tax.compareTo(BigDecimal.ZERO)>0) {
								taxAmountItem.setValue(tax); 
							}
						}
					}
				}
			}
		});
	}

	//获取流程ID
	public String gerProcessId(String workName) {
		String processId = "";
		Storage sta = Storage.getLocalStorageIfSupported();
							String str = sta.getItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
		if(!PomPlatformClientUtil.isNullOrEmpty(str)){
			String[] arr = str.split(",");
			for(String tempStr : arr){
				String[] tempArr = tempStr.split(":");
				//获取父级ID
				if(tempArr[0].replaceAll("\"", "").equals(workName)){
					processId = tempArr[1];
				}
			}
		}
		return processId;
	}

}
