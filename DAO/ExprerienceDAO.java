package DAO;

import Common.Connect;
import Model.Candidate;
import Model.Experience;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExprerienceDAO{
    public ExprerienceDAO() {
    }

    public void addData(Candidate candidate, Connection connection) {
            try {
                String query = "insert into Candidate(CandidateID, Fullname,Birthday, Phone, Email, CandidateType) values(?,?,?,?,?,?)";
                PreparedStatement myStmt = connection.prepareStatement(query);
                myStmt.setInt(1,candidate.getCandidateID());
                myStmt.setString(2,candidate.getFullName());
                myStmt.setString(3, candidate.getBirthDay());
                myStmt.setString(4, candidate.getPhone());
                myStmt.setString(5, candidate.getEmail());
                myStmt.setInt(6,candidate.getCandidateType());
                myStmt.addBatch();

                String query2 = "insert into Experience(CandidateID, ExpInYear, ProSkill) values(?,?,?)";
                PreparedStatement myStmt2 = connection.prepareStatement(query2);
                myStmt2.setInt(1,candidate.getCandidateID());
                myStmt2.setInt(2,((Experience) candidate).getExpInYear());
                myStmt2.setString(3, ((Experience) candidate).getProSkill());
                myStmt2.addBatch();

                myStmt.executeBatch();
                myStmt2.executeBatch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }


//    public void addExperience(int id, String fullname, String birthday, String phone, String email, int candidateType, int expInYear, String proSkill) {
//        Connection connection = Connect.getConnection();
//        try {
//            String query = "insert into Candidate(CandidateID, Fullname,Birthday, Phone, Email, CandidateType) values(?,?,?,?,?,?)";
//            PreparedStatement myStmt = connection.prepareStatement(query);
//            myStmt.setInt(1,id);
//            myStmt.setString(2,fullname);
//            myStmt.setString(3,birthday);
//            myStmt.setString(4,phone);
//            myStmt.setString(5,email);
//            myStmt.setInt(6,candidateType);
//
//            String query2 = "insert into Experience(CandidateID, ExpInYear, ProSkill) values(?,?,?)";
//            PreparedStatement myStmt2 = connection.prepareStatement(query2);
//            myStmt2.setInt(1,id);
//            myStmt2.setInt(2,expInYear);
//            myStmt2.setString(3,proSkill);
//
//            myStmt.executeUpdate();
//            myStmt2.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
