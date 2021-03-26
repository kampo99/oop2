package practicumopdracht.comparators;

import practicumopdracht.model.MerkModel;
import practicumopdracht.model.TelefooneigenaarModel;

import java.util.Comparator;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class MerkOprichtdatumComparator implements Comparator<MerkModel> {


    @Override
    public int compare(MerkModel o1, MerkModel o2) {
        return o1.getOprichtdatum().compareTo(o2.getOprichtdatum());
    }
}
