package dao;

import conexao.Conexao;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public void salvar(Usuario usuario) throws SQLException {
        try {
        Connection conexao = new Conexao().getConnection();

            String sql = "INSERT INTO usuario (email,senha) values (?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Usuario> listar() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";
        PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));

            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Usuario buscar(Long id) throws SQLException {
        Usuario retorno = new Usuario();

        String sql = "SELECT * FROM usuario where id = " + retorno.getId();
        PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){

            retorno.setId(rs.getLong("id"));
            retorno.setEmail(rs.getString("email"));
            retorno.setSenha(rs.getString("senha"));
        }
        return retorno;
    }

    public void update (Usuario usuario){
        //String email = JOptionPane.showInputDialog("Informe o email que sera alterado");
        try {
            String sql = "update usuario set email =  ?,senha = ? where id = " + usuario.getId();

            PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete (Long id){

        try {
            String sql = "delete from usuario where id = "+ id;
            PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



