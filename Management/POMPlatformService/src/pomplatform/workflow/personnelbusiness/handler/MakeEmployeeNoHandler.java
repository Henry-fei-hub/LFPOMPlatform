package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseMakeEmployeeNo;
import pomplatform.workflow.personnelbusiness.bean.ConditionMakeEmployeeNo;
import pomplatform.workflow.personnelbusiness.query.QueryMakeEmployeeNo;
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

public class MakeEmployeeNoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MakeEmployeeNoHandler.class);

	public static BaseCollection<BaseMakeEmployeeNo> executeQueryMakeEmployeeNo(ConditionMakeEmployeeNo c, KeyValuePair[] replacements ) throws Exception {
		QueryMakeEmployeeNo dao = new QueryMakeEmployeeNo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMakeEmployeeNo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMakeEmployeeNo c = new ConditionMakeEmployeeNo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMakeEmployeeNo> result = executeQueryMakeEmployeeNo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMakeEmployeeNo> result;
		ConditionMakeEmployeeNo c = new ConditionMakeEmployeeNo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMakeEmployeeNo dao = new QueryMakeEmployeeNo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMakeEmployeeNo.ALL_CAPTIONS);
			for(BaseMakeEmployeeNo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


