package tr.gov.msb.authenticationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import tr.gov.msb.authenticationservice.model.User;
import tr.gov.msb.authenticationservice.service.repository.UserRepository;





@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> kullaniciListesiGetir() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User kaydetKullanici(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void silKullanici(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public User kullaniciGetir(Long id) {
		// TODO Auto-generated method stub
		return	userRepository.getById(id);
	}


	@Override
	public List<User> kullaniciAdiveSifreBilgisineGoreKullaniciGetir(String username, String password) {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findByKullaniciAdiAndKullaniciSifre(username, password);
		return users;
	}

}
