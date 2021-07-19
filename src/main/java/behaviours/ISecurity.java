package behaviours;
import people.Visitor;

public interface ISecurity {
    Boolean isAllowed(Visitor visitor);
}
