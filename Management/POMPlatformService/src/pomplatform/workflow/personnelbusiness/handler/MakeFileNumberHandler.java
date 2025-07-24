package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseMakeFileNumber;
import pomplatform.workflow.personnelbusiness.bean.ConditionMakeFileNumber;
import pomplatform.workflow.personnelbusiness.query.QueryMakeFileNumber;
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

public class MakeFileNumberHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MakeFileNumberHandler.class);

	public static BaseCollection<BaseMakeFileNumber> executeQueryMakeFileNumber(ConditionMakeFileNumber c, KeyValuePair[] replacements ) throws Exception {
		QueryMakeFileNumber dao = new QueryMakeFileNumber();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMakeFileNumber> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMakeFileNumber c = new ConditionMakeFileNumber();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMakeFileNumber> result = executeQueryMakeFileNumber(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMakeFileNumber> result;
		ConditionMakeFileNumber c = new ConditionMakeFileNumber();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMakeFileNumber dao = new QueryMakeFileNumber();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMakeFileNumber.ALL_CAPTIONS);
			for(BaseMakeFileNumber b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


