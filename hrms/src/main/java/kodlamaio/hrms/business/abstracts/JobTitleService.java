package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	void save(JobTitle jobTitle);
	Result add(JobTitle jobTitle);
	Result delete(JobTitle jobTitle);
	DataResult<List<JobTitle>> getAll();

}
