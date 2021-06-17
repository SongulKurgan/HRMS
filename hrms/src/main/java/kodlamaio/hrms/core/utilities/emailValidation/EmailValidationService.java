package kodlamaio.hrms.core.utilities.emailValidation;

public interface EmailValidationService {
	public void sendVerificationMail(String email);
	public boolean isEmailVerified(String email);

}
