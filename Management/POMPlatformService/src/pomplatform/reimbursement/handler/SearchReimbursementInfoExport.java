package pomplatform.reimbursement.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import pomplatform.reimbursement.bean.BaseSearchReimbursementInfo;
import pomplatform.reimbursement.bean.BaseSearchReimbursementInfoExport;
import pomplatform.reimbursement.bean.ConditionSearchReimbursementInfo;
import pomplatform.reimbursement.query.QuerySearchReimbursementInfo;

public class SearchReimbursementInfoExport extends SearchReimbursementInfoHandler {

	private static final Logger __logger = Logger.getLogger(SearchReimbursementInfoExport.class);

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSearchReimbursementInfo> result;
		ConditionSearchReimbursementInfo c = new ConditionSearchReimbursementInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySearchReimbursementInfo dao = new QuerySearchReimbursementInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSearchReimbursementInfoExport.ALL_CAPTIONS);
			BaseSearchReimbursementInfoExport bean = null;
			for(BaseSearchReimbursementInfo b : result.getCollections()){
				bean = new BaseSearchReimbursementInfoExport();
				b.cloneCopy(bean);
				ps.println(bean.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


