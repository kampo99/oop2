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
        return true;
    }

    @Override
    public boolean save() {
        return false;
    }
}
