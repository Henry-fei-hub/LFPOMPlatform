package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseBeProjectApply;
import pomplatform.preProjects.bean.ConditionBeProjectApply;
import pomplatform.preProjects.query.QueryBeProjectApply;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.bean.BaseMainProjectSpecialty;
import com.pomplatform.db.dao.MainProjectSpecialty;
import com.pomplatform.db.bean.BaseMainProjectCompetitionUnit;
import com.pomplatform.db.dao.MainProjectCompetitionUnit;
import delicacy.common.BaseCollection;

public class BeProjectApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BeProjectApplyHandler.class);

	public static BaseCollection<BaseBeProjectApply> executeQueryBeProjectApply(ConditionBeProjectApply c, KeyValuePair[] replacements ) throws Exception {
		QueryBeProjectApply dao = new QueryBeProjectApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBeProjectApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			MainProjectBusinessType daoMainProjectBusinessType = new MainProjectBusinessType();
			MainProjectSpecialty daoMainProjectSpecialty = new MainProjectSpecialty();
			MainProjectCompetitionUnit daoMainProjectCompetitionUnit = new MainProjectCompetitionUnit();
			for(BaseBeProjectApply bean : result.getCollections()){
				daoMainProjectBusinessType.setConditionMainProjectId("=", bean.getPreProjectId());
				bean.setDetailMainProjectBusinessType(daoMainProjectBusinessType.conditionalLoad(null));
				daoMainProjectSpecialty.setConditionMainProjectId("=", bean.getPreProjectId());
				bean.setDetailMainProjectSpecialty(daoMainProjectSpecialty.conditionalLoad(null));
				daoMainProjectCompetitionUnit.setConditionMainProjectId("=", bean.getPreProjectId());
				bean.setDetailMainProjectCompetitionUnit(daoMainProjectCompetitionUnit.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBeProjectApply c = new ConditionBeProjectApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBeProjectApply> result = executeQueryBeProjectApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBeProjectApply> result;
		ConditionBeProjectApply c = new ConditionBeProjectApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBeProjectApply dao = new QueryBeProjectApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBeProjectApply.ALL_CAPTIONS);
			for(BaseBeProjectApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


