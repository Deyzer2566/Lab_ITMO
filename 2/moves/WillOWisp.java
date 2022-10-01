package moves;
import ru.ifmo.se.pokemon.*;
public class WillOWisp extends StatusMove{
	public WillOWisp(){
		super(Type.FIRE,0,85);
	}
	protected String describe(){
		return "ультанул WillOWisp";
	}
	protected void applyOppEffects(Pokemon p){
		Effect.burn(p);
	}
}