/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.healio.pharmacie.entite.Medicament;
import tn.esprit.healio.pharmacie.entite.OrdMed;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import tn.esprit.healio.pharmacie.service.MedicamentService;
import tn.esprit.healio.pharmacie.service.OrdMedService;
import tn.esprit.healio.pharmacie.service.OrdonnanceService;

/**
 * FXML Controller class
 *
 * @author AMINE
 */
public class OrdMedController implements Initializable {

    @FXML
    private TextField tford;
    @FXML
    private TextField tffreq;
    @FXML
    private TextField tfnour;
    @FXML
    private TextField tfqte;
    @FXML
    private Button btaj;
    @FXML
    private Button btup;
    @FXML
    private Button btdel;
    @FXML
    private TableColumn<OrdMed, Integer> clmed;
    @FXML
    private TableColumn<OrdMed, String> clfreq;
    @FXML
    private TableColumn<OrdMed, String> clnour;
    @FXML
    private TableColumn<OrdMed, String> clqte;

    /**
     * Initializes the controller class.
     */
    
    private Ordonnance ordonnance;
    @FXML
    private ComboBox<Integer> cbxMed;
    @FXML
    private TableView<OrdMed> tv;
    private OrdMedService oms;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        OrdonnanceService os = new OrdonnanceService();
        MedicamentService ms = new MedicamentService();
        cbxMed.getItems().addAll(ms.readAllId());
    }    
    public void setParameter(Ordonnance Ord)
    {
        try {
            this.ordonnance=Ord;
           System.out.println("setParameter - this.ordonnance : "+ this.ordonnance);

            System.out.println(ordonnance);
                    showOrdMed();

        } catch (Exception e) {
            System.out.println("cant get ordonnance");
        }
        
        tford.setText(""+Ord.getIdOrdonnance());
        
    }

    @FXML
    private void handleAjout(ActionEvent event) {
        MedicamentService ms = new MedicamentService();
        Medicament med = ms.readById(cbxMed.getSelectionModel().getSelectedItem());
        OrdMed om = new OrdMed(ordonnance,med, tffreq.getText(), tfnour.getText(), tfqte.getText());
        OrdMedService oms = new OrdMedService();
        oms.insert(om);
        System.out.println("element ajouté");
        showOrdMed();
    }

    @FXML
    private void handleModif(ActionEvent event) {
    }

    @FXML
    private void handleSupprimer(ActionEvent event) {
    }
    private void showOrdMed() {
    OrdMedService om = new OrdMedService();
    List<OrdMed> ordMedList = om.readAllItems(this.ordonnance.getIdOrdonnance());
    System.out.println("List exists");
    clmed.setCellValueFactory(data -> {
        OrdMed ordMed = data.getValue();
        Medicament medicament = ordMed.getMedicament();
        int idMedicament = medicament.getIdMedicament();
        return new SimpleIntegerProperty(idMedicament).asObject();
    });
    clfreq.setCellValueFactory(new PropertyValueFactory<>("frequence"));
    clnour.setCellValueFactory(new PropertyValueFactory<>("nouriture"));
    clqte.setCellValueFactory(new PropertyValueFactory<>("quantite"));

    tv.setItems(FXCollections.observableArrayList(ordMedList));
}
    public void update()
    {
        
    }

    @FXML
    private void generatepdf(ActionEvent event) {
        OrdMedService om = new OrdMedService();
        List<OrdMed> ordMedList = om.readAllItems(this.ordonnance.getIdOrdonnance());
        try {
            String fileName = "C:\\Users\\AMINE\\Documents\\PIDEV\\pdf\\ordonnance"+this.ordonnance.getIdOrdonnance()+".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            
            Paragraph para = new Paragraph("Bonjour, voici l ordonnace numero : "+ this.ordonnance.getIdOrdonnance());
            Paragraph para1 = new Paragraph("Le medecin : "+ this.ordonnance.getIdMedecin());
            Paragraph para2 = new Paragraph("Le patient : "+ this.ordonnance.getIdClient());
            Paragraph para3 = new Paragraph("Date : "+this.ordonnance.getDateTraitement());
            
            document.add(para);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            
            for (OrdMed ordM : ordMedList)
            {
            Paragraph ordMedDet = new Paragraph(ordM.toString());
            document.add(ordMedDet);
            }
            document.close();
            System.out.println("finished");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
