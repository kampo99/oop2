package practicumopdracht.data;

import practicumopdracht.model.TelefooneigenaarModel;

import java.io.*;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class ObjectTelefooneigenaarModelDAO extends TelefooneigenaarModelDAO{

    public ObjectTelefooneigenaarModelDAO(){

    }
    @Override
    public boolean save() {
        File objectfile = new File("telefooneigenaardetail.obj");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(objectfile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
                ) {

            objectOutputStream.writeInt(telefooneigenaarlist.size());

            for (TelefooneigenaarModel telefooneigenaarModel : telefooneigenaarlist) {
                objectOutputStream.writeObject(telefooneigenaarModel);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean load() {
        File objectfile = new File("telefooneigenaardetail.obj");
        telefooneigenaarlist.clear();
        try (
                FileInputStream fileInputStream = new FileInputStream(objectfile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ){

            int aantalStudenten = objectInputStream.readInt();

            for (int i = 0; i < aantalStudenten; i++) {
                TelefooneigenaarModel telefooneigenaarModel = (TelefooneigenaarModel) objectInputStream.readObject();
                telefooneigenaarlist.add(telefooneigenaarModel);
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }


}
