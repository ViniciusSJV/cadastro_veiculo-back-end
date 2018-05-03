package br.com.veiculo.validador;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import br.com.veiculo.service.Veiculo;

public final class Validator {
	
	public static boolean validar(Veiculo veiculo)
            throws GenericException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException  {

        Field[] declaredFields = veiculo.getClass().getDeclaredFields();
        
        for(Field field : declaredFields) {
            verificaCamposObrigatorios(veiculo, field);
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
		            throw new GenericException(veiculo.getClass().getName()+"."+field.getName(), "Campo obrigatorio");
		        }
		    }
		}
	}
}
