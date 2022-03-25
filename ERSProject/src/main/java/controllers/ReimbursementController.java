package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimbursement;
import services.ReimbursementService;

import java.util.List;

public class ReimbursementController {
    private ReimbursementService reimbursementService;

    public ReimbursementController(){
        this.reimbursementService = new ReimbursementService();
    }

    public ReimbursementController(ReimbursementService reimbursementService){
        this.reimbursementService = reimbursementService;
    }

    public void getAllReimbursementGivenUser(Context context){
        Integer userId = Integer.parseInt(context.pathParam("userId"));

        List<Reimbursement> reimbs = reimbursementService.getAllReimbursementGivenUser(userId);

        context.json(new JsonResponse(true, "All reimbursements for user " + userId, reimbs));
    }

    public void showAllReimbursement(Context context){
        List<Reimbursement> reimbs = reimbursementService.showAllReimbursement();

        context.json(new JsonResponse(true, "All reimbursements ", reimbs));
    }

    public void approveReimbursement(Context context){
        Integer id = Integer.parseInt(context.pathParam("id"));

        reimbursementService.approveReimbursement(id);

        context.json(new JsonResponse(true, "Approved reimbursement", null));
    }

    public void denyReimbursement(Context context){
        Integer id = Integer.parseInt(context.pathParam("id"));

        reimbursementService.denyReimbursement(id);

        context.json(new JsonResponse(true, "Denied reimbursement", null));
    }

    public void createReimbursement(Context context){
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);

        reimbursementService.createReimbursement(reimbursement);

        context.json(new JsonResponse(true, "reimbursement created for user " + reimbursement.getUsersAuthor(), null));
    }

    /*public void deleteReimbursement(Context context){
        Integer reimbId = Integer.parseInt(context.pathParam("reimbId"));

        reimbursementService.deleteReimbursement(reimbId);

        context.json(new JsonResponse(true, "Reimbursement ID:" + reimbId + "deleted", null));
    }*/

}
