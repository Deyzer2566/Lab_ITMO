package moves;
import ru.ifmo.se.pokemon.*;
public class Facade extends PhysicalMove {
    public Facade(){
        super(Type.FIRE, 70, 100);
    }

    public double calcBaseDamage(Pokemon att, Pokemon def){
        Status attStatus = att.getCondition();
        if (attStatus.equals(Status.POISON) || attStatus.equals(Status.PARALYZE)){
                return 140.0d;
		}
		else if(attStatus.equals(Status.BURN)){
                return 70.0d;
		}
		else{
			return super.calcBaseDamage(att, def);
        }
    }

    public String describe(){
        return "применл facade";
    }
}