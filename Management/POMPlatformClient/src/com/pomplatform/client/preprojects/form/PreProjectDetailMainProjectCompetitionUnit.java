package com.pomplatform.client.preprojects.form;

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
import com.smartgwt.client.widgets.grid.ListGridField;
import com.pomplatform.client.preprojects.datasource.DSMainProjectCompetitionUnit;

public class PreProjectDetailMainProjectCompetitionUnit extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	public PreProjectDetailMainProjectCompetitionUnit(){


		HLayout mainProjectCompetitionUnits = new HLayout();
		mainProjectCompetitionUnits.setWidth100();
		mainProjectCompetitionUnits.setHeight100();
		grid.setDataSource(DSMainProjectCompetitionUnit.getInstance());
		grid.setAutoFitFieldWidths(false);
		mainProjectCompetitionUnits.addMember(grid);
		VLayout mainProjectCompetitionUnitsControls = new VLayout();
		mainProjectCompetitionUnitsControls.setHeight100();
		mainProjectCompetitionUnitsControls.setWidth(60);
		mainProjectCompetitionUnitsControls.setLayoutTopMargin(30);
		mainProjectCompetitionUnitsControls.setLayoutLeftMargin(5);
		mainProjectCompetitionUnitsControls.setLayoutRightMargin(5);
		mainProjectCompetitionUnitsControls.setMembersMargin(10);
		mainProjectCompetitionUnits.addMember(mainProjectCompetitionUnitsControls);
		addMember(mainProjectCompetitionUnits);
		IButton mainProjectCompetitionUnitsNewButton = new IButton("新增");
		mainProjectCompetitionUnitsNewButton.setIcon("[SKIN]/actions/add.png");
		mainProjectCompetitionUnitsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		IButton mainProjectCompetitionUnitsRemoveButton = new IButton("删除所有");
		mainProjectCompetitionUnitsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		mainProjectCompetitionUnitsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		mainProjectCompetitionUnitsControls.addMember(mainProjectCompetitionUnitsNewButton);
		mainProjectCompetitionUnitsControls.addMember(mainProjectCompetitionUnitsRemoveButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("mainProjectId", getRecord().getAttribute("preProjectId"));
		DBDataSource.callOperation("ST_MainProjectCompetitionUnit", "find", condition, new DSCallback(){
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					if(__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if(__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for(ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailMainProjectCompetitionUnit");
		return res;
	}

	@Override
	public boolean isTheValuesEmpty() {
		ListGridRecord[] rows = grid.getRecords();
		return rows == null || rows.length == 0;
	}

	@Override
	public Map getValuesAsMap() {
		Map param = new HashMap();
		ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailMainProjectCompetitionUnit");
		return param;
	}

	@Override
	public String getName() {
		return "前期项目的竞争单位子表";
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


}

