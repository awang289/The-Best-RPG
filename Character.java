//Andreas Wang
//Pd 8
//HW 25
//2013-11-15

public abstract class Character{
    protected int HP;
    protected int str;
    protected int def;
    protected double att;
    public boolean isAlive(){
	return (HP > 0);
    }
    public int getDefense(){
	return def;
    }
    public int lowerHP(int num) {
	HP -= num;
	return HP;
    }
    public int attack(Character m) {
	int damage = (int)(str * att) - m.getDefense();
	if (damage > 0) {
	    m.lowerHP(damage);
	    return damage;
	}
	else { return 0; }
    }
    public abstract void specialize();
    public abstract void normalize();
}
