
package Utilities;

/**
 *
 * @author root
 */

import java.sql.*;

public class Conexao {
    private static Connection conn;
    
    public static void conectar(String url, String usuario, String senha, String driver) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static void destroy() {
        try {
            conn = null;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int getAutoInc(String Generator) {
        int Codigo = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "Select Gen_ID("+Generator+",1) From RDB$Database");
            //pstmt.setString(1, Generator);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Codigo = rs.getInt(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Codigo;
    }
}
