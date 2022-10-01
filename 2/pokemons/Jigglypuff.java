package pokemons;
import ru.ifmo.se.pokemon.*;
import moves.*;
public class Jigglypuff extends Igglybuff{
	
	public Jigglypuff(){
		super();
		setStats(115.0,45.0,20.0,45.0,25.0,20.0);
		addMove(new Pound());
	}
	
	public Jigglypuff(String name,int lvl){
		super(name,lvl);
		setStats(115.0,45.0,20.0,45.0,25.0,20.0);
		addMove(new Pound());
	}
}