package moves;
import ru.ifmo.se.pokemon.*;
public class FeintAttack extends PhysicalMove{
	public FeintAttack(){
		super(Type.DARK,60,Double.POSITIVE_INFINITY);
	}
	
	// protected void applyOppDamage(Pokemon def, double damage) {
        // def.setMod(Stat.HP, (int) Math.round(damage));
    // }
	
	protected String describe(){
		return "применил FeintAttack";
	}
}