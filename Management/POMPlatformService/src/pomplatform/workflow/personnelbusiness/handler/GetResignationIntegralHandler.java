package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseGetResignationIntegral;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetResignationIntegral;
import pomplatform.workflow.personnelbusiness.query.QueryGetResignationIntegral;
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

public class GetResignationIntegralHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetResignationIntegralHandler.class);

	public static BaseCollection<BaseGetResignationIntegral> executeQueryGetResignationIntegral(ConditionGetResignationIntegral c, KeyValuePair[] replacements ) throws Exception {
		QueryGetResignationIntegral dao = new QueryGetResignationIntegral();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetResignationIntegral> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetResignationIntegral c = new ConditionGetResignationIntegral();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetResignationIntegral> result = executeQueryGetResignationIntegral(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetResignationIntegral> result;
		ConditionGetResignationIntegral c = new ConditionGetResignationIntegral();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetResignationIntegral dao = new QueryGetResignationIntegral();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetResignationIntegral.ALL_CAPTIONS);
			for(BaseGetResignationIntegral b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


