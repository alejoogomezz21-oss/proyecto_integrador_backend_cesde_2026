package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Groups;

import java.util.List;

public interface GroupsRepository {

    Groups create (Groups groups);

    boolean delete(Long groupsId);

    boolean update(Groups groupsUpdate);

    Groups findById(Long groupsId);

    List<Groups> findAll();

    boolean existsById(Long groupsId);


}
