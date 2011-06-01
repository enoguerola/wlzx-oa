package system.wlims.oa.serviceImpl.course.adjust;
import java.util.Date;

import system.utils.UtilDateTime;
import system.wlims.oa.dao.course.adjust.ApplyDAO;
import system.wlims.oa.entity.course.adjust.ApplyModel;
import system.wlims.oa.service.course.adjust.ApplyService;

public class ApplyServiceImpl implements ApplyService{
	private ApplyDAO applyDAO;

	public ApplyDAO getApplyDAO() {
		return applyDAO;
	}

	public void setApplyDAO(ApplyDAO applyDAO) {
		this.applyDAO = applyDAO;
	}

	@Override
	public boolean applyAdd(ApplyModel apply) {
		// TODO Auto-generated method stub
		Date currenDate=new Date();
		apply.setApplyNo(UtilDateTime.toDateString(currenDate, "yyyyMMddhhmmss"));
		apply.setApplyCreationDate(currenDate);
		apply.setApplyStatus(ApplyModel.ApplyStatus.WAITING.getStatus());
		applyDAO.saveOrUpdate(apply);
		return true;
	}
}
