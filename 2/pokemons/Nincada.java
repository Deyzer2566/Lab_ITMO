package pokemons;
import ru.ifmo.se.pokemon.*;
import moves.*;
public class Nincada extends Pokemon{
	public Nincada(String name,int lvl){
		super(name,lvl);
		setType(Type.BUG,Type.GROUND);
		setStats(31.0,45.0,90.0,30.0,30.0,40.0);
		setMove(new Rest(),new XScissor(),new AerialAce());
	}
}