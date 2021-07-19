package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Boolean isAllowed(Visitor visitor) {
        if(visitor.getAge() > 13 && visitor.getHeight() >= 145){
            return true;
        }
        return false;
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if(visitor.getHeight() > 200){
            return defaultPrice()*2;
        }
        return defaultPrice();
    }
}
