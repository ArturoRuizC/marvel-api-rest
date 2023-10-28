package com.aruiz.marvelapirest.repository;

import java.util.List;
import com.aruiz.marvelapirest.model.Bitacora;

public interface BitacoraRpository {

	Bitacora save(Bitacora bitacora);

	List<Bitacora> findAll();
}