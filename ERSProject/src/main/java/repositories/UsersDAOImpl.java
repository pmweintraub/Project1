package repositories;

import models.Users;
import util.ConnectionUtil;

import java.sql.*;

public class UsersDAOImpl implements UsersDAO{

    @Override
    public Users getUserGivenUsername(String username) {
        Users users = null;

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "select * from users where username  = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                users = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return users;
    }

    @Override
    public void createUser(Users users) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into users (username, password, first_name, last_name, email, user_roles_fk) values (?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

             ps.setString(1, users.getUsername());
             ps.setString(2, users.getPassword());
             ps.setString(3, users.getFirstname());
             ps.setString(4, users.getLastname());
             ps.setString(5, users.getEmail());
             ps.setInt(6, users.getUserRole());

             ps.executeUpdate();


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
