package com.pomplatform.client.attachment.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentLinkInvoices;
import com.pomplatform.client.minvocieapplydedaocor.panel.AttachmentInvoiceContracticcisiiorPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdateAttachmentLinkInvoicesPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid /*= new DelicacyListGrid(false)*/;
	private AbstractWizadPage mainInfoPage;
	
	private Integer contractId;
	
	public UpdateAttachmentLinkInvoicesPanel() {
		initPanel();
	}
	
	public void initPanel(){
		grid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
//            	 if (getFieldName(colNum).equals("processStatus")) { 
            		if(record.getAttributeAsInt("forAmount") == 1){
            			return "color: #ABABAB;";
            		}
            		if(record.getAttributeAsInt("sign") == 3 || record.getAttributeAsInt("sign") == 2 || record.getAttributeAsInt("sign") == 4){
            			return "color: #ABABAB;";
            		}
            		if (record.getAttributeAsInt("flagType") == 2) {  
            			return "color: red;";
                    } else {  
                        return super.getCellCSSText(record, rowNum, colNum);  
                    }  
//            	 }else{
//            		 return super.getCellCSSText(record, rowNum, colNum);  
//            	 }
                
            }  
        };  
		__dataGrid = grid;

		HLayout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.setHeight100();

		ListGridField[] fields = new ListGridField[10];
		int idx = 0;
		fields[idx] = new ListGridField("invoiceType");
		idx++;
//		fields[idx] = new ListGridField("invoiceCode");
//		idx++;
		fields[idx] = new ListGridField("invoiceNumber");
		idx++;
		fields[idx] = new ListGridField("ticketingCompany");
		idx++;
		fields[idx] = new ListGridField("customerId");
		KeyValueManager.loadValueMap("customers", fields[idx]);
		idx++;
		fields[idx] = new ListGridField("invoiceAmount");
		idx++;
		fields[idx] = new ListGridField("taxRate");
		idx++;
		fields[idx] = new ListGridField("noTaxAmount");
		idx++;
