package com.pomplatform.client.ja.ht.panel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.user.client.ui.Button;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
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
public class CustomAddQuotationMainPanel2 extends VLayout {
	private static Logger __LOGGER = Logger.getLogger("");
    public static CustomOutAllDesignConsiderationPanel outAllDesignConsiderationPanel;
//    public static CustomDesignConsiderationPanel designConsiderationPanel;
    public static com.pomplatform.client.treedesignconsideration.panel.CustomDesignConsiderationPanel designConsiderationPanel;
    
    public static Label outRedesignConsiderationTitle;
    public static Label designConsiderationTitle;
    
	public CustomAddQuotationMainPanel2(String infoCode,String projectCode) {
		CustomAddQuotationMainPanel2.infoCode=infoCode;
		CustomAddQuotationMainPanel2.projectCode=projectCode;
		CustomAddQuotationMainPanel2.outQuotationId=outQuotationId;
		outRedesignConsiderationTitle = new Label("报价单");
		outRedesignConsiderationTitle.setHeight(30);
		outRedesignConsiderationTitle.setAlign(Alignment.CENTER);
		designConsiderationTitle = new Label("拆分价");
		designConsiderationTitle.setHeight(6);
		designConsiderationTitle.setAlign(Alignment.CENTER);
		outAllDesignConsiderationPanel = new CustomOutAllDesignConsiderationPanel(infoCode, projectCode, outQuotationId);
		outAllDesignConsiderationPanel.startEdit();
		
		 
		designConsiderationPanel = new com.pomplatform.client.treedesignconsideration.panel.CustomDesignConsiderationPanel(infoCode,projectCode,outQuotationId);
		designConsiderationPanel.startEdit();
		 
		setHeight100();
		setMembersMargin(5);
		
		
		//最大的box 
		VLayout bigBoxPanel = new VLayout(10);
		bigBoxPanel.setWidth100();
		bigBoxPanel.setHeight100();
		//top box
		HLayout topGridAndBtnVLayout = new HLayout(10);
		topGridAndBtnVLayout.setHeight("50%");
		
		VLayout leftVLayout = new VLayout(10);
		leftVLayout.addMember(outRedesignConsiderationTitle);
		leftVLayout.setWidth100();
		HLayout leftGridBoxPanel = new HLayout(10);
		leftGridBoxPanel.setWidth("94%");
		leftGridBoxPanel.setHeight100();
		
		VLayout leftBtnBoxPanel = new VLayout(10); 
		leftBtnBoxPanel.setWidth("6%");
		leftBtnBoxPanel.setHeight100();
		
		IButton refreshButton1 = new IButton("刷新");
		refreshButton1.setIcon("[SKIN]/actions/refresh.png");
		refreshButton1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				outAllDesignConsiderationPanel.startEdit();
			}
		});
