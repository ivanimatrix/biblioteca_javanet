package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.UsuarioDTO;

/**
 * Esta clase implementa la clase UsuarioDAO
 * es una implementacion con la tecnolog�a JDBC
 * podr�a haber otro tipo de implementaciones con tecnolog�as
 * como Hibernate, iBatis, SpringJDBC, etc.
 * @author Ubaldo
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection userConn;
	
	private final String SQL_INSERT = "INSERT INTO usuarios(rut_usuario, pass_usuario, nombres_usuario, apellidos_usuario) VALUES(?,?,?,?)";
	
	private final String SQL_SELECT = "SELECT id_usuario,rut_usuario,pass_usuario,nombres_usuario, apellidos_usuario FROM usuarios";
        
        private final String SQL_SELECT_BY_ID = "SELECT id_usuario,rut_usuario,pass_usuario,nombres_usuario, apellidos_usuario FROM usuarios where id_usuario = ? limit 1";
	
	/**
	 * Constructor vac�o
	 */
	public UsuarioDAOImpl(){
		
	}
	
	
	public UsuarioDAOImpl(Connection conn){
		this.userConn = conn;
	}
	
	/**
	 * El metodo insert recibe como argumento un objeto DTO
	 * el cual viene de otra capa, y se extraen sus valores
	 * para crear un nuevo registro
	 */
	@Override
	public int insert(UsuarioDTO usuario) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try{
			conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario.getRut_usuario());
			stmt.setString(2, usuario.getPass_usuario());
                        stmt.setString(3, usuario.getNombres_usuario());
                        stmt.setString(4, usuario.getApellidos_usuario());
			
			rows = stmt.executeUpdate();
			
		}catch(SQLException e){
                    rows = 0;
                }
		finally{
			Conexion.close(stmt);
			if(this.userConn == null){
                            Conexion.close(conn);
			}
		}
		
		return rows;
	}
	
	
	/**
	 * En este m�todo utilizamos el objeto UsuarioDTO
	 * para llenar una lista y regresarla
	 */
	@Override
	public List<UsuarioDTO> select() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UsuarioDTO usuarioDTO = null;
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		try{
                    conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
                    stmt = conn.prepareStatement(SQL_SELECT);
                    rs = stmt.executeQuery();
                    while(rs.next()){
                        usuarioDTO.setId_usuario(rs.getInt("id_usuario"));
                        usuarioDTO.setRut_usuario(rs.getString("rut_usuario"));
                        usuarioDTO.setPass_usuario(rs.getString("pass_usuario"));
                        usuarioDTO.setNombres_usuario(rs.getString("nombres_usuario"));
                        usuarioDTO.setApellidos_usuario(rs.getString("apellidos_usuario"));

                        usuarios.add(usuarioDTO);

                    }
		}
		finally{
			Conexion.close(rs);
			Conexion.close(stmt);
			if(this.userConn == null){
				Conexion.close(conn);
			}
		}
		
		return usuarios;
	}
        
        @Override
        public UsuarioDTO selectById(int id_usuario) throws SQLException{
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            UsuarioDTO usuarioDTO = null;
            
            try{
                conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
                stmt.setInt(1, id_usuario);
                rs = stmt.executeQuery();
                while(rs.next()){
                    usuarioDTO.setId_usuario(rs.getInt("id_usuario"));
                    usuarioDTO.setRut_usuario(rs.getString("rut_usuario"));
                    usuarioDTO.setPass_usuario(rs.getString("pass_usuario"));
                    usuarioDTO.setNombres_usuario(rs.getString("nombres_usuario"));
                    usuarioDTO.setApellidos_usuario(rs.getString("apellidos_usuario"));
                }
            }
            finally{
                Conexion.close(rs);
                Conexion.close(stmt);
                if(this.userConn == null){
                    Conexion.close(conn);
                }
            }

            return usuarioDTO;
        }

	

}
