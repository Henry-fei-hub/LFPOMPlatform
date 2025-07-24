package pomplatform.employeechangeplaterecord.handler;

import org.apache.log4j.Logger;
import pomplatform.employeechangeplaterecord.bean.BaseMemployeechangeplaterecordeeepyseor;
import pomplatform.employeechangeplaterecord.bean.ConditionMemployeechangeplaterecordeeepyseor;
import pomplatform.employeechangeplaterecord.query.QueryMemployeechangeplaterecordeeepyseor;
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

public class MemployeechangeplaterecordeeepyseorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeechangeplaterecordeeepyseorHandler.class);

	public static BaseCollection<BaseMemployeechangeplaterecordeeepyseor> executeQueryMemployeechangeplaterecordeeepyseor(ConditionMemployeechangeplaterecordeeepyseor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeechangeplaterecordeeepyseor dao = new QueryMemployeechangeplaterecordeeepyseor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeechangeplaterecordeeepyseor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeechangeplaterecordeeepyseor c = new ConditionMemployeechangeplaterecordeeepyseor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeechangeplaterecordeeepyseor> result = executeQueryMemployeechangeplaterecordeeepyseor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeechangeplaterecordeeepyseor> result;
		ConditionMemployeechangeplaterecordeeepyseor c = new ConditionMemployeechangeplaterecordeeepyseor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeechangeplaterecordeeepyseor dao = new QueryMemployeechangeplaterecordeeepyseor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeechangeplaterecordeeepyseor.ALL_CAPTIONS);
			for(BaseMemployeechangeplaterecordeeepyseor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


