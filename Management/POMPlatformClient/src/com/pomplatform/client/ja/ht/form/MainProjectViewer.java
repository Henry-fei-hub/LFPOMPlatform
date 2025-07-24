package com.pomplatform.client.ja.ht.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.ListGridFieldType;
import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.GenericViewWindow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.ja.ht.datasource.DSMainProject;

public class MainProjectViewer extends AbstractDetailViewer
{
	private final DelicacyListGrid employeeGrid = new DelicacyListGrid();
	private final DelicacyListGrid specialtyGrid = new DelicacyListGrid();
	//业务类别
	private final DelicacyListGrid serviceCategoryGrid = new DelicacyListGrid();
	//项目参与专业
	private final DelicacyListGrid stageGrid = new DelicacyListGrid();

	private SearchForm __parentSearchForm;


	public MainProjectViewer() {
	}

	@Override
	public void initComponents() {
		super.initComponents();
		
		employeeGrid.setAutoFitFieldWidths(false);
		employeeGrid.setShowGridSummary(true);
		int index = 0;
		ListGridField[] fields = new ListGridField[5];
		fields[index] = new ListGridField("mainProjectEmployeeId");
		fields[index].setHidden(true);
		index++;
		fields[index] = new ListGridField("relation","角色");
		fields[index].setValueMap(KeyValueManager.getValueMap("system_dictionary_158"));
		fields[index].setWidth("30%");
		index++;
		fields[index] = new ListGridField("employeeNo","职员编号");
		fields[index].setWidth("20%");
		index++;
		fields[index] = new ListGridField("employeeId","职员姓名");
		fields[index].setWidth("20%");
		fields[index].setValueMap(KeyValueManager.getValueMap("employees"));
		index++;
		fields[index] = new ListGridField("plateId","业务部门");
		fields[index].setWidth("30%");
		fields[index].setValueMap(KeyValueManager.getValueMap("plate_records"));		
		index++;
		fields[index] = new ListGridField("plateId","业务部门");
		fields[index].setWidth("30%");
		fields[index].setValueMap(KeyValueManager.getValueMap("plate_records"));		
		employeeGrid.setFields(fields);
		
		specialtyGrid.setAutoFitFieldWidths(false);
		specialtyGrid.setShowGridSummary(true);
		int b = 0;
		ListGridField[] bFields = new ListGridField[4];
		bFields[b] = new ListGridField("mainProjectSpecialtyId");
		bFields[b].setHidden(true);
		b++;
		bFields[b] = new ListGridField("specialtyId","参与专业");
		bFields[b].setWidth("33%");
		bFields[b].setCanEdit(false);
		KeyValueManager.loadValueMap("pm_specials",bFields[b]);
		b++;
		bFields[b] = new ListGridField("registrationSealEmployeeId","注册盖章人员");
		bFields[b].setWidth("33%");
		bFields[b].setCanEdit(false);
		KeyValueManager.loadValueMap("employees",bFields[b]);
		b++;
		bFields[b] = new ListGridField("isOutsourcing","是否外包");
		bFields[b].setType(ListGridFieldType.BOOLEAN);
		bFields[b].setWidth("33%");
		bFields[b].setCanEdit(false);
		specialtyGrid.setFields(bFields);

		serviceCategoryGrid.setAutoFitFieldWidths(false);
		serviceCategoryGrid.setShowGridSummary(false);
		int c = 0;
		ListGridField[] cFields = new ListGridField[3];
		cFields[c] = new ListGridField("mainProjectBusinessTypeId");
		cFields[c].setHidden(true);
		c++;
		cFields[c] = new ListGridField("mainProjectId");
		cFields[c].setHidden(true);
		c++;
		cFields[c] = new ListGridField("businessType", "业务类别");
		cFields[c].setHidden(false);
		cFields[c].setWidth("33%");
		cFields[c].setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		c++;
		cFields[c] = new ListGridField("area", "面积");
		cFields[c].setHidden(false);
		cFields[c].setWidth("33%");
		c++;
		cFields[c] = new ListGridField("outputValue", "产值");
		cFields[c].setHidden(false);
		cFields[c].setWidth("33%");
		c++;
		serviceCategoryGrid.setFields(cFields);

		stageGrid.setAutoFitFieldWidths(false);
		stageGrid.setShowGridSummary(false);
		int d = 0;
		ListGridField[] dFields = new ListGridField[3];
		dFields[d] = new ListGridField("projectStageId");
		dFields[d].setHidden(true);
		d++;
		dFields[d] = new ListGridField("mainProjectId");
		dFields[d].setHidden(true);
		d++;
		dFields[d] = new ListGridField("stageId", "项目阶段");
		dFields[d].setHidden(true);
		d++;
		dFields[d] = new ListGridField("stageName", "阶段名称");
		dFields[d].setWidth("33%");
		dFields[d].setHidden(false);

		d++;
		dFields[d] = new ListGridField("percent", "阶段比例");
		dFields[d].setHidden(false);
		dFields[d].setWidth("33%");
		d++;
		stageGrid.setFields(dFields);

	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "基本信息";
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public List<GroupColumn> getGroupColumnNames() {
		List<GroupColumn> gcs = new ArrayList<GroupColumn>();
		return gcs;
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		Record selected = grid.getSelectedRecord();
		Map<String,Object> params = new HashMap<>();
		int mainProjectId = BaseHelpUtils.getIntValue(selected.getAttribute("mainProjectId"));
		params.put("mainProjectId", mainProjectId);
		DBDataSource.callOperation("NQ_SearchMainProjectEmployeeData", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					employeeGrid.setData(dsResponse.getData());
				}
			}
		});
		
		
		DBDataSource.callOperation("ST_MainProjectSpecialty","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					specialtyGrid.setData(dsResponse.getData());
				}
			}
		});

		DBDataSource.callOperation("ST_MainProjectBusinessType","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					serviceCategoryGrid.setData(dsResponse.getData());
				}
			}
		});

		DBDataSource.callOperation("ST_ProjectStage","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					stageGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public DataSource getMainDataSource() {
		return DSMainProject.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 4;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		res.add(employeeGrid);
		res.add(specialtyGrid);
		res.add(serviceCategoryGrid);
		res.add(stageGrid);
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		res.add("项目相关人员");
		res.add("项目参与专业");
		res.add("项目业务类别");
		res.add("项目阶段");
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}


}

