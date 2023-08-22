package tr.gov.msb.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.msb.authenticationservice.model.LoginUser;
import tr.gov.msb.authenticationservice.model.User;
import tr.gov.msb.authenticationservice.service.UserService;
import tr.gov.msb.authenticationservice.util.JwtUtil;

@RestController
public class AuthRestController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/auth/login")
	public ResponseEntity<String> login(@RequestBody LoginUser loginUser) {
		if (isAuthenticated(loginUser) == null) {
			return new ResponseEntity<String>("Kullanıcı doğrulama başarısız", HttpStatus.OK);
		} else {
			String token = jwtUtil.generateToken(loginUser.getKullaniciAdi());
			return new ResponseEntity<String>(token, HttpStatus.OK);
		}
	}

	private User isAuthenticated(LoginUser loginUser) {
		List<User> users = userService.kullaniciAdiveSifreBilgisineGoreKullaniciGetir(loginUser.getKullaniciAdi(),
				loginUser.getKullaniciSifre());
		if(users.size()<1) {
			return null;
		}else {
		return users.get(0);
		}
	}

	@PostMapping("/auth/register")
	public ResponseEntity<String> register(@RequestBody String userName) {
		// Persist user to some persistent storage
		System.out.println("Info saved...");

		return new ResponseEntity<String>("Registered", HttpStatus.OK);
	}

}
