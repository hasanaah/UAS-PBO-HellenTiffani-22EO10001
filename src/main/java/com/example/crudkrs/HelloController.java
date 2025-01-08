package com.example.crudkrs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUbah;

    @FXML
    private Label lblMP;

    @FXML
    private Label lblNIM;

    @FXML
    private Label lblSemester;

    @FXML
    private Label lblValidasi;

    @FXML
    private Label lblNama;

    @FXML
    private TextField txt_MP;

    @FXML
    private TextField txt_NIM;

    @FXML
    private TextField txt_Nama;

    @FXML
    private TextField txt_Semester;

    @FXML
    private TextField txt_Validasi;

    @FXML
    private TableView<ModelData> tableView;  // TableView untuk menampilkan data

    @FXML
    private TableColumn<ModelData, String> colNama;

    @FXML
    private TableColumn<ModelData, String> colNIM;

    @FXML
    private TableColumn<ModelData, String> colMP;

    @FXML
    private TableColumn<ModelData, String> colSemester;

    @FXML
    private TableColumn<ModelData, String> colValidasi;

    // ObservableList untuk menyimpan data ModelData
    private ObservableList<ModelData> dataList;

    public HelloController() {
        // Menginisialisasi ObservableList
        dataList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        // Mengikat data ke kolom di TableView
        colNama.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        colNIM.setCellValueFactory(cellData -> cellData.getValue().nimProperty());
        colMP.setCellValueFactory(cellData -> cellData.getValue().mpProperty());
        colSemester.setCellValueFactory(cellData -> cellData.getValue().semesterProperty());
        colValidasi.setCellValueFactory(cellData -> cellData.getValue().validasiProperty());

        // Menghubungkan TableView dengan ObservableList
        tableView.setItems(dataList);
    }

    // Method untuk menangani tombol Tambah
    @FXML
    void btnTambah(ActionEvent event) {
        if (isInputValid()) {
            // Menambahkan data baru ke dalam ObservableList
            ModelData newData = new ModelData(
                    txt_Nama.getText(),
                    txt_NIM.getText(),
                    txt_MP.getText(),
                    txt_Semester.getText(),
                    txt_Validasi.getText()
            );

            // Menambahkan data baru ke dalam ObservableList
            dataList.add(newData);

            // Menampilkan pesan di terminal (bisa dihapus nantinya)
            System.out.println("Tambah button clicked!");
            System.out.println("Nama: " + newData.getNama());  // Sekarang bisa menggunakan getNama()
            System.out.println("NIM: " + newData.getNim());
            System.out.println("MP: " + newData.getMp());
            System.out.println("Semester: " + newData.getSemester());
            System.out.println("Validasi: " + newData.getValidasi());
        } else {
            System.out.println("Input tidak valid.");
        }
    }

    // Method untuk menangani tombol Hapus
    @FXML
    void btnHapus(ActionEvent event) {
        // Mendapatkan item yang terpilih pada TableView
        ModelData selectedData = tableView.getSelectionModel().getSelectedItem();
        if (selectedData != null) {
            // Menghapus data dari ObservableList
            dataList.remove(selectedData);
            System.out.println("Data telah dihapus.");
        } else {
            System.out.println("Pilih data terlebih dahulu untuk dihapus.");
        }
    }

    // Method untuk menangani tombol Reset
    @FXML
    void btnReset(ActionEvent event) {
        txt_Nama.clear();
        txt_NIM.clear();
        txt_MP.clear();
        txt_Semester.clear();
        txt_Validasi.clear();
        System.out.println("Reset button clicked!");
    }

    // Method untuk menangani tombol Ubah
    @FXML
    void btnUbah(ActionEvent event) {
        // Mendapatkan item yang terpilih pada TableView
        ModelData selectedData = tableView.getSelectionModel().getSelectedItem();
        if (selectedData != null && isInputValid()) {
            // Memperbarui data
            selectedData.setNama(txt_Nama.getText());
            selectedData.setNim(txt_NIM.getText());
            selectedData.setMp(txt_MP.getText());
            selectedData.setSemester(txt_Semester.getText());
            selectedData.setValidasi(txt_Validasi.getText());

            // Menyegarkan TableView
            tableView.refresh();
            System.out.println("Data telah diubah.");
        } else {
            System.out.println("Pilih data terlebih dahulu untuk diubah.");
        }
    }

    // Method untuk validasi input
    private boolean isInputValid() {
        if (txt_Nama.getText().isEmpty() ||
                txt_NIM.getText().isEmpty() ||
                txt_MP.getText().isEmpty() ||
                txt_Semester.getText().isEmpty() ||
                txt_Validasi.getText().isEmpty()) {
            System.out.println("Semua field harus diisi.");
            return false;
        }
        if (!txt_NIM.getText().matches("\\d+")) {
            System.out.println("NIM harus berupa angka.");
            return false;
        }
        return true;
    }
}
