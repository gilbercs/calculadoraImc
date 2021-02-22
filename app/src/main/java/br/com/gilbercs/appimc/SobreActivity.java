package br.com.gilbercs.appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SobreActivity extends AppCompatActivity {
    private TextView descricaApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        descricaApp = (TextView)findViewById(R.id.idDescricao);
        descricaApp.setText("Descrição Aplicativo:" +
                "\n\n"+"O aplicativo é uma calculadora de IMC" +
                "\n"+"onde você pode avaliar seu índice de massa" +
                "\n"+"corporal baseado na informação relevante," +
                "\n"+"como peso do corpo e altura do individuo." +
                "\n"+"App desenvolvido na linguagem de" +
                "\n"+"programação JAVA e IDE Android Studio Versão." +
                "\n\n"+"Nome App: Calculador IMC" +
                "\n"+"Modelo: Android" +
                "\n"+"Versão: 1.0"+
                "\n"+"Marca: Yaco Tecnologia" +
                "\n"+"Lincença: open source" +
                "\n"+"Desenvolvedor: Gilber" +
                "\n\n"+"Contato:" +
                "\n"+"e-mail: gilbercs@hotmail.com" +
                "\n"+"Site: gilbercs.com.br" +
                "\n"+"celular: (92) 99312-4740");
    }
}