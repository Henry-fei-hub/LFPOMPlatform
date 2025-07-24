package pomplatform.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.operation.bean.BaseMprojectemployeeepor;
import pomplatform.operation.bean.ConditionMprojectemployeeepor;
import pomplatform.operation.query.QueryMprojectemployeeepor;
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

public class MprojectemployeeeporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectemployeeeporHandler.class);

	public static BaseCollection<BaseMprojectemployeeepor> executeQueryMprojectemployeeepor(ConditionMprojectemployeeepor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectemployeeepor dao = new QueryMprojectemployeeepor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectemployeeepor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectemployeeepor c = new ConditionMprojectemployeeepor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectemployeeepor> result = executeQueryMprojectemployeeepor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectemployeeepor> result;
		ConditionMprojectemployeeepor c = new ConditionMprojectemployeeepor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectemployeeepor dao = new QueryMprojectemployeeepor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseMprojectemployeeepor.ALL_CAPTIONS);
			for(BaseMprojectemployeeepor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


