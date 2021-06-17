package kodlamaio.hrms.core.utilities.verificationCode;

import org.springframework.stereotype.Service;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	@Override
	public boolean sendVerificationCode(String email) {
		System.out.println(email + " mail hesabına doğrulama kodu gönderildi.");
		return true;
	}

}
