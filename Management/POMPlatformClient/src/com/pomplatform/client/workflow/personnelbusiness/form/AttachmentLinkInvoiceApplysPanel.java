package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentLinkInvoiceApplys;
import com.pomplatform.client.minvocieapplydedaocor.panel.AddOrUpdateContactsPanel;
import com.pomplatform.client.minvocieapplydedaocor.panel.CheckContactsPanel;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
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

public class AttachmentLinkInvoiceApplysPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private DelicacyListGrid grid /*= new DelicacyListGrid(false)*/;
	private AbstractWizadPage mainInfoPage;
	private Integer type;
	
	private Integer contractId;
	
	public AttachmentLinkInvoiceApplysPanel() {
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
		fields[idx] = new ListGridField("invoiceType");
		idx++;
		fields[idx] = new ListGridField("companyName");
		idx++;
		fields[idx] = new ListGridField("dutyParagraph");
		idx++;
		fields[idx] = new ListGridField("landline");
		idx++;
		fields[idx] = new ListGridField("registeredAddress");
		idx++;
		fields[idx] = new ListGridField("bankName");
		idx++;
		fields[idx] = new ListGridField("bankAccount");
		idx++;
		fields[idx] = new ListGridField("customerName");
		idx++;
		fields[idx] = new ListGridField("customerPhone");
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
				"companyName", "landline", "invoiceType", "dutyParagraph", "customerName", "customerPhone", "registeredAddress", "bankName", "bankAccount", "applyRemark", "bindAmount", "flagType", "deleteFlag"}) });
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
				PopupWindow pw = new PopupWindow();
				CheckContactsPanel panel = new CheckContactsPanel(false);
				panel.setContractId(contractId);
				panel.setRecord(grid.getSelectedRecord());
				panel.startEdit();
				panel.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						Record record = event.getData();
						int temp = record.getAttributeAsInt("temp");
						if (temp == 2) {
							relationData(2);
						}
						if (temp == 1) {
							if(grid.anySelected()){
								PopupWindow pw = new PopupWindow();
								AddOrUpdateContactsPanel panel = new AddOrUpdateContactsPanel(false);
								panel.setContractId(contractId);
								panel.setRecord(grid.getSelectedRecord());
								panel.startEdit();
								panel.addDataEditedHandler(new DataEditedHandler() {
									@Override
									public void onDataEdited(DataEditEvent event) {
										reloadDetailTableData(BaseHelpUtils.getIntValue(event.getData().getAttribute("invoiceApplyId")));
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
								SC.say("请选择一条联系人数据");
							}
						}
//						reloadDetailTableData(invoiceApplyId);
					}
				});
				panel.setParentCanvas(pw);
				panel.setFatherWindow(pw);
				panel.setGridRecords(grid.getSelectedRecords());
				panel.setContractId(contractId);
				pw.addItem(panel);
				pw.setTitle("<font class=\"attachment_pw_head_title\" style=\"color:red;font-weight:bold;align:center;\">请仔细核对联系人姓名、电话以及邮寄地址，财务部将根据这个地址来发出快递!!!</font>");

				pw.setWidth("45%");
				pw.setHeight("50%");
				pw.centerInPage();
				pw.show();
				SC.debugger();
//				relationData(2);
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
		IButton addThisButton = new IButton("以此联系人新增");
		addThisButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(grid.anySelected()){
					PopupWindow pw = new PopupWindow();
					AddOrUpdateContactsPanel panel = new AddOrUpdateContactsPanel(false);
					panel.setContractId(contractId);
					panel.setRecord(grid.getSelectedRecord());
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
					SC.say("请选择一条联系人数据");
				}
				
			}
		});
		IButton expressBtn = new IButton("递送快递");
		expressBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(null != getRecord().getAttribute("personnelBusinessId")){
					if(grid.anySelected()){
						//将确认函主键、与联系人信息、业务主键带入开快递面板
						int personnelBusinessId = getRecord().getAttributeAsInt("personnelBusinessId");
						Map params = grid.getSelectedRecord().toMap();
						params.put("personnelBusinessId", personnelBusinessId);
						
					}else{
						SC.say("请选择一条联系人信息");
					}
					
					
				}
				
			}
		});
		controlLayout.addMember(relationButton);
		controlLayout.addMember(unRelationButton);
		controlLayout.addMember(addButton);
		controlLayout.addMember(addThisButton);
