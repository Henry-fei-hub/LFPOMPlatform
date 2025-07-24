package com.pomplatform.client.plateproductionvaluecoefficients.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;


/**
 * 产值系数的新增界面
 *
 * @author xiaolong
 */
public class NewProductionValueCoefficientTypeForm extends GenericWizadWindow {

    private static final Logger __logger = Logger.getLogger("");

    @Override
    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_ProductionValueCoefficientTypeWithP";
    }

    @Override
    public boolean checkData(Map data) {
        return true;
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
                if (dsResponse.getStatus() >= 0) {
                    SC.say("保存成功");
                } else {
                    SC.say("保存失败，产值类型不能重复");
                }
            }
        });

        List<AbstractWizadPage> res = new ArrayList<>();
        res.add(new ProductionValueCoefficientTypeDetailProductionValueCoefficient());
        return res;
    }


}

