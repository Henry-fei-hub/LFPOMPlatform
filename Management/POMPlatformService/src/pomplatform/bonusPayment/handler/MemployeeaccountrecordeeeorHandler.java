package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseMemployeeaccountrecordeeeor;
import pomplatform.bonusPayment.bean.ConditionMemployeeaccountrecordeeeor;
import pomplatform.bonusPayment.query.QueryMemployeeaccountrecordeeeor;
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

public class MemployeeaccountrecordeeeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeaccountrecordeeeorHandler.class);

	public static BaseCollection<BaseMemployeeaccountrecordeeeor> executeQueryMemployeeaccountrecordeeeor(ConditionMemployeeaccountrecordeeeor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeaccountrecordeeeor dao = new QueryMemployeeaccountrecordeeeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeaccountrecordeeeor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeaccountrecordeeeor c = new ConditionMemployeeaccountrecordeeeor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeaccountrecordeeeor> result = executeQueryMemployeeaccountrecordeeeor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeaccountrecordeeeor> result;
		ConditionMemployeeaccountrecordeeeor c = new ConditionMemployeeaccountrecordeeeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeaccountrecordeeeor dao = new QueryMemployeeaccountrecordeeeor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeaccountrecordeeeor.ALL_CAPTIONS);
			for(BaseMemployeeaccountrecordeeeor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


