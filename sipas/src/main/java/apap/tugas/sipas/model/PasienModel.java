package apap.tugas.sipas.model;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="PASIEN")

public class PasienModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "kode", nullable = false)
    private String kode;

    @NotNull
    @Size(max=255)
    @Column(name = "nik", nullable = false)
    private String nik;

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggal_lahir;

    @NotNull
    @Size(max=255)
    @Column(name = "tempat_lahir", nullable = false)
    private String tempat_lahir;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private Integer jenis_kelamin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Integer getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(Integer jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }


    @ManyToMany(mappedBy = "listPasienDiagnosis")
    private List<DiagnosisModel> listDiagnosisPenyakit;

    @ManyToMany(mappedBy = "listPasienAsuransi")
    private List<AsuransiModel> listAsuransi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_emergency_contact", referencedColumnName = "id")
    private EmergencyContactModel emergencyContact;


}
