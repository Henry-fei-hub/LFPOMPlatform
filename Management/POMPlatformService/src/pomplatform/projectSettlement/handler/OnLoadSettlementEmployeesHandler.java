package pomplatform.projectSettlement.handler;

import org.apache.log4j.Logger;
import pomplatform.projectSettlement.bean.BaseOnLoadSettlementEmployees;
import pomplatform.projectSettlement.bean.ConditionOnLoadSettlementEmployees;
import pomplatform.projectSettlement.query.QueryOnLoadSettlementEmployees;
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

public class OnLoadSettlementEmployeesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadSettlementEmployeesHandler.class);

	public static BaseCollection<BaseOnLoadSettlementEmployees> executeQueryOnLoadSettlementEmployees(ConditionOnLoadSettlementEmployees c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadSettlementEmployees dao = new QueryOnLoadSettlementEmployees();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadSettlementEmployees> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadSettlementEmployees c = new ConditionOnLoadSettlementEmployees();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadSettlementEmployees> result = executeQueryOnLoadSettlementEmployees(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadSettlementEmployees> result;
		ConditionOnLoadSettlementEmployees c = new ConditionOnLoadSettlementEmployees();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadSettlementEmployees dao = new QueryOnLoadSettlementEmployees();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadSettlementEmployees.ALL_CAPTIONS);
			for(BaseOnLoadSettlementEmployees b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


