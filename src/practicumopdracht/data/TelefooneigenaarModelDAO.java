package practicumopdracht.data;

import practicumopdracht.model.TelefooneigenaarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public abstract class TelefooneigenaarModelDAO implements DAO<TelefooneigenaarModel>{

    protected ArrayList<TelefooneigenaarModel> telefooneigenaarlist;

    public TelefooneigenaarModelDAO(){
        this.telefooneigenaarlist = new ArrayList<>();

    }
    @Override
    public List<TelefooneigenaarModel> getAll() {
        return telefooneigenaarlist;
    }

    @Override
    public void add(TelefooneigenaarModel Object) {
        telefooneigenaarlist.add(Object);
    }

    @Override
    public void remove(TelefooneigenaarModel Object) {
        telefooneigenaarlist.remove(Object);
    }

    @Override
    public abstract boolean load();

    @Override
    public abstract boolean save();
}
