/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuanduabelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "mata_kuliah")
@NamedQueries({
    @NamedQuery(name = "MataKuliah.findAll", query = "SELECT m FROM MataKuliah m"),
    @NamedQuery(name = "MataKuliah.findByKodeMk", query = "SELECT m FROM MataKuliah m WHERE m.kodeMk = :kodeMk"),
    @NamedQuery(name = "MataKuliah.findBySks", query = "SELECT m FROM MataKuliah m WHERE m.sks = :sks"),
    @NamedQuery(name = "MataKuliah.findByNamaMk", query = "SELECT m FROM MataKuliah m WHERE m.namaMk = :namaMk"),
    @NamedQuery(name = "MataKuliah.findBySemesterAjar", query = "SELECT m FROM MataKuliah m WHERE m.semesterAjar = :semesterAjar")})
public class MataKuliah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode_mk")
    private String kodeMk;
    @Column(name = "sks")
    private Integer sks;
    @Column(name = "nama_mk")
    private String namaMk;
    @Column(name = "semester_ajar")
    private Integer semesterAjar;

    public MataKuliah() {
    }

    public MataKuliah(String kodeMk) {
        this.kodeMk = kodeMk;
    }

    public String getKodeMk() {
        return kodeMk;
    }

    public void setKodeMk(String kodeMk) {
        this.kodeMk = kodeMk;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }

    public String getNamaMk() {
        return namaMk;
    }

    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    public Integer getSemesterAjar() {
        return semesterAjar;
    }

    public void setSemesterAjar(Integer semesterAjar) {
        this.semesterAjar = semesterAjar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeMk != null ? kodeMk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MataKuliah)) {
            return false;
        }
        MataKuliah other = (MataKuliah) object;
        if ((this.kodeMk == null && other.kodeMk != null) || (this.kodeMk != null && !this.kodeMk.equals(other.kodeMk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pertemuanduabelas.MataKuliah[ kodeMk=" + kodeMk + " ]";
    }
    
}
