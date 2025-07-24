package com.pomplatform.client.ja.ht.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.google.gwt.user.client.ui.Button;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.Browser;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 */
public class CustomAddReQuotationMainPanel extends VLayout {
	private static Logger __LOGGER = Logger.getLogger("");
    public static CustomOutDesignConsiderationPanel outDesignConsiderationPanel;
    public static CustomOutRedesignConsiderationPanel outRedesignConsiderationPanel;
    public static Label outDesignConsiderationTitle;
    public static Label outRedesignConsiderationTitle;
    
	public CustomAddReQuotationMainPanel(String infoCode,String projectCode,int outQuotationId,Double moneySum) {
		CustomAddReQuotationMainPanel.infoCode=infoCode;
		CustomAddReQuotationMainPanel.projectCode=projectCode;
		CustomAddReQuotationMainPanel.outQuotationId=outQuotationId;
		CustomAddReQuotationMainPanel.moneySum=moneySum;
		__LOGGER.info("CustomAddReQuotationMainPanel=====infoCode"+infoCode+"projectCode="+projectCode+"outQuotationId"+outQuotationId);
		outDesignConsiderationTitle = new Label("报价单子项(报价单总金额："+moneySum+" 元)");
		outDesignConsiderationTitle.setHeight(30);
		outDesignConsiderationTitle.setAlign(Alignment.CENTER);
		outRedesignConsiderationTitle = new Label("(初步)拆分价");
		outRedesignConsiderationTitle.setHeight(30);
		outRedesignConsiderationTitle.setAlign(Alignment.CENTER);
//		outDesignConsiderationPanel = new CustomOutDesignConsiderationPanel(infoCode, projectCode, outQuotationId,moneySum);
//		outDesignConsiderationPanel.startEdit();
		outRedesignConsiderationPanel = new CustomOutRedesignConsiderationPanel(infoCode, projectCode,outQuotationId,moneySum,1);
		outRedesignConsiderationPanel.startEdit();
		 
		setHeight100();
		setMembersMargin(5);
		
		
		//最大的box 
		HLayout bigBoxPanel = new HLayout(10);
		bigBoxPanel.setWidth100();
		bigBoxPanel.setHeight100();
		//left box
		HLayout leftGridAndBtnHLayout = new HLayout(10);
		
		VLayout leftVLayout = new VLayout(10);
		leftVLayout.addMember(outDesignConsiderationTitle);
		leftVLayout.setWidth("50%");
		HLayout leftGridBoxPanel = new HLayout(10);
		leftGridBoxPanel.setWidth("94%");
		leftGridBoxPanel.setHeight100();
		
		VLayout leftBtnBoxPanel = new VLayout(10); 
		leftBtnBoxPanel.setHeight100();
		leftBtnBoxPanel.setWidth("6%");
		
		IButton refreshButton1 = new IButton("刷新");
		refreshButton1.setIcon("[SKIN]/actions/refresh.png");
		refreshButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				outDesignConsiderationPanel.startEdit();
			}
		});
		IButton btnAAddOutQ=new IButton("新增报价项");
		btnAAddOutQ.setIcon("[SKIN]/actions/add.png");
		btnAAddOutQ.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			    
			 ListGridRecord record = new ListGridRecord();
			 record.setAttribute("infoCode", CustomAddReQuotationMainPanel.infoCode);
			 record.setAttribute("projectCode", CustomAddReQuotationMainPanel.projectCode);
			 record.setAttribute("outQuotationId", CustomAddReQuotationMainPanel.outQuotationId);
			 record.setAttribute("designArea", 0);
			 record.setAttribute("designUnitPrice", 0);
			 record.setAttribute("moneySum", 0);
			
			 ListGridRecord[] rlist = outDesignConsiderationPanel.SourceGrid.getRecords();
			 int len = rlist.length;
			 ListGridRecord[] resultList = new ListGridRecord[len + 1];
			 int i = 0;
			 for (ListGridRecord e : rlist) {
			 resultList[i] = e;
			 i++;
			 }
			 resultList[len] = record;
			 outDesignConsiderationPanel.SourceGrid.setData(resultList);
			 outDesignConsiderationPanel.SourceGrid.redraw();
			}
		});
		IButton btnDelOutQ=new IButton("删除");
		btnDelOutQ.setIcon("[SKIN]/actions/remove.png");
		btnDelOutQ.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = outDesignConsiderationPanel.SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count<=0){
					SC.say("请选择要删除的数据");
					return;
				}
				//选中的要删除的ids
			    StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
				}
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "deleteOutDesignConsideration");
				
				__LOGGER.info(" deleteOutDesignConsideration ids="+ids);
				condition.put("ids", ""+ids);
				condition.put("outQuotationId", selected[0].getAttribute("outQuotationId"));
				condition.put("infoCode", selected[0].getAttribute("infoCode"));
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							outDesignConsiderationPanel.startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
//		将主报价单的子项转到(初步)拆分价表中去
		IButton addDesigConsiderationListBtn=new IButton("转为拆分价");
		addDesigConsiderationListBtn.setIcon("[SKIN]/actions/add.png");
		addDesigConsiderationListBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = outDesignConsiderationPanel.SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count<=0){
					SC.say("请选择要转移的数据");
					return;
				}
				//选中的ids
			    StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outDesignConsiderationId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
				}
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "addRedesigneConsiderationList");
				condition.put("ids", ""+ids);
				condition.put("infoCode", selected[0].getAttribute("infoCode"));//信息编号
				condition.put("projectCode", selected[0].getAttribute("projectCode"));//项目编号
				condition.put("moneySum",CustomAddReQuotationMainPanel.moneySum);//报价单的总价
				condition.put("outQuotationId",CustomAddReQuotationMainPanel.outQuotationId);//报价单id
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							outRedesignConsiderationPanel.startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		//报价单子项grid
		leftGridBoxPanel.addMember(outDesignConsiderationPanel);
		leftBtnBoxPanel.setMargin(10);
		leftBtnBoxPanel.addMember(refreshButton1);
		leftBtnBoxPanel.addMember(btnAAddOutQ);
		leftBtnBoxPanel.addMember(btnDelOutQ);
		leftBtnBoxPanel.addMember(addDesigConsiderationListBtn);
		
		leftGridAndBtnHLayout.addMember(leftGridBoxPanel);
		leftGridAndBtnHLayout.addMember(leftBtnBoxPanel);
		leftVLayout.addMember(leftGridAndBtnHLayout);
		bigBoxPanel.addMember(leftVLayout);
		
		//right box
		HLayout rightGridAndBtnHLayout = new HLayout(10);
		
		HLayout rightGridBoxPanel = new HLayout(10);
		rightGridBoxPanel.setWidth("94%");
		rightGridBoxPanel.setHeight100();
		VLayout rightBtnBoxPanel = new VLayout(10);
		rightBtnBoxPanel.setWidth("6%");
		rightBtnBoxPanel.setHeight100();
		 
		IButton refreshButton2 = new IButton("刷新");
		refreshButton2.setIcon("[SKIN]/actions/refresh.png");
		refreshButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				outRedesignConsiderationPanel.startEdit();
			}
		});
		IButton btnAAddQ=new IButton("新增拆分价");
		btnAAddQ.setIcon("[SKIN]/actions/add.png");
		btnAAddQ.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			    
			 ListGridRecord record = new ListGridRecord();
			 record.setAttribute("infoCode", CustomAddReQuotationMainPanel.infoCode);
			 record.setAttribute("projectCode", CustomAddReQuotationMainPanel.projectCode);
			 record.setAttribute("designArea", 0);
			 record.setAttribute("designUnitPrice", 0);
			 record.setAttribute("moneySum", 0);
			
			 ListGridRecord[] rlist = outRedesignConsiderationPanel.SourceGrid.getRecords();
			 int len = rlist.length;
			 ListGridRecord[] resultList = new ListGridRecord[len + 1];
			 int i = 0;
			 for (ListGridRecord e : rlist) {
			 resultList[i] = e;
			 i++;
			 }
			 resultList[len] = record;
			 outRedesignConsiderationPanel.SourceGrid.setData(resultList);
			 outRedesignConsiderationPanel.SourceGrid.redraw();
			}
		});
		IButton btnDelQ=new IButton("删除");
		btnDelQ.setIcon("[SKIN]/actions/remove.png");
		btnDelQ.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = outRedesignConsiderationPanel.SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count<=0){
					SC.say("请选择要删除的数据");
					return;
				}
				//选中的要删除的ids
			    StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outRedesignConsiderationId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("outRedesignConsiderationId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
				}
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "deleteOutRedDesignConsideration");
				condition.put("ids", ""+ids);
				condition.put("outQuotationId", selected[0].getAttribute("outQuotationId"));
				condition.put("infoCode", selected[0].getAttribute("infoCode"));
				DBDataSource.callOperation("EP_CustomOutRedesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							outRedesignConsiderationPanel.startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		VLayout rightVLayout = new VLayout(10);
		rightVLayout.setWidth("50%");
		rightVLayout.addMember(outRedesignConsiderationTitle);
		rightGridBoxPanel.addMember(outRedesignConsiderationPanel);
		
		rightBtnBoxPanel.setMargin(10);
		rightBtnBoxPanel.addMember(refreshButton2);
		rightBtnBoxPanel.addMember(btnAAddQ);
		rightBtnBoxPanel.addMember(btnDelQ);
		rightGridAndBtnHLayout.addMember(rightGridBoxPanel);
		rightGridAndBtnHLayout.addMember(rightBtnBoxPanel);
		rightVLayout.addMember(rightGridAndBtnHLayout);
		bigBoxPanel.addMember(rightVLayout);
		
		
		if (Browser.getIsDesktop()) {
			addMember(bigBoxPanel);
		} else {
			addMember(bigBoxPanel);
		}
    }
	private static  String infoCode;
	private static String projectCode;
	private static int outQuotationId;
	private static double moneySum;

	 
}
