package pokemons;
import ru.ifmo.se.pokemon.*;
import moves.*;
public class Wishiwashi extends Pokemon{
	
	public Wishiwashi(){
		super();
		setType(Type.WATER);
		setStats(45.0,20.0,20.0,25.0,25.0,40.0);
		setMove(new IceBeam(),new DoubleTeam(),new Facade(),new FeintAttack());
	}
	
	public Wishiwashi(String name,int lvl){
		super(name,lvl);
		setType(Type.WATER);
		setStats(45.0,20.0,20.0,25.0,25.0,40.0);
		setMove(new IceBeam(),new DoubleTeam(),new Facade(),new FeintAttack());
	}
}