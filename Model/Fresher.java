package Model;

import java.util.Date;
import java.util.Scanner;

public class Fresher extends Candidate{
    private int candidateID;
    private String graduateDate;
    private String graduateRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType, int candidateID1, String graduateDate, String graduateRank, String education) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.candidateID = candidateID1;
        this.graduateDate = graduateDate;
        this.graduateRank = graduateRank;
        this.education = education;
    }

    @Override
    public int getCandidateID() {
        return candidateID;
    }

    @Override
    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(String graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getGraduateRank() {
        return graduateRank;
    }

    public void setGraduateRank(String graduateRank) {
        this.graduateRank = graduateRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showMe() {
        super.showMe();
        System.out.println("Graduation date: " + graduateDate);
        System.out.println("Graduation rank : " + graduateRank);
        System.out.println("Education : " + education);
    }

    @Override
    public void addData(Candidate candidate) {
        super.addData(candidate);
        Scanner scanner = new Scanner(System.in);
        candidate.setCandidateType(1);
        Fresher fresher = (Fresher) candidate;
        System.out.println("Input graduate date : ");
        fresher.setGraduateDate(scanner.nextLine());
        System.out.println("Input graduate rank : ");
        fresher.setGraduateRank(scanner.nextLine());
        System.out.println("Input education : ");
        fresher.setEducation(scanner.nextLine());
    }
}
