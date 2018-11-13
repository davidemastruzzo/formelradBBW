package ch.bbw.formelrad;

/**
 * Berechnet das Formelrad
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
    private double leistung;
    private double spannung;
    private double strom;
    private double widerstand;

    public Calculator(double leistung, double spannung, double strom, double widerstand) {
        super();
        this.leistung = leistung;
        this.spannung = spannung;
        this.strom = strom;
        this.widerstand = widerstand;
    }

    public double getLeistung() {
        return leistung;
    }

    public double getSpannung() {
        return spannung;
    }

    public double getStrom() {
        return strom;
    }

    public double getWiderstand() {
        return widerstand;
    }

    @Override
    public String toString() {
        return "Calculator [leistung=" + leistung +
                ", spannung=" + spannung +
                ", strom=" + strom +
                ", widerstand=" + widerstand + "]";
    }

    /*
    Leistung = p
    WidersStand = R
    Stromstärke = I
    Spannung = U
     */

    public void calculate() {

        if (spannung != 0 && strom != 0) {
            leistung = pFromUAndI(spannung, strom);
            widerstand = rFromUAndI(spannung, strom);
        }

        if (spannung != 0 && widerstand != 0) {
            leistung = pFromUAndR(spannung, widerstand);
            strom = iFromUAndR(spannung, widerstand);
        }

        if (widerstand != 0 && strom != 0) {
            leistung = pFromRAndI(widerstand, strom);
            spannung = uFromRAndI(widerstand, strom);
        }

        if (leistung != 0 && strom != 0) {
            spannung = uFromPAndI(leistung, strom);
            widerstand = rFromPAndI(leistung, strom);
        }

        if (leistung != 0 && widerstand != 0) {
            spannung = uFromPAndR(leistung, widerstand);
            strom = iFromPAndR(leistung, widerstand);
        }

        if (leistung != 0 && spannung != 0) {
            strom = iFromPAndU(leistung, spannung);
            widerstand = rFromUAndP(spannung, leistung);
        }


    }

    public double pFromUAndI(double u, double i) {
		System.out.println("Aufruf der pFromUAndI Methode");
        return u * i;
    }

    public double pFromUAndR(double u, double r) {
		System.out.println("Aufruf der pFromUAndR Methode");
        return Math.pow(u, 2) / r;
    }

    public double pFromRAndI(double r, double i) {
		System.out.println("Aufruf der pFromRAndI Methode");
        return r * Math.pow(i, 2);
    }

    public double uFromRAndI(double r, double i) {
		System.out.println("Aufruf der uFromRAndI Methode");
        return r * i;
    }

    public double uFromPAndI(double p, double i) {
		System.out.println("Aufruf der uFromPAndI Methode");
        return p / i;
    }

    public double uFromPAndR(double p, double r) {
		System.out.println("Aufruf der uFromPAndR Methode");
        return Math.sqrt(p * r);
    }
	
	// add rFromPAndI-method log
	public double iFromPAndR(double p, double r){
		System.out.println("Aufruf der iFromPAndR Methode");
		return Math.sqrt(p / r);
	}

	public double iFromPAndU(double p, double u){
		System.out.println("Aufruf der iFromPAndU Methode");
		return p / u;
	}

	public double iFromUAndR(double u, double r){
		System.out.println("Aufruf der iFromUAndR Methode");
		return u / r;
	}
		
	public double rFromUAndP(double u, double p){
		System.out.println("Aufruf der rFromUAndP Methode");
		return Math.pow(u,2) / p;
	}
		
	public double rFromPAndI(double p, double i){
		System.out.println("Aufruf der rFromPAndI Methode");
		return p / Math.pow(i,2);
	}
		
	public double rFromUAndI(double u, double i){
		return u / i;
	}
}
