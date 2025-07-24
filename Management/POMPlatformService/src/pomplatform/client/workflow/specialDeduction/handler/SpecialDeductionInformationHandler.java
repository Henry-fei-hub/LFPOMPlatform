package pomplatform.client.workflow.specialDeduction.handler;

import org.apache.log4j.Logger;

import pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionInformation;
import pomplatform.client.workflow.specialDeduction.bean.ConditionSpecialDeductionInformation;
import pomplatform.client.workflow.specialDeduction.query.QuerySpecialDeductionInformation;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseSpecialDeductionDetail;
import com.pomplatform.db.dao.SpecialDeductionDetail;
import delicacy.common.BaseCollection;

public class SpecialDeductionInformationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SpecialDeductionInformationHandler.class);

	public static BaseCollection<BaseSpecialDeductionInformation> executeQueryspecialDeductionInformation(ConditionSpecialDeductionInformation c, KeyValuePair[] replacements ) throws Exception {
		QuerySpecialDeductionInformation dao = new QuerySpecialDeductionInformation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSpecialDeductionInformation> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			SpecialDeductionDetail daoSpecialDeductionDetail = new SpecialDeductionDetail();
			for(BaseSpecialDeductionInformation bean : result.getCollections()){
				daoSpecialDeductionDetail.setConditionParentId("=", bean.getSpecialDeductionRecordId());
				bean.setDetailSpecialDeductionDetail(daoSpecialDeductionDetail.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSpecialDeductionInformation c = new ConditionSpecialDeductionInformation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSpecialDeductionInformation> result = executeQueryspecialDeductionInformation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSpecialDeductionInformation> result;
		ConditionSpecialDeductionInformation c = new ConditionSpecialDeductionInformation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySpecialDeductionInformation dao = new QuerySpecialDeductionInformation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSpecialDeductionInformation.ALL_CAPTIONS);
			for(BaseSpecialDeductionInformation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


