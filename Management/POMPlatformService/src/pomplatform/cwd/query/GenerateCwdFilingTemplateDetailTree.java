package pomplatform.cwd .query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCwdFilingTemplateDetail;
import com.pomplatform.db.dao.CwdFilingTemplateDetail;
import com.pomplatform.db.handler.CwdFilingTemplateDetailHandler;

import delicacy.common.BaseTreeNode;
import delicacy.common.GenericProcessor;

public class GenerateCwdFilingTemplateDetailTree implements GenericProcessor
{


	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		CwdFilingTemplateDetail dao = new CwdFilingTemplateDetail();
		BaseCwdFilingTemplateDetail bean = new BaseCwdFilingTemplateDetail();
		bean.setDataFromJSON(creteria);
		CwdFilingTemplateDetailHandler.setConditions(bean, dao);
		List<BaseCwdFilingTemplateDetail> cwd_filing_template_details = dao.conditionalLoad();
		List<BaseTreeNode> roots = generateRoot(cwd_filing_template_details, bean.getCwdFilingTemplateDetailId() == null ? 0 : bean.getCwdFilingTemplateDetailId());
		for(BaseTreeNode n : roots){
			generateNode(n, cwd_filing_template_details);
		}
		return BaseTreeNode.toJSON(roots);
	}

	private List<BaseTreeNode> generateRoot(List<BaseCwdFilingTemplateDetail> cwd_filing_template_details, Integer parentId){
		List<BaseTreeNode> roots = new ArrayList<>();
		for(BaseCwdFilingTemplateDetail bd : cwd_filing_template_details){
			if(Objects.equals(bd.getParentId(), parentId)){
				BaseTreeNode n = new BaseTreeNode();
				n.setId(bd.getCwdFilingTemplateDetailId());
				n.setTitle(bd.getFileName());
				n.setAttr(bd);
				roots.add(n);
			}
		}
		return roots;
	}

	private void generateNode(BaseTreeNode parent, List<BaseCwdFilingTemplateDetail> cwd_filing_template_details){
		List<BaseTreeNode> children = new ArrayList<>();
		for(BaseCwdFilingTemplateDetail bd : cwd_filing_template_details){
			if(Objects.equals(bd.getParentId(), parent.getId())){
				BaseTreeNode n = new BaseTreeNode();
				n.setId(bd.getCwdFilingTemplateDetailId());
				n.setTitle(bd.getFileName());
				n.setAttr(bd);
				children.add(n);
			}
		}
		if(!children.isEmpty()){
			parent.setChildren(children);
			for(BaseTreeNode n : children){
				generateNode(n, cwd_filing_template_details);
			}
		}
	}

}
