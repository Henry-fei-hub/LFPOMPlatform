package com.pomplatform.client.contractinfo.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.PermissionControl;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.upload.panel.CommonUploadWindow;
import com.pomplatform.client.upload.panel.UploadCallBack;
import com.pomplatform.client.workflow.commonNormalReimbursement.datasource.DSNormalReimbursementWithDepartment;
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
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author CL
 */
public class CustomContractMainPanel extends VLayout implements HasHandlers {
	private static final Logger __logger = Logger.getLogger("");
    public static CustomChildContractPanel childContract;
//    public static CustomConsiderationPanel consideration;
    public static CustomParentContractPanel parentContractpanel;
    public static Label childContractTitle;
//    public static Label considerationTitle;
    public static DynamicForm __infoForm;
    public static TextAreaItem subContractRemark;//整个子订单的备注
    public static TextAreaItem subContractCarouselRemark;//每个子订单的备注
    
    //附件
	private final LinkItem attachmentItem;
	private final TextItem attachmentIdItem;
	private final TextItem attachmentNameItem;
    
	public CustomContractMainPanel(int contractId, Record record, int flowStatus, Boolean isShow) {
		final int __contractId = contractId;
		final int __flowStatus = flowStatus;
		childContractTitle = new Label("子订单列表");
//		considerationTitle = new Label("报价单详情");
		childContract = new CustomChildContractPanel(flowStatus);
//		consideration = new CustomConsiderationPanel();
        setHeight100();
        setMembersMargin(5);

        //主合同gird
        VLayout parentContract = new VLayout(5);
        Label parentContractTitle = new Label("主订单基本信息");
        parentContractTitle.setHeight(42);
        parentContractTitle.setAlign(Alignment.CENTER);
        parentContract.addMember(parentContractTitle);
        parentContractpanel = new CustomParentContractPanel();
        parentContractpanel.setRecord(record);
        parentContractpanel.startEdit();
        parentContract.addMember(parentContractpanel);

        //子合同grid
        VLayout childContractPanel = new VLayout(5);
        childContractPanel.setHeight("60%");
        childContractTitle.setHeight(30);
        childContractTitle.setAlign(Alignment.CENTER);
        childContractPanel.addMember(childContractTitle);
        childContract.setContractId(contractId);
        childContract.startEdit();
        childContractPanel.addMember(childContract);
        
        HLayout myVLayout=new HLayout(5);
        myVLayout.setWidth100();
        myVLayout.setHeight("40%");
        
        
        //报价单grid
//        VLayout considerationPanel = new VLayout(5);
//        considerationPanel.setWidth("60%");
//        considerationPanel.setHeight100();
//        considerationTitle.setHeight(30);
//        considerationTitle.setAlign(Alignment.CENTER);
//        considerationPanel.addMember(considerationTitle);
//        consideration.setSubContractId(0);
//        consideration.startEdit();
//        considerationPanel.addMember(consideration);
        
        //添加备注框
        __infoForm = new DynamicForm();
		__infoForm.setWidth100();
		__infoForm.setHeight("100%");
		__infoForm.setDataSource(DSNormalReimbursementWithDepartment.getInstance());
		__infoForm.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__infoForm);
		HLayout formHLayout=new HLayout(5);
		formHLayout.setWidth("40%");
		formHLayout.setHeight100();
		formHLayout.setLayoutTopMargin(40);
        formHLayout.addMember(__infoForm);
		
		subContractRemark=new TextAreaItem("subContractRemark","订单备注");
		subContractRemark.setDisabled(true);
		subContractRemark.setWidth("*");
		
		subContractCarouselRemark=new TextAreaItem("subContractCarouselRemark","子订单备注");
		subContractCarouselRemark.setDisabled(true);
		subContractCarouselRemark.setWidth("*");
		
		
		attachmentItem = new LinkItem("attachment");
		attachmentItem.setWidth("*");
		attachmentItem.setCanEdit(false);
		
		attachmentIdItem = new TextItem("attachmentId", "附件ID");
		attachmentIdItem.setHidden(true);
		
		attachmentNameItem = new TextItem("attachmentName", "附件名称");
		attachmentNameItem.setHidden(true);
		 
		__infoForm.setFields(subContractCarouselRemark,subContractRemark,attachmentItem,attachmentIdItem,attachmentNameItem);
		
        myVLayout.addMember(formHLayout);
//        myVLayout.addMember(considerationPanel);
        
        String title ="";
        String permission ="";
        switch (flowStatus) {
		case 1:
			title = "提交";
			permission =ERPPermissionStatic.CONTRACT_INFO_MANAGEMENT;
			break;
		case 2:
			title = "提交";
			permission =ERPPermissionStatic.CONTRACT_INFO_MANAGEMENT;
			break;
		case 3:
			permission =ERPPermissionStatic.YUNY_PRICE_AGREE_INFO_BUTTON;
			title = "同意";
			break;
		}
        IButton submitButton = PermissionControl.createPermissionButton(title, permission);
        submitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String titleB ="";
		        switch (__flowStatus) {
				case 1:
					titleB = "提交";
					break;
				case 2:
					titleB = "提交";
					break;
				case 3:
					titleB = "同意";
					break;
				}
		        
//				if (BaseHelpUtils.isNullOrEmpty(__infoForm.getItem("attachmentId").getValue())||BaseHelpUtils.isNullOrEmpty( __infoForm.getItem("attachment").getValue())) {
//					SC.say("提示", "附件不能为空");
//					return;
//				}
		        
