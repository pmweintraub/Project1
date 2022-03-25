package services;

import models.Reimbursement;
import repositories.ReimbursementDAO;
import repositories.ReimbursementDAOImpl;

import java.util.List;

public class ReimbursementService {

    private ReimbursementDAO reimbursementDAO;

    public ReimbursementService(){
        this.reimbursementDAO = new ReimbursementDAOImpl();
    }

    public ReimbursementService(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO = reimbursementDAO;
    }

    public List<Reimbursement> getAllReimbursementGivenUser(Integer authId){
        return this.reimbursementDAO.getAllReimbursementGivenUser(authId);
    }

    public List<Reimbursement> showAllReimbursement(){
        return this.reimbursementDAO.showAllReimbursement();
    }

    public void approveReimbursement(Integer id){
        this.reimbursementDAO.approveReimbursement(id);
    }

    public void denyReimbursement(Integer id){
        this.reimbursementDAO.denyReimbursement(id);
    }

    public void createReimbursement(Reimbursement reimbursement){
        this.reimbursementDAO.createReimbursement(reimbursement);
    }

    public void deleteReimbursement(Integer id){
        this.reimbursementDAO.deleteReimbursement(id);
    }

}
