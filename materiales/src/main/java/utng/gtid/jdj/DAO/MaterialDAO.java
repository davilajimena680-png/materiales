package utng.gtid.jdj.DAO;

import utng.gtid.jdj.Conexion.Conexion;
import utng.gtid.jdj.modelo.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class MaterialDAO {


    // ============================
    // INSERTAR MATERIAL
    // ============================

    public boolean insertar(Material material) {

        String sql = "INSERT INTO material "
                + "(nombre, categoria, marca, modelo, numero_serie, cantidad, ubicacion, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


        try {

            Connection con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);


            ps.setString(1, material.getNombre());
            ps.setString(2, material.getCategoria());
            ps.setString(3, material.getMarca());
            ps.setString(4, material.getModelo());
            ps.setString(5, material.getNumeroSerie());
            ps.setInt(6, material.getCantidad());
            ps.setString(7, material.getUbicacion());
            ps.setString(8, material.getEstado());


            ps.executeUpdate();

            return true;


        } catch (SQLException e) {

            System.out.println("Error al insertar material");
            e.printStackTrace();

            return false;
        }
    }



    // ============================
    // CONSULTAR TODOS
    // ============================

    public List<Material> consultarTodos() {


        List<Material> lista = new ArrayList<>();


        String sql = "SELECT * FROM material";


        try {


            Connection con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();



            while(rs.next()) {


                Material material = new Material();


                material.setIdMaterial(rs.getInt("id_material"));
                material.setNombre(rs.getString("nombre"));
                material.setCategoria(rs.getString("categoria"));
                material.setMarca(rs.getString("marca"));
                material.setModelo(rs.getString("modelo"));
                material.setNumeroSerie(rs.getString("numero_serie"));
                material.setCantidad(rs.getInt("cantidad"));
                material.setUbicacion(rs.getString("ubicacion"));
                material.setEstado(rs.getString("estado"));


                lista.add(material);

            }


        } catch(SQLException e) {

            System.out.println("Error al consultar materiales");
            e.printStackTrace();

        }


        return lista;

    }




    // ============================
    // ACTUALIZAR MATERIAL
    // ============================

    public boolean actualizar(Material material) {


        String sql = "UPDATE material SET "
                + "nombre=?, categoria=?, marca=?, modelo=?, numero_serie=?, "
                + "cantidad=?, ubicacion=?, estado=? "
                + "WHERE id_material=?";


        try {


            Connection con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);


            ps.setString(1, material.getNombre());
            ps.setString(2, material.getCategoria());
            ps.setString(3, material.getMarca());
            ps.setString(4, material.getModelo());
            ps.setString(5, material.getNumeroSerie());
            ps.setInt(6, material.getCantidad());
            ps.setString(7, material.getUbicacion());
            ps.setString(8, material.getEstado());

            ps.setInt(9, material.getIdMaterial());



            ps.executeUpdate();


            return true;


        } catch(SQLException e) {


            System.out.println("Error al actualizar material");
            e.printStackTrace();

            return false;

        }

    }





    // ============================
    // ELIMINAR MATERIAL
    // ============================

    public boolean eliminar(int idMaterial) {


        String sql = "DELETE FROM material WHERE id_material=?";


        try {


            Connection con = Conexion.getConexion();


            PreparedStatement ps = con.prepareStatement(sql);


            ps.setInt(1, idMaterial);


            ps.executeUpdate();


            return true;



        } catch(SQLException e) {


            System.out.println("Error al eliminar material");

            e.printStackTrace();


            return false;

        }

    }


}