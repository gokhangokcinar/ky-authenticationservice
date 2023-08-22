package tr.gov.msb.authenticationservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kullanici_adi")
    private String kullaniciAdi;
    
    @Column(name = "kullanici_sifre")
    private String kullaniciSifre;
    
    @Column(name = "adi")
    private String adi;
    
    @Column(name = "soyadi")
    private String soyadi;
    
    @Column(name = "unvan")
    private String unvan;
    
    @Column(name = "e_posta")
    private String ePosta;
    
    @Column(name = "telefon")
    private String telefon;
    
    @Column(name = "son_giris_tarihi")
    private LocalDateTime sonGirisTarihi;


    @Column(name = "aciklama")
    private String aciklama;
    
    @Column(name="aktif")
    private Integer aktif;

    @Column(name = "kayit_yapan_kullanici")
    private String kayitYapanKullanici;

    @Column(name = "kayit_tarihi")
    private LocalDateTime kayitTarihi;

}
