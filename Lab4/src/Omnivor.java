class Omnivor extends Animal {

    public Omnivor(String nume, int energie, int x, int y) {
        super(nume, energie, x, y, 0.9, 2, "Plante și Animale");
    }

    @Override
    public void mananca(EntitateEcosistem hrana) {
        if (hrana instanceof Planta || hrana instanceof Animal) {
            this.energie += hrana.energie / 2;
            hrana.energie = 0;
            System.out.println(nume + " a mâncat " + hrana.nume + " și a câștigat energie: " + energie);
        }
    }


    @Override
    public Omnivor reproduce() {
        return new Omnivor(nume + "_copil", 25, x + 1, y + 1);
    }

    @Override
    public void actioneaza() {

    }
}

