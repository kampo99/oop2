package practicumopdracht.data;

import practicumopdracht.model.MerkModel;

import java.time.LocalDate;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class FakeMerkModelDAO extends MerkModelDAO {

    @Override
    public boolean load() {
        merkModelList.add(new MerkModel("Apple", "241.2", LocalDate.of(1976,4,1)));
        merkModelList.add(new MerkModel("Samsung","50.4",LocalDate.of(1969,1,13)));
        return true;
    }

    @Override
    public boolean save() {
        return true;
    }


}
