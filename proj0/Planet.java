public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = (p.xxPos - xxPos);
        double dy = (p.yyPos - yyPos);
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance;
    }

    public double calcForceExertedBy(Planet p){
        double G = 6.67e-11;
        double m1_m2 = (mass * p.mass);
        double r = calcDistance(p);
        double F = (G * m1_m2) / (r*r);
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double F = calcForceExertedBy(p);
        double dx = (p.xxPos - xxPos);
        double r = calcDistance(p);
        double F_x = F * dx / r;
        return F_x;
    }

    public double calcForceExertedByY(Planet p){
        double F = calcForceExertedBy(p);
        double dy = (p.yyPos - yyPos);
        double r = calcDistance(p);
        double F_y = F * dy / r;
        return F_y;
    }

    public double calcNetForceExertedByX(Planet[] ps){
        double F_Net_x = 0;
        for (int i=0; i < ps.length; i += 1){
            if (equals(ps[i])){
                continue;
            }
            F_Net_x += calcForceExertedByX(ps[i]);
        }
        return F_Net_x;
    }

    public double calcNetForceExertedByY(Planet[] ps){
        double F_Net_y = 0;
        for (int i=0; i < ps.length; i += 1){
            if (equals(ps[i])){
                continue;
            }
            F_Net_y += calcForceExertedByY(ps[i]);
        }
        return F_Net_y;
    }

    public void update(double dt, double fx, double fy){
        double a_net_x = fx / mass;
        double a_net_y = fy / mass;
        xxVel = xxVel + (dt * a_net_x);
        yyVel = yyVel + (dt * a_net_y);
        xxPos = xxPos + (dt * xxVel);
        yyPos = yyPos + (dt * yyVel);
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}