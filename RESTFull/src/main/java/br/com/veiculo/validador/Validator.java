package br.com.veiculo.validador;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import br.com.veiculo.service.Veiculo;

public class Validator {
	
	public static boolean validaCamposObrigatorios(Veiculo veiculo)
            throws CampoObrigatorioException, IllegalArgumentException, IllegalAccessException {

        Field[] declaredFields = veiculo.getClass().getDeclaredFields();
        
        for(Field field : declaredFields) {

            Annotation annotation = field.getAnnotation(Obrigatorio.class);

            if (annotation != null) {

                Obrigatorio obrigatorio = (Obrigatorio) annotation;

                if (obrigatorio.value()) {
                    
                    field.setAccessible(true);
                   
                    if (field.get(veiculo) == null || field.get(veiculo) == "") {
                        throw new CampoObrigatorioException(veiculo.getClass().getName()+"."+field.getName());
                    }
                }
            }
        }
        return true;
    }
}