//		将主报价单的子项转到(初步)拆分价表中去
		IButton addDesigConsiderationListBtn=new IButton("转为拆分价");
		addDesigConsiderationListBtn.setIcon("[SKIN]/actions/add.png");
		addDesigConsiderationListBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = outAllDesignConsiderationPanel.SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count==1){
					SC.say("请选择一条要转移的数据");
					return;
				}
				
				//选中的ids
			    StringBuilder ids=new StringBuilder();
			    //类别  2装饰 1配合
			    int category=0;
				for(int i=0;i<selected.length;i++){
					int type=BaseHelpUtils.getIntValue(selected[i].getAttribute("jobMix"));
					if(type==2){
						SC.say("合计项不能操作");
						return;//合计
					}else if(type==3){
						return;//最终报价单
					}
					
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
					
					category=BaseHelpUtils.getIntValue(selected[i].getAttribute("optionType"));
				}
				//2装饰 
				if(category==2){
					SC.say("类别 装饰  需要拆分");
				}else{
					Map<String, Object> condition = new HashMap<>();
					condition.put("opt_type", "addDesigneConsiderationList");
					condition.put("ids", ""+ids);
					condition.put("infoCode", selected[0].getAttribute("infoCode"));//信息编号
					condition.put("projectCode", selected[0].getAttribute("projectCode"));//项目编号
					condition.put("employeeId",ClientUtil.getEmployeeId());//操作人id
					
					DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
						@Override
						public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							if (dsResponse.getStatus() >= 0) {
								designConsiderationPanel.startEdit();
							}else{
								ClientUtil.displayErrorMessage(dsResponse);
							}
						}
					});
				}
			}
		});
		//报价单导出
		IButton exportOutDeCon=new IButton("导出");
		exportOutDeCon.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("infoCode", CustomAddQuotationMainPanel2.infoCode);
				DBDataSource.downloadFile("DW_CustomOutDesigneConsiderationHandler", condition);
			}
		});

		
		//报价单子项grid
		leftGridBoxPanel.addMember(outAllDesignConsiderationPanel);
		leftBtnBoxPanel.setMargin(10);
		leftBtnBoxPanel.addMember(refreshButton1);
		leftBtnBoxPanel.addMember(addDesigConsiderationListBtn);
		leftBtnBoxPanel.addMember(exportOutDeCon);
		
		topGridAndBtnVLayout.addMember(leftGridBoxPanel);
		topGridAndBtnVLayout.addMember(leftBtnBoxPanel);
		leftVLayout.addMember(topGridAndBtnVLayout);
		bigBoxPanel.addMember(leftVLayout);
		
		//bottom box
		HLayout bottomGridAndBtnVLayout = new HLayout(10);
		bottomGridAndBtnVLayout.setHeight("50%");
		VLayout rightGridBoxPanel = new VLayout(10);
		rightGridBoxPanel.setWidth("94%");
		rightGridBoxPanel.setHeight100();
		VLayout rightBtnBoxPanel = new VLayout(10);
		rightBtnBoxPanel.setWidth("6%");
		rightBtnBoxPanel.setHeight100();
		
		 
		IButton refreshButton2 = new IButton("刷新");
		refreshButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				designConsiderationPanel.startEdit();
			}
		});
		
		IButton closePWButton = new IButton("关闭");
		closePWButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "checkCFJData");
				condition.put("infoCode", CustomAddQuotationMainPanel2.infoCode);
				
				DBDataSource.callOperation("EP_CustomOutDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							pw.destroy();
						}else{
							SC.ask(BaseHelpUtils.getString(dsResponse.getErrors().get("errorMsg")+" 还否还是要关闭"),new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(value){
										pw.destroy();
									}
								}
							});
							
						}
					}
				});
				
			}
		});
		
		
		
		
		
		IButton btnAAddQUp=new IButton("向上新增");
		btnAAddQUp.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			    
			 ListGridRecord record = new ListGridRecord();
			 record.setAttribute("infoCode", CustomAddQuotationMainPanel2.infoCode);
			 record.setAttribute("projectCode", CustomAddQuotationMainPanel2.projectCode);
			 record.setAttribute("businessType",1);//默认商业
			 record.setAttribute("optionType",1);//默认专项
			 record.setAttribute("employeeId",ClientUtil.getEmployeeId());//操作人
			 ListGridRecord[] rlist = designConsiderationPanel.SourceGrid.getRecords();
			 //将原数据放入List中保存起来
			 List<ListGridRecord> putList=new LinkedList<>();
			 int x=0,len=rlist.length;
			 for(ListGridRecord l:rlist){
				 putList.add(x,l);
				 x++;
			 }
			//合计的索引
			 int hjIndex=putList.indexOf(rlist[len-1]);
			 //选中的数据
			 ListGridRecord[] selected = designConsiderationPanel.SourceGrid.getSelectedRecords();
			 int count=selected.length;
			 int index=0;
			 if(count<=0){//没有选中顶部追加
				 putList.add(0,record);
			 }else{//选中向上追加
				 index=putList.indexOf(selected[0]);
				 if(hjIndex==index){
					 SC.say("合计项选中不能向上添加行");
					 return;
				 }
				 record.setAttribute("outQuotationId",selected[0].getAttributeAsInt("outQuotationId"));//报价单的id
				 record.setAttribute("businessType",selected[0].getAttributeAsInt("businessType"));
				 record.setAttribute("optionType",selected[0].getAttributeAsInt("optionType"));
				 record.setAttribute("orderNum",selected[0].getAttributeAsInt("orderNum"));
				 putList.add(index==0?0:(index--),record);
				 index++;
			 }
			 
			 for(int i=0;i<putList.size();i++){
				 rlist[i]=putList.get(i);
			 }
			 
			 
			 designConsiderationPanel.SourceGrid.setData(rlist);
			 designConsiderationPanel.SourceGrid.redraw();
			 designConsiderationPanel.SourceGrid.startEditing(index);
			 
			}
		});
		IButton btnAAddQDown=new IButton("向下新增");
		btnAAddQDown.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			    
			 ListGridRecord record = new ListGridRecord();
			 record.setAttribute("infoCode", CustomAddQuotationMainPanel2.infoCode);
			 record.setAttribute("projectCode", CustomAddQuotationMainPanel2.projectCode);
			 record.setAttribute("businessType",1);//默认商业
			 record.setAttribute("optionType",1);//默认专项
			 record.setAttribute("employeeId",ClientUtil.getEmployeeId());//操作人
			 
			 ListGridRecord[] rlist = designConsiderationPanel.SourceGrid.getRecords();
			 //将原数据放入List中保存起来
			 List<ListGridRecord> putList=new LinkedList<>();
			 int x=0,len=rlist.length;
			 for(ListGridRecord l:rlist){
				 putList.add(x,l);
				 x++;
			 }
			 //合计的索引
			 int hjIndex=putList.indexOf(rlist[len-1]);
			 
			 //选中的数据
			 ListGridRecord[] selected = designConsiderationPanel.SourceGrid.getSelectedRecords();
			 int count=selected.length;
			 int index=0;
			 if(count<=0){//没有选中顶部追加
				 putList.add(0,record);
			 }else{//选中向下追加
				 index=putList.indexOf(selected[0]);
				 if(hjIndex==index){
					 SC.say("合计项选中不能向下添加行");
					 return;
				 }
				 index++;
				 record.setAttribute("outQuotationId",selected[0].getAttributeAsInt("outQuotationId"));//报价单的id
				 record.setAttribute("businessType",selected[0].getAttributeAsInt("businessType"));
				 record.setAttribute("optionType",selected[0].getAttributeAsInt("optionType"));
				 record.setAttribute("orderNum",selected[0].getAttributeAsInt("orderNum"));
				 record.setAttribute("onSiteTime",1);//表示是向下添加
				 putList.add(index,record);
			 }
			 
			 for(int i=0;i<putList.size();i++){
				 rlist[i]=putList.get(i);
			 }
			 
			 
			 designConsiderationPanel.SourceGrid.setData(rlist);
			 designConsiderationPanel.SourceGrid.redraw();
			 designConsiderationPanel.SourceGrid.startEditing(index);
			}
		});
		IButton btnDelQ=new IButton("删除");
		btnDelQ.setIcon("[SKIN]/actions/remove.png");
		btnDelQ.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				ListGridRecord[] selected = designConsiderationPanel.SourceGrid.getSelectedRecords();
				int count=selected.length;
				if(count<=0){
					SC.say("请选择要删除的数据");
					return;
				}
				
				//选中的要删除的ids
			    StringBuilder ids=new StringBuilder();
				for(int i=0;i<selected.length;i++){
					int type=BaseHelpUtils.getIntValue(selected[i].getAttribute("jobMix"));
					if(type==2){
						return;//合计
					}else if(type==3){
						return;//最终报价单
					}
					if(BaseHelpUtils.isNullOrEmpty(ids.toString())){
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("designConsiderationId"));
						if(tempId>0){
							ids.append(tempId);
						}
					}else{
						int tempId=BaseHelpUtils.getIntValue(selected[i].getAttribute("designConsiderationId"));
						if(tempId>0){
							ids.append(",");
							ids.append(tempId);
						}
					}
				}
				Map<String, Object> condition = new HashMap<>();
				condition.put("opt_type", "deleteDesignConsideration");
				condition.put("ids", ""+ids);
				 
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", condition, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							designConsiderationPanel.startEdit();
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		IButton upBtn=new IButton("向上");
		upBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = designConsiderationPanel.SourceGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
			    Map params = record.toMap();
				params.put("opt_type", "moveDesignConsideration");
				params.put("moveType", "up");
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							int currentIndex = designConsiderationPanel.SourceGrid.getRowNum(record);
							designConsiderationPanel.SourceGrid.setData(dsResponse.getData());
							designConsiderationPanel.SourceGrid.selectRecord(currentIndex - 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		
		IButton downBtn=new IButton("向下");
		downBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final ListGridRecord record = designConsiderationPanel.SourceGrid.getSelectedRecord();
				if(record == null){
					SC.say("请选择一条数据");
					return;
				}
				Map params = record.toMap();
				params.put("opt_type", "moveDesignConsideration");
				params.put("moveType", "down");
				DBDataSource.callOperation("EP_CustomDesigneConsiderationHandler", params, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() >= 0) {
							int currentIndex = designConsiderationPanel.SourceGrid.getRowNum(record);
							designConsiderationPanel.SourceGrid.setData(dsResponse.getData());
							designConsiderationPanel.SourceGrid.selectRecord(currentIndex + 1);
						}else{
							ClientUtil.displayErrorMessage(dsResponse);
						}
					}
				});
			}
		});
		//拆分价导出
		IButton exportDeCon=new IButton("导出");
		exportDeCon.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> condition = new HashMap<>();
				condition.put("infoCode", CustomAddQuotationMainPanel2.infoCode);
				DBDataSource.downloadFile("DW_CustomDesigneConsiderationHandler", condition);
			}
		});
		
		//拆分价grid
		rightGridBoxPanel.addMember(designConsiderationTitle);
		rightGridBoxPanel.addMember(designConsiderationPanel);
		
		rightBtnBoxPanel.setLayoutTopMargin(30);
		rightBtnBoxPanel.addMember(refreshButton2);
//		rightBtnBoxPanel.addMember(closePWButton);
		rightBtnBoxPanel.addMember(btnAAddQUp);
		rightBtnBoxPanel.addMember(btnAAddQDown);
		rightBtnBoxPanel.addMember(btnDelQ);
		rightBtnBoxPanel.addMember(upBtn);
		rightBtnBoxPanel.addMember(downBtn);
		rightBtnBoxPanel.addMember(exportDeCon);
		bottomGridAndBtnVLayout.addMember(rightGridBoxPanel);
		bottomGridAndBtnVLayout.addMember(rightBtnBoxPanel);
		bigBoxPanel.addMember(bottomGridAndBtnVLayout);
		
		
		if (Browser.getIsDesktop()) {
			addMember(bigBoxPanel);
		} else {
			addMember(bigBoxPanel);
		}
    }
	private static String infoCode;
	private static String projectCode;
	private static int outQuotationId;
	private PopupWindow pw;

	public PopupWindow getPw() {
		return pw;
	}
	public void setPw(PopupWindow pw) {
		this.pw = pw;
	}
}
