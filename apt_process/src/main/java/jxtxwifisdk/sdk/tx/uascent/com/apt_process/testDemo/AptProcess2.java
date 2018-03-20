package jxtxwifisdk.sdk.tx.uascent.com.apt_process.testDemo;


import com.google.auto.service.AutoService;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

import jxtxwifisdk.sdk.tx.uascent.com.apt_lib.AutoCreateTest;

@AutoService(Processor.class)
public class AptProcess2 extends AbstractProcessor {
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(AutoCreateTest.class.getCanonicalName());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment
            roundEnv) {

        FieldSpec name = FieldSpec.builder(String.class, "name", Modifier.PRIVATE)
                .build();
        FieldSpec age = FieldSpec.builder(int.class, "age", Modifier.PRIVATE).build();

        MethodSpec methodConstructor = MethodSpec.methodBuilder("User")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(String.class, "name")
                .addParameter(int.class, "age")
                .addStatement("this.age = age")
                .addStatement("this.name = name")
                .build();

        MethodSpec methodGetName = MethodSpec.methodBuilder("getName")
                .addModifiers(Modifier.PUBLIC)
                .returns(String.class)
                .addStatement("return name")
                .build();

        MethodSpec methodSetName = MethodSpec.methodBuilder("setName")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(String.class, "name")
                .returns(void.class)
                .addStatement("this.name = name")
                .build();

        MethodSpec methodPrintName = MethodSpec.methodBuilder("printName")
                .addModifiers(Modifier.PUBLIC)
                .addStatement("$T.out.println(name)", System.class)
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("User")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(methodConstructor)
                .addMethod(methodGetName)
                .addMethod(methodSetName)
                .addMethod(methodPrintName)
                .addField(name)
                .addField(age)
                .build();

        JavaFile javaFile = JavaFile.builder("com.uascent.tx.sdk.jxtxwifisdk", helloWorld)
                .build();

        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
