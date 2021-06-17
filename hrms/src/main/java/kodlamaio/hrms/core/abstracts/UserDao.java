package kodlamaio.hrms.core.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {
	public User getByEmailEquals(String email);
}