package repositories;

import models.Reimbursement;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{

    @Override
    public List<Reimbursement> getAllReimbursementGivenUser(Integer authId) {
        List<Reimbursement> reimbs = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from reimbursement where users_fk_auth = ? order by reimb_id;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, authId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimbs.add(new Reimbursement(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return reimbs;
    }

    @Override
    public List<Reimbursement> showAllReimbursement() {
        List<Reimbursement> reimbs = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "select * from reimbursement;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimbs.add(new Reimbursement(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return reimbs;
    }

    @Override
    public void approveReimbursement(Integer id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "update reimbursement set users_fk_reslvr = 3, reimb_resolved = current_timestamp, reimb_status_fk = 2 where reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void denyReimbursement(Integer id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "update reimbursement set users_fk_reslvr = 3, reimb_resolved = current_timestamp, reimb_status_fk = 3 where reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void createReimbursement(Reimbursement reimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "insert into reimbursement (reimb_amount, reimb_description, users_fk_auth, reimb_type_fk) values (?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimbursement.getAmount());
            ps.setString(2, reimbursement.getDescription());
            ps.setInt(3, reimbursement.getUsersAuthor());
            ps.setInt(4, reimbursement.getReimbType());

            ps.executeUpdate();


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void deleteReimbursement(Integer id) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "delete from reimbursement where reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
