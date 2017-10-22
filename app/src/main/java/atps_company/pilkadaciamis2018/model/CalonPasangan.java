package atps_company.pilkadaciamis2018.model;

import java.io.Serializable;

/**
 * Created by emerio on 10/10/17.
 */

public class CalonPasangan implements Serializable{

    private String id,biodata;
    private String nama;

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }

    private String nourut;

    public String getNourut() {
        return nourut;
    }

    public void setNourut(String nourut) {
        this.nourut = nourut;
    }

    private String visi;
    private String misi;
    private String imagePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
