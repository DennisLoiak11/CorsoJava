package Venerdi4Luglio.EserciziTest;

public class GestioneConto {
    static class ContoBancario {
        private String numeroConto;
        private double saldo;
        private String titolare;

        public ContoBancario(String numeroConto, String titolare, double saldoIniziale) {
            this.numeroConto = numeroConto;
            this.titolare = titolare;
            this.saldo = saldoIniziale;
        }

        public String getNumeroConto() {
            return numeroConto;
        }

        public double getSaldo() {
            return saldo;
        }

        public String getTitolare() {
            return titolare;
        }

        // Metodo per depositare soldi sul conto
        public void deposita(double importo) {
            if (importo > 0) {
                saldo += importo; // aggiungo l'importo al saldo
            } else {
                System.out.println("Importo non valido per il deposito");
            }
        }

        // Metodo per prelevare soldi dal conto
        public void preleva(double importo) {
            if (importo > 0 && importo <= saldo) {
                saldo -= importo; // tolgo l'importo dal saldo
            } else {
                System.out.println("Importo non valido per il prelievo");
            }
        }
    }
    public static void main(String[] args) {
        ContoBancario conto = new ContoBancario("IT45X123456789000", "Mario Rossi", 1000.0);
        // Deposito 500 euro
        conto.deposita(500.0); // saldo ora è 1500
        // Prelevo 200 euro
        conto.preleva(200.0); // saldo ora è 1300
        System.out.println("Conto intestato a: " + conto.getTitolare());
        System.out.println("Numero conto: " + conto.getNumeroConto());
        System.out.println("Saldo finale: " + conto.getSaldo() + " euro");
    }
}

