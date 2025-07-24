package pomplatform.employeeInformationDetails.handler;

import org.apache.log4j.Logger;
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
import pomplatform.employeeInformationDetails.bean.BaseMemployeeeeedor;
import pomplatform.employeeInformationDetails.bean.ConditionMemployeeeeedor;
import pomplatform.employeeInformationDetails.query.QueryMemployeeeeedor;

public class MemployeeeeedorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeeeedorHandler.class);

	public static BaseCollection<BaseMemployeeeeedor> executeQueryMemployeeeeedor(ConditionMemployeeeeedor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeeeedor dao = new QueryMemployeeeeedor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeeeedor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeeeedor c = new ConditionMemployeeeeedor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeeeedor> result = executeQueryMemployeeeeedor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeeeedor> result;
		ConditionMemployeeeeedor c = new ConditionMemployeeeeedor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeeeedor dao = new QueryMemployeeeeedor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeeeedor.ALL_CAPTIONS);
			for(BaseMemployeeeeedor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


