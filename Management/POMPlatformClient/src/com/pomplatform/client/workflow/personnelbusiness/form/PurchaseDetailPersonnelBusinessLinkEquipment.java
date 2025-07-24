package com.pomplatform.client.workflow.personnelbusiness.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
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
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.EditCompleteEvent;
import com.smartgwt.client.widgets.grid.events.EditCompleteHandler;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class PurchaseDetailPersonnelBusinessLinkEquipment extends AbstractWizadPage
{

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private AbstractWizadPage mainInfoPage;
	private DelicacyListGrid grid = new DelicacyListGrid(true);
	ListGridField[] fields = new ListGridField[5];

	public PurchaseDetailPersonnelBusinessLinkEquipment(){


		HLayout personnelBusinessLinkEquipments = new HLayout();
		personnelBusinessLinkEquipments.setWidth100();
		personnelBusinessLinkEquipments.setHeight100();
		grid.setDataSource(DSPersonnelBusinessLinkEquipment.getInstance());
		grid.setAutoFitFieldWidths(false);
		grid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				if (null != mainInfoPage && null != mainInfoPage.findNamedItem("fee")) {
					int rowNum = event.getRowNum();
					BigDecimal totalPrice = BigDecimal.ZERO;
					ListGridRecord[] data = grid.getRecords();
					int i = 0;
					for (ListGridRecord r : data) {
						if (i != rowNum && null != r.getAttribute("totalPrice")) {
							totalPrice = totalPrice.add(new BigDecimal(r.getAttribute("totalPrice")));
						}
						i++;
					}
					mainInfoPage.findNamedItem("fee").setValue(totalPrice);
				}
			}
		});

		int idx = 0;
		fields[idx] = new ListGridField("type");
		idx++;
		fields[idx] = new ListGridField("price");
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
				BigDecimal price = BigDecimal.ZERO;
				BigDecimal amount = BigDecimal.ZERO;
				String type = null;
				if(map.containsKey("type") && null != record.getAttribute("type") && map.get("type").toString().equals(record.getAttribute("type")) && !map.containsKey("price")){
					type = map.get("type").toString();
					price = new BigDecimal(KeyValueManager.getValue("equipment_prices", type));
					record.setAttribute("price", price);
				}
				if(map.containsKey("price") && null != record.getAttribute("price") && map.get("price").toString().equals(record.getAttribute("price"))){
					price = new BigDecimal(map.get("price").toString());
				}else if(!map.containsKey("price") && price.compareTo(BigDecimal.ZERO) == 0 && null != record.getAttribute("price")){
					price = new BigDecimal(record.getAttribute("price"));
				}
				if(map.containsKey("amount") && null != record.getAttribute("amount") && map.get("amount").toString().equals(record.getAttribute("amount"))){
					amount = new BigDecimal(map.get("amount").toString());
				}else if(!map.containsKey("amount") && null != record.getAttribute("amount")){
					amount = new BigDecimal(record.getAttribute("amount"));
				}
				if(price.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(BigDecimal.ZERO) > 0){
					record.setAttribute("totalPrice", price.multiply(amount));
				}
				grid.updateData(record);
				Record[] records = grid.getRecords();
				BigDecimal totalPrice = BigDecimal.ZERO;
				for(Record obj : records){
					if(null != obj.getAttribute("totalPrice")){
						totalPrice = totalPrice.add(new BigDecimal(obj.getAttribute("totalPrice")));
					}
				}
				mainInfoPage.findNamedItem("fee").setValue(totalPrice);
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
		IButton newButton = new IButton("新增");
		newButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.startEditingNew();
			}
		});
		
		
		IButton removeButton = new IButton("删除所有");
		removeButton.addClickHandler( new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				grid.setData(new RecordList());
				mainInfoPage.findNamedItem("fee").setValue(0);
			}
		});
		personnelBusinessLinkEquipmentsControls.addMembers(newButton, /*updateButton,*/ removeButton);
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
		if(!BaseHelpUtils.isNullOrEmpty(type)){
			if(type==1){
				KeyValueManager.loadValueMap("system_dictionary_249", customerItem);
			}else if(type==2){
				KeyValueManager.loadValueMap("system_dictionary_250", customerItem);
			}else{
				KeyValueManager.loadValueMap("system_dictionary_248", customerItem);
			}
		}else{
			KeyValueManager.loadValueMap("system_dictionary_248", customerItem);
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
			SC.say("请在右侧填写采购的物品清单");
			return false;
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
	
	public AbstractWizadPage getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(AbstractWizadPage mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

	public void newPopupWindow(final Record editRecord, final boolean update) {
		final PopupWindow window = new PopupWindow();
		if(update){
			window.setTitle("修改");
		}else{
			window.setTitle("新增");
		}
		window.setWidth(450);
		window.setHeight(370);
		window.centerInPage();
		EquipmentDetailPanel panel = new EquipmentDetailPanel();
		panel.startEdit(editRecord);
		panel.addDataEditedHandler(new DataEditedHandler() {
			@Override
			public void onDataEdited(DataEditEvent event) {
				if(update){
					Record record = event.getData();
					RecordList list = grid.getDataAsRecordList();
					RecordList newList = new RecordList();
					int size = list.getLength();
					int rowNo = grid.getRowNum(grid.getSelectedRecord());
					for(int i=0 ; i<size; i++){
						if(i == rowNo){
							newList.add(record);
						}else{
							newList.add(list.get(i));
						}
					}
					grid.setData(newList);
				}else{
					Record record = event.getData();
					RecordList list = grid.getDataAsRecordList();
					list.add(record);
					grid.setData(list);
				}
				grid.redraw();
				FormItem item = mainInfoPage.findNamedItem("fee");
				BigDecimal totalPrice = BigDecimal.ZERO;
				if (null != item) {
					ListGridRecord[] data = grid.getRecords();
					if (data == null || data.length == 0) {
						item.setValue(totalPrice);
						return;
					}
					for (ListGridRecord r : data) {
						if (null != r.getAttribute("totalPrice")) {
							totalPrice = totalPrice.add(new BigDecimal(r.getAttribute("totalPrice")));
						}
					}
					item.setValue(totalPrice);
				}
			}
		});
		panel.setParentWindow(window);
		window.addItem(panel);
		window.show();
	}
}

