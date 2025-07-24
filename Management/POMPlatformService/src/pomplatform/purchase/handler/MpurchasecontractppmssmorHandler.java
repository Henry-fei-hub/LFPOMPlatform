package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseMpurchasecontractppmssmor;
import pomplatform.purchase.bean.ConditionMpurchasecontractppmssmor;
import pomplatform.purchase.query.QueryMpurchasecontractppmssmor;
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

public class MpurchasecontractppmssmorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MpurchasecontractppmssmorHandler.class);

	public static BaseCollection<BaseMpurchasecontractppmssmor> executeQueryMpurchasecontractppmssmor(ConditionMpurchasecontractppmssmor c, KeyValuePair[] replacements ) throws Exception {
		QueryMpurchasecontractppmssmor dao = new QueryMpurchasecontractppmssmor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMpurchasecontractppmssmor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMpurchasecontractppmssmor c = new ConditionMpurchasecontractppmssmor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMpurchasecontractppmssmor> result = executeQueryMpurchasecontractppmssmor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMpurchasecontractppmssmor> result;
		ConditionMpurchasecontractppmssmor c = new ConditionMpurchasecontractppmssmor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMpurchasecontractppmssmor dao = new QueryMpurchasecontractppmssmor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMpurchasecontractppmssmor.ALL_CAPTIONS);
			for(BaseMpurchasecontractppmssmor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


