package pomplatform.reimbursementpackage.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursementpackage.bean.BaseNormalReimbursementStatus2;
import pomplatform.reimbursementpackage.bean.ConditionNormalReimbursementStatus2;
import pomplatform.reimbursementpackage.query.QueryNormalReimbursementStatus2;
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

public class NormalReimbursementStatus2Handler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NormalReimbursementStatus2Handler.class);

	public static BaseCollection<BaseNormalReimbursementStatus2> executeQueryNormalReimbursementStatus2(ConditionNormalReimbursementStatus2 c, KeyValuePair[] replacements ) throws Exception {
		QueryNormalReimbursementStatus2 dao = new QueryNormalReimbursementStatus2();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNormalReimbursementStatus2> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNormalReimbursementStatus2 c = new ConditionNormalReimbursementStatus2();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNormalReimbursementStatus2> result = executeQueryNormalReimbursementStatus2(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNormalReimbursementStatus2> result;
		ConditionNormalReimbursementStatus2 c = new ConditionNormalReimbursementStatus2();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNormalReimbursementStatus2 dao = new QueryNormalReimbursementStatus2();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNormalReimbursementStatus2.ALL_CAPTIONS);
			for(BaseNormalReimbursementStatus2 b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


