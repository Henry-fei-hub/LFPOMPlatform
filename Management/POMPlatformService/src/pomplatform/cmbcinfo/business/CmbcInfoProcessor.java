package pomplatform.cmbcinfo.business;

import java.io.File;
import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.cmbcinfo.bean.BaseMcmbcaccoutinfoccacbscor;

public class CmbcInfoProcessor implements GenericProcessor, GenericDownloadProcessor {

	private final static String SYNC_CMBC_DATA = "syncCmbcData";// 同步CMB账户详情数据
	
	private final static String SYNC_CMB_TRANS_DATA = "syncCmbTransData";// 同步CMB交易详情数据

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			String opt_type = BaseHelpUtils.getStringValue(params, "opt_type");
			switch (opt_type) {
			case SYNC_CMBC_DATA:
				return syncCmbcData();
			case SYNC_CMB_TRANS_DATA:
				return syncCmbTransData(params);
			}
		}
		return bc.toJSON(-1, "参数不能为空");
	}
	
	private String syncCmbTransData(Map<String, Object> params) throws Exception{
		int status = 1;
		String errorMsg = null;
		Date beginDate = GenericBase.__getDate(params.get("beginDate"));
		Date endDate = GenericBase.__getDate(params.get("endDate"));
		if(null != beginDate && null != endDate){
			if(beginDate.compareTo(endDate) <= 0){
				List<BaseMcmbcaccoutinfoccacbscor> list = GenericBase.__getList(params.get("list"), BaseMcmbcaccoutinfoccacbscor.newInstance());
				if(list.size() > 0){
					for (BaseMcmbcaccoutinfoccacbscor baseMcmbcaccoutinfoccacbscor : list) {
						if(!BaseHelpUtils.isNullOrEmpty(baseMcmbcaccoutinfoccacbscor.getBbknbr())
								&& !BaseHelpUtils.isNullOrEmpty(baseMcmbcaccoutinfoccacbscor.getAccnbr())){
							CmbBusinessProcess.syncCmbTransInfoToErp(baseMcmbcaccoutinfoccacbscor.getBbknbr(), baseMcmbcaccoutinfoccacbscor.getAccnbr(), 
									beginDate, endDate, false);
						}
					}
				}else{
					CmbBusinessProcess.syncAllAccountTransInfoDataToErp(beginDate, endDate, false);
				}
			}else{
				status = -1;
				errorMsg = "开始日期不能大于结束日期";
			}
		}else{
			status = -1;
			errorMsg = "参数错误";
		}
		
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	
	private String syncCmbcData() throws Exception{
		CmbBusinessProcess.syncCmbBankInfoDataToErp();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(1, null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
}
