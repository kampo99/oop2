package practicumopdracht.comparators;

import practicumopdracht.model.TelefooneigenaarModel;

import java.util.Comparator;

/**
 * This method <description of functionality>
 *
 * @author Po
 */
public class TelefooneigenaarNaamComparator implements Comparator<TelefooneigenaarModel>{


    @Override
    public int compare(TelefooneigenaarModel o1, TelefooneigenaarModel o2) {
        if (o1.getNaam() == o2.getNaam()) {
            return o1.getAantalTelefoons()- (o2.getAantalTelefoons());
        }
        return o1.getNaam().compareTo(o2.getNaam());
//        if (o1.getAantalTelefoons() == o2.getAantalTelefoons()) {
//            return o1.getAankoopdatum().compareTo(o2.getAankoopdatum());
//        }
//        return o1.getAantalTelefoons() - o2.getAantalTelefoons();
    }

}
