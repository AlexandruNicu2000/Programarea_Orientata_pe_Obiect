class Planta extends EntitateEcosistem {

    public Planta(String nume, int energie, int x, int y) {
        super(nume, energie, x, y, 1.0);
    }

    @Override
    public void actioneaza() {
        creste();
    }

    public void creste() {
        this.energie += 5; // Plantele cresc în mod natural
        System.out.println(nume + " a crescut, energie: " + energie);
    }

    public Planta reproduce() {
        return new Planta(nume + "_copil", 10, x + 1, y + 1);
    }
}

