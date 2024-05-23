package DAO;

import Common.Connect;
import Model.Candidate;
import Model.Intern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InternDAO {
    public InternDAO() {
    }
    public void addData(Candidate candidate, Connection connection){
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

            String query2 = "insert into Intern(CandidateID, Majors, Semester, UniversityName) values(?,?,?,?)";
            PreparedStatement myStmt2 = connection.prepareStatement(query2);
            myStmt2.setInt(1,candidate.getCandidateID());
            myStmt2.setString(2,((Intern) candidate).getMajors());
            myStmt2.setInt(3,((Intern) candidate).getSemester());
            myStmt2.setString(4,((Intern) candidate).getUniversityName());
            myStmt2.addBatch();

            myStmt.executeBatch();
            myStmt2.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
