package br.com.system.vbankback.config;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.google.common.base.Optional;

import springfox.documentation.builders.ModelPropertyBuilder;
import springfox.documentation.service.AllowableRangeValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

/***
 * 
 * @author Julio
 *
 * Classe complementar para o SpringFox para auxiliar na geração das
 * informações dos campos na Documentação, assim reconhecer algumas
 * anotações da Entidade
 */

@Component
public class Jsr303ModelPropertyBuilderPlugin implements ModelPropertyBuilderPlugin{

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    @Override
    public void apply(ModelPropertyContext context) {
        ModelPropertyBuilder builder = context.getBuilder();

        // Para obter o getter da propriedade
        Optional<BeanPropertyDefinition> beanPropDef = context.getBeanPropertyDefinition();
        BeanPropertyDefinition beanDef = beanPropDef.get();
        AnnotatedMethod method = beanDef.getGetter();
        if (method == null) {
            return;
        }

        // Obter o essencial e não-essencial
        NotNull notNull = method.getAnnotation(NotNull.class);
        NotEmpty notEmpty = method.getAnnotation(NotEmpty.class);
        NotBlank notBlank =  method.getAnnotation(NotBlank.class);
        if (notNull != null || notEmpty != null || notBlank != null) {
            builder.required(true);
        }

        // Obter as limitacoes de alcance
        Range range = method.getAnnotation(Range.class);
        if (range != null) {
            builder.allowableValues(new AllowableRangeValues(
                    Long.toString(range.min()), Long.toString(range.max())));
        }
        Size size = method.getAnnotation(Size.class);
        if (size != null) {
            builder.allowableValues(new AllowableRangeValues(
                    Long.toString(size.min()), Long.toString(size.max())));
        }
    }	
}
