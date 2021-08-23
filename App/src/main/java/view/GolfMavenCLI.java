package view;

import golferData.GolferDAO;
import golferData.GolferJdbcDAO;
import golferModel.Golfer;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class GolfMavenCLI {

    public static void main(String[] args) {

        System.out.println("***** Golf Maven - Banner Placeholder *****");

        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/golf-maven");
        ds.setUsername("postgres");
        ds.setPassword("postgres1");

        GolferDAO dao = new GolferJdbcDAO(ds);
        List<Golfer> golfers = dao.getAllGolfers();
        System.out.println(golfers);
    }
}
