package src;

public class Data {
    int dia, mes;

    public Data(int dia, int mes){
        this.dia = dia;
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String toString() {
        return this.dia+"/"+this.mes;
    }

    public static boolean validaData(String data) {

        int dia, mes;
        String[] partes = data.split("/");

        if (partes.length == 2) {
            try {
                dia = Integer.parseInt(partes[0]);
                mes = Integer.parseInt(partes[1]);
            } catch (Exception e) {
                System.err.println("Formato inválido! Insira no formato DD/MM.");
                return false;
            }
        } else {
            System.err.println("Formato inválido! Use DD/MM.");
            return false;
        }

        if (dia < 1 || dia > 31) {
            System.err.println("Dia inválido!");
            return false; 
        }
    
        if (mes < 1 || mes > 12) {
            System.err.println("Mês inválido!");
            return false;
        }
    
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) {
                System.err.println("Dia inválido para o mês " + mes);
                return false;
            }
        } else if (mes == 2) {
            if (dia > 28) {
                System.err.println("Dia inválido para fevereiro");
                return false;
            }
        }

        return true;
    }
    
}
