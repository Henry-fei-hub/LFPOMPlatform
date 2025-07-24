package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.reimbursementpackage.panel.NewReimbursementPackagePanel;
import com.pomplatform.client.reimbursementpackage.panel.NewReimbursementSelectRolePackagePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class DoReimbursementpackagePanel extends AbstractWizadPage implements HasHandlers{
	
	
	private final NewReimbursementPackagePanel newReimbursementPackagePanel;//
	
	private final DoSelectReimbursementpackagePanel doSelectReimbursementpackagePanel;//
	
    public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";
    
    
	private static final Logger __LOGGER = Logger.getLogger("");
	

	public DoReimbursementpackagePanel(){
//		setBorder(BORDER_STYLE);
		setBackgroundColor(BACKGROUND_COLOR);
		VLayout mainLayout = new VLayout();
		
		HLayout allH =new HLayout();
		allH.setWidth100();
		allH.setHeight100();
		allH.setMargin(5);
		
		VLayout leftLayout = new VLayout();//左边
		leftLayout.setWidth("50%");
		leftLayout.setHeight100();
		
		VLayout rightLayout = new VLayout();//右边
		rightLayout.setWidth("50%");
		rightLayout.setHeight100();
		
		
		newReimbursementPackagePanel = new NewReimbursementPackagePanel();
		newReimbursementPackagePanel.setWidth100();
		newReimbursementPackagePanel.setHeight100();
		newReimbursementPackagePanel.addDataEditedHandler(new DataEditedHandler() {
			
			@Override
			public void onDataEdited(DataEditEvent event) {
				DelicacyListGrid fromGrid = newReimbursementPackagePanel.getGrid();
				
				if(!fromGrid.anySelected()){
					SC.say("请选择需要进行打包的报销单");
					return;
				}
				DelicacyListGrid toGrid = doSelectReimbursementpackagePanel.sourceGrid;
				Record [] formRecords = fromGrid.getSelectedRecords();
				Record [] toRecords = toGrid.getRecords();
				for (Record record : formRecords) {
					boolean flag = true;
					for (Record record2 : toRecords) {
						String code = record.getAttributeAsString("code").trim();
						String code2 = record2.getAttributeAsString("code").trim();
						if(code.equals(code2)){
							flag = false;
							break;
						}
					}
					if(flag){
						toGrid.addData(record);
					}
					fromGrid.removeData(record);
				}
			}
		});
		leftLayout.addMember(newReimbursementPackagePanel);
		
		doSelectReimbursementpackagePanel= new DoSelectReimbursementpackagePanel();
		doSelectReimbursementpackagePanel.setLeftPackagePanel(newReimbursementPackagePanel);
		doSelectReimbursementpackagePanel.setWidth100();
		doSelectReimbursementpackagePanel.setHeight100();
		rightLayout.addMember(doSelectReimbursementpackagePanel);
		doSelectReimbursementpackagePanel.addDataEditedHandler(new DataEditedHandler() {
			
			@Override
			public void onDataEdited(DataEditEvent event) {
			}
		});
		// 底部工具栏添加
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		IButton splitBtn = new IButton("分别打包");
		btnLayout.addMember(splitBtn);
		btnLayout.addSpacer(10);
		splitBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				splitBtn.setDisabled(true);
				DelicacyListGrid grid = doSelectReimbursementpackagePanel.sourceGrid;
				if (grid.getRecords().length <= 0) {
					SC.say("添加打包数据");
					splitBtn.setDisabled(false);
					return;
				}
				int selectSize = grid.getRecords().length;
				SC.confirm("确认将所选[" + selectSize + "]张报销单分别打成[" + selectSize + "]个包", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(null != value && value){
							final ListGridRecord[] list = grid.getRecords();
//							String companyId = list[0].getAttribute("companyId");
//							for (ListGridRecord obj : list) {
//								if (!obj.getAttribute("companyId").equals(companyId)) {
//									SC.say("您选择的记录涉及到多个归属公司，目前系统只支持打包同一个归属公司的信息！");
//									return;
//								}
//							}
							
							
							//弹出选择可操作角色和添加备注的面板
//							PopupWindow window = new PopupWindow();
//							window.setWidth("30%");
//							window.setHeight("60%");
//							window.centerInPage();
//							window.setTitle("选定审批角色");
//							NewReimbursementSelectRolePackagePanel panel = new NewReimbursementSelectRolePackagePanel();
//							panel.setParentWindow(window);
//							panel.addDataEditedHandler(new DataEditedHandler() {
//								@Override
//								public void onDataEdited(DataEditEvent event) {
//									Record record = event.getData();
//									Map params = record.toMap();
									Map params = new HashMap<>();
									params.put("operatorId", ClientUtil.getEmployeeId());
									params.put("records", list);
									params.put("remark", "批量分批打包");
									params.put("opt_type", "splitAddPackage");
									DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() >= 0) {
												SC.say("打包成功!");
												getFatherWindow().destroy();
												DataEditEvent dee = new DataEditEvent();
					                            fireEvent(dee);
											} else {
												splitBtn.setDisabled(false);
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
							}else{
								SC.debugger();
								splitBtn.setDisabled(false);
							}
//							});
//							window.addItem(panel);
//							window.show();
//						}
						
					}
				});
			}
		});
		
		IButton saveBtn = new IButton("打包");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				saveBtn.setDisabled(true);
				DelicacyListGrid grid = doSelectReimbursementpackagePanel.sourceGrid;
				if (grid.getRecords().length <= 0) {
					saveBtn.setDisabled(false);
					SC.say("添加打包数据");
					return;
				}
				SC.confirm("确认打包", new BooleanCallback() {

					@Override
					public void execute(Boolean value) {
						if (null != value && value) {
							final ListGridRecord[] list = grid.getRecords();
							String companyId = list[0].getAttribute("companyId");
							for (ListGridRecord obj : list) {
								if (!obj.getAttribute("companyId").equals(companyId)) {
									SC.say("您选择的记录涉及到多个归属公司，目前系统只支持打包同一个归属公司的信息！");
									saveBtn.setDisabled(false);
									return;
								}
							}
							//弹出选择可操作角色和添加备注的面板
							PopupWindow window = new PopupWindow();
							window.setWidth("30%");
							window.setHeight("60%");
							window.centerInPage();
							window.setTitle("选定审批角色");
							NewReimbursementSelectRolePackagePanel panel = new NewReimbursementSelectRolePackagePanel(BaseHelpUtils.getIntValue(companyId));
							panel.setParentWindow(window);
							panel.addDataEditedHandler(new DataEditedHandler() {
								@Override
								public void onDataEdited(DataEditEvent event) {
									Record record = event.getData();
									Map params = record.toMap();
									params.put("operatorId", ClientUtil.getEmployeeId());
									params.put("records", list);
									params.put("opt_type", "addPackage");
									DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if (dsResponse.getStatus() >= 0) {
												SC.say("打包成功!");
												getFatherWindow().destroy();
												DataEditEvent dee = new DataEditEvent();
					                            fireEvent(dee);
											} else {
												saveBtn.setDisabled(false);
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
								}
							});
							window.addItem(panel);
							window.show();
							
						}else{
							saveBtn.setDisabled(false);
						}
					}
				});
				
			}
		});

		IButton cancelBtn = new IButton("取消");
		cancelBtn.setIcon("[SKIN]/actions/close.png");
		btnLayout.addMember(cancelBtn);
		btnLayout.addSpacer(10);
		cancelBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "确认取消?", new BooleanCallback() {
					@Override
					public void execute(Boolean value) {
						if (value) {
							getFatherWindow().destroy();
						}
					}
				});
			}
		});
		
		allH.addMember(leftLayout);
		allH.addMember(rightLayout);
		mainLayout.addMember(allH);
		
		VLayout allLayout = new VLayout();
		allLayout.setHeight100();
		allLayout.setWidth100();
		allLayout.addMember(mainLayout);
		allLayout.addMember(btnLayout);
		addMember(allLayout);
		
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		Map<String, Object> params = new HashMap<>();
		params.put("opt_type", "getPackageDetailById");
		DBDataSource.callOperation("EP_ReimbursementPackageProcessor", "getPackageDetailById", params, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() > 0){
				}else{
					ClientUtil.displayErrorMessage(dsResponse);
				}
			}
		});
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
