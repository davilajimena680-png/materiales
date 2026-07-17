package utng.gtid.jdj.DAO;


import utng.gtid.jdj.Conexion.Conexion;
import utng.gtid.jdj.modelo.MaterialDañado;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;



public class MaterialDañadoDAO {



    // =====================================
    // INSERTAR MATERIAL DAÑADO
    // =====================================

    public boolean insertar(MaterialDañado materialDanado) {


        String sql = "INSERT INTO material_danado "
                + "(id_material, fecha_reporte, tipo_danio, descripcion, estado, observaciones)"
                + " VALUES (?, ?, ?, ?, ?, ?)";


        try {


            Connection con = Conexion.getConexion();


            PreparedStatement ps = con.prepareStatement(sql);



            ps.setInt(1, materialDanado.getIdMaterial());

            ps.setDate(2,
                    java.sql.Date.valueOf(materialDanado.getFechaReporte()));

            ps.setString(3, materialDanado.getTipoDanio());

            ps.setString(4, materialDanado.getDescripcion());

            ps.setString(5, materialDanado.getEstado());

            ps.setString(6, materialDanado.getObservaciones());



            ps.executeUpdate();


            return true;



        } catch(SQLException e){


            System.out.println("Error al insertar material dañado");

            e.printStackTrace();

            return false;

        }


    }





    // =====================================
    // CONSULTAR TODOS
    // =====================================


    public List<MaterialDañado> consultarTodos(){


        List<MaterialDañado> lista = new ArrayList<>();


        String sql = "SELECT * FROM material_danado";



        try {


            Connection con = Conexion.getConexion();


            PreparedStatement ps = con.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();



            while(rs.next()){


                MaterialDañado md = new MaterialDañado();



                md.setIdMaterialDanado(
                        rs.getInt("id_material_danado")
                );


                md.setIdMaterial(
                        rs.getInt("id_material")
                );



                md.setFechaReporte(
                        rs.getDate("fecha_reporte")
                        .toLocalDate()
                );



                md.setTipoDanio(
                        rs.getString("tipo_danio")
                );



                md.setDescripcion(
                        rs.getString("descripcion")
                );



                md.setEstado(
                        rs.getString("estado")
                );



                md.setObservaciones(
                        rs.getString("observaciones")
                );



                lista.add(md);


            }



        }catch(SQLException e){


            System.out.println("Error al consultar materiales dañados");

            e.printStackTrace();

        }


        return lista;


    }







    // =====================================
    // ACTUALIZAR
    // =====================================


    public boolean actualizar(MaterialDañado materialDanado){



        String sql = "UPDATE material_danado SET "
                + "id_material=?, "
                + "fecha_reporte=?, "
                + "tipo_danio=?, "
                + "descripcion=?, "
                + "estado=?, "
                + "observaciones=? "
                + "WHERE id_material_danado=?";



        try{


            Connection con = Conexion.getConexion();


            PreparedStatement ps = con.prepareStatement(sql);



            ps.setInt(1, materialDanado.getIdMaterial());

            ps.setDate(2,
                    java.sql.Date.valueOf(materialDanado.getFechaReporte()));

            ps.setString(3, materialDanado.getTipoDanio());

            ps.setString(4, materialDanado.getDescripcion());

            ps.setString(5, materialDanado.getEstado());

            ps.setString(6, materialDanado.getObservaciones());

            ps.setInt(7,
                    materialDanado.getIdMaterialDanado());



            ps.executeUpdate();


            return true;



        }catch(SQLException e){


            System.out.println("Error al actualizar material dañado");

            e.printStackTrace();


            return false;

        }


    }



    // =====================================
    // ELIMINAR
    // =====================================


    public boolean eliminar(int idMaterialDanado){



        String sql =
                "DELETE FROM material_danado "
                + "WHERE id_material_danado=?";



        try{


            Connection con = Conexion.getConexion();


            PreparedStatement ps =
                    con.prepareStatement(sql);



            ps.setInt(1, idMaterialDanado);



            ps.executeUpdate();



            return true;



        }catch(SQLException e){


            System.out.println("Error al eliminar material dañado");

            e.printStackTrace();


            return false;

        }


    }



}
