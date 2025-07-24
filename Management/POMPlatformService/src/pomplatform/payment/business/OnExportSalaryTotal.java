package pomplatform.payment.business;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.payment.bean.BaseOnSalaryTotalData;
import pomplatform.payment.bean.ConditionOnSalaryTotalData;
import pomplatform.payment.query.QueryOnSalaryTotalData;

public class OnExportSalaryTotal implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnExportSalaryTotal.class);

	public static BaseCollection<BaseOnSalaryTotalData> executeQueryInsurance(ConditionOnSalaryTotalData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryTotalData dao = new QueryOnSalaryTotalData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryTotalData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryTotalData c = new ConditionOnSalaryTotalData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryTotalData> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryTotalData> result;
		ConditionOnSalaryTotalData c = new ConditionOnSalaryTotalData();
		c.setDataFromJSON(creteria);
		QueryOnSalaryTotalData dao = new QueryOnSalaryTotalData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryTotalData.EXPORT_CAPTIONS);
			for(BaseOnSalaryTotalData b : result.getCollections()){
				if(b.getEmployeeId() != 0){
					ps.println(b.toCSVString());
				}
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


