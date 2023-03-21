package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class Obrot implements Transformacja {
    private final double angle;

    public Obrot(double angle) {
        this.angle = angle;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        return new Punkt(p.getX() * Math.cos(angle) - p.getY() * Math.sin(angle),
                         p.getX() * Math.sin(angle) + p.getY() * Math.cos(angle));
    }

    @Override
    public Obrot getTransformacjaOdwrotna() {
        return new Obrot(-angle);
    }

    public double getAngle() {
        return this.angle;
    }

    @Override
    public String toString() {
        return "Obrót o kąt "+angle;
    }
}