//		fields[idx] = new ListGridField("outputTax");
//		idx++;
		fields[idx] = new ListGridField("invoiceDate");
		idx++;
		fields[idx] = new ListGridField("sign");
		idx++;
		fields[idx] = new ListGridField("forAmount");
		idx++;
		fields[idx] = new ListGridField("bindAmount");
		fields[idx].setCellFormatter(new CellFormatter() {
			
			@Override
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				if(value == null){
					return "0";
				}else{
					return value.toString();
				}
			}
		});
		idx++;
		fields[idx] = new ListGridField("flagType");
		
		
		grid.setHeaderHeight(60);
		grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("确认函与发票", new String[] { "invoiceType", "invoiceCode", "invoiceNumber", "ticketingCompany",
				"customerId", "invoiceAmount", "taxRate", "noTaxAmount", "outputTax", "invoiceDate", "sign", "forAmount", "bindAmount", "flagType"}) });
		grid.setFields(fields);
		grid.setCanEdit(false);
		grid.setDataSource(DSOnAttachmentLinkInvoices.getInstance());
		grid.setAutoFitFieldWidths(false);
		mainLayout.addMember(grid);

		VLayout controlLayout = new VLayout();
		controlLayout.setHeight100();
		controlLayout.setWidth(60);
		controlLayout.setLayoutTopMargin(30);
		controlLayout.setLayoutLeftMargin(5);
		controlLayout.setLayoutRightMargin(5);
		controlLayout.setMembersMargin(10);
		IButton relationButton = new IButton("绑定");
		relationButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				relationData(2);
				
			}
		});
		IButton unRelationButton = new IButton("取消绑定");
		unRelationButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				relationData(1);
				
			}
		});
		IButton useInvoiceButton = new IButton("增开发票");
		useInvoiceButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				FormItem contractItem = mainInfoPage.findNamedItem("contractId");
				Object contractId = contractItem.getValue();
				if(null == contractId){
					SC.say("请先选择合同");
					return;
				}
				PopupWindow pw = new PopupWindow();
				ListGridRecord record = new ListGridRecord();
				record.setAttribute("contractId", contractId);
				AttachmentInvoiceContracticcisiiorPanel panel = new AttachmentInvoiceContracticcisiiorPanel(record);
				panel.addDataEditedHandler(new DataEditedHandler() {
	            	@Override
	            	public void onDataEdited(DataEditEvent event) {
	            		reloadDetailTableData();
	            	}
	            });
				panel.setParentCanvas(pw);
	            panel.setFatherWindow(pw);
	            pw.addItem(panel);
	            pw.setTitle("确认填开发票");
	            pw.setWidth100();
	            pw.setHeight100();
	            pw.centerInPage();
	            pw.show();
				
			}
		});
		controlLayout.addMember(relationButton);
		controlLayout.addMember(unRelationButton);
		controlLayout.addMember(useInvoiceButton);
		mainLayout.addMember(controlLayout);
		addMember(mainLayout);
	
	}
	
	private void summaryMoney(){
		BigDecimal sumMoney = BigDecimal.ZERO;
		ListGridRecord[] record = grid.getRecords();
		for (ListGridRecord listGridRecord : record) {
			if(listGridRecord.getAttributeAsInt("flagType") == 2 && null != listGridRecord.getAttribute("invoiceAmount")){
				BigDecimal receivableSumMoney = new BigDecimal(listGridRecord.getAttribute("invoiceAmount"));
				sumMoney = sumMoney.add(receivableSumMoney);
			}
		}
		if(null != mainInfoPage){
			mainInfoPage.findNamedItem("inv").setValue(sumMoney);
		}
	}

	private void relationData(int type){
		if(grid.anySelected()){
			ListGridRecord[] selectRecords = grid.getSelectedRecords();
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < selectRecords.length; i++) {
				list.add(grid.getRowNum(selectRecords[i]));
			}
			
			ListGridRecord[] records = grid.getRecords();
			for (int i = 0; i < records.length; i++) {
				if(list.contains(i)){
					records[i].setAttribute("flagType", type);
				}
			}
			grid.setData(records);
			grid.redraw();
			for (Integer integer : list) {
				grid.selectRecord(integer);
			}
			summaryMoney();
		} else {
			SC.say("请选择需要处理的数据");
		}
	}
	
	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		Object attachmentManageId = -1;
		if(null != getRecord() && null != getRecord().getAttribute("attachmentManageId")){
			attachmentManageId = getRecord().getAttribute("attachmentManageId");
		}
		if(null != getRecord() && null != getRecord().getAttribute("contractId")){
			if(null == this.contractId){
				this.contractId = getRecord().getAttributeAsInt("contractId");
			}
		}
		condition.put("contractId", this.contractId);
		condition.put("attachmentManageId", attachmentManageId);
		DBDataSource.callOperation("NQ_OnUpdateAttachmentLinkInvoices", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (__startLoadedDetail != null)
						__startLoadedDetail.execute(dsResponse, data, dsRequest);
					grid.setData(dsResponse.getData());
					if (__endLoadedDetail != null)
						__endLoadedDetail.execute(dsResponse, data, dsRequest);
					summaryMoney();
				}
			}
		});
	}

	@Override
	public boolean checkData() {
		for (ListGridRecord r : grid.getRecords()) {
			__logger.info(MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
		}
//		if(isVisible()){
//			AdvancedCriteria ad = new AdvancedCriteria();
//			ad.addCriteria("flagType", 2);
//			if(grid.findAll(ad).length <= 0){
//				SC.say("请添加确认函与发票的绑定");
//				return false;
//			}
//		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailAttachmentLinkInvoices");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailAttachmentLinkInvoices");
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

	public AbstractWizadPage getMainInfoPage() {
		return mainInfoPage;
	}

	public void setMainInfoPage(AbstractWizadPage mainInfoPage) {
		this.mainInfoPage = mainInfoPage;
	}

	public void reDrawGrid() {
		if (null != grid)
			this.grid.redraw();
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

}
