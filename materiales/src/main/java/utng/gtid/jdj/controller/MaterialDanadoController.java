package utng.gtid.jdj.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;

import utng.gtid.jdj.DAO.MaterialDañadoDAO;
import utng.gtid.jdj.modelo.MaterialDañado;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class MaterialDanadoController implements Initializable {


    @FXML
    private ComboBox<String> cbMaterial;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private ComboBox<String> cbTipoDanio;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private TextArea txtObservaciones;


    @FXML
    private TableView<MaterialDañado> tablaMaterialDanado;

    @FXML
    private TableColumn<MaterialDañado,Integer> colId;

    @FXML
    private TableColumn<MaterialDañado,Integer> colMaterial;

    @FXML
    private TableColumn<MaterialDañado,LocalDate> colFecha;

    @FXML
    private TableColumn<MaterialDañado,String> colTipo;

    @FXML
    private TableColumn<MaterialDañado,String> colEstado;


    private MaterialDañadoDAO dao;

    private ObservableList<MaterialDañado> lista;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dao = new MaterialDañadoDAO();

        configurarTabla();

        cargarCombos();

        cargarDatos();

        tablaMaterialDanado.setOnMouseClicked(event -> cargarSeleccionado());

    }



    // =========================
    // CONFIGURAR TABLA
    // =========================

    private void configurarTabla(){

        colId.setCellValueFactory(
            dato -> new SimpleIntegerProperty(
                dato.getValue().getIdMaterialDanado()
            ).asObject()
        );


        colMaterial.setCellValueFactory(
            dato -> new SimpleIntegerProperty(
                dato.getValue().getIdMaterial()
            ).asObject()
        );


        colFecha.setCellValueFactory(
            dato -> new SimpleObjectProperty<>(
                dato.getValue().getFechaReporte()
            )
        );


        colTipo.setCellValueFactory(
            dato -> new SimpleStringProperty(
                dato.getValue().getTipoDanio()
            )
        );


        colEstado.setCellValueFactory(
            dato -> new SimpleStringProperty(
                dato.getValue().getEstado()
            )
        );

    }



    // =========================
    // CARGAR DATOS
    // =========================

    private void cargarDatos(){

        lista = FXCollections.observableArrayList(
                dao.consultarTodos()
        );

        tablaMaterialDanado.setItems(lista);

    }



    // =========================
    // COMBOS
    // =========================

    private void cargarCombos(){

        cbMaterial.setItems(
            FXCollections.observableArrayList(
                "1 - Laptop Dell",
                "2 - Mouse Logitech",
                "3 - Monitor Samsung",
                "4 - Teclado HP"
            )
        );


        cbTipoDanio.setItems(
            FXCollections.observableArrayList(
                "Pantalla rota",
                "Cable dañado",
                "No enciende",
                "Golpe físico"
            )
        );


        cbEstado.setItems(
            FXCollections.observableArrayList(
                "Pendiente",
                "Reparación",
                "Reemplazado",
                "Baja"
            )
        );

    }



    // =========================
    // GUARDAR
    // =========================

    @FXML
    private void guardar(){

        try{

            if(cbMaterial.getValue()==null ||
               dpFecha.getValue()==null ||
               cbTipoDanio.getValue()==null ||
               cbEstado.getValue()==null){

                mostrarMensaje(
                    "Completa los campos obligatorios"
                );

                return;
            }



            MaterialDañado md = new MaterialDañado();


            md.setIdMaterial(
                Integer.parseInt(
                    cbMaterial.getValue()
                    .split("-")[0]
                    .trim()
                )
            );


            md.setFechaReporte(
                dpFecha.getValue()
            );


            md.setTipoDanio(
                cbTipoDanio.getValue()
            );


            md.setDescripcion(
                txtDescripcion.getText()
            );


            md.setEstado(
                cbEstado.getValue()
            );


            md.setObservaciones(
                txtObservaciones.getText()
            );


            dao.insertar(md);


            cargarDatos();

            limpiar();


            mostrarMensaje(
                "Material registrado correctamente"
            );


        }catch(Exception e){

            e.printStackTrace();

            mostrarMensaje(
                "Error al guardar"
            );

        }

    }



    // =========================
    // ACTUALIZAR
    // =========================

   @FXML
private void actualizar(){

    MaterialDañado seleccionado =
            tablaMaterialDanado.getSelectionModel().getSelectedItem();


    if(seleccionado == null){
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText("Seleccione un registro de la tabla");
        alerta.show();
        return;
    }


    seleccionado.setIdMaterial(
            Integer.parseInt(
                    cbMaterial.getValue().split("-")[0].trim()
            )
    );


    seleccionado.setFechaReporte(
            dpFecha.getValue()
    );


    seleccionado.setTipoDanio(
            cbTipoDanio.getValue()
    );


    seleccionado.setDescripcion(
            txtDescripcion.getText()
    );


    seleccionado.setEstado(
            cbEstado.getValue()
    );


    seleccionado.setObservaciones(
            txtObservaciones.getText()
    );


    dao.actualizar(seleccionado);


    cargarDatos();


    limpiar();


    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    alerta.setTitle("Actualización");
    alerta.setHeaderText(null);
    alerta.setContentText("Material actualizado correctamente");
    alerta.show();

}

    // =========================
    // ELIMINAR
    // =========================

    @FXML
    private void eliminar(){

        MaterialDañado md =
            tablaMaterialDanado
            .getSelectionModel()
            .getSelectedItem();


        if(md!=null){

            dao.eliminar(
                md.getIdMaterialDanado()
            );

            cargarDatos();

        }

    }



    // =========================
    // LIMPIAR
    // =========================

    @FXML
    private void limpiar(){

        cbMaterial.setValue(null);
        dpFecha.setValue(null);
        cbTipoDanio.setValue(null);
        cbEstado.setValue(null);

        txtDescripcion.clear();
        txtObservaciones.clear();

    }



    private void mostrarMensaje(String mensaje){

        Alert alerta =
            new Alert(Alert.AlertType.INFORMATION);

        alerta.setContentText(mensaje);

        alerta.show();
        

    }





    private void cargarSeleccionado(){

    MaterialDañado md =
            tablaMaterialDanado.getSelectionModel().getSelectedItem();


    if(md != null){

        cbMaterial.setValue(
                md.getIdMaterial() + " - "
        );

        dpFecha.setValue(
                md.getFechaReporte()
        );

        cbTipoDanio.setValue(
                md.getTipoDanio()
        );

        txtDescripcion.setText(
                md.getDescripcion()
        );

        cbEstado.setValue(
                md.getEstado()
        );

        txtObservaciones.setText(
                md.getObservaciones()
        );

    }

}

}



