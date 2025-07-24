package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.ViewProcessWindow;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSpersonnelLinkReturn;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.*;
import java.util.logging.Logger;

public class ReturnOfItemDetailUpdate extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);

	private Record record;

	@Override
	public Record getRecord() {
		return record;
	}

	@Override
	public void setRecord(Record record) {
		this.record = record;
	}

	public ReturnOfItemDetailUpdate(Record data){
		setRecord(data);

		HLayout returnOfItem = new HLayout();
		returnOfItem.setWidth100();
		returnOfItem.setHeight100();
		grid.setDataSource(DSpersonnelLinkReturn.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
		grid.setCanRemoveRecords(false);
		grid.setCanEdit(false);
//

		returnOfItem.addMember(grid);
		VLayout personnelBusinessLinkEquipmentsControls = new VLayout();
		personnelBusinessLinkEquipmentsControls.setHeight100();
		personnelBusinessLinkEquipmentsControls.setWidth(60);
		personnelBusinessLinkEquipmentsControls.setLayoutTopMargin(30);
		personnelBusinessLinkEquipmentsControls.setLayoutLeftMargin(5);
		personnelBusinessLinkEquipmentsControls.setLayoutRightMargin(5);
		personnelBusinessLinkEquipmentsControls.setMembersMargin(10);
		returnOfItem.addMember(personnelBusinessLinkEquipmentsControls);
		addMember(returnOfItem);
		IButton personnelBusinessLinkEquipmentsNewButton = new IButton("查看关联流程");
		personnelBusinessLinkEquipmentsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord selectedRecord = grid.getSelectedRecord();
				if (BaseHelpUtils.isNullOrEmpty(selectedRecord)) {
					SC.say("提示:", "请选择一条数据");
					return;
				}
				SC.debugger();
				HashMap<String, Integer> params = new HashMap<>();
				Map<String, Object> condition = new HashMap<>();
				int personnelBusinessLinkEquipmentId = BaseHelpUtils.getIntValue(selectedRecord.getAttribute("personnelBusinessLinkEquipmentId"));
				params.put("personnelBusinessLinkEquipmentId", personnelBusinessLinkEquipmentId);
				DBDataSource.callOperation("ST_PersonnelBusinessLinkEquipment", "find", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							Record data1 = dsResponse.getData()[0];
							if (!BaseHelpUtils.isNullOrEmpty(data1)) {
								int parentId = BaseHelpUtils.getIntValue(data1.getAttribute("parentId"));
								condition.put("personnelBusinessId", parentId);
								DBDataSource.callOperation("NQ_PersonnelBusinessLinkProcessInstance", condition, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											Record data = dsResponse.getData()[0];
											ViewProcessWindow Reimbursement = new ViewProcessWindow();
											Reimbursement.setWidth("80%");
											Reimbursement.setHeight("80%");
											Reimbursement.setLayoutMode(0);
											Reimbursement.setInstanceData(data);
											Reimbursement.initComponents();
											Reimbursement.setTitle("物品申请");
											Reimbursement.show();
										}
									}
								});
							}
						}
					}
				});


			}
		});
		personnelBusinessLinkEquipmentsControls.addMember(personnelBusinessLinkEquipmentsNewButton);

		startEdit();
	}

	@Override
	public void startEdit() {
		reloadDetailTableData();
	}

	/**
	 * @author liubin
	 * @date 2019/12/24 14:53
	 * @param []
	 * @return void
	 * @description: 查询归还的流程的数据
	 */
	private void reloadDetailTableData() {
		SC.debugger();
		Record record = getRecord();
		//获取流程的业务表的主键
		int businessId = BaseHelpUtils.getIntValue(record.getAttribute("personnelBusinessId"));
		Map<String, Object> params = new HashMap<>();
		params.put("personnelBusinessId", businessId);
		DBDataSource.callOperation("ST_PersonnelBusinessLinkReturn","find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					Record[] data = dsResponse.getData();
					grid.setData(data);
				}
			}
		});
	}


	@Override
	public boolean checkData() {

		ListGridRecord[] records = grid.getSelectedRecords();
		if(records.length<=0){
			SC.say("请勾选要归还的物品!");
			return false;
		}
		for (ListGridRecord r :records){
			if(BaseHelpUtils.getIntValue(r.getAttribute("returnAmount"))<=0){
				SC.say("归还数量不能为0!");
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("returnOfItemDetailUpdate");
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
		/*ListGridRecord[] rows = grid.getRecords();
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "returnOfItemDetail");
		param.put("list", "list");*/
		return param;
	}

	@Override
	public String getName() {
		return "";
	}

	public DelicacyListGrid getGrid() {
		return this.grid;
	}

	public void setGrid( DelicacyListGrid value ) {
		this.grid = value;
	}


}

