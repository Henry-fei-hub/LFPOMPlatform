package com.pomplatform.client.client.workflow.specialdeduction.form;

import java.util.*;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionDetail;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionRecordWithS;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductiondetailor;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation1;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation2;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation3;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation4;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation5;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation6;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeOnboardInformation;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeDetailEmployeeEducationInformation;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeDetailEmployeeFamilyInformation;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeDetailEmployeeRewardExperience;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeDetailEmployeeTechnicalTitle;
import com.pomplatform.client.workflow.personnelbusiness.form.EmployeeDetailEmployeeWorkExperience;

public class SpecialDeductionRecordWithSDetailSpecialDeductionDetail2 extends AbstractWizadPage
{
	private HLayout allLayout;
	private VLayout leftLayout;
	private VLayout rightLayout;
	private VLayout contactLayout;
	private VLayout gridLayout;
	private SpecialDeductionInformation1 specialDeductionInformation1;
	private SpecialDeductionInformation2 specialDeductionInformation2;
	private SpecialDeductionInformation3 specialDeductionInformation3;
	private SpecialDeductionInformation4 specialDeductionInformation4;
	private SpecialDeductionInformation5 specialDeductionInformation5;
	private SpecialDeductionInformation6 specialDeductionInformation6;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	private static final Logger logger = Logger.getLogger("");

	public SpecialDeductionRecordWithSDetailSpecialDeductionDetail2() {
		DSSspecialdeductiondetailor ds = DSSspecialdeductiondetailor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		allLayout = new HLayout(10);
		allLayout.setWidth100();
		allLayout.setHeight100();

		specialDeductionInformation1 = new SpecialDeductionInformation1();
		specialDeductionInformation2 = new SpecialDeductionInformation2();
		specialDeductionInformation3 = new SpecialDeductionInformation3();
		leftLayout = new VLayout(10);
		leftLayout.setHeight100();
		leftLayout.setWidth("50%");
		leftLayout.addMember(specialDeductionInformation1);
		leftLayout.addMember(specialDeductionInformation2);
		leftLayout.addMember(specialDeductionInformation3);
		allLayout.addMember(leftLayout);
		
		
		specialDeductionInformation4 = new SpecialDeductionInformation4();
		specialDeductionInformation5 = new SpecialDeductionInformation5();
		specialDeductionInformation6 = new SpecialDeductionInformation6();
		rightLayout = new VLayout(10);
		rightLayout.setHeight100();
		rightLayout.setWidth("50%");
		rightLayout.addMember(specialDeductionInformation4);
		rightLayout.addMember(specialDeductionInformation5);
		rightLayout.addMember(specialDeductionInformation6);
		allLayout.addMember(rightLayout);
		
		addMember(allLayout);
		
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) {
			__form.editRecord(getRecord());
			specialDeductionInformation1.startEdit();
			specialDeductionInformation2.startEdit();
			specialDeductionInformation3.startEdit();
			specialDeductionInformation4.startEdit();
			specialDeductionInformation5.startEdit();
			specialDeductionInformation6.startEdit();
		}
		else {
			__form.editNewRecord();
		}
	}

	@Override
	public boolean checkData() {
		if(!__form.validate()){
			SC.say("请按系统提示修改信息");
			return false;
		}
		if(!specialDeductionInformation1.checkData()) {
			return false;
		}
		if(!specialDeductionInformation2.checkData()) {
			return false;
		}
		if(!specialDeductionInformation3.checkData()) {
			return false;
		}
		if(!specialDeductionInformation4.checkData()) {
			return false;
		}
		if(!specialDeductionInformation5.checkData()) {
			return false;
		}
		if(!specialDeductionInformation6.checkData()) {
			return false;
		}
		
		
		return true;
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSpecialDeductionRecordWithS.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		
		Map valuesAsMap1 = specialDeductionInformation1.getValuesAsMap();
		Map valuesAsMap2 = specialDeductionInformation2.getValuesAsMap();
		Map valuesAsMap3 = specialDeductionInformation3.getValuesAsMap();
		Map valuesAsMap4 = specialDeductionInformation4.getValuesAsMap();
		Map valuesAsMap5 = specialDeductionInformation5.getValuesAsMap();
		Map valuesAsMap6 = specialDeductionInformation6.getValuesAsMap();
		
		List<Map> list =new  ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap1)&&valuesAsMap1.size()>0) {
			List<Map> map1 =(List<Map>) valuesAsMap1.get("specialDeductionInformation1");
			list.addAll(map1);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap2)&&valuesAsMap2.size()>0) {
			List<Map> map2 =(List<Map>) valuesAsMap2.get("specialDeductionInformation2");
			list.addAll(map2);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap3)&&valuesAsMap3.size()>0) {
			List<Map> map3 =(List<Map>) valuesAsMap3.get("specialDeductionInformation3");
			list.addAll(map3);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap4)&&valuesAsMap4.size()>0) {
			List<Map> map4 =(List<Map>) valuesAsMap4.get("specialDeductionInformation4");
			list.addAll(map4);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap5)&&valuesAsMap5.size()>0) {
			List<Map> map5 =(List<Map>) valuesAsMap5.get("specialDeductionInformation5");
			list.addAll(map5);
		}
		if(!BaseHelpUtils.isNullOrEmpty(valuesAsMap6)&&valuesAsMap6.size()>0) {
			List<Map> map6 =(List<Map>) valuesAsMap6.get("specialDeductionInformation6");
			list.addAll(map6);
		}
		values.put("detailSpecialDeductionDetail", list);
		return values;
	}


}

