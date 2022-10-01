package moves;
import ru.ifmo.se.pokemon.*;
public class Rest extends StatusMove{
	public Rest(){
		type=Type.PSYCHIC;
	}
	protected void applySelfEffects(Pokemon p){
		p.addEffect(new Effect().turns(2).condition(Status.SLEEP));
		p.restore();
	}
	
	protected String describe() {
        return "чиллит";
    }
}