import javax.swing.JOptionPane;

public class CustomException2 {
    public static void main(String[] args) {
        int[] numerador = { 4, 5, 8, 10 };
        int[] demoninador = { 2, 4, 0, 2, 8 };
        
        for (int i = 0; i < demoninador.length; i++) {
            try {
                if (numerador[i] %2 != 0) throw new DivisaoNaoExataException("Divisão não exata!", numerador[i], demoninador[i]);
                int resultado = numerador[i] / demoninador[i];
                System.out.println(resultado);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Indice do array fora do limite!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            System.out.println("O programa continua...");
        }
    }
}

class DivisaoNaoExataException extends Exception {
    private int numerador;
    private int denominador;

    public DivisaoNaoExataException(String message, int numerador, int denominador) {
        super(message);
        this.numerador = numerador;
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return "DivisaoNaoExataException [numerador=" + numerador + ", denominador=" + denominador + "]";
    }
    
}