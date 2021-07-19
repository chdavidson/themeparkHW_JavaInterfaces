import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<IReviewed> attractionsAndStalls;

    public ThemePark(ArrayList<IReviewed> attractionsAndStalls) {
        this.attractionsAndStalls = attractionsAndStalls;
    }

    public void addAttractionOrStall(IReviewed newItem){
        this.attractionsAndStalls.add(newItem);
    }

    public ArrayList<IReviewed> getReviewed(){
        return attractionsAndStalls;
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.visitAttraction(attraction);
        attraction.incrementVisitCount();
    }

    public HashMap<String, Integer> getReviews(){
        HashMap<String, Integer> allWithReview = new HashMap<>();
        for(IReviewed i : attractionsAndStalls){
            allWithReview.put(i.getName(), i.getRating());
        }
        return allWithReview;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> listOfAllowed = new ArrayList<>();
        for (IReviewed i : attractionsAndStalls){
            if (i instanceof ISecurity){
                if (((ISecurity) i).isAllowed(visitor)){
                    listOfAllowed.add(i);
                }
            }
            else{
                listOfAllowed.add(i);
            }
        }
        return listOfAllowed;
    }
}
