package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	@Override
	public void save(Candidate candidate) {
		this.candidateDao.save(candidate);
		
	}

	@Override
	public List<Candidate> getAll() {
		return this.candidateDao.findAll();
	}

	@Override
	public Candidate getById(int id) {
		return this.candidateDao.findById(id).orElse(null);
	}

}
