package system.wlims.oa.serviceImpl.course.adjust;
import system.wlims.oa.dao.course.adjust.ApplyDAO;
import system.wlims.oa.service.course.adjust.ApplyService;

public class ApplyServiceImpl implements ApplyService{
	private ApplyDAO applyDAO;

	public ApplyDAO getApplyDAO() {
		return applyDAO;
	}

	public void setApplyDAO(ApplyDAO applyDAO) {
		this.applyDAO = applyDAO;
	}
}
