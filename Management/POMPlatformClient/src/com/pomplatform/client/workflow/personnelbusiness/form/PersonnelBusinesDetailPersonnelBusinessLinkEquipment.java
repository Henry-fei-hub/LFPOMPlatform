package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSPersonnelBusinessLinkEquipment;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PersonnelBusinesDetailPersonnelBusinessLinkEquipment extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	ListGridField[] fields = new ListGridField[5];


	public PersonnelBusinesDetailPersonnelBusinessLinkEquipment(){


		HLayout personnelBusinessLinkEquipments = new HLayout();
		personnelBusinessLinkEquipments.setWidth100();
		personnelBusinessLinkEquipments.setHeight100();
		grid.setDataSource(DSPersonnelBusinessLinkEquipment.getInstance());
		grid.setAutoFitFieldWidths(false);
		int idx = 0;
		fields[idx] = new ListGridField("type")		;


///		fields[idx].setEditorProperties(typeSelect);
		idx++;
		fields[idx] = new ListGridField("price");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("amount");
		idx++;
		fields[idx] = new ListGridField("totalPrice");
		fields[idx].setCanEdit(false);
		idx++;
		fields[idx] = new ListGridField("remark");
		grid.setFields(fields);
		grid.addEditCompleteHandler(new EditCompleteHandler() {
			
			@Override
			public void onEditComplete(EditCompleteEvent event) {
				Map map = event.getNewValues();
				Record record = grid.getRecord(event.getRowNum());
				if(map.containsKey("type") && map.containsKey("amount")){
					//如果map中的type和record中的type不一致，则为删除操作，不需要更新总价
					if(null != record.getAttribute("type") && map.get("type").toString().equals(record.getAttribute("type"))){
						//修改了种类和数量，则根据新的种类价格和数量来计算总价
						record.setAttribute("price", KeyValueManager.getValue("equipment_prices", map.get("type").toString()));
						record.setAttribute("totalPrice", new BigDecimal(record.getAttribute("price")).multiply(new BigDecimal(map.get("amount").toString())));
					}
				}else if(map.containsKey("type")){
					//如果map中的type和record中的type不一致，则为删除操作，不需要更新总价
					if(null != record.getAttribute("type") && map.get("type").toString().equals(record.getAttribute("type"))){
						//只修改了种类，则更新价格，并按新价格更新总价
						record.setAttribute("price", KeyValueManager.getValue("equipment_prices", map.get("type").toString()));
						if(null != record.getAttribute("amount")){
							record.setAttribute("totalPrice", new BigDecimal(record.getAttribute("price")).multiply(new BigDecimal(record.getAttribute("amount"))));
						}
					}
				}else if(map.containsKey("amount")){
					//如果map中的amount和record中的amount不一致，则为删除操作，不需要更新总价
					if(null != record.getAttribute("amount") && map.get("amount").toString().equals(record.getAttribute("amount"))){
						//只修改了数量，则根据旧的价格和新的数量更新总价
						if(null != record.getAttribute("price")){
							record.setAttribute("totalPrice", new BigDecimal(record.getAttribute("price")).multiply(new BigDecimal(map.get("amount").toString())));
						}
					}
				}
				grid.updateData(record);
			}
		});
		personnelBusinessLinkEquipments.addMember(grid);
		VLayout personnelBusinessLinkEquipmentsControls = new VLayout();
		personnelBusinessLinkEquipmentsControls.setHeight100();
		personnelBusinessLinkEquipmentsControls.setWidth(60);
		personnelBusinessLinkEquipmentsControls.setLayoutTopMargin(30);
		personnelBusinessLinkEquipmentsControls.setLayoutLeftMargin(5);
		personnelBusinessLinkEquipmentsControls.setLayoutRightMargin(5);
		personnelBusinessLinkEquipmentsControls.setMembersMargin(10);
		personnelBusinessLinkEquipments.addMember(personnelBusinessLinkEquipmentsControls);
		addMember(personnelBusinessLinkEquipments);
		IButton personnelBusinessLinkEquipmentsNewButton = new IButton("新增");
		personnelBusinessLinkEquipmentsNewButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		IButton personnelBusinessLinkEquipmentsRemoveButton = new IButton("删除所有");
		personnelBusinessLinkEquipmentsRemoveButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
			}
		});
		personnelBusinessLinkEquipmentsControls.addMember(personnelBusinessLinkEquipmentsNewButton);
		personnelBusinessLinkEquipmentsControls.addMember(personnelBusinessLinkEquipmentsRemoveButton);
	}

	@Override
	public void startEdit() {
		if(getPageMode() != PAGE_MODE_UPDATE) return;
		reloadDetailTableData();
	}


	public void reload(int type){
		ComboBoxItem customerItem = new ComboBoxItem();
		customerItem.setChangeOnKeypress(false);
		customerItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		fields[0].setEditorProperties(customerItem);
		grid.setData(new RecordList());
//		EditCompleteEvent editCompleteEvent = new EditCompleteEvent(null);
//		grid.fireEvent(editCompleteEvent);
		if(!BaseHelpUtils.isNullOrEmpty(type)){
			if(type==1){
				KeyValueManager.loadValueMap("system_dictionary_257", customerItem);
			}else if(type==2){
				KeyValueManager.loadValueMap("system_dictionary_258", customerItem);
			}else{
				KeyValueManager.loadValueMap("system_dictionary_256", customerItem);
			}
		}else{
			KeyValueManager.loadValueMap("system_dictionary_256", customerItem);
		}
		fields[0].setEditorProperties(customerItem);
	}

	public void reloadDetailTableData(){
		Map condition = new HashMap();
		condition.put("parentId", getRecord().getAttribute("personnelBusinessId"));
		condition.put("processType", getRecord().getAttribute("processType"));
		DBDataSource.callOperation("ST_PersonnelBusinessLinkEquipment", "find", condition, new DSCallback(){
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
		ListGridRecord[] records = grid.getRecords();
		if(null == records || (null != records && records.length == 0)){
			SC.say("请在右侧填写领用的物品清单");
			return false;
		}
		for(ListGridRecord record : records){
			if(null == record.getAttribute("type")){
				SC.say("请选择领用的物品类型");
				return false;
			}
			if(null == record.getAttribute("amount")){
				SC.say("请填写需要领用的物品数量");
				return false;
			}
			if(ClientUtil.checkAndGetIntValue(record.getAttribute("amount")) == 0){
				SC.say("领用的物品数量必须大于0");
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailPersonnelBusinessLinkEquipment");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailPersonnelBusinessLinkEquipment");
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

