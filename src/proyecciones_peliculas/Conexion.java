package proyecciones_peliculas;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Conexion {
    String nombreBd = "cine_db";
    String usuario = "root";
    String password = "contraseña";
    String timezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String url = "jdbc:mysql://localhost:3306/";
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    CallableStatement proalm = null;
    ResultSetMetaData rsmd = null;
    
    public void BorrarSala(int id){
        try {
            proalm = conn.prepareCall("{call BorrarSala(?)}");
            proalm.setInt(1,id);
            proalm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en BorrarSala");

        }
    }
    
    public void modificarSala(int id,String tipo){
        try {
            proalm = conn.prepareCall("{call modificarSala(?,?)}");
            proalm.setInt(1,id);
            proalm.setString(2,tipo);
            proalm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en modificarSala");

        }
    }
    
    public void borrarProyeccion(int id){
        try {
            proalm = conn.prepareCall("{call borrarProyeccion(?)}");
            proalm.setInt(1,id);
            proalm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrarProyeccion");

        }
    }
    
    public void borrarBoleto(int id){
        try {
            proalm = conn.prepareCall("{call borrarBoleto(?)}");
            proalm.setInt(1,id);
            proalm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrarBoleto");

        }
    }
    
    public void ConsultarProyeccion(DefaultTableModel model ){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("call consultarvista_proyeccion();");
            model.addColumn("id_proyeccion");
            model.addColumn("nombre");
            model.addColumn("num_sala");
            model.addColumn("tipo");
            model.addColumn("dia");
            model.addColumn("mes");
            model.addColumn("anio");
            model.addColumn("hora");
            model.addColumn("minutos");
            
            while(rs.next()){
                ArrayList<String> valores = new ArrayList();
                valores.add(String.valueOf(rs.getInt(1)));
                valores.add(rs.getString(2));
                valores.add(rs.getString(3));
                valores.add(rs.getString(4));
                valores.add(rs.getString(5));
                valores.add(rs.getString(6));
                valores.add(rs.getString(7));
                valores.add(rs.getString(8));
                valores.add(rs.getString(9));
                model.addRow(valores.toArray());
            }
            
        } catch (SQLException ex) {
            System.out.println("hubo un error en ConsultarProyeccion");
        }
    }
    
    public void consultarCuentaEmpleado(String columna,ArrayList <String> valores){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("call consultarCuentaEmpleado();");
            
            while(rs.next()){
                valores.add(rs.getString(columna));
            }
            
        } catch (SQLException ex) {
            System.out.println("hubo un error en consultarCuentaEmpleado");
        }
    }
    
    public void consultarvista_proyeccion(String columna,ArrayList <String> valores){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("call consultarvista_proyeccion();");
            
            while(rs.next()){
                valores.add(rs.getString(columna));
            }
            
        } catch (SQLException ex) {
            System.out.println("hubo un error en consultarvista_proyeccion");
        }
    }
    
    public void consultarvista_boleto(String columna,ArrayList <String> valores){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("call consultarvista_boleto();");
            
            while(rs.next()){
                valores.add(rs.getString(columna));
            }
            
        } catch (SQLException ex) {
            System.out.println("hubo un error en consultarvista_boleto");
        }
    }
    
    public void seleccionarProyeccionporPelicula(String nombre,ArrayList <String> valores){
        try {
            ps = conn.prepareStatement("call seleccionarProyeccionporPelicula(?)");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                valores.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("error seleccionarProyeccionporPelicula");
        }
    }
    
    public void seleccionarBoletoporUsuario(String nombre,ArrayList <String> valores){
        try {
            ps = conn.prepareStatement("call seleccionarBoletoporUsuario(?)");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                valores.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("error seleccionarBoletoporUsuario");
        }
    }
    
    public void seleccionarBoleto(int id_sala,String nombre,int hora,ArrayList <String> valores){
        try {
            ps = conn.prepareStatement("call seleccionarBoleto(?,?,?)");
            ps.setInt(1, id_sala);
            ps.setString(2, nombre);
            ps.setInt(3, hora);
            rs = ps.executeQuery();
            while(rs.next()){
                valores.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("error seleccionarBoleto");
        }
    }
    
    public void ConsultarTicket(int pk_usuario,String columna,ArrayList <String> valores){
        try {
            ps = conn.prepareStatement("call ConsultarTicket(?)");
            ps.setInt(1,pk_usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                valores.add(rs.getString(columna));
            }
        } catch (SQLException ex) {
            System.out.println("error ConsultarTicket xdxdxd");
        }
    }
    
    public void BuscarPorButaca(int proyeccion,ArrayList<Integer>fila,ArrayList<Integer>columna){
        try {
            ps = conn.prepareStatement("call BuscarPorButaca(?);");
            ps.setInt(1,proyeccion);
            rs = ps.executeQuery();
            while(rs.next()){
                fila.add(Integer.valueOf(rs.getInt(1)));
                columna.add(Integer.valueOf(rs.getInt(2)));
            }
            
        } catch (SQLException ex) {
            System.out.println("error buscar butaca xdxdxd");
        }
    }
    
    public int BuscarPorUsuario(String nombre){
        try {
            ps = conn.prepareStatement("call BuscarPorUsuario(?)");
            ps.setString(1,nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            System.out.println("error buscar sala xdxdxd");
        }
        return -1;
    }
    
    public void Insertar_boleto(String fila ,String columna,String tipo,String fecha_de_creacion,int fk_id_proyeccion,int fk_id_usuario){

        try {
            
            ps = conn.prepareStatement("call Insertar_boleto(?,?,?,?,?,?)");
            ps.setString(1,fila);
            ps.setString(2,columna);
            ps.setString(3,tipo);
            ps.setString(4,fecha_de_creacion);
            ps.setInt(5, fk_id_proyeccion);
            ps.setInt(6, fk_id_usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("hola");
            }
        } catch (SQLException ex) {
            System.out.println("error Insertar_boleto");
        }
    }
    
    
    public void ConsultarSalas(DefaultTableModel model ){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM sala;");
            model.addColumn("num_sala");
            model.addColumn("tipo");
            
            while(rs.next()){
                ArrayList<String> valores = new ArrayList();
                valores.add(String.valueOf(rs.getInt(1)));
                valores.add(rs.getString(2));
                model.addRow(valores.toArray());
            }
            
        } catch (SQLException ex) {
            System.out.println("hubo un error consulta num sala");
        }
    }
    
    
    public void eliminar(String valor){
        try {
            String query = "DELETE FROM sala WHERE num_sala = "+valor;
            st = conn.createStatement();
            st.executeUpdate(query);
                    
        } catch (SQLException ex) {
            System.out.println("hubo un problema al eliminar");
        }

    }
    
    public int seleccionarProyeccion(String nombre,String sala,String horario){
        int valor = -1;
        try {
            ps = conn.prepareStatement("call seleccionarProyeccion(?,?,?)");
            ps.setString(1,nombre);
            ps.setString(2,sala);
            ps.setString(3,horario);
            
            
            rs = ps.executeQuery();
            while(rs.next()){
                
                
                valor = rs.getInt("id_proyeccion");
                System.out.println("id : "+rs.getInt("id_proyeccion"));
            
            }
            
        } catch (SQLException ex) {
            System.out.println("error buscar sala xdxdxd");
        }
        return valor;
    }
    
    public void ConsultarSalasDeProyeccion(String nombre, String horario,JComboBox caja1){
        try {
            ps = conn.prepareStatement("call ConsultarSalasDeProyeccion(?,?)");
            ps.setString(1,nombre);
            ps.setString(2, horario);
            rs = ps.executeQuery();
            while(rs.next()){
                caja1.addItem(rs.getString("num_sala"));
            }
        } catch (SQLException ex) {
            System.out.println("hubo un erro en seleccionarProyeccion");
        }
    }
    
    public String ProyeccionTicket(int id_proyeccion,String columna){
        String aux = "";
        try {
            ps = conn.prepareStatement("call ProyeccionTicket(?)");
            ps.setInt(1, id_proyeccion);
            rs = ps.executeQuery();
            while(rs.next()){
               aux = rs.getString(columna);
            }
        } catch (SQLException ex) {
            System.out.println("error ultimo xdxdxd");
        }
        return aux;
    }
    
    public void ConsultarHorario(String nombre,String num_sala,JComboBox caja1){
        try {
            ps = conn.prepareStatement("call ConsultarHorario(?,?)");
            ps.setString(1,nombre);
            ps.setString(2,num_sala);
            rs = ps.executeQuery();
            while(rs.next()){
                caja1.addItem("hora: "+rs.getString("hora")+",minuto: "+rs.getString("minutos"));
            }
        } catch (SQLException ex) {
            System.out.println("hubo un error en consultahorario");
        }
    }
    
    public void ConsultarNumSala(String nombre,JComboBox caja1){
        try {
            ps = conn.prepareStatement("call ConsultarNumSala(?)");
            ps.setString(1,nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                caja1.addItem(rs.getString("num_sala"));
            }
        } catch (SQLException ex) {
            System.out.println("hubo un error consulta num sala");
        }
    }
    
    public void BuscarPorHorario(String nombre,String sala,JComboBox caja1){
        try {
            ps = conn.prepareStatement("call BuscarPorHorario(?,?)");
            ps.setString(1,nombre);
            ps.setString(2,sala);
            rs = ps.executeQuery();
            while(rs.next()){
                caja1.addItem("hora: "+rs.getString("hora")+":"+rs.getString("minutos"));
            }
        } catch (SQLException ex) {
            System.out.println("error buscar sala xdxdxd");
        }
    }
    
    public void BuscarPorSala(String nombre,ArrayList <String> valores){
        try {
            ps = conn.prepareStatement("call BuscarPorSala(?)");
            ps.setString(1,nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                valores.add(rs.getString("num_sala"));
            }
        } catch (SQLException ex) {
            System.out.println("error buscar sala xdxdxd");
        }
    }
    
    public void ConsultarDuracion(ArrayList <String> valores){
        try {
            String call = "{call ConsultarDuracion()}";
            proalm = conn.prepareCall(call);
            rs = proalm.executeQuery();
                while(rs.next()){
                    String salida = rs.getString("duracion_horas")+"horas,"+rs.getString("duracion_minutos")+" minutos, "+rs.getString("duracion_segundos")+" segundos";
                    valores.add(salida);
                    System.out.println(salida);
                }
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en  consulta procedimiento");

        }
    }
    
    public void BuscarPorSala(String nombre,JComboBox caja1){
        try {
            ps = conn.prepareStatement("call BuscarPorSala(?)");
            ps.setString(1,nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                caja1.addItem(rs.getString("num_sala"));
            }
        } catch (SQLException ex) {
            System.out.println("error buscar sala xdxdxd");
        }
    }
    
  
    
    public void ConsultarSalasDeProyeccion(String nombre,JComboBox caja1){
        try {
            ps = conn.prepareStatement("call ConsultarSalasDeProyeccion(?)");
            ps.setString(1,nombre);
            rs = ps.executeQuery();
            while(rs.next()){
                caja1.addItem(rs.getString("num_sala"));
            }
        } catch (SQLException ex) {
            System.out.println("error ultimo xdxdxd");
        }
        
    }
    
    public int verificar(String funcion,ArrayList <String> valores){
        try {
            String query = "SELECT "+funcion+"(";
            for(int i=0;i<valores.size();i++){
                if(i == valores.size()-1){
                    query += "?);";
                }else{
                    query += "?,";
                }
            }
            ps = conn.prepareStatement(query);
            for(int i=0;i<valores.size();i++){
                ps.setString(i+1,valores.get(i));
            }
            rs = ps.executeQuery();
            int valor = 0;
            while(rs.next()){
                valor = rs.getInt(1);
            }
            if(valor != 0){
              //JOptionPane.showMessageDialog(null, "ya existe un dato registrado con ese nombre");
              return 1;
            }else{
             JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectos");
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public void funcionInsertar(String funcion,ArrayList <String> valores){
        try {
            String query = "SELECT "+funcion+"(";
            for(int i=0;i<valores.size();i++){
                if(i == valores.size()-1){
                    query += "?);";
                }else{
                    query += "?,";
                }
            }
            ps = conn.prepareStatement(query);
            for(int i=0;i<valores.size();i++){
                ps.setString(i+1,valores.get(i));
            }
            rs = ps.executeQuery();
            int valor = 0;
            while(rs.next()){
                valor = rs.getInt(1);
            }
            if(valor == 0){
              JOptionPane.showMessageDialog(null, "ya existe un dato registrado con ese nombre");
            }else{
             JOptionPane.showMessageDialog(null, "se insertó correctamente");

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void callProcedimiento(String valor){
        try {
            proalm = conn.prepareCall("{call InsertarSalas(?)}");
            proalm.setString(1,valor);
            proalm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en procedimiento");

        }
    }
    
    public void Funcion(){
        
    }
    
    public void callProcedimientoGeneral(ArrayList<String> valores){
        try {
            String call = "{call CrearUsuario(";
            for(int i=0;i<valores.size();i++){
                if(i == valores.size()-1){
                    call += "?)}";
                }else{
                    call += "?,";
                }
            }
            proalm = conn.prepareCall(call);
            for(int i=0;i<valores.size();i++){
                proalm.setString(i+1,valores.get(i));
            }
            proalm.executeUpdate();
            JOptionPane.showMessageDialog(null, "insertar usuario correcto");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en procedimiento");

        }
    }
    
    public void callProcedimientoPelis(ArrayList <String> valores){
        try {
            
            proalm = conn.prepareCall("{call InsertarPeliculas(?,?,?,?,?,?,?,?,?)}");
            proalm.setString(1, valores.get(0));
            proalm.setInt(2 , parseInt(valores.get(1)));
            proalm.setString(3, valores.get(2));
            proalm.setString(4, valores.get(3));
            proalm.setString(5, valores.get(4));
            proalm.setInt(6, parseInt(valores.get(5)));
            proalm.setInt(7, parseInt(valores.get(6)));
            proalm.setInt(8, parseInt(valores.get(7)));
            proalm.setString(9, valores.get(8));
            proalm.executeUpdate();
       JOptionPane.showMessageDialog(null, "insertar pelis correcto");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en procedimiento");

        }
    }
    
    public void consultar(String tabla,String columna,ArrayList <String> valores){
        String consulta = "SELECT "+columna+" FROM "+tabla;
        try{
         st = conn.createStatement();
         rs = st.executeQuery(consulta);
         while(rs.next()){
             valores.add(rs.getString(1));
         }
        }catch(SQLException ex){
            System.out.println("hubo un error");
        }
    }
    
    public void consultarP(String procedimiento,String columna,ArrayList <String> valores){
        try {
            String call = "{call "+procedimiento+"()}";
            proalm = conn.prepareCall(call);
            rs = proalm.executeQuery();
                while(rs.next()){
                    valores.add(rs.getString(columna));
                    System.out.println(""+rs.getString(columna));
                }
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en  consulta procedimiento");

        }
    }
    
    public void consultar(String tabla,String columna,JComboBox caja1){
        String consulta = "SELECT "+columna+" FROM "+tabla;
        try{
         st = conn.createStatement();
         rs = st.executeQuery(consulta);
         while(rs.next()){
             caja1.addItem(rs.getString(1));
         }
        }catch(SQLException ex){
            System.out.println("hubo un error");
        }
    }
    
    public String consultar(){
        String salida = "";
        String consulta = "SELECT * FROM sala";
        try{
         st = conn.createStatement();
         rs = st.executeQuery(consulta);
         while(rs.next()){
             salida += rs.getString(1)+ "\t";
             salida += rs.getString(2)+ "\t\n";
         }
        }catch(Exception ex){
            System.out.println("hubo un error");
        }
        return salida;
    }

    public Conexion(String nombreBd) {   
        this.nombreBd =nombreBd;
    }
    
    public void Insercion(String query){
        try {
            st = conn.createStatement();
            //ps=conn.prepareStatement("INSERT INTO sala (tipo)VALUES (?);");
            //ps.setString(1,valor);
            st.executeUpdate(query);
      //JOptionPane.showMessageDialog(null,"Inserccion exitosa", "Info", JOptionPane.INFORMATION_MESSAGE+JOptionPane.YES_NO_OPTION, null);

        } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Hubo un error en la insercion", "Error", JOptionPane.ERROR_MESSAGE+JOptionPane.YES_NO_OPTION, null);

        }
    }
    
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url+nombreBd,usuario,password);
            System.out.println("se conecto a "+nombreBd);
        } catch (ClassNotFoundException ex) {
            System.out.println("error en clase");
        } catch (SQLException ex) {
            System.out.println("error en sql");
        }
        return conn;
    }
    
    public void InsertarP(String query){
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public void desconectar(){
        try {
            conn.close();
            System.out.println("Se desconecto correctamente");
        } catch (SQLException ex) {
            System.out.println("error en la desconexion");
        }
    } 
    
}
