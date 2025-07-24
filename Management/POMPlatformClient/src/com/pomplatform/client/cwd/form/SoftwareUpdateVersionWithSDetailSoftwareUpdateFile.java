package com.pomplatform.client.cwd.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.cwd.datasource.DSSoftwareUpdateFile;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SoftwareUpdateVersionWithSDetailSoftwareUpdateFile extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid();

	public SoftwareUpdateVersionWithSDetailSoftwareUpdateFile() {

		HLayout softwareUpdateFiles = new HLayout();
		softwareUpdateFiles.setWidth100();
		softwareUpdateFiles.setHeight100();
		grid.setCanRemoveRecords(true);
		grid.setDataSource(DSSoftwareUpdateFile.getInstance());
		grid.setAutoFitFieldWidths(false);
		softwareUpdateFiles.addMember(grid);
		VLayout softwareUpdateFilesControls = new VLayout();
		softwareUpdateFilesControls.setHeight100();
		softwareUpdateFilesControls.setWidth(60);
		softwareUpdateFilesControls.setLayoutTopMargin(30);
		softwareUpdateFilesControls.setLayoutLeftMargin(5);
		softwareUpdateFilesControls.setLayoutRightMargin(5);
		softwareUpdateFilesControls.setMembersMargin(10);
		softwareUpdateFiles.addMember(softwareUpdateFilesControls);
		addMember(softwareUpdateFiles);
		IButton softwareUpdateFilesNewButton = new IButton("新增");
		softwareUpdateFilesNewButton.setIcon("[SKIN]/actions/add.png");
		softwareUpdateFilesNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PopupWindow window = new PopupWindow();
				window.setWidth("30%");
				window.setHeight("60%");
				window.centerInPage();
				window.setTitle("添加文件");
				AddOrUpdateUpdateFilePanel panel = new AddOrUpdateUpdateFilePanel();
				panel.setParentWindow(window);
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						final Record __record = event.getData();
						grid.addData(__record);
					}
				});
				window.addItem(panel);
				window.show();
			}
		});
		IButton softwareUpdateFilesRemoveButton = new IButton("删除所有");
		softwareUpdateFilesRemoveButton.setIcon("[SKIN]/actions/remove.png");
		softwareUpdateFilesRemoveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		softwareUpdateFilesControls.addMember(softwareUpdateFilesNewButton);
		softwareUpdateFilesControls.addMember(softwareUpdateFilesRemoveButton);
	}

	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		condition.put("softwareUpdateVersionId", getRecord().getAttribute("softwareUpdateVersionId"));
		DBDataSource.callOperation("ST_SoftwareUpdateFile", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (__startLoadedDetail != null)
						__startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if (__endLoadedDetail != null)
						__endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for (ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailSoftwareUpdateFile");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailSoftwareUpdateFile");
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DSCallback getStartLoadedDetail() {
		return this.__startLoadedDetail;
	}

	public void setStartLoadedDetail(DSCallback value) {
		this.__startLoadedDetail = value;
	}

	public DSCallback getEndLoadedDetail() {
		return this.__endLoadedDetail;
	}

	public void setEndLoadedDetail(DSCallback value) {
		this.__endLoadedDetail = value;
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid(DelicacyListGrid value) {
		this.grid = value;
	}

}
