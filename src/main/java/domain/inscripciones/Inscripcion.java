package domain.inscripciones;

import java.util.ArrayList;
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

    public List<Materia> getMateriasInscripcion() {
        return materiasInscripcion;
    }

    public void setMateriasInscripcion(List<Materia> materiasInscripcion) {
        this.materiasInscripcion = materiasInscripcion;
    }


/*    private Boolean aprobada() {
        for(Materia materia : materiasInscripcion) {
            return alumno.aprobo(materia);
        }
    }*/

    private Boolean inscripcionAprobada() {
        return this.materiasInscripcion.stream().allMatch(materia -> alumno.cumpleCorrelativas(materia));
    }
}