//		controlLayout.addMember(expressBtn);
		mainLayout.addMember(controlLayout);
		addMember(mainLayout);
	
	}

	public void relationData(int type){
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
	
	public void checkType(ListGridRecord[] records , Integer contractId1){
		if (getType() == 1) {
			SC.say("____"+contractId1);
			if(null != contractId1 && contractId1 > 0){
				PopupWindow pw1 = new PopupWindow();
				AddOrUpdateContactsPanel panel1 = new AddOrUpdateContactsPanel(false);
				panel1.setContractId(contractId1);
				panel1.setRecord(records[0]);
				panel1.startEdit();
				panel1.addDataEditedHandler(new DataEditedHandler() {
					@Override
					public void onDataEdited(DataEditEvent event) {
						reloadDetailTableData();
					}
				});
				panel1.setParentCanvas(pw1);
				panel1.setFatherWindow(pw1);
				pw1.addItem(panel1);
				pw1.setTitle("添加联系人");
				pw1.setWidth("30%");
				pw1.setHeight("90%");
				pw1.centerInPage();
				pw1.show();
			}else{
				SC.say("请先选择合同");
			}
		}
		if (getType() == 2) {
			SC.say("222");
//			relationData(2);
			SC.debugger();
			if(records.length != 0){
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < records.length; i++) {
					list.add(grid.getRowNum(records[i]));
				}
				
				ListGridRecord[] records2 = grid.getRecords();
				for (int i = 0; i < records2.length; i++) {
					if(list.contains(i)){
						records2[i].setAttribute("flagType", 2);
					}
				}
				grid.setData(records2);
				grid.redraw();
				for (Integer integer : list) {
					grid.selectRecord(integer);
				}
			} else {
				SC.say("请选择需要处理的数据");
			}
		}
	}
	
	@Override
	public void startEdit() {
		if (getPageMode() != PAGE_MODE_UPDATE)
			return;
		reloadDetailTableData();
	}
	
	public void reloadDetailTableData(int pkId) {
		List<Integer> ids = new ArrayList<>();
		ids.add(pkId);
		AdvancedCriteria aCriteria = new AdvancedCriteria();
		aCriteria.addCriteria("flagType", 2);
		Record [] oriRecords = grid.findAll(aCriteria);
		for (Record record : oriRecords) {
			ids.add(record.getAttributeAsInt("invoiceApplyId"));
		}
		
		Map condition = new HashMap();
		Object personnelBusinessId = -1;
		if(null != getRecord() && null != getRecord().getAttribute("personnelBusinessId")){
			personnelBusinessId = getRecord().getAttribute("personnelBusinessId");
		}
		if(null != getRecord() && null != getRecord().getAttribute("projectId")){
			if(null == this.contractId){
				this.contractId = getRecord().getAttributeAsInt("projectId");
			}
		}
		condition.put("contractId", this.contractId);
		condition.put("personnelBusinessId", personnelBusinessId);
		DBDataSource.callOperation("NQ_OnAttachmentLinkInvoiceApplys", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if (__startLoadedDetail != null)
						__startLoadedDetail.execute(dsResponse, data, dsRequest);
					Record [] tmpRecords = dsResponse.getData();
					for (Record record : tmpRecords) {
						for (int checkId : ids) {
							if(record.getAttributeAsInt("invoiceApplyId") == checkId){
								record.setAttribute("flagType", 2);
							}
						}
					}
					grid.setData(tmpRecords);
					if (__endLoadedDetail != null)
						__endLoadedDetail.execute(dsResponse, data, dsRequest);
				}
			}
		});
	}

	public void reloadDetailTableData() {
		Map condition = new HashMap();
		Object personnelBusinessId = -1;
		if(null != getRecord() && null != getRecord().getAttribute("personnelBusinessId")){
			personnelBusinessId = getRecord().getAttribute("personnelBusinessId");
		}
		if(null != getRecord() && null != getRecord().getAttribute("projectId")){
			if(null == this.contractId){
				this.contractId = getRecord().getAttributeAsInt("projectId");
			}
		}
		condition.put("contractId", this.contractId);
		condition.put("personnelBusinessId", personnelBusinessId);
		DBDataSource.callOperation("NQ_OnAttachmentLinkInvoiceApplys", "find", condition, new DSCallback() {
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	

}
