package com.pomplatform.client.sinvoiceitior.panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.thirdparty.common.css.compiler.passes.RemoveVendorSpecificProperties;
import com.pomplatform.client.sinvoiceitior.datasource.DSSinvoiceitior;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RemoveRecordClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class DestoryEmptySinvoiceitiorPanel extends AbstractWizadPage implements HasHandlers{

	private static final Logger logger = Logger.getLogger("");
	public DelicacyListGrid SourceGrid;
	
	public final static String BORDER_STYLE = "1px solid gray";
    public final static String BACKGROUND_COLOR = "azure";
    public final static String BUTTON_BACKGROUND_COLOR = "azure";
    public final static String FORM_BORDER_STYLE = "1px solid #808080";

	public DestoryEmptySinvoiceitiorPanel() {
		setBackgroundColor(BACKGROUND_COLOR);
		SourceGrid = new DelicacyListGrid();
		SourceGrid.setHeight100();
		SourceGrid.setDataSource(DSSinvoiceitior.getInstance());
		int ids = 0;
		ListGridField [] fields = new ListGridField[5];
		fields[ids] = new ListGridField("invoiceType");
		ids++;
		fields[ids] = new ListGridField("invoiceCode");
		ids++;
		fields[ids] = new ListGridField("invoiceNumber");
		ids++;
		fields[ids] = new ListGridField("ticketingCompany");
		ids++;
		fields[ids] = new ListGridField("invalidRemark");
		fields[ids].setCanEdit(Boolean.TRUE);
		
		SourceGrid.setFields(fields);
		SourceGrid.setCanRemoveRecords(true);
		SourceGrid.addRemoveRecordClickHandler(new RemoveRecordClickHandler() {
			
			@Override
			public void onRemoveRecordClick(RemoveRecordClickEvent event) {
				setRemoveCount(getRemoveCount() - 1);
				getFatherWindow().setTitle("发票作废("+ getRemoveCount() + "张)");
			}
		});
		
		VLayout SearchSourceLayout = new VLayout();
		SearchSourceLayout.setWidth100();
		 
		SearchSourceLayout.setHeight100();
		SearchSourceLayout.setMargin(5);
		SearchSourceLayout.addMember(SourceGrid);
		
		ToolStrip btnLayout = new ToolStrip();
		btnLayout.setVPolicy(LayoutPolicy.FILL);
		btnLayout.setPadding(5);
		btnLayout.setHeight(40);
		btnLayout.setWidth100();
		btnLayout.addFill();
		
		IButton saveBtn = new IButton("作废");
		saveBtn.setIcon("[SKIN]/actions/save.png");
		btnLayout.addMember(saveBtn);
		btnLayout.addSpacer(10);
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				SC.ask("提示", "保存后发票将空白作废,确认作废?", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(value){
							ListGridRecord[] records = SourceGrid.getRecords();
							
							if(records.length > 0){
								List<Map> list = new ArrayList<>();
								for (ListGridRecord listGridRecord : records) {
									list.add(listGridRecord.toMap());
								}
								Map<String, Object> param = new HashMap<>();
								param.put("opt_type", "destoryEmptyInvoice");
								param.put("list", list);
								DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "destoryEmptyInvoice", param, new DSCallback() {
									@Override
									public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
										if (dsResponse.getStatus() >= 0) {
											getFatherWindow().destroy();
											DataEditEvent dee = new DataEditEvent();
				                            fireEvent(dee);
										}else{
											ClientUtil.displayErrorMessage(dsResponse);
										}
									}
								});
							}else{
								SC.say("没有可作废发票,请重新选择!");
								getFatherWindow().destroy();
							}
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
				getFatherWindow().destroy();
			}
		});
		
		
		SearchSourceLayout.addMember(btnLayout);
		addMember(SearchSourceLayout);
	}

	@Override
	public void startEdit() {
		Map<String, Object> condition = new HashMap<>();
		condition.put("opt_type", "getInvoiceInfoByIds");
		condition.put("invoiceIds", getInvoiceIds());
		DBDataSource.callOperation("EP_CustomSinvoiceitiorHandler", "", condition, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					SourceGrid.setData(dsResponse.getData());
				}
			}
		});
	}

	@Override
	public Set<String> getItemNames() {
		Set<String> res = new HashSet<>();
		res.add("customSinvoiceitiorHandler");
		return res;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map getValuesAsMap() {
		return null;
	}

	@Override
	public boolean checkData() {
		return false;
	}

	
	private String invoiceIds;// 发票主键 逗号拼接
	
	private int removeCount;//移除的发票数量
	
	public int getRemoveCount() {
		return removeCount;
	}

	public void setRemoveCount(int removeCount) {
		this.removeCount = removeCount;
	}

	public String getInvoiceIds() {
		return invoiceIds;
	}

	public void setInvoiceIds(String invoiceIds) {
		this.invoiceIds = invoiceIds;
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

