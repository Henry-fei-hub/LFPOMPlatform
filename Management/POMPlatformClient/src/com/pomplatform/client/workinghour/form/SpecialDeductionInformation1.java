package com.pomplatform.client.workinghour.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.specialdeduction.datasource.DSSspecialdeductiondetailor;
import com.pomplatform.client.workinghour.datasource.DSWorkingHourManageRecord;
import com.smartgwt.client.data.*;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.ChangedEvent;
import com.smartgwt.client.widgets.grid.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

public class SpecialDeductionInformation1 extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DelicacyListGrid grid = new DelicacyListGrid();
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public SpecialDeductionInformation1(){
		
		HLayout employeeEducationInformations = new HLayout();
		employeeEducationInformations.setWidth100();
		employeeEducationInformations.setHeight100();
		ListGridField[] fields = new ListGridField[4];
		int idx = 0;
		fields[idx] = new ListGridField("projectCode");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("projectName");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("workHour");
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		fields[idx] = new ListGridField("workDate");
		fields[idx].setRequired(true);
		fields[idx].setShowGridSummary(false);
		fields[idx].setHidden(true);
		idx++;
		grid.setCanEdit(true);
		grid.setCanRemoveRecords(true);
		grid.setDataSource(DSWorkingHourManageRecord.getInstance());
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


	public void load(){
		Map condition = new HashMap();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();



	}

	@Override
	public boolean checkData() {

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


	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}













	

}

