public class SimulareEcosistem {
    public static void main(String[] args) {
        Ecosistem ecosistem = new Ecosistem(20);

        ecosistem.populeazaEcosistem(20, 10, 0, 5);

        // Simulăm mai mulți pași
        for (int i = 0; i < 10; i++) {
            System.out.println("\nPas " + (i + 1) + ":");
            ecosistem.simuleazaPas();
            ecosistem.afiseazaHarta();
            ecosistem.afiseazaStare();
        }
    }
}


