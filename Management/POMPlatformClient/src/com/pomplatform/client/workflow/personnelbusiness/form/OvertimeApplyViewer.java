package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.GroupColumn;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSOvertimeApply;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class OvertimeApplyViewer extends AbstractDetailViewer
{

	private VLayout mainLayout;
	private VLayout warning;
	private OvertimeApplyUpdateForm form;
	private static final Logger logger = Logger.getLogger("");
	public OvertimeApplyViewer() {
	}

	@Override
	public void initComponents() {
		setWidth100();
		setHeight100();
		mainLayout = new VLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();
		mainLayout.setBackgroundColor("#fff");
		
		form = new OvertimeApplyUpdateForm();
		form.setWidth100();
		form.setHeight("90%");
		mainLayout.addMember(form);
		
		int width = (form.getWidth()-30)/23*10;
		warning = new VLayout();
		warning.setWidth100();
		warning.setHeight("10%");
		warning.setLayoutLeftMargin(width * 3 / 10 + 10);
		mainLayout.addMember(warning);
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
		return "加班申请";
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
		DBDataSource.callOperation("NQ_OvertimeApply", "find", new DSCallback() {
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
		return DSOvertimeApply.getInstance();
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


}

