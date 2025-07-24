package com.pomplatform.client.workflow.personnelbusiness.form;

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
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.attachment.datasource.DSOnAttachmentLinkContractReceivables;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.TreeModelType;
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
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

public class AttachmentLinkContractReceivablesPanel extends AbstractWizadPage {

	private static final Logger __logger = Logger.getLogger("");
	private DSCallback __startLoadedDetail;
	private DSCallback __endLoadedDetail;
	private TreeGrid grid /*= new DelicacyListGrid(false)*/;
	private AbstractWizadPage mainInfoPage;
	
	private Integer contractId;
	
	public AttachmentLinkContractReceivablesPanel() {
		initPanel();
	}
	
	public void initPanel(){
		grid = new TreeGrid() {  
            @Override  
            protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {  
//            	 if (getFieldName(colNum).equals("processStatus")) {  
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

		ListGridField[] fields = new ListGridField[4];
		int idx = 0;
		fields[idx] = new ListGridField("receivableName");
		idx++;
		fields[idx] = new ListGridField("receivablePercentage");
		idx++;
		fields[idx] = new ListGridField("receivableSumMoney");
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
		grid.setHeaderSpans(new HeaderSpan[] { new HeaderSpan("确认函与合同阶段", new String[] { "receivableName", "receivablePercentage", "receivableSumMoney", "bindAmount", "flagType"}) });
		grid.setFields(fields);
		grid.setCanEdit(false);
		grid.setDataSource(DSOnAttachmentLinkContractReceivables.getInstance());
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
		controlLayout.addMember(relationButton);
		controlLayout.addMember(unRelationButton);
		mainLayout.addMember(controlLayout);
		addMember(mainLayout);
	
	}

	private void summaryMoney(){
		BigDecimal sumMoney = BigDecimal.ZERO;
		ListGridRecord[] record = grid.getRecords();
		for (ListGridRecord listGridRecord : record) {
			if(listGridRecord.getAttributeAsInt("flagType") == 2 && null != listGridRecord.getAttribute("receivableSumMoney")){
				BigDecimal receivableSumMoney = new BigDecimal(listGridRecord.getAttribute("receivableSumMoney"));
				sumMoney = sumMoney.add(receivableSumMoney);
			}
		}
		if(null != mainInfoPage){
			mainInfoPage.findNamedItem("rec").setValue(sumMoney);
		}
	}
	
	private void relationData(int type){
		if(grid.anySelected()){
			ListGridRecord[] selectRecords = grid.getSelectedRecords();
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < selectRecords.length; i++) {
				list.add(grid.getRowNum(selectRecords[i]));
			}
//			
			ListGridRecord[] records = grid.getRecords();
			for (int i = 0; i < records.length; i++) {
				if(list.contains(i)){
					records[i].setAttribute("flagType", type);
				}
			}
//			grid.setData(records);
//			grid.redraw();

			
			int len = records.length;
			TreeNode[] nodes = new TreeNode[len];
			for (int i = 0; i < len; i++) {
				nodes[i] = new TreeNode();
				DBDataSource.copyRecord(records[i], nodes[i]);
			}
			Tree tree = new Tree();
			tree.setModelType(TreeModelType.PARENT);
			tree.setRootValue("");
			tree.setIdField("contractReceivableId");
			tree.setParentIdField("parentId");
			tree.setData(nodes);
			tree.openAll();
			grid.setData(tree);
//			grid.selectSingleRecord(0);
//			TreeNode selectedNode = grid.getSelectedRecord();
//			if(selectedNode != null) grid.openFolder(selectedNode);
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
		DBDataSource.callOperation("NQ_OnAttachmentLinkContractReceivables", "find", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					
					int len = dsResponse.getData().length;
					TreeNode[] nodes = new TreeNode[len];
					for (int i = 0; i < len; i++) {
						nodes[i] = new TreeNode();
						DBDataSource.copyRecord(dsResponse.getData()[i], nodes[i]);
					}
					Tree tree = new Tree();
					tree.setModelType(TreeModelType.PARENT);
					tree.setRootValue("");
					tree.setIdField("contractReceivableId");
					tree.setParentIdField("parentId");
					tree.setData(nodes);
					tree.openAll();
					grid.setData(tree);
					summaryMoney();
//					grid.selectSingleRecord(0);
//					TreeNode selectedNode = grid.getSelectedRecord();
//					if(selectedNode != null) grid.openFolder(selectedNode);
					
//					if (__startLoadedDetail != null)
//						__startLoadedDetail.execute(dsResponse, data, dsRequest);
//					grid.setData(dsResponse.getData());
//					if (__endLoadedDetail != null)
//						__endLoadedDetail.execute(dsResponse, data, dsRequest);
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
				SC.say("请添加确认函与收款阶段的绑定");
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("detailAttachmentLinkContractReceivables");
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
		MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailAttachmentLinkContractReceivables");
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

	public TreeGrid getGrid() {
		return this.grid;
	}

	public void setGrid(TreeGrid value) {
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
