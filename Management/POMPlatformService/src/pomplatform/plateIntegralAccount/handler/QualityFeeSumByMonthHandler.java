package pomplatform.plateIntegralAccount.handler;

import org.apache.log4j.Logger;
import pomplatform.plateIntegralAccount.bean.BaseQualityFeeSumByMonth;
import pomplatform.plateIntegralAccount.bean.ConditionQualityFeeSumByMonth;
import pomplatform.plateIntegralAccount.query.QueryQualityFeeSumByMonth;
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

public class QualityFeeSumByMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(QualityFeeSumByMonthHandler.class);

	public static BaseCollection<BaseQualityFeeSumByMonth> executeQueryQualityFeeSumByMonth(ConditionQualityFeeSumByMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryQualityFeeSumByMonth dao = new QueryQualityFeeSumByMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseQualityFeeSumByMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionQualityFeeSumByMonth c = new ConditionQualityFeeSumByMonth();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseQualityFeeSumByMonth> result = executeQueryQualityFeeSumByMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseQualityFeeSumByMonth> result;
		ConditionQualityFeeSumByMonth c = new ConditionQualityFeeSumByMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryQualityFeeSumByMonth dao = new QueryQualityFeeSumByMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseQualityFeeSumByMonth.ALL_CAPTIONS);
			for(BaseQualityFeeSumByMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


