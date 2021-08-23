package golferData;

import golferModel.Golfer;

import java.util.List;

public interface GolferDAO {

    public List<Golfer> getAllGolfers();
    public Golfer getGolfer(int id);
    public void saveGolfer(Golfer golferToSave);

}
