package pomplatform.bonusPaymentByDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPaymentByDetail.bean.BaseBonusPaymentByDetail;
import pomplatform.bonusPaymentByDetail.bean.ConditionBonusPaymentByDetail;
import pomplatform.bonusPaymentByDetail.query.QueryBonusPaymentByDetail;
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

public class BonusPaymentByDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusPaymentByDetailHandler.class);

	public static BaseCollection<BaseBonusPaymentByDetail> executeQueryBonusPaymentByDetail(ConditionBonusPaymentByDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusPaymentByDetail dao = new QueryBonusPaymentByDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusPaymentByDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusPaymentByDetail c = new ConditionBonusPaymentByDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusPaymentByDetail> result = executeQueryBonusPaymentByDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusPaymentByDetail> result;
		ConditionBonusPaymentByDetail c = new ConditionBonusPaymentByDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusPaymentByDetail dao = new QueryBonusPaymentByDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusPaymentByDetail.ALL_CAPTIONS);
			for(BaseBonusPaymentByDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


