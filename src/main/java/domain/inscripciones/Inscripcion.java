package domain.inscripciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasInscripcion;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasInscripcion = new ArrayList<>();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void agregarMateriasInscripcion(Materia ... materiasInscripcion) {
        Collections.addAll(this.materiasInscripcion, materiasInscripcion);
    }

/*    private Boolean aprobada() {
        for(Materia materia : materiasInscripcion) {
            return alumno.aprobo(materia);
        }
    }*/

    public boolean aprobada() {
        return this.materiasInscripcion.stream().allMatch(materia -> alumno.cumpleCorrelativas(materia));
    }
}
