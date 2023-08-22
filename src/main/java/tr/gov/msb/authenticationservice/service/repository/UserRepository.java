package tr.gov.msb.authenticationservice.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.msb.authenticationservice.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

 List<User> findByKullaniciAdiAndKullaniciSifre(String kullaniciAdi, String kullaniciSifre);
}
