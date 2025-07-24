package com.pomplatform.client.specialdeduction.datasource;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.client.workflow.specialdeduction.form.SpecialDeductionInformationNewForm;
import com.pomplatform.client.specialdeduction.form.SspecialdeductiontypessorViewer;
import com.pomplatform.client.specialdeduction.panel.SspecialdeductiontypessorPanel;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeEducationInformation;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SpecialDeductionInformation1 extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid = new DelicacyListGrid();
	private int parentId;
	private Date currYearLast =new Date();
	private Date currYearFirst=new Date();
	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static DateTimeFormat __DF_y = DateTimeFormat.getFormat("yyyy");
	public static DateTimeFormat __DF_m = DateTimeFormat.getFormat("MM");
	
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public SpecialDeductionInformation1(){
		
		String year = __DF_y.format(currYearFirst);
		String month = __DF_m.format(currYearFirst);
		currYearFirst= __DF.parse(year+"-"+month+"-01");
		currYearLast = __DF.parse(year+"-12-31");
		
		HLayout employeeEducationInformations = new HLayout();
		employeeEducationInformations.setWidth100();
		employeeEducationInformations.setHeight100();
		ListGridField[] fields = new ListGridField[18];
		int idx = 0;
		fields[idx] = new ListGridField("specialDeductionDetailId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("parentId");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("specialDeductionTypeId",shouldNotBeNull+"专项类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_223"));
		fields[idx].addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				int thisVal = BaseHelpUtils.getIntValue(event.getValue());
				SC.debugger();
				DynamicForm df = event.getItem().getForm();
				BigDecimal deductionPercentage =BigDecimal.ONE;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("deductionPercentage"))) {
					deductionPercentage = BaseHelpUtils.getBigDecimalValue(df.getField("deductionPercentage").getValue()).divide(new BigDecimal(100)).setScale(4);
				}
				if(deductionPercentage.compareTo(BigDecimal.ONE)>0) {
					deductionPercentage=BigDecimal.ONE;
				}
				if(thisVal == 1&&!BaseHelpUtils.isNullOrEmpty(df.getField("num"))){//子女教育
					int num = BaseHelpUtils.getIntValue(df.getField("num").getValue());
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(num)).multiply(new BigDecimal(1000)));
				}else if(thisVal == 2&&!BaseHelpUtils.isNullOrEmpty(df.getField("educationType"))) {//继续教育
					
					int educationType = BaseHelpUtils.getIntValue(df.getField("educationType").getValue());
					if(educationType==1) {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(300)));
					}else {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(400)));
					}
				}else if(thisVal == 3&&!BaseHelpUtils.isNullOrEmpty(df.getField("houseFirst"))) {//住房贷款利息
					int houseFirst = BaseHelpUtils.getIntValue(df.getField("houseFirst").getValue());
					if(houseFirst==1) {//是
						df.getField("amount").setValue(0);
					}else {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1000)));
					}
				}else if(thisVal == 4&&!BaseHelpUtils.isNullOrEmpty(df.getField("city"))) {//住房租金
					int city = BaseHelpUtils.getIntValue(df.getField("city").getValue());
					if(city==1||city==2) {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1500)));
					}else if(city==3){
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1000)));
					}else {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(800)));
					}
				}else if(thisVal == 5&&!BaseHelpUtils.isNullOrEmpty(df.getField("singleChild"))) {//赡养老人
					int singleChild = BaseHelpUtils.getIntValue(df.getField("singleChild").getValue());
					if(singleChild!=1) {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
					}else {
						if(deductionPercentage.compareTo(new BigDecimal(0.5))>=0) {
							df.getField("deductionPercentage").setValue(50);
							df.getField("amount").setValue(1000);
						}else {
							df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
						}
					}
					
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("startDate",shouldNotBeNull+"起始时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setDefaultValue(currYearFirst);
		idx++;
		fields[idx] = new ListGridField("endDate",shouldNotBeNull+"结束时间");
		fields[idx].setShowGridSummary(false);
		fields[idx].setDefaultValue(currYearLast);
		idx++;
		fields[idx] = new ListGridField("num","子女人数/老人人数");
		fields[idx].setShowGridSummary(false);
		fields[idx].addChangedHandler(new ChangedHandler() {
			
			@Override
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				DynamicForm df = event.getForm();
				int thisVal=99;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("specialDeductionTypeId"))) {
					 thisVal = BaseHelpUtils.getIntValue(df.getField("specialDeductionTypeId").getValue());
				}
				
				BigDecimal deductionPercentage =BigDecimal.ONE;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("deductionPercentage"))) {
					deductionPercentage = BaseHelpUtils.getBigDecimalValue(df.getField("deductionPercentage").getValue()).divide(new BigDecimal(100)).setScale(4);
				}
				
				if(deductionPercentage.compareTo(BigDecimal.ONE)>0) {
					deductionPercentage=BigDecimal.ONE;
				}
				if(thisVal == 1&&!BaseHelpUtils.isNullOrEmpty(df.getField("num"))) {//子女教育
					int num = BaseHelpUtils.getIntValue(df.getField("num").getValue());
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(num)).multiply(new BigDecimal(1000)));
				}else if(thisVal == 5&&!BaseHelpUtils.isNullOrEmpty(df.getField("singleChild"))){//赡养老人
					int singleChild = BaseHelpUtils.getIntValue(df.getField("singleChild").getValue());
					if(singleChild!=1) {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
					}else {
						if(deductionPercentage.compareTo(new BigDecimal(0.5))>=0) {
							df.getField("amount").setValue(1000);
						}else {
							df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
						}
					}
				}else {
					df.getField("num").setValue("");
					SC.say("提示","除子女教育或赡养老人专项外，此项非必填");
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("singleChild","是否独生子女");
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		fields[idx].addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				DynamicForm df = event.getItem().getForm();
				int thisVal=99;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("specialDeductionTypeId"))) {
					 thisVal = BaseHelpUtils.getIntValue(df.getField("specialDeductionTypeId").getValue());
				}
				if(thisVal != 5) {
					df.getField("singleChild").setValue("");
					SC.say("提示","除赡养老人专项外，此项非必填");
				}
				int singleChild = BaseHelpUtils.getIntValue(event.getValue());
				BigDecimal deductionPercentage =BigDecimal.ONE;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("deductionPercentage"))) {
					deductionPercentage = BaseHelpUtils.getBigDecimalValue(df.getField("deductionPercentage").getValue()).divide(new BigDecimal(100)).setScale(4);
				}
				if(deductionPercentage.compareTo(BigDecimal.ONE)>0) {
					deductionPercentage=BigDecimal.ONE;
				}
				if(singleChild!=1) {
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
				}else {
					if(deductionPercentage.compareTo(new BigDecimal(0.5))>=0) {
						df.getField("deductionPercentage").setValue(50);
						df.getField("amount").setValue(1000);
					}else {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
					}
				}
				
			
			}; 
		});
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("educationType","继续教育类型");
		fields[idx].setShowGridSummary(false);
		fields[idx].addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				DynamicForm df = event.getItem().getForm();
				int thisVal=99;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("specialDeductionTypeId"))) {
					 thisVal = BaseHelpUtils.getIntValue(df.getField("specialDeductionTypeId").getValue());
				}
				if(thisVal != 2) {
					df.getField("educationType").setValue("");
					SC.say("提示","除继续教育专项外，此项非必填");
				}
				int educationType = BaseHelpUtils.getIntValue(event.getValue());
				BigDecimal deductionPercentage =BigDecimal.ONE;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("deductionPercentage"))) {
					deductionPercentage = BaseHelpUtils.getBigDecimalValue(df.getField("deductionPercentage").getValue()).divide(new BigDecimal(100)).setScale(4);
				}
				if(deductionPercentage.compareTo(BigDecimal.ONE)>0) {
					deductionPercentage=BigDecimal.ONE;
				}
				if(educationType==1) {
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(300)));
				}else {
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(400)));
				}
				
			}; 
		});
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_221"));
		idx++;
		fields[idx] = new ListGridField("educationStage","教育阶段");
		fields[idx].setShowGridSummary(false);
		fields[idx].addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				DynamicForm df = event.getForm();
				int thisVal=99;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("specialDeductionTypeId"))) {
					 thisVal = BaseHelpUtils.getIntValue(df.getField("specialDeductionTypeId").getValue());
				}
				if(thisVal != 1) {
					df.getField("educationStage").setValue("");
					SC.say("提示","除子女教育专项外，此项非必填");
				}
			}; 
		});
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_218"));
		idx++;
		fields[idx] = new ListGridField("city","租房城市");
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_228"));
		fields[idx].addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				DynamicForm df = event.getItem().getForm();
				int thisVal=99;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("specialDeductionTypeId"))) {
					 thisVal = BaseHelpUtils.getIntValue(df.getField("specialDeductionTypeId").getValue());
				}
				if(thisVal != 4) {
					df.getField("city").setValue("");
					SC.say("提示","除住房租赁专项外，此项非必填");
				}
				int city = BaseHelpUtils.getIntValue(df.getField("city").getValue());
				BigDecimal deductionPercentage =BigDecimal.ONE;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("deductionPercentage"))) {
					deductionPercentage = BaseHelpUtils.getBigDecimalValue(df.getField("deductionPercentage").getValue()).divide(new BigDecimal(100)).setScale(4);
				}
				if(city==1||city==2) {
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1500)));
				}else if(city==3){
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1000)));
				}else {
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(800)));
				}
				
			}; 
		});
		idx++;
		fields[idx] = new ListGridField("houseFirst","是否首套房");
		fields[idx].addChangedHandler(new ChangedHandler() {
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				DynamicForm df = event.getItem().getForm();
				int thisVal=99;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("specialDeductionTypeId"))) {
					 thisVal = BaseHelpUtils.getIntValue(df.getField("specialDeductionTypeId").getValue());
				}
				if(thisVal != 3) {
					df.getField("houseFirst").setValue("");
					SC.say("提示","除贷房利息专项外，此项非必填");
				}
				int houseFirst = BaseHelpUtils.getIntValue(df.getField("houseFirst").getValue());
				BigDecimal deductionPercentage =BigDecimal.ONE;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("deductionPercentage"))) {
					deductionPercentage = BaseHelpUtils.getBigDecimalValue(df.getField("deductionPercentage").getValue()).divide(new BigDecimal(100)).setScale(4);
				}
				if(deductionPercentage.compareTo(BigDecimal.ONE)>0) {
					deductionPercentage=BigDecimal.ONE;
				}
				if(houseFirst==1) {//否
					df.getField("amount").setValue(0);
				}else {
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1000)));
				}
			}; 
		});
		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("deductionPercentage",shouldNotBeNull+"本人扣除比例（%）");
