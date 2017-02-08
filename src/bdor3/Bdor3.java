package bdor3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import oracle.net.aso.n;

public class Bdor3 {

    public static Connection conn = null;

    public static void Conexion() throws SQLException {

        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain";
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
        conn = DriverManager.getConnection(url);

        if (conn != null) {

            JOptionPane.showMessageDialog(null, "Conexion Establecida");

        } else {

            JOptionPane.showMessageDialog(null, "Fallo de Conexion");

        }

    }
    
    
    public static void listar() throws SQLException{
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("Select * from empregado");
        
        while(rs.next()){
        
        java.sql.Struct x = (java.sql.Struct) rs.getObject(1);
                
        Object[] campos = x.getAttributes();
        
        String z = (String) campos[0];
        java.math.BigDecimal y = (java.math.BigDecimal) campos[1];
        
        int edade = rs.getInt(2);
       
            System.out.println(z+" ," + y + " ,"+edade);
        
        }
                
    
    
    
    
    }

    public static void main(String[] args) throws SQLException {
        Conexion();
        listar();
    }

}
