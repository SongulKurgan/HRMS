package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public void save(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), Messages.jobTitlesListed);
	}

	

	@Override
	public Result add(JobTitle jobTitle) {
		Result result = BusinessRules.run(existJobTitle(jobTitle.getTitle()));

		if (result != null) {
			return result;
		}

		this.jobTitleDao.save(jobTitle);
		return new SuccessResult(Messages.jobTitleAdded);
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult(Messages.jobTitleDeleted);
	}

	
	private Result existJobTitle(String jobTitle) {
		if (this.jobTitleDao.getByTitleEquals(jobTitle) != null) {
			return new ErrorResult("Bu pozisyon ismi daha önce oluşturulmuştur");
		}
		return new SuccessResult();
	}
	

}
