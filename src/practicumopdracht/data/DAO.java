package practicumopdracht.data;

import java.util.List;

public interface DAO<T>{
    List<T> getAll();
    boolean load();
    boolean save();
    void add(T Object);
    void remove(T Object);
}
