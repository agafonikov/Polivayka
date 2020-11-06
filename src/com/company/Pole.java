package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pole {
    public final double x;
    public final double y;
    public final double deg;

    public List<Cvetok> cvetoks;

    public Pole(double x, double y, double deg){
        this.deg = deg;
        this.x = x;
        this.y = y;
        this.cvetoks = new ArrayList<>();
    }

    public void addCvetok(String name, double x, double y){
        cvetoks.add(new Cvetok(name, x - this.x, y - this.y));
    }

    public Double poschitat(){
        Map<Integer, Double> resultati = new HashMap<>();
        int max = cvetoks.size();
        int kolichestvo = 0;
        double gradusi = 0;
        for (Cvetok cvetok: cvetoks){
            int novoeKolichestvo = poschitatVZone(cvetok.deg, cvetok.deg + this.deg);
            double novieGradusi = (cvetok.deg*2 + this.deg)/2;
            if (novoeKolichestvo == max) return novieGradusi;
            if (kolichestvo < novoeKolichestvo){
                gradusi = novieGradusi;
                kolichestvo = novoeKolichestvo;
            }

            novoeKolichestvo = poschitatVZone(cvetok.deg, cvetok.deg - this.deg);
            novieGradusi = (-cvetok.deg - this.deg)/2;
            if (novoeKolichestvo == max) return novieGradusi;
            if (kolichestvo < novoeKolichestvo){
                gradusi = novieGradusi;
                kolichestvo = novoeKolichestvo;
            }
        }

        return gradusi;
    }

    public int poschitatVZone(double granicaOdin, double granicaDva){
        Set<String> cvetkiVGranicah = new HashSet<>();
        this.cvetoks.forEach(
                x -> {
                    if (x.deg <= granicaOdin & x.deg >= granicaDva)
                        cvetkiVGranicah.add(x.name);
                }
        );
        return cvetkiVGranicah.size();
    }
}
