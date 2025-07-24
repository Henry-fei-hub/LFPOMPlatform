package pomplatform.bonusPaymentByMonth.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPaymentByMonth.bean.BaseBonusPaymentByMonth;
import pomplatform.bonusPaymentByMonth.bean.ConditionBonusPaymentByMonth;
import pomplatform.bonusPaymentByMonth.query.QueryBonusPaymentByMonth;
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

public class BonusPaymentByMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusPaymentByMonthHandler.class);

	public static BaseCollection<BaseBonusPaymentByMonth> executeQueryBonusPaymentByMonth(ConditionBonusPaymentByMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusPaymentByMonth dao = new QueryBonusPaymentByMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusPaymentByMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusPaymentByMonth c = new ConditionBonusPaymentByMonth();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusPaymentByMonth> result = executeQueryBonusPaymentByMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusPaymentByMonth> result;
		ConditionBonusPaymentByMonth c = new ConditionBonusPaymentByMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusPaymentByMonth dao = new QueryBonusPaymentByMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusPaymentByMonth.ALL_CAPTIONS);
			for(BaseBonusPaymentByMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


