package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseBonusPaymentDetail;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentDetail;
import pomplatform.bonusPayment.query.QueryBonusPaymentDetail;
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

public class BonusPaymentDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusPaymentDetailHandler.class);

	public static BaseCollection<BaseBonusPaymentDetail> executeQueryBonusPaymentDetail(ConditionBonusPaymentDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusPaymentDetail dao = new QueryBonusPaymentDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusPaymentDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusPaymentDetail c = new ConditionBonusPaymentDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusPaymentDetail> result = executeQueryBonusPaymentDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusPaymentDetail> result;
		ConditionBonusPaymentDetail c = new ConditionBonusPaymentDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusPaymentDetail dao = new QueryBonusPaymentDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusPaymentDetail.ALL_CAPTIONS);
			for(BaseBonusPaymentDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


