import behaviours.IReviewed;
import attractions.*;
import people.Visitor;
import stalls.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ThemeParkTest {
    ThemePark themePark;
    @Before
    public void setUp(){
        ArrayList<IReviewed> stuff = new ArrayList<>();
        stuff.add(new RollerCoaster("Big Loop", 0));
        stuff.add(new TobaccoStall("Big SMoke", "Smokey Joe", ParkingSpot.A1, 10));
        themePark = new ThemePark(stuff);
    }

    @Test
    public void themeParkHasStuff(){
        assertEquals(2, themePark.getReviewed().size());
    }

    @Test
    public void visitCountIncrements(){
        Visitor v = new Visitor(18, 199, 100);
        Attraction attraction = new RollerCoaster("Wee Loop", 0);
        themePark.addAttractionOrStall(attraction);
        themePark.visit(v, attraction);
        assertEquals(1, v.getNumberVisited());
        assertEquals(1, attraction.getVisitCount());
    }

    @Test
    public void canGetReviewMap(){
        assertEquals(2, themePark.getReviews().size());

        Attraction attraction = new RollerCoaster("Wee Loop", 1);
        themePark.addAttractionOrStall(attraction);

        assertTrue(themePark.getReviews().containsKey("Wee Loop"));
    }

    @Test
    public void getAllowed(){
        Visitor weeGuy = new Visitor(17, 300, 200);
        assertEquals(1, themePark.getAllAllowedFor(weeGuy).size());
    }
}§