package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseUpdateFrozenIntegral;
import pomplatform.employee.bean.ConditionUpdateFrozenIntegral;
import pomplatform.employee.query.QueryUpdateFrozenIntegral;
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

public class UpdateFrozenIntegralHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(UpdateFrozenIntegralHandler.class);

	public static BaseCollection<BaseUpdateFrozenIntegral> executeQueryUpdateFrozenIntegral(ConditionUpdateFrozenIntegral c, KeyValuePair[] replacements ) throws Exception {
		QueryUpdateFrozenIntegral dao = new QueryUpdateFrozenIntegral();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseUpdateFrozenIntegral> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionUpdateFrozenIntegral c = new ConditionUpdateFrozenIntegral();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseUpdateFrozenIntegral> result = executeQueryUpdateFrozenIntegral(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseUpdateFrozenIntegral> result;
		ConditionUpdateFrozenIntegral c = new ConditionUpdateFrozenIntegral();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryUpdateFrozenIntegral dao = new QueryUpdateFrozenIntegral();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseUpdateFrozenIntegral.ALL_CAPTIONS);
			for(BaseUpdateFrozenIntegral b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


