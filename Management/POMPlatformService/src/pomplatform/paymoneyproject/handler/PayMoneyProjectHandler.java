package pomplatform.paymoneyproject.handler;

import org.apache.log4j.Logger;
import pomplatform.paymoneyproject.bean.BasePayMoneyProject;
import pomplatform.paymoneyproject.bean.ConditionPayMoneyProject;
import pomplatform.paymoneyproject.query.QueryPayMoneyProject;
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

public class PayMoneyProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PayMoneyProjectHandler.class);

	public static BaseCollection<BasePayMoneyProject> executeQueryPayMoneyProject(ConditionPayMoneyProject c, KeyValuePair[] replacements ) throws Exception {
		QueryPayMoneyProject dao = new QueryPayMoneyProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePayMoneyProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPayMoneyProject c = new ConditionPayMoneyProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePayMoneyProject> result = executeQueryPayMoneyProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePayMoneyProject> result;
		ConditionPayMoneyProject c = new ConditionPayMoneyProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPayMoneyProject dao = new QueryPayMoneyProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePayMoneyProject.ALL_CAPTIONS);
			for(BasePayMoneyProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


