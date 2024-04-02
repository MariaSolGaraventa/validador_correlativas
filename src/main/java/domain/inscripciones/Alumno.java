package domain.inscripciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public void agregarMateriasAprobadas(Materia ... materiasAprobadas) {
        Collections.addAll(this.materiasAprobadas, materiasAprobadas);
    }

    public Boolean cumpleCorrelativas(Materia unaMateria) {
        return unaMateria.correlativasAprobadas(this);
    }

    public boolean aprobo(Materia unaMateria) {
        return this.materiasAprobadas.contains(unaMateria);
    }
}
