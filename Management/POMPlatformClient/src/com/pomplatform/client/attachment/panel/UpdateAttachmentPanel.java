package com.pomplatform.client.attachment.panel;

import static com.delicacy.client.ui.GenericWizadWindow.BACKGROUND_COLOR;
import static com.delicacy.client.ui.GenericWizadWindow.BORDER_STYLE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class UpdateAttachmentPanel extends AbstractProcessPanel implements HasHandlers{
	
	private Integer processType;
	
	private HLayout hRight;
	
	private HLayout hLeft;
	
	private Boolean updateFlag = true;
	
	public UpdateAttachmentPanel(){
		
	}
	
	public UpdateAttachmentPanel(Boolean flag){
		this.updateFlag = flag;
	}
	
	@Override
	public void initComponents() {
        //设置页面属性
        setWidth100();
        setHeight100();

        __pages = getPages();
        for (AbstractWizadPage __page : __pages) {
            if (__page.getPageMode() != AbstractWizadPage.PAGE_MODE_ADD) {
                setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
            }
            __page.setBorder(BORDER_STYLE);
            __page.setPadding(5);
            __page.setBackgroundColor(BACKGROUND_COLOR);
        }
        VLayout mainLayout = new VLayout();
        mainLayout.setOverflow(Overflow.HIDDEN);
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        switch (__pageMode) {
            case PAGE_DISPLAY_NAV:
                __pageNum = getPageCount();
                customLayout = new HLayout();
                customLayout.setWidth100();
                customLayout.setHeight100();
                customLayout.setPadding(5);
                customLayout.addMember(__pages.get(getCurrentPage()));
                mainLayout.addMember(customLayout);
                break;
            default:
                __pageNum = 1;
                HLayout hLayout = new HLayout();
                hLayout.setWidth100();
                hLayout.setHeight100();
                hLayout.setPadding(5);
                hLeft = new HLayout();
                hLeft.setWidth("30%");
                hLeft.setHeight100();
                hLeft.setPadding(5);
                hRight = new HLayout();
                hRight.setWidth("70%");
                hRight.setHeight100();
                hRight.setPadding(5);
                VLayout vRight = new VLayout();
                vRight.setWidth100();
                vRight.setHeight100();
                vRight.setPadding(5);
                int i = 0;
                for (AbstractWizadPage __page : __pages) {
                	if(i == 0){
                		hLeft.addMember(__page);
                	}else{
                		vRight.addMember(__page);
                	}
                	i++;
                }
                hRight.addMember(vRight);
                hLayout.addMember(hLeft);
                hLayout.addMember(hRight);
                hLayout.setDisabled(!updateFlag);
                mainLayout.addMember(hLayout);
                //底部操作按钮
                ToolStrip btnLayout = new ToolStrip();
        		btnLayout.setVPolicy(LayoutPolicy.FILL);
        		btnLayout.setPadding(5);
        		btnLayout.setHeight(40);
        		btnLayout.setWidth100();
        		btnLayout.addFill();
        		IButton saveBtn = new IButton("确认修改");
        		saveBtn.setIcon("[SKIN]/actions/save.png");
        		if(updateFlag){
        			btnLayout.addMember(saveBtn);
    			};
        		btnLayout.addSpacer(10);
        		saveBtn.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						if(checkData(null)){
							SC.ask("确认修改?", new BooleanCallback() {
								
								@Override
								public void execute(Boolean value) {
									if(value){
										Map params = new HashMap<>();
										List<AbstractWizadPage> checkPages = __pages;
										for (AbstractWizadPage abstractWizadPage : checkPages) {
											params.putAll(abstractWizadPage.getValuesAsMap());
										}
										params.put("opt_type", "passAfterBindAttachment");
										DBDataSource.callOperation("EP_CustomAttachmentWorkProcess", params, new DSCallback() {
											
											@Override
											public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
												if(dsResponse.getStatus() > 0){
													getFatherWindow().destroy();
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
						
					}
				});
        		
        		IButton cancelBtn = new IButton(updateFlag ? "取消" : "关闭");
        		cancelBtn.setIcon("[SKIN]/actions/close.png");
        		btnLayout.addMember(cancelBtn);
        		btnLayout.addSpacer(10);
        		cancelBtn.addClickHandler(new ClickHandler() {

        			@Override
        			public void onClick(ClickEvent event) {
        				if(updateFlag){
        					SC.ask("提示", "确认取消?取消后所有进行的操作都会被还原！！！", new BooleanCallback() {
            					@Override
            					public void execute(Boolean value) {
            						if (value) {
            							getFatherWindow().destroy();
            						}
            					}
            				});
        				}else{
        					getFatherWindow().destroy();
        				}
        			}
        		});
        		mainLayout.addMember(btnLayout);
                break;
        }
        addMember(mainLayout);
    }

	@Override
	public void load() {
		if (getBusinessId() == null)
			return;
		Map params = new HashMap();
		params.put("attachmentManageId", getBusinessId());
		DBDataSource.callOperation("ST_AttachmentManage", "find", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					setData(dsResponse.getData()[0]);
					if (__pages == null)
						__pages = getPages();
					for (AbstractWizadPage wp : __pages) {
						wp.setRecord(getData());
						wp.startEdit();
					}
				}
			}
		});
	}

	@Override
	public boolean checkData(Map data) {
		List<AbstractWizadPage> checkPages = __pages;
		boolean flag = true;
		for (AbstractWizadPage abstractWizadPage : checkPages) {
			if (!abstractWizadPage.checkData()) {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public int getPageCount() {
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		UpdateAttachmentLinkContractReceivablesPanel alrPanel = new UpdateAttachmentLinkContractReceivablesPanel();
		alrPanel.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		UpdateAttachmentLinkInvoiceApplysPanel aliaPanel = new UpdateAttachmentLinkInvoiceApplysPanel();
		aliaPanel.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		UpdateAttachmentLinkInvoicesPanel aliPanel  = new UpdateAttachmentLinkInvoicesPanel();
		aliPanel.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		AttachmentUpdateForm mainForm = new AttachmentUpdateForm();
		mainForm.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		aliPanel.setMainInfoPage(mainForm);
		alrPanel.setMainInfoPage(mainForm);
		mainForm.setAlrPanel(alrPanel);
		mainForm.setAliaPanel(aliaPanel);
		mainForm.setAliPanel(aliPanel);
		mainForm.addDataEditedHandler(new DataEditedHandler() {
			
			@Override
			public void onDataEdited(DataEditEvent event) {
				Record record = event.getData();
				if(record.getAttributeAsBoolean("flag")){
					hRight.show();
				}else{
					hRight.hide();
				}
				DataEditEvent dee = new DataEditEvent();
				dee.setData(record);
				fireEvent(dee);
			}
		});
		res.add(mainForm);
		res.add(alrPanel);
		res.add(aliaPanel);
		res.add(aliPanel);
		return res;
	}

	public Integer getProcessType() {
		return processType;
	}

	public void setProcessType(Integer processType) {
		this.processType = processType;
	}
	
	private Window fatherWindow;

	public Window getFatherWindow() {
		return fatherWindow;
	}

	public void setFatherWindow(Window fatherWindow) {
		this.fatherWindow = fatherWindow;
	}

	protected final HandlerManager handlerManager = new HandlerManager(this);
	protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
}
