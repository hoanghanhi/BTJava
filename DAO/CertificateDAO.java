package DAO;

import Common.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CertificateDAO {
    public CertificateDAO() {
    }

    public void addCertificate(int certificateID, int candidateID, String certificateName, String certificateRank, String certificateDate){
        try(Connection connection = Connect.getConnection();) {
            String query = "insert into Certificate_(CertificateID, CandidateID, CertificateName, CertificateRank, CertificateDate) values(?,?,?,?,?)";
            PreparedStatement myStmt = connection.prepareStatement(query);
            myStmt.setInt(1,certificateID);
            myStmt.setInt(2,candidateID);
            myStmt.setString(3,certificateName);
            myStmt.setString(4,certificateRank);
            myStmt.setString(5,certificateDate);

            myStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
