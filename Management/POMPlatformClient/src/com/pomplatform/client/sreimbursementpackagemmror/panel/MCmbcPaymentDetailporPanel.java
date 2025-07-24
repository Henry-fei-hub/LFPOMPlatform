package com.pomplatform.client.sreimbursementpackagemmror.panel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractSearchPanel;
import com.delicacy.client.ui.GenericViewWindow;
import com.delicacy.client.ui.LayoutConstant;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.pomplatform.client.sreimbursementpackagemmror.datasource.DSMCmbcPaymentDetailpor;
import com.pomplatform.client.sreimbursementpackagemmror.form.MCmbcPaymentDetailporSearchForm;
import com.pomplatform.client.sreimbursementpackagemmror.form.MCmbcPaymentDetailporViewer;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class MCmbcPaymentDetailporPanel extends AbstractSearchPanel {

	private static final Logger __LOGGER = Logger.getLogger("");
	
	private McmbcpaydetailctswoowycoorPanel withdrawPanel;
	
	private Integer cmbcPaymentId;

	public static class Factory implements PanelFactory {
		private String id;

		@Override
		public Canvas create() {
			MCmbcPaymentDetailporPanel cm = new MCmbcPaymentDetailporPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MCmbcPaymentDetailpor";
		}

	}

	@Override
	public void init() {
		super.init();
		__controlPosition = LayoutConstant.RIGHT;
		__needPagenation = false;
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
		IButton viewButton = new IButton("查看详细");
		viewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showDetail();
			}
		});
		controlLayout.addMember(viewButton);
		IButton tdDealWithBtn = new IButton("发起退单处理");
		tdDealWithBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(resultGrid.anySelected()){
					ListGridRecord selectRecord = resultGrid.getSelectedRecord();
					int status = selectRecord.getAttributeAsInt("status");
					if(status == 5){
						SC.confirm("确认发起退单处理?(确定后会在退单重新发起单生成一条记录,当信息核对完成后可以再次进行支付)", new BooleanCallback() {
							
							@Override
							public void execute(Boolean value) {
								if(value){
									
									int cmbcPayDetailId = selectRecord.getAttributeAsInt("cmbcPayDetailId");
									Map<String, Object> params = new HashMap<>();
									params.put("cmbcPayDetailId", cmbcPayDetailId);
									params.put("opt_type", "dealWithDraw");
									DBDataSource.callOperation("EP_ReimbursementPackageProcessor", params, new DSCallback() {
										
										@Override
										public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
											if(dsResponse.getStatus() > 0){
												
												if(null != getWithdrawPanel()){
													getWithdrawPanel().commonQuery();
												}
												
												SC.say("处理成功");
											}else{
												ClientUtil.displayErrorMessage(dsResponse);
											}
										}
									});
								}
								
								
							}
						});
					}else{
						SC.say("该支付单未处于退单状态");
					}
				}else{
					SC.say("请选择一条退单的数据");
				}
				
			}
		});
		controlLayout.addMember(tdDealWithBtn);
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
				detail.setTitle("详情");
				detail.setWidth100();
				detail.setHeight100();
				MCmbcPaymentDetailporViewer detailForm = new MCmbcPaymentDetailporViewer();
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
		criteria.put("cmbcPaymentId", getCmbcPaymentId());
		criteria.put("addtionalCondition", "order by cmbc_pay_detail_id");
		criteria.put("addtionalCondition", "order by reimbursement_package_summary_id");
		return true;
	}

	@Override
	public SearchForm generateSearchForm() {
//		return new MCmbcPaymentDetailporSearchForm();
		return null;
	}

	@Override
	public DataSource getDataSource() {
		return DSMCmbcPaymentDetailpor.getInstance();
	}

	public Integer getCmbcPaymentId() {
		return cmbcPaymentId;
	}

	public void setCmbcPaymentId(Integer cmbcPaymentId) {
		this.cmbcPaymentId = cmbcPaymentId;
	}

	public McmbcpaydetailctswoowycoorPanel getWithdrawPanel() {
		return withdrawPanel;
	}

	public void setWithdrawPanel(McmbcpaydetailctswoowycoorPanel withdrawPanel) {
		this.withdrawPanel = withdrawPanel;
	}

}
