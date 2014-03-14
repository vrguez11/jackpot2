package jackpot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Jackpot {

    private int[] resultado = new int[3];
    private float saldo = 0;
    private float deposito = 1000;
    private final float VALOR_APUESTA = 0.50F;

    private final int CEREZA = 0;
    private final int CAMPANA = 1;
    private final int TREBOL = 2;
    private final int MONEDA = 3;
    private final int SIETE = 4;
        
    public float jugar() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            resultado[i] = random.nextInt(5);
        }
        saldo -= VALOR_APUESTA;
        float premio = getPremio();
        saldo += premio;
        return premio;
    }

    public ImageIcon getImagen(int indice) {
        try {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/" + resultado[indice] + ".png"));
            return imagen;
        } catch (NullPointerException ex) {
            Logger.getLogger(Jackpot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int getPremio() {
        if (resultado[0] == CEREZA && resultado[1] == CEREZA) {
            return 5;
        } else if (resultado[0] == CEREZA) {
            return 1;
        } else if (resultado[0] == CAMPANA && resultado[1] == CAMPANA && resultado[2] == CAMPANA) {
            return 10;
        } else if (resultado[0] == CAMPANA && resultado[1] == CAMPANA && resultado[2] == SIETE) {
            return 10;
        } else if (resultado[0] == TREBOL && resultado[1] == TREBOL && resultado[2] == TREBOL) {
            return 15;
        } else if (resultado[0] == TREBOL && resultado[1] == TREBOL && resultado[2] == SIETE) {
            return 15;        
        } else if (resultado[0] == MONEDA && resultado[1] == MONEDA && resultado[2] == MONEDA) {
            return 20;
        } else if (resultado[0] == MONEDA && resultado[1] == MONEDA && resultado[2] == SIETE) {
            return 20;
        } else if (resultado[0] == SIETE && resultado[1] == SIETE && resultado[2] == SIETE) {
            return 100;
        } else {
            return 0;
        }        
    }
    
    public void introducirMoneda(float valor) {
        this.saldo += valor;
        deposito += valor;
    }

    public float getSaldo() {        
        return saldo;
    }
    
    public float getDeposito() {
        return deposito;
    }
    
    public void cobrar() {
        deposito -= saldo;
        saldo = 0;
    }
    
    //Método que nos da la fecha y la hora actual
    public void getDate() {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = Calendar.getInstance().getTime();
        String fechaHora = dateformat.format(now);

        System.out.println("Fecha y hora de la jugada: " + fechaHora);
    }
            
}
