package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.selectgridemployeevalue.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSCheckWorkHandover;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class WorkHandoverPanel extends AbstractWizadPage{

	private HLayout contentLayout;
	private VLayout controlLayout;
	private DelicacyListGrid grid;
	private Integer businessId;
	private Integer employeeId;
	private int type;
	private StringBuilder deleteIds = new StringBuilder();

	public WorkHandoverPanel(int type) {
		this.type = type;
		setWidth100();
		setHeight100();
		contentLayout = new HLayout();
		contentLayout.setWidth100();
		contentLayout.setHeight100();
		
		ListGridField[] fields = new ListGridField[5];
		int idx = 0;
		fields[idx] = new ListGridField("type", "工作交接类型");
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(type);
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("name", "名称");
		fields[idx].setWidth("10%");
		idx++;
		fields[idx] = new ListGridField("content", "主要内容");
		fields[idx].setWidth("50%");
		idx++;
		fields[idx] = new ListGridField("fromEmployeeId", "交接者");
		fields[idx].setWidth("10%");
		fields[idx].setCanEdit(false);
		fields[idx].setDefaultValue(employeeId);
		idx++;
		fields[idx] = new ListGridField("toEmployeeId", "被交接者");
		fields[idx].setWidth("20%");
		ListGridField eNoField = new ListGridField("employeeNo");
		ListGridField eNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		Criteria c = new Criteria();
		c.addCriteria("status", 0);
		ComboBoxItem employeeIdItem = new ComboBoxItem("toEmployeeId");
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
		employeeIdItem.setPickListWidth(350);
		employeeIdItem.setOptionCriteria(c);
		employeeIdItem.setValueField("employeeId");
		employeeIdItem.setDisplayField("employeeName");
		employeeIdItem.setPickListFields(eNoField, eNameField, departmentIdField);
		fields[idx].setEditorProperties(employeeIdItem);
		grid = new DelicacyListGrid();
		grid.setAutoFitFieldWidths(false);
		grid.setDataSource(DSCheckWorkHandover.getInstance());
		grid.setCanEdit(true);
		grid.setFields(fields);
		
		controlLayout = new VLayout();
		controlLayout.setWidth("7%");
		controlLayout.setBackgroundColor("#F0F0F0");
		controlLayout.setMembersMargin(20);
		controlLayout.setLayoutLeftMargin(10);
		controlLayout.setLayoutRightMargin(10);
		controlLayout.setLayoutTopMargin(20);
		controlLayout.setBorder("1px solid #ABABAB");
		IButton newButton = new IButton("新建");
		newButton.setWidth100();
		newButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(grid.getRecords().length < 11){
					Record r = new Record();
					r.setAttribute("type", type);
					r.setAttribute("fromEmployeeId", employeeId);
					grid.startEditingNew(r);
				}else{
					SC.say("对不起，最多只能填写11项工作交接");
				}
			}
		});
		controlLayout.addMember(newButton);
		
		IButton deleteButton = new IButton("删除");
		deleteButton.setWidth100();
		deleteButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if(!grid.anySelected()){
							SC.say("请选择需要删除的纪录");
							return;
						}
						Record[] records = grid.getSelectedRecords();
						for(Record record : records){
							if(record.getAttribute("workHandoverId") != null){
								if(deleteIds.length() > 0){
									deleteIds.append(",");
								}
								deleteIds.append(record.getAttribute("workHandoverId"));
							}
							grid.removeData(record);
						}
					}
					
					@Override
					public void onFailure(Throwable reason) {
						SC.say("fail to download");
					}
				});
			}
		});
		controlLayout.addMember(deleteButton);
		contentLayout.addMembers(grid, controlLayout);
		
		addMembers(contentLayout);
	}
	
	@Override
	public Map getValuesAsMap() {
		Map map = new HashMap<>();
		MapUtils.convertRecordToMap(grid.getDataSource(), grid.getRecords(), map,
				"list");
		map.put("deleteIds", deleteIds.toString());
		return map;
	}

	@Override
	public boolean checkData() {
		Record[] records = grid.getRecords();
		if(null != records && records.length > 0){
			return true;
		}
		SC.say("请填写工作交接内容");
		return false;
	}

	@Override
	public void startEdit() {
		if(null != businessId){
			Map<String, Object> params = new HashMap<>();
			params.put("optType", "getWorkhandovers");
			params.put("type", type);
			params.put("businessId", businessId);
			DBDataSource.callOperation("EP_MyPersonnelProcessor", params, new DSCallback() {
				@Override
				public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
					if(dsResponse.getStatus() >= 0){
						Record[] records = dsResponse.getData();
						grid.setData(records);
						grid.redraw();
					}else{
						ClientUtil.displayErrorMessage(dsResponse);
					}
				}
			});
		}
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
}
