package services;

import models.Reimbursement;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import repositories.ReimbursementDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReimbursementServiceTest {
    private ReimbursementService reimbursementService;
    private ReimbursementDAO reimbursementDAO = Mockito.mock(ReimbursementDAO.class);

    public ReimbursementServiceTest() {
        reimbursementService = new ReimbursementService(reimbursementDAO);
    }

    @Test
    void showAllReimbursement() {
        List<Reimbursement> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Reimbursement(100, "description", 1, 1));
        expectedOutput.add(new Reimbursement(200, "description", 2, 2));
        Mockito.when(reimbursementDAO.showAllReimbursement()).thenReturn(expectedOutput);

        List<Reimbursement> actualOutput = reimbursementService.showAllReimbursement();

        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void getAllReimbursementGivenUser() {
        Integer authId = 1;
        List<Reimbursement> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Reimbursement(100, "description", authId, 1));
        expectedOutput.add(new Reimbursement(200, "description", authId, 2));
        Mockito.when(reimbursementDAO.getAllReimbursementGivenUser(authId)).thenReturn(expectedOutput);

        List<Reimbursement> actualOutput = reimbursementService.getAllReimbursementGivenUser(authId);

        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void approveReimbursement() {
        Integer reimbId = 2;

        reimbursementService.approveReimbursement(reimbId);

        Mockito.verify(reimbursementDAO, Mockito.times(1)).approveReimbursement(reimbId);
    }

    @Test
    void denyReimbursement() {
        Integer reimbId = 2;

        reimbursementService.denyReimbursement(reimbId);

        Mockito.verify(reimbursementDAO, Mockito.times(1)).denyReimbursement(reimbId);
    }

    @Test
    void deleteReimbursement() {
        Integer reimbId = 2;

        reimbursementService.deleteReimbursement(reimbId);

        Mockito.verify(reimbursementDAO, Mockito.times(1)).deleteReimbursement(reimbId);
    }
}