//		fields[idx].setValueMap(KeyValueManager.getValueMap("system_dictionary_224"));
		fields[idx].setFormat("##,###,##0.00");
		fields[idx].setDefaultValue(100);
		fields[idx].addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				SC.debugger();
				DynamicForm df = event.getItem().getForm();
				int thisVal=99;
				if(!BaseHelpUtils.isNullOrEmpty(df.getField("specialDeductionTypeId"))) {
					 thisVal = BaseHelpUtils.getIntValue(df.getField("specialDeductionTypeId").getValue());
				}
				BigDecimal deductionPercentage  = BaseHelpUtils.getBigDecimalValue(event.getValue()).divide(new BigDecimal(100)).setScale(4);
				if(deductionPercentage.compareTo(BigDecimal.ONE)>0) {
					deductionPercentage=BigDecimal.ONE;
				}
	
				if(thisVal == 1&&!BaseHelpUtils.isNullOrEmpty(df.getField("num"))){//子女教育
					int num = BaseHelpUtils.getIntValue(df.getField("num").getValue());
					df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(num)).multiply(new BigDecimal(1000)));
				}else if(thisVal == 2&&!BaseHelpUtils.isNullOrEmpty(df.getField("educationType"))) {//继续教育
					
					int educationType = BaseHelpUtils.getIntValue(df.getField("educationType").getValue());
					if(educationType==1) {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(300)));
					}else {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(400)));
					}
				}else if(thisVal == 3&&!BaseHelpUtils.isNullOrEmpty(df.getField("houseFirst"))) {//住房贷款利息
					int houseFirst = BaseHelpUtils.getIntValue(df.getField("houseFirst").getValue());
					if(houseFirst==1) {//是
						df.getField("amount").setValue(0);
					}else {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1000)));
					}
				}else if(thisVal == 4&&!BaseHelpUtils.isNullOrEmpty(df.getField("city"))) {//住房租金
					int city = BaseHelpUtils.getIntValue(df.getField("city").getValue());
					if(city==1||city==2) {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1500)));
					}else if(city==3){
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(1000)));
					}else {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(800)));
					}
				}else if(thisVal == 5&&!BaseHelpUtils.isNullOrEmpty(df.getField("singleChild"))) {//赡养老人
					int singleChild = BaseHelpUtils.getIntValue(df.getField("singleChild").getValue());
					if(singleChild!=1) {
						df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
					}else {
						if(deductionPercentage.compareTo(new BigDecimal(0.5))>=0) {
							df.getField("deductionPercentage").setValue(50);
							df.getField("amount").setValue(1000);
						}else {
							df.getField("amount").setValue(deductionPercentage.multiply(new BigDecimal(2000)));
						}
					}
				}
			}
		});
		fields[idx].setShowGridSummary(false);
		idx++;
		fields[idx] = new ListGridField("amount","扣除金额");
		fields[idx].setShowGridSummary(false);
		fields[idx].setCanEdit(false);
		grid.setCanEdit(true);
		grid.setCanRemoveRecords(true);
		grid.setDataSource(DSSspecialdeductiondetailor.getInstance());
		grid.setFields(fields);
		grid.setAutoFitFieldWidths(false);
		employeeEducationInformations.addMember(grid);
		VLayout employeeEducationInformationsControls = new VLayout();
		employeeEducationInformationsControls.setHeight100();
		employeeEducationInformationsControls.setWidth(60);
		employeeEducationInformationsControls.setLayoutTopMargin(30);
		employeeEducationInformationsControls.setLayoutLeftMargin(5);
		employeeEducationInformationsControls.setLayoutRightMargin(5);
		employeeEducationInformationsControls.setMembersMargin(10);
		employeeEducationInformations.addMember(employeeEducationInformationsControls);
		addMember(employeeEducationInformations);
		IButton refearshButton = new IButton("刷新");
		refearshButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.redraw();
			}
		});
		IButton employeeEducationInformationsNewButton = new IButton("新增");
		employeeEducationInformationsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		IButton employeeEducationInformationsRemoveButton = new IButton("删除所有");
		employeeEducationInformationsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		employeeEducationInformationsControls.addMember(refearshButton);
		employeeEducationInformationsControls.addMember(employeeEducationInformationsNewButton);
		employeeEducationInformationsControls.addMember(employeeEducationInformationsRemoveButton);
	}
	

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) {
			return;
		}else{
			reloadDetailTableData();
		}
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("parentId", getRecord().getAttribute("specialDeductionRecordId"));
		DBDataSource.callOperation("ST_SpecialDeductionDetail", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					grid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		boolean bool_1 =false;
		boolean bool_2 =false;
		boolean bool_3 =false;
		boolean bool_4 =false;
		boolean bool_5 =false;
		
		for(ListGridRecord r : grid.getRecords()) {
			if(null==r.getAttribute("specialDeductionTypeId")) {
				SC.say("提示","子项类型不能为空");
				return false;
			}
			if(null==r.getAttribute("deductionPercentage")) {
				SC.say("提示","扣除比例不能为空");
				return false;
			}
			
			if(null==r.getAttribute("startDate")) {
				SC.say("提示","当前开始时间不能为空");
				return false;
			}else if(r.getAttributeAsDate("startDate").compareTo(currYearFirst)<0) {
				SC.say("提示","当前开始时间不能小于"+__DF.format(currYearFirst));
				return false;
			}
			
			if(null==r.getAttribute("endDate")) {
				SC.say("提示","当前结束日期不能为空");
				return false;
			}else if(r.getAttributeAsDate("endDate").compareTo(currYearLast)>0) {
				SC.say("提示","当前结束日期不能超过申请"+__DF.format(currYearLast));
				return false;
			}
			
			if(r.getAttributeAsDate("startDate").after(r.getAttributeAsDate("endDate"))){
				SC.say("当前开始时间必须小于当前结束日期");
				return false;
			}
			int intValue = BaseHelpUtils.getIntValue(r.getAttribute("specialDeductionTypeId"));
			if(intValue==1) {//子女教育
				if(bool_1) {
					SC.say("子女教育不得申请多条");
					return false;
				}
				bool_1=true;
				int num = BaseHelpUtils.getIntValue(r.getAttribute("num"));
				if(num<=0) {
					SC.say("子女教育专项，子女人数不能为空");
					return false;
				}
//				String educationStage = r.getAttribute("educationStage");
//				if(BaseHelpUtils.isNullOrEmpty(educationStage)) {
//					SC.say("子女教育专项，教育类型不能为空");
//					return false;
//				}
			}else if(intValue==2) {//继续教育
				if(bool_2) {
					SC.say("继续教育不得申请多条");
					return false;
				}
				bool_2=true;
				String educationType = r.getAttribute("educationType");
				if(BaseHelpUtils.isNullOrEmpty(educationType)) {
					SC.say("继续教育专项，继续教育类型不能为空");
					return false;
				}
			}else if(intValue==3) {//住房贷款利息
				if(bool_3) {
					SC.say("住房贷款利息不得申请多条");
					return false;
				}
				bool_3=true;
				if(bool_4) {
					SC.say("住房贷款利息专项和住房租金专项互斥，请删除其一");
					return false;
				}
				String houseFirst = r.getAttribute("houseFirst");
				if(BaseHelpUtils.isNullOrEmpty(houseFirst)) {
					SC.say("住房贷款利息专项，是否首套房不能为空");
					return false;
				}
				
			}else if(intValue==4) {//住房租金
				if(bool_4) {
					SC.say("住房租金不得申请多条");
					return false;
				}
				bool_4=true;
				if(bool_3) {
					SC.say("住房贷款利息专项和住房租金专项互斥，请删除其一");
					return false;
				}
				String city = r.getAttribute("city");
				if(BaseHelpUtils.isNullOrEmpty(city)) {
					SC.say("住房租金专项，租房城市不能为空");
					return false;
				}
			}else if(intValue==5) {//赡养老人
				if(bool_5) {
					SC.say("赡养老人不得申请多条");
					return false;
				}
				bool_5=true;
				Object singleChild = r.getAttribute("singleChild");
				if(BaseHelpUtils.isNullOrEmpty(singleChild)) {
					SC.say("赡养老人专项，是否独生子女不能为空");
					return false;
				}
				BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(r.getAttribute("deductionPercentage"));
				if(BaseHelpUtils.getIntValue(singleChild)==1&&bigDecimalValue.compareTo(new BigDecimal(50))>0) {
					SC.say("赡养老人专项，非独生子女可填写扣除比例最高为50%");
				}
				int num = BaseHelpUtils.getIntValue(r.getAttribute("num"));
				if(BaseHelpUtils.isNullOrEmpty(singleChild)) {
					SC.say("赡养老人专项，老人人数不能为空");
					return false;
				}
			}else {
				SC.say("专项扣除类型异常");
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("SpecialDeductionInformation1");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		
		ListGridRecord[] rows = grid.getRecords();
		Map param = new HashMap();
		if(!BaseHelpUtils.isNullOrEmpty(rows) && rows.length > 0) {
			MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailSpecialDeductionDetail");
		}
		
		return param;
	}

	@Override
	public String getName() {
		return "专项扣除信息";
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public Date getCurrYearLast() {
		return currYearLast;
	}


	public void setCurrYearLast(Date currYearLast) {
		this.currYearLast = currYearLast;
	}


	public Date getCurrYearFirst() {
		return currYearFirst;
	}


	public void setCurrYearFirst(Date currYearFirst) {
		this.currYearFirst = currYearFirst;
	}
	
	

}

