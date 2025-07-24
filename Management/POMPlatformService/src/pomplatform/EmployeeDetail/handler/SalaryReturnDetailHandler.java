package pomplatform.EmployeeDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.EmployeeDetail.bean.BaseSalaryReturnDetail;
import pomplatform.EmployeeDetail.bean.ConditionSalaryReturnDetail;
import pomplatform.EmployeeDetail.query.QuerySalaryReturnDetail;
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

public class SalaryReturnDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalaryReturnDetailHandler.class);

	public static BaseCollection<BaseSalaryReturnDetail> executeQuerySalaryReturnDetail(ConditionSalaryReturnDetail c, KeyValuePair[] replacements ) throws Exception {
		QuerySalaryReturnDetail dao = new QuerySalaryReturnDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalaryReturnDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalaryReturnDetail c = new ConditionSalaryReturnDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalaryReturnDetail> result = executeQuerySalaryReturnDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalaryReturnDetail> result;
		ConditionSalaryReturnDetail c = new ConditionSalaryReturnDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalaryReturnDetail dao = new QuerySalaryReturnDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSalaryReturnDetail.ALL_CAPTIONS);
			for(BaseSalaryReturnDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


