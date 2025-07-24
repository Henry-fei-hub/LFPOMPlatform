package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseFiveInsuranceOneGolds;
import pomplatform.payment.bean.ConditionFiveInsuranceOneGolds;
import pomplatform.payment.query.QueryFiveInsuranceOneGolds;
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

public class FiveInsuranceOneGoldsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FiveInsuranceOneGoldsHandler.class);

	public static BaseCollection<BaseFiveInsuranceOneGolds> executeQueryFiveInsuranceOneGolds(ConditionFiveInsuranceOneGolds c, KeyValuePair[] replacements ) throws Exception {
		QueryFiveInsuranceOneGolds dao = new QueryFiveInsuranceOneGolds();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFiveInsuranceOneGolds> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFiveInsuranceOneGolds c = new ConditionFiveInsuranceOneGolds();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFiveInsuranceOneGolds> result = executeQueryFiveInsuranceOneGolds(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFiveInsuranceOneGolds> result;
		ConditionFiveInsuranceOneGolds c = new ConditionFiveInsuranceOneGolds();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFiveInsuranceOneGolds dao = new QueryFiveInsuranceOneGolds();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFiveInsuranceOneGolds.ALL_CAPTIONS);
			for(BaseFiveInsuranceOneGolds b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


