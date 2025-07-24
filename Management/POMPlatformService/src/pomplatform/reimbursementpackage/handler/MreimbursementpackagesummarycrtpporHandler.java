package pomplatform.reimbursementpackage.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursementpackage.bean.BaseMreimbursementpackagesummarycrtppor;
import pomplatform.reimbursementpackage.bean.ConditionMreimbursementpackagesummarycrtppor;
import pomplatform.reimbursementpackage.query.QueryMreimbursementpackagesummarycrtppor;
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

public class MreimbursementpackagesummarycrtpporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MreimbursementpackagesummarycrtpporHandler.class);

	public static BaseCollection<BaseMreimbursementpackagesummarycrtppor> executeQueryMreimbursementpackagesummarycrtppor(ConditionMreimbursementpackagesummarycrtppor c, KeyValuePair[] replacements ) throws Exception {
		QueryMreimbursementpackagesummarycrtppor dao = new QueryMreimbursementpackagesummarycrtppor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMreimbursementpackagesummarycrtppor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMreimbursementpackagesummarycrtppor c = new ConditionMreimbursementpackagesummarycrtppor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMreimbursementpackagesummarycrtppor> result = executeQueryMreimbursementpackagesummarycrtppor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMreimbursementpackagesummarycrtppor> result;
		ConditionMreimbursementpackagesummarycrtppor c = new ConditionMreimbursementpackagesummarycrtppor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMreimbursementpackagesummarycrtppor dao = new QueryMreimbursementpackagesummarycrtppor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMreimbursementpackagesummarycrtppor.ALL_CAPTIONS);
			for(BaseMreimbursementpackagesummarycrtppor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


