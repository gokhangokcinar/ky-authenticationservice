package tr.gov.msb.authenticationservice.service;

import java.util.List;

import tr.gov.msb.authenticationservice.model.User;



public interface UserService {
	List<User> kullaniciListesiGetir();
	User kaydetKullanici(User user);
	void silKullanici(Long id);
	User kullaniciGetir(Long id);
	List<User> kullaniciAdiveSifreBilgisineGoreKullaniciGetir(String username, String password);
}
