package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
