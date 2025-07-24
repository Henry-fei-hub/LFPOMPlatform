package pomplatform.EmployeeDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.EmployeeDetail.bean.BaseSureIntegralDetail;
import pomplatform.EmployeeDetail.bean.ConditionSureIntegralDetail;
import pomplatform.EmployeeDetail.query.QuerySureIntegralDetail;
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

public class SureIntegralDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SureIntegralDetailHandler.class);

	public static BaseCollection<BaseSureIntegralDetail> executeQuerySureIntegralDetail(ConditionSureIntegralDetail c, KeyValuePair[] replacements ) throws Exception {
		QuerySureIntegralDetail dao = new QuerySureIntegralDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSureIntegralDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSureIntegralDetail c = new ConditionSureIntegralDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSureIntegralDetail> result = executeQuerySureIntegralDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSureIntegralDetail> result;
		ConditionSureIntegralDetail c = new ConditionSureIntegralDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySureIntegralDetail dao = new QuerySureIntegralDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSureIntegralDetail.ALL_CAPTIONS);
			for(BaseSureIntegralDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


