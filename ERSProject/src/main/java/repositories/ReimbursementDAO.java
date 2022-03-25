package repositories;

import models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {
    List<Reimbursement> getAllReimbursementGivenUser(Integer authId);
    List<Reimbursement> showAllReimbursement();
    void approveReimbursement(Integer id);
    void denyReimbursement(Integer id);
    void createReimbursement(Reimbursement reimbursement);
    void deleteReimbursement(Integer id);
}
