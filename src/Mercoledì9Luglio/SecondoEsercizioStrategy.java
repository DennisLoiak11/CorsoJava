package Mercoledì9Luglio;

import java.util.Scanner;

interface MetodoPagamento {
    void paga(double importo);
}
class CartaDiCredito implements MetodoPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di €" + importo + " effettuato con Carta di Credito.");
    }
}

class PayPal implements MetodoPagamento {
    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di €" + importo + " effettuato con PayPal.");
    }
}

class PagamentoContext {
    private MetodoPagamento metodo;

    public void setMetodo(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public void eseguiPagamento(double importo) {
        if (metodo == null) {
            throw new IllegalStateException("Metodo di pagamento non impostato.");
        }
        metodo.paga(importo);
    }
}

public class SecondoEsercizioStrategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PagamentoContext context = new PagamentoContext();

        System.out.print("Inserisci l'importo da pagare: ");
        double importo = scanner.nextDouble();

        System.out.println("Scegli il metodo di pagamento:");
        System.out.println("1. Carta di Credito");
        System.out.println("2. PayPal");
        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
                context.setMetodo(new CartaDiCredito());
                break;
            case 2:
                context.setMetodo(new PayPal());
                break;
            default:
                System.out.println("Metodo non valido. Pagamento annullato.");
                return;
        }

        context.eseguiPagamento(importo);
    }
}
