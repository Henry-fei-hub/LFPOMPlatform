package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionInformation;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation1;

public class SpecialDeductionInformationNewForm extends AbstractWizadPage
{


	private final TextItem employeIdItem;
	private final TextItem plateIdItem;
	private final TextItem deparmentIdItem;
	private final TextItem companyIdItem;
	private final SelectItem yearItem;
	
	private Date currYearLast =new Date();
	private Date currYearFirst=new Date();
	private Date currDate=new Date();
	private int year =0;
	private int curYear =0;
	
	private SpecialDeductionInformation1  specialDeductionInformation1 =new SpecialDeductionInformation1();
	
	public static DateTimeFormat __DF = DateTimeFormat.getFormat("yyyy-MM-dd");
	public static DateTimeFormat __DF_y = DateTimeFormat.getFormat("yyyy");
	public static DateTimeFormat __DF_m = DateTimeFormat.getFormat("MM");
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	
	public SpecialDeductionInformationNewForm() {
		DSSpecialDeductionInformation ds = DSSpecialDeductionInformation.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		employeIdItem = new TextItem("employeId", "纳税申请人");
		employeIdItem.setCanEdit(false);
		employeIdItem.setRequired(true);
		IsIntegerValidator employeIdValidator = new IsIntegerValidator();
		employeIdItem.setValidators(employeIdValidator);
		employeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		employeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeIdItem);
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.setCanEdit(false);
		companyIdItem.setDefaultValue(ClientUtil.getCompanyId());
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		__formItems.add(companyIdItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setCanEdit(false);
		plateIdItem.setDefaultValue(ClientUtil.getPlateId());
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		__formItems.add(plateIdItem);
		deparmentIdItem = new TextItem("deparmentId", "归属部门");
		deparmentIdItem.setCanEdit(false);
		deparmentIdItem.setDefaultValue(ClientUtil.getDepartmentId());
		deparmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		__formItems.add(deparmentIdItem);
		
		year= currDate.getYear()+1900;
		curYear=year;
		
		yearItem = new SelectItem("employeeName", shouldNotBeNull+"扣除年度");
		yearItem.setDefaultValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				year = BaseHelpUtils.getIntValue(event.getValue());
				if(year>curYear) {
					currYearFirst= __DF.parse(year+"-01-01");
					currYearLast = __DF.parse(year+"-12-31");
				}else if(year==curYear) {
					int month = currDate.getMonth()+1;
					currYearFirst= __DF.parse(year+"-"+month+"-01");
					currYearLast = __DF.parse(year+"-12-31");
				}else {
					currYearFirst= __DF.parse(year+"-01-01");
					currYearLast = __DF.parse(year+"-12-31");
				}
				
				DelicacyListGrid grid = specialDeductionInformation1.getGrid();
				grid.getField(1).setDefaultValue(currYearFirst);
				grid.getField(2).setDefaultValue(currYearLast);
				specialDeductionInformation1.setCurrYearFirst(currYearFirst);
				specialDeductionInformation1.setCurrYearLast(currYearLast);
				ListGridRecord[] records = grid.getRecords();
				if(null!=records &&records.length>0) {
					for (ListGridRecord listGridRecord : records) {
						listGridRecord.setAttribute("startDate", currYearFirst);
						listGridRecord.setAttribute("endDate", currYearLast);
					}
					specialDeductionInformation1.getGrid().redraw();
				}
			}
		});
		__formItems.add(yearItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(10);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSpecialDeductionInformation.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
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

	public SpecialDeductionInformation1 getSpecialDeductionInformation1() {
		return specialDeductionInformation1;
	}

	public void setSpecialDeductionInformation1(SpecialDeductionInformation1 specialDeductionInformation1) {
		this.specialDeductionInformation1 = specialDeductionInformation1;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCurYear() {
		return curYear;
	}

	public void setCurYear(int curYear) {
		this.curYear = curYear;
	}

	

	
}
