package co.edu.cesde.ga.aplicacion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Subjects {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_Materia")
        private Long subjectId;

        @Column(name = "Codigo_Materia")
        private String code;

        @Column(name = "Nombre_Materia")
        private String name;

        @Column(name = "Creditos")
        private Integer credits;

        @Column(name = "ID_Carrera")
        private Long programId;

        public Subjects() {}

        public Subjects(Long subjectId, String code, String name, Integer credits, Long programId) {
                this.subjectId = subjectId;
                this.code = code;
                this.name = name;
                this.credits = credits;
                this.programId = programId;
        }

        public Long getSubjectId() {
                return subjectId;
        }

        public void setSubjectId(Long subjectId) {
                this.subjectId = subjectId;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getCredits() {
                return credits;
        }

        public void setCredits(Integer credits) {
                this.credits = credits;
        }

        public Long getProgramId() {
                return programId;
        }

        public void setProgramId(Long programId) {
                this.programId = programId;
        }
}