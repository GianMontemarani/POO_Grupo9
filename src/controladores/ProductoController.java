package controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.ProductoDao;
import dto.ProductoDto;
import modelo.Producto;

public class ProductoController {
	private static ProductoController INSTANCE = null;
	
	private static List<Producto> productosList;
	
	private static ProductoDao productosDao;
	
	private ProductoController(List<Producto> productosList) {ProductoController.productosList = productosList;}
	
	public static synchronized ProductoController getInstance() throws Exception{
		if(INSTANCE == null) {
			productosDao = new ProductoDao(Producto.class,getPathOutModel(Producto.class.getSimpleName()));
			INSTANCE = new ProductoController(initModel());
		}
		return INSTANCE;
	}
	
	public List<ProductoDto> getAll(){
        List<ProductoDto> dtoList = new ArrayList<>();
        for (Producto Producto : productosList) {
            dtoList.add(toDto(Producto));
        }
        return dtoList;
    }
	
	public ProductoDto getProducto(int id) throws Exception {
        for (Producto Producto: productosList) {
            if (Producto.getId() == id){
                return toDto(Producto);
            }
        }
        return  null;
    }
	
	public void addProducto(ProductoDto productoDto) {
		try {
			Producto productoNuevo = new Producto(productoDto, productosList.size() + 1);
			productosList.add(productoNuevo);
			productosDao.save(productoNuevo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarById(int id) {
        try {
            for(Producto p: productosList) {
                if(p.getId() == id) {
                	productosList.remove(p);
                    productosDao.saveAll(productosList);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
	
	public static ProductoDto toDto(Producto producto){
        return new ProductoDto(producto);
    }
	
	private static String getPathOutModel(String name){
        String dir = "./datos/";
        return  new File(dir+name+".json").getPath();
    }
	
	private static List<Producto> initModel(){
		try {
        	productosList = productosDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return  productosList;
	}
}
