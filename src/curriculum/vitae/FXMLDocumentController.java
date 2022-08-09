package curriculum.vitae;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;



public class FXMLDocumentController implements Initializable {
    String rootto;
    final FileChooser fc = new FileChooser();
    @FXML private TextField tfNombre;
    @FXML private TextField tfApellido;
    @FXML private TextField tfIdentidad;
    @FXML private TextField tfEdad;
    @FXML private TextField tfTelefono;
    @FXML private TextField tfEmail;
    @FXML private TextField tfInstitucion;
    @FXML private TextField tfGrado;
    @FXML private TextField tfEmpresa;
    @FXML private TextField tfCargo;
    @FXML private TextArea tfLogros;
    @FXML private DatePicker fechaIni1;
    @FXML private DatePicker FechaFin1;
    @FXML private DatePicker FechaIni2;
    @FXML private DatePicker FechaFin2;
    @FXML private Button btnOpenImgFile;
    @FXML private ImageView ivFile;
    @FXML private Button btGuardar;
    @FXML private Button btLimpiar;
    private ArrayList<String> errores;
    
    
    
    @FXML
    private GridPane panel;
    @FXML
    private Button exitbtn;
    
    
    @FXML
    private void handleOpenImgFile(ActionEvent event) {
        //Imagen
        
        //Lector de Archivos
        
        //Damos titulo al Lector de archivos
        fc.setTitle("Foto de Perfil");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        //Aplicamos un filtro solo para imagenes
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*.gif"));
        File file=fc.showOpenDialog(null);
        if (file != null){
            ivFile.setImage(new Image(file.toURI().toString()));
            rootto = file.getPath();
        }
        else{
            rootto= "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-hombre-icono-de-usuario-aislado-en-un-fondo-blanco-avatar-cuenta-para-la-web-foto-de-perfil-de-usuar.jpg";
        }
        
    }
    @FXML private void handleButtonAction (ActionEvent event){
        
        
        String espacios = "     ";
        String nombre = tfNombre.getText();
        String apellido = tfApellido.getText();
        String identidad = tfIdentidad.getText();
        String edad = tfEdad.getText();
        String telefono = tfTelefono.getText();
        String email = tfEmail.getText();
        String institucion = tfInstitucion.getText();
        String grado = tfGrado.getText();
        String empresa = tfEmpresa.getText();
        String cargo = tfCargo.getText();
        String logros = tfLogros.getText();
        //Obtenemos las fechas
        LocalDate fecha1= fechaIni1.getValue();
        LocalDate fecha2= FechaFin1.getValue();
        LocalDate fecha3= FechaIni2.getValue();
        LocalDate fecha4= FechaFin2.getValue();
        
        //Se le da un formato correcto a la fecha
        if (rootto==null){
            rootto= "https://us.123rf.com/450wm/mialima/mialima1603/mialima160300025/55096766-hombre-icono-de-usuario-aislado-en-un-fondo-blanco-avatar-cuenta-para-la-web-foto-de-perfil-de-usuar.jpg";
        }
       
        
        //Escritura
        
        FileWriter fichero =null;
        PrintWriter escr = null;
        
        try{
            fichero = new FileWriter(""+nombre+" "+apellido+" curriculum.html");
            escr = new PrintWriter(fichero);
            
            escr.println("!DOCTTYPE html");
            escr.println("<html lang=\"en\">");
            escr.println("<head>");
            escr.println("<meta charset=\"UTF-8\">");
            escr.println("<title>"+nombre+"</title>");
            escr.println("<link rel=\"stylesheet\" href=\"styles.css\">");
            escr.println("<script src=\"https://kit.fontawesome.com/b99e675b6e.js\">"); //toma los iconos para el curriculum
            escr.println("</script>");
            escr.println("</head>");
            escr.println("<body>");
           
            escr.println("<div class=\"resume\">");
            escr.println("<div class=\"resume_left\">");
            escr.println("<div class=\"resume_profile\">");
            escr.println("<img src="+rootto+">"); ///imagen ruta colocar compañeros
            escr.println("</div>");
            escr.println("<div class=\"resume_content\">");
            escr.println("<div class=\"resume_item resume_info\">");
            escr.println("<div class=\"title\">");
            escr.println("<p class=\"bold\">"+nombre+"</p>");
            escr.println("<p class=\"bold\">"+apellido+"</p>");
            escr.println("</div>");
           escr.println("<ul>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-map-signs\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">");
              escr.println(" Tegucigalpa, <br /> HONDURAS");
             escr.println("</div>");
           escr.println("</li>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-solid fa-address-card\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+identidad);
             escr.println("</div>");
             escr.println("</li>");
             escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fa-solid fa-user-tie\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+edad+" años");
             escr.println("</div>");
             escr.println("</li>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-mobile-alt\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+telefono);
             escr.println("</div>");
             escr.println("</li>");
           escr.println("<li>");
             escr.println("<div class=\"icon\">");
               escr.println("<i class=\"fas fa-envelope\"></i>");
             escr.println("</div>");
             escr.println("<div class=\"data\">"+email);
             escr.println("</div>");
           escr.println("</li>");
         escr.println("</ul>");
       escr.println("</div>");
            escr.println("</div>");
            escr.println("</div>");
            escr.println("<div class=\"resume_right\">");
    escr.println("<div class=\"resume_item resume_about\">");
        escr.println("<div class=\"title\">");
        
        //agregar un componente que permita incluir una descripcion del perfil
        
           escr.println("<p class=\"bold\"> Perfil </p>");
         escr.println("</div>");
        escr.println("<p>DESCRIBCION: Lorem ipsum dolor sit, amet consectetur adipisicing elit. Perspiciatis illo fugit officiis "
                + "distinctio culpa officia totam atque exercitationem inventore repudiandae?</p>");
    escr.println("</div>");
    escr.println("<div class=\"resume_item resume_work\">");
        escr.println("<div class=\"title\">");
        
        //hacer que se permita colocar mas campos de experiencias y no solo una 
        
           escr.println("<p class=\"bold\"> EXPERIENCIA LABORAL </p>");
         escr.println("</div>");
        escr.println("<ul>");
            escr.println("<li>");
                escr.println("<div class=\"date\">" +fecha1+espacios+fecha2+"</div>"); 
                escr.println("<div class=\"info\">");
                     escr.println("<p class=\"semi-bold\">" +empresa+ "</p>"); 
                     escr.println("<p>"+cargo+"</p>");
                  escr.println("<p>"+logros+"</p>");
                escr.println("</div>");
            escr.println("</li>");
            escr.println("<li>");
              escr.println("<div class=\"date\">" +fecha1+espacios+fecha2+"</div>");
              escr.println("<div class=\"info\">");
                     escr.println("<p class=\"semi-bold\">" +empresa+"</p>"); 
                  escr.println("<p>"+cargo+"</p>");
                  escr.println("<p>"+logros+"</p>");
                escr.println("</div>");
                escr.println("</li>");
            escr.println("<li>");
              escr.println("<div class=\"date\">" +fecha1+espacios+fecha2+"</div>");
              escr.println("<div class=\"info\">");
                      escr.println("<p class=\"semi-bold\">" +empresa+"</p>"); 
                     escr.println("<p>"+cargo+"</p>");
                    escr.println("<p>"+logros+"</p>");
                escr.println("</div>");
            escr.println("</li>");
        escr.println("</ul>");
    escr.println("</div>");
    escr.println("<div class=\"resume_item resume_education\">");
      escr.println("<div class=\"title\">");
      
      //colocar un componente que permita colocar mas campos y no solo una
      
           escr.println("<p class=\"bold\"> ESTUDIOS REALIZADOS</p>");
         escr.println("</div>");
      escr.println("<ul>");
             escr.println("<li>");
                escr.println("<div class=\"date\">"+fecha3+"/"+fecha4+" </div>"); 
                escr.println("<div class=\"info\">");
                     escr.println("<p class=\"semi-bold\">"+institucion+"</p>"); 
                  escr.println("<p>"+grado+"</p>");
               escr.println("</div>");
            escr.println("</li>");
            escr.println("<li>");
              escr.println("<div class=\"date\">"+fecha3+"/"+fecha4+" </div>");
              escr.println("<div class=\"info\">");
                    escr.println("<p class=\"semi-bold\">"+institucion+"</p>"); 
                    escr.println("<p>"+grado+"</p>");
               escr.println("</div>");
            escr.println("</li>");
            escr.println("<li>");
              escr.println("<div class=\"date\">"+fecha3+"/"+fecha4+" </div>");
              escr.println("<div class=\"info\">");
              escr.println("<p class=\"semi-bold\">"+institucion+"</p>");  
                  escr.println("<p>"+grado+"</p>");
                escr.println("</div>");
            escr.println("</li>");
             escr.println("<li>");
              escr.println("<div class=\"date\">"+fecha3+"      "+fecha4+" </div>");
              escr.println("<div class=\"info\">");
                     escr.println("<p class=\"semi-bold\">"+institucion+"</p>"); 
                  escr.println("<p>"+grado+"</p>");
                escr.println("</div>");
            escr.println("</li>");
       escr.println("</ul>");
    escr.println("</div>");
    escr.println("<div class=\"resume_item resume_hobby\">");
      escr.println("<div class=\"title\">");
           escr.println("<p class=\"bold\"> PASATIEMPOS </p>");
         escr.println("</div>");
       escr.println("<ul>");
       //aqui podemos usar un componete que permita seleccionar entre estas 4 obsiones de pasatiempos 
         escr.println("<li><i class=\"fas fa-book\"></i></li>");
         escr.println("<li><i class=\"fas fa-gamepad\"></i></li>");
         escr.println("<li><i class=\"fas fa-music\"></i></li>");
         escr.println("<li><i class=\"fab fa-pagelines\"></i></li>");
      escr.println("</ul>");
    escr.println("</div>");
  escr.println("</div>");
escr.println("</div>");
         escr.println("</body>");
escr.println("</html>");     
              
            
        }catch (Exception e){
        }finally{
            try{
                if(null != fichero){
                    fichero.close();
                }
            }catch (Exception e){
            }
        }
        
        validar();
        if ( errores.size() > 0 ){
            String cadenaErrores = "";
            
            for (int i=0; i<errores.size(); i++){
                cadenaErrores += errores.get(i) + "\n";
            }
            
            Alert mensaje = new Alert(AlertType.ERROR); //ESTO LO QUE HACE ES MOSTRAR UN CUADRO DE DIALOGO PORQUE HAY ERRORES
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Se encontraron los siguientes errores");
            mensaje.setContentText(cadenaErrores);
            mensaje.show();
            return;
        }
        
        //VENTA PARA DECIR QUE SE GUARDÓ CORRECTAMENTE
        Alert mensajeG = new Alert(AlertType.CONFIRMATION);
        String Guardado = "Se guardó correctamente";
        mensajeG.setContentText("Se guardaron correctamente los datos");
        mensajeG.show();
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       errores = new ArrayList<String>();
    }    

    @FXML
    private void clear(ActionEvent event) {
        tfEdad.clear();
        tfIdentidad.clear();
        tfNombre.clear();
        tfApellido.clear();
        tfTelefono.clear();
        tfEmail.clear();
        tfInstitucion.clear();
        tfGrado.clear();
        tfEmpresa.clear();
        tfCargo.clear();
        tfLogros.clear();
        fechaIni1.setValue(null);
        FechaFin1.setValue(null);
        FechaIni2.setValue(null);
        FechaFin2.setValue(null);
        rootto=null;
        ivFile.setImage(null);
        
    }
    
    
    
    private void validar(){
        
        String patronName = "^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$";
        String patronEmail = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
        //String patronTel = "/(^$|^[3789][0-9]*)$/";
        
        errores.clear(); //HACE QUE EL ARREGLO ESTE VACÍO EN CADA LLAMADO
        if ( tfNombre.getText().isEmpty() ){
            errores.add("El campo nombre es obligatorio");
        }
        if ( tfApellido.getText().isEmpty() ){
            errores.add("El campo Apellido es obligatorio");
        }
        if ( tfTelefono.getText().isEmpty() ){
            errores.add("El campo telefono es obligatorio");
        }
        if ( tfEmail.getText().isEmpty() ){
            errores.add("El campo email es obligatorio");
        } else if(!Pattern.matches(patronEmail, tfEmail.getText())){
            errores.add("Por favor ingrese un correo electronico valido");
            }
        
        if ( tfInstitucion.getText().isEmpty() ){
            errores.add("El campo institución es obligatorio");
        }
        if ( tfGrado.getText().isEmpty() ){
            errores.add("El campo grado es obligatorio");
        }
        if ( tfEmpresa.getText().isEmpty() ){
            errores.add("El campo empresa es obligatorio");
        }
         if ( tfCargo.getText().isEmpty() ){
            errores.add("El campo Cargo es obligatorio");
        }
         if ( tfLogros.getText().isEmpty() ){
            errores.add("El campo logros es obligatorio");
        }
        
        
        if ( !Pattern.matches(patronName, tfNombre.getText())){
             errores.add("No se permiten numeros ni caracteres especiales en el nombre");
        }
        if(!Pattern.matches(patronName, tfApellido.getText())){
            errores.add("No se permiten numeros ni caracteres especiales en el apellido");
        }
        /*
        if(!Pattern.matches(patronTel, tfTelefono.getText())){
            errores.add("Telefono invalido");
        }
        */
        
        
        
        
        
    }

    @FXML
    private void exitnow(ActionEvent event) {
        Platform.exit();
    }
    

}
