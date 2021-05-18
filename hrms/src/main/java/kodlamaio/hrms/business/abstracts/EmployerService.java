package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	void save(Employer employer);
	List<Employer> getAll();
	Employer getById(int id);

}
