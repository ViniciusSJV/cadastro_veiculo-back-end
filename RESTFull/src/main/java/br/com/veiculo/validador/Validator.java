package br.com.veiculo.validador;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import br.com.veiculo.service.Veiculo;

public final class Validator {
	
	public static boolean validar(Veiculo veiculo)
            throws GenericException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException  {
		
		//pega os campos da classe
        Field[] declaredFields = veiculo.getClass().getDeclaredFields();
        
        //verifica a notação "Obrigatorio" nos campos pra apricar a regra
        for(Field field : declaredFields) {
            verificaCamposObrigatorios(veiculo, field);
        }
        return true;
    }
	
	private static void verificaCamposObrigatorios(Veiculo veiculo, Field field)
			 throws GenericException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException   {
		
		//pega a notação "Ogrigatorio" do campo
		Annotation annotation = field.getAnnotation(Obrigatorio.class);
		
		//verifica se o campo possue a notação "Ogrigatorio"
		if (annotation != null) {

		    Obrigatorio obrigatorio = (Obrigatorio) annotation;
		    
		    //verifica se é obrigatorio
		    if (obrigatorio.value()) {
		        
		    	//metodo para poder acessar um campo Private senão teriamos um IllegalAccessException
		        field.setAccessible(true);
		       
		        //aprica a regra se ocampo for vazio ou nulo lança a GenericException
		        if (field.get(veiculo) == null || field.get(veiculo).toString().trim().isEmpty()) {
		            throw new GenericException(veiculo.getClass().getName()+"."+field.getName(), "Campo obrigatorio");
		        }
		    }
		}
	}
}
