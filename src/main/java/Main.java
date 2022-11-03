import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
            System.out.println("Conexión establecida");

            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM ejemplo.departamentos";
            resultado = sentencia.executeQuery(sql);
            //mostrar todos los datos
            while (resultado.next()) {
                System.out.println(resultado.getInt("dept_no") + " " + resultado.getString("dnombre") + " " + resultado.getString("loc"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    resultado.close();
                    sentencia.close();
                    conexion.close();

                    System.out.println("Conexion cerrada.");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
}
