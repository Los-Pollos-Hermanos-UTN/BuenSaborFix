package com.example.buensaboruno.repositories.base;

import com.example.buensaboruno.domain.entities.base.ImagenBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface ImagenBaseRepository<E extends ImagenBase, ID extends UUID> extends JpaRepository<E, ID> {
}