package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.concretes.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService {
	void save(User user);
	Result add(User user);
	Result delete(User user);
	DataResult<List<User>> getAll();
	User findByEmailAdressAndPassword(String email, String password);

}
