package com.example.crudkrs;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelData {

    private final StringProperty nama;
    private final StringProperty nim;
    private final StringProperty mp;
    private final StringProperty semester;
    private final StringProperty validasi;

    // Constructor dengan argumen
    public ModelData(String nama, String nim, String mp, String semester, String validasi) {
        this.nama = new SimpleStringProperty(nama);
        this.nim = new SimpleStringProperty(nim);
        this.mp = new SimpleStringProperty(mp);
        this.semester = new SimpleStringProperty(semester);
        this.validasi = new SimpleStringProperty(validasi);
    }

    // Constructor tanpa argumen (untuk beberapa kasus seperti binding kosong)
    public ModelData() {
        this.nama = new SimpleStringProperty("");
        this.nim = new SimpleStringProperty("");
        this.mp = new SimpleStringProperty("");
        this.semester = new SimpleStringProperty("");
        this.validasi = new SimpleStringProperty("");
    }

    // Getter dan Setter untuk properti nama
    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public StringProperty namaProperty() {
        return nama;
    }

    // Getter dan Setter untuk properti nim
    public String getNim() {
        return nim.get();
    }

    public void setNim(String nim) {
        this.nim.set(nim);
    }

    public StringProperty nimProperty() {
        return nim;
    }

    // Getter dan Setter untuk properti mp
    public String getMp() {
        return mp.get();
    }

    public void setMp(String mp) {
        this.mp.set(mp);
    }

    public StringProperty mpProperty() {
        return mp;
    }

    // Getter dan Setter untuk properti semester
    public String getSemester() {
        return semester.get();
    }

    public void setSemester(String semester) {
        this.semester.set(semester);
    }

    public StringProperty semesterProperty() {
        return semester;
    }

    // Getter dan Setter untuk properti validasi
    public String getValidasi() {
        return validasi.get();
    }

    public void setValidasi(String validasi) {
        this.validasi.set(validasi);
    }

    public StringProperty validasiProperty() {
        return validasi;
    }
}
