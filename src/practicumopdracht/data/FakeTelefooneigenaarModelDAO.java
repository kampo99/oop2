package practicumopdracht.data;

import practicumopdracht.model.TelefooneigenaarModel;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class FakeTelefooneigenaarModelDAO extends TelefooneigenaarModelDAO{

    @Override
    public boolean load() {
//        telefooneigenaarlist.add(new TelefooneigenaarModel("Po","",""));
//        telefooneigenaarlist.add(new TelefooneigenaarModel());
        return true;
    }

    @Override
    public boolean save() {
        return false;
    }
}
