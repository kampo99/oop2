package practicumopdracht.data;

import practicumopdracht.model.MerkModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public abstract class MerkModelDAO implements DAO<MerkModel>{
    protected List<MerkModel> merkModelList;

    public MerkModelDAO(){
        merkModelList = new ArrayList<>();
        load();
    }
    public List<MerkModel> getAll(){
        return merkModelList;
    }
    public int getIdFor(MerkModel merkModel){
        return merkModelList.indexOf(merkModel);
    }
    public MerkModel getById(int id){
        return merkModelList.get(id);
    }

    public void add(MerkModel object) {
        merkModelList.add(object);
    }

    @Override
    public void remove(MerkModel object) {
        merkModelList.remove(object);
    }
}
