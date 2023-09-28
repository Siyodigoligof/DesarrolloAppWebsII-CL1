package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Producto;



public interface IProductoService {
	
	public List<Producto> list();
	public Optional<Producto> search(String id);
	public int save(Producto p);
	public void delete(String id); 


}
