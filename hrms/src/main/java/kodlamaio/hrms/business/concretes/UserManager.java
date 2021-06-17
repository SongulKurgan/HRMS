package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.abstracts.UserDao;
import kodlamaio.hrms.core.concretes.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
    
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
		this.userDao.save(user);
		
	}

	@Override
	public User findByEmailAdressAndPassword(String email, String password) {
		return null;
	}


	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult(Messages.userDeleted);
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(Messages.userAdded);
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),Messages.usersListed);
	}

}