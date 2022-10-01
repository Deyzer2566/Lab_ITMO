package pokemons;
import ru.ifmo.se.pokemon.*;
import moves.*;
public class Wigglytuff extends Jigglypuff{
	public Wigglytuff(String name,int lvl){
		super(name,lvl);
		setStats(140.0,70.0,45.0,85.0,50.0,45.0);
		addMove(new DoubleEdge());
	}
}