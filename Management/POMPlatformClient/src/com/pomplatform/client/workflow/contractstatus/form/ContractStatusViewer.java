package com.pomplatform.client.workflow.contractstatus.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.workflow.contractstatus.datasource.DSContractStatus;
import com.pomplatform.client.workflow.personnelbusiness.form.LeaveApplyUpdateForm2;
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

public class ContractStatusViewer extends AbstractDetailViewer
{

	private VLayout mainLayout;
	private ContractStatusUpdateForm form;
	private SearchForm __parentSearchForm;


	public ContractStatusViewer() {
	}

	@Override
	public void initComponents() {
//		super.initComponents();
		setWidth100();
		setHeight100();
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		
		form = new ContractStatusUpdateForm();
		form.setWidth100();
		form.setHeight100();
		mainLayout.addMember(form);
		
		addMember(mainLayout);
	}

	@Override
	public void viewRecord(Record r, boolean includeDetail) {
		form.setRecord(r);
		form.startEdit();
		form.getAttachmentItem().hide();
		FormItem[] items = form.getFormItemArray();
		for(FormItem item : items){
			if(!item.getName().equals("viewProjects")) {
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
		return "合同状态";
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
		params.put("contractLogId", getBusinessId());
		DBDataSource.callOperation("NQ_ContractStatus", "find", new DSCallback() {
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
		return DSContractStatus.getInstance();
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


}

