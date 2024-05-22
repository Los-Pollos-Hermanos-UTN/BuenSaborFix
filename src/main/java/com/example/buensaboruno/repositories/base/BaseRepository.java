package com.example.buensaboruno.repositories.base;

import com.example.buensaboruno.domain.entities.base.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
    @Query("SELECT e FROM #{#entityName} e WHERE e.eliminado = false")
    List<E> findAllNotDeleted();

}
