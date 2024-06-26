package domain.inscripciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> materiasCorrelativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.materiasCorrelativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMateriasCorrelativas(Materia ... materiasCorrelativas) {
        Collections.addAll(this.materiasCorrelativas, materiasCorrelativas);
    }

    public Boolean correlativasAprobadas(Alumno alumno) {
        return this.materiasCorrelativas.stream().allMatch(alumno::aprobo); // materia -> alumno.aprobo(materia)
    }
}