				SC.ask("提示", "确认"+ titleB +"?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							
							Map<String, Object> param = new HashMap<>();
							param.put("opt_type", "saveContentInfo");
							param.put("employeeId", ClientUtil.getEmployeeId());
							param.put("contractId", __contractId);
							param.put("attachmentId", __infoForm.getItem("attachmentId").getValue());
							param.put("attachment", __infoForm.getItem("attachment").getValue());
							
							DBDataSource.callOperation("EP_CustomSubContractHandler", param, new DSCallback() {
								@Override
								public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
									// 获取子合同主键
									Map<String, Object> params = new HashMap<>();
									params.put("contractId", __contractId);
									params.put("opt_type", "goFlowMainContract");
									params.put("flowStatus", __flowStatus + 1);
									params.put("attachmentId", __infoForm.getItem("attachmentId").getValue());
									params.put("attachment", __infoForm.getItem("attachment").getValue());
									DBDataSource.callOperation("EP_CustomMainContractHandler", "", params,
										new DSCallback() {
											@Override
											public void execute(DSResponse dsResponse, Object data,
													DSRequest dsRequest) {
												if (dsResponse.getStatus() > 0) {
													getParentWindow().destroy();
						                            DataEditEvent dee = new DataEditEvent();
						                            fireEvent(dee);
												}else{
													ClientUtil.displayErrorMessage(dsResponse);
												}
											}
										});
								}
							});
						}
					}
				});
				
			}
		});
        IButton cancelButton = PermissionControl.createPermissionButton("不同意", ERPPermissionStatic.YUNY_PRICE_NOT_AGREE_INFO_BUTTON);
        cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "确认不同意?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if(value){
							// 获取子合同主键
							Map<String, Object> params = new HashMap<>();
							params.put("contractId", __contractId);
							params.put("opt_type", "goFlowMainContract");
							params.put("flowStatus", 0);
							DBDataSource.callOperation("EP_CustomMainContractHandler", "", params,
								new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data,
											DSRequest dsRequest) {
										if (dsResponse.getStatus() > 0) {
											getParentWindow().destroy();
				                            DataEditEvent dee = new DataEditEvent();
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
						}
					}
				});
				
			}
		});
        
        IButton uploadButton= new IButton("上传启动函", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new CommonUploadWindow("上传启动函", false, 100, null, 1, new UploadCallBack() {
					
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
        
        if (Browser.getIsDesktop()) {
            HLayout mainPanel = new HLayout(10);
            mainPanel.setWidth100();
            mainPanel.setHeight100();
            
            VLayout childAndconsiderationPanel = new VLayout();
            childAndconsiderationPanel.setWidth("84%");
            childAndconsiderationPanel.setHeight100();
            
           //只查看与可编辑
            if(!isShow){
            	childContractPanel.setHeight("60%");
//            	considerationPanel.setHeight100();
            }
            
            childAndconsiderationPanel.addMember(childContractPanel);
            childAndconsiderationPanel.addMember(myVLayout);
            if(!isShow){
            	if(__flowStatus == 3){
            		HLayout hButton = new HLayout();
            		hButton.setHeight("12%");
            		hButton.setWidth("20%");
            		hButton.setLayoutTopMargin(10);
            		hButton.setLayoutLeftMargin(104);
//            		hButton.addMember(submitButton);
            		
            		HLayout submitLayout=new HLayout();
            		submitLayout.addMember(submitButton);
              		hButton.addMember(submitLayout);
            		
            		HLayout cb=new HLayout();
            		cb.setLayoutLeftMargin(30);
            		cb.setLayoutRightMargin(30);
            		cb.addMember(cancelButton);
            		hButton.addMember(cb);
            		
            		HLayout updataLayout=new HLayout();
            		updataLayout.addMember(uploadButton);
              		hButton.addMember(updataLayout);

            		
            		childAndconsiderationPanel.addMember(hButton);
            	}else{
            		childAndconsiderationPanel.addMember(submitButton);
            	}
            }
            parentContract.setHeight100();
            parentContract.setWidth("16%");
            mainPanel.addMember(parentContract);
            mainPanel.addMember(childAndconsiderationPanel);
            addMember(mainPanel);
        } else {
            parentContract.setWidth100();
            parentContract.setHeight("30%");
            addMember(parentContract);
            
            childContractPanel.setWidth100();
            childContractPanel.setHeight("35%");
            addMember(childContractPanel);
//            considerationPanel.setWidth100();
//            considerationPanel.setHeight("35%");
//            if(!isShow){
//            	childContractPanel.setHeight("33%");
//            	considerationPanel.setHeight("33%");
//            }
            addMember(myVLayout);
            
            //可编辑
            if(!isShow){
            	addMember(submitButton);
            }
        }
    }
	private Window parentWindow;
	
    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }
    
    public Window getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }
    
    
	public static void onLoadSubContractRemark(int contractId){
		// 先将数据保存数据库
		Map<String, Object> params = new HashMap<>();
		params.put("contractId", contractId);
		params.put("opt_type", "onLoadSubContractRemark");
		DBDataSource.callOperation("EP_CustomSubContractHandler", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				SC.debugger();
				if (dsResponse.getStatus() >= 0&&dsResponse.getData().length>0) {
					Record r = dsResponse.getData()[0];
					__infoForm.getItem("attachmentName").setValue(BaseHelpUtils.getString(r.getAttribute("attachmentName")));
					__infoForm.getItem("attachmentId").setValue(BaseHelpUtils.getString(r.getAttribute("attachmentId")));
					__infoForm.getItem("attachment").setValue(BaseHelpUtils.getString(r.getAttribute("attachment")));
					__infoForm.getItem("subContractRemark").setValue(BaseHelpUtils.getString(r.getAttribute("remark")));
				} else {
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
	}
    
    
}
