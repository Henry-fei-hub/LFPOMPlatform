package pomplatform.salaryexceptions.handler;

import org.apache.log4j.Logger;
import pomplatform.salaryexceptions.bean.BaseOnSalaryExceptions;
import pomplatform.salaryexceptions.bean.ConditionOnSalaryExceptions;
import pomplatform.salaryexceptions.query.QueryOnSalaryExceptions;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseSalaryException;
import com.pomplatform.db.dao.SalaryException;
import delicacy.common.BaseCollection;

public class OnSalaryExceptionsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryExceptionsHandler.class);

	public static BaseCollection<BaseOnSalaryExceptions> executeQueryOnSalaryExceptions(ConditionOnSalaryExceptions c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryExceptions dao = new QueryOnSalaryExceptions();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryExceptions> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			SalaryException daoSalaryException = new SalaryException();
			for(BaseOnSalaryExceptions bean : result.getCollections()){
				daoSalaryException.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				bean.setDetailSalaryException(daoSalaryException.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryExceptions c = new ConditionOnSalaryExceptions();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryExceptions> result = executeQueryOnSalaryExceptions(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryExceptions> result;
		ConditionOnSalaryExceptions c = new ConditionOnSalaryExceptions();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryExceptions dao = new QueryOnSalaryExceptions();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryExceptions.ALL_CAPTIONS);
			for(BaseOnSalaryExceptions b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


