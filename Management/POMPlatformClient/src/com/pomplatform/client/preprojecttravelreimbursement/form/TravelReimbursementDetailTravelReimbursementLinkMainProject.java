package com.pomplatform.client.preprojecttravelreimbursement.form;

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
import com.pomplatform.client.preprojecttravelreimbursement.datasource.DSTravelReimbursementLinkMainProject;

public class TravelReimbursementDetailTravelReimbursementLinkMainProject extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	public TravelReimbursementDetailTravelReimbursementLinkMainProject(){


		HLayout travelReimbursementLinkMainProjects = new HLayout();
		travelReimbursementLinkMainProjects.setWidth100();
		travelReimbursementLinkMainProjects.setHeight100();
		grid.setDataSource(DSTravelReimbursementLinkMainProject.getInstance());
		grid.setAutoFitFieldWidths(false);
		travelReimbursementLinkMainProjects.addMember(grid);
		VLayout travelReimbursementLinkMainProjectsControls = new VLayout();
		travelReimbursementLinkMainProjectsControls.setHeight100();
		travelReimbursementLinkMainProjectsControls.setWidth(60);
		travelReimbursementLinkMainProjectsControls.setLayoutTopMargin(30);
		travelReimbursementLinkMainProjectsControls.setLayoutLeftMargin(5);
		travelReimbursementLinkMainProjectsControls.setLayoutRightMargin(5);
		travelReimbursementLinkMainProjectsControls.setMembersMargin(10);
		travelReimbursementLinkMainProjects.addMember(travelReimbursementLinkMainProjectsControls);
		addMember(travelReimbursementLinkMainProjects);
		IButton travelReimbursementLinkMainProjectsNewButton = new IButton("新增");
		travelReimbursementLinkMainProjectsNewButton.setIcon("[SKIN]/actions/add.png");
		travelReimbursementLinkMainProjectsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		IButton travelReimbursementLinkMainProjectsRemoveButton = new IButton("删除所有");
		travelReimbursementLinkMainProjectsRemoveButton.setIcon("[SKIN]/actions/remove.png");
		travelReimbursementLinkMainProjectsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		travelReimbursementLinkMainProjectsControls.addMember(travelReimbursementLinkMainProjectsNewButton);
		travelReimbursementLinkMainProjectsControls.addMember(travelReimbursementLinkMainProjectsRemoveButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("travelReimbursementId", getRecord().getAttribute("travelReimbursementId"));
		DBDataSource.callOperation("ST_TravelReimbursementLinkMainProject", "find", condition, new DSCallback(){
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
		res.add("detailTravelReimbursementLinkMainProject");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailTravelReimbursementLinkMainProject");
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


}

