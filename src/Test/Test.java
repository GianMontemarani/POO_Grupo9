package Test;
import java.util.List;
import java.util.Scanner;

import controladores.ProductoController;
import controladores.ProveedorController;
import dto.ProductoDto;
import dto.ProveedorDto;

public class Test {
	private static Scanner scanner = new Scanner(System.in);
	private static void mostrarMenu() {
	        System.out.println("------- Menú -------");
	        System.out.println("0 - Salir");
	        System.out.println("1 - Ingresar un proveedor");
	        System.out.println("2 - Listar proveedores");
	        System.out.println("3 - Ingresar un producto");
	        System.out.println("4 - Listar productos");
	        System.out.println("---------------------");
	        System.out.println("Selecciona una opción: ");
	 }
	
	private static void ingresarProducto(ProductoController productoController) {
        System.out.print("Ingrese el nombre del producto: ");
        String productoNombre = scanner.nextLine();
        
        System.out.print("Ingrese el precio: ");
        int productoPrecio = scanner.nextInt();
        
        System.out.print("Ingrese el % de iva del prodcuto: ");
        int productoIva = scanner.nextInt();
        
        System.out.print("Ingrese la unidad del producto: ");
        String productoUnidad = scanner.nextLine();
        
        ProductoDto nuevoProveedor = new ProductoDto(productoUnidad,productoPrecio,productoIva,productoNombre);
        productoController.addProducto(nuevoProveedor);
    }
	
	public static void main(String[] args) throws Exception {
			ProveedorController proveedorController = ProveedorController.getInstance();
			ProductoController productoController = ProductoController.getInstance();
			
			int opcion;
	        do {
	            mostrarMenu();
	            opcion = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcion) {
	                case 0:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                case 1:
	                   //Ingresar Proveedor
	                    break;
	                case 2:
	                	try {
	        				List<ProveedorDto> proveedores = proveedorController.getAll();
	        				for(ProveedorDto p: proveedores) {
	        					System.out.println(p.toString());
	        				}
	        			} catch (Exception e) {
	        				e.printStackTrace();
	        			}
	                    break;
	                case 3:
	                    ingresarProducto(productoController);
	                    break;
	                case 4:
	                	try {
	        				List<ProductoDto> productos = productoController.getAll();
	        				for(ProductoDto p: productos) {
	        					System.out.println(p.toString());
	        				}
	        			} catch (Exception e) {
	        				e.printStackTrace();
	        			}
	                    break;
	                default:
	                    System.out.println("Opción no válida. Introduce una opción del menú.");
	                    break;
	            }
	        } while (opcion != 0);		
	}
}
