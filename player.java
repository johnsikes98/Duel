package ecen_424_project;

class weapon {

    double damage;
    double speed;
    String type;

    public String toString() {
        return "Type:," + type + ",Damage:," + damage + ",Speed:," + speed;
    }

    weapon(String type, double damage, double speed) {
        this.damage = damage;
        this.speed = speed;
        this.type = type;
    }

}

class defense {

    double hp;
    double speedModifier;
    String type;
    
    public String toString(){
        return "Type:," + type + ",Hitpoints:," + hp + ",Speed Modifier:," + speedModifier;
    }

    defense(String type, double hp, double speedModifier) {
        this.hp = hp;
        this.speedModifier = speedModifier;
        this.type = type;
    }
}

class perk {

    double damageModifier;
    double speedModifier;
    double hpModifier;
    String type;
    
    public String toString(){
        return "Type:," + type + ",Damage Multiplier:," + damageModifier + ",Speed Multiplier:," + speedModifier + ",Hitpoints Multiplier:," + hpModifier;
    }

    perk(String type, double damageModifier, double speedModifier, double hpModifier) {
        this.damageModifier = damageModifier;
        this.speedModifier = speedModifier;
        this.hpModifier = hpModifier;
        this.type = type;
    }
}

public class player {

    private String name;

    weapon weapon;
    defense defense;
    perk perk;

    public String getName() {
        return name;
    }
    
    public String toString(){
        
        
        return "\tWeapon: " + this.weapon.toString().replace(',', ' ') + "\n\tDefense: " + this.defense.toString().replace(',', ' ') + "\n\tPerk: " + this.perk.toString().replace(',', ' ');
    }

    player(String _name) {
        name = _name;
    }

}
