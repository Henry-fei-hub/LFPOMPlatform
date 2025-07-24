package pomplatform.projectSettlement.handler;

import org.apache.log4j.Logger;
import pomplatform.projectSettlement.bean.BaseOnLoadProjectSettlementEmployees;
import pomplatform.projectSettlement.bean.ConditionOnLoadProjectSettlementEmployees;
import pomplatform.projectSettlement.query.QueryOnLoadProjectSettlementEmployees;
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

public class OnLoadProjectSettlementEmployeesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectSettlementEmployeesHandler.class);

	public static BaseCollection<BaseOnLoadProjectSettlementEmployees> executeQueryOnLoadProjectSettlementEmployees(ConditionOnLoadProjectSettlementEmployees c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectSettlementEmployees dao = new QueryOnLoadProjectSettlementEmployees();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectSettlementEmployees> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectSettlementEmployees c = new ConditionOnLoadProjectSettlementEmployees();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectSettlementEmployees> result = executeQueryOnLoadProjectSettlementEmployees(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectSettlementEmployees> result;
		ConditionOnLoadProjectSettlementEmployees c = new ConditionOnLoadProjectSettlementEmployees();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectSettlementEmployees dao = new QueryOnLoadProjectSettlementEmployees();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectSettlementEmployees.ALL_CAPTIONS);
			for(BaseOnLoadProjectSettlementEmployees b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


