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
            spannung = uFromRandI(widerstand, strom);
        }

        if (leistung != 0 && strom != 0) {
            spannung = uFromPandI(leistung, strom);
            widerstand = rFromPAndI(leistung, strom);
        }

        if (leistung != 0 && widerstand != 0) {
            spannung = uFromPandR(leistung, widerstand);
            strom = iFromPAndR(leistung, widerstand);
        }

        if (leistung != 0 && spannung != 0) {
            strom = iFromPAndU(leistung, spannung);
            widerstand = rFromUAndP(spannung, leistung);
        }


    }

    public double pFromUAndI(double u, double i) {
        return u * i;
    }

    public double pFromUAndR(double u, double r) {
        return Math.pow(u, 2) / r;
    }

    public double pFromRAndI(double r, double i) {
        return r * Math.pow(i, 2);
    }

    public double uFromRandI(double r, double i) {
        return r * i;
    }

    public double uFromPandI(double p, double i) {
        return p / i;
    }

    public double uFromPandR(double p, double r) {
        return Math.sqrt(p * r);
    }

	public double iFromPandR(double p, double r){
		return Math.sqrt(p / r);
	}

	public double iFromPandU(double p, double u){
		return p / u;
	}

	public double iFromUandR(double u, double r){
		return u / r;
	}
}
