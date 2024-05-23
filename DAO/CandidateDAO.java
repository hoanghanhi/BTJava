package DAO;

import Common.Connect;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;

import java.sql.*;
import java.util.List;

public class CandidateDAO {

    public CandidateDAO() {

    }

    public void addCandidate(List<Candidate> candidateList) {
        Connection connection = Connect.getConnection();

        try {
            connection.setAutoCommit(false);

            for (Candidate candidate : candidateList) {
                if (candidate instanceof Experience) {
                    ExprerienceDAO exprerienceDAO = new ExprerienceDAO();
                    exprerienceDAO.addData(candidate, connection);
                }
                else if (candidate instanceof Fresher) {
                    FresherDAO fresherDAO = new FresherDAO();
                    fresherDAO.addData(candidate, connection);
                }
                else {
                    InternDAO internDAO = new InternDAO();
                    internDAO.addData(candidate, connection);
                }
            }
            connection.commit();
//            Candidate.setCandidateCount(candidateList.size());
            connection.setAutoCommit(true);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("loi");
        }
    }
}
