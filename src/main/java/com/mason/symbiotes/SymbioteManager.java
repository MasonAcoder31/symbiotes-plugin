public class SymbioteManager {
    private int hunger;
    private List<String> abilities;
    private boolean isAttached;

    public SymbioteManager() {
        this.hunger = 100; // Max hunger level
        this.abilities = new ArrayList<>();
        this.isAttached = false;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        if (hunger < 0) {
            this.hunger = 0;
        } else if (hunger > 100) {
            this.hunger = 100;
        } else {
            this.hunger = hunger;
        }
    }

    public void addAbility(String ability) {
        abilities.add(ability);
    }

    public void removeAbility(String ability) {
        abilities.remove(ability);
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void attachSymbiote() {
        if (!isAttached) {
            isAttached = true;
            System.out.println("Symbiote attached!");
        } else {
            System.out.println("Symbiote is already attached.");
        }
    }

    public void detachSymbiote() {
        if (isAttached) {
            isAttached = false;
            System.out.println("Symbiote detached!");
        } else {
            System.out.println("No symbiote is attached.");
        }
    }

    public boolean isSymbioteAttached() {
        return isAttached;
    }
}