package domain;

import domain.inscripciones.Alumno;
import domain.inscripciones.Inscripcion;
import domain.inscripciones.Materia;
import org.junit.Assert;
import org.junit.Test;

public class Inscripcion_test {

    @Test
    public void inscripciones() {

        // Materias
        Materia algoritmosYEstruturasDeDatos = new Materia("Algoritmos y Estruturas de Datos");
        algoritmosYEstruturasDeDatos.agregarMateriasCorrelativas();

        Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programamación");
        paradigmasDeProgramacion.agregarMateriasCorrelativas(algoritmosYEstruturasDeDatos);

        Materia disenioDeSistemas = new Materia("Diseño de Sistemas");
        disenioDeSistemas.agregarMateriasCorrelativas(paradigmasDeProgramacion);

        Materia sistemasYOrganizaciones = new Materia("Sistemas y Organizaciones");
        sistemasYOrganizaciones.agregarMateriasCorrelativas();

        // Alumnos
        Alumno juan = new Alumno("Juan", "200.000-1");
        juan.agregarMateriasAprobadas(paradigmasDeProgramacion, algoritmosYEstruturasDeDatos, sistemasYOrganizaciones);

        Alumno pedro = new Alumno("Pedro", "199.999-3");
        juan.agregarMateriasAprobadas(algoritmosYEstruturasDeDatos);

        // Inscripciones
        Inscripcion inscripcionOk = new Inscripcion(juan);
        inscripcionOk.agregarMateriasInscripcion(disenioDeSistemas);

        Inscripcion inscripcionNotOk = new Inscripcion(pedro);
        inscripcionNotOk.agregarMateriasInscripcion(disenioDeSistemas);

        // Asserts
        Assert.assertTrue(inscripcionOk.aprobada());

        Assert.assertFalse(inscripcionNotOk.aprobada());
    }
}
