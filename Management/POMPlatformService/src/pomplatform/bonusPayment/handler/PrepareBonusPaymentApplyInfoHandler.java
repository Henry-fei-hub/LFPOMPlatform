package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BasePrepareBonusPaymentApplyInfo;
import pomplatform.bonusPayment.bean.ConditionPrepareBonusPaymentApplyInfo;
import pomplatform.bonusPayment.query.QueryPrepareBonusPaymentApplyInfo;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class PrepareBonusPaymentApplyInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PrepareBonusPaymentApplyInfoHandler.class);

	public static BaseCollection<BasePrepareBonusPaymentApplyInfo> executeQueryPrepareBonusPaymentApplyInfo(ConditionPrepareBonusPaymentApplyInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryPrepareBonusPaymentApplyInfo dao = new QueryPrepareBonusPaymentApplyInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePrepareBonusPaymentApplyInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPrepareBonusPaymentApplyInfo c = new ConditionPrepareBonusPaymentApplyInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePrepareBonusPaymentApplyInfo> result = executeQueryPrepareBonusPaymentApplyInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePrepareBonusPaymentApplyInfo> result;
		ConditionPrepareBonusPaymentApplyInfo c = new ConditionPrepareBonusPaymentApplyInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPrepareBonusPaymentApplyInfo dao = new QueryPrepareBonusPaymentApplyInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePrepareBonusPaymentApplyInfo.ALL_CAPTIONS);
			for(BasePrepareBonusPaymentApplyInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


