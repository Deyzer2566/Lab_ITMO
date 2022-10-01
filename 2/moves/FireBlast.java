package moves;
import ru.ifmo.se.pokemon.*;
public class FireBlast extends SpecialMove {
	
	public FireBlast(){
		super(Type.FIRE, 110, 85);
	}
	
	protected void applyOppEffects(Pokemon p) {
		p.addEffect(new Effect().chance(0.1).condition(Status.BURN));
	}
	
	protected String describe() {
		return "использовал Fire Blast";
	}
}