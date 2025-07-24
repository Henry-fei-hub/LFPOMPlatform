package com.pomplatform.client.purchase.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractExpansionRelatedPage;
import com.delicacy.client.ui.GenericViewWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.purchase.datasource.DSPaymentTemplateDetail;
import com.pomplatform.client.purchase.datasource.DSPaymentTemplateWithP;
import com.pomplatform.client.purchase.form.PaymentTemplateWithPSearchForm;
import com.pomplatform.client.purchase.form.PaymentTemplateWithPViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PaymentTemplateWorkflowPanel extends AbstractExpansionRelatedPage implements HasHandlers{

	private static final Logger __LOGGER = Logger.getLogger("");
	protected final HandlerManager handlerManager = new HandlerManager(this);

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			PaymentTemplateWorkflowPanel cm = new PaymentTemplateWorkflowPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PaymentTemplateWithP";
		}

	}

	@Override
	public void initComponents() {
		IButton refreshButton = new IButton("刷新");
		controlLayout.addMember(refreshButton);
		refreshButton.setIcon("[SKIN]/actions/refresh.png");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				commonQuery();
			}
		});

		resultGrid.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				showDetail();
			}
		});
		IButton operation1Button = new IButton("查看详情");
		controlLayout.addMember(operation1Button);
		operation1Button.setIcon("[SKIN]/actions/view.png");
		operation1Button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		
		IButton applyBtn = new IButton("应用模板");
		controlLayout.addMember(applyBtn);
		applyBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(!resultGrid.anySelected()) {
					SC.say("请选择一条数据进行应用!");
					return;
				}
				SC.confirm("确认应用模板？应用则会覆盖原有付款数据!!!", new BooleanCallback() {
					
					@Override
					public void execute(Boolean value) {
						if(null != value && value) {
							Record selectRecord = resultGrid.getSelectedRecord();
							DataEditEvent dee = new DataEditEvent();
							dee.setData(selectRecord);
							fireEvent(dee);
						}
						
					}
				});
				
			}
		});
		commonQuery();
	}

	public void showDetail() {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onFailure(Throwable reason) {
				SC.say("failure to download code");
			}

			@Override
			public void onSuccess() {
				if (!resultGrid.anySelected()) {
					SC.say("请选择一条数据");
					return;
				}
				GenericViewWindow detail = new GenericViewWindow();
				detail.setTitle("付款模板");
				detail.setWidth100();
				detail.setHeight100();
				PaymentTemplateWithPViewer detailForm = new PaymentTemplateWithPViewer();
				detailForm.setParentSearchForm(searchForm);
				detailForm.setLayoutMode(AbstractDetailViewer.COMPONENT_LAYOUT_TAB);
				detailForm.initComponents();
				detailForm.viewSelectedData(resultGrid);
				detail.setContent(detailForm);
				detail.centerInPage();
				detail.show();
			}
		});
	}

	
	@Override
	public boolean checkSearchCriteria(Map criteria) {
		criteria.put("addtionalCondition", "order by payment_template_id DESC");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
		return new PaymentTemplateWithPSearchForm();
	}

	@Override
	public DataSource getDataSource() {
		return DSPaymentTemplateWithP.getInstance();
	}

	@Override
	public DataSource getChildDataSource() {
		return DSPaymentTemplateDetail.getInstance();
	}

	@Override
	public void customCommonQuery(ListGridRecord record, ListGrid childGrid) {
		Map<String, Object> params = new HashMap<>();
		params.put("paymentTemplateId", record.getAttribute("paymentTemplateId"));
		params.put("addtionalCondition", "order by order_num");
		DBDataSource.callOperation("ST_PaymentTemplateDetail", "find", params, new DSCallback() {
			
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0) {
					childGrid.setData(dsResponse.getData());
				}
				
			}
		});
	}

	@Override
	public boolean doCustomCommonQuery() {
		return true;
	}

	@Override
	public void setChildGridOption(ListGrid resultChildGrid) {
		resultChildGrid.setCanRemoveRecords(false);
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
	
	public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
		return handlerManager.addHandler(DataEditEvent.TYPE, handler);
	}
}
