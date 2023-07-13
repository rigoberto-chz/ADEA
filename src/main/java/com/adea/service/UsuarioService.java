package com.adea.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adea.models.UsuarioModel;

@Service
public class UsuarioService {
	
	@Autowired
    DataSource dataSource;
	
	public UsuarioModel login(String login, String password) {
		
		UsuarioModel usuarioModel = null;
		
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where Login=? and Password=? and Status='A'")) {
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					usuarioModel = new UsuarioModel(
							resultSet.getString(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getFloat(4),
							resultSet.getString(5),
							resultSet.getDate(6),
							resultSet.getDate(7),
							resultSet.getString(8).charAt(0),
							resultSet.getFloat(9),
							resultSet.getDate(10),
							resultSet.getDate(11),
							resultSet.getInt(12),
							resultSet.getString(13),
							resultSet.getString(14),
							resultSet.getInt(15),
							resultSet.getDate(16));
					
					
			    }
				preparedStatement.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return usuarioModel;
	}
	
	public List<UsuarioModel> usuarios(String status){
		
		List<UsuarioModel> list = new ArrayList<UsuarioModel>();
		
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where Status=?")) {
			preparedStatement.setString(1, status);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					list.add(new UsuarioModel(
							resultSet.getString(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getFloat(4),
							resultSet.getString(5),
							resultSet.getDate(6),
							resultSet.getDate(7),
							resultSet.getString(8).charAt(0),
							resultSet.getFloat(9),
							resultSet.getDate(10),
							resultSet.getDate(11),
							resultSet.getInt(12),
							resultSet.getString(13),
							resultSet.getString(14),
							resultSet.getInt(15),
							resultSet.getDate(16)));
			    }
				preparedStatement.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public UsuarioModel getUsuario(String login) {
		
		UsuarioModel usuarioModel = null;
		
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where Login=?")) {
			preparedStatement.setString(1, login);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					usuarioModel = new UsuarioModel(
							resultSet.getString(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getFloat(4),
							resultSet.getString(5),
							resultSet.getDate(6),
							resultSet.getDate(7),
							resultSet.getString(8).charAt(0),
							resultSet.getFloat(9),
							resultSet.getDate(10),
							resultSet.getDate(11),
							resultSet.getInt(12),
							resultSet.getString(13),
							resultSet.getString(14),
							resultSet.getInt(15),
							resultSet.getDate(16));
					
					
			    }
				preparedStatement.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return usuarioModel;
	}
	
	public boolean saveUsuario(UsuarioModel usuarioModel) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("update usuario set Password=?,Nombre=?,Cliente=?,Email=?,FechaAlta=?,FechaBaja=?,Status=?,Intentos=?,FechaRevocado=?,FechaVigencia=?,NoAcceso=?,ApellidoPaterno=?,ApellidoMaterno=?,Area=?,FechaModificacion=? where Login=?")) {
			preparedStatement.setString(1, usuarioModel.getPassword());
			preparedStatement.setString(2, usuarioModel.getNombre());
			preparedStatement.setFloat(3, usuarioModel.getCliente());
			preparedStatement.setString(4, usuarioModel.getEmail());
			preparedStatement.setString(5, usuarioModel.getFechaAlta() != null ? dateFormat.format((Date) usuarioModel.getFechaAlta()): null);
			preparedStatement.setString(6, usuarioModel.getFechaBaja() != null ? dateFormat.format((Date) usuarioModel.getFechaBaja()): null);
			preparedStatement.setString(7, String.valueOf(usuarioModel.getStatus()));
			preparedStatement.setFloat(8, usuarioModel.getIntentos());
			preparedStatement.setString(9, usuarioModel.getFechaRevocado() != null ? dateFormat.format((Date) usuarioModel.getFechaRevocado()): null);
			preparedStatement.setString(10, usuarioModel.getFechaVigencia() != null ? dateFormat.format((Date) usuarioModel.getFechaVigencia()): null);
			preparedStatement.setInt(11, usuarioModel.getNoAcceso());
			preparedStatement.setString(12, usuarioModel.getApellidoPaterno());
			preparedStatement.setString(13, usuarioModel.getApellidoMaterno());
			preparedStatement.setInt(14, usuarioModel.getArea());
			preparedStatement.setString(15, dateFormat.format(Calendar.getInstance().getTime()));
			preparedStatement.setString(16, usuarioModel.getLogin());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean deleteUsuario(String login) {
		
		try (Connection connection = dataSource.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("delete from usuario where Login=?")) {
			preparedStatement.setString(1, login);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
		
}
