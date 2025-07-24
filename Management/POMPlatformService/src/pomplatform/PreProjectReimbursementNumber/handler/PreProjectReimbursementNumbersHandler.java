package pomplatform.PreProjectReimbursementNumber.handler;

import org.apache.log4j.Logger;
import pomplatform.PreProjectReimbursementNumber.bean.BasePreProjectReimbursementNumbers;
import pomplatform.PreProjectReimbursementNumber.bean.ConditionPreProjectReimbursementNumbers;
import pomplatform.PreProjectReimbursementNumber.query.QueryPreProjectReimbursementNumbers;
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

public class PreProjectReimbursementNumbersHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PreProjectReimbursementNumbersHandler.class);

	public static BaseCollection<BasePreProjectReimbursementNumbers> executeQueryPreProjectReimbursementNumbers(ConditionPreProjectReimbursementNumbers c, KeyValuePair[] replacements ) throws Exception {
		QueryPreProjectReimbursementNumbers dao = new QueryPreProjectReimbursementNumbers();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePreProjectReimbursementNumbers> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPreProjectReimbursementNumbers c = new ConditionPreProjectReimbursementNumbers();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePreProjectReimbursementNumbers> result = executeQueryPreProjectReimbursementNumbers(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePreProjectReimbursementNumbers> result;
		ConditionPreProjectReimbursementNumbers c = new ConditionPreProjectReimbursementNumbers();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPreProjectReimbursementNumbers dao = new QueryPreProjectReimbursementNumbers();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePreProjectReimbursementNumbers.ALL_CAPTIONS);
			for(BasePreProjectReimbursementNumbers b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


