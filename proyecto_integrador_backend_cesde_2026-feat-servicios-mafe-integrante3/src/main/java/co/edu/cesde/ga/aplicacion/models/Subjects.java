package co.edu.cesde.ga.aplicacion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "Code")
        private String code;

        @Column(name = "Name")
        private String name;

        @Column(name = "Credits")
        private Integer credits;

        @ManyToOne
        @JoinColumn(name = "program_id", nullable = false)
        private Programs program;

        public Subjects() {}

        public Subjects(Long id, String code, String name, Integer credits, Programs program) {
                this.id = id;
                this.code = code;
                this.name = name;
                this.credits = credits;
                this.program = program;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
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

        public Programs getProgram() {
                return program;
        }

        public void setProgram(Programs program) {
                this.program = program;
        }
}