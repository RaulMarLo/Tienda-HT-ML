package generation.javongus.html.repository;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import generation.javongus.html.model.Producto;

public interface ProductoRespository extends JpaRepository<Producto, Long>{
	
//	Buscar producto por nombre: 
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	Optional<Producto> findByNombre(String nombre);
	
//	@Query("SELECT p FROM Producto p WHERE p.precio between ?start and ?end")
//	Optional<List<Producto>> findByPrecioBetween(Double start, Double end);
	
	@Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :start AND :end")
	List<Producto> findByPrecioBetween(@Param("start") Double start, @Param("end") Double end);
	
}
