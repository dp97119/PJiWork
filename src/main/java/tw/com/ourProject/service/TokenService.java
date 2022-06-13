package tw.com.ourProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.ourProject.model.Temptoken;
import tw.com.ourProject.repository.TempTokenRepo;
@Service
public class TokenService {
	
	@Autowired
	public TempTokenRepo tempTokenRepo;
	
	public Temptoken tempToken = new Temptoken();
	
	public void saveToken(String userToken) {
//		tempToken.setTokenId(1);
//		tempToken.setTokenValue(userToken);
//		tempTokenRepo.save(tempToken);
		Boolean rs = tempTokenRepo.existsBy();
		System.out.println(rs);
	}
}
