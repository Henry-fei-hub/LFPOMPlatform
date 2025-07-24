package pomplatform.custom.handler;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.handler.ContractHandler;

import pomplatform.common.utils.AccountUtils;

public class ContractCustomHandler extends ContractHandler{
	@Override
	public String save(String json) throws Exception {
		BaseContract bean = new BaseContract();
		bean.setDataFromJSON(json);
		Contract dao = new Contract();
		dao.setDataFromBase(bean);
		int num = dao.save();
		AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_CONTRACT, dao.getContractId(), AccountUtils.ACCOUNT_LEVEL_1, dao.getContractName(), dao.getOperator(), true);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}
}
