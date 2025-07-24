package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseOvertimeApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionOvertimeApply;
import pomplatform.workflow.personnelbusiness.query.QueryOvertimeApply;
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

public class OvertimeApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OvertimeApplyHandler.class);

	public static BaseCollection<BaseOvertimeApply> executeQueryOvertimeApply(ConditionOvertimeApply c, KeyValuePair[] replacements ) throws Exception {
		QueryOvertimeApply dao = new QueryOvertimeApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOvertimeApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOvertimeApply c = new ConditionOvertimeApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOvertimeApply> result = executeQueryOvertimeApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOvertimeApply> result;
		ConditionOvertimeApply c = new ConditionOvertimeApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOvertimeApply dao = new QueryOvertimeApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOvertimeApply.ALL_CAPTIONS);
			for(BaseOvertimeApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


