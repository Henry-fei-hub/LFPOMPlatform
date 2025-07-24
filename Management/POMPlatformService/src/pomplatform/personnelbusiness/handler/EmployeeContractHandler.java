package pomplatform.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.personnelbusiness.bean.BaseEmployeeContract;
import pomplatform.personnelbusiness.bean.ConditionEmployeeContract;
import pomplatform.personnelbusiness.query.QueryEmployeeContract;
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

public class EmployeeContractHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeContractHandler.class);

	public static BaseCollection<BaseEmployeeContract> executeQueryEmployeeContract(ConditionEmployeeContract c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeContract dao = new QueryEmployeeContract();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeContract> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeContract c = new ConditionEmployeeContract();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeContract> result = executeQueryEmployeeContract(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeContract> result;
		ConditionEmployeeContract c = new ConditionEmployeeContract();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeContract dao = new QueryEmployeeContract();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeContract.ALL_CAPTIONS);
			for(BaseEmployeeContract b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


