package practicumopdracht.comparators;

import practicumopdracht.model.MerkModel;

import java.util.Comparator;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class MerkNaamComparator implements Comparator<MerkModel> {

    @Override
    public int compare(MerkModel o1, MerkModel o2) {
        return o1.getMerkNaam().compareTo(o2.getMerkNaam());
    }
}
