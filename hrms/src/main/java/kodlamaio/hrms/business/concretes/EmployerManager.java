package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.abstracts.UserDao;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verificationCode.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private  UserDao userDao;
	private  VerificationCodeService verificationCodeService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao, VerificationCodeService verificationCodeService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
		
	}

	@Override
	public void save(Employer employer) {
		this.employerDao.save(employer);
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.employersListed);
	}


	@Override
	public Result register(Employer employer) {
		Result result = BusinessRules.run(existEmail(employer.getEmail()),
				checkWebAddress(employer.getWebAddress(),employer.getEmail()));

		if (result != null) {
			return result;
		}

		this.verificationCodeService.sendVerificationCode(employer.getEmail());
		this.employerDao.save(employer);
		return new SuccessResult(Messages.employerAdded);
	}
	
       private Result checkWebAddress(String website, String email) {
		
		String domain = email.split("@")[1];
		
		if(!website.contains(domain)) {
			return new ErrorResult("Email adresi website domaini ile örtüşmüyor");
		}
		
		return new SuccessResult();
	}
	
	private Result existEmail(String email) {
		if (this.userDao.getByEmailEquals(email)!=null) {
			return new ErrorResult("Email adresi ile daha önce kayıt oluşturulmuştur");
		}
		
		return new SuccessResult();
	}
	

}
