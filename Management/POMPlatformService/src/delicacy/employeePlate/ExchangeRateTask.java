package delicacy.employeePlate;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseExchangeRate;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.ExchangeRate;
import com.pomplatform.db.dao.SystemDictionary;

import pomplatform.common.utils.StaticUtils;
import pomplatform.exchangerate.utils.ExchangeRateUtils;

public class ExchangeRateTask extends TimerTask {

    @Override
    public void run() {
    	try {
    		SystemDictionary dicDao = new SystemDictionary();
    		dicDao.setConditionDicTypeId("=", StaticUtils.SYSTEM_DICTIONARY_CURRENCY);
    		dicDao.setConditionDicIsEnable("=", true);
    		dicDao.unsetSelectFlags();
    		dicDao.setSelectDicTypeValueId(true);
    		List<BaseSystemDictionary> dicList = dicDao.conditionalLoad();
    		if(null == dicList || dicList.isEmpty()) {
    			return;
    		}
    		Set<Integer> set = new HashSet<>();
    		for(BaseSystemDictionary dicBean : dicList) {
    			if(Objects.equals(dicBean.getDicTypeValueId(), StaticUtils.CURRENCY_0)) {
    				continue;
    			}
    			set.add(dicBean.getDicTypeValueId());
    		}
	    	Date today = new Date();
	    	ExchangeRate dao = new ExchangeRate();
	    	dao.setConditionExchangeDate("=", today);
	    	List<BaseExchangeRate> list = dao.conditionalLoad();
	    	for(BaseExchangeRate bean : list) {
	    		set.remove(bean.getCurrencyId());
	    	}
	    	if(set.size() > 0) {
	    		for(Integer currency : set) {
	    			ExchangeRateUtils.saveExchangeRateToDB(currency);
	    		}
	    	}
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
    }
}
