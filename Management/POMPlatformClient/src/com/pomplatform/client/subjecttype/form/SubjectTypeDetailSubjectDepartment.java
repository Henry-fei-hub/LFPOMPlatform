package com.pomplatform.client.subjecttype.form;

import java.util.*;
import com.delicacy.client.MapUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.smartgwt.client.data.Criteria;
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
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;
import java.util.logging.Logger;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGridField;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.pomplatform.client.subjecttype.datasource.DSSubjectDepartment;
import com.pomplatform.client.subjecttype.datasource.DSDepartment;

public class SubjectTypeDetailSubjectDepartment extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	private TreeGrid SourceGrid = new TreeGrid();

	public SubjectTypeDetailSubjectDepartment(){


		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth100();
		TreeGridField[] fields = new TreeGridField[10];
		int idx = 0;
		fields[idx] = new TreeGridField("departmentId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("departmentName");
		fields[idx].setFrozen(true);
		idx ++;
		fields[idx] = new TreeGridField("abbreviation");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("managerId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("managerName");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("parentId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("enabled");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("originalId");
		fields[idx].setHidden(true);
		idx ++;
		fields[idx] = new TreeGridField("plateId");
		idx ++;
		fields[idx] = new TreeGridField("isHeadcount");
		fields[idx].setHidden(true);
		idx ++;
		SourceGrid.setFields(fields);
		SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		SourceGrid.setDataSource(DSDepartment.getInstance());
		SourceGrid.setShowOpenIcons(false);
		SourceGrid.setShowDropIcons(false); 
		SourceGrid.setShowSelectedStyle(false); 
		SourceGrid.setShowPartialSelection(true); 
		SourceGrid.setCascadeSelection(true);   
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setLayoutTopMargin(10);
		SearchSourceLayout.setLayoutRightMargin(5);
		SearchSourceLayout.setMembersMargin(10);
		SearchSourceLayout.addMember(SourceGrid);
		addMember(SearchSourceLayout);
	}

	@Override
	public void startEdit() {
		DBDataSource.callOperation("ST_Department", "find", new HashMap(), new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					int len = dsResponse.getData().length;
					TreeNode[] nodes = new TreeNode[len];
					for (int i = 0; i < len; i++) {
						nodes[i] = new TreeNode();
						DBDataSource.copyRecord(dsResponse.getData()[i], nodes[i]);
					}
					Tree tree = new Tree();
					tree.setModelType(TreeModelType.PARENT);
					tree.setRootValue("0");
					tree.setIdField("departmentId");
					tree.setParentIdField("parentId");
					tree.setData(nodes);
					tree.openAll();
					SourceGrid.setData(tree);
					if (getRecord() != null) reloadDetailTableData();
				}
			}
		});
	}

	public void reloadDetailTableData(){
		SourceGrid.deselectAllRecords();
		Map condition = new HashMap();
		condition.put("subjectTypeId", getRecord().getAttribute("subjectTypeId"));
		DBDataSource.callOperation("ST_SubjectDepartment", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					int len = dsResponse.getData().length;
					if(len == 0) { if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);return; }
					Map searchMap = new HashMap();
					Tree originalList = SourceGrid.getData();
					for (int i = 0; i < len; i++) {
						searchMap.put("departmentId", dsResponse.getData()[i].getAttribute("departmentId"));
						int idx = originalList.findIndex(searchMap);
						if(idx == -1) continue;
						TreeNode node = SourceGrid.getRecord(idx);
						DBDataSource.copyRecord(dsResponse.getData()[i], node);
						if(originalList.isFolder(node)) continue;
						SourceGrid.selectRecord(idx);
					}
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	public void deselectAllSource(){
		SourceGrid.deselectAllRecords();
	}

	@Override
	public boolean checkData() {
		for(ListGridRecord r : SourceGrid.getSelectedRecords()) {
			__logger.info(MapUtils.convertRecordToMap(SourceGrid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailSubjectDepartment");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] selected = SourceGrid.getSelectedRecords();
		return selected == null || selected.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] selected = SourceGrid.getSelectedRecords();
		List resList = new ArrayList();
		for(ListGridRecord r : selected){
			Map lm = MapUtils.convertRecordToMap(DSSubjectDepartment.getInstance(), r);
			resList.add(lm);
		}
		param.put("detailSubjectDepartment", resList);
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail( DSCallback value ) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail( DSCallback value ) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}

	public TreeGrid getSourceGrid() {
		return this.SourceGrid;
	}

	public void setSourceGrid( TreeGrid value ) {
		this.SourceGrid = value;
	}


}

