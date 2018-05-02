package br.com.veiculo.validador;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Calendar;

import br.com.veiculo.service.Veiculo;

public final class Validator {
	
	public static boolean validar(Veiculo veiculo)
            throws GenericException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException  {

        Field[] declaredFields = veiculo.getClass().getDeclaredFields();
        
        for(Field field : declaredFields) {
            verificaCamposObrigatorios(veiculo, field);
            verificaAno(veiculo, field);
            verificaPlaca(veiculo, field);
            
        }
        return true;
    }
	
	private static void verificaCamposObrigatorios(Veiculo veiculo, Field field)
			 throws GenericException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException   {
		
		Annotation annotation = field.getAnnotation(Obrigatorio.class);

		if (annotation != null) {

		    Obrigatorio obrigatorio = (Obrigatorio) annotation;

		    if (obrigatorio.value()) {
		        
		        field.setAccessible(true);
		       
		        if (field.get(veiculo) == null || field.get(veiculo) == "") {
		        	System.out.println(veiculo.getClass().getName() + "." + field.getName() + " Campo obrigatorio");
		            throw new GenericException(veiculo.getClass().getName()+"."+field.getName(), "Campo obrigatorio");
		        }
		    }
		}
	}

	private static void verificaAno(Veiculo veiculo, Field field)
			 throws GenericException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException  {

		Annotation annotation = field.getAnnotation(Ano.class);
		
		if(annotation != null) {
			
			Ano ano = (Ano) annotation;
			
			if (ano.value()) {
		        
		        field.setAccessible(true);
		    
		        int year = Calendar.getInstance().get(Calendar.YEAR);
		        
		        if((Integer)field.get(veiculo) > year || (Integer)field.get(veiculo) < 1990 ) {
		        	System.out.println(veiculo.getClass().getName() + "." + field.getName() + " Ano invalido");
		        	throw new GenericException(veiculo.getClass().getName()+"."+field.getName(), "Ano invalido");
		        }
			}
		       
		}
		
	}

	private static void verificaPlaca(Veiculo veiculo, Field field)
			 throws GenericException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException   {
		
		Annotation annotation = field.getAnnotation(Placa.class);
		
		if(annotation != null) {
			
			Placa placa = (Placa) annotation;
			
			if (placa.value()) {
		        
		        field.setAccessible(true);
		    
		        
			}
		       
		}
		
	}
}
