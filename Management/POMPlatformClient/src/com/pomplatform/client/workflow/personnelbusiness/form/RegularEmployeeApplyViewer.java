package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSRegularEmployeeApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class RegularEmployeeApplyViewer extends AbstractDetailViewer
{

	/**
	 * 转正员工
	 */
	private String processName_1 = "转正员工";
	/**
	 * 部门经理
	 */
	private String processName_2 = "部门经理";
	/**
	 * 人事经理
	 */
	private String processName_3 = "人事经理";
	/**
	 * 部门分管领导
	 */
	private String processName_4 = "部门分管领导";
	/**
	 * 人资部
	 */
	private String processName_5 = "人资部";
	/**
	 * 薪酬专员
	 */
	private String processName_6 = "薪酬专员";
	/**
	 * 招聘专员
	 */
	private String processName_7 = "招聘专员";
	/**
	 * 行政人事助理
	 */
	private String processName_8 = "行政人事助理";
	/**
	 * 组织发展专员
	 */
	private String processName_9 = "组织发展专员";
	private VLayout mainLayout;
	private RegularEmployeeApplyUpdateForm form;
	private SearchForm __parentSearchForm;


	public RegularEmployeeApplyViewer() {
	}

	@Override
	public void initComponents() {
		setWidth100();
		setHeight100();
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		
		form = new RegularEmployeeApplyUpdateForm();
		form.setWidth100();
		form.setHeight100();
		form.setProcessName(processName);
		mainLayout.addMember(form);
		
		addMember(mainLayout);
	}
	
	@Override
	public void viewRecord(Record r, boolean includeDetail) {
		//Record不为空
		if(r.toMap().toString().length() > 2){
			form.setRecord(r);
			form.startEdit();
			FormItem[] items = form.getFormItemArray();
			for (FormItem item : items) {
				item.setDisabled(false);
				item.setCanEdit(false);
			}
		}
	}

	@Override
	public int getHorizontalPercent() {
		return 0;
	}

	@Override
	public String getName() {
		return "转正申请";
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
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_RegularEmployeeApply", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					for(DetailViewer v : detailViewers){
						v.setData(dsResponse.getData());
						if(dsResponse.getData().length == 0) continue;
						v.selectRecord(0);
						v.redraw();
					}
					setRecord(dsResponse.getData()[0]);
					viewDetailData();
				}
			}
		});
	}

	@Override
	public void viewSelectedData(ListGrid grid){
		super.viewSelectedData(grid);
		setRecord(grid.getSelectedRecord());
		viewDetailData();
	}

	public void viewDetailData(){
	}

	@Override
	public DataSource getMainDataSource() {
		return DSRegularEmployeeApply.getInstance();
	}

	@Override
	public int getDetailCount(){
		return 0;
	}

	@Override
	public List<ListGrid> getDetailListGrids() {
		List<ListGrid> res = new ArrayList<ListGrid>();
		return res;
	}

	@Override
	public List<String> getDetailNames() {
		List<String> res = new ArrayList<String>();
		return res;
	}

	public SearchForm getParentSearchForm() {
		return this.__parentSearchForm;
	}

	public void setParentSearchForm( SearchForm value ) {
		this.__parentSearchForm = value;
	}

	private String processName;
	
	public String getProcessName() {
		return processName;
	}
	
	public void setProcessName(String processName) {
		this.processName = processName;
	}

}

