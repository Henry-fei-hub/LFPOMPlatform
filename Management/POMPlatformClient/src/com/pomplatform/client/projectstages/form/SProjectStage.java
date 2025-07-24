package com.pomplatform.client.projectstages.form;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.projectstages.datasource.DSSprojectstagecor;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementWithDepartment;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

	
public class SProjectStage extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("");
    private final DelicacyListGrid grid = new DelicacyListGrid();
    private final DelicacyListGrid SourceGrid = new DelicacyListGrid();
    private final DynamicForm form;
    private int countPercent = 0;
    private BigDecimal projectIntegral;
    private BigDecimal settlementIntegral;
    private int attachmentNum;
    private String oldValue = null;
    private TextItem projectIntegralLeftItem;
    private TextItem projectIntegralItem;
    private TextItem contractNameItem;
    private TextItem remarkItem;
    //附件
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
    public static IButton uploadButton;

    public SProjectStage(Map<String,Object> map) {
    	
    	
        VLayout mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        mainLayout.setLayoutTopMargin(10);
        mainLayout.setLayoutRightMargin(5);
        mainLayout.setMembersMargin(10);
        mainLayout.setShowResizeBar(false);
        
        //上半部layout
        VLayout SearchSourceLayout = new VLayout();
        SearchSourceLayout.setWidth100();
        SearchSourceLayout.setHeight("25%");
        SearchSourceLayout.setLayoutTopMargin(10);
        mainLayout.addMember(SearchSourceLayout);
        
        HLayout infoLayout = new HLayout(10);
		infoLayout.setWidth100();
		infoLayout.setHeight("10%");
		infoLayout.setLayoutTopMargin(30);
		contractNameItem = new TextItem("contractName", "订单名称");
		contractNameItem.setWidth("*");
		contractNameItem.setValue(map.get("contractName"));
		contractNameItem.setCanEdit(false);

		projectIntegralItem = new TextItem("projectIntegral", "订单积分");
		projectIntegralItem.setWidth("*");
		projectIntegralItem.setValue(map.get("projectAmountSum"));
		projectIntegralItem.setCanEdit(false);

		projectIntegralLeftItem = new TextItem("projectIntegralLeft", "本次申请积分");
		projectIntegralLeftItem.setWidth("*");
		projectIntegralLeftItem.setCanEdit(false);
//		projectIntegral = BaseHelpUtils.getBigDecimalValue(projectIntegralItem.getValue());
		
		remarkItem = new TextItem("remark", "申请缘由");
		remarkItem.setWidth("*");
		remarkItem.setCanEdit(true);
		
		attachmentItem = new LinkItem("attachment");
		attachmentItem.setWidth("*");
		attachmentItem.setCanEdit(false);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		
		
		uploadButton= new IButton("上传附件", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传附件", false, 100, null, 1, new UploadCallBack() {
					
					@Override
					public void execute(Map<String, Record> data) {
						for(String key : data.keySet()) {
							String fileId = data.get(key).getAttribute("fileId");
							attachmentItem.setValue(data.get(key).getAttribute("fileUrl"));
							attachmentIdItem.setValue(fileId);
							String fileName = data.get(key).getAttribute("fileName");
							attachmentItem.setLinkTitle(fileName);
							attachmentNameItem.setValue(fileName);
						}
					}
				});
			}
		});

		form = new DynamicForm();
		form.setNumCols(8);
		form.setWidth100();
		form.setHeight100();
		form.setDataSource(DSNormalReimbursementWithDepartment.getInstance());
		form.setItems(contractNameItem, projectIntegralItem, projectIntegralLeftItem,remarkItem,attachmentItem,attachmentIdItem,attachmentNameItem);
//		contractNameItem.setColSpan(3);
//		projectIntegralItem.setColSpan(3);
//		projectIntegralLeftItem.setColSpan(3);
		remarkItem.setColSpan(5);
		attachmentItem.setColSpan(5);
		infoLayout.addMember(form);
		SearchSourceLayout.addMember(infoLayout);
		SearchSourceLayout.addMember(uploadButton);
    	
        //下半部layout
        HLayout SourceLayout = new HLayout(5);
        SourceLayout.setWidth100();
        SourceLayout.setHeight("70%");
        mainLayout.addMember(SourceLayout);
        SourceGrid.setAutoFitFieldWidths(false);
      	SourceGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
      	SourceGrid.setDataSource(DSSprojectstagecor.getInstance());
      	SourceLayout.addMember(SourceGrid);
    	addMember(mainLayout);
    	

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void startEdit() {
        if (getPageMode() != PAGE_MODE_UPDATE) {
            return;
        }
        Map condition = new HashMap();
        condition.put("contractId", getRecord().getAttribute("contractId"));
        condition.put("addtionalCondition", " order by project_stage_id");
        DBDataSource.callOperation("NQ_Sprojectstagecor", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                	SourceGrid.setData(dsResponse.getData());
                }
            }
        });
    }

    @Override
    public boolean checkData() {
//        for (ListGridRecord r : SourceGrid.getRecords()) {
//            __logger.info(MapUtils.convertRecordToMap(SourceGrid.getDataSource(), r).toString());
//        }
    	ListGridRecord[] selectedRecords = SourceGrid.getSelectedRecords();
    	if(selectedRecords.length<=0) {
    		SC.say("提示","请选择最少一个阶段");
    		return false;
    	}
    	
    	BigDecimal projectIntegralLeft = BaseHelpUtils.getBigDecimalValue(projectIntegralLeftItem.getValue());
    	if(projectIntegralLeft.compareTo(BigDecimal.ZERO)<=0) {
    		SC.say("提示","本次申请的积分小于等于0");
    		return false;
    	}
    	String remark = BaseHelpUtils.getString(remarkItem.getValue());
    	if(BaseHelpUtils.isNullOrEmpty(remark)) {
    		SC.say("提示","备注不能为空");
    		return false;
    	}
    	
		String attachment=BaseHelpUtils.getString(attachmentItem.getValue());
		String attachmentId=BaseHelpUtils.getString(attachmentIdItem.getValue());
		String attachmentName=BaseHelpUtils.getString(attachmentNameItem.getValue());
		if(BaseHelpUtils.isNullOrEmpty(attachment)|| BaseHelpUtils.isNullOrEmpty(attachmentId) ||BaseHelpUtils.isNullOrEmpty(attachmentName)){
			SC.say("提示","附件不能空");
			return false;
		}
        return true;
    }

    @Override
    public Set<String> getItemNames() {
        Set<String> res = new HashSet<>();
        res.add("detailProjectStage");
        return res;
    }

    @Override
    public java.util.Map getValuesAsMap() {
        java.util.Map param = new java.util.HashMap();
        ListGridRecord[] rows = SourceGrid.getSelectedRecords();
        MapUtils.convertRecordToMap(SourceGrid.getDataSource(), rows, param, "detailProjectStage");
        param.put("projectIntegralLeft", BaseHelpUtils.getBigDecimalValue(projectIntegralLeftItem.getValue()));
        return param;
    }


}
