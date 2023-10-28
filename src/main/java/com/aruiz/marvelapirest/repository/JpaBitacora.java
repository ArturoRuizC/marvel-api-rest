package com.aruiz.marvelapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aruiz.marvelapirest.model.Bitacora;

public interface JpaBitacora extends BitacoraRpository, JpaRepository<Bitacora, Integer> {

}