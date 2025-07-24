package com.pomplatform.client.attachment.panel;

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
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentLinkInvoiceApplys;
import com.pomplatform.client.minvocieapplydedaocor.panel.AddOrUpdateContactsPanel;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UpdateAttachmentLinkInvoiceApplysPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid /*= new DelicacyListGrid(false)*/;
	private AbstractWizadPage mainInfoPage;
	
	private Integer contractId;
	
	public UpdateAttachmentLinkInvoiceApplysPanel() {
		initPanel();
	}
	
	public void initPanel(){
		grid = new DelicacyListGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
//            	 if (getFieldName(colNum).equals("processStatus")) {  
	            	if(record.getAttributeAsInt("deleteFlag") == 1){
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

		ListGridField[] fields = new ListGridField[7];
		int idx = 0;
		fields[idx] = new ListGridField("companyName");
		idx++;
		fields[idx] = new ListGridField("invoiceType");
		idx++;
		fields[idx] = new ListGridField("dutyParagraph");
		idx++;
		fields[idx] = new ListGridField("customerName");
		idx++;
		fields[idx] = new ListGridField("customerPhone");
		idx++;
		fields[idx] = new ListGridField("registeredAddress");
		idx++;
		fields[idx] = new ListGridField("bankName");
		idx++;
		fields[idx] = new ListGridField("bankAccount");
		idx++;
		fields[idx] = new ListGridField("applyRemark");
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
		idx++;
		fields[idx] = new ListGridField("deleteFlag");
		grid.setHeaderHeight(60);
		grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("确认函与联系人", new String[] { 
				"companyName", "invoiceType", "dutyParagraph", "customerName", "customerPhone", "registeredAddress", "bankName", "bankAccount", "applyRemark", "bindAmount", "flagType", "deleteFlag"}) });
		grid.setFields(fields);
		grid.setCanEdit(false);
		grid.setDataSource(DSOnAttachmentLinkInvoiceApplys.getInstance());
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
		IButton addButton = new IButton("新增联系人");
		addButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(null != contractId && contractId > 0){
					PopupWindow pw = new PopupWindow();
					AddOrUpdateContactsPanel panel = new AddOrUpdateContactsPanel(false);
					panel.setContractId(contractId);
					panel.startEdit();
					panel.addDataEditedHandler(new DataEditedHandler() {
						@Override
						public void onDataEdited(DataEditEvent event) {
							reloadDetailTableData();
						}
					});
					panel.setParentCanvas(pw);
					panel.setFatherWindow(pw);
					pw.addItem(panel);
					pw.setTitle("添加联系人");
					pw.setWidth("30%");
					pw.setHeight("90%");
					pw.centerInPage();
					pw.show();
				}else{
					SC.say("请先选择合同");
				}
				
				
			}
		});
		controlLayout.addMember(relationButton);
		controlLayout.addMember(unRelationButton);
		controlLayout.addMember(addButton);
		mainLayout.addMember(controlLayout);
		addMember(mainLayout);
	
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
		DBDataSource.callOperation("NQ_OnUpdateAttachmentLinkInvoiceApplys", "find", condition, new DSCallback() {
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
		if(isVisible()){
			AdvancedCriteria ad = new AdvancedCriteria();
			ad.addCriteria("flagType", 2);
			if(grid.findAll(ad).length <= 0){
				SC.say("请添加确认函与联系人的绑定");
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailAttachmentLinkInvoiceApplys");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailAttachmentLinkInvoiceApplys");
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
