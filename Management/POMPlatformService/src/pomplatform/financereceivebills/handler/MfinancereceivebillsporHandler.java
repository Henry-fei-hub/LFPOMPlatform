package pomplatform.financereceivebills.handler;

import org.apache.log4j.Logger;
import pomplatform.financereceivebills.bean.BaseMfinancereceivebillspor;
import pomplatform.financereceivebills.bean.ConditionMfinancereceivebillspor;
import pomplatform.financereceivebills.query.QueryMfinancereceivebillspor;
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

public class MfinancereceivebillsporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MfinancereceivebillsporHandler.class);

	public static BaseCollection<BaseMfinancereceivebillspor> executeQueryMfinancereceivebillspor(ConditionMfinancereceivebillspor c, KeyValuePair[] replacements ) throws Exception {
		QueryMfinancereceivebillspor dao = new QueryMfinancereceivebillspor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMfinancereceivebillspor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMfinancereceivebillspor c = new ConditionMfinancereceivebillspor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMfinancereceivebillspor> result = executeQueryMfinancereceivebillspor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMfinancereceivebillspor> result;
		ConditionMfinancereceivebillspor c = new ConditionMfinancereceivebillspor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMfinancereceivebillspor dao = new QueryMfinancereceivebillspor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMfinancereceivebillspor.ALL_CAPTIONS);
			for(BaseMfinancereceivebillspor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


