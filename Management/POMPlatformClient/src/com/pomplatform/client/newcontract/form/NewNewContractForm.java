package com.pomplatform.client.newcontract.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class NewNewContractForm extends GenericContractWizadWindow {
	
	private NewContractGroupname1New newContractGroupname1New;

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "ST_CustomContract";
	}

	@Override
	public boolean checkData(Map data) {
		return newContractGroupname1New.checkData();
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
		List<AbstractWizadPage> res = new ArrayList<AbstractWizadPage>();
		if (null != map && !map.isEmpty()) {
			newContractGroupname1New = new NewContractGroupname1New(map);
			res.add(newContractGroupname1New);
		} else {
			newContractGroupname1New = new NewContractGroupname1New();
			res.add(newContractGroupname1New);
		}
		return res;
	}

	private Map<String, Object> map;

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getMap() {
		return this.map;
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
