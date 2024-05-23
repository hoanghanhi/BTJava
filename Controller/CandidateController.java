package Controller;

import DAO.CandidateDAO;
import DAO.ExprerienceDAO;
import DAO.FresherDAO;
import DAO.InternDAO;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CandidateController {
    public void addCandidate() {
        Scanner scanner = new Scanner(System.in);
        String opt = "c";
        List<Candidate> candidateList = new LinkedList<>();
        do {
            System.out.println("moi ban chon loai candidate");
            int type = Integer.parseInt(scanner.nextLine());
            switch (type) {
                case 0:
                    Candidate experience = new Experience();
                    experience.addData(experience);
                    candidateList.add(experience);
                    break;
                case 1:
                    Candidate fresher = new Fresher();
                    fresher.addData(fresher);
                    candidateList.add(fresher);
                    break;
                case 2:
                    Candidate intern = new Intern();
                    intern.addData(intern);
                    candidateList.add(intern);
            }
            System.out.println("continue?");
            opt = scanner.nextLine();
        } while (!opt.equals("q"));
        CandidateDAO candidateDAO = new CandidateDAO();
        candidateDAO.addCandidate(candidateList);
        System.out.println("num: " + Candidate.getCandidateCount());
        Candidate.setCandidateCount(0);
    }

}
