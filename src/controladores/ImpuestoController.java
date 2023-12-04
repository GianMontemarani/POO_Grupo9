package controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.ImpuestoDao;
import dto.ImpuestoDto;
import modelo.Impuesto;

public class ImpuestoController {
	private static ImpuestoController INSTANCE = null;
	
	private static List<Impuesto> impuestosList;
	
	private static ImpuestoDao impuestoDao;
	
	private ImpuestoController(List<Impuesto> impuestosList) {ImpuestoController.impuestosList = impuestosList;}
	
	public static synchronized ImpuestoController getInstance() throws Exception{
		if(INSTANCE == null) {
			impuestoDao = new ImpuestoDao(Impuesto.class,getPathOutModel(Impuesto.class.getSimpleName()));
			INSTANCE = new ImpuestoController(initModel());
		}
		return INSTANCE;
	}
	
	public List<ImpuestoDto> getAll(){
        List<ImpuestoDto> dtoList = new ArrayList<>();
        for (Impuesto impuesto : impuestosList) {
            dtoList.add(toDto(impuesto));
        }
        return dtoList;
    }
	
	public ImpuestoDto getById(int id){
        for (Impuesto impuesto: impuestosList) {
            if (impuesto.getId() == id){
                return toDto(impuesto);
            }
        }
        return  null;
    }
	
	public void addImpuesto(ImpuestoDto impuestoDto) {
		try {
			Impuesto impuestoNuevo = new Impuesto(impuestoDto, impuestosList.size()+1);
			impuestosList.add(impuestoNuevo);
			impuestoDao.save(impuestoNuevo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ImpuestoDto toDto(Impuesto impuesto){
        return new ImpuestoDto(impuesto);
    }
	
	private static String getPathOutModel(String name){
        String dir = "./datos/";
        return  new File(dir+name+".json").getPath();
    }
	
	private static List<Impuesto> initModel(){
        try {
        	impuestosList = impuestoDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return  impuestosList;
    }
}
