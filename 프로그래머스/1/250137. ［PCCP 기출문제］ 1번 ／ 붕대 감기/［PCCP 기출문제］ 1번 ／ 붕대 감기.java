class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxBandage = bandage[0]; int heal = bandage[1]; int bonus = bandage[2];
        int hp = health;
        int delay = 0;
        int damage = 0;
        int lastAttackTime = 0;
        
        for (int[] attack : attacks) {
            damage = attack[1];
            delay = attack[0] - lastAttackTime - 1;
            
            if (delay > 0) {
                hp += (delay / maxBandage) * bonus;
                hp += (delay * heal);
            }
            
            if (hp > health) {
                hp = health;
            }
            
            hp -= damage;
            
            if (hp <= 0) {
                return -1;
            }
            
            lastAttackTime = attack[0];
        }
        return hp;
    }
}