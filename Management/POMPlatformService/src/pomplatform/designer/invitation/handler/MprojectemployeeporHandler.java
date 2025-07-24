package pomplatform.designer.invitation.handler;

import org.apache.log4j.Logger;
import pomplatform.designer.invitation.bean.BaseMprojectemployeepor;
import pomplatform.designer.invitation.bean.ConditionMprojectemployeepor;
import pomplatform.designer.invitation.query.QueryMprojectemployeepor;
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

public class MprojectemployeeporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojectemployeeporHandler.class);

	public static BaseCollection<BaseMprojectemployeepor> executeQueryMprojectemployeepor(ConditionMprojectemployeepor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojectemployeepor dao = new QueryMprojectemployeepor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojectemployeepor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectemployeepor c = new ConditionMprojectemployeepor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectemployeepor> result = executeQueryMprojectemployeepor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojectemployeepor> result;
		ConditionMprojectemployeepor c = new ConditionMprojectemployeepor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojectemployeepor dao = new QueryMprojectemployeepor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseMprojectemployeepor.ALL_CAPTIONS);
			for(BaseMprojectemployeepor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


